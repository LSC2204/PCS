import http from '@http/http'
export const _getUserInfo = (errMsg) => http.GET('/api/user/getcur', {}, errMsg)
// 登录
export const login = (user) => http.POST('/api/user/login', user)
export const submit_reserve = (res_inf) => http.POST('/api/report/save', res_inf)
export const user_inf = query => http.GET('/api/user/getuser', query)
export const tea_inf = query => http.GET('/api/user/getteacher', query)
export const getUserInfo = () => http.GET('/api/user/getcurPerson')
export const submitUserBasic = (userInfo)=>{
    console.log(userInfo)
    http.POST('/api/user/update_person?userId='+userInfo.user_id+'&email='+userInfo.email+"&address="+userInfo.address+
    "&phoneNumber="+userInfo.phone)
}
export const submitUserPwd = (form,userInfo)=>{
    http.POST("/api/user/update_person?userId="+userInfo.user_id+"&email=&address="+
    "&phoneNumber=&password="+form.password)
}
export const create = (res) => {
    console.log(res)

    http.POST('/api/user/add_person', res)

}
