<template>
  <div class="register-wrapper" :style="'background-image:url('+ Background +')'">
    
    <div class="form-box">
      <div class="form-title">
        <!-- <img src="../assets/img/logo2.png" alt="icon"> -->
        <p style="font-size:30px">账 号 注 册</p>
      </div>
        <el-form ref="registerForm" :model="registerForm" :rules="registerRules">
            <el-row gutter="20">
            <el-col :span="12">
                <el-form-item label="用户id" prop="user_id">
                    <el-input v-model="registerForm.user_id" placeholder="用户id">
                    </el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">            
                <el-form-item label="用户真实姓名" prop="person_name">
                    <el-input v-model="registerForm.person_name" placeholder="用户名">
                    </el-input>
                </el-form-item>
            </el-col>
            </el-row >
            <el-row gutter="20">
            <el-col :span="12">
                <el-form-item label="密码" prop="password">
                    <el-input v-model="registerForm.password" placeholder="密码" show-password></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="确认密码" prop="repassword" placeholder="确认密码"> 
                  <el-input v-model="registerForm.repassword" show-password></el-input>
              </el-form-item>
            </el-col>
            </el-row>
            <el-row gutter="20">
            <el-col :span="12">
                <el-form-item label="生日" prop="birthday">
                        <el-date-picker
                        v-model="registerForm.birthday"
                        type="date"
                        placeholder="选择日期" value-format="yyyy-MM-dd">
                      </el-date-picker>
                </el-form-item>
            </el-col>
            <el-col :span="12">            
                <el-form-item label="性别" prop="sex">
                    <el-select v-model="registerForm.sex" placeholder="请选择" style="width:100%">
                        <el-option
                        v-for="(item,index) in [{value:'男'},{value:'女'}]"
                        :key="index"
                        :label="item.value"
                        :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-col>
            </el-row>
            <el-row gutter="20">
            <el-col :span="12">
                <el-form-item label="电话" prop="phone_number">
                    <el-input v-model="registerForm.phone_number" placeholder="电话"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">               
                <el-form-item label="邮箱" prop="email">
                    <el-input v-model="registerForm.email" placeholder="邮箱"></el-input>
                </el-form-item>
            </el-col>
            </el-row>
            <el-row>

                <el-col :span="4" :offset="5">
                    <el-button :loading="loading" size="large" type="primary" style="" @click="handleRegister">
                        <span>注册</span>
                    </el-button>
                </el-col>
                <el-col :span="4" :offset="8">                    
                    <el-button :loading="loading" size="large" type="primary" style="" @click="handleBack">
                        <span>返回</span>
                    </el-button></el-col> 
            </el-row>








        </el-form>
    </div>
  </div>
</template>

<script>
import { login } from '@api/user'
import Background from '../../assets/images/login-background.jpg'
import {user_inf,tea_inf,create,first_inf} from '@api/user'
export default {
  data() {

    var validatePass2 = (rule, value, callback) => {
        if (value === '') {
            callback(new Error('请再次输入密码'))
            // password 是表单上绑定的字段
          } else if (value !== this.registerForm.password) {

            callback(new Error('两次输入密码不一致!'))
          } else {
            this.is_disabled=false
            callback()
          }
    }
    return {
      Background,
      registerForm: {
        user_id:'',
        password:'',
        email:'',
        person_name:'',
        birthday:'',
        sex:'',
        phone_number:'',
        address:'',
      },
      registerRules: {
        user_id: [{ required: true, trigger: 'blur', message: '用户账号不能为空' }],
        password: [{ required: true, message: '密码不能为空' ,trigger: 'blur'}],
        person_name: [{ required: true, trigger: 'blur', message: '姓名不能为空' }],
        birthday: [{ required: true, trigger: 'blur', message: '生日不能为空' }],
        sex: [{ required: true, trigger: 'blur', message: '性别不能为空' }],
        phone_number: [{ required: true, trigger: 'blur', message: '电话号码不能为空' }],
        address: [{ required: true, trigger: 'blur', message: '地址不能为空' }],
        email: [{ required: true, trigger: 'blur', message: '邮箱不能为空' }],
        repassword: [{ required: true, validator: validatePass2, trigger: 'change' }]
     },
      loading: false,
      redirect: undefined,
        user_id:'',
        password:'',
        email:'',
        person_name:'',
        birthday:'',
        sex:'',
        phone_number:'',
        address:'未设置地址',
        repassword:'',
      
    }
  },
  methods: {
    
    post(){
        let give={
          name:this.registerForm.user_id,
          password:this.registerForm.password,
          email:this.registerForm.email,
          userType:'2',
          personName:this.registerForm.person_name,
          birthday:this.registerForm.birthday.toString(),
          sex:this.registerForm.sex,
          phoneNumber:this.registerForm.phone_number,
          address:"未设置地址"
        }
        create(give)
        setTimeout(() => {
          this.$router.push({name: 'login'})
        }, 1000);
    },
    handleRegister(){
      this.$refs["registerForm"].validate((valid) => {
        console.log(valid)
          if (valid) {
            this.post(this.registerForm).then(res => {
            this.$message({
              message: '注册成功',
              type: 'success'
            })

            
          })
          } else {
            
            return false;
          }
      })

    },
    handleBack(){
        this.$router.push({name:"login"})
    }

    // handleLogin() {
    //   this.$refs.loginForm.validate(valid => {
    //     const data = {
    //       name: this.loginForm.name,
    //       password: this.loginForm.password
    //     }
    //     if (valid) {
    //       this.loading = true
    //       login(data).then(res => {
    //         this.loading = false
    //       }).catch(() => {
    //         this.loading = false
    //       })
    //     }
    //   })
    // }
  }
}
</script>

<style lang="less">
.register-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100vh;
  background-size: cover;
  .form-box {
    width: 500px;
    padding: 15px 30px 20px;
    background: #fff;
    border-radius: 4px;
    box-shadow: 0 15px 30px 0 rgba(0, 0, 1, .1);
    .form-title {
      margin: 0 auto 35px;
      text-align: center;
      color: #707070;
      font-size: 18px;
      letter-spacing: 2px;
    }
  }
}
</style>
