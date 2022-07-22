<template>

    <div>
              <el-dialog
                        title="提示"
                        :visible.sync="eightDialogVisible"
                        width="40%"
                        :before-close="handleClose">
            <el-form >
            <el-form-item style="width:100px" label="给咨询师打分" prop="score">
                <el-input v-model.number="score"></el-input>
            </el-form-item>
            <el-form-item style="width:550px" label="咨询详情" prop="des">
                <el-input type="textarea" v-model="des"></el-input>
            </el-form-item>
            </el-form>
                    <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="give_inf()">提 交</el-button>
          </span>
        </el-dialog>
        <el-dialog
                        title="提示"
                        :visible.sync="dialogVisible"
                        width="40%"
                        :before-close="handleClose">
            <el-form >
            <el-form-item style="width:100px" label="给咨询师打分" prop="score">
                <el-input v-model.number="score"></el-input>
            </el-form-item>
            <el-form-item style="width:550px" label="咨询详情" prop="des">
                <el-input type="textarea" v-model="des"></el-input>
            </el-form-item>
            </el-form>
                    <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="give_inf()">提 交</el-button>
          </span>
        </el-dialog>
<el-button style="margin:10px 10px" size="small" type="primary" @click="exportExcel('s','预约结果')">导出excel</el-button>
        <report_dis ref="report_di" />
<!--        :style="{ color:domain.groups == 1? '#ccc': domain.groups == 2 ? '#ccc' : '' }"-->
        <el-table id="s"
                :data="result.filter(data=> {return !data.isFirst})"
                style="width: 100%">
            <el-table-column
                    width="90">
            </el-table-column>
            <el-table-column
                    label="处理结果"
                    width="240">
                <template slot-scope="scope">
                    <el-button v-if="scope.row.isSuccess=='已分配'"
                            size="mini"
                            type="success">分配</el-button>
                    <el-button v-else
                            size="mini"
                            type="danger">驳回</el-button>
                </template>
            </el-table-column>
            <el-table-column
                    label="处理时间"
                    prop="resultTime"
                    width="240">
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
                <template slot-scope="scope">
                    <span>{{getChineseDate(scope.row.timeResult)}}</span>
                </template>
            </el-table-column>
            <el-table-column
                    label="处理结果"
                    width="240">
                <template slot-scope="scope">
                    <el-button v-if="scope.row.isSuccess=='已分配'&&scope.row.isOk==true"
                               size="mini"
                               type="success"
                                @click="jumpout(scope.row.resultId)">咨询完成，填写咨询报告</el-button>
                    <el-button v-if="scope.row.isSuccess=='已驳回'"
                               size="mini"
                               type="danger"
                               @click="report_again()">再次预约</el-button>
                </template>
            </el-table-column>

        </el-table>
    </div>


</template>

<script>
  import {exportExcel} from "@api/file"
    import{get_result_user,give_eval} from '../../../../api/result'
   const timeChinese = ["星期天上午","星期天下午","星期一上午","星期一下午","星期二上午","星期二下午","星期三上午","星期三下午","星期四上午","星期四下午","星期五上午","星期五下午","星期六上午","星期六下午"];
    const timeOptions = ["sun_m","sun_a",'mon_m', 'mon_a', 'tue_m', 'tue_a',"wed_m","wed_a","thu_m","thu_a","fri_m","fri_a","sat_m","sat_a"];
    export default {

      data() {
        return {
          dialogVisible: false,
          result:[],
          id_exchange:1,
          score:1,
          des:'',
          eightDialogVisible
        }
      },
      created(){
        this.get_result()
      },
      methods:{
        give_inf(){
          let re = {
            resultId:this.id_exchange,
            score:this.score.valueOf(),
            fellings:this.des
          }
          give_eval(re)
          this.dialogVisible=false
        },

          handleClose(done) {
            this.$confirm('确认关闭？')
              .then(_ => {
                done();
              })
              .catch(_ => {});
          },
        jumpout(id){
          this.id_exchange=id
          this.dialogVisible=true
        },

        report_again(){

          this.$router.push({name:'reserve'})

        },

        get_result(){
          get_result_user({}).then(res=>{
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
