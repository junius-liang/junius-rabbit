<template>
  <div></div>
</template>
<script setup>
import { ref} from "vue";
const aa = ref('aa...........')
const bb = () => {
  console.log('bb')
}
//组件内部的属性与方法不允许给父组件访问，因此需要通过defineExpose指定
defineExpose({aa,bb})
</script>
<style scoped>

</style>
