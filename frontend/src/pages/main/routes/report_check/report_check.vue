<template>
    <div>
        <report_dis ref="report_di" />
    <el-table
            :data="report_ch"
            style="width: 100%">
        <el-table-column
                label="用户申请时间"
                prop="reportTime"
                width="240">
        </el-table-column>
        <el-table-column
                label="用户id"
                prop="userId"
                width="180">
        </el-table-column>
        <el-table-column
                label="用户姓名"
                width="180">
            <template slot-scope="scope">
                    <el-popover trigger="hover" placement="top">
                        <p>用户备注: {{ scope.row.reviewRemarks }}</p>
                        <div slot="reference" class="name-wrapper">
                            <el-tag size="medium">{{ scope.row.userName }}</el-tag>
                        </div>
                </el-popover>
            </template>
        </el-table-column>
        <el-table-column
                label="分数"
                prop="score"
                width="120">
        </el-table-column>
        <el-table-column
                label="期望咨询师"
                prop="teacherName"
                width="180">
        </el-table-column>
        <el-table-column
                label="期望时间"
                prop="time"
                width="180">
        </el-table-column>
        <el-table-column label="操作">
            <template slot-scope="scope">
                <el-button
                        size="mini"
                        @click="handleEdit(scope.row,tea_name)">分配</el-button>
                <el-button
                        size="mini"
                        type="danger"
                        @click="handleDelete(scope.row)">驳回</el-button>
            </template>
        </el-table-column>

    </el-table>
    </div>
</template>

<script>
  import {report_check,reject} from '@api/report'
  import {teacher_name} from '@api/teacher_inf'
  import report_dis from '../../components/report/report_distribution'
  export default {
    components:{
      report_dis
    },
    data() {
      return {
        report_ch:[],
        tea_name:[]
      }
    },
    created(){
      this.report_check()
      this.teacher_name()
    },
    methods: {

      teacher_name(){
        teacher_name({}).then(res=>{
          console.info(res)
          this.tea_name=res.data
          console.log(res.data)
          console.log(this.tea_name)

        })
      },

      report_check(){
        report_check({}).then(res=>{
          console.info(res)
          this.report_ch=res.data
        })
      },

      handleEdit(row,tea_name) {
        // console.log(row);
        this.$refs.report_di.show(row,tea_name)
        this.$refs.tea_name=this.tea_name
      },

      handleDelete(row) {
        console.log(row);
        reject(row)
        location.reload()
        alert('驳回成功')
      }
    }
  }
</script>

<style scoped>

</style>
