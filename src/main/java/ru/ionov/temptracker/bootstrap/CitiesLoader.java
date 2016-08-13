package ru.ionov.temptracker.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.ionov.temptracker.domain.City;
import ru.ionov.temptracker.repositories.CitiesRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CitiesLoader implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    private CitiesRepository repository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        List<City> cities = new ArrayList<City>();
        cities.add(new City("Moscow"));
        cities.add(new City("Saint-Petersburg"));
        cities.add(new City("Samara"));
        cities.add(new City("Togliatti"));

        repository.save(cities);
    }
}
