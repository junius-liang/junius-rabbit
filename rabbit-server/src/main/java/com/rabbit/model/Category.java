package com.rabbit.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @author junius
 * @date 2023/05/20 13:56
 * @project junius-rabbit
 **/
@TableName("category")
@Data
public class Category {

    /**
     * 分类下属商品
     */
    @TableField(exist = false)
    private List<Good> goods;
    /**
     * 分类id
     */
    @TableField("id")
    private String id;
    /**
     * 分类名字
     */
    @TableField("name")
    private String name;
    /**
     * 分类图片
     */
    @TableField("picture")
    private String picture;
    /**
     * 父级类目id
     * @return
     */
    @TableField("parentId")
    private String parentId;
    @TableField(exist = false)
    private List<Category> children;

}

