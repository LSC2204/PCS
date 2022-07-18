<template>

    <el-table
            :data="review"
            border
            style="width: 100%">
        <el-table-column
                prop="userId"
                label="咨询用户id"
                width="120">
        </el-table-column>
        <el-table-column
                prop="userName"
                label="咨询用户姓名"
                width="120">
        </el-table-column>
        <el-table-column
                prop="time"
                label="咨询时间"
                width="100">
        </el-table-column>
        <el-table-column
                prop="resultTime"
                label="管理员分配时间"
                width="240">
        </el-table-column>
        <el-table-column
                prop="reviewTime"
                label="咨询报告提交时间"
                width="240">
        </el-table-column>
        <el-table-column
                prop="reviewScore"
                label="咨询打分"
                width="100">
        </el-table-column>
        <el-table-column
                prop="reviewRemarks"
                label="咨询备注">
        </el-table-column>
    </el-table>
</template>

<script>
  import {get_review_teacher} from '@api/result'
  export default {

    data() {
      return {
        review:[]
      }
    },
    created(){
      this.get_review()
    },
    methods:{
      get_review(){
        get_review_teacher({}).then(res=>{
          console.info(res)
          this.review=res.data
        })
      }
    }
  }
</script>

<style scoped>

</style>
