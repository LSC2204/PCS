// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuebar from 'vuebar'
import ElementUI from 'element-ui'
import VueClock from '@dangvanthanh/vue-clock'
import 'normalize.css/normalize.css'
import 'nprogress/nprogress.css'
import '@/assets/styles/index.less'
import '@/assets/styles/element-ui.less'
import App from './App'
import '@/assets/iconfont-default'
import router from './router/'
import store from './store/'

Vue.use(Vuebar)
Vue.use(ElementUI)
Vue.use(VueClock)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
