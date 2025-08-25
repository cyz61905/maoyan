<template>
  <div class="right">
    <div class="title">我的订单</div>
    <ul class="main" @click="del">
      <li v-for="item in orderList" :key="item.order.id">
        <div class="order-head">
          <div>
            <span class="time">{{ item.order.createTime.substring(0, 16) }}</span>
            <span class="num">猫眼订单号:<span>{{ item.order.orderNum }}</span></span>
          </div>
          <i class="iconfont icon-shanchu" :data-index="item.order.id"></i>
        </div>
        <div class="order-body">
          <img :src="item.film.posterUrl" :alt="item.film.name" />
          <div class="info">
            <div class="name">《<span>{{ item.film.name }}</span>》</div>
            <div class="address">{{ item.cinema.title }}（{{ item.cinema.shopSign }}）</div>
            <div class="position">{{ item.cinemaSession.screeningRoom }} {{ seatList(item.order.seatRealList) }}</div>
            <div class="play-time">{{ date(item.cinemaSession.playTime) }}</div>
          </div>
          <div class="price">￥<span>{{ item.order.price }}</span></div>
          <div class="status">{{ state(item.order.state) }}</div>
          <div class="action">
            <router-link v-if="item.order.state === '0'"
                         :to="`/orderDetail?orderId=${item.order.id}&date=${date(item.cinemaSession.playTime)}`"
                         class="pay">付款
            </router-link>
            <router-link :to="`/orderDetail?orderId=${item.order.id}&date=${date(item.cinemaSession.playTime)}`"
                         class="check-info">
              查看详情
            </router-link>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { inject, onMounted, ref } from 'vue'
import { useUserStore } from '@/stores/userStore.js'
import { ElMessage, ElMessageBox } from 'element-plus'
import { useRouter } from 'vue-router'
import { deleteOrder, getOrderList } from '@/api/order.js'

const userStore = useUserStore()
const router = useRouter()
const orderList = ref([])
const dataLoaded = ref(false)

const refresh = inject('refresh')
const seatList = (seatRealList) => {
  return seatRealList.split(',').reduce((pre, cur) => {
    return pre + `${cur[0]}排${cur[2]}座 `
  }, '').trim()
}
const state = (num) => {
  if (num === '0') {
    return '待支付'
  } else if (num === '1') {
    return '已支付'
  } else if (num === '-1') {
    return '已取消'
  }
}
const date = (d) => {
  let now = new Date()
  let playTime = new Date(d)
  if (playTime.getFullYear() === now.getFullYear() && playTime.getMonth() === now.getMonth() && playTime.getDate() === now.getDate()) {
    return `今天 ${playTime.getMonth() + 1}月${playTime.getDate()}日 ${playTime.getHours()}:${playTime.getMinutes()}`
  } else {
    return `${playTime.getMonth() + 1}月${playTime.getDate()}日 ${playTime.getHours()}:${playTime.getMinutes()}`
  }
}
const del = async (e) => {
  if (e.target.className !== 'iconfont icon-shanchu') {
    return
  }
  let orderId = e.target.dataset.index
  ElMessageBox.confirm('是否删除该订单？', '警告', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    let res = await deleteOrder(orderId)
    if (res.code === 200) {
      ElMessage.success('删除成功')
      setTimeout(() => {
        refresh()
      }, 500)
    } else {
      ElMessage.warning('删除失败')
    }
  })
}
onMounted(async () => {
  if (Object.keys(userStore.user).length === 0) {
    ElMessage.warning('请先登录')
    setTimeout(() => {
      router.push('/login')
    }, 1000)
    return
  }
  const res = await getOrderList(userStore.user.id)
  orderList.value = res.data
  dataLoaded.value = true
})

</script>

<style scoped>
.container .right {
  flex-grow: 1;
  padding-left: 40px;
}

.container .right .title {
  padding: 26px 0;
  color: #ec443f;
  font-size: 18px;
  border-bottom: 1px solid #e1e1e1;
  margin-bottom: 30px;
}

.container .right .main {
  margin-right: 40px;
  overflow-y: scroll;
  height: 800px;
}

.container .right .main li {
  font-size: 14px;
  border: 1px solid #e1e1e1;
  margin-top: 20px;
}

.container .right .main li .order-head {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #f7f7f7;
  padding: 16px 20px;
}

.container .right .main li .order-head .iconfont.icon-shanchu {
  cursor: pointer;
}

.container .right .main li .order-head .num {
  color: #999;
  margin-left: 25px;
}

.container .right .main li .order-body {
  padding: 20px 0 20px 20px;
  display: flex;
  align-items: center;
  color: #333;
  font-size: 14px;
}

.container .right .main li .order-body img {
  width: 66px;
  height: 91px;
}

.container .right .main li .order-body .info {
  width: 49%;
  margin-left: 15px;
  color: #999;
  font-size: 12px;
}

.container .right .main li .order-body .info .name {
  font-size: 16px;
  font-weight: 700;
  margin-left: -5px;
}

.container .right .main li .order-body .info .address,
.container .right .main li .order-body .info .position,
.container .right .main li .order-body .info .play-time {
  margin-top: 10px;
}

.container .right .main li .order-body .info .play-time {
  color: #f03d37;
}

.container .right .main li .order-body .price {
  width: 12%;
  line-height: 95px;
}

.container .right .main li .order-body .status {
  width: 15%;
  line-height: 95px;
}

.container .right .main li .order-body .action {
  flex-grow: 1;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container .right .main li .order-body .action a {
  display: block;
  width: 80px;
  text-align: center;
  cursor: pointer;
}

.container .right .main li .order-body .action .pay {
  height: 30px;
  line-height: 30px;
  background-color: #f03d37;
  color: #fff;
  box-shadow: 0 2px 10px -2px #f03d37;
  border-radius: 15px;
  margin-bottom: 10px;
}
</style>
