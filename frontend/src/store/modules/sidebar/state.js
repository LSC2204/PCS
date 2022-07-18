export default {
  sidebarMap: {
    1: {
      main: [
        // {
        //   groupTitle: '分组1'
        // },
        {
          path: '/main/home',
          icon: 'el-icon-s-custom',
          title: '主页',
          group: 'home',
          children:[
            {
              path: '/main/home',
              icon: 'el-icon-document-remove',
              title: '用户主页'
            },
            {
              path: '/main/usercenter',
              icon: 'el-icon-document-checked',
              title: '用户信息'
            }

          ]
        },
        {
          path: '/main/report-check',
          icon: 'el-icon-s-platform',
          title: '预约表管理',
          group: 'second',
          children: [
            {
              path: '/main/report_check',
              icon: 'el-icon-document-remove',
              title: '待审核预约表'
            },
            {
              path: '/main/report_checked',
              icon: 'el-icon-document-checked',
              title: '已审核预约表'
            }
          ]
        },
        {
          path: '/main/rest_check',
          icon: 'el-icon-s-check',
          title: '咨询师请假审核',
        },
        {
          path: '/main/user_inf',
          icon: 'el-icon-s-data',
          title: '查看用户列表',
        }
      ]
    },
    2:{
      main:[
        {
          path: '/main/home',
          icon: 'el-icon-s-custom',
          title: '主页',
          group: 'home',
          children:[
            {
              path: '/main/home',
              icon: '',
              title: '用户主页'
            },
            {
              path: '/main/usercenter',
              icon: 'el-icon-document-checked',
              title: '用户信息'
            }

          ]
        },
        {
          path: '/main/reserve',
          icon: 'el-icon-message',
          title: '心理咨询预约',
        },
        {
          path: '/main/result',
          icon: 'el-icon-s-platform',
          title: '预约相关',
          group: 'report',
          children: [
            {
              path: '/main/user_result',
              icon: 'el-icon-document-remove',
              title: '预约结果查询'
            },
            {
              path: '/main/report_history',
              icon: 'el-icon-document-checked',
              title: '历史预约'
            }
          ]
        },
        {
          path: '/main/review',
          icon: 'el-icon-search',
          title: '咨询反馈表查询',
        },
        {
          path: '/main/teacher_inf',
          icon: 'el-icon-menu',
          title: '心理咨询师阵容',
        },


      ]

    },
    3:{
      main:[
        {
          path: '/main/home',
          icon: 'el-icon-s-custom',
          title: '主页',
          group: 'home',
          children:[
            {
              path: '/main/home',
              icon: '',
              title: '用户主页'
            },
            {
              path: '/main/usercenter',
              icon: 'el-icon-document-checked',
              title: '用户信息'
            }

          ]
        },
        {
          path: '/main/result',
          icon: 'el-icon-monitor',
          title: '工作相关',
          group: 'work',
          children: [
            {
              path: '/main/work_distribution',
              title: '查看工作安排'
            },
            {
              path: '/main/rest_reserve',
              title: '请假'
            },
            {
              path: '/main/rest_delete',
              title: '销假'
            },
            {
              path: '/main/rest_history',
              title: '请假记录'
            }
          ]
        },
        {
          path: '/main/work_history',
          icon: 'el-icon-search',
          title: '工作咨询记录'
        }
      ]
    },
    4:{
      main:[
        {
          path: '/main/home',
          icon: 'el-icon-s-custom',
          title: '主页',
          group: 'home',
          children:[
            {
              path: '/main/home',
              icon: '',
              title: '用户主页'
            },
            {
              path: '/main/usercenter',
              icon: 'el-icon-document-checked',
              title: '用户信息'
            }

          ]
        },
        {
          path: '/main/result',
          icon: 'el-icon-monitor',
          title: '工作相关',
          group: 'work',
          children: [
            {
              path: '/main/work_distribution',
              title: '查看工作安排'
            },
            {
              path: '/main/rest_reserve',
              title: '请假'
            },
            {
              path: '/main/rest_delete',
              title: '销假'
            },
            {
              path: '/main/rest_history',
              title: '请假记录'
            }
          ]
        },
        {
          path: '/main/work_history',
          icon: 'el-icon-search',
          title: '工作咨询记录'
        }
      ]
    }
  },
  sidebarTheme: {
    dark: {
      background: '#1f2c35',
      text: '#ffffff',
      activeText: '#ffffff'
    },
    light: {
      background: '#ffffff',
      text: '#000000',
      activeText: '#1890ff'
    }
  }
}
