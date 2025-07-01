package de.likeherotozero.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "emission_data")
public class EmissionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private int year;
    private double co2Value;

    public EmissionData() {}

    public EmissionData(String country, int year, double co2Value) {
        this.country = country;
        this.year = year;
        this.co2Value = co2Value;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getCo2Value() { return co2Value; }
    public void setCo2Value(double co2Value) { this.co2Value = co2Value; }
}
