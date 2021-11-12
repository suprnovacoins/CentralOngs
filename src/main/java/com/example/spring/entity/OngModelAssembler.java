package com.example.spring.entity;

import com.example.spring.controller.OngController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OngModelAssembler implements RepresentationModelAssembler<Ong, EntityModel<Ong>> {
    @Override
    public EntityModel<Ong> toModel(Ong ong) {
        return EntityModel.of(ong,
                linkTo(methodOn(OngController.class).one(ong.getId())).withSelfRel(),
                linkTo(methodOn(OngController.class).all()).withRel("ong"));
    }

}
