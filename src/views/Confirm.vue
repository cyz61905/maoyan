<template>
  <DefaultLayout>
    <div class="container">
      <div class="progress-bar">
        <div class="step completed"><span class="num"><i
          class="iconfont icon-duigou"></i></span><span>选择影片场次</span></div>
        <div class="step completed"><span class="num"><i class="iconfont icon-duigou"></i></span><span>选择座位</span>
        </div>
        <div class="step active"><span class="num">3</span><span>14分钟内付款</span></div>
        <div class="step"><span class="num">4</span><span>影院取票观影</span></div>
        <div class="line"></div>
        <div class="line-on" :style="{ width:(35 + 23)+'%'}"></div>
      </div>
      <div class="main" v-if="dataLoaded">
        <div class="countdown">
          <i class="iconfont icon-countDown"></i>
          <div class="content">
            <div class="time">请在 <span>{{ min > 9 ? min : '0' + min }}</span> 分
              <span>{{ second > 9 ? second : '0' + second }}</span> 秒内完成支付
            </div>
            <div class="help">超时订单会自动取消，如遇支付问题，请致电猫眼客服：1010-5335</div>
          </div>
        </div>
        <table class="order-info">
          <thead>
          <tr>
            <th>影片</th>
            <th>时间</th>
            <th>影院</th>
            <th>座位</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>
              {{ order.filmName }}
            </td>
            <td>
              {{ order.playTime.substring(0, 16).replace('T', ' ') }}
            </td>
            <td>
              {{ order.cinemaName }}
            </td>
            <td>
              {{ order.session + ' ' + seatList }}
            </td>
          </tr>
          </tbody>
        </table>
        <div class="pay">
          实付金额：<span>¥<span>{{ order.price }}</span></span>
          <button>确认支付</button>
        </div>
      </div>
    </div>
  </DefaultLayout>
</template>

<script setup>
import DefaultLayout from '@/layout/DefaultLayout.vue'
import { onMounted, ref } from 'vue'
import { useOrderStore } from '@/stores/orderStore.js'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import { cancelOrder } from '@/api/order.js'

const router = useRouter()
const orderStore = useOrderStore()
const { order } = orderStore
const min = ref(0)
const second = ref(0)
const seatList = ref('')
const dataLoaded = ref(false)
onMounted(() => {
  console.log(order)
  if (Object.keys(order).length === 0) {
    ElMessage.warning('非法访问')
    setTimeout(() => {
      router.back()
    }, 1000)
    return
  }
  dataLoaded.value = true
  let orderTime = new Date(order.orderCreateTime)
  let now = new Date()
  let time = 15 * 60 - Math.floor((now.getTime() - orderTime.getTime()) / 1000)
  min.value = Math.floor(time / 60)
  second.value = time % 60
  const timer = setInterval(async () => {
    if (time <= 0) {
      clearInterval(timer)
      ElMessage.warning('订单超时已取消')
      await cancelOrder(order.orderId)
      router.back()
      return
    }
    time--
    min.value = Math.floor(time / 60)
    second.value = time % 60
  }, 1000)
  seatList.value = order.seatRealList.split(',').reduce((pre, cur) => {
    return pre + `${cur[0]}排${cur[2]}座 `
  }, '').trim()
})
</script>

<style scoped>
.container {
  margin-top: 81px;
  width: 1200px;
}

.container .progress-bar {
  position: relative;
  box-sizing: border-box;
  width: 1200px;
  margin: 0 auto;
  padding: 20px 100px;
  display: flex;
  color: #999;
  font-size: 14px;
}

.container .progress-bar .line {
  position: absolute;
  top: 35px;
  left: 120px;
  right: 120px;
  height: 2px;
  background-color: #e5e5e5;
  z-index: -1;
}

.container .progress-bar .line-on {
  position: absolute;
  top: 35px;
  left: 120px;
  width: 35%;
  height: 2px;
  background-color: #ff5c38;
  z-index: -1;
}

.container .progress-bar .step {
  width: 25%;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container .progress-bar .step .num {
  width: 30px;
  height: 30px;
  line-height: 30px;
  text-align: center;
  border-radius: 50%;
  margin-bottom: 10px;
  background-color: #fff;
  border: 1px solid #e5e5e5;
}

.container .progress-bar .step.completed .num {
  border-color: #ff5c38;
  color: #ff5c38;
}

.container .progress-bar .step.active .num {
  background-color: #ff5c38;
  border-color: #ff5c38;
  color: #fff;
}

.container .main .countdown {
  display: flex;
  align-items: center;
  background-color: #fff2f0;
  border: 1px solid #ffebe8;
  border-radius: 4px;
  padding: 15px;
  margin: 20px 0;
}

.container .main .countdown i {
  color: #ff5c38;
  font-size: 24px;
  margin-right: 10px;
}

.container .main .countdown .content {
  font-size: 14px;
  color: #666;
}

.container .main .countdown .content div {
  margin: 10px;
}

.container .main .countdown .content .time span {
  font-size: 18px;
  font-weight: bold;
  color: #ff5c38;
}

.container .main .countdown .content .help {
  color: #999;
  font-size: 12px;
}

.container .main .order-info {
  width: 100%;
  font-size: 14px;
  text-align: left;
}

.container .main .order-info thead {
  color: #999;
}

.container .main .order-info thead th {
  padding: 15px;
}

.container .main .order-info tbody {
  color: #333;

}

.container .main .order-info tbody td {
  padding: 15px;
}

.container .main .pay {
  display: flex;
  align-items: center;
  margin-top: 20px;
  float: right;
  font-size: 14px;
  color: #333;
}

.container .main .pay > span {
  font-size: 18px;
  font-weight: bold;
  color: #ff5c38;
  margin-left: 5px;
}

.container .main .pay button {
  margin-left: 15px;
  width: 120px;
  height: 40px;
  background-color: #ff5c38;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
}

.container .main .pay button.disable {
  background-color: #e3e3e3;
  color: #999;
  cursor: default;
}

</style>
