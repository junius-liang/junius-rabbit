<template>
  <button @click="send">点我</button>
</template>
<script setup>
//通过defineEmits编译器宏生成emit方法
 const emit = defineEmits(['sendMessage'])
 const send = ()=>{
   emit('sendMessage','Hello Vue3 and Ts')
 }
</script>
<style scoped>

</style>
