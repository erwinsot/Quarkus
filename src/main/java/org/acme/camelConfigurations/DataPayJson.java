package org.acme.camelConfigurations; 

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"amount",
"cardNumber",
"cardHolder",
"cardExpirationDate",
"cardCvv",
"cardType"
})


@jakarta.annotation.Generated("jsonschema2pojo")
public class DataPayJson {

@JsonProperty("amount")
private Double amount;
@JsonProperty("cardNumber")
private String cardNumber;
@JsonProperty("cardHolder")
private String cardHolder;
@JsonProperty("cardExpirationDate")
private String cardExpirationDate;
@JsonProperty("cardCvv")
private String cardCvv;
@JsonProperty("cardType")
private String cardType;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("amount")
public Double getAmount() {
return amount;
}

@JsonProperty("amount")
public void setAmount(Double amount) {
this.amount = amount;
}

@JsonProperty("cardNumber")
public String getCardNumber() {
return cardNumber;
}

@JsonProperty("cardNumber")
public void setCardNumber(String cardNumber) {
this.cardNumber = cardNumber;
}

@JsonProperty("cardHolder")
public String getCardHolder() {
return cardHolder;
}

@JsonProperty("cardHolder")
public void setCardHolder(String cardHolder) {
this.cardHolder = cardHolder;
}

@JsonProperty("cardExpirationDate")
public String getCardExpirationDate() {
return cardExpirationDate;
}

@JsonProperty("cardExpirationDate")
public void setCardExpirationDate(String cardExpirationDate) {
this.cardExpirationDate = cardExpirationDate;
}

@JsonProperty("cardCvv")
public String getCardCvv() {
return cardCvv;
}

@JsonProperty("cardCvv")
public void setCardCvv(String cardCvv) {
this.cardCvv = cardCvv;
}

@JsonProperty("cardType")
public String getCardType() {
return cardType;
}

@JsonProperty("cardType")
public void setCardType(String cardType) {
this.cardType = cardType;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}