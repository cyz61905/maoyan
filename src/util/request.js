import axios from 'axios'

const instance = axios.create({
  baseURL: 'http://localhost:8080/maoyan/',
  timeout: 1000,
  headers: {
    'Content-Type': 'application/json;charset=utf-8'
  }
})

instance.interceptors.request.use(config => {
  return config
}, (err) => {
  return Promise.reject(err)
})

instance.interceptors.response.use((res) => {
  return res.data
}, (err) => {
  return Promise.reject(err)
})

export default instance
