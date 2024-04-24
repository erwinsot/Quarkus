package org.acme.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CardTransactionResponseDTO {

    private BigDecimal amount;
    private String cardNumber;
    private String cardType;

    
}
