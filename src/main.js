import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'
import '@/styles/common.scss'
//引入并注册懒加载插件
import {lazyPlugin} from "@/directives";
const app = createApp(App)
app.use(createPinia())
app.use(router)
app.use(lazyPlugin)

app.mount('#app')
