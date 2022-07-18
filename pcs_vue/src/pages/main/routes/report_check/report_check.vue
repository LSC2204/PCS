<template>
    <div>
        <report_dis ref="report_di" />
            <div style="margin:20px"></div>
            <el-input
              style="width:15%"
              prefix-icon="el-icon-search"
              v-model="search"
              size="large"
              placeholder="输入关键字搜索用户姓名"/>
              
    <el-table
            :data="report_cha.filter(data => !search || data.userName.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%"
            :row-class-name="tableRowClassName"
            >
        <el-table-column
                label="用户申请时间"
                prop="reportTime"
                width="240">
        </el-table-column>
        <!-- <el-table-column 
                label="用户id"
                prop="userId"
                width="150">
        </el-table-column> -->
        <el-table-column
                label="用户姓名"
                width="180">

            <template slot-scope="scope">
                    <el-popover trigger="hover" placement="top">
                        <p>用户备注: {{ scope.row.reviewRemarks }}</p>
                        <div slot="reference" class="name-wrapper">
                            <el-tag size="medium">{{ scope.row.userName }}</el-tag>
                        </div>
                </el-popover>
            </template>
        </el-table-column>
        <el-table-column sortable
                label="分数"
                prop="score"
                width="120">
        </el-table-column>
        <el-table-column
                label="期望咨询师"
                prop="teacherName"
                width="150">
        </el-table-column>
        <el-table-column
                label="期望时间"
                prop="time"
                width="180">
        </el-table-column>
                <el-table-column
                label="联系方式"
                prop="phoneNumber"
                width="180">
        </el-table-column>
        <el-table-column label="分配操作">
            <template slot-scope="scope">
                <el-button v-if="scope.row.isFirst"
                        size="mini"
                        @click="handleEdit(scope.row,tea_name)">初访员</el-button>
                <el-button v-else
                        size="mini"
                        @click="handleEdit(scope.row,tea_name)">咨询师</el-button>
                <el-button
                        size="mini"
                        type="danger"
                        @click="handleDelete(scope.row)">驳回</el-button>
            </template>
        </el-table-column>

    </el-table>
    </div>
</template>

<script>
  import {report_check,reject} from '@api/report'
  import {teacher_name} from '@api/teacher_inf'
  import {getAllPerson} from '@api/user'
  import report_dis from '../../components/report/report_distribution'
  export default {
    components:{
      report_dis
    },
    data() {
      return {
        report_ch:[],
        tea_name:[],
        personData:[],
        search: '',
        report_cha:[],
      }
    },
    created(){
      this.report_check()
      this.teacher_name()
    },
    methods: {
      get_all_person(){
        getAllPerson({}).then(res=>{
          this.personData=res.data
        })
        //顺便处理一下数据？
      },
      teacher_name(){
        teacher_name({}).then(res=>{
          this.tea_name=res.data

        })
      },

      report_check(){
        report_check({}).then(res=>{
          console.info(res)
          this.report_ch=res.data
          getAllPerson({}).then(res2=>{
            this.personData=res2.data
            //在这里对数据进行处理
            for(let i=0;i<this.report_ch.length;i++){
              for(let j=0;j<this.personData.length;j++){
                if(this.report_ch[i].userId==this.personData[j].name){
                  this.report_ch[i].phoneNumber=this.personData[j].phoneNumber
                }
              }
              
            }
            this.report_cha=this.report_ch;
          })
          

        })
      },

      handleEdit(row,tea_name) {
          console.info("hss")
       console.info(row);
          console.info("hss")
        this.$refs.report_di.show(row,tea_name)
        this.$refs.tea_name=this.tea_name
      },

      handleDelete(row) {
        console.log(row);
        reject(row)
        location.reload()
        alert('驳回成功')
      },
      tableRowClassName({row, rowIndex}) {
          if (row.isFirst) {
          return 'warning-row';
          } else if (!row.isFirst) {
          return 'success-row';
          }
          return '';
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
