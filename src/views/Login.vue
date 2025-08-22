<template>
  <Header/>
  <div class="main">
    <div class="left">
      <img src="https://obj.pipi.cn/festatic/common/image/91434e659bfbf05f43ae5a8d41b5e84b.png" alt="">
    </div>
    <div class="right">
      <div class="register">
        <div class="title">登录</div>
        <div>
          <div>
            <input type="text" v-model="account" placeholder="请输入账号">
          </div>
          <div>
            <input type="password" v-model="password" placeholder="请输入密码">
          </div>
          <button @click="login">登录</button>
        </div>
      </div>
      <div class="info">
        <div class="agrement">
          <input type="checkbox" v-model="protocol" name="protocol">
          我已阅读并同意
          <a href="">《猫眼用户服务协议》</a>
          <a href="">《隐私政策》</a>
          <RouterLink to="/register">注册</RouterLink>
        </div>
        <p>客服电话：<a href="">1010-5335</a></p>
        <p>未注册的手机号将自动生成新账号</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import Header from '@/components/common/Header.vue'
import { ref } from 'vue'
import { ElMessage } from 'element-plus'
import { userLogin } from '@/api/user.js'
import { useUserStore } from '@/stores/userStore.js'
import { useRouter } from 'vue-router'

const account = ref('')
const password = ref('')
const protocol = ref(false)
const router = useRouter()
const userStore = useUserStore()

const login = async () => {
  if (!protocol.value) {
    ElMessage.warning('请阅读并同意协议')
    return
  }
  if (!account.value && account.value.trim() === '') {
    ElMessage.warning('请输入账号')
    return
  }
  if (!password.value && password.value.trim() === '') {
    ElMessage.warning('请输入密码')
    return
  }
  if (password.value.length < 6 || password.value.length > 18) {
    ElMessage.warning('密码长度在6-18位之间')
    return
  }
  try {
    const loginRes = await userLogin(account.value, password.value)
    if (loginRes.code === 200) {
      ElMessage.success('登录成功')
      userStore.user.value = loginRes.data
      localStorage.setItem('user', JSON.stringify(loginRes.data))
      setTimeout( ()=>{
        router.replace('/')
      },1000)
    }else {
      ElMessage.error(loginRes.msg)
    }
  }catch (e){
    ElMessage.error('登录异常')
  }
}
</script>

<style scoped>
.main{
  display: flex;
  width: 1200px;
  margin-top: 120px;
  background-color: #fff;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
  border-radius: 8px;
  padding: 40px;
  box-sizing: border-box;
}

.left{
  width: 720px;
}
.right{
  flex-grow: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
}
.right .title{
  font-size: 26px;
  color: #333;
  align-self: self-start;
  margin-bottom: 40px;
  font-weight: normal;
}

.right .register input{
  box-sizing: border-box;
  width: 345px;
  height: 45px;
  padding: 10px;
  border: 1px solid #e5e5e5;
  font-size: 16px;
  margin-bottom: 20px;
  border-radius: 5px;
  outline: none;
}
.right .register input::placeholder{
  font-size: 16px;
  color: #ccc;
  border: none;
}
.right .register input:focus{
  border-color: #ef4238;
}

.right .register button{
  width: 345px;
  height: 45px;
  margin-top: 20px;
  border-radius: 4px;
  background-color: #ff5f16;
  color: #fff;
  font-size: 16px;
  border: none;
}

.info{
  margin-top: 20px;
  font-size: 12px;
  color: rgba(0, 0, 0, .5);
}
.info .agrement{
  display: flex;
  align-items: center;
}

.info .agrement input{
  margin-right: 5px;
}

.info .agrement a{
  color: #ef4238;
}

.info p{
  padding-top: 15px;
  text-align: center;
}
button:hover{
  cursor: pointer;
}
input:hover{
  cursor: pointer;
}


</style>
