package ru.ionov.temptracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ionov.temptracker.bootstrap.CitiesLoader;
import ru.ionov.temptracker.domain.City;
import ru.ionov.temptracker.repositories.CitiesRepository;

@RestController
@RequestMapping("/cities")
public class CitiesController
{
    @Autowired
    private CitiesRepository citiesRepository;

    @RequestMapping
    public Iterable<City> getCities()
    {
        return citiesRepository.findAll();
    }
}
