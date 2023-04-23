package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Timestamp releaseDate;
  private Long minAllowedAge;
  private String typeOfMovie;
  @OneToMany(targetEntity = Role.class, mappedBy = "movie")
  private List<Role> casts;

  @Column(columnDefinition = "text not null")
  private String description;

}
