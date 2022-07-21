<template>
<div>
<el-button style="margin:10px 10px" size="small" type="primary" @click="exportExcel('s','预约反馈')">导出excel</el-button>
        <el-table id="s"
            :data="rev.filter(data=>!data.isFirst)"
            border
            style="width: 100%">
        <!--        "evaluationId": 8,-->
        <!--        "userId": "user1",-->
        <!--        "teacherName": "陈奥博",-->
        <!--        "time": "sun_m",-->
        <!--        "fellings": "15",-->
        <!--        "score": 20,-->
        <!--        "evaluationTime": "2022-07-04 17:46:51 下午",-->
        <!--        "resultTime":-->
        <el-table-column
                prop="teacherName"
                label="咨询师名"
                width="180">
        </el-table-column>
        <el-table-column
                label="咨询时间"
                prop="time"
                width="180">
                <template slot-scope="scope">
                    <span>{{getChineseDate(scope.row.time)}}</span>
                </template>
        </el-table-column>

        <el-table-column
                label="提交感受"
                prop="fellings"
                width="360">
        </el-table-column>
        <el-table-column
                label="咨询打分"
                prop="score"
                width="180">
        </el-table-column>
        <el-table-column
                label="报告提交时间"
                prop="evaluationTime">
        </el-table-column>

    </el-table>
</div>

</template>

<script>
  import {exportExcel} from "@api/file"
const timeChinese = ["星期天上午","星期天下午","星期一上午","星期一下午","星期二上午","星期二下午","星期三上午","星期三下午","星期四上午","星期四下午","星期五上午","星期五下午","星期六上午","星期六下午"];
    const timeOptions = ["sun_m","sun_a",'mon_m', 'mon_a', 'tue_m', 'tue_a',"wed_m","wed_a","thu_m","thu_a","fri_m","fri_a","sat_m","sat_a"];
    import {review} from '@api/teacher_inf'
    import {tea_inf,first_inf,user_inf} from "@api/user"
    export default {
        data() {
            return {
                rev:[],
                rev2:[],
                teacherData:[],
                firstData:[]
            }
        },
        created(){
            this.teacher_inf()
            this.f_inf()
        },
        methods:{
            teacher_inf(){
                review({}).then(res=>{
                    console.info(res)
                    this.rev2=res.data
                    first_inf({}).then(res2=>{
                        //接下来装入数据
                        this.firstData=res2.data
                        for(let i=0;i<this.rev2.length;i++){
                            let flag=0;
                            for(let j=0;j<this.firstData.length;j++){
                                if(this.rev2[i].teacherName==this.firstData[j].personName){
                                    //如果在初访员表里面找到名字匹配则说明是初访
                                    this.rev2[i].isFirst=true
                                    flag=1
                                    break
                                }
                            }
                            if(flag==0){
                                this.rev2[i].isFirst=false
                            }
                        }
                        this.rev=this.rev2
                    })
                    
                })
            
            },
        getChineseDate(time){
          for(let i=0;i<timeOptions.length;i++){
              if (timeOptions[i]==time) return timeChinese[i]
          }
        },
        exportExcel(id,name){
          exportExcel(id,name);
        }
    }
}
</script>

<style scoped>

</style>
