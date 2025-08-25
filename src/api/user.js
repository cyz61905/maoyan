import request from '@/util/request.js'

export function userLogin(username, password) {
  return request.post('user/login', { username, password },{headers:{'Content-Type': 'application/x-www-form-urlencoded'}})
}

export function userRegister(username, password, alignPassword) {
  return request.post('user/register', { username, password, alignPassword })
}

export function getUserById(userId) {
  return request.get(`user/${userId}`)
}

export function updateUser(data) {
  return request.put('user/update', data)
}
