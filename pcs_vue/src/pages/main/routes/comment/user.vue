<template>
<div>
<!-- <el-table
            :data="userData"
            border
            style="width: 100%">
        <el-table-column type="expand">
            <template slot-scope="props">
                <el-table :data="evaData.filter(data => data.==props.)" height="290" border>
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
        </el-table-column>
        <el-table-column
                prop="name"
                label="用户账号"
                width="180">
        </el-table-column>
        <el-table-column
                label="用户姓名"
                prop="personName"
                width="180">
        </el-table-column>
        <el-table-column
                label="性别"
                prop="sex" 
                width="180">
                <template slot-scope="scope">
                    <span v-if="scope.row.sex=='男'">男</span>
                    <span v-if="scope.row.sex=='女'">女</span>
                </template>
        </el-table-column>
        <el-table-column
                label="联系方式"
                prop="phoneNumber"
                width="180">
        </el-table-column>
                <el-table-column
                label="地址"
                prop="address"
                width="180">
        </el-table-column>
    </el-table> -->
        <el-table
            :data="evaData"
            
            style="width: 100%">
    
        <el-table-column
                prop="evaluationTime"
                label="评价时间"
                width="220">
        </el-table-column>
        <el-table-column
                label="预约时间"
                prop="time"
                width="180">
                <template slot-scope="scope">
                    <span>{{getChineseDate(scope.row.time)}}</span>
                </template>
        </el-table-column>
        <el-table-column
                label="用户ID"
                prop="userId" 
                width="180">
        </el-table-column>
        <el-table-column
                label="分数"
                prop="score"
                width="180">
        </el-table-column>
                <el-table-column
                label="咨询师/初访员姓名"
                prop="teacherName"
                width="180">
        </el-table-column>
        <el-table-column
                label="用户评价"
                prop="fellings"
                width="250">
        </el-table-column>
    </el-table>
</div>
    
</template>

<script>
//需要按每个用户的信息进行展开
//用户姓名需要有接口获取，根据用户的id获取person信息
//外面的表进行获取所有user的id信息，里面的表获取id==该id的信息
//发现能直接获取用户接口
//根据用户name获取对应的eva
//TODO： 这里问题最多拉
    import {get_all_person} from '@api/teacher_inf'
    import {user_inf,getAllPerson} from  '@api/user'
    const timeChinese = ["星期天上午","星期天下午","星期一上午","星期一下午","星期二上午","星期二下午","星期三上午","星期三下午","星期四上午","星期四下午","星期五上午","星期五下午","星期六上午","星期六下午"];
    const timeOptions = ["sun_m","sun_a",'mon_m', 'mon_a', 'tue_m', 'tue_a',"wed_m","wed_a","thu_m","thu_a","fri_m","fri_a","sat_m","sat_a"];
    export default {
        name: 'user_eva',
        
        data() {
            return {
                evaData:[],
                userData:[],
                personData:[]
            }
        },
        created(){
            this.get_all_eval()
            // this.get_all_user()
        },
        methods:{
            get_all_eval(){
                get_all_person({}).then(res=>{
                    console.info(res)
                    this.evaData=res.data
                })
            },
            get_all_user(){
                //这里获取到的其实是所有user的person信息。
                user_inf({}).then(res=>{
                    console.info(res)
                    this.userData=res.data
                })
            },
            getChineseDate(time){
                for(let i=0;i<timeOptions.length;i++){
                    if (timeOptions[i]==time) return timeChinese[i]
                }
            },
            tableRowClassName({row, rowIndex}) {
        if (rowIndex === 1) {
          return 'warning-row';
        } else if (rowIndex === 3) {
          return 'success-row';
        }
        return '';
            }
        },
        computed:{
            userNames(){
                let arr=[]
                this.userData.forEach((item,i)=>{
                    //TODO:这里不清楚user包的具体内容
                    // arr.push(item.)
                })
                arr.push()
            }
        }
    }
</script>

<style>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>
