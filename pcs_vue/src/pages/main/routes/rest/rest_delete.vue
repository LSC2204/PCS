<template>
    <div>
        <report_dis ref="report_di" />
        <el-button style="margin:10px 10px" size="small" type="primary" @click="exportExcel('s','销假表')">导出excel</el-button>
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
                {{requestState(scope.row.isSuccess)}}
            </template>
                
        </el-table-column>
      
        <el-table-column
                label="期望时间"
                prop="noteTime"
                width="180">
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
        <el-table-column label="操作">
            <template slot-scope="scope">
                <el-button v-if="scope.row.isSuccess==1"
                        size="mini"
                        @click="handleEnd(scope.row)">销假</el-button>
            </template>
        </el-table-column>

    </el-table>
    </div>
</template>

<script>
  import {exportExcel} from "@api/file"
  import {getMyRest,endRestRequest} from '@api/rest'
  import report_dis from '../../components/report/report_distribution'
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
      requestState(num){
          console.log(num)
          if(num==0)
          return "未通过"
          else if(num==1) return "已通过"
          else return "被驳回"
      },
        exportExcel(id,name){
          exportExcel(id,name);
        }
    },
    computed:{
      uncheckedRest(){
        return this.restData.filter((item,index)=>{
          return item.isFinish==0 && item.isSuccess==1;
        })
      },

    }
  }
</script>

<style scoped>

</style>
