package com.stockorder.stockorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockorder.stockorder.entity.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

}
