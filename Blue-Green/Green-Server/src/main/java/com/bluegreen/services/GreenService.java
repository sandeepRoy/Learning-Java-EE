package com.bluegreen.services;

import com.bluegreen.entities.Green;
import com.bluegreen.repositories.GreenRepository;
import com.bluegreen.request.GreenRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreenService {
    @Autowired
    private GreenRepository greenRepository;

    public Green create(GreenRequest greenRequest) {
        Green green = new Green();
        green.setName(greenRequest.getName());
        Green save = greenRepository.save(green);
        return save;
    }

    public Green getById(Integer green_id) {
        return greenRepository.findById(green_id).orElseThrow(() -> new RuntimeException("Not Found!"));
    }

    public List<Green> getAll() {
        return greenRepository.findAll();
    }

    public long getRecordCount() {
        return greenRepository.findAll().stream().count();
    }
}
