<template>
  <suncaper-layout
    theme="dark"
    :logo="logo"
    :sidebar-list="sidebarList"
    :logout="logout"
  />
</template>

<script>
import {mapGetters} from 'vuex'
import Layout from '@/layouts/Layout'
import logo from '@/assets/images/logo.png'

export default {
  name: 'Main',
  data () {
    return {
      logo: {
        src: logo,
        alt: '上程数据',
        firstDes: '心理咨询系统',
        secondDes: '第29组'
      }
    }
  },
  computed: {
    ...mapGetters({
      userType: 'user/getUserType',
      getSidebarList: 'sidebar/getSidebarList'
    }),
    sidebarList () {
      return this.getSidebarList(this.userType).main
    }
  },
  methods: {
    logout () {
      (errMsg) => http.GET('/api/user/getcur', {}, errMsg)
      this.$router.push({name: 'login'})
    }
  },
  components: {
    'suncaper-layout': Layout
  }
}
</script>
