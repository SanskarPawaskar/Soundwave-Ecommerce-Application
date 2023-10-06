package com.sanskar.major.repository;

import java.util.List;

import jdk.internal.foreign.abi.aarch64.linux.LinuxAArch64Linker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanskar.major.model.Category;
import com.sanskar.major.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
