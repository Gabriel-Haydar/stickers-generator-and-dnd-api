package br.com.alura.linguagens.api;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DndImageRepository extends MongoRepository<DndImage, String> {
    
}
