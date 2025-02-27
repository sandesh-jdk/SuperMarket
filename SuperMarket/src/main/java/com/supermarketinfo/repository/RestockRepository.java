package com.supermarketinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarketinfo.Entity.Restock;

@Repository
public interface RestockRepository extends JpaRepository<Restock, Long>
{

}
