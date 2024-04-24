package org.acme.dtos;

import org.acme.models.DataPayCard;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class DataPayCardMapperImpl  implements DataPayCardMapper{

    @Override
    public DataPayCard toDataPayCard(DataPayCardDTO dataPayCardDTO) {
        if ( dataPayCardDTO == null ) {
            return null;
        }

        DataPayCard dataPayCard = new DataPayCard();

        dataPayCard.setAmount( dataPayCardDTO.getAmount() );
        dataPayCard.setCardNumber( dataPayCardDTO.getCardNumber() );
        dataPayCard.setCardHolder( dataPayCardDTO.getCardHolder() );
        dataPayCard.setCardExpirationDate( dataPayCardDTO.getCardExpirationDate() );
        dataPayCard.setCardCvv( dataPayCardDTO.getCardCvv() );
        dataPayCard.setCardType( dataPayCardDTO.getCardType() );

        return dataPayCard;
    }
        
        
}
