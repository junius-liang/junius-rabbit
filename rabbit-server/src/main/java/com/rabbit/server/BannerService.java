package com.rabbit.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rabbit.model.APIModel;
import com.rabbit.model.BannerItem;

/**
 * @author junius
 * @date 2023/05/27 14:48
 * @project rabbit-server
 **/

public interface BannerService extends IService<BannerItem> {
    APIModel getBannerData();
}
