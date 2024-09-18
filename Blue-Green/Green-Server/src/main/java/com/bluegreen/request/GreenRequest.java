package com.bluegreen.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class GreenRequest {
    String name;

    public GreenRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
