package com.microservice.expenses.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "expenses")
@AllArgsConstructor
@NoArgsConstructor
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "amount")
    private double amount;
    @Column(name = "categoryId")
    private Long categoryId;
    @Column(name = "date")
    private String date;


}

