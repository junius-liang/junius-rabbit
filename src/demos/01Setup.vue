<script setup lang="ts">
import {ref} from "vue";
const count = ref(1);
const addCount = ()=>{
  count.value++;
}
</script>

<template>
  <div @click="addCount">{{count}}</div>
</template>

<style scoped>

</style>
