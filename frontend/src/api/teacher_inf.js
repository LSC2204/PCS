import http from '@http/http'
export const teacher_inf = query => http.GET('/api/user/getteacher', query)
export const teacher_name = query => http.GET('/api/user/getteacher_name', query)
export const review = query => http.GET('/api/evaluation/getperson', query)
//

