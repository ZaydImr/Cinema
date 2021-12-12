package com.cinema.services;

import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.models.Subscription;
import com.cinema.models.User;
import com.cinema.repositories.ISubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionService {
    private final ISubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(ISubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription addSubscription(Subscription subscription){
        subscription.setIdEmailSubscription(UUID.fromString(UUID.randomUUID().toString()));
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscriptions(){
        return subscriptionRepository.findAll();
    }

    public Subscription updateSubscription(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }

    public Subscription findSubscriptionById(UUID id) throws Throwable {
        return subscriptionRepository.findSubscriptionById(id)
                .orElseThrow(() -> new ElementNotFoundException("Subscription was not found !"));
    }

    public void deleteSubscription(UUID id){
        subscriptionRepository.deleteSubscriptionById(id);
    }
}
