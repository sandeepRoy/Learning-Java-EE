package com.bluegreen.shared.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class LastUpdatedService {
    private static String lastUpdatedApp = "None";

    public static String getLastUpdatedApp() {
        return lastUpdatedApp;
    }

    public static void setLastUpdatedApp(String lastUpdatedApp) {
        LastUpdatedService.lastUpdatedApp = lastUpdatedApp;
    }
}
