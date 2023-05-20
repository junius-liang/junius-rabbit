package com.rabbit.controller;

import com.rabbit.model.APIModel;
import com.rabbit.model.Category;
import com.rabbit.server.CategoriesServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author junius
 * @date 2023/05/20 18:55
 * @project junius-rabbit
 **/
@RestController
public class CategoryController {
    @Autowired
    private CategoriesServer categoriesServer;

    @GetMapping("/home/category/head")
    public APIModel<Category> getAllCategories(){
        return categoriesServer.getAllCategories();
    }
}
