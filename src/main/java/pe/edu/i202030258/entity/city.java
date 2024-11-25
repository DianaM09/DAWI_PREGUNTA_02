package pe.edu.i202030258.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class city {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "District")
    private String district;

    @Column(name = "Population")
    private int population;

    // Relación con country
    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private country country;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }
    public country getCountry() { return country; }
    public void setCountry(country country) { this.country = country; }
}