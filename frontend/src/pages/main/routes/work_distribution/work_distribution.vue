<template>

    <div>
        <el-dialog
                title="提示"
                :visible.sync="dialogVisible"
                width="40%"
                :before-close="handleClose">
            <el-form >
                <el-form-item style="width:100px" label="给用户咨询状况打分" prop="score">
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
                :data="result"
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
                    label="用户id"
                    prop="userId"
                    width="120">
            </el-table-column>
            <el-table-column
                    label="用户名"
                    prop="userName"
                    width="120">
            </el-table-column>
            <el-table-column
                    label="用户备注"
                    prop="resultRemarks"
                    width="360">
            </el-table-column>
            <el-table-column
                    label="已分配咨询时间"
                    prop="timeResult"
                    width="180">
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
<!--            <el-table-column-->
<!--                    label="id"-->
<!--                    width="180">-->
<!--&lt;!&ndash;                <template slot-scope="scope">&ndash;&gt;-->
<!--&lt;!&ndash;                    <el-button&ndash;&gt;-->
<!--&lt;!&ndash;                               size="mini"&ndash;&gt;-->
<!--&lt;!&ndash;                               type="success">咨询完成，填写咨询报告</el-button>&ndash;&gt;-->
<!--&lt;!&ndash;                </template>&ndash;&gt;-->
<!--            </el-table-column>-->

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
    </div>


</template>

<script>
  import{get_result_teacher,get_ft_teacher,give_rev} from '../../../../api/result'

  export default {

    data () {
      return {
        dialogVisible: false,
        result: [],
        ft:[],
        id_exchange: 1,
        score:0,
        des: ''
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

        })
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
