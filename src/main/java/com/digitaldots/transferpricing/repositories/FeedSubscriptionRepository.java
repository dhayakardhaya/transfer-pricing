package com.digitaldots.transferpricing.repositories;

import com.digitaldots.transferpricing.models.FeedSubscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedSubscriptionRepository extends MongoRepository<FeedSubscription, String>,
        PagingAndSortingRepository<FeedSubscription, String> {

}
