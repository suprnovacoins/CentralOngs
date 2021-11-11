package com.example.spring.controller;

import com.example.spring.entity.Ong;
import com.example.spring.errorHandler.OngNotFoundException;
import com.example.spring.repository.OngRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OngController {

    private final OngRepository repository;

    public OngController(OngRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ongs")
    List<Ong> all(){
        return repository.findAll();
    }

    @PostMapping("/ongs")
    Ong newOng(@RequestBody Ong newOng){
        return repository.save(newOng);
    }

    @GetMapping("/ongs/{id}")
    Ong ongById (@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new OngNotFoundException(id));
    }

    @PutMapping("/ongs/{id}")
    Ong replaceOng(@RequestBody Ong newOng, @PathVariable Long id){
        return repository.findById(id)
                .map(ong -> {
                    ong.setNome(newOng.getNome());
                    ong.setInstituicao(newOng.getInstituicao());
                    ong.setPublico_destinado(newOng.getPublico_destinado());
                    ong.setEndereco(newOng.getEndereco());
                    ong.setBairro(newOng.getBairro());
                    ong.setResponsavel(newOng.getResponsavel());
                    return repository.save(ong);

                })
                .orElseGet(() -> {
                    newOng.setId(id);
                    return repository.save(newOng);
                });
    }

    @DeleteMapping("/ongs/{id}")
    void deleteOng (@PathVariable Long id){
        repository.deleteById(id);
    }
}
