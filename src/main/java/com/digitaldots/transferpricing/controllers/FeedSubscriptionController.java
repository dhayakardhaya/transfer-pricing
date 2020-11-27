package com.digitaldots.transferpricing.controllers;


import com.digitaldots.transferpricing.models.FeedSubscription;
import com.digitaldots.transferpricing.services.FeedSubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/feed-subscriptions")
@AllArgsConstructor
@Slf4j
public class FeedSubscriptionController {


    private final FeedSubscriptionService feedSubscriptionService;

    private final ModelMapper mapper;

    @Operation(summary = "Create a Feed Subscription", description = "Create a new Feed Subscription for user"
              , tags = { "FeedSubscription" }, security = @SecurityRequirement(name = "ApiKeyAuth"))
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeedSubscription> createFeedSubscription(@Valid @RequestBody FeedSubscription subscription) {
        return ResponseEntity.ok(feedSubscriptionService.save(subscription));
    }

    @Operation(summary = "Update a Feed Subscription", description = "Update a existing Feed Subscription"
              , tags = { "FeedSubscription" }, security = @SecurityRequirement(name = "ApiKeyAuth"))
    @PutMapping("/{id}")
    public FeedSubscription updateSubscription(@PathVariable String id, @Valid @RequestBody FeedSubscription subscription) {

        return feedSubscriptionService.updateFeedSubscription(id, subscription);
    }

    @Operation(summary = "Get a Feed Subscription", description = "Get a Feed Subscription by Id"
              , tags = { "FeedSubscription" }, security = @SecurityRequirement(name = "ApiKeyAuth"))
    @GetMapping("/subscription")
    public FeedSubscription getSubscription(@RequestParam(value = "subscriptionId", required = true) String subscriptionId) {
        return feedSubscriptionService.getSubscription(subscriptionId);
    }

    @Operation(summary = "Delete a  Feed Subscription", description = "Delete a Feed Subscription in DB Logically"
              , tags = { "FeedSubscription" }, security = @SecurityRequirement(name = "ApiKeyAuth"))
    @DeleteMapping(value = "/{subId}")
    public void deleteSubscription(@PathVariable("subId") final String subId) {
        feedSubscriptionService.deleteById(subId);
    }
}
