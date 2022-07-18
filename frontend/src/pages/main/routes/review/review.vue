<template>

    <el-table
            :data="rev"
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
</template>

<script>
    import {review} from '@api/teacher_inf'
    export default {
        name: 'teacher_inf',
        data() {
            return {
                rev:[]
            }
        },
        created(){
            this.teacher_inf()
        },
        methods:{
            teacher_inf(){
                review({}).then(res=>{
                    console.info(res)
                    this.rev=res.data
                })
            }
        }
    }
</script>

<style scoped>

</style>
