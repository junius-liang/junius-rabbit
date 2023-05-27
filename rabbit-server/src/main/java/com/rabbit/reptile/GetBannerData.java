package com.rabbit.reptile;

import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.rabbit.mapper.BannerMapper;
import com.rabbit.model.APIModel;
import com.rabbit.model.BannerItem;
import com.rabbit.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author junius
 * @date 2023/05/27 14:15
 * @project rabbit-server
 * 爬取轮播图数据并封装
 **/
@Component
@Slf4j
public class GetBannerData {
    private static String path = "/home/banner";
    @Resource
    private BannerMapper bannerMapper;

//    @PostConstruct
    private  void GetBannerData() {
        String result1= HttpUtil.get(Constant.URL+path);
        APIModel apiModel = JSONUtil.toBean(result1, APIModel.class);
        List result = apiModel.getResult();
        for (Object item : result) {
            String s = JSONUtil.toJsonStr(item);
            BannerItem bannerItem = JSONUtil.toBean(s, BannerItem.class);
            bannerMapper.insert(bannerItem);
        }
        log.info("爬取banner轮播图数据成功");
    }
}
