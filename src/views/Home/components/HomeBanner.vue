<script setup>
import {getBannerData} from "@/apis/Home/getBanner";
import {onMounted, ref} from "vue";
const bannerList = ref([]);
//获取轮播图数据
const getBanner = async ()=>{
  const res = await getBannerData()
  bannerList.value = res.data.result
  console.log(bannerList.value)
}
onMounted(()=>{
  getBanner()
})
</script>

<template>
  <div class="home-banner">
    <el-carousel height="500px">
      <el-carousel-item v-for="item in bannerList" :key="item.id">
        <img v-lazyload="item.imgUrl" alt="">
      </el-carousel-item>
    </el-carousel>
  </div>
</template>



<style scoped lang='scss'>
.home-banner {
  width: 1240px;
  height: 500px;
  position: absolute;
  left: 0;
  top: 0;
  z-index: 98;

  img {
    width: 100%;
    height: 500px;
  }
}
</style>
