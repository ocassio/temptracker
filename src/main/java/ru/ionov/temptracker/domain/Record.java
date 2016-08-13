package ru.ionov.temptracker.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"city_id", "date"})
)
@Entity
public class Record
{
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date date;

    @Column(nullable = false)
    private int temperature;

    public Record()
    {
    }

    public Record(City city, Date date, int temperature)
    {
        this.city = city;
        this.date = date;
        this.temperature = temperature;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public City getCity()
    {
        return city;
    }

    public void setCity(City city)
    {
        this.city = city;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }
}
