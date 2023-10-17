import App from './App'
// #ifndef VUE3
import Vue from 'vue'
import './uni.promisify.adaptor'
import TuniaoUI from 'tuniao-ui'
Vue.use(TuniaoUI)
import store from './store'
let vuexStore = require('@/store/$tn.mixin.js')
Vue.mixin(vuexStore)

Vue.config.productionTip = false
App.mpType = 'app'
const app = new Vue({
 store,
  ...App
})
app.$mount()
// #endif

// #ifdef VUE3
import { createSSRApp } from 'vue'
export function createApp() {
  const app = createSSRApp(App)
  return {
    app
  }
}
// #endif