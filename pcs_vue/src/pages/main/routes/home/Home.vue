<template>
  <div class="home-wrapper">
    <div style="margin:50px 0px"></div>
    <el-row>
      
      <el-col :span="6" :offset="5">
        <flip-clock />
      </el-col>  
    </el-row>
    <div style="margin:100px 0px"></div>
    <!-- <div class="date-row">
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

    </div> -->
      <el-row :gutter="20" style="margin:0 55px">
        <el-col :span="8">
          <el-carousel height="400px">
            <el-carousel-item v-for="item in images" :key="item">
              <img style="width:auto; height:auto; max-width:100%; max-height:100%;" :src="item" alt="">
            </el-carousel-item>
          </el-carousel>
        </el-col>
        <el-col :span="16" >
          <el-card shadow="always" style="height:380px;overflow-y:auto">
              <div slot="header" class="clearfix">
                <span>公告栏</span>
                <el-button v-if="userType==1" style="float: right; padding: 6px 15px;margin:0 20px" type="primary" @click="dialogVisible=true">增加公告</el-button>
              </div>
              <el-collapse v-model="activeName" accordion>
                <el-collapse-item v-for="(item,index) in boardData" 
                  :title="item.time+'　　　'+item.title" 
                  :name="index" 
                  :key="index">
                  <template slot="title">
                    <p style="font-size:15px">{{item.time+'　　　'+item.title}}</p>
                  </template>
                  
                  <div style="margin-left:20px">{{item.content}}</div>
                  <div>
                    <el-button v-if="userType==1" style="float: right; padding: 6px 15px;margin:5px 20px" type="primary" @click="changeBoard(item.title,item.content,item.boardId,item.time)">修改</el-button>
                    <el-button v-if="userType==1" style="float: right; padding: 6px 15px;margin:5px 20px" type="danger" @click="deleteBoard(item.boardId)">删除</el-button>
                  </div>
                </el-collapse-item>
            </el-collapse>
          </el-card>
        </el-col>
      </el-row>

    <el-dialog
            title="增加公告"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
        <el-form :model="addForm">
            <el-form-item label="公告标题" prop="title" >
                    <el-input v-model="addForm.title" placeholder="输入标题">
                    </el-input>
            </el-form-item>
            <el-form-item label="公告内容" prop="content" >
                    <el-input v-model="addForm.content" type="textarea" :rows="3" placeholder="输入内容">
                    </el-input>
            </el-form-item>

        </el-form>
        <span slot="footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="addBoard">确认</el-button>
        </span>
    </el-dialog>


    <el-dialog
            title="修改公告"
            :visible.sync="dialogVisible2"
            width="30%"
            :before-close="handleClose">
        <el-form :model="changeForm">
            <el-form-item label="公告标题" prop="title" >
                    <el-input v-model="changeForm.title" placeholder="输入标题">
                    </el-input>
            </el-form-item>
            <el-form-item label="公告内容" prop="content" >
                    <el-input v-model="changeForm.content" type="textarea" :rows="3" placeholder="输入内容">
                    </el-input>
            </el-form-item>

        </el-form>
        <span slot="footer">
          <el-button @click="dialogVisible2 = false">取 消</el-button>
          <el-button type="primary" @click="submitChange">确认</el-button>
        </span>
    </el-dialog>
  </div>
</template>

<script>
//
import {mapGetters} from 'vuex'
import FlipClock from 'kuan-vue-flip-clock'
import {get_board,change_board,delete_board,add_board} from "@api/board"
export default {
  name: 'Home',
  components:{FlipClock},
  data() {
    return {

    nowWeek: "",
    nowDate: "",
    nowTime: "",
    activeName: '1',
    boardData:[],
    dialogVisible: false,
    dialogVisible2: false,
    addForm:{
      title:"",
      content:"",
      id:""
    },
    changeForm:{
      title:"",
      content:"",
      boardId:"",
      time:""
    },
    images:[
      require("@/assets/images/i1.png"),
      require("@/assets/images/i2.png"),
      require("@/assets/images/i3.png"),
      require("@/assets/images/i4.png"),
      require("@/assets/images/i5.png"),
      require("@/assets/images/i6.png"),
    ]
    }
  },
  created(){
    this.getAllBoard()
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
    },
    getAllBoard(){
      get_board().then(res=>{
          this.boardData=res.data
      })

    },
    makeTitle(title,time){
      return item.title+'　　　　　　　'+item.time
    },
    addBoard(){
      let f={
        content:this.addForm.content,
        title:this.addForm.title,
        image:""
      }
      add_board(f)
      setTimeout(() => {
        location.reload()
      }, 1000);
    },
    deleteBoard(id){
      delete_board(id)
      setTimeout(() => {
        location.reload()
      }, 1000);
    },
    changeBoard(title,content,boardId,time){
      this.changeForm.title=title
      this.changeForm.content=content
      this.changeForm.boardId=boardId
      this.changeForm.time=time
      this.dialogVisible2 = true
    },
    submitChange(){
      let f={
        content:this.changeForm.content,
        title:this.changeForm.title,
        image:"",
        time:this.changeForm.time,
        board_id:this.changeForm.boardId
      }
      change_board(f)
    }
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
