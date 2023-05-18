<script setup>
//父组件中仍然使用属性绑定：
//<子组件标签 自定义属性名称=自定义属性值></子组件标签>
//子组件通过defineProps接收子组件传递的数据
//const props = defineProps({自定义属性名称:自定义属性类型})
import Son from "./Son.vue";
</script>

<template>
  <div class="father">
    <Son message="Hello Vue3"></Son>
  </div>
</template>
<style scoped>

</style>
