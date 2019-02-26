package com.lyq.project.service;

import com.lyq.project.common.LYQResponse;
import com.lyq.project.common.SearchDto;
import com.lyq.project.common.ShengJiJianGuanBuMenSearchDto;
import com.lyq.project.dto.CreateKeYunQiYeDto;
import com.lyq.project.dto.CreateShengJiJianGuanBuMenDto;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IQService {
    LYQResponse createShengJiJianGuanBuMen(HttpSession session, CreateShengJiJianGuanBuMenDto createShengJiJianGuanBuMenDto);
    LYQResponse getShengJiJianGuanBuMenList(HttpSession session, SearchDto<ShengJiJianGuanBuMenSearchDto> searchDto);
    LYQResponse getShengJiJianGuanBuMenDetail(HttpSession session, String id);
    LYQResponse updateShengJiJianGuanBuMen(HttpSession session, CreateShengJiJianGuanBuMenDto createShengJiJianGuanBuMenDto);
    LYQResponse deleteShengJiJianGuanBuMenDetail(HttpSession session, String id);
    LYQResponse createKeYunQiYe(HttpSession session, CreateKeYunQiYeDto createKeYunQiYeDto);

}
