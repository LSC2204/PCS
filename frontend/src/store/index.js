import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user/'
import role from './modules/role/'
import sidebar from './modules/sidebar/'
import permission from './modules/permission/'
import routecache from './modules/routecache'
import home from "./modules/home/"
Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

export default new Vuex.Store({
  modules: {
    user,
    role,
    sidebar,
    permission,
    routecache,
    home
  },
  strict: debug
})
