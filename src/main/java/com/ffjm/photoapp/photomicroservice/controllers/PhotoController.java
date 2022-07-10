package com.ffjm.photoapp.photomicroservice.controllers;

import com.ffjm.photoapp.photomicroservice.controllers.model.PhotoRequestModel;
import com.ffjm.photoapp.photomicroservice.controllers.model.PhotoResponseModel;
import com.ffjm.photoapp.photomicroservice.dto.PhotoDto;
import com.ffjm.photoapp.photomicroservice.exception.ResourceNotFoundException;
import com.ffjm.photoapp.photomicroservice.service.PhotoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@Controller
@RequestMapping("/photo")
public class PhotoController {
    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("")
    public ResponseEntity<PhotoResponseModel> savePhoto(@Valid @RequestBody PhotoRequestModel photoRequestModel) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PhotoDto photoDto = photoService.savePhoto(modelMapper.map(photoRequestModel, PhotoDto.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(photoDto, PhotoResponseModel.class));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<PhotoResponseModel>> getUserPhoto(@PathVariable String userId) throws ResourceNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<PhotoDto>>() {
        }.getType();
        return ResponseEntity.ok(modelMapper.map(photoService.getUsersPhoto(userId), listType));
    }
}
