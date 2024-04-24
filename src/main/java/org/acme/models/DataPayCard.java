package org.acme.models;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DataPayCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PayId;

    private BigDecimal amount;
    private String cardNumber;
    private String cardHolder;
    private String cardExpirationDate;
    private String cardCvv;
    private String cardType;
    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
    
    
    
}
