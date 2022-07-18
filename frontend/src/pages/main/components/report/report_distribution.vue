<template>
    <el-dialog
            title="提示"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
        <el-form :model="form">

            <el-form-item v-if="teacher==null" label="分配时间" prop="time">
                <el-select @change="post_t()" v-model="time" placeholder="请选择分配时间" clearable>
                    <el-option label="星期一上午" value="mon_m"></el-option>
                    <el-option label="星期一上午" value="mon_m"></el-option>
                    <el-option label="星期一下午" value="mon_a"></el-option>
                    <el-option label="星期二上午" value="tue_m"></el-option>
                    <el-option label="星期二下午" value="tue_a"></el-option>
                    <el-option label="星期三上午" value="wed_m"></el-option>
                    <el-option label="星期三下午" value="wed_a"></el-option>
                    <el-option label="星期四上午" value="the_m"></el-option>
                    <el-option label="星期四下午" value="the_a"></el-option>
                    <el-option label="星期五上午" value="fri_m"></el-option>
                    <el-option label="星期五下午" value="fri_a"></el-option>
                    <el-option label="星期六上午" value="sta_m"></el-option>
                    <el-option label="星期六下午" value="sta_a"></el-option>
                    <el-option label="星期日上午" value="sun_m"></el-option>
                    <el-option label="星期日下午" value="sun_a"></el-option>

                </el-select>
            </el-form-item>
                <el-form-item v-else label="分配时间" prop="time">
                    <el-select @change="post_t()" v-model="time" placeholder="请选择分配时间" clearable>
                <el-option :key="index" v-for="(c_time,index) in free_time"  :value="c_time">{{c_time}}</el-option>
                </el-select>
            </el-form-item>
            <!--            <el-button @click="post_t()">查询有空教师</el-button><br/>-->


            <el-form-item v-if="time==null" label="选择咨询师" prop="teacher">
                <el-select @change="post_tea()" v-model="teacher" placeholder="请选择教师" clearable>
                    <el-option :key="index" v-for="(t_name,index) in tea_name"  :value="t_name">{{t_name}}</el-option>
                </el-select>
            </el-form-item>
            <el-form-item v-else label="选择咨询师" prop="teacher">
                <el-select @change="post_tea()" v-model="teacher" placeholder="请选择教师" clearable>
                    <el-option :key="index" v-for="(c_teacher,index) in free_teacher"  :value="c_teacher">{{c_teacher}}</el-option>
                </el-select>
            </el-form-item>
<!--            <el-button @click="post_tea()">查询有空教师</el-button><br/>-->

        </el-form>

        <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="post_res()">确认分配</el-button>
        </span>
    </el-dialog>


</template>

<script>
  import {post_time,post_result,post_teacher} from '@api/report'
  import {teacher_name} from '@api/teacher_inf'

  export default {
    data() {
      return {
        time:null,
        teacher:null,
        dialogVisible: false,
        row:{},
        free_teacher:[],
        free_time:[],
        tea_name:[],
      };
    },
    created(){
      this.report_distribute()
      this.teacher_name()
    },

    methods: {
      post_res(){
        let report_r = {
          reportId:this.row.reportId,
          teacherName:this.teacher,
          time:this.time
        }
        post_result(report_r)
        this.dialogVisible = false
        location.reload()
      },
      teacher_name(){
        teacher_name({}).then(res=>{
          console.info(res)
          this.tea_name=res.data
        })
      },
      post_tea(){
        let teacher=this.teacher
        post_teacher(teacher).then(res=>{
          this.free_time=res.data
        })
      },
      post_t(){
        let data={
          time:this.time,
          isFirst:this.row.isFirst
        }

        post_time(data).then(res=>{
          this.free_teacher=res.data
        })
      },
      show(row,tea_name){
        this.dialogVisible=true
        this.row=row
        this.tea_name=tea_name
      },
      handleClose(done) {

        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      }
    }
  };
</script>

<style scoped>

</style>
