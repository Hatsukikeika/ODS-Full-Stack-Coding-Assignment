import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import locale from 'element-ui/lib/locale'
import en from 'element-ui/lib/locale/lang/en'

Vue.use(VueRouter)

locale.use(en)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  }
]

const router = new VueRouter({
  routes
})

export default router
