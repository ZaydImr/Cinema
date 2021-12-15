package com.cinema.apicontroller;

import com.cinema.models.Subscription;
import com.cinema.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/subscription")
@RequiredArgsConstructor
public class SubscriptionApiController {
    public final SubscriptionService subscriptionService;

    @GetMapping("/all")
    public ResponseEntity<List<Subscription>> getAllSubscriptions(){
        List<Subscription> Subscriptions = subscriptionService.getAll();
        return new ResponseEntity<>(Subscriptions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable("id") UUID id) {
        Subscription subscription = null;
        try {
            subscription = subscriptionService.getElementById(id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(subscription, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription subscription) {
        Subscription newSubscription = subscriptionService.addEntity(subscription);
        return new ResponseEntity<>(newSubscription, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Subscription> updateSubscription(@RequestBody Subscription subscription) {
        Subscription updatedSubscription = subscriptionService.updateEntity(subscription);
        return new ResponseEntity<>(updatedSubscription, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubscription(@PathVariable("id") UUID id){
        subscriptionService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
