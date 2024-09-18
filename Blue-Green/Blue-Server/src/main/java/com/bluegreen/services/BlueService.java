package com.bluegreen.services;

import com.bluegreen.entities.Blue;
import com.bluegreen.repositories.BlueRepository;
import com.bluegreen.requests.BlueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlueService {
    @Autowired
    public BlueRepository blueRepository;

    public Blue create(BlueRequest blueRequest) {
        Blue blue = new Blue();
        blue.setName(blueRequest.getName());
        Blue save = blueRepository.save(blue);
        return save;
    }

    public Blue getById(Integer green_id) {
        return blueRepository.findById(green_id).orElseThrow(() -> new RuntimeException("Not Found!"));
    }

    public List<Blue> getAll() {
        return blueRepository.findAll();
    }

    public long getRecordCount() {
        return blueRepository
                .findAll()
                .stream()
                .count();
    }
}

