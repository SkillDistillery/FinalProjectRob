package com.skilldistillery.booknerds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.booknerds.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
