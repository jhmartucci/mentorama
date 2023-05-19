package com.br.mentorama.AsyncThreadPool.Controllers;

import com.br.mentorama.AsyncThreadPool.Models.Cars;
import com.br.mentorama.AsyncThreadPool.Services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/cars")
@RestController
@Async
public class CarsController {
    @Autowired
    private CarsService carsService;

    @GetMapping
    public CompletableFuture<List<Cars>> findAll(){
        System.out.println("Serviço Thread Controller findAll: " + Thread.currentThread().getName());
        return carsService.findAllBy();
    }
    @GetMapping("/{id}")
    public CompletableFuture<Cars> findByOneId(UUID id){
        System.out.println("Serviço Thread Controller findByOneId: " + Thread.currentThread().getName());
        return carsService.findByOneId(id).thenApply(c-> {
            try {
                return c.get();
            }catch (NoSuchElementException e){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        });
    }
    @PostMapping
    public CompletableFuture<Cars> save(@RequestBody Cars cars){
        System.out.println("Serviço Thread Controller Save: " + Thread.currentThread().getName());
        return this.carsService.save(cars);
    }
    @PutMapping
    public CompletableFuture<Cars> uptade(@RequestBody Cars cars){
        System.out.println("Serviço Thread Controller Update: " + Thread.currentThread().getName());
        return carsService.save(cars);
    }
    @DeleteMapping("/{id}")
    public CompletableFuture<Optional<Cars>> delete(@PathVariable UUID id){
        System.out.println("Serviço Thread Controller Delete: " + Thread.currentThread().getName());
        if(carsService.findByOneId(id).join().isPresent()){
            return carsService.delete(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
