package com.cinema.apicontroller;

import com.cinema.classGeneric.Page;
import com.cinema.models.Director;
import com.cinema.models.Nationality;
import com.cinema.models.Subscription;
import com.cinema.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/subscription")
@RequiredArgsConstructor
public class SubscriptionApiController {
    public final SubscriptionService subscriptionService;

    @GetMapping(value = "all/{pageNumber}")
    public ResponseEntity<com.cinema.classGeneric.Page<Subscription>> list(@PathVariable Integer pageNumber) {
        com.cinema.classGeneric.Page<Subscription> page = new Page<>();
        page.setList(subscriptionService.getList(pageNumber));
        page.setNext(subscriptionService.getList(pageNumber + 1).size() > 0);
        if(pageNumber -1 > 0)
            page.setPrev(subscriptionService.getList(pageNumber - 1).size() > 0);
        else
            page.setPrev(false);
        return new ResponseEntity<>(page,HttpStatus.OK) ;
    }

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
