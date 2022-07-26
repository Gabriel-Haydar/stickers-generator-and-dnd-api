package br.com.alura.linguagens.api;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class DndImageController {
    
    @Autowired
    private DndImageRepository repository;

    @GetMapping("/cos-images")
    public List<DndImage> getDndImages() {
        List<DndImage> dndImages = repository.findAll();
        return dndImages;
    }

    @PostMapping("/cos-images")
    public DndImage addDndImage(@RequestBody DndImage dndImage) {
        DndImage savedDndImage = repository.save(dndImage);
        return savedDndImage;
    } 

}
