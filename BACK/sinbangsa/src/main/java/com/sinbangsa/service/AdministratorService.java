package com.sinbangsa.service;

import com.sinbangsa.data.dto.AdminStoreDto;
import com.sinbangsa.data.dto.StoreRegesterDto;
import com.sinbangsa.data.entity.Admin;

import java.util.List;

public interface AdministratorService {
    List<AdminStoreDto> getAdminStoreDetail(long adminId);
    Boolean registerStoreDetail(StoreRegesterDto storeRegesterDto, long adminId);
    Boolean updateStoreDetail(AdminStoreDto adminStoreDto, long adminId);
}
