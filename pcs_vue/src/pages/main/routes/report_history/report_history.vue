<template>
<div>
  <el-button style="margin:10px 10px" size="small" type="primary" @click="exportExcel('s','历史咨询')">导出excel</el-button>
      <el-table id="s"
            :data="report_h"
            border
            style="width: 100%"
            :row-class-name="tableRowClassName"
            >
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
                >
        </el-table-column>
        <el-table-column
                prop="reviewRemarks"
                label="备注">
        </el-table-column>
    </el-table>
</div>

</template>

<script>
  import {rejcet,report_his} from '@api/report'
    import {exportExcel} from "@api/file"
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
      },
      tableRowClassName({row, rowIndex}) {
          if (row.isFirst) {
          return 'warning-row';
          } else if (!row.isFirst) {
          return 'success-row';
          }
          return '';
      },
      exportExcel(id,name){
          exportExcel(id,name);
        }
    }
  }
</script>

<style scoped>

</style>
