package com.digitaldots.transferpricing.dtos;

import com.digitaldots.transferpricing.models.ReceiverInfo;
import com.digitaldots.transferpricing.models.SenderInfo;
import com.digitaldots.transferpricing.models.enums.Frequency;
import com.digitaldots.transferpricing.models.enums.Sources;
import com.digitaldots.transferpricing.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class FeedSubscriptionDto {

    private String id;

    @NotNull(message = "Source Type should not be null")
    private List<Sources> sourceType;

    private List<Integer> amounts;

    private Frequency frequency;

    private SenderInfoDto senderInfo;

    private ReceiverInfoDto receiverInfo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    private Status status;

    private String actions;
}
