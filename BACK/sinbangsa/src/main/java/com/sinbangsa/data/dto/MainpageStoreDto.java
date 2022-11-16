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
public class MainpageStoreDto {

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
    public static class LStoreDto {
        private long storeId;
        private String storeName;
        private String storeImg;
        private String storeAddress;
        private int likeCount;
        private MostReviewedThemeDto mostReviewedTheme;
        private String tel;
        private String mapX;
        private String mapY;
        private String homepage;
    }

    private List<LStoreDto> storeList;

}

