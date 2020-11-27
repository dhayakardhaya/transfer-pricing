package com.digitaldots.transferpricing.models;

import com.digitaldots.transferpricing.models.enums.DeliveryMethod;
import com.digitaldots.transferpricing.models.enums.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReceiverInfo {

    private String  receiverCountry;

    private String receiverCurrency;

    private DeliveryMethod deliveryMethod;

    private List<String> receiverLocations;

}
