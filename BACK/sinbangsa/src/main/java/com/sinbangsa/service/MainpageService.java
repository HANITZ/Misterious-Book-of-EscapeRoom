package com.sinbangsa.service;

import com.sinbangsa.data.dto.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MainpageService {
    MainpageStoreDto getStoreSearchResult(String searchWord, int page, String type);

    MainpageThemeDto getThemeSearchResult(String searchWord, int page, String type);
    PreLoadingDto getPreLoading();

    List<TransferDto> getTransfers(String region);

    TransferSearchDto getTransferSearch(String searchWord);

    Boolean putTransfer(Long reservationId, HttpServletRequest httpServletRequest);
}
