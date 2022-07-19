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
          title: '咨询管理',
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
          title: '请假审核',
        },
        {
          path: '/main/user_inf',
          icon: 'el-icon-s-data',
          title: '查看用户列表',
        },
        ///main/all_empty
        {
          path: '/main/all_empty',
          icon: 'el-icon-date',
          title: '查看排班',
        },
        {
          path: '/main/comment_user',
          icon: 'el-icon-s-platform',
          title: '评分',
          group: 'comment',
          children: [
            {
              path: '/main/comment_user',
              icon: 'el-icon-document-remove',
              title: '用户评分'
            },
            {
              path: '/main/comment_teacher',
              icon: 'el-icon-document-checked',
              title: '咨询师评分'
            },
            {
              path: '/main/comment_first',
              icon: 'el-icon-document-checked',
              title: '初访员评分'
            }
          ]
        },
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
          group: 'reserve',
          children:[
            {
              path: '/main/reserve_first',
              icon: '',
              title: '初访预约'
            },
            {
              path: '/main/reserve_teacher',
              icon: 'el-icon-document-checked',
              title: '咨询预约'
            }

          ]
        },
        {
          path: '/main/result',
          icon: 'el-icon-s-platform',
          title: '查看结果',
          group: 'report',
          children: [
            // {
            //   path: '/main/user_result',
            //   icon: 'el-icon-document-remove',
            //   title: '预约结果查询'
            // },
            {
              path: '/main/user_result_f',
              icon: 'el-icon-document-remove',
              title: '初访结果'
            },
            {
              path: '/main/user_result_t',
              icon: 'el-icon-document-remove',
              title: '预约结果'
            },
            {
              path: '/main/report_history',
              icon: 'el-icon-document-checked',
              title: '历史咨询',
            }
          ]
        },
        {
          path: '/main/review_f',
          icon: 'el-icon-search',
          title: '反馈',
          group: 'comment',
          children: [
            {
              path: '/main/review_f',
              title: '初访反馈'
            },
            {
              path: '/main/review_t',
              title: '预约反馈',
            }
          ]
        },
        {
          path: '/main/teacher_inf',
          icon: 'el-icon-menu',
          title: '可选咨询师',
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
          path: '/main/work_distribution',
          icon: 'el-icon-date',
          title: '查看工作安排'
        },
        {
          path: '/main/result',
          icon: 'el-icon-monitor',
          title: '请假',
          group: 'work',
          children: [
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
        },
        {
          path: '/main/teacher_comment',
          icon: 'el-icon-s-promotion',
          title: '用户评分'
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
          path: '/main/work_distribution',
          icon: 'el-icon-date',
          title: '查看工作安排'
        },
        {
          path: '/main/result',
          icon: 'el-icon-monitor',
          title: '请假',
          group: 'work',
          children: [
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
        },
        {
          path: '/main/teacher_comment',
          icon: 'el-icon-s-promotion',
          title: '用户评分'
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
