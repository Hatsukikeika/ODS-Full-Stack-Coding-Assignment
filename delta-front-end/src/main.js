import Vue from 'vue'
import axios from 'axios'
import App from './App.vue'
import router from './router'
import './plugins/element.js'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

Vue.prototype.$axios = axios
Vue.prototype.$handleResError = function (res) {
  if (!res) this.$message.error('Connection Failed...')
  else this.$message.error(res.data.message)
}

axios.defaults.baseURL = 'http://localhost:80/api/v1/'
