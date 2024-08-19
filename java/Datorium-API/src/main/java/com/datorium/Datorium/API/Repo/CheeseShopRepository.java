package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTOs.Cheese;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Repository
public class CheeseShopRepository {
    private final List<Cheese> cheeses = new ArrayList<>(); //Mocked db

    public Cheese getById(Long id) {
        var cheese = cheeses.stream().filter(x -> x.id == id).findAny();
        return cheese.orElse(null);
    }

    public List<Cheese> getAll() {
        return cheeses;
    }

    public Cheese update(Integer id, Cheese cheese) {
        OptionalInt indexOpt = IntStream.range(0, cheeses.size())
                .filter(i -> cheeses.get(i).id == id)
                .findFirst();
        if (indexOpt.isPresent()) {
            cheeses.get(indexOpt.getAsInt()).name = cheese.name;
            cheeses.get(indexOpt.getAsInt()).age = cheese.age;
            return cheeses.get(indexOpt.getAsInt());
        }
        return null;
    }

    public Cheese create(Cheese cheese) {
        cheeses.add(cheese);
        return cheese;
    }
}
