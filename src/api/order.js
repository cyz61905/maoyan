import request from '@/util/request.js'

export function addOrder(order){
  return request.post('order/add',order)
}
