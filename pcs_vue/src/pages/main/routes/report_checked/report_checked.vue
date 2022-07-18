<template>
    <div>
          <div style="margin:20px"></div>
            <el-input 
              style="width:15%"
              prefix-icon="el-icon-search"
              v-model="search"
              size="large"
              placeholder="输入关键字搜索用户姓名"/>
        <report_dis ref="report_di" />
        <el-table
                
                :data="result.filter(data => !search || data.userName.toLowerCase().includes(search.toLowerCase()))"
                style="width: 100%;"
                :row-class-name="tableRowClassName"
                >
            <el-table-column
                    label="处理时间"
                    prop="resultTime"
                    width="240">
            </el-table-column>
            <el-table-column
                    label="处理用户id"
                    prop="userId"
                    width="180">
            </el-table-column>
            <el-table-column
                    label="处理用户姓名"
                    prop="userName"
                    width="180">
            </el-table-column>
            <el-table-column
                    label="分配咨询师"
                    prop="teacherName"
                    >
            </el-table-column>
            <el-table-column
                    label="分配时间"
                    prop="timeResult"
                    >
                <template slot-scope="scope">
                    <span>{{getChineseDate(scope.row.timeResult)}}</span>
                </template>
            </el-table-column>
            <el-table-column
                    label="操作"
                    prop="isSuccess"
                    >
            </el-table-column>
<!--            <el-table-column label="操作">-->
<!--                <el-button v-if="result.isOk==1" type="success">已分配</el-button>-->
<!--                <el-button v-else-if="result.isOk==0" type="danger">已驳回</el-button>-->
<!--                <template slot-scope="scope">-->
<!--                    <el-button-->
<!--                            size="mini"-->
<!--                            @click="handleEdit(scope.row,tea_name)">分配</el-button>-->
<!--                    <el-button-->
<!--                            size="mini"-->
<!--                            type="danger"-->
<!--                            @click="handleDelete(scope.row)">驳回</el-button>-->
<!--                </template>-->
<!--            </el-table-column>-->

        </el-table>
    </div>
</template>

<script>
  import {get_result_all} from '@api/result'
const timeChinese = ["星期天上午","星期天下午","星期一上午","星期一下午","星期二上午","星期二下午","星期三上午","星期三下午","星期四上午","星期四下午","星期五上午","星期五下午","星期六上午","星期六下午"];
    const timeOptions = ["sun_m","sun_a",'mon_m', 'mon_a', 'tue_m', 'tue_a',"wed_m","wed_a","thu_m","thu_a","fri_m","fri_a","sat_m","sat_a"];
  export default {
    components:{

    },
    data() {
      return {
        result:[],
        search:''
      }
    },
    created(){
      this.get_result()
    },
    methods: {

      get_result(){
        get_result_all({}).then(res=>{
          console.info(res)
          for(let i=0;i<res.data.length;i++){
            if(res.data[i].isSuccess){
              res.data[i].isSuccess='已分配'
            }else{
              res.data[i].isSuccess='已驳回'
            }
          }
          this.result=res.data
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
      getChineseDate(time){
          for(let i=0;i<timeOptions.length;i++){
              if (timeOptions[i]==time) return timeChinese[i]
          }
      },


    }
  }
</script>

<style scoped>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>
