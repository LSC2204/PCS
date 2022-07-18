<template>
<div>
    <el-dialog
                title="提示"
                :visible.sync="dialogVisible"
                width="30%"
                :before-close="handleClose">
        <el-form >
            <el-form-item label="用户id" >
                <el-input v-model="user_id" placeholder="用户id"></el-input>
            </el-form-item>
            <el-form-item label="用户名">
                <el-input v-model="person_name" placeholder="用户名"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="password" placeholder="密码"></el-input>
            </el-form-item>

            <el-form-item label="邮箱">
                <el-input v-model="email" placeholder="邮箱"></el-input>
            </el-form-item>
            <el-form-item label="生日">
                <el-input v-model="birthday" placeholder="生日"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <el-input v-model="sex" placeholder="性别"></el-input>
            </el-form-item>
            <el-form-item label="电话">
                <el-input v-model="phone_number" placeholder="电话"></el-input>
            </el-form-item>
            <el-form-item label="地址">
                <el-input v-model="address" placeholder="地址"></el-input>
            </el-form-item>
        </el-form>


        <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="post()">提交</el-button>
      </span>
    </el-dialog>
    <el-dialog
            title="提示"
            :visible.sync="dialogVisible_t"
            width="30%"
            :before-close="handleClose">
        <el-form >
            <el-form-item label="咨询师id" >
                <el-input v-model="user_id" placeholder="咨询师id"></el-input>
            </el-form-item>
            <el-form-item label="咨询师名">
                <el-input v-model="person_name" placeholder="咨询师名"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="password" placeholder="密码"></el-input>
            </el-form-item>

            <el-form-item label="邮箱">
                <el-input v-model="email" placeholder="邮箱"></el-input>
            </el-form-item>
            <el-form-item label="生日">
                <el-input v-model="birthday" placeholder="生日"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <el-input v-model="sex" placeholder="性别"></el-input>
            </el-form-item>
            <el-form-item label="电话">
                <el-input v-model="phone_number" placeholder="电话"></el-input>
            </el-form-item>
            <el-form-item label="地址">
                <el-input v-model="address" placeholder="地址"></el-input>
            </el-form-item>
        </el-form>


        <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible_t = false">取 消</el-button>
        <el-button type="primary" @click="post_t()">提交</el-button>
      </span>
    </el-dialog>
    <br>
    <el-button type="primary" plain>用户信息</el-button>
    <br>
    <el-table
            :data="user_infor"
            border
            style="width: 100%">
        <el-table-column
                prop="personId"
                label="id"
                width="90">
        </el-table-column>
        <el-table-column
                prop="name"
                label="账号"
                width="180">
        </el-table-column>
        <el-table-column
                prop="personName"
                label="姓名"
                width="180">
        </el-table-column>
        <el-table-column
                prop="sex"
                label="性别"
                width="90">
        </el-table-column>
        <el-table-column
                prop="birthday"
                label="生日"
                width="180">
        </el-table-column>
        <el-table-column
                prop="phoneNumber"
                label="电话号码"
                width="270">
        </el-table-column>
        <el-table-column
                prop="address"
                label="地址" >
        </el-table-column>
    </el-table>
    <br>
    <div style="display: flex">
        <div style="flex: 1"></div>
        <el-button type="primary" @click="jump_user()">新增用户</el-button>
        <div style="flex: 1"></div>
    </div>
    <br>
    <br>
    <el-button type="success" plain>咨询师信息</el-button>
    <br>
    <el-table
            :data="tea_inf"
            border
            style="width: 100%">
        <el-table-column
                prop="personId"
                label="id"
                width="90">
        </el-table-column>
        <el-table-column
                prop="name"
                label="账号"
                width="180">
        </el-table-column>
        <el-table-column
                prop="personName"
                label="姓名"
                width="180">
        </el-table-column>
        <el-table-column
                prop="sex"
                label="性别"
                width="90">
        </el-table-column>
        <el-table-column
                prop="birthday"
                label="生日"
                width="180">
        </el-table-column>
        <el-table-column
                prop="phoneNumber"
                label="电话号码"
                width="270">
        </el-table-column>
        <el-table-column
                prop="address"
                label="地址" >
        </el-table-column>
    </el-table>
    <br>
    <div style="display: flex">
        <div style="flex: 1"></div>
        <el-button type="success" @click="jump_teacher()">新增咨询师</el-button>
        <div style="flex: 1"></div>
    </div>

</div>
</template>

<script>
  import {user_inf,tea_inf,create} from '@api/user'
  export default {
    name: 'user_inf',
    data() {
      return {
        user_infor:[],
        tea_inf:[],
        dialogVisible: false,
        dialogVisible_t: false,
        user_id:'',
        password:'',
        email:'',
        person_name:'',
        birthday:'',
        sex:'',
        phone_number:'',
        address:''
      }
    },
    created(){
      this.user_inf()
      this.t_inf()
    },
    methods:{
      post(){
        let give={
          name:this.user_id,
          password:this.password,
          email:this.email,
          userType:'2',
          personName:this.person_name,
          birthday:this.birthday,
          sex:this.sex,
          phoneNumber:this.phone_number,
          address:this.address
        }
        create(give)
        this.dialogVisible=false
        location.reload()
      },
      post_t(){
        let give={
          name:this.user_id,
          password:this.password,
          email:this.email,
          userType:'4',
          personName:this.person_name,
          birthday:this.birthday,
          sex:this.sex,
          phoneNumber:this.phone_number,
          address:this.address
        }
        create(give)
        this.dialogVisible_t=false
        location.reload()
      },
      jump_user(){
        this.dialogVisible=true
      },
      jump_teacher(){
        this.dialogVisible_t=true
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },

      user_inf(){
        user_inf({}).then(res=>{
          console.info(res)
          this.user_infor=res.data
        })
      },
      t_inf(){
        tea_inf({}).then(res=>{
          console.info(res)
          this.tea_inf=res.data
        })
      }
    }
  }
</script>

<style scoped>

</style>
