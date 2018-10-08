package pet.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pet.project.model.FoodPlace;
import pet.project.service.DefaultService;

@RestController
public class CreateItemController {

    @Autowired
    DefaultService defaultService;

    @PostMapping("/addItem")
    public void addItem(@ModelAttribute FoodPlace foodPlace) {
        defaultService.test();
    }
}
