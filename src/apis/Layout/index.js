import httpInstant from "@/apis/http";
//获取-全部分类(包含推荐商品)
export function getAllCategory(){
    return httpInstant({
        url:'/home/category/head',
        method:'get'
    })
}

