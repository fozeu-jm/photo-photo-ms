package com.ffjm.photoapp.photomicroservice.service;

import com.ffjm.photoapp.photomicroservice.dto.PhotoDto;
import com.ffjm.photoapp.photomicroservice.entities.Photo;
import com.ffjm.photoapp.photomicroservice.exception.ResourceNotFoundException;
import com.ffjm.photoapp.photomicroservice.repository.PhotoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public PhotoDto savePhoto(PhotoDto photoDto) {
        Photo photo = dtoToEntity(photoDto);
        photo.setPublicId(UUID.randomUUID().toString());
        photoRepository.save(photo);
        return modelMapper.map(photoRepository.save(photo), PhotoDto.class);
    }

    @Override
    public List<PhotoDto> getUsersPhoto(String userId) throws ResourceNotFoundException {
        List<Photo> photoList = photoRepository.findByUserId(userId);
        if(photoList == null || photoList.isEmpty()){
            throw new ResourceNotFoundException("No Resource Found");
        }
        Type listType = new TypeToken<List<PhotoDto>>(){}.getType();
        return modelMapper.map(photoList, listType);
    }

    private Photo dtoToEntity(PhotoDto photoDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(photoDto, Photo.class);
    }
}
