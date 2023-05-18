<script setup>
//模板引用：通过ref标识获取真实dom对象或者组件实例对象
//1.调用ref函数生成一个ref对象
import {onMounted, ref} from "vue";
import Son from "@/demos/08模板引用/Son.vue";
const a = ref(null)
const b = ref(null)
onMounted(()=>{
  console.log(a.value)
  console.log(b.value)
  //调用bb
  b.value.bb()
})

</script>
<template>
  <!--  通过ref标识绑定ref对象-->
  <div ref="a">我是dom标签</div>
  <Son ref="b"/>
</template>
<style scoped>

</style>
