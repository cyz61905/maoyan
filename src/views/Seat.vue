<template>
  <default-layout>
    <div class="container">
      <div class="progress-bar">
        <div class="step"><span class="num">1</span><span>选择影片场次</span></div>
        <div class="step"><span class="num">2</span><span>选择座位</span></div>
        <div class="step"><span class="num">3</span><span>14分钟内付款</span></div>
        <div class="step"><span class="num">4</span><span>影院取票观影</span></div>
        <div class="line"></div>
        <div class="line-on"></div>
      </div>
      <div class="main">
        <div class="seat">
          <div class="seat-status">
            <div><img src="@/assets/images/noChecked.png" alt="noChecked"><span>可选座位</span></div>
            <div><img src="@/assets/images/saled.png" alt="noChecked"><span>已售座位</span></div>
            <div><img src="@/assets/images/checked.png" alt="noChecked"><span>已选座位</span></div>
            <div><img src="@/assets/images/lovers.png" alt="noChecked"><span>情侣座位</span></div>
          </div>
          <div class="screen">
            <div class="screen-line"></div>
            <span>银幕中央</span>
          </div>
          <ul class="seat-map">
            <!-- <li class="row">
                <div class="num">1</div>
                <div class="seat-continer">
                    <div class="seat-item "></div>
                    <div class="seat-item "></div>
                    <div class="seat-item "></div>
                    <div class="seat-item saled"></div>
                    <div class="seat-item noChecked"></div>
                    <div class="seat-item noChecked"></div>
                    <div class="seat-item noChecked"></div>
                    <div class="seat-item noChecked"></div>
                    <div class="seat-item noChecked"></div>
                    <div class="seat-item noChecked"></div>
                    <div class="seat-item noChecked"></div>
                    <div class="seat-item noChecked"></div>
                    <div class="seat-item noChecked"></div>
                    <div class="seat-item noChecked"></div>
                </div>
            </li> -->
          </ul>
        </div>
        <div class="info">
          <div class="movie-info">
            <div class="poster">
              <img
                src="https://p0.pipi.cn/mediaplus/friday_image_fe/0fa33452bf80514ea98b077dc2ff111e40b25.jpg?imageView2/1/w/464/h/644"
                alt="哪吒之魔童降世">
            </div>
            <div class="basic">
              <div class="name">酱园弄·悬案</div>
              <div>导演：<span class="director">杨荔钠</span></div>
              <div>时长：<span class="duration">131</span>分钟</div>
            </div>
          </div>
          <div class="show-info">
            <div class="item">影院：<span class="name">万达影城（北京朝阳店）</span></div>
            <div class="item">影厅：<span class="screeningRoom">杜比全景声5厅</span></div>
            <div class="item">版本：<span class="language">中文</span></div>
            <div class="item">场次：<span class="date">今天7月1日 01:00</span></div>
            <div class="item">票价：<span class="price">¥<span>70</span>/张</span></div>
          </div>
          <div class="ticket-info">
            <div class="seats">座位：<span>一次最多选6个座位</span></div>
            <!-- <div class="seats">座位：<span><span>7排11座</span></span></div> -->
            <div class="tips">请点击左侧座位图选择座位</div>
            <div class="total-price">总价：<span>¥<span>0</span></span></div>
            <button class="disable">确认选座</button>
          </div>
        </div>
      </div>
    </div>
  </default-layout>
</template>

<script setup>
import DefaultLayout from '@/layout/DefaultLayout.vue'
import { useFilmSessionStore } from '@/stores/filmSessionStore.js'
import { onMounted } from 'vue'
import { storeToRefs } from 'pinia'
import { useUserStore } from '@/stores/userStore.js'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'

const { film, cinema, session, date } = storeToRefs(useFilmSessionStore())
const { user } = storeToRefs(useUserStore())
const router = useRouter()
onMounted(() => {
  if (!film.value || !cinema.value || !session.value || !date.value || !user.value) {
    console.log(film.value)
    console.log(cinema.value)
    console.log(session.value)
    console.log(date.value)
    console.log(user.value)
    ElMessage.warning('数据异常')
    setTimeout(() => {
      router.back()
    }, 1000)
    return
  }

})
</script>

<style scoped>
.container {
  margin-top: 81px;
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

.container .main {
  width: 1200px;
  margin: 0 auto;
  display: flex;
}

.container .main .seat {
  box-sizing: border-box;
  width: 880px;
  padding: 50px 20px 20px 20px;
  font-size: 12px;
  color: #999;
  border-right: 1px solid #e5e5e5;
}

.container .main .seat .seat-status {
  display: flex;
  justify-content: center;
  color: #666;
}

.container .main .seat .seat-status > div {
  width: 100px;
  height: 20px;
  margin-right: 50px;
}

.container .main .seat .seat-status > div img {
  width: 20px;
  height: 20px;
  vertical-align: middle;
  margin-right: 5px;
}

.container .main .seat .screen {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container .main .seat .screen .screen-line {
  width: 80%;
  height: 6px;
  background-color: #f0f0f0;
  margin: 10px auto 10px;
  border-radius: 3px;
}

.container .main .seat .screen span {
  font-size: 14px;
  margin: 10px 0;
}

.container .main .seat .seat-map {
  width: 840px;
}

.container .main .seat .seat-map .row {
  display: flex;
  justify-content: center;
  margin-bottom: 10px;
}

.container .main .seat .seat-map .row .num {
  width: 25px;
  height: 25px;
  line-height: 25px;
  text-align: center;
  margin: 0 4px;
  cursor: pointer;
}

.container .main .seat .seat-map .row .seat-continer {
  width: 594px;
  display: flex;
  justify-content: center;
}

.container .main .seat .seat-map .row .seat-continer .seat-item {
  width: 25px;
  height: 25px;
  margin: 0 4px;
  cursor: default;
}

.container .main .seat .seat-map .row .seat-continer .seat-item.saled {
  background: url('@/assets/images/saled.png') no-repeat;
  background-size: contain;
  background-position: center;
  cursor: not-allowed;
}

.container .main .seat .seat-map .row .seat-continer .seat-item.checked {
  background: url('@/assets/images/checked.png') no-repeat;
  background-size: contain;
  background-position: center;
  cursor: pointer;
}

.container .main .seat .seat-map .row .seat-continer .seat-item.noChecked {
  background: url('@/assets/images/noChecked.png') no-repeat;
  background-size: contain;
  background-position: center;
  cursor: pointer;
}

.container .main .info {
  flex-grow: 1;
  padding: 20px;
}

.container .main .info .movie-info {
  display: flex;
  justify-content: space-around;
}

.container .main .info .movie-info .poster img {
  width: 115px;
  height: 158px;
}

.container .main .info .movie-info .basic {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  color: #666;
  font-size: 14px;
}

.container .main .info .movie-info .basic div {
  margin-bottom: 12px;
}

.container .main .info .movie-info .basic .name {
  color: #333;
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 10px;
  text-align: left;
}

.container .main .info .show-info {
  margin: 20px 0;
  font-size: 14px;
  color: #999;
}

.container .main .info .show-info .item {
  margin-bottom: 15px;
}

.container .main .info .show-info .item > span {
  margin-left: 10px;
  color: #333;
}

.container .main .info .show-info .item:last-child span {
  color: #ff5c38;
  font-weight: bold;
}

.container .main .info .ticket-info {
  font-size: 12px;
  color: #999;
}

.container .main .info .ticket-info .seats > span span {
  position: relative;
  display: inline-block;
  margin-right: 10px;
  margin-bottom: 5px;
  border: 1px solid #ff5c38;
  color: #ff5c38;
  padding: 2px 5px;
  border-radius: 5px;
  cursor: pointer;
}

.container .main .info .ticket-info .seats > span span:hover::after {
  display: block;
  content: 'x';
  height: 12px;
  width: 12px;
  line-height: 12px;
  text-align: center;
  font-size: 12px;
  font-weight: 900;
  position: absolute;
  top: -7px;
  right: -5px;
}

.container .main .info .ticket-info .tips {
  text-align: center;
  color: #ff5c38;
  text-align: center;
  margin: 20px 0;
}

.container .main .info .ticket-info .total-price {
  display: flex;
  justify-content: space-between;
  color: #333;
  font-size: 14px;
}

.container .main .info .ticket-info .total-price > span {
  font-size: 20px;
  color: #ff5c38;
  font-weight: bold;
}

.container .main .info .ticket-info button {
  margin-top: 20px;
  width: 100%;
  height: 40px;
  background-color: #ff5c38;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
}

.container .main .info .ticket-info button.disable {
  background-color: #e3e3e3;
  color: #999;
  cursor: default;
}

</style>
