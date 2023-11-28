package com.asma.parfums.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asma.parfums.entities.Image;

public interface ImageRepository  extends JpaRepository<Image , Long> {

}
