package com.rabbit.server.impl;

import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rabbit.mapper.CategoryMapper;
import com.rabbit.mapper.GoodMapper;
import com.rabbit.model.APIModel;
import com.rabbit.model.Category;
import com.rabbit.model.Good;
import com.rabbit.server.CategoriesServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author junius
 * @date 2023/05/20 18:59
 * @project junius-rabbit
 **/
@Service
public class CategoriesServerImpl implements CategoriesServer {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private GoodMapper goodMapper;

    @Override
    public APIModel<Category> getAllCategories() {
        APIModel<Category> data = new APIModel<>();
        //创建树形结构
        List<Category> res = new ArrayList<>();
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.eq("parentId","-1");
        List<Category> categories = categoryMapper.selectList(categoryQueryWrapper);
        for (Category category : categories) {
            QueryWrapper<Category> categoryQueryWrapper1 = new QueryWrapper<>();
            categoryQueryWrapper.eq("parentId",category.getId());
            List<Category> categories1 = categoryMapper.selectList(categoryQueryWrapper1);
            for (Category category1 : categories1) {
                if (category1.getParentId().equals(category.getId())){
                    List<Category> children = category.getChildren();
                    if (children==null){
                        children = new ArrayList<>();
                    }
                    children.add(category1);
                    category.setChildren(children);
                }
            }
            res.add(category);
        }
        List<Category> result = new ArrayList<>();
        for (Category re : res) {
            addGoods(re,result);
        }
        data.setResult(result);
        data.setCode("200");
        data.setMsg("success");
        return data;
    }

    private void addGoods(Category res,List<Category> result) {
        QueryWrapper<Good> goodQueryWrapper = new QueryWrapper<>();
        goodQueryWrapper.eq("categoryId", res.getId());
        List<Good> goods = goodMapper.selectList(goodQueryWrapper);
        res.setGoods(goods);
        result.add(res);
    }

}
