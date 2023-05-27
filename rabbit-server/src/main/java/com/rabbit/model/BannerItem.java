package com.rabbit.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author junius
 * @date 2023/05/27 14:28
 * @project rabbit-server
 **/
@Data
@ToString
@TableName("banneritem")
public class BannerItem {
    /**
     * 轮播图跳转链接
     */
    @TableField("hrefUrl")
    private String hrefUrl;
    /**
     * 轮播图id
     */
    @TableField("id")
    private String id;
    /**
     * 轮播图地址
     */
    @TableField("imgUrl")
    private String imgUrl;
    /**
     * 轮播图跳转类型，跳转类型: 1、页面2、H5 3、小程序（小程序使用）
     */
    @TableField("type")
    private String type;

}
