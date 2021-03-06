package ru.ionov.temptracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class City
{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Record> records;

    public City()
    {
    }

    public City(String name)
    {
        this.name = name;
    }

    public City(String name, List<Record> records)
    {
        this.name = name;
        this.records = records;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Record> getRecords()
    {
        return records;
    }

    public void setRecords(List<Record> records)
    {
        this.records = records;
    }
}
