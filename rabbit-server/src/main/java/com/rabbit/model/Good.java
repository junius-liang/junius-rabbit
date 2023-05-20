package com.rabbit.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author junius
 * @date 2023/05/20 13:58
 * @project junius-rabbit
 **/
@TableName("good")
@Data
public class Good {
    /**
     * 商品描述
     */
    @TableField("desca")
    private String desca;
    /**
     * 商品折扣，如为null时，即无折扣
     */
    @TableField("discount")
    private Object discount;
    /**
     * 商品id
     */
    @TableField("id")
    private String id;
    /**
     * 商品名字
     */
    @TableField("name")
    private String name;
    /**
     * 商品销量
     */
    @TableField("orderNum")
    private Object orderNum;
    /**
     * 商品图片
     */
    @TableField("picture")
    private String picture;
    /**
     * 商品价格
     */
    @TableField("price")
    private String price;

    @TableField("categoryId")
    private String categoryId;


}
