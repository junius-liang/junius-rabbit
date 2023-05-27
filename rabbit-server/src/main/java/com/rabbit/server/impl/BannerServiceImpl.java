package com.rabbit.server.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbit.mapper.BannerMapper;
import com.rabbit.model.APIModel;
import com.rabbit.model.BannerItem;
import com.rabbit.server.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author junius
 * @date 2023/05/27 14:51
 * @project rabbit-server
 **/
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper,BannerItem> implements BannerService{
    @Resource
    private BannerMapper bannerMapper;
    @Override
    public APIModel getBannerData() {
        APIModel objectAPIModel = new APIModel<>();
        List<BannerItem> bannerItems = bannerMapper.selectList(null);
        objectAPIModel.setMsg("操作成功");
        objectAPIModel.setCode("1");
        objectAPIModel.setResult(bannerItems);
        return objectAPIModel;
    }

}
