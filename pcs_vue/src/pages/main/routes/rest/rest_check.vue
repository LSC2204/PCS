<template>
    <div>
        <report_dis ref="report_di" />
         <el-button style="margin:10px 10px" size="small" type="primary" @click="exportExcel('s','请假审核表')">导出excel</el-button>
    <el-table id="s"
            :data="uncheckedRest"
            style="width: 100%">
         <el-table-column
                label="请假请求id"
                prop="noteId"
                width="180">
        </el-table-column>       
        <el-table-column
                label="用户id"
                prop="teacherId"
                width="180">
        </el-table-column>
        <el-table-column
                label="用户姓名"
                prop="teacherName"
                width="180">
        </el-table-column>
        <el-table-column
                label="请假时间"
                prop="createTime"
                width="180">
        </el-table-column>
        <el-table-column
                label="期望时间"
                prop="noteTime"
                width="180">
            <template slot-scope="scope">
            <span>{{ getChineseDate(scope.row.noteTime) }}</span>
            </template>
        </el-table-column>
        <el-table-column
                label="请假原因"
                prop="noteReason"
                width="180">
        </el-table-column>
        <el-table-column label="操作">
            <template slot-scope="scope">
                <el-button
                        size="mini"
                        @click="handleAgree(scope.row)">通过</el-button>
                <el-button
                        size="mini"
                        type="danger"
                        @click="handleDisagree(scope.row)">驳回</el-button>
            </template>
        </el-table-column>

    </el-table>
    </div>
</template>

<script>
  import {report_check,reject} from '@api/report'
    import {exportExcel} from "@api/file"
  import {getAllRestData,agreeRestRequest,disagreeRestRequest} from '@api/rest'
  import report_dis from '../../components/report/report_distribution'
  const timeChinese = [
  "星期天上午",
  "星期天下午",
  "星期一上午",
  "星期一下午",
  "星期二上午",
  "星期二下午",
  "星期三上午",
  "星期三下午",
  "星期四上午",
  "星期四下午",
  "星期五上午",
  "星期五下午",
  "星期六上午",
  "星期六下午",
];
const timeOptions = [
  "sun_m",
  "sun_a",
  "mon_m",
  "mon_a",
  "tue_m",
  "tue_a",
  "wed_m",
  "wed_a",
  "thu_m",
  "thu_a",
  "fri_m",
  "fri_a",
  "sat_m",
  "sat_a",
];
  export default {
    components:{
      report_dis
    },
    data() {
      return {
        restData:[],
      }
    },
    created(){
      this.getRestData()
    },
    methods: {
      getRestData(){
        getAllRestData().then(res=>{
          console.log(res)
          this.restData=res.data
        })
      },
      handleAgree(row) {
        agreeRestRequest(row.noteId)
        location.reload()
      },

      handleDisagree(row) {
        disagreeRestRequest(row.noteId)
        location.reload()
      },
        exportExcel(id,name){
          exportExcel(id,name);
        },
    getChineseDate(time) {
      for (let i = 0; i < timeOptions.length; i++) {
        if (timeOptions[i] == time) return timeChinese[i];
      }
    },
    },
    computed:{
      uncheckedRest(){
        return this.restData.filter((item,index)=>{
          return item.isSuccess==0;
        })
      }
    }
  }
</script>

<style scoped>

</style>
