package pe.edu.i202030258.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class countrylanguage {
    @EmbeddedId
    private countrylanguageId id;

    @Column(name = "IsOfficial")
    private boolean isOfficial;

    @Column(name = "Percentage")
    private double percentage;

    // Relación con country
    @ManyToOne
    @MapsId("countryCode")
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private country country;

    // Getters and Setters
    public countrylanguageId getId() { return id; }
    public void setId(countrylanguageId id) { this.id = id; }
    public boolean isOfficial() { return isOfficial; }
    public void setOfficial(boolean official) { isOfficial = official; }
    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }
    public country getCountry() { return country; }
    public void setCountry(country country) { this.country = country; }
}