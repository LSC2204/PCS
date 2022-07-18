import http from '@http/http'
// 分页查询
export const bookPageList = (query) => http.GET('/api/book/pageList', query)
// 图书类别列表
export const bookTypeList = () => http.GET('/api/bookType/list')
// 图书皮偏高删除
export const bookDeteles = (query) => http.POST('/api/book/deletes', query)
// 图书修改
export const bookUpdate = (book) => http.POST('/api/book/update', book)
// 下载
export const bookDownloda = () => http.EXPORT('/api/file/download1')
// 导出
export const bookExport = () => http.EXPORT('/api/book/export')