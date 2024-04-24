package org.acme.dtos;

import org.acme.models.DataPayCard;


public interface DataPayCardMapper {
    
    DataPayCard toDataPayCard(DataPayCardDTO dataPayCardDTO);
}
