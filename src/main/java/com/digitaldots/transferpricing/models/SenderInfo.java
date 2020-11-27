package com.digitaldots.transferpricing.models;

import com.digitaldots.transferpricing.models.enums.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SenderInfo {

    private String senderCountry;

    private String senderCurrency;

    private List<PaymentMethod> paymentMethod;

    private List<String> senderLocations;

}
