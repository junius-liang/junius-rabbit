<template>
  <button @click="changeCount">{{count}}</button>
  <br/>
  <div>{{addCount}}</div>
</template>
<script setup>
import {computed,ref} from "vue";
const count = ref(1);
const addCount = computed(()=>{
  let res = (count.value+1)*2;
  return res;
})
const changeCount = ()=>{
  count.value++;
}
</script>
<style scoped>

</style>
