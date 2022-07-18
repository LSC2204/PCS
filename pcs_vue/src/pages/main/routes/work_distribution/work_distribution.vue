<template>

    <div>
        <el-dialog
                title="提示"
                :visible.sync="dialogVisible"
                width="40%"
                :before-close="handleClose">
            <el-form >
                <el-form-item style="width:200px" label="给用户咨询状况打分" prop="score">
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

<!--        <report_dis ref="report_di" />-->
        <!--        :style="{ color:domain.groups == 1? '#ccc': domain.groups == 2 ? '#ccc' : '' }"-->
        <el-table
                :data="result1"
                :row-class-name="tableRowClassName"
                style="width: 100%">
            <el-table-column
                    width="50">
            </el-table-column>
            <el-table-column
                    label="处理时间"
                    prop="resultTime"
                    width="220">
            </el-table-column>

            <el-table-column
                    label="用户名"
                    prop="userName"
                    width="120">
            </el-table-column>
            <el-table-column
                    label="联系方式"
                    prop="phoneNumber"
                    width="120">
            </el-table-column>
            <el-table-column
                    label="地址"
                    prop="address"
                    width="120">
            </el-table-column>
            <el-table-column
                    label="用户备注"
                    prop="resultRemarks"
                    width="230">
            </el-table-column>
            <el-table-column
                    label="已分配咨询时间"
                    prop="timeResult"
                    width="180">
                <template slot-scope="scope">
                    <span>{{getChineseDate(scope.row.timeResult)}}</span>
                </template>
            </el-table-column>
            <el-table-column
                    label="咨询报告">
                <template slot-scope="scope">
                    <el-button
                               size="mini"
                               type="success"
                               @click="jumpout(scope.row.resultId)">咨询完成，填写咨询报告</el-button>
                </template>
            </el-table-column>

        </el-table>
        <div style="margin:50px"></div>

<!-- 
        <el-table
                :data="ft"
                border
                style="width: 100%">
            <el-table-column
                    prop="monM"
                    label="星期一上午"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="tueM"
                    label="星期二上午"
                    width="180">
            </el-table-column>

            <el-table-column
                    prop="wedM"
                    label="星期三上午"
                    width="180">
            </el-table-column>

            <el-table-column
                    prop="thuM"
                    label="星期四上午"
                    width="180">
            </el-table-column>


            <el-table-column
                    prop="friM"
                    label="星期五上午"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="satA"
                    label="星期六上午"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="sunA"
                    label="星期日上午"
                    width="180">
            </el-table-column>

        </el-table>
        <el-table
                :data="ft"
                border
                style="width: 100%"
            >
            <el-table-column
                    prop="monA"
                    label="下午"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="tueA"
                    label="下午"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="wedA"
                    label="下午"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="thuA"
                    label="下午"
                    width="180">
            </el-table-column>

            <el-table-column
                    prop="friA"
                    label="下午"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="satA"
                    label="下午"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="sunA"
                    label="下午"
                    width="180">
            </el-table-column>
        </el-table>


 -->



                    <el-table
                        :data="ft"
                        
                        style="width: 100%">
                        
                        <el-table-column
                                prop=""
                                label=""
                                width="67">
                                <template>
                                        上午
                                </template>
                        </el-table-column>
                        <el-table-column
                                prop="monM"
                                label="星期一"
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.monM}} 咨询时</span>
                                </template>
                        </el-table-column>
                        <el-table-column
                                prop="tueM"
                                label="星期二"
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.tueM}} 咨询时</span>
                                </template>
                        </el-table-column>

                        <el-table-column
                                prop="wedM"
                                label="星期三"
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.wedM}} 咨询时</span>
                                </template>
                        </el-table-column>

                        <el-table-column
                                prop="thuM"
                                label="星期四"
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.thuM}} 咨询时</span>
                                </template>
                        </el-table-column>


                        <el-table-column
                                prop="friM"
                                label="星期五"
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.friM}} 咨询时</span>
                                </template>
                        </el-table-column>
                        <el-table-column
                                prop="satM"
                                label="星期六"
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.satM}} 咨询时</span>
                                </template>
                        </el-table-column>
                        <el-table-column
                                prop="sunM"
                                label="星期日"
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.sunM}} 咨询时</span>
                                </template>
                        </el-table-column>
                    </el-table>

                    <el-table
                            :data="ft"
                            :show-header="false"
                            style="width: 100%"
                        >
                        <el-table-column
                                prop=""
                                label=""
                                width="67">
                                <template>
                                        下午
                                </template>
                        </el-table-column>
                        <el-table-column
                                prop="monA"
                                label=""
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.monA}} 咨询时</span>
                                </template>
                        </el-table-column>
                        <el-table-column
                                prop="tueA"
                                label=""
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.tueA}} 咨询时</span>
                                </template>
                        </el-table-column>
                        <el-table-column
                                prop="wedA"
                                label=""
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.wedA}} 咨询时</span>
                                </template>
                        </el-table-column>
                        <el-table-column
                                prop="thuA"
                                label=""
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.thuA}} 咨询时</span>
                                </template>
                        </el-table-column>

                        <el-table-column
                                prop="friA"
                                label=""
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.friA}} 咨询时</span>
                                </template>
                        </el-table-column>
                        <el-table-column
                                prop="satA"
                                label=""
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.satA}} 咨询时</span>
                                </template>
                        </el-table-column>
                        <el-table-column
                                prop="sunA"
                                label=""
                                width="162">
                                <template slot-scope="scope">
                                        <span>{{scope.row.sunA}} 咨询时</span>
                                </template>
                        </el-table-column>
                    </el-table>


    </div>


</template>

<script>
  import{get_result_teacher,get_ft_teacher,give_rev} from '../../../../api/result'
  import {user_inf,tea_inf,create,first_inf} from '@api/user'
 const timeChinese = ["星期天上午","星期天下午","星期一上午","星期一下午","星期二上午","星期二下午","星期三上午","星期三下午","星期四上午","星期四下午","星期五上午","星期五下午","星期六上午","星期六下午"];
    const timeOptions = ["sun_m","sun_a",'mon_m', 'mon_a', 'tue_m', 'tue_a',"wed_m","wed_a","thu_m","thu_a","fri_m","fri_a","sat_m","sat_a"];
  export default {

    data () {
      return {
        dialogVisible: false,
        result: [],
        result1:[],
        ft:[],
        id_exchange: 1,
        score:0,
        des: '',
        userData:[]
      }
    },
    created () {
      this.get_result()
      this.get_ft_tea()
    },
    methods: {

      get_ft_tea () {
        get_ft_teacher({}).then(res => {
          console.info(res)
          this.ft=res.data


        })
      },

      tableRowClassName ({row, rowIndex}) {
        if (rowIndex%2 === 1) {
          return 'warning-row';
        } else if (rowIndex%2 === 0) {
          return 'success-row';
        }
        return '';
      },

      give_inf () {
        let re = {
          resultId: this.id_exchange,
          score: this.score.valueOf(),
          fellings: this.des
        }
        give_rev(re)
        this.dialogVisible = false
          location.reload()
      },

      handleClose (done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {
          });
      },
      jumpout (id) {
        this.id_exchange = id
        this.dialogVisible = true
      },

      get_result () {
        get_result_teacher({}).then(res => {
          console.info(res)
          for(let i=0;i<res.data.length;i++){
            if(res.data[i].isOk==false){
              this.result.push(res.data[i])
            }
          }
        user_inf({}).then(res=>{
                this.userData=res.data;
                for(let i=0;i<this.result.length;i++){
                        for(let j=0;j<this.userData.length;j++){
                                //这里不知道会不会出问题，userId应该是账户吧
                                if(this.result[i].userId==this.userData[j].name){
                                        this.result[i].address=this.userData[j].address
                                        this.result[i].phoneNumber=this.userData[j].phoneNumber
                                }
                        }
                }
                this.result1=this.result;
        })

        

        })
      },
        getChineseDate(time){
          for(let i=0;i<timeOptions.length;i++){
              if (timeOptions[i]==time) return timeChinese[i]
          }
      },
        user_inf(){

      },
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
