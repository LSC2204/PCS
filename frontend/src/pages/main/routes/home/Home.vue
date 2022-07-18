<template>
  <div class="home-wrapper">
    <div class="date-row">
      <div v-for="(item, index) in LinksData" :key="index" class="data-col" >
        <a :href="item.path" style="text-decoration:none">
        <el-card shadow="always" :body-style="{padding: '0px'}">
          <div class="date-block">
            <i :class="[ item.icon ]" :style="{ background: item.color }" class="icon-box" />
            <p style="margin:0 auto;font-size: 20px;" class="title">{{ item.pathName }}</p>
          </div>
        </el-card>
        </a>
      </div>
    </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'


export default {
  name: 'Home',
  data() {
    return {
      text: '用户访问来源',
      title: '近七天用户访问量条形图',




          timer: null,
    nowWeek: "",
    nowDate: "",
    nowTime: "",
      cardInfoData: [
        { title: '今日点击', icon: 'vue-dsn-icon-dianji', count: 682, color: '#2d8cf0' },
        { title: '新增用户', icon: 'vue-dsn-icon-xinzeng', count: 259, color: '#19be6b' },
        { title: '信息发送', icon: 'vue-dsn-icon-xinfeng', count: 1262, color: '#ff9900' },
        { title: '点赞统计', icon: 'vue-dsn-icon-dianzan', count: 508, color: '#e46cbb' },
        { title: '累计收藏', icon: 'vue-dsn-icon-heart', count: 379, color: '#9a66e4' }
      ],


    }
  },
  methods:{
    getWeekByDate(myDate){
        let wk = myDate.getDay()
        let yy = String(myDate.getFullYear())
        let mm = myDate.getMonth() + 1
        let dd = String(myDate.getDate() < 10 ? '0' + myDate.getDate() : myDate.getDate())
        let hou = String(myDate.getHours() < 10 ? '0' + myDate.getHours() : myDate.getHours())
        let min = String(myDate.getMinutes() < 10 ? '0' + myDate.getMinutes() : myDate.getMinutes())
        let sec = String(myDate.getSeconds() < 10 ? '0' + myDate.getSeconds() : myDate.getSeconds())
        let weeks = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六']
        let week = weeks[wk]
        this.nowDate = yy + '年' + mm + '月' + dd + '日'
        this.nowTime = hou + ':' + min + ':' + sec
        console.log("今天时间为："+week)
    }
  },
  mounted(){
        
  },

  computed: {
    ...mapGetters({
      userType: 'user/getUserType',
      getLinksData: 'home/getLinksData'
    }),
    LinksData(){
      return this.getLinksData(this.userType)
    },
}
}
</script>

<style lang="less">
@import "../../../../assets/less/home";
</style>
