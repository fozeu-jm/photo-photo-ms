package com.ffjm.photoapp.photomicroservice.service;

import com.ffjm.photoapp.photomicroservice.dto.PhotoDto;
import com.ffjm.photoapp.photomicroservice.exception.ResourceNotFoundException;

import java.util.List;

public interface PhotoService {
    PhotoDto savePhoto(PhotoDto photoDto);

    List<PhotoDto> getUsersPhoto(String userId) throws ResourceNotFoundException;
}
