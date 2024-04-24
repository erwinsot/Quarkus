package org.acme.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataPayCardDTO {
    private BigDecimal amount;
    private String cardNumber;
    private String cardHolder;
    private String cardExpirationDate;
    private String cardCvv;
    private String cardType;    
    
}
