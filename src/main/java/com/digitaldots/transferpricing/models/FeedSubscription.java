package com.digitaldots.transferpricing.models;

import com.digitaldots.transferpricing.models.enums.Frequency;
import com.digitaldots.transferpricing.models.enums.Sources;
import com.digitaldots.transferpricing.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Data
@Builder
@Document(collection = "subscription")
public class FeedSubscription {

    @Id
    private String id;

    private List<Sources> sourceType;

    private List<Integer> amounts;

    private Frequency frequency;

    private SenderInfo senderInfo;

    private ReceiverInfo receiverInfo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    private Status status;

    private String actions;
}
