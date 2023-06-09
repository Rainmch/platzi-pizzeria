package com.platzi.pizza.web.controller;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;
    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll(){
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> get(@PathVariable int idPizza){
        return ResponseEntity.ok( pizzaService.get(idPizza) );
    }
    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> getAvailable(){
        return ResponseEntity.ok( pizzaService.getAvailable() );
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> getByName(@PathVariable String name){
        return ResponseEntity.ok( pizzaService.getByName(name) );
    }

    @GetMapping("/with/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getWith(@PathVariable String ingredient){
        return ResponseEntity.ok( pizzaService.getWith(ingredient) );
    }

    @GetMapping("/without/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getWithout(@PathVariable String ingredient){
        return ResponseEntity.ok( pizzaService.getWithout(ingredient) );
    }

    @GetMapping("/priceGreather/{price}")
    public ResponseEntity<List<PizzaEntity>> getPriceGreather(@PathVariable int price){
        return ResponseEntity.ok( pizzaService.getPriceGreather(price) );
    }


    @PostMapping
    public ResponseEntity< PizzaEntity > add(@RequestBody PizzaEntity pizza){
        if(pizza.getIdPizza() == null || !pizzaService.exists(pizza.getIdPizza()) ){
            return ResponseEntity.ok( pizzaService.save(pizza) );
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity< PizzaEntity > update(@RequestBody PizzaEntity pizza){
        if(pizza.getIdPizza() != null && pizzaService.exists(pizza.getIdPizza()) ){
            return ResponseEntity.ok( pizzaService.save(pizza) );
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> delete(@PathVariable int idPizza){
        if(pizzaService.exists(idPizza)){
            pizzaService.delete(idPizza);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
