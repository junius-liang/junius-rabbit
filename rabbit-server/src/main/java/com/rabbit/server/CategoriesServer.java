package com.rabbit.server;

import com.rabbit.model.APIModel;
import com.rabbit.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author junius
 * @date 2023/05/20 18:58
 * @project junius-rabbit
 **/

public interface CategoriesServer {
    public APIModel<Category> getAllCategories();
}
