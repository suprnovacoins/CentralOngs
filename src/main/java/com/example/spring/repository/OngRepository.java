package com.example.spring.repository;

import com.example.spring.entity.Ong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  OngRepository extends JpaRepository<Ong, Long> {

}
