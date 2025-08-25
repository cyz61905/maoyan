<template>
  <DefaultLayout>
    <div class="main" v-if="dataLoaded" ref="main">
      <div class="state">
        <div :style="{display: orderDetail.state === '0'?'block':''}" class="state-item nopay">
          <div class="icon">
            <i class="iconfont icon-countDown"></i>
          </div>
          <div class="text">
            <div class="status">待支付</div>
            <div class="down">请在<span class="min">{{ min > 9 ? min : '0' + min }}</span>分<span
              class="sec">{{ sec > 9 ? sec : '0' + sec }}</span>秒内完成支付
            </div>
          </div>
        </div>
        <div :style="{display: orderDetail.state === '-1'?'block':''}" class="state-item cancel">已取消</div>
        <div :style="{display: orderDetail.state === '1'?'block':''}" class="state-item payed">已支付</div>
      </div>
      <div class="order-info">
        <div class="title">
          <span>猫眼订单号:<span>{{ orderDetail.orderNum }}</span></span>
          <div class="tips">（有订单问题可拨打猫眼客服电话<span>1010-5335</span>，工作时间: 9:00-24:00）</div>
        </div>
        <div class="content">
          <div class="item">
            <div class="tag">影片</div>
            <div class="tag">时间</div>
            <div class="tag">影院</div>
            <div class="tag">座位</div>
          </div>
          <div class="item">
            <div class="tag name">{{ orderDetail.filmName }}</div>
            <div class="tag play-time">{{ date }}</div>
            <div class="tag cinema-name">{{ orderDetail.cinemaName }}</div>
            <div class="tag position">{{ seatRealList }}</div>
          </div>
        </div>
      </div>
      <div class="cinema-info">
        <div class="left">
          <div class="name">{{ orderDetail.cinemaName }}</div>
          <div>地址: <span class="addr">{{ orderDetail.cinemaAddress }}</span></div>
          <div>电话: <span class="phone">{{ orderDetail.phone }}</span></div>
        </div>
        <div class="right">总价: <span>￥<span class="num">{{ orderDetail.price }}</span></span></div>
      </div>
      <div class="btn-box" :style="{display: orderDetail.state === '0'?'block':''}">
        <button class="pay" @click="pay">立即支付</button>
        <div class="cancel" @click="cancel">取消订单</div>
      </div>
      <div v-html="redirect" id="myScript"></div>
    </div>
  </DefaultLayout>
</template>

<script setup>
import DefaultLayout from '@/layout/DefaultLayout.vue'
import { useRoute, useRouter } from 'vue-router'
import { computed, inject, onMounted, ref, useTemplateRef } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { cancelOrder, getOrderById, payOrder } from '@/api/order.js'

const router = useRouter()
const route = useRoute()
const orderId = Number(route.query.orderId)
const date = route.query.date
const orderDetail = ref({})
const dataLoaded = ref(false)
const min = ref(0)
const sec = ref(0)
const flag = ref(false)
const refresh = inject('refresh')
const redirect = ref('')
const seatRealList = computed(() => {
  return orderDetail.value.seatRealList.split(',').reduce((pre, cur) => {
    return pre + `${cur[0]}排${cur[2]}座 `
  }, '').trim()
})

const countDown = async () => {
  let total = 15 * 60
  let create = new Date(orderDetail.value.orderCreateTime)
  let now = new Date()
  let remain = total - Math.floor((now.getTime() - create.getTime()) / 1000)
  if (remain > 0) {
    min.value = Math.floor(remain / 60)
    sec.value = remain % 60

    let timer = setInterval(() => {
      if (remain <= 0) {
        clearInterval(timer)
      }
      remain--
      min.value = Math.floor(remain / 60)
      sec.value = remain % 60
    }, 1000)
  } else {
    let res = await cancelOrder(orderId)
    if (res.code === 200) {
      ElMessage.warning('支付超时,订单已取消')
      refresh()
    }
  }
}
const pay = async () => {
  if (flag.value) return
  flag.value = true
  let res = await payOrder(orderDetail.value.orderId, orderDetail.value.price)
  ElMessage.success('正在跳转到支付平台...')
  setTimeout(() => {

    let i = res.indexOf('<script')
    redirect.value = res.substring(0, i)
    let sc = res.substring(i+8,res.length-9)
    console.log(redirect.value)
    console.log(sc)
    const script = document.createElement('script')
    script.textContent = sc
    console.log(script)
    document.getElementById('myScript').appendChild(script)
  }, 1000)
}
const cancel = async () => {
  ElMessageBox.confirm('是否取消该订单？', '警告', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    let res = await cancelOrder(orderId)
    if (res.code === 200) {
      ElMessage.success('取消成功')
      setTimeout(() => {
        refresh()
      }, 500)
    } else {
      ElMessage.warning('取消失败')
    }
  })
}
onMounted(async () => {
  if (!orderId) {
    ElMessageBox.error('参数错误')
    setTimeout(() => {
      router.back()
    }, 1000)
    return
  }
  const res = await getOrderById(orderId)
  if (res.code !== 200) {
    ElMessage.error(res.data.msg)
    return
  }
  orderDetail.value = res.data
  dataLoaded.value = true
  if (orderDetail.value.state === '0') {
    countDown()
  }
})


</script>

<style scoped>
.main {
  width: 1200px;
  margin-top: 81px;
  color: #333;
  font-size: 14px;
}

.main .state-item {
  display: none;
  margin-top: 40px;
  width: 100%;
  height: 110px;
  background-color: #fffbf2;
}

.main .state-item.payed,
.main .state-item.cancel {
  color: #faaf00;
  font-size: 24px;
  line-height: 110px;
  padding-left: 50px;
  font-weight: 700;
}

.main .state-item .icon {
  float: left;
  width: 50px;
  height: 100%;
  line-height: 110px;
  text-align: center;
  margin-left: 20px;
}

.main .state-item .icon i {
  font-size: 40px;
  color: #fec110;
}

.main .state-item .text {
  float: left;
  padding: 28px 0;
  height: 110px;
  margin-left: 10px;
  box-sizing: border-box;
}

.main .state-item .text .status {
  color: #faaf00;
  font-size: 24px;
  font-weight: 700;
}

.main .state-item .text .down {
  font-size: 14px;
  color: #999;
  margin-top: 8px;
}

.main .state-item .text .down span {
  color: #faaf00;
  margin: 0 3px;
}

.main .order-info {
  margin-top: 40px;
}

.main .order-info .title {
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 16px;
}

.main .order-info .title .tips {
  font-size: 12px;
  color: #666;
}

.main .order-info .title .tips span {
  color: #f03d37;
}

.main .order-info .content {
  margin-top: 10px;
  border: 1px solid #e5e5e5;
}

.main .order-info .content .item {
  height: 50px;
  display: flex;
  width: 100%;
}

.main .order-info .content .item:nth-child(2n+1) {
  background-color: #f7f7f7;
}

.main .order-info .content .item .tag {
  font-size: 16px;
  color: #333;
  width: 25%;
  padding: 14px 0;
  font-weight: 400;
  line-height: 22px;
  text-align: center;
}

.main .order-info .content .item .tag.play-time {
  font-size: 14px;
  color: #f03d37;
}

.main .order-info .content .item .tag.cinema-name,
.main .order-info .content .item .tag.position {
  font-size: 14px;
}

.main .cinema-info {
  margin-top: 40px;
  display: flex;
  justify-content: space-between;
  font-size: 14px;
}

.main .cinema-info .left div {
  margin-bottom: 8px;
}

.main .cinema-info .left .name {
  line-height: 20.67px;
  font-size: 16px;
  font-weight: 700;
}

.main .cinema-info .right {
  font-size: 14px;
  color: #333;
  float: right;
  margin-top: 35px;
}

.main .cinema-info .right > span {
  color: #f03d37;
  font-weight: 700;
  font-size: 26px;
}

.main .cinema-info .right > span > span {
  font-size: 36px;
}

.main .btn-box {
  display: none;
  margin-top: 40px;
}

.main .btn-box .cancel {
  float: right;
  cursor: pointer;
  margin-top: 38px;
  margin-right: 20px;
}

.main .btn-box .pay {
  float: right;
  cursor: pointer;
  margin-top: 16px;
  width: 190px;
  height: 42px;
  line-height: 42px;
  text-align: center;
  color: #fff;
  background-color: #f03d37;
  border-radius: 100px;
  box-shadow: 0 2px 10px -2px #f03d37;
  border: none;
}

.main .btn-box .pay.disable {
  background-color: #e3e3e3;
  color: #999;
  cursor: default;
}
</style>
