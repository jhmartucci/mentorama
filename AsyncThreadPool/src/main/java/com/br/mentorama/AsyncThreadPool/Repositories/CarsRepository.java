package com.br.mentorama.AsyncThreadPool.Repositories;

import com.br.mentorama.AsyncThreadPool.Models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Repository
@Async("customThreadPool")
public interface CarsRepository extends JpaRepository<Cars, UUID> {
    CompletableFuture<Optional<Cars>> findOneById(UUID id);
    CompletableFuture<List<Cars>> findAllBy();
}
