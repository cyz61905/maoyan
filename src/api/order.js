import request from '@/util/request.js'

export function addOrder(order){
  return request.post('order/add',order)
}

export function cancelOrder(orderId){
  return request.get(`order/cancel?id=${orderId}`)
}

export function getOrderList(userId){
  return request.get(`order/list?userId=${userId}`)
}

export function deleteOrder(orderId){
  return request.delete(`order/delete/${orderId}`)
}

export function getOrderById(orderId){
  return request.get(`order/${orderId}`)
}

export function payOrder(orderId, price){
  return request.get(`alipay/pay?orderNo=${orderId}&amount=${price}`)
}
