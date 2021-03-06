package com.cinema.repositories;

import com.cinema.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription, UUID> {
    void deleteSubscriptionById(UUID id);

    Optional<Subscription> findSubscriptionById(UUID id);
}
