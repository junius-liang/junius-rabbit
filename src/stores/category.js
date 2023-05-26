import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import {getAllCategory} from "@/apis/Layout";

export const useCategoryStore = defineStore('categoryStore', () => {
    const categoryListStore = ref([])
    const getallCategory = async ()=>{
        const res = await getAllCategory()
        categoryListStore.value=res.data.result
    }
    return { categoryListStore, getallCategory}
})
