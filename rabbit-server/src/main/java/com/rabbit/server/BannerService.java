package com.rabbit.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rabbit.mapper.BannerMapper;
import com.rabbit.model.APIModel;
import com.rabbit.model.BannerItem;
import org.springframework.stereotype.Service;

/**
 * @author junius
 * @date 2023/05/27 14:48
 * @project rabbit-server
 **/

public interface BannerService {
    APIModel getBannerData();
}
