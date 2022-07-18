import http from '@http/http'
export const _getUserInfo = (errMsg) => http.GET('/api/user/getcur', {}, errMsg)
// 登录
export const login = (user) => http.POST('/api/user/login', user)
export const post_result = (report_r) => http.POST('/api/result/reporttoresult_success', report_r)
export const reject = (id) => http.POST('/api/result/reporttoresult_failure', id)
export const post_time = (data) => http.POST('/api/enpity/get_by_time?time='+data.time+"&isFirst="+data.isFirst)
export const post_teacher = (teacher) => http.POST('/api/enpity/get_by_teacher?teacher='+teacher)


export const report_his = (query) => http.GET('/api/report/get', query)
export const report_check = (query) => http.GET('/api/report/getall', query)
export const report_distribute = (query) => http.GET('/api/report/getenpity', query)

