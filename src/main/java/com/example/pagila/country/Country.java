package com.example.pagila.country;

import com.example.pagila.city.City;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;
    @Column
    private String country;
    @Column
    private LocalDateTime lastUpdate;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<City> cities;
}