package com.bluegreen.client;

import com.bluegreen.qualifier.SharedClientQualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SharedClientQualifier
@FeignClient(name = "shared", url = "http://localhost:8084/shared")
public interface SharedClient {
    @GetMapping("/get-updated")
    public String getUpdatedApp();

    @PostMapping("/set-updated/{app_name}")
    public String setUpdatedApp(String app_name);
}