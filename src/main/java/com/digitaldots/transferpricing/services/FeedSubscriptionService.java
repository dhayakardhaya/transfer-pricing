package com.digitaldots.transferpricing.services;

import com.digitaldots.transferpricing.exceptions.NoSuchFeedSubscriptionExistException;
import com.digitaldots.transferpricing.models.FeedSubscription;
import com.digitaldots.transferpricing.models.ReceiverInfo;
import com.digitaldots.transferpricing.models.SenderInfo;
import com.digitaldots.transferpricing.models.enums.Sources;
import com.digitaldots.transferpricing.models.enums.Status;
import com.digitaldots.transferpricing.repositories.FeedSubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FeedSubscriptionService {

    @Autowired
    private FeedSubscriptionRepository feedSubscriptionRepository;


    public FeedSubscription save(FeedSubscription subscription) {
        log.info("New Subscription created successfully");
        feedSubscriptionRepository.save(subscription);
        return subscription;
    }

    public FeedSubscription updateFeedSubscription(String id, FeedSubscription subscription) {
        Optional<FeedSubscription> availableSubscription = feedSubscriptionRepository.findById(id);
        if(availableSubscription.isPresent()) {
            availableSubscription.get().setSourceType(subscription.getSourceType());
            availableSubscription.get().setAmounts(subscription.getAmounts());
            availableSubscription.get().setFrequency(subscription.getFrequency());
            availableSubscription.get().setSenderInfo(updateSenderInfo(subscription));
            availableSubscription.get().setReceiverInfo(updateReceiverInfo(subscription));
            availableSubscription.get().setModifiedAt(LocalDateTime.now());
            availableSubscription.get().setStatus(subscription.getStatus());
            availableSubscription.get().setActions(subscription.getActions());
            feedSubscriptionRepository.save(availableSubscription.get());
            log.info("Subscription is updated successfully");
        } else {
            throw new NoSuchFeedSubscriptionExistException("Subscription doesn't exist with the given id");
        }

        return availableSubscription.get();
    }
    public SenderInfo updateSenderInfo(FeedSubscription subscription) {
        return SenderInfo.builder().senderCountry(subscription.getSenderInfo().getSenderCountry())
               .senderCurrency(subscription.getSenderInfo().getSenderCurrency())
               .paymentMethod(subscription.getSenderInfo().getPaymentMethod())
               .senderLocations(subscription.getSenderInfo().getSenderLocations()).build();
    }
    public ReceiverInfo updateReceiverInfo(FeedSubscription subscription) {
        return ReceiverInfo.builder().receiverCountry(subscription.getReceiverInfo().getReceiverCountry())
               .receiverCurrency(subscription.getReceiverInfo().getReceiverCurrency())
               .deliveryMethod(subscription.getReceiverInfo().getDeliveryMethod())
               .receiverLocations(subscription.getReceiverInfo().getReceiverLocations()).build();
    }

    public FeedSubscription getSubscription(String subscriptionId) {
        Optional<FeedSubscription> existingSubscription = feedSubscriptionRepository.findById(subscriptionId);
        if(existingSubscription.isPresent()) {
            return existingSubscription.get();
        } else {
            throw new NoSuchFeedSubscriptionExistException("Subscription doesn't exist with the given Id");
        }
    }

    public void deleteById(String subId) {
        Optional<FeedSubscription> existingFeedSubscription = feedSubscriptionRepository.findById(subId);
        if(existingFeedSubscription.isPresent()) {
            existingFeedSubscription.get().setStatus(Status.ARCHIVED);
            feedSubscriptionRepository.save(existingFeedSubscription.get());
        } else {
            throw new NoSuchFeedSubscriptionExistException("No Feed Subscription Exist with the given Id");
        }
    }
}
