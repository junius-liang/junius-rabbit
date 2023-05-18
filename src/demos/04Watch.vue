<script setup>
// watch函数的作用：侦听一个或多个数据的变化，数据变化时执行回调函数
// 额外参数：immediate(立即执行) deep(深度侦听)
import {ref, watch} from "vue";

const count = ref(0);
const addCount = ()=>{
  count.value++
}
const count1 = ref(0);
const count2 = ref(0);
const addCount1 = ()=>{
  count1.value++
  count2.value++
}
//监听单个数据的变化
watch(count,(newVal,oldVal)=>{
  console.log("count变化了",newVal,oldVal)
},{
  //立即触发并侦听以后每次触发
  immediate:true,
  //深度监听
  deep:true
})
//侦听多个数据的变化
watch([count1,count2],([newVal1,newVal2],[oldVal1,oldVal2])=>{
  console.log("count变化了",newVal1,newVal2,oldVal1,oldVal2)
})
//精切侦听
// const obj1 = ref({
//   name:'zhangsan',
//   age:18
// })
// watch(()=>obj1.age,()=>{
//   console.log(obj1)
// })

</script>
<template>
  <button @click="addCount">{{count}}</button>
  <br/>
  <button @click="addCount1">{{count1}}--{{count2}}</button>

</template>
<style scoped>

</style>
