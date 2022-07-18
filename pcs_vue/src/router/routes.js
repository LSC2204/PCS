const loginPage = [
  {
    path: '/',
    name: 'login',
    component: () =>
      import(/* webpackChunkName: "Login" */ '../pages/login/Login')
  },
  {
    path: '/register',
    name: 'register',
    component: () =>
      import(/* webpackChunkName: "Login" */ '../pages/login/register')
  }
]
//注意这里要改两个部分，还要改store的部分，不能联动确实麻烦
const mainPage = [
  // {
  //   path: '/',
  //   redirect: '/login'
  // },
  {
    path: '/main',
    name: 'main',
    component: () =>
      import(/* webpackChunkName: "Main" */ '../pages/main/Main'),
    children: [
      {
        path: 'home',
        name: 'home',
        component: () =>
            import(
              /* webpackChunkName: "Second" */ '../pages/main/routes/home/home'
            )
      },
      {
        path: 'usercenter',
        name: 'usercenter',
        component: () =>
            import(
              /* webpackChunkName: "Second" */ '../pages/main/routes/usercenter/UserCenter'
            )
      },
      {
        path: 'review',
        name: 'review',
        component: () =>
            import(
                /* webpackChunkName: "Second" */ '../pages/main/routes/review/review'
                )
      },
      {
        path: 'report',
        name: 'report',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/report/report'
            )
      },
      {
        path: 'user_result',
        name: 'user_result',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/user_result/user_result'
            )
      },
      {
        path: 'teacher_inf',
        name: 'teacher_inf',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/teacher_inf/teacher_inf'
            )
      },
      {
        path: 'report_check',
        name: 'report_check',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/report_check/report_check'
            )
      },
      {
        path: 'user_inf',
        name: 'user_inf',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/user_inf/user_inf'
            )
      },
      {
        path: 'work_distribution',
        name: 'work_distribution',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/work_distribution/work_distribution'
            )
      },
      {
        path: 'work_history',
        name: 'work_history',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/work_history/work_history'
            )
      },
      {
        path: 'report_history',
        name: 'report_history',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/report_history/report_history'
            )
      },
      {
        path: 'report_checked',
        name: 'report_checked',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/report_checked/report_checked'
            )
      },
      {
        path: 'reserve',
        name: 'reserve',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/reserve/reserve'
            )
      },
      {
        path: 'rest_reserve',
        name: 'rest_reserve',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/rest/rest_reserve'
            )
      },
      {
        path: 'rest_check',
        name: 'rest_check',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/rest/rest_check'
            )
      },
      {
        path: 'rest_delete',
        name: 'rest_delete',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/rest/rest_delete'
            )
      },
      {
        path: 'rest_history',
        name: 'rest_history',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/rest/rest_history'
            )
      },
      //2022/7/17
      {
        path: 'all_empty',
        name: 'all_empty',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/work_distribution/all_empty_3'
            )
      },
      //增加三个评分界面
      {
        path: 'comment_user',
        name: 'comment_user',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/comment/user'
            )
      },
      {
        path: 'comment_teacher',
        name: 'comment_teacher',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/comment/teacher'
            )
      },
      {
        path: 'comment_first',
        name: 'comment_first',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/comment/first'
            )
      },//添加初访预约和咨询预约
      {
        path: 'reserve_first',
        name: 'reserve_first',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/reserve/reserve_first.vue'
            )
      },
      {
        path: 'reserve_teacher',
        name: 'reserve_teacher',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/reserve/reserve_teacher.vue'
            )
      },//增加user_result
      {
        path: 'user_result_f',
        name: 'user_result_f',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/user_result/user_result_f'
            )
      },
      {
        path: 'user_result_t',
        name: 'user_result_t',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/user_result/user_result_t'
            )
      },//增加review_f
      {
        path: 'review_f',
        name: 'review_f',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/review/review_f.vue'
            )
      },
      {
        path: 'review_t',
        name: 'review_t',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/review/review_t.vue'
            )
      },
      {
        path: 'teacher_comment',
        name: 'teacher_comment',
        component: () =>
          import(
            /* webpackChunkName: "Second" */ '../pages/main/routes/comment/teacherPage.vue'
            )
      }
    ]
  }
]

const errorPage = [
  {
    path: '/notFound',
    name: 'notFound',
    component: () =>
      import(/* webpackChunkName: "NotFound" */ '../pages/error/NotFound')
  },
  {
    path: '/forbidden',
    name: 'forbidden',
    component: () =>
      import(/* webpackChunkName: "Forbidden" */ '../pages/error/Forbidden')
  },
  {
    path: '/badGateway',
    name: 'badGateway',
    component: () =>
      import(/* webpackChunkName: "BadGateway" */ '../pages/error/BadGateway')
  },
  {
    path: '*',
    redirect: '/notFound'
  }
]
export default [...loginPage, ...mainPage, ...errorPage]
