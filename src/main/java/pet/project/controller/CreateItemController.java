package pet.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.project.service.DefaultService;

@RestController
public class CreateItemController {

    @Autowired
    DefaultService defaultService;

    @RequestMapping("/add")
    public void addItem() {
        defaultService.test();
    }

}
