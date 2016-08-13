package ru.ionov.temptracker.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ionov.temptracker.domain.Record;

public interface RecordsRepository extends CrudRepository<Record, Integer>
{
}
