import axios from 'axios'

const baseURL = 'http://106.55.153.66:80/api/maoyan/'
// const baseURL = 'http://localhost:80/api/maoyan/'

const instance = axios.create({
  baseURL: baseURL,
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
