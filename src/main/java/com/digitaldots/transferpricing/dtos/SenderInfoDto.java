package com.digitaldots.transferpricing.dtos;

import com.digitaldots.transferpricing.models.enums.PaymentMethod;
import lombok.Data;

import java.util.List;

@Data
public class SenderInfoDto {

    private String senderCountry;

    private String senderCurrency;

    private PaymentMethod paymentMethod;

    private List<String> senderLocations;
}
