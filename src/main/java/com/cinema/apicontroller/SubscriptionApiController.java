package com.cinema.apicontroller;

import com.cinema.models.Director;
import com.cinema.models.Subscription;
import com.cinema.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @GetMapping
    public String index() {
        return "redirect:/subscriptions/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Subscription> page = subscriptionService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "subscriptions/list";
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
