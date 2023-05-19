package com.br.mentorama.AsyncThreadPool.Services;

import com.br.mentorama.AsyncThreadPool.Models.Cars;
import com.br.mentorama.AsyncThreadPool.Repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class CarsService {

    @Autowired
    CarsRepository carsRepository;

    public CompletableFuture<List<Cars>> findAllBy(){
        System.out.println("Serviço Thread Service FindAllBy: " + Thread.currentThread().getName());
        return carsRepository.findAllBy();
    }
    public CompletableFuture<Optional<Cars>> findByOneId(UUID id){
        System.out.println("Serviço Thread Service FindByOneId: " + Thread.currentThread().getName());
        return carsRepository.findOneById(id);
    }
    public CompletableFuture<Cars> save(Cars cars){
        System.out.println("Serviço Thread Service Save: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(carsRepository.save(cars));
    }
    public CompletableFuture<Cars> update(Cars cars){
        System.out.println("Serviço Thread Service update: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(carsRepository.save(cars));
    }
    public CompletableFuture<Optional<Cars>> delete(UUID id){
        System.out.println("Serviço Thread Service delete: " + Thread.currentThread().getName());
        carsRepository.deleteById(id);
        return null;
    }
}
