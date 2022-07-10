package com.ffjm.photoapp.photomicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoDto {
    private String name;
    private String description;
    private String url;
    private String publicId;
    private String userId;
}
