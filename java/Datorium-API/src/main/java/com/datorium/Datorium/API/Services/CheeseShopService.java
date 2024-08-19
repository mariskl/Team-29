package com.datorium.Datorium.API.Services;

import com.datorium.Datorium.API.DTOs.Cheese;
import com.datorium.Datorium.API.Repo.CheeseShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheeseShopService {
    private final CheeseShopRepository cheeseShopRepository;

    public CheeseShopService(CheeseShopRepository cheeseShopRepository) {
        this.cheeseShopRepository = cheeseShopRepository;
    }

    public Cheese create(Cheese cheese) {
        return cheeseShopRepository.create(cheese);
    }

    public Cheese update(Integer id, Cheese cheese) {
        return cheeseShopRepository.update(id, cheese);
    }

    public List<Cheese> getAll() {
        return cheeseShopRepository.getAll();
    }

    public Cheese getById(Long id) {
        return cheeseShopRepository.getById(id);
    }
}
