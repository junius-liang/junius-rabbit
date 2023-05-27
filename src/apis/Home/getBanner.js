import httpInstant from "@/apis/http";
//获取轮播图数据
export function getBannerData(){
    return httpInstant({
        url:'/home/banner',
        method:'get'
    })
}

