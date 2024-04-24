package org.acme.service;

import java.util.Optional;

import org.acme.dtos.CardTransactionResponseDTO;
import org.acme.models.DataPayCard;
import org.acme.repositories.DataPayCardRespository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;


@ApplicationScoped
public class DataPayCardService {

    @Inject
    private DataPayCardRespository dataPayCardRespository;


    public Optional<DataPayCard> save(DataPayCard dataPayCard) {
        dataPayCardRespository.persist(dataPayCard);
        return Optional.of(dataPayCard);
    }

    public Optional<CardTransactionResponseDTO> findById(Long id) {
        DataPayCard dataPayCard= dataPayCardRespository.findById(id);
        if (dataPayCard == null) {
            return Optional.empty();            
        }
        CardTransactionResponseDTO cardTransactionResponseDTO = new CardTransactionResponseDTO();
        cardTransactionResponseDTO.setAmount(dataPayCard.getAmount());
        cardTransactionResponseDTO.setCardNumber(dataPayCard.getCardNumber());
        cardTransactionResponseDTO.setCardType(dataPayCard.getCardType());

        return Optional.of(cardTransactionResponseDTO);


    }

    public List<DataPayCard> findAll() {
        return dataPayCardRespository.listAll();
    }
    
}
