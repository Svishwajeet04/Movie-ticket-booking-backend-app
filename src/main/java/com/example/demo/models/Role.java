package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(targetEntity = Actor.class)
  private List<Actor> actor;

  @ManyToOne(targetEntity = Movie.class)
  private Movie movie;
}
