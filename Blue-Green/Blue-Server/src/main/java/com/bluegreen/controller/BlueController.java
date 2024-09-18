package com.bluegreen.controller;

import com.bluegreen.client.SharedClient;
import com.bluegreen.entities.Blue;
import com.bluegreen.requests.BlueRequest;
import com.bluegreen.services.BlueService;
import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.netflix.spectator.api.Statistic.count;

@RestController
@RequestMapping("/blue")
public class BlueController {

    @Autowired
    public SharedClient sharedClient;

    @Autowired
    public BlueService blueService;

    @GetMapping("/version")
    public String getVersion() {
        return "This is version Blue";
    }


    @PostMapping("/new")
    public ResponseEntity<Blue> create(@RequestBody BlueRequest blueRequest) {
        Blue blue = blueService.create(blueRequest);
        sharedClient.setUpdatedApp("blue");
        return new ResponseEntity<>(blue, HttpStatus.CREATED);
    }

    @GetMapping("/id")
    public ResponseEntity<Blue> getById(@PathParam("id") Integer id) {
        Blue byId = blueService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Blue>> getAll() {
        List<Blue> all = blueService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/record-count")
    public ResponseEntity<Long> getRecordCount() {
        long recordCount = blueService.getRecordCount();
        return new ResponseEntity<>(recordCount, HttpStatus.OK);
    }
}