<template>
    <div>
        <report_dis ref="report_di" />
        <el-table
                :data="result"
                style="width: 100%">
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
                    width="120">
            </el-table-column>
            <el-table-column
                    label="分配时间"
                    prop="timeResult"
                    width="180">
            </el-table-column>
            <el-table-column
                    label="操作"
                    prop="isSuccess"
                    width="180">
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

  export default {
    components:{

    },
    data() {
      return {
        result:[]
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


    }
  }
</script>

<style scoped>

</style>
