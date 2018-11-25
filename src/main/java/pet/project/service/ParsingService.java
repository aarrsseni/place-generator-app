package pet.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ParsingService {

    String getRandomNewPlace();

    String getCafe() throws JsonProcessingException;
}
