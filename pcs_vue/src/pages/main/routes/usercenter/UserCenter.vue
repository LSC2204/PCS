<template>
  <div class="user-center-wrapper clear-fix">
    <el-card shadow="always" :body-style="{padding: '50px'}">
      <div slot="header" class="clearfix">
        <span>用户信息页</span>
      </div>
      <!-- <div class="user-avatar">
        <img src="../assets/img/avatar.png" alt="avatar">
      </div> -->
      <el-row :gutter="50" style="margin-left:30%">
        <el-col :span="7">
          <label>用户名：</label>
          <span>{{ userInfo.username }}</span>
        </el-col>
        <el-col :span="7">
          <label>角色：</label>
          <span>{{ userInfo.role }}</span>
        </el-col>
      </el-row>
      <el-row :gutter="50" style="margin-left:30%;margin-top:30px">
        <el-col :span="7">
          <label>真实姓名：</label>
          <span>{{ userInfo.realName }}</span>
        </el-col>
        <el-col :span="7">
          <label>性别：</label>
          <span>{{ userInfo.sex }}</span>
        </el-col>
      </el-row>
      <el-row :gutter="50" style="margin-left:30%;margin-top:30px">
        <el-col :span="24">
          <label>生日：</label>
          <span>{{ userInfo.birthday }}</span>
        </el-col>
      </el-row>
      <el-row :gutter="50" style="margin-left:30%;margin-top:30px">
        <el-col :span="24">
          <label>地址：</label>
          <span>{{ userInfo.address }}</span>
        </el-col>
      </el-row>
      <el-row :gutter="50" style="margin-left:30%;margin-top:30px">
        <el-col :span="24">
          <label>电话号码：</label>
          <span>{{ userInfo.phone }}</span>
        </el-col>
      </el-row>
      <el-row :gutter="50" style="margin-left:30%;margin-top:30px">
        <el-col :span="24">
          <label>邮箱：</label>
          <span>{{ userInfo.email }}</span>
        </el-col>
      </el-row>
      <el-row :gutter="50" style="margin-left:30%;margin-top:30px">
        <el-col :span="7" style="margin-top:11px">
          <label>是否需要初访：</label>
          <span>{{ is_first }}</span>
        </el-col>
        <el-col :span="12">
                    <label>密码：</label>
          <span>{{ showPassword }}</span>
          <el-button style="margin-left:30px" icon="el-icon-view" circle @click="is_covered=!is_covered"></el-button>
          <el-button icon="el-icon-edit" circle @click="pwdFormVisible = true"></el-button>
  </el-col>

      </el-row>
      <el-button style="margin:10px 45%" type="primary" @click="basicFormVisible= true">基本信息修改</el-button>
      <!-- <ul class="user-info" style="list-style:none;margin-left:30%">
        <li>
          <label>用户名：</label>
          <span>{{ userInfo.username }}</span>
        </li>
        <li>
          <label>角色：</label>
          <span>{{ userInfo.role }}</span>
        </li>
        <li>
          <label>真实姓名：</label>
          <span>{{ userInfo.realName }}</span>
        </li>
        <li>
          <label>性别：</label>
          <span>{{ userInfo.sex }}</span>
        </li>
        <li>
          <label>生日：</label>
          <span>{{ userInfo.birthday }}</span>
        </li>
        <li>
          <label>地址：</label>
          <span>{{ userInfo.address }}</span>
        </li>
        <li>
          <label>电话号码：</label>
          <span>{{ userInfo.phone }}</span>
        </li>
        <li>
          <label>邮箱：</label>
          <span>{{ userInfo.email }}</span>
        </li>
        <li>
          <label>是否需要初访：</label>
          <span>{{ is_first }}</span>
        </li>

      <li><el-button style="margin:0px 120px" type="primary" @click="basicFormVisible= true">基本信息修改</el-button></li>
      </ul>
      <ul class="user-info" style="list-style:none;margin-left:30%">
                <li>
          <label>密码：</label>
          <span>{{ showPassword }}</span>
          <el-button style="margin-left:30px" icon="el-icon-view" circle @click="is_covered=!is_covered"></el-button>
          <el-button icon="el-icon-edit" circle @click="pwdFormVisible = true"></el-button>
        </li>
      </ul> -->

    </el-card>
          <el-dialog title="基本信息修改" :visible.sync="basicFormVisible">
          <el-form :model="form" :rules="rules">
            <el-form-item label="用户名" :label-width="formLabelWidth" >
              <el-input v-model="userInfo.username" autocomplete="off" disabled></el-input>
            </el-form-item>
            <el-form-item label="真实姓名" :label-width="formLabelWidth" >
              <el-input v-model="userInfo.realName" autocomplete="off" disabled></el-input>
            </el-form-item>
            <el-form-item label="性别" :label-width="formLabelWidth" >
              <el-input v-model="userInfo.sex" autocomplete="off" disabled></el-input>
            </el-form-item>
            <el-form-item label="生日" :label-width="formLabelWidth" >
                        <el-date-picker
                        v-model="userInfo.birthday"
                        type="date"
                        placeholder="选择日期">
                      </el-date-picker>
            </el-form-item>
            <el-form-item label="电话号码." :label-width="formLabelWidth" >
              <el-input v-model="userInfo.phone" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="地址" :label-width="formLabelWidth" >
              <el-input v-model="userInfo.address" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="电子邮箱" :label-width="formLabelWidth" >
              <el-input v-model="userInfo.email" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="basicFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="handleSubmitBasic">确 定</el-button>
          </div>
        </el-dialog>
    

        <el-dialog title="修改密码" :visible.sync="pwdFormVisible">
          <el-form :model="form" :rules="rules">
            <el-form-item label="原密码" :label-width="formLabelWidth" >
              <el-input v-model="userInfo.password" autocomplete="off" disabled ></el-input>
            </el-form-item>
            <el-form-item label="新密码" prop="password" :label-width="formLabelWidth">
              <el-input :placeholder="form.password" v-model="form.password" show-password></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="repassword" :label-width="formLabelWidth"> 
              <el-input :placeholder="form.repassword" v-model="form.repassword" show-password></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="pwdFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="handleSubmitPwd" :disabled="is_disabled">确 定</el-button>
          </div>
        </el-dialog>

  </div>
</template>

<script>
import {mapGetters} from 'vuex'
import { getUserInfo ,_getUserInfo,submitUserBasic,submitUserPwd} from '@/api/user'
export default {
  name: 'UserCenter',
  
  data() {


    var validatePass2 = (rule, value, callback) => {
        if (value === '') {
            callback(new Error('请再次输入密码'))
            // password 是表单上绑定的字段
          } else if (value !== this.form.password) {

            callback(new Error('两次输入密码不一致!'))
          } else {
            this.is_disabled=false
            callback()
          }
          
    }

    return {
      userInfo: {
        user_id:"",
        username:"",
        role:"",
        realName:"",
        sex:"",
        birthday:"",
        phone:"",
        email:"",
        is_first:"",
        password:null,
        address:null
      },
      is_disabled:true,
      is_covered:true,
      pwdFormVisible:false,
      basicFormVisible:false,
      form: {
          password: '',
          repassword: ''
        },
      formLabelWidth: '120px',
      info: {
          password: '',

      },
      rules:{
        password: [
          { required: true,message:"请输入密码" ,trigger: 'blur' }
        ],
        repassword: [
          { required: true, validator: validatePass2, trigger: 'change' }
        ]
      }

      }
  },
  mounted(){
    getUserInfo().then(res => {
      this.userInfo.user_id=res.data.id
      this.userInfo.username=res.data.name
      this.userInfo.realName=res.data.personName
      this.userInfo.sex=res.data.sex
      this.userInfo.birthday=res.data.birthday
      this.userInfo.phone=res.data.phoneNumber
      this.userInfo.is_first=res.data.isfirst
      this.userInfo.address=res.data.address
      console.log(this.userInfo)
    })
    _getUserInfo().then(res =>{
      this.userInfo.user_id=res.data.id;
      this.userInfo.email=res.data.email;
      this.userInfo.password=res.data.password;
    })
    this.userInfo.role=this.roleName
  
  },
  created() {

  },
  methods:{
    getCoveredPwd(pwd){
      let a="";
      
      for(let b=0;b<pwd.length;b++){
        a+="*";
      }
      return a;
    },

    handleSubmitPwd(){
      this.pwdFormVisible = false
      submitUserPwd(this.form,this.userInfo)
    },
    handleSubmitBasic(){
      this.pwdFormVisible = false
      submitUserBasic(this.userInfo)
      //修改成功后需要跳转页面，不考虑修改失败
      this.$router.push(route)
    }
  },
  computed: {
    ...mapGetters({
      userType: 'user/getUserType',
      getRoleName: 'role/getRoleName',
    }),
    roleName () {
      return this.getRoleName(this.userType)
    },
    is_first(){
      return this.userInfo.is_first?"否":"是"
    },
    showPassword(){
      return this.is_covered?this.getCoveredPwd(this.userInfo.password):this.userInfo.password
    }
  }
}


</script>

<style lang="less">
.user-center-wrapper {
  .user-avatar {
    float: left;
    width: 150px;
    height: 150px;
  }
  .user-info {
    float: left;
    width: 800px;
    margin-left: 50px;
    margin-bottom: 20px;
    li {
      height: 34px;
      line-height: 34px;
      label,
      span {
        display: inline-block;
        vertical-align: middle;
      }
      label {
        width: 120px;
        margin-right: 12px;
        text-align:right;
      }
    }
  }
}
</style>
