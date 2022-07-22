<template>
<div>
       <el-button style="margin:10px 10px" size="small" type="primary" @click="exportExcel('s','初访员评分记录')">导出excel</el-button>
            <el-table id="s"
            :data="review.filter(data=>data.isFirst==1)"
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
                                <template slot-scope="scope">
                    <span>{{getChineseDate(scope.row.time)}}</span>
                </template>
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
</div>

</template>

<script>
  import {exportExcel} from "@api/file"
//目前是单个咨询师的结果，但是我想要获取到所有咨询师的，同样需要展开表格的帮助
//TODO:需要数据进行测试  上面的is_first进行筛选
 const timeChinese = ["星期天上午","星期天下午","星期一上午","星期一下午","星期二上午","星期二下午","星期三上午","星期三下午","星期四上午","星期四下午","星期五上午","星期五下午","星期六上午","星期六下午"];
    const timeOptions = ["sun_m","sun_a",'mon_m', 'mon_a', 'tue_m', 'tue_a',"wed_m","wed_a","thu_m","thu_a","fri_m","fri_a","sat_m","sat_a"];
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
      },
        exportExcel(id,name){
          exportExcel(id,name);
        },
        getChineseDate(time){
          for(let i=0;i<timeOptions.length;i++){
              if (timeOptions[i]==time) return timeChinese[i]
          }
        }
    }
  }
</script>

<style scoped>

</style>
