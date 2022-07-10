package com.ffjm.photoapp.photomicroservice.controllers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoRequestModel {
    @NotNull(message = "name field cannot be null")
    private String name;
    private String description;
    @NotNull
    private String url;
    @NotNull
    private String userId;
}
