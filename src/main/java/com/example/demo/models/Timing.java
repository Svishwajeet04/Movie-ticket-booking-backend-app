package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "timings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Timing {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "start_timing" ,columnDefinition = "timestamp not null")
  private Timestamp start;

  @Column(name = "end_timing" ,columnDefinition = "timestamp not null")
  private Timestamp end;
}
