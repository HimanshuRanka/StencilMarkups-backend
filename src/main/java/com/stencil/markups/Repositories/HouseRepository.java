package com.stencil.markups.Repositories;

import com.stencil.markups.Models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer>{

}
