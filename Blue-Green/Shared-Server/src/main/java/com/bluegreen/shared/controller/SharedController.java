package com.bluegreen.shared.controller;

import com.bluegreen.shared.service.LastUpdatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shared")
public class SharedController {
    @Autowired
    public LastUpdatedService lastUpdatedService;

    @GetMapping("/get-updated")
    public String getUpdatedApp() {
        return LastUpdatedService.getLastUpdatedApp();
    }

    @PostMapping("/set-updated/{app_name}")
    public String setUpdatedApp(@PathVariable String app_name) {
        LastUpdatedService.setLastUpdatedApp(app_name);
        return "Updated";
    }
}
