package com.rabbit.reptile;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.rabbit.mapper.CategoryMapper;
import com.rabbit.mapper.GoodMapper;
import com.rabbit.model.APIModel;
import com.rabbit.model.Category;
import com.rabbit.model.Good;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author junius
 * @date 2023/05/20 13:47
 * @project junius-rabbit
 **/
@Component
public class GetLayout {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private GoodMapper goodMapper;

    static String URL = Constant.URL;
    static String path = "/home/category/head";
    static List<Category> list = new ArrayList<>();
    static List<Category> list2 = new ArrayList<>();


    @PostConstruct
    void init() {
//        getLayout();
    }

    public  void getLayout() {
        String result1= HttpUtil.get(URL+path);
        APIModel apiModel = JSONUtil.toBean(result1, APIModel.class);
        List result = apiModel.getResult();
        for (Object category : result) {
            String s = JSONUtil.toJsonStr(category);
            Category category1 = JSONUtil.toBean(s, Category.class);
            list2.add(category1);
        }
        for (Category category : list2) {
            buildTree("-1",category);
        }
        for (Category category : list) {
            List<Good> goods = category.getGoods();
            if (null!=goods){
                for (Good good : goods) {
                    good.setCategoryId(category.getId());
                    goodMapper.insert(good);
                }
            }

            categoryMapper.insert(category);
        }
    }

     void buildTree(String parentId, Category category){
        if (null==category.getChildren()||0==category.getChildren().size()) {
            category.setParentId(parentId);
            list.add(category);
            return;
        }
        category.setParentId(parentId);
        list.add(category);
        for (Category child : category.getChildren()) {
            buildTree(category.getId(),child);
        }

    }
}
