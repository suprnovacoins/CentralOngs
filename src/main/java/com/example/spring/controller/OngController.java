package com.example.spring.controller;

import com.example.spring.entity.Ong;
import com.example.spring.entity.OngModelAssembler;
import com.example.spring.errorHandler.OngNotFoundException;
import com.example.spring.repository.OngRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class OngController {

    private final OngRepository repository;
    private final OngModelAssembler assembler;

    public OngController(OngRepository repository, OngModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/ongs")
    public CollectionModel<EntityModel<Ong>> all(){

        List<EntityModel<Ong>> ongs = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(ongs,
                linkTo(methodOn(OngController.class).all()).withSelfRel());
    }

    @PostMapping("/ongs")
    Ong newOng(@RequestBody Ong newOng){
        return repository.save(newOng);
    }

//    @GetMapping("/ongs/{id}")
//    Ong ongById (@PathVariable Long id){
//        return repository.findById(id)
//                .orElseThrow(() -> new OngNotFoundException(id));
//    }

//    @GetMapping("/ongs/{id}")
//    EntityModel one (@PathVariable Long id){
//        Ong ong = repository.findById(id)
//                .orElseThrow(() -> new OngNotFoundException(id));
//
//        return EntityModel.of(ong,
//                linkTo(methodOn(OngController.class).one(id)).withSelfRel(),
//                linkTo(methodOn(OngController.class).all()).withRel("ongs"));
//    }

    @GetMapping("/ongs/{id}")
    public EntityModel<Ong> one(@PathVariable Long id){
        Ong ong = repository.findById(id)
                .orElseThrow(() -> new OngNotFoundException(id));

        return assembler.toModel(ong);
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
