<template>
  <div>
    <el-dialog
      title="提示"
      :visible.sync="historyVisible"
      width="40%"
      :before-close="handleClose"
    >
              <el-table :data="historyTable.historyArray">
              <el-table-column lable="">
                   <template slot-scope="scope">
                       {{scope.row.time}}
                   </template>
              </el-table-column>
              <el-table-column lable="状态">
                   <template slot-scope="scope">
                       {{scope.row.status}}
                   </template>
              </el-table-column>
          </el-table>

      <span slot="footer" class="dialog-footer">
        <el-select v-model="historyTable.status" placeholder="选择对应的咨询状况" >
            <el-option label="已咨询" value="1"></el-option>
            <el-option label="旷约" value="2"></el-option>
        </el-select>
        <el-button v-if="historyTable.hisotoryNumber.length >= 8" @click="addHistory">追加咨询时间确认</el-button>
        <el-button v-if="historyTable.hisotoryNumber.length < 8" @click="addHistory">第{{historyTable.hisotoryNumber.length+1}}次咨询情况确认</el-button>
        <el-button @click="historyVisible = false">取 消</el-button>
    
      </span>
    </el-dialog>

    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="40%"
      :before-close="handleClose"
    >
      <el-form>
        <el-form-item
          style="width: 200px"
          label="给用户咨询状况打分"
          prop="score"
        >
          <el-input v-model.number="score"></el-input>
        </el-form-item>
        <el-form-item
          style="width: 200px"
          label="用户心理问题分类"
          prop=""
          v-if="userType == 4"
        >
          <el-select v-model="des0" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item style="width: 550px" label="咨询详情" prop="des">
          <el-input type="textarea" v-model="des"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="give_inf()">提 交</el-button>
      </span>
    </el-dialog>
    <el-button
      style="margin: 10px 10px"
      size="small"
      type="primary"
      @click="exportExcel('s', '工作安排')"
      >导出excel</el-button
    >
    <!--        <report_dis ref="report_di" />-->
    <!--        :style="{ color:domain.groups == 1? '#ccc': domain.groups == 2 ? '#ccc' : '' }"-->
    <el-table
      id="s"
      :data="result1"
      :row-class-name="tableRowClassName"
      style="width: 100%"
    >
      <el-table-column width="50"> </el-table-column>
      <el-table-column label="处理时间" prop="resultTime" width="220">
      </el-table-column>

      <el-table-column label="用户名" prop="userName" width="120">
      </el-table-column>
      <el-table-column label="联系方式" prop="phoneNumber" width="120">
      </el-table-column>
      <el-table-column label="地址" prop="address" width="120">
      </el-table-column>
      <el-table-column label="用户备注" prop="resultRemarks" width="230">
      </el-table-column>
      <el-table-column label="已分配咨询时间" prop="timeResult" width="180">
        <template slot-scope="scope">
          <span>{{ getChineseDate(scope.row.timeResult) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="咨询报告">
        <template slot-scope="scope">
          <el-button
            v-if="userType == 3"
            size="mini"
            type="success"
            @click="historyJumpout(scope.row)"
            >详细</el-button
          >
          <!-- <el-button 
            size="mini"
            type="success"
            @click="jumpout(scope.row.resultId)"
            >填写咨询结案报告</el-button> -->
            
            <el-button v-if="scope.row.status.length>=8"
            size="mini"
            type="success"
            @click="jumpout(scope.row.resultId)"
            >填写结案报告</el-button>
            <el-button v-if="scope.row.status.length<8"
            size="mini"
            type="success"
            @click="jumpout(scope.row.resultId)"
            >提前结案</el-button>
          
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 50px"></div>

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

    <el-table :data="ft" style="width: 100%">
      <el-table-column prop="" label="" width="67">
        <template> 上午 </template>
      </el-table-column>
      <el-table-column prop="monM" label="星期一" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.monM }} 咨询时</span>
        </template>
      </el-table-column>
      <el-table-column prop="tueM" label="星期二" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.tueM }} 咨询时</span>
        </template>
      </el-table-column>

      <el-table-column prop="wedM" label="星期三" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.wedM }} 咨询时</span>
        </template>
      </el-table-column>

      <el-table-column prop="thuM" label="星期四" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.thuM }} 咨询时</span>
        </template>
      </el-table-column>

      <el-table-column prop="friM" label="星期五" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.friM }} 咨询时</span>
        </template>
      </el-table-column>
      <el-table-column prop="satM" label="星期六" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.satM }} 咨询时</span>
        </template>
      </el-table-column>
      <el-table-column prop="sunM" label="星期日" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.sunM }} 咨询时</span>
        </template>
      </el-table-column>
    </el-table>

    <el-table :data="ft" :show-header="false" style="width: 100%">
      <el-table-column prop="" label="" width="67">
        <template> 下午 </template>
      </el-table-column>
      <el-table-column prop="monA" label="" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.monA }} 咨询时</span>
        </template>
      </el-table-column>
      <el-table-column prop="tueA" label="" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.tueA }} 咨询时</span>
        </template>
      </el-table-column>
      <el-table-column prop="wedA" label="" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.wedA }} 咨询时</span>
        </template>
      </el-table-column>
      <el-table-column prop="thuA" label="" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.thuA }} 咨询时</span>
        </template>
      </el-table-column>

      <el-table-column prop="friA" label="" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.friA }} 咨询时</span>
        </template>
      </el-table-column>
      <el-table-column prop="satA" label="" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.satA }} 咨询时</span>
        </template>
      </el-table-column>
      <el-table-column prop="sunA" label="" width="162">
        <template slot-scope="scope">
          <span>{{ scope.row.sunA }} 咨询时</span>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { exportExcel } from "@api/file";
import { mapGetters } from "vuex";
import {
  get_result_teacher,
  get_ft_teacher,
  give_rev,
  get_result_by_id,
  update_result
} from "../../../../api/result";
import { user_inf, tea_inf, create, first_inf } from "@api/user";

const timeChinese = [
  "星期天上午",
  "星期天下午",
  "星期一上午",
  "星期一下午",
  "星期二上午",
  "星期二下午",
  "星期三上午",
  "星期三下午",
  "星期四上午",
  "星期四下午",
  "星期五上午",
  "星期五下午",
  "星期六上午",
  "星期六下午",
];
const timeOptions = [
  "sun_m",
  "sun_a",
  "mon_m",
  "mon_a",
  "tue_m",
  "tue_a",
  "wed_m",
  "wed_a",
  "thu_m",
  "thu_a",
  "fri_m",
  "fri_a",
  "sat_m",
  "sat_a",
];
export default {
  data() {
    return {
      historyVisible: false,
      dialogVisible: false,
      historyShowId: -1,
      result: [],
      result1: [],
      ft: [],
      //id_exchange: 1,
      score: 0,
      des: "",
      userData: [],
      des0: "",
      options: [
        {
          value: "感觉障碍",
          label: "感觉障碍",
        },
        {
          value: "知觉障碍",
          label: "知觉障碍",
        },
        {
          value: "注意障碍",
          label: "注意障碍",
        },
        {
          value: "记忆障碍",
          label: "记忆障碍",
        },
        {
          value: "思维障碍",
          label: "思维障碍",
        },
        {
          value: "情感障碍",
          label: "情感障碍",
        },
        {
          value: "意志障碍",
          label: "意志障碍",
        },
        {
          value: "智力障碍",
          label: "智力障碍",
        },
      ],
      
      //暂定1为已咨询，0为未咨询，2为旷约
      debug_historyNumber: ["11", "111211111", "1", "222222222"],
      historyTable: {
        user_id: "",
        teacher_id: "",
        teacher_name: "",
        user_name: "",
        status:"",
        resultId:"",
        historyArray: [],
        hisotoryNumber: "",
      },
    };
  },
  created() {
    this.get_result();
    this.get_ft_tea();
  },
  methods: {
    get_ft_tea() {
      get_ft_teacher({}).then((res) => {
        console.info(res);
        this.ft = res.data;
      });
    },

    tableRowClassName({ row, rowIndex }) {
      if (rowIndex % 2 === 1) {
        return "warning-row";
      } else if (rowIndex % 2 === 0) {
        return "success-row";
      }
      return "";
    },

    give_inf() {
      let re = {
        resultId: this.historyShowId,
        score: this.score.valueOf(),
        fellings: this.get_fellings(this.des0, this.des),
      };
      give_rev(re);
      this.dialogVisible = false;
      location.reload();
    },
    get_fellings(dex0, des) {
      if (dex0 == "") {
        return des;
      } else return "心理问题初步诊断为：" + this.des0 + "     " + this.des;
    },
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
        })
        .catch((_) => {});
    },
    jumpout(id) {
      this.historyShowId = id;
      this.dialogVisible = true;
    },
    // test(){
    //     let n = this.debug_historyNumber[0].length;
    //     let s = this.debug_historyNumber[0];
    //     console.log("n="+n)
    //     },
    historyJumpout(res) {
      //通过Number获取array
      this.historyTable.resultId=res.resultId
      this.historyTable.hisotoryNumber=res.status?res.status:"";
      let n = this.historyTable.hisotoryNumber.length;
      let s = this.historyTable.hisotoryNumber;
      let tmpArray = [];
      if (n <= 8) {
        //n<=8说明未超过8次,需要进行处理
        for (let i = 0; i < n; i++) {
          let time = "第" + (i + 1) + "次咨询";
          if (s[i] == "1") tmpArray.push({ time: time, status: "已咨询" });
          else if (s[i] == "2") tmpArray.push({ time: time, status: "旷约" });
        }
        for (let i = n; i < 8 ; i++) {
          let time = "第" + (i + 1) + "次咨询";
          tmpArray.push({ time: time, status: "未咨询" });
        }
      } 
      else {
          for (let i = 0; i < n; i++) {
            let time = "第" + (i + 1) + "次咨询";
            if (s[i] == "1") tmpArray.push({ time: time, status: "已咨询" });
            else if (s[i] == "2") tmpArray.push({ time: time, status: "旷约" });
          }
      }
      this.historyTable.historyArray=tmpArray;
      this.historyVisible = true;
    },
    get_result() {
      get_result_teacher({}).then((res) => {
        console.info(res);
        for (let i = 0; i < res.data.length; i++) {
          if (res.data[i].isOk == false) {
            // console.log("sssssssss")
            // console.log(res.data[i].status)
            res.data[i].status=res.data[i].status?res.data[i].status:""
            // console.log(res.data[i].status)
            this.result.push(res.data[i]);
            
          }
        }
        user_inf({}).then((res) => {
          this.userData = res.data;
          for (let i = 0; i < this.result.length; i++) {
            for (let j = 0; j < this.userData.length; j++) {
              //这里不知道会不会出问题，userId应该是账户吧
              if (this.result[i].userId == this.userData[j].name) {
                this.result[i].address = this.userData[j].address;
                this.result[i].phoneNumber = this.userData[j].phoneNumber;
              }
            }
          }
          this.result1 = this.result;
        });
      });
    },
    getChineseDate(time) {
      for (let i = 0; i < timeOptions.length; i++) {
        if (timeOptions[i] == time) return timeChinese[i];
      }
    },
    user_inf() {},
    exportExcel(id, name) {
      exportExcel(id, name);
    },
    addHistory(){
        //TODO: 重新返回一个number
        //这里的status和数据库的status是一样的，上面的status是指中文的状态，historyTable的status是指此次咨询的状态，1 2
        get_result_by_id(
            {resultId:this.historyTable.resultId,
            userId:null,
            timeResult :null,
            resultScore:null,
            teacherId:null,
            isFirst:null,
            resultRemarks:null,
            isSuccess:null,
            userName:null,
            teacherName:null,
            resultTime:null,
            isOk:null,
            status:null,
        }).then(res=>{
            // console.log("sssssssssssssssssssssssss")
            // console.log(res.data)
            let f=res.data
            f.status=this.historyTable.hisotoryNumber+this.historyTable.status
            update_result(f).then(()=>{
            setTimeout(() => {
                location.reload()
            }, 500);
            })

        })
    }
  },
  computed: {
    ...mapGetters({
      userType: "user/getUserType",
      userName: "user/getUserName",
      getRoleName: "role/getRoleName",
      getSidebarTheme: "sidebar/getSidebarTheme",
    }),
  },
};
</script>

<style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>
