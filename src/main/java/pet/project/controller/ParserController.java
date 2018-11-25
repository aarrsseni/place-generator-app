package pet.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pet.project.service.ParsingService;

@RestController
public class ParserController {

    @Autowired
    private ParsingService parsingService;

    @RequestMapping(value = "/getNewPlace", method = RequestMethod.GET)
    public String getNewPlace() {
        return parsingService.getRandomNewPlace();
    }

    @RequestMapping(value = "/getCafe", method = RequestMethod.GET)
    public String getCafe() throws JsonProcessingException {
        return parsingService.getCafe();
    }
}
