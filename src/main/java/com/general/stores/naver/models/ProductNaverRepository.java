package com.general.stores.naver.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductNaverRepository extends JpaRepository<NaverProduct, Long> {
	
}