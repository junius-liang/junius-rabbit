import httpInstant from "@/apis/http";
/**
 * @description: 获取人气推荐
 * @return {*}
 */
//TODO
export const getHotAPI = () => {
    return httpInstant({
        url:'home/hot',
        method:'get',
        params:{}
    })
}
