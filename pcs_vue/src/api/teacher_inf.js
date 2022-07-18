import http from '@http/http'
export const teacher_inf = query => http.GET('/api/user/getteacher', query)
export const teacher_name = query => http.GET('/api/user/getteacher_name', query)
export const review = query => http.GET('/api/evaluation/getperson', query)
export const get_all_person = query => http.GET('/api/evaluation/getall_to_person', query)
export const all_empity = () => http.GET('/api/enpity/getall')
export const get_teacher = query => http.GET('/api/evaluation/getteacher', query)

//

