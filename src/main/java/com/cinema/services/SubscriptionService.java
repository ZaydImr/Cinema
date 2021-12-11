package com.cinema.services;

import com.cinema.repositories.ISubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    private ISubscriptionRepository subscriptionRepository;
    public SubscriptionService(ISubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }
}
