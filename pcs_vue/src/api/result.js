import http from '@http/http'
// export const _getUserInfo = (errMsg) => http.GET('/api/user/getcur', {}, errMsg)
// // 登录
// export const login = (user) => http.POST('/api/user/login', user)
// export const post_result = (report_r) => http.POST('/api/result/reporttoresult_success', report_r)
// export const reject = (id) => http.POST('/api/result/reporttoresult_failure', id)
// export const post_time = (time) => http.POST('/api/enpity/get_by_time?time='+time)
// export const post_teacher = (teacher) => http.POST('/api/enpity/get_by_teacher?teacher='+teacher)
//
//
// export const report_his = (query) => http.GET('/api/report/get', query)
// export const report_check = (query) => http.GET('/api/report/getall', query)
// export const report_distribute = (query) => http.GET('/api/report/getenpity', query)
export const get_result_all = (res) => http.GET('/api/result/getall', res)
export const get_review_teacher = (res) => http.GET('/api/review/get_by_teacher', res)
export const get_result_user = (res) => http.POST('/api/result/getperson', res)
export const get_ft_teacher = (res) => http.GET('/api/enpity/getcur', res)
export const get_result_teacher = (res) => http.POST('/api/result/getteacher', res)
export const get_review_all = (res) => http.GET('/api/review/getall', res)
export const give_rev = (res) => http.POST('/api/review/save?resultId='+res.resultId+'&reviewMarks='+res.fellings+'&reviewScore='+res.score)
export const give_eval = (res) => http.POST('/api/evaluation/save?resultId='+res.resultId+'&score='+res.score+'&fellings='+res.fellings)
export const give_eval_by_name = (res) => http.POST('/api/evaluation/getbyteacher?teacher_name='+res)
export const get_result_by_id = (res) => http.POST('/api/result/get',res)
export const update_result = (form) => http.POST('/api/result/update',form)