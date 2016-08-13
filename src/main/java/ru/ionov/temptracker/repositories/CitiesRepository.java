package ru.ionov.temptracker.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ionov.temptracker.domain.City;

public interface CitiesRepository extends CrudRepository<City, Integer>
{
}
