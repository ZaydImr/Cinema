package com.cinema.services;


import com.cinema.models.Subscription;
import com.cinema.repositories.ISubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubscriptionService extends AbstractService<Subscription, UUID> {

    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Override
    protected JpaRepository<Subscription, UUID> getRepository() {
        return subscriptionRepository;
    }

    public long getCountOfSubscriptions(){
        return subscriptionRepository.count();
    }
}
