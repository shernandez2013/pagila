package com.example.pagila.images;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImageEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "image")
    @Type(type="org.hibernate.type.BinaryType")
    private byte [] image;
    @Column(name = "description")
    private String description;
    @Column(name = "url")
    private String url;
}
