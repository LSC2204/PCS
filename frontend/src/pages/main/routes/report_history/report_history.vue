<template>

    <el-table
            :data="report_h"
            border
            style="width: 100%">
        <el-table-column
                prop="teacherName"
                label="预约咨询师"
                width="180">
        </el-table-column>
        <el-table-column
                prop="time"
                label="目的预约时间"
                width="180">
        </el-table-column>
        <el-table-column
                prop="reportTime"
                label="预约时间"
                width="540">
        </el-table-column>
        <el-table-column
                prop="reviewRemarks"
                label="备注">
        </el-table-column>
    </el-table>
</template>

<script>
  import {rejcet,report_his} from '@api/report'
  export default {
    name: 'report_history',
    data() {
      return {
        report_h:[]
      }
    },
    created(){
      this.report_his()
    },
    methods:{
      report_his(){
        report_his({}).then(res=>{
          console.info(res)
          this.report_h=res.data
        })
      }
    }
  }
</script>

<style scoped>

</style>
