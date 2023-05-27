package com.rabbit;

import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rabbit.mapper.BannerMapper;
import com.rabbit.mapper.CategoryMapper;
import com.rabbit.mapper.GoodMapper;
import com.rabbit.model.BannerItem;
import com.rabbit.model.Category;
import com.rabbit.model.Good;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author junius
 * @date 2023/05/20 17:51
 * @project junius-rabbit
 **/
@SpringBootTest
public class test1 {
    @Resource
    private GoodMapper goodMapper;
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private BannerMapper bannerMapper;

    @Test
    void test() {
        Good good = new Good();
        good.setName("天狼狩猎者");
        good.setId("001");
        good.setDesca("裴擒虎kpl史诗限定皮肤");
        good.setPicture("https://i1.hdslb.com/bfs/archive/798d49e1fcb04521687692276ce38bd92f91d3e6.jpg");
        good.setPrice("88.00");
        good.setDiscount(null);
        good.setOrderNum(1);
        int insert = goodMapper.insert(good);
        Console.log(insert);
    }

    @Test
    void test2() {
        Category category = new Category();
        category.setName("皮肤");
        category.setParentId("-1");
        category.setId("0001");
        categoryMapper.insert(category);
    }

    @Test
    void test3() throws InterruptedException {
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
        //封装商品信息
        Console.log("===========================================");
        List<Category> result = new ArrayList<>();
        for (Category re : res) {
            addGoods(re,result);
        }
        for (Category category : result) {
            Console.log(category);
        }
    }

    private void addGoods(Category res,List<Category> result) {
        QueryWrapper<Good> goodQueryWrapper = new QueryWrapper<>();
        goodQueryWrapper.eq("categoryId", res.getId());
        List<Good> goods = goodMapper.selectList(goodQueryWrapper);
        res.setGoods(goods);
        result.add(res);
    }


    @Test
    public void test4(){
        QueryWrapper<Good> goodQueryWrapper = new QueryWrapper<>();
        goodQueryWrapper.eq("categoryId", "1013001");
        List<Good> goods = goodMapper.selectList(goodQueryWrapper);
        Console.log(goods);
    }

    @Test
    public void test5(){
        BannerItem bannerItem = new BannerItem();
        bannerItem.setHrefUrl("123");
        bannerItem.setType("1");
        bannerItem.setId("001");
        bannerItem.setImgUrl("jidsjdisjid");
        int insert = bannerMapper.insert(bannerItem);
    }

}
