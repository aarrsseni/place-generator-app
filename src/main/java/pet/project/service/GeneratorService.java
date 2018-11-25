package pet.project.service;

import pet.project.model.FoodPlace;

import java.util.List;

public interface GeneratorService {

    FoodPlace generateForPerson(int id);

    FoodPlace generateForPersons(List<Integer> ids);

    FoodPlace generateForPersonByMark(int id);

    FoodPlace generateForPersonsByMark(List<Integer> ids);
}
