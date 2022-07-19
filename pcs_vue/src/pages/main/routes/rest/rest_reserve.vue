<template>
<div>
    <Hints>
      <template slot="hintName">请假注意事项：</template>
      <template slot="hintInfo">
        <p>咨询师可以通过该页面进行请假申请，交由管理员审核</p>
        <p>只允许咨询师进行一周之内的请假申请行为，而且不能当天请假</p>
        <p>若请假当天有预约，则无法进行请假预约（不显示选框）</p>
        <p>如果有特殊情况，请和管理员进行联系</p>
      </template>
    </Hints>


    <p></p>
    <el-form :model="restData" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item>
        </el-form-item>
        <el-form-item label="请假日期" prop="time_select">
            <div style="width:800px">
                <el-radio-group v-model="restData.noteTime" >
                  <el-radio v-for="(time,index) in weekitemList" :label="time.eng" :key="index" style="margin-top:10px" >
                  {{time.zh}}
                  </el-radio>
              
              </el-radio-group>
                <!-- <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox> -->
                
            </div>
        </el-form-item>


        <el-form-item style="width:1200px" label="请假理由" prop="desc">
            <el-input type="textarea" v-model="restData.noteReason"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitRestForm">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import {submit_reserve,getUserInfo} from '../../../../api/user'
  import {teacher_name} from '@api/teacher_inf'
  import Hints from '@/components/Hints'
  import {getSpareTime,sendRestRequest} from "@api/rest"
  const timeChinese = ["星期天上午","星期天下午","星期一上午","星期一下午","星期二上午","星期二下午","星期三上午","星期三下午","星期四上午","星期四下午","星期五上午","星期五下午","星期六上午","星期六下午"]
  //如果可以的话，建议设置当天的按钮是灰色
  //或者直接说说明当天的时间预约将会被认定为下一周
  const timeOptions = ["sun_m","sun_a",'mon_m', 'mon_a', 'tue_m', 'tue_a',"wed_m","wed_a","thu_m","thu_a","fri_m","fri_a","sat_m","sat_a"];
  const timeOptions2 = ["sunM","sunA",'monM', 'monA', 'tueM', 'tueA',"wedM","wedA","thuM","thuA","friM","friA","satM","satA"];
  const timeMap=[
    {
      zh:"星期天上午",
      eng:"sun_m"
    },
        {
      zh:"星期天下午",
      eng:"sun_a"
    },    {
      zh:"星期一上午",
      eng:"mon_m"
    },    {
      zh:"星期一下午",
      eng:"mon_a"
    },    {
      zh:"星期二上午",
      eng:"tue_m"
    },    {
      zh:"星期二下午",
      eng:"tue_a"
    },    {
      zh:"星期三上午",
      eng:"wed_m"
    },    {
      zh:"星期三下午",
      eng:"wed_a"
    },    {
      zh:"星期四上午",
      eng:"thu_m"
    },{
      zh:"星期四下午",
      eng:"thu_a"
    },{
      zh:"星期五上午",
      eng:"fri_m"
    },{
      zh:"星期五下午",
      eng:"fri_a"
    },{
      zh:"星期六上午",
      eng:"sat_m"
    },{
      zh:"星期六下午",
      eng:"sat_a"
    }
  ]
  export default {
    components: {Hints },
    data() {
      return {
        ruleForm: {
          name: '',
          time:'',
          score:'',
          desc: '',
          teacher:'',
          date:[]
        },
        wk:null,
        tea_name:[],
        is_first:null,
        rules: {
          time_select:[{ required: true, message: '请输入请假时间', trigger: 'blur' }],
          desc: [
            { required: true, message: '请输入请假理由', trigger: 'blur' }
          ],
        },
        checkAll: false,
        checkedTimes: [],
        times: timeChinese,
        isIndeterminate: true,
        assemble:"",
        spareTimeData:{},
        spareTimeArray:[],
        restData:{
          noteReason:null,
          noteTime:null
        }
      };
    },

    created(){
      getSpareTime().then(res=>{
          console.log(res)
          this.spareTimeData=res.data[0]
        })
      getUserInfo().then(res => {
        this.is_first=res.data.isfirst
      this.wk=new Date().getDay()
    })
    userInfo.role=this.getRoleName
    },
    methods: {
      handleCheckAllChange(val) {
        this.checkedTimes = val ? timeOptions : [];
        this.isIndeterminate = false;
      },
      handleCheckedCityChange(value) {
        let checkedCount = value.length;
        this.checkAll = checkedCount === this.times.length;
        this.isIndeterminate = checkedCount > 0 && checkedCount < this.times.length;
      },
      timeAssemble(){
        this.assemble=""
        for(let i=0;i<this.checkedTimes.length;i++){
          this.assemble+=this.checkedTimes[i]

          if (i!=this.checkedTimes.length-1){
            this.assemble+=';'
          }
        }
      },
      teacher_name(){
        teacher_name({}).then(res=>{
          console.info(res)
          this.tea_name=res.data
        })
      },
      submitForm(formName) {
        this.timeAssemble()

        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('提交成功');
            let res_inf={
              userId:this.ruleForm.name,
              score:this.ruleForm.score,
              time:this.assemble,
              teacherName:this.ruleForm.teacher,
              reviewRemarks:this.ruleForm.desc
            }
            console.info(res_inf)
            submit_reserve(res_inf)
          } else {
            console.log('提交失败');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
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
        return wk
    },
    submitRestForm(){
      sendRestRequest(this.restData)
      setTimeout(()=>{
        this.$router.push({name:"main"})
      },1000)
      
    }

    },
    computed: {
      weekitemList: function() {
        //需要把这个index和得到的某天的时间进行对应起来
        //index为0 1 说明周日 2 3周一
          return timeMap.filter((item,index) => {
            // console.log()
            // console.log()
            // return parseInt(index/2)!=this.wk && this.spareTimeData[this.timeOptions2[index]]>=3;
            return parseInt(index/2)!=this.wk && this.spareTimeData[timeOptions2[index]]>=3
          })
        }
      }

  }
</script>

<style scoped>

</style>
