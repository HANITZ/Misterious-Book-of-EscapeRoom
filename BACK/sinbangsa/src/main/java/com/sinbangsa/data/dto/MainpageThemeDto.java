package com.sinbangsa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MainpageThemeDto {

    @Getter
    @Setter
    public static class MostReviewedThemeDto{
        private long themeId;
        private String themeName;
        private String themeImg;
        private double star;
    }


    @Getter
    @Setter
    public static class LThemeDto{
        private long themeId;
        private String themeName;
        private String storeName;
        private String themeImg;
        private int likeCount;
        private double star;
        private String randomReview;
    }

    private List<LThemeDto> themelist;

}

