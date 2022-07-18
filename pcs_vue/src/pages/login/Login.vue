<template>
  <div class="login-wrapper" :style="'background-image:url('+ Background +')'">
    <div class="form-box">
      <div class="form-title">
        <!-- <img src="../assets/img/logo2.png" alt="icon"> -->
        <p>账 号 登 录</p>
      </div>
      <el-form ref="loginForm" :model="loginForm" :rules="loginRules" label-width="0px" class="login-form">
        <el-form-item prop="name">
          <el-input v-model="loginForm.name" type="text" auto-complete="off" placeholder="请输入账号" prefix-icon="el-icon-user" />
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="loginForm.password" type="password" auto-complete="off" placeholder="请输入密码" prefix-icon="el-icon-lock" @keyup.enter.native="handleLogin" />
        </el-form-item>
        <el-form-item>
          <el-checkbox v-model="loginForm.rememberMe">记住密码</el-checkbox>
        </el-form-item>
        <el-form-item>
          <el-button :loading="loading" size="small" type="primary" style="width:47%;" @click.native.prevent="handleLogin">
            <span v-if="!loading">登 录</span>
            <span v-else>登 录 中...</span>
          </el-button>
          <el-button :loading="loading" size="small" type="primary" style="width:47%;" @click="handleRegister">
            <span>注册</span>
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { login } from '@api/user'
import Background from '../../assets/images/login-background.jpg'

export default {
  name: 'Login',
  data() {
    return {
      Background,
      loginForm: {
        name: '',
        password: '',
        rememberMe: true
      },
      loginRules: {
        name: [{ required: true, trigger: 'blur', message: '用户名不能为空' }],
        password: [{ required: true, message: '密码不能为空' ,trigger: 'blur'}]
      },
      loading: false,
      redirect: undefined
    }
  },
  methods: {
    handleLogin(){
      login(this.loginForm).then(res => {
        if (res.data) {
          // 跳转主页
          this.$message({
            message: '登录成功',
            type: 'success'
          })
          this.$router.push({name: 'main'})
        } else {
          this.$message.error('用户名或密码错误')
        }
      })

    },
    handleRegister(){
      this.$router.push({name:'register'})
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
.login-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100vh;
  background-size: cover;
  .form-box {
    width: 320px;
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
