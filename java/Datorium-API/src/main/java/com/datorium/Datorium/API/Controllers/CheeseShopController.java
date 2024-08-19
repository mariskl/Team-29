package com.datorium.Datorium.API.Controllers;

import com.datorium.Datorium.API.DTOs.Cheese;
import com.datorium.Datorium.API.Services.CheeseShopService;
import com.datorium.Datorium.API.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cheese")
public class CheeseShopController {
    private final CheeseShopService cheeseShopService;

    // Constructor-based injection without @Autowired
    public CheeseShopController(CheeseShopService cheeseShopService) {
        this.cheeseShopService = cheeseShopService;
    }

    @GetMapping
    public List<Cheese> get() {
        return cheeseShopService.getAll();
    }

    @GetMapping("/{id}")
    public Cheese getById(@PathVariable Long id) {
        return cheeseShopService.getById(id);
    }

    @PostMapping
    public Cheese post(@RequestBody Cheese cheese) {
        return cheeseShopService.create(cheese);
    }

    @PutMapping("/{id}")
    public Cheese put(@PathVariable Integer id, @RequestBody Cheese cheese) {
        return cheeseShopService.update(id, cheese);
    }
}
