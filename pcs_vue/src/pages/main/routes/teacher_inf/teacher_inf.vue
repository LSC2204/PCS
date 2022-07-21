<template>
<div>
   <el-button style="margin:10px 10px" size="small" type="primary" @click="exportExcel('s','咨询师列表')">导出excel</el-button>
      <el-table
      id="s"
            :data="teacher_infor"
            border
            style="width: 100%">
        <el-table-column
                prop="personId"
                label="id"
                width="180">
        </el-table-column>
        <el-table-column
                prop="personName"
                label="姓名"
                width="360">
        </el-table-column>
        <el-table-column
                prop="sex"
                label="性别"
                width="180">
        </el-table-column>
        <el-table-column
                prop="phoneNumber"
                label="电话号码">
        </el-table-column>
    </el-table>
</div>

</template>

<script>
  import {teacher_inf} from '@api/teacher_inf'
  import {exportExcel} from "@api/file"
  export default {
    name: 'teacher_inf',
    data() {
      return {
        teacher_infor:[]
      }
    },
    created(){
      this.teacher_inf()
    },
    methods:{
      teacher_inf(){
        teacher_inf({}).then(res=>{
          console.info(res)
          this.teacher_infor=res.data
        })
      },
        exportExcel(id,name){
          exportExcel(id,name);
        }
    }
  }
</script>

<style scoped>

</style>
