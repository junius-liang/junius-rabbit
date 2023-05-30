import httpInstant from "@/apis/http";
//获取新鲜好物
//TODO
export const findNewAPI = () => {
    return httpInstant({
        url:'/home/new',
        method:'get'
    })
}
