import http from '@http/http'
export const get_board = () => http.GET('/api/board/getall')
export const add_board = (form) => http.POST('/api/board/save',form)
export const delete_board = (id) => http.POST('/api/board/delete?id='+id)
export const change_board = (form) => http.POST('/api/board/update',form)