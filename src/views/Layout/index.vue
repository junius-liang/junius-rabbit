<script setup>
import LayoutNav from './components/Layoutnav.vue'
import LayoutHeader from './components/LayoutHeader.vue'
import LayoutFooter from './components/LayoutFooter.vue'
import LayoutFix from './components/LayoutFix.vue'
import {useCategoryStore} from "@/stores/category";
import {onMounted} from "vue";
onMounted(()=>{
  const categoryStore = useCategoryStore();
  categoryStore.getallCategory();
})
</script>

<template>
  <LayoutFix/>
  <LayoutNav />
  <LayoutHeader />
  <RouterView />
  <LayoutFooter />
</template>

<style>
</style>
