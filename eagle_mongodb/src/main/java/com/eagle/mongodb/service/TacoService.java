package com.eagle.mongodb.service;

import com.eagle.mongodb.data.TacoRepository;
import com.eagle.mongodb.tacos.Ingredient;
import com.eagle.mongodb.tacos.Taco;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Service
public class TacoService {
    private final TacoRepository tacoRepository;

    public TacoService(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    public void add() {
        Taco taco = new Taco();
        taco.setCreatedAt(new Date());
        taco.setName("tmp");
        ArrayList<Ingredient> ingredients = new ArrayList(){{
            add(new Ingredient(UUID.randomUUID().toString(), "tmp_name", Ingredient.Type.CHEESE));
        }};
        taco.setIngredients(ingredients);
        tacoRepository.save(new Taco());
    }
}
