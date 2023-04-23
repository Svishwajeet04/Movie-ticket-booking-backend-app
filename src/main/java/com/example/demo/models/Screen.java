package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "screens")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Screen {

  private String name;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

}
