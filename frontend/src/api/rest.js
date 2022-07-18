import http from '@http/http'
//根据当前老师获取空闲时间
export const getSpareTime = () => http.GET('/api/enpity/getcur')
//需要请假时间和请假原因  noteReason noteTime
export const sendRestRequest = (data) => http.POST('/api/note/add',data)
//获取所有的请假表信息
export const getAllRestData = ()  => http.POST('/api/note/getall')
//同意
export const agreeRestRequest = (noteId)  => http.POST('/api/note/agree?noteId='+noteId)
//驳回
export const disagreeRestRequest = (noteId)  => http.POST('/api/note/overrule?noteId='+noteId)
//销假
export const endRestRequest = (noteId)  => http.POST('/api/note/end?noteId='+noteId)
//得到自己的请假信息
export const getMyRest = ()  => http.POST('/api/note/getowner')