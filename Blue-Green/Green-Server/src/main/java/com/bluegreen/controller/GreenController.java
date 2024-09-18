package com.bluegreen.controller;

import com.bluegreen.client.SharedClient;
import com.bluegreen.entities.Green;
import com.bluegreen.services.GreenService;
import com.bluegreen.request.GreenRequest;
import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/green")
public class GreenController {

    @Autowired
    private GreenService greenService;

    @Autowired
    public SharedClient sharedClient;

    @GetMapping("/version")
    public String getVersion() {
        return "This is version Green";
    }

    @PostMapping("/new")
    public ResponseEntity<Green> create(@RequestBody GreenRequest greenRequest) {
        Green green = greenService.create(greenRequest);
        sharedClient.setUpdatedApp("green");
        return new ResponseEntity<>(green, HttpStatus.CREATED);
    }

    @GetMapping("/id")
    public ResponseEntity<Green> getById(@PathParam("id") Integer id) {
        Green byId = greenService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Green>> getAll() {
        List<Green> all = greenService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/record-count")
    public ResponseEntity<Long> getRecordCount() {
        long recordCount = greenService.getRecordCount();
        return new ResponseEntity<>(recordCount, HttpStatus.OK);
    }
}