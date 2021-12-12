package com.cinema.services;

import com.cinema.dao.IGenericRepository;
import com.cinema.models.Subscription;
import com.cinema.repositories.ISubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionService implements IGenericRepository<Subscription, UUID> {
    private ISubscriptionRepository subscriptionRepository;
    public SubscriptionService(ISubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<Subscription> GetAll() {
        return null;
    }

    @Override
    public void AddEntity(Subscription obj) {

    }

    @Override
    public void UpdateEntity(Subscription obj) {

    }

    @Override
    public Subscription GetOneById(int id) {
        return null;
    }

    @Override
    public void DeleteEntity(int id) {

    }
}
