package com.cinema.services;


import com.cinema.dao.IGenericRepository;
import com.cinema.models.Subscription;
import com.cinema.exceptions.ElementNotFoundException;
import com.cinema.repositories.ISubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionService extends AbstractService<Subscription, UUID> {

    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Override
    protected JpaRepository<Subscription, UUID> getRepository() {
        return subscriptionRepository;
    }

    /*@Override
    public List<Subscription> GetAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription AddEntity(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription UpdateEntity(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription GetOneById(UUID id) {
        return subscriptionRepository.findSubscriptionById(id)
                .orElseThrow(() -> new ElementNotFoundException("Subscription was not found !"));
    }

    @Override
    public void DeleteEntity(UUID id) {
        subscriptionRepository.deleteSubscriptionById(id);
    }*/
}
