<template>
<div>
    <Hints>
      <template slot="hintName">预约注意事项：</template>
      <template slot="hintInfo">
           <p>由于咨询师对于一个用户的咨询时间并不固定，因此采用挂号预约制度。</p>
    <p>为了保证用户的体验，我们只允许用户进行一周之内的预约行为</p>
      </template>
    </Hints>


    <el-dialog
            title="心里测评分析"
            :visible.sync="dialogVisible"
            width="40%"
            :before-close="handleClose">
        <el-form >
            <el-form-item label="01.觉得手上工作太多，无法应对" >
                <el-select  @change="add_score1()" placeholder="请选择状况" v-model="choice1">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="02.觉得时间不够用，所以要分秒必争" >
                <el-select  @change="add_score2()" placeholder="请选择状况" v-model="choice2">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="03.觉着没有时间休闲，终日记挂着工作" >
                <el-select  @change="add_score3()" placeholder="请选择状况" v-model="choice3">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="04.遇到挫折时很容易发脾气" >
                <el-select  @change="add_score4()" placeholder="请选择状况" v-model="choice4">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="05.担心别人对自己的工作表现的评价" >
                <el-select  @change="add_score5()" placeholder="请选择状况" v-model="choice5">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="06.觉着上司、家人都不欣赏自己" >
                <el-select  @change="add_score6()" placeholder="请选择状况" v-model="choice6">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="07.担心自己的经济状况" >
                <el-select  @change="add_score7()" placeholder="请选择状况" v-model="choice7">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="08.有头疼、胃疼的毛病，难以治愈" >
                <el-select  @change="add_score8()" placeholder="请选择状况" v-model="choice8">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="09.需要借助烟酒、药物、零食等抑制不安的情绪" >
            <el-select  @change="add_score9()" placeholder="请选择状况" v-model="choice9">
                <el-option label="从未发生" value="从未发生"></el-option>
                <el-option label="偶尔发生" value="偶尔发生"></el-option>
                <el-option label="经常发生" value="经常发生"></el-option>
            </el-select>
        </el-form-item>
            <el-form-item label="10.需要借助安眠药帮助自己入睡" >
            <el-select  @change="add_score10()" placeholder="请选择状况" v-model="choice10">
                <el-option label="从未发生" value="从未发生"></el-option>
                <el-option label="偶尔发生" value="偶尔发生"></el-option>
                <el-option label="经常发生" value="经常发生"></el-option>
            </el-select>
        </el-form-item>
            <el-form-item label="11.与家人、朋友、同时的相处中常发脾气" >
            <el-select  @change="add_score11()" placeholder="请选择状况" v-model="choice11">
                <el-option label="从未发生" value="从未发生"></el-option>
                <el-option label="偶尔发生" value="偶尔发生"></el-option>
                <el-option label="经常发生" value="经常发生"></el-option>
            </el-select>
        </el-form-item>
            <el-form-item label="12.与人清谈时，常打断对方的话题" >
            <el-select  @change="add_score12()" placeholder="请选择状况" v-model="choice12">
                <el-option label="从未发生" value="从未发生"></el-option>
                <el-option label="偶尔发生" value="偶尔发生"></el-option>
                <el-option label="经常发生" value="经常发生"></el-option>
            </el-select>
        </el-form-item>
            <el-form-item label="13.上床后思潮起伏，牵挂很多事情，难以入睡" >
            <el-select  @change="add_score13()" placeholder="请选择状况" v-model="choice13">
                <el-option label="从未发生" value="从未发生"></el-option>
                <el-option label="偶尔发生" value="偶尔发生"></el-option>
                <el-option label="经常发生" value="经常发生"></el-option>
            </el-select>
        </el-form-item>
            <el-form-item label="14.觉得工作太多，不能每件事都做到尽善尽美" >
                <el-select  @change="add_score14()" placeholder="请选择状况" v-model="choice14">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="15.空闲时轻松一下也会内疚" >
                <el-select  @change="add_score15()" placeholder="请选择状况" v-model="choice15">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="16.做事急躁、任性，事后常感到内疚" >
                <el-select  @change="add_score16()" placeholder="请选择状况" v-model="choice16">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="17.觉得自己不应该享乐" >
                <el-select  @change="add_score17()" placeholder="请选择状况" v-model="choice17">
                    <el-option label="从未发生" value="从未发生"></el-option>
                    <el-option label="偶尔发生" value="偶尔发生"></el-option>
                    <el-option label="经常发生" value="经常发生"></el-option>
                </el-select>
            </el-form-item>

        </el-form>
        <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="get_score()">测评分数</el-button>
      </span>
    </el-dialog>


    <p></p>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item>
        </el-form-item>

        <el-form-item style="width:400px" label="测评分数" prop="score">
            <el-input v-model="score_res" clearable></el-input>
            <el-button type="primary" plain @click="jump()">立即测评</el-button>
        </el-form-item>

        <el-form-item label="选择测评日期" prop="time">
            <div style="width:800px">
                <!-- <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox> -->
                <div style="margin: 15px 0;"></div>
                <el-checkbox-group v-model="checkedTimes" @change="handleCheckedCityChange">

                    <el-checkbox v-for="time in weekitemList" :label="time" :key="time"><div style="margin: 5px 0;"></div>{{time}}</el-checkbox>
                </el-checkbox-group>
            </div>
        </el-form-item>
<!--        <el-form-item label="期望时间段" prop="time">-->
<!--            <el-select v-model="ruleForm.time" placeholder="请选择时间">-->
<!--                <el-option label="星期一上午" value="mon_m"></el-option>-->
<!--                <el-option label="星期一下午" value="mon_a"></el-option>-->
<!--                <el-option label="星期二上午" value="tue_m"></el-option>-->
<!--                <el-option label="星期二下午" value="tue_a"></el-option>-->
<!--                <el-option label="星期三上午" value="wed_m"></el-option>-->
<!--                <el-option label="星期三下午" value="wed_a"></el-option>-->
<!--                <el-option label="星期四上午" value="the_m"></el-option>-->
<!--                <el-option label="星期四下午" value="the_a"></el-option>-->
<!--                <el-option label="星期五上午" value="fri_m"></el-option>-->
<!--                <el-option label="星期五下午" value="fri_a"></el-option>-->
<!--                <el-option label="星期六上午" value="sta_m"></el-option>-->
<!--                <el-option label="星期六下午" value="sta_a"></el-option>-->
<!--                <el-option label="星期日上午" value="sun_m"></el-option>-->
<!--                <el-option label="星期日下午" value="sun_a"></el-option>-->
<!--            </el-select>-->
<!--        </el-form-item>-->
    <Hints v-if="!is_first">
      <template slot="hintName">您需要进行初访，此次预约无法选择咨询师</template>
    </Hints>
        <el-form-item label="选择咨询师" prop="teacher">

            <el-select :disabled="!is_first" v-model="ruleForm.teacher" placeholder="请选择教师">
                <el-option :key="index" v-for="(t_name,index) in tea_name"  :value="t_name">{{t_name}}</el-option>
            </el-select>
        </el-form-item>

        <el-form-item style="width:1200px" label="备注" prop="desc">
            <el-input type="textarea" v-model="ruleForm.desc"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import {submit_reserve,getUserInfo} from '../../../../api/user'
  import {teacher_name} from '@api/teacher_inf'
  import Hints from '@/components/Hints'
  const timeChinese = ["星期天上午","星期天下午","星期一上午","星期一下午","星期二上午","星期二下午","星期三上午","星期三下午","星期四上午","星期四下午","星期五上午","星期五下午","星期六上午","星期六下午"]
  //如果可以的话，建议设置当天的按钮是灰色
  //或者直接说说明当天的时间预约将会被认定为下一周
  const timeOptions = ["sun_m","sun_a",'mon_m', 'mon_a', 'tue_m', 'tue_a',"wed_m","wed_a","thu_m","thu_a","fri_m","fri_a","sat_m","sat_a"];

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
        score_t:0,
        score_res:0,
        choice1:'', choice2:'', choice3:'', choice4:'', choice5:'', choice6:'', choice7:'', choice8:'', choice9:'', choice10:'',
        choice11:'', choice12:'', choice13:'', choice14:'', choice15:'', choice16:'', choice17:'',
        tea_name:[],
        is_first:null,
        rules: {


        },
        checkAll: false,
        dialogVisible: false,
        checkedTimes: [],
        times: timeChinese,
        isIndeterminate: true,
        assemble:""
      };
    },

    created(){
      this.teacher_name()
      getUserInfo().then(res => {
          console.info("hi")
          console.info(res.data)
          console.info("hi")
        this.is_first=!res.data.isfirst
      this.wk=new Date().getDay()
    })
    userInfo.role=this.getRoleName
    },
    methods: {
      add_score1(){
          if(this.choice1=='从未发生'){
            this.score_t+=0
          }else if(this.choice1=='偶尔发生'){
            this.score_t+=3
          }else if(this.choice1=='经常发生'){
            this.score_t+=6
          }
          if(this.score_t>100){
            this.score=100
          }
      },
      add_score2(){
        if(this.choice2=='从未发生'){
          this.score_t+=0
        }else if(this.choice2=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice2=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score3(){
        if(this.choice3=='从未发生'){
          this.score_t+=0
        }else if(this.choice3=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice3=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score4(){
        if(this.choice4=='从未发生'){
          this.score_t+=0
        }else if(this.choice4=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice4=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score5(){
        if(this.choice5=='从未发生'){
          this.score_t+=0
        }else if(this.choice5=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice5=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score6(){
        if(this.choice6=='从未发生'){
          this.score_t+=0
        }else if(this.choice6=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice6=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score7(){
        if(this.choice7=='从未发生'){
          this.score_t+=0
        }else if(this.choice7=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice7=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score8(){
        if(this.choice8=='从未发生'){
          this.score_t+=0
        }else if(this.choice8=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice8=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score9(){
        if(this.choice9=='从未发生'){
          this.score_t+=0
        }else if(this.choice9=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice9=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score10(){
        if(this.choice10=='从未发生'){
          this.score_t+=0
        }else if(this.choice10=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice10=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score11(){
        if(this.choice11=='从未发生'){
          this.score_t+=0
        }else if(this.choice11=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice11=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score12(){
        if(this.choice12=='从未发生'){
          this.score_t+=0
        }else if(this.choice12=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice12=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score13(){
        if(this.choice13=='从未发生'){
          this.score_t+=0
        }else if(this.choice13=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice13=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score14(){
        if(this.choice14=='从未发生'){
          this.score_t+=0
        }else if(this.choice14=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice14=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score15(){
        if(this.choice15=='从未发生'){
          this.score_t+=0
        }else if(this.choice15=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice15=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score16(){
        if(this.choice16=='从未发生'){
          this.score_t+=0
        }else if(this.choice16=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice16=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },
      add_score17(){
        if(this.choice17=='从未发生'){
          this.score_t+=0
        }else if(this.choice17=='偶尔发生'){
          this.score_t+=3
        }else if(this.choice17=='经常发生'){
          this.score_t+=6
        }
        if(this.score_t>100){
          this.score=100
        }
      },

      get_score(){
        this.score_res=this.score_t
        this.dialogVisible=false
      },
      jump(){
        this.dialogVisible=true
      },
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
              userId:this.$store.state.user.id,
                userName:this.$store.state.user.name,
              score:this.score_t,
              time:this.assemble,
              teacherName:this.ruleForm.teacher,
              reviewRemarks:this.ruleForm.desc
            }
              console.info("hi")
              console.info(res_inf)

              console.info("hi")
            submit_reserve(res_inf)
          } else {
            console.log('提交失败');
            return false;
          }
        });
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
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
    }

    },
    computed: {
      weekitemList: function() {
          return this.times.filter((item,index) => {
            return parseInt(index/2)!=this.wk;
          })
        }
      }

  }
</script>

<style scoped>

</style>
