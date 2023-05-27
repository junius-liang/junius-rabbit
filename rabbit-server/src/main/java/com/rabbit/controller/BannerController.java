package com.rabbit.controller;

import com.rabbit.model.APIModel;
import com.rabbit.model.BannerItem;
import com.rabbit.server.BannerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author junius
 * @date 2023/05/27 14:49
 * @project rabbit-server
 **/
@RestController
public class BannerController {
    @Resource
    private BannerService bannerService;

    @GetMapping("/home/banner")
    public APIModel getBannerData(){
        return bannerService.getBannerData();
    }
}
