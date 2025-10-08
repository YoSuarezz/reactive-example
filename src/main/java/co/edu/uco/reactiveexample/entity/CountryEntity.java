package co.edu.uco.reactiveexample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "country")
public final class CountryEntity {

    @Id
    private int id;

    @Column(value = "name")
    private String name;

    @Column(value = "country_code")
    private String country_code;

    @Column(value = "iso_country_code")
    private String iso_country_code;

    @Column(value = "enabled")
    private boolean enabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getIso_country_code() {
        return iso_country_code;
    }

    public void setIso_country_code(String iso_country_code) {
        this.iso_country_code = iso_country_code;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
