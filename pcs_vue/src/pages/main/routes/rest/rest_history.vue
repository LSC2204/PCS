<template>
    <div>
      <el-button style="margin:10px 10px" size="small" type="primary" @click="exportExcel('s','请假记录')">导出excel</el-button>
        <report_dis ref="report_di" />
    <el-table id="s"
            :data="uncheckedRest"
            style="width: 100%">
         <el-table-column
                label="请假请求id"
                prop="noteId"
                width="180">
        </el-table-column>       
        <el-table-column
                label="审核结果"
                prop="isSuccess"
                width="180">
                <!-- {{isSuccess==1?"已通过":(isSuccess==0?"未审核":"被驳回")}} -->
            <template slot-scope="scope">
                {{requestState(scope.row.isSuccess,scope.row.isFinish)}}
            </template>
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
                label="请假时间"
                prop="createTime"
                width="180">
        </el-table-column>
        <el-table-column
                label="请假原因"
                prop="noteReason"
                width="180">
        </el-table-column>

    </el-table>
    </div>
</template>

<script>
  import {getMyRest,endRestRequest} from '@api/rest'
  import report_dis from '../../components/report/report_distribution'
   import {exportExcel} from "@api/file"
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
        getMyRest().then(res=>{
          console.log(res)
          this.restData=res.data
        })
      },
      handleEnd(row) {
        endRestRequest(row.noteId)
        location.reload()
      },
      requestState(num1,num2){
          if(num2==1)
          return "已销假"
          else if(num1==1) return "已通过"
          else if(num1==2) return "被驳回"
          else if(num1==0) return "未审核"
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
        return this.restData
        // return this.restData.filter((item,index)=>{
        //   return item.isFinish==0 && item.isSuccess==1;
        // })
      },

    }
  }
</script>

<style scoped>

</style>
