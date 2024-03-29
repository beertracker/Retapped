package com.retapped.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retapped.domain.Beer;
import com.retapped.repository.RetappedRepository;

@Service
public class RetappedService {
    
    @Autowired
    private RetappedRepository repo;

    

    public List<Beer> grabABeer() {
        ArrayList<Integer> beerIds = new ArrayList<>();
        beerIds.add(1);
        return repo.findAllById(beerIds);
    }
}
