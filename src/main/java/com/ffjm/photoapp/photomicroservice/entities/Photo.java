package com.ffjm.photoapp.photomicroservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "photo_user")
public class Photo implements Serializable {

    private static final long serialVersionUID = -1675980544299520890L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false, unique = true)
    private String publicId;

    @Column(nullable = false)
    private String userId;

}
