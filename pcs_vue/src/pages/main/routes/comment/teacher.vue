<template>

    <el-table
            :data="review.filter(data=>data.isFirst==0)"
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
                prop="teacherId"
                label="咨询师id"
                width="120">
        </el-table-column>
        <el-table-column
                prop="teacherName"
                label="咨询师姓名"
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
//目前是单个咨询师的结果，但是我想要获取到所有咨询师的，同样需要展开表格的帮助
//TODO:需要数据进行测试  上面的is_first进行筛选
  import {get_review_teacher,get_review_all} from '@api/result'
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
        get_review_all({}).then(res=>{
          console.info(res)
          this.review=res.data
        })
      }
    }
  }
</script>

<style scoped>

</style>
