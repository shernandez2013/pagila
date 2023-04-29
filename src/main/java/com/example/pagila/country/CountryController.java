package com.example.pagila.country;

import com.example.pagila.exceptions.SakilaException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
@RequestMapping("v1")
@ApiOperation("Sakila country API")
public class CountryController {
    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @ApiOperation(value = "Get all countries", notes = "Return all countries from sakila DB")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved", response = CountryResponse.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Not found - Countries are not found")
    })
    @GetMapping(value = "/countries")
    public List<CountryResponse> getCountries() throws SakilaException {
        return countryService.getCountries();
    }


    @ApiOperation(value = "Get country by id", notes = "Get a country by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved", response = CountryResponse.class),
            @ApiResponse(code = 400, message = "Not found - country was not found by id")
    })
    @GetMapping(value = "/countries/{id}")
    public CountryResponse getCountry(@PathVariable @ApiParam(name = "id", value = "id") Integer id) throws SakilaException {
        return countryService.getCountryById(id);
    }

    @ApiOperation(value = "Save country", notes = "Save country in sakila DB")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully saved"),
            @ApiResponse(code = 400, message = "Not saved - data not saved ")
    })
    @PostMapping(value = "/countries")
    public void saveCountry(@RequestBody @ApiParam(name = "request", value = "CountryRequest") CountryRequest request) throws SakilaException {
        countryService.saveCountry(request);
    }

    @ApiOperation(value = "Update country", notes = "Update country in sakila DB")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated"),
            @ApiResponse(code = 400, message = "Not updated - data not updates ")
    })
    @PutMapping(value = "/countries")
    public void updateCountry(@RequestBody @ApiParam(name = "request", value = "CountryRequest") CountryRequest request) throws SakilaException {
        countryService.updateCountry(request);
    }

    @ApiOperation(value = "Delete country by id", notes = "Delete country by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted"),
            @ApiResponse(code = 400, message = "Not found - country was not deleted by id")
    })
    @DeleteMapping(value = "/countries/{id}")
    public void deleteCountry(@PathVariable @ApiParam(name = "id", value = "Country id") Integer id) throws SakilaException {
        try {
            countryService.deleteCountry(id);
        } catch (EntityNotFoundException e) {
            logger.info("Country not found");
        }
    }
}
