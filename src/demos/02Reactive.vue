<script setup lang="ts">
import {reactive} from "vue";
const count = reactive({
  num:1
})
const addCount = ()=>{
  count.num++
}
</script>

<template>
  <button @click="addCount">{{count.num}}</button>
</template>

<style scoped>

</style>
