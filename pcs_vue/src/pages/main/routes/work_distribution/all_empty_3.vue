<template>

<div>
<div style="margin-top:30px"></div>
            <el-table :row-class-name="a" :data="ft.filter(data => data.teacherType==3)" height="290">
            <el-table-column type="expand">
                 <template slot-scope="props">

                    <el-table
                        :data="[ft[props.$index]]"
                        
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
                            :data="[ft[props.$index]]"
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
                 </template>
            </el-table-column>
        
            <el-table-column
                    prop="teacherId"
                    label="咨询师编号"
                    width="630">
            </el-table-column>
            <el-table-column
                    prop="teacherName"
                    label="咨询师姓名"
                    width="630">
            </el-table-column>
            </el-table>

<div style="margin-top:80px"></div>
            <el-table :row-class-name="a" :data="ft.filter(data => data.teacherType==4)" height="290">
            <el-table-column type="expand">
                 <template slot-scope="props">

                    <el-table
                        :data="[ft[props.$index]]"
                        
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
                            :data="[ft[props.$index]]"
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
                 </template>
            </el-table-column>
        
            <el-table-column
                    prop="teacherId"
                    label="初访员编号"
                    width="630">
            </el-table-column>
            <el-table-column
                    prop="teacherName"
                    label="初访员姓名"
                    width="630">
            </el-table-column>
            </el-table>






</div>
  
</template>

<script>
//决定采用折叠式的
  import {all_empity} from '../../../../api/teacher_inf'

  export default {
    name:"all_empity",
    data () {
      return {
        dialogVisible: false,
        result: [],
        ft:[],
        id_exchange: 1,
        score:0,
        des: '',
        a:'warning-row'
      }
    },
    created () {

      this.get_all_empity()
    },
    methods: {

      get_all_empity () {
        all_empity({}).then(res => {
          console.info(res)
          this.ft=res.data
        })
      },

    }
  }
</script>
<style >
  .el-table .warning-row {
    background: oldlace;
  }
</style>
