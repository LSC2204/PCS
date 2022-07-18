export default {
  mainTypeMap: {
    1: {
      roleName: '中心管理员',
      linksData: [
        {
          path:"/#/main/usercenter",
          pathName : "用户信息",
          icon:"el-icon-user",
          color:"#2d8cf0"
        },
        {
          path:"/#/main/report-check",
          pathName : "待审核预约表",
          icon:"el-icon-document-remove",
          color:"#19be6b"
        },
        {
          path:"/#/main/report_checked",
          pathName : "已审核预约表",
          icon:"el-icon-document-checked",
          color:"#ff9900"
        },
        {
          path:"/#/main/user_inf",
          pathName : "所有用户",
          icon:"el-icon-s-data",
          color:"#e46cbb"
        },

      ]
    
      
    },
    2: {
      roleName: '普通用户',
      linksData: [
        {
          path:"/#/main/usercenter",
          pathName : "用户信息",
          icon:"el-icon-user",
          color:"#2d8cf0"
        },
        {
          path:"/#/main/reserve",
          pathName : "心理咨询预约",
          icon:"el-icon-message",
          color:"#19be6b"
        },
        {
          path:"/#/main/user_result",
          pathName : "预约结果查询",
          icon:"el-icon-search",
          color:"#ff9900"
        },
        {
          path:"/#/main/report_history",
          pathName : "历史预约",
          icon:"el-icon-tickets",
          color:"#e46cbb"
        },

      ]
    },
    3: {
      roleName: '咨询师',
      linksData: [
        {
          path:"/#/main/usercenter",
          pathName : "用户信息",
          icon:"el-icon-user",
          color:"#2d8cf0"
        },
        {
          path:"/#/main/work_distribution",
          pathName : "查看工作安排",
          icon:"el-icon-message",
          color:"#19be6b"
        },
        {
          path:"/#/main/work_history",
          pathName : "咨询记录",
          icon:"el-icon-search",
          color:"#ff9900"
        },
        // {
        //   path:"/#/main/",
        //   pathName : "请假",
        //   icon:"el-icon-tickets",
        //   color:"#e46cbb"
        // },
      ]
    },
    4: {
      roleName: '初访员'
    }
  }
}
