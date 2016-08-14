package ru.ionov.temptracker.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.ionov.temptracker.domain.City;
import ru.ionov.temptracker.domain.Record;
import ru.ionov.temptracker.repositories.CitiesRepository;
import ru.ionov.temptracker.repositories.RecordsRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/records")
public class RecordsController
{
    private static final String ERROR_KEY = "error";

    private static final String UNIQUE_ERROR_CODE = "unique";
    private static final String INTEGRITY_ERROR_CODE = "integrity";

    @Autowired
    private CitiesRepository citiesRepository;

    @Autowired
    private RecordsRepository recordsRepository;

    @Value("${spring.jackson.date-format}")
    private String dateFormat;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat(dateFormat), true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    @RequestMapping
    public Iterable<Record> getRecords(@RequestParam(value = "city", required = false) Integer cityId)
    {
        if (cityId == null)
        {
            return recordsRepository.findAll();
        }

        City city = citiesRepository.findOne(cityId);
        if (city != null)
        {
            return city.getRecords();
        }

        return new ArrayList<>();
    }

    @RequestMapping("/{id}")
    public Record getRecord(@PathVariable("id") int id)
    {
        return recordsRepository.findOne(id);
    }

    @RequestMapping(value = "/addOrUpdate", method = {RequestMethod.POST, RequestMethod.PUT})
    public Map<String, Object> addOrUpdateRecord(@RequestBody Record record)
    {
        Map<String, Object> result = new HashMap<>();

        try
        {
            recordsRepository.save(record);
        }
        catch (DataIntegrityViolationException e)
        {
            if (e.getCause() instanceof ConstraintViolationException)
            {
                result.put(ERROR_KEY, UNIQUE_ERROR_CODE);
            }
            else
            {
                result.put(ERROR_KEY, INTEGRITY_ERROR_CODE);
            }
        }

        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteRecord(@RequestParam("id") int id)
    {
        recordsRepository.delete(id);
    }
}
