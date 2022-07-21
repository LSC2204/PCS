<template>
<div><el-button style="margin:10px 10px" size="small" type="primary" @click="exportExcel('s','用户评分')">导出excel</el-button>
    <el-table id="s"
            :data="evalData"
            border
            style="width: 100%">
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
const timeChinese = ["星期天上午","星期天下午","星期一上午","星期一下午","星期二上午","星期二下午","星期三上午","星期三下午","星期四上午","星期四下午","星期五上午","星期五下午","星期六上午","星期六下午"];
    const timeOptions = ["sun_m","sun_a",'mon_m', 'mon_a', 'tue_m', 'tue_a',"wed_m","wed_a","thu_m","thu_a","fri_m","fri_a","sat_m","sat_a"];
    import {review,get_teacher} from '@api/teacher_inf'
    import {give_eval_by_name} from '@api/result'
    import {getAllPerson} from "@api/user"
      import {exportExcel} from "@api/file"
      //复制三步走:1.按钮2.引用3.函数 4.改名
    //获取allperson
    
    export default {
        data() {
            return {
                rev:[],
                rev2:[],
                teacherData:[],
                firstData:[],
                personData:[],
                evalData:[],
            }
        },
        created(){
            this.teacher_inf()
            this.person_inf()
        },
        methods:{
            teacher_inf(){
                get_teacher({}).then(res=>{
                    console.info(res)
                    this.rev=res.data
                })
            
            },
            person_inf(){
                getAllPerson({}).then(res=>{
                    this.personData=res.data
                    //
                    for(let i=0;i<this.personData.length;i++){
                        if(this.personData[i].name==this.$store.state.user.name){
                            //在这里发出请求，得到所有的eval
                            give_eval_by_name(this.personData[i].personName).then(
                                res=>{
                                    this.evalData=res.data;
                                }
                                
                            )
                        }
                    }
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
