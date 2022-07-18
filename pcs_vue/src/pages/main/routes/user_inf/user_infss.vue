<template>
<div>
    <el-dialog
                title="增加用户"
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
                        <el-date-picker
                        v-model="birthday"
                        type="date"
                        placeholder="选择日期">
                      </el-date-picker>
            </el-form-item>
            <el-form-item label="性别">
                  <el-select v-model="value" placeholder="请选择" style="width:100%">
                    <el-option
                      v-for="(item,index) in [{value:'男'},{value:'女'}]"
                      :key="index"
                      :label="item.value"
                      :value="item.value">
                    </el-option>
                  </el-select>
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
            title="增加咨询师"
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
                      <el-date-picker
                        v-model="birthday"
                        type="date"
                        placeholder="选择日期">
                      </el-date-picker>
            </el-form-item>
            <el-form-item label="性别">
                  <el-select v-model="value" placeholder="请选择" style="width:100%">
                    <el-option
                      v-for="(item,index) in [{value:'男'},{value:'女'}]"
                      :key="index"
                      :label="item.value"
                      :value="item.value">
                    </el-option>
                  </el-select>
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


        <el-dialog
            title="增加初访员"
            :visible.sync="dialogVisible_f"
            width="30%"
            :before-close="handleClose">
        <el-form >
            <el-form-item label="初访员id" >
                <el-input v-model="user_id" placeholder="初访员id"></el-input>
            </el-form-item>
            <el-form-item label="初访员名">
                <el-input v-model="person_name" placeholder="初访员名"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="password" placeholder="密码"></el-input>
            </el-form-item>

            <el-form-item label="邮箱">
                <el-input v-model="email" placeholder="邮箱"></el-input>
            </el-form-item>
            <el-form-item label="生日">
                      <el-date-picker
                        v-model="birthday"
                        type="date"
                        placeholder="选择日期">
                      </el-date-picker>
            </el-form-item>
            <el-form-item label="性别">
                  <el-select v-model="value" placeholder="请选择" style="width:100%">
                    <el-option
                      v-for="(item,index) in [{value:'男'},{value:'女'}]"
                      :key="index"
                      :label="item.value"
                      :value="item.value">
                    </el-option>
                  </el-select>
            </el-form-item>
            <el-form-item label="电话">
                <el-input v-model="phone_number" placeholder="电话"></el-input>
            </el-form-item>
            <el-form-item label="地址">
                <el-input v-model="address" placeholder="地址"></el-input>
            </el-form-item>
        </el-form>


        <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible_f = false">取 消</el-button>
        <el-button type="primary" @click="post_f()">提交</el-button>
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






<el-button type="info" plain>初访员信息</el-button>
    <br>
    <el-table
            :data="first_inf"
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
        <el-button type="info" @click="jump_first()">新增初访员</el-button>
        <div style="flex: 1"></div>
    </div>





</div>
</template>

<script>
  import {user_inf,tea_inf,create,first_inf} from '@api/user'
  export default {
    name: 'user_inf',
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
        user_infor:[],
        tea_inf:[],
        first_inf:[],
        dialogVisible: false,
        dialogVisible_t: false,
        dialogVisible_f: false,
        user_id:'',
        password:'',
        email:'',
        person_name:'',
        birthday:'',
        sex:'',
        phone_number:'',
        address:'',
        userForm: {
            user_id:'',
            password:'',
            email:'',
            person_name:'',
            birthday:'',
            sex:'',
            phone_number:'',
            address:'',
          },
          userRules: {
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
      }
    },
    created(){
      this.user_inf()
      this.t_inf()
      this.f_inf()
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
          userType:'3',
          personName:this.person_name,
          birthday:this.birthday,
          sex:this.sex,
          phoneNumber:this.phone_number,
          address:this.address
        }
        },
      post_f(){
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
      jump_first(){
        this.dialogVisible_f=true
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
      },
      f_inf(){
        first_inf({}).then(res=>{
          console.info(res)
          this.first_inf=res.data
        })

      }
    }
  }
</script>

<style scoped>

</style>
