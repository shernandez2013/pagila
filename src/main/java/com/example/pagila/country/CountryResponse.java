package com.example.pagila.country;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CountryResponse {

    @ApiModelProperty(name = "Country id", notes = "This is the id for each country")
    private Integer countryId;
    @ApiModelProperty(name = "country", notes = "Name of each country")
    private String country;
    @ApiModelProperty(name = "lastUpdate", notes = "This value show us lastUpdate for each record")
    private LocalDateTime lastUpdate;

    public CountryResponse(Country country) {
        this.countryId = country.getCountryId();
        this.country = country.getCountry();
        this.lastUpdate = country.getLastUpdate();
    }
}

