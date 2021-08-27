package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ticket;


public interface Repository extends JpaRepository<Ticket, Integer> {

}
