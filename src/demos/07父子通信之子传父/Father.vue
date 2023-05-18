<script setup>

//子传父使用自定义事件
import Son from "@/Son.vue";
const sendMsg = (message)=>{
  console.log(message)
}
</script>
<template>
  <Son @sendMessage="sendMsg"/>
</template>
<style scoped>

</style>
