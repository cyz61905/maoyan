package com.cyz.maoyan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    private Integer id;

    private String name;

    private String englishName;

    private Integer regionId;

    private Integer duration;

    private Date releaseDate;

    private String showingArea;

    private String posterUrl;

    private String introduction;

    private Integer del;

    private Integer wantSee;

    private Integer playState;
}
