package com.ffjm.photoapp.photomicroservice.repository;

import com.ffjm.photoapp.photomicroservice.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findByUserId(String userId);
}
