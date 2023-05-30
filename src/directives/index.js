//定义懒加载插件
import { useIntersectionObserver } from '@vueuse/core'
export const lazyPlugin = {
    install(app){
        app.directive('lazyload',{
            mounted(el,binding){
                const stop = useIntersectionObserver(
                    el,
                    ([{ isIntersecting }]) => {
                        el.src = binding.value
                        stop()
                    },
                )

            }
        })
    }
}
