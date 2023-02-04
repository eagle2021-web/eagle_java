package com.eagle.mongodb.data;

import org.springframework.data.repository.CrudRepository;
import com.eagle.mongodb.tacos.Ingredient;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String>{

}
