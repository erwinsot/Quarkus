package org.acme.camelConfigurations;

import java.math.BigDecimal;

import org.acme.dtos.DataPayCardDTO;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;





public class CardProcessor implements Processor{

    Logger logger = LoggerFactory.getLogger(CardProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        String jsonInput = exchange.getIn().getBody(String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        DataPayCardDTO dataPayCardDTO = objectMapper.readValue(jsonInput, DataPayCardDTO.class);
        dataPayCardDTO.setAmount(dataPayCardDTO.getAmount().multiply(new BigDecimal(0.9)));
        dataPayCardDTO.setCardType("VISA");
        logger.info("DataPayCardDTO: {}", dataPayCardDTO);
        logger.info("jsonInput: {}", jsonInput);
        String updatedJson = objectMapper.writeValueAsString(dataPayCardDTO);
        exchange.getMessage().setBody(updatedJson);
        
    }
    
}
