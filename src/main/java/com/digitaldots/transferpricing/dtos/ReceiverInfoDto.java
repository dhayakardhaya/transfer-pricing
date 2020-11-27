package com.digitaldots.transferpricing.dtos;

import com.digitaldots.transferpricing.models.enums.DeliveryMethod;
import lombok.Data;

import java.util.List;

@Data
public class ReceiverInfoDto {

    private String  receiverCountry;

    private String receiverCurrency;

    private DeliveryMethod deliveryMethod;

    private List<String> receiverLocations;
}
