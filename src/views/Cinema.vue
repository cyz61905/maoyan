<template>
  <DefaultLayout>
    <div class="banner">
      <div class="banner-continer">
        <div class="left">
          <img class="avatar"
               src="https://p0.meituan.net/mmdb/fd146c7848a0ebca36eb869dfef7c9331034607.png@292w_292h_1e_1c"
               alt="CGV影城（信万广场激光IMAX店）">
        </div>
        <div class="mid" v-if="dataLoaded">
          <div class="name">{{ cinema.title + '(' + cinema.shopSign + ')' }}</div>
          <div class="address">{{ cinema.address }}</div>
          <div class="phone">电话：<span>{{ cinema.phone }}</span></div>
          <div class="service">
            <div class="title">影院服务</div>
            <!--
            <div class="item">
                <span>可停车</span>YOYOPARK购物公园停车场，停车15分钟内免费，前2个小时内5元，超1小时，
            </div>
            -->
            <div class="item" v-for="e in JSON.parse(cinema.services)">
              <span>{{ e.service_name }}</span>{{ e.description }}
            </div>
          </div>
        </div>
        <div class="right">

        </div>
      </div>
    </div>
    <div class="main" v-if="dataLoaded">
      <div class="nav">
        <router-link to="/index">猫眼电影</router-link>
        >
        <router-link to="/cinemas"> 影院</router-link>
        >
        <span>CGV影城（信万广场激光IMAX店）</span>
      </div>
      <div class="swiper-continer">
        <ul class="item-list"
            @click="swiperSelect"
            :style="{transform: `translateX(-${swiperBegin}px)`}">
          <li v-for="(e,i) in cinema.filmList"
              :class="{active : currentFilm === i}">
            <img :src="e.posterUrl" :alt="e.name" :data-index="i">
          </li>
        </ul>
        <div class="swiper-button-prev" @click="prev"></div>
        <div class="swiper-button-next" @click="next"></div>
      </div>
      <div class="info-tab">
        <div class="title">
          <span class="name">{{ film.name }}</span>
          <!-- <span>暂无评分</span> -->
          <span class="score" :class="{num : film.score}">
            {{ film.score ? film.score.toFixed(1) : '暂无评' }}分
          </span>
          <div class="movie-desc">
            <div>时长 : <span>{{ film.duration }}分钟</span></div>
            <div>类型 : <span>{{ film.typeList[0].name }}</span></div>
            <div>主演 : <span>{{ film.filmCastList.actor ? film.filmCastList.actor[0].realName : '暂无主演' }}</span>
            </div>
          </div>
        </div>
        <div class="show-date">
          <span>观影时间 :</span>
          <span>
            <span v-for="(e,i) in dateList"
                  class="date-item"
                  :class="{active:filmSession ===i }"
                  @click="filmSession = i">
              {{ e }}
            </span>
          </span>
        </div>
        <table class="show-time">
          <thead>
          <tr>
            <th>放映时间</th>
            <th>语言版本</th>
            <th>放映厅</th>
            <th>售价（元）</th>
            <th>选座购票</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(e,i) in sessions[dateList[filmSession]]">
            <td>
              <div class="begin-time">{{e.playTime.substring(11, 16)}}</div>
              <div class="end-time">{{e.endTime.substring(11, 16)}}散场</div>
            </td>
            <td>{{e.language}}</td>
            <td>{{e.screeningRoom}}</td>
            <td>
              <div class="money">￥<span>{{e.price}}</span></div>
            </td>
            <td><a @click="setStorage(i)">选座购票</a></td>
          </tr>
          </tbody>
        </table>
        <div class="related-cinemas">
          <div class="title">相关影院</div>
          <div class="cinema-list">
            <a href="">CGV影城（信万广场激光IMAX店）</a>
            <a href="">CGV影城（信万广场激光IMAX店）</a>
            <a href="">CGV影城（信万广场激光IMAX店）</a>
            <a href="">CGV影城（信万广场激光IMAX店）</a>
            <a href="">CGV影城（信万广场激光IMAX店）</a>
            <a href="">CGV影城（信万广场激光IMAX店）</a>
            <a href="">CGV影城（信万广场激光IMAX店）</a>
            <a href="">CGV影城（信万广场激光IMAX店）</a>
            <a href="">CGV影城（信万广场激光IMAX店）</a>
          </div>
        </div>
      </div>
    </div>
  </DefaultLayout>
</template>

<script setup>
import DefaultLayout from '@/layout/DefaultLayout.vue'
import { useRoute, useRouter } from 'vue-router'
import { computed, onMounted, ref, watchEffect } from 'vue'
import { ElMessage } from 'element-plus'
import { getCinemaById, getCinemaFilmSession } from '@/api/cinema.js'
import { useFilmSessionStore } from '@/stores/filmSessionStore.js'

const dataLoaded = ref(false)
const route = useRoute()
const router = useRouter()
const cinema = ref({})
const currentFilm = ref(0)
const swiperBegin = ref(0)
const timeList = ref([])
const sessions = ref([])
const dateList = ref([])
const filmSession = ref(0)
const filmSessionStore = useFilmSessionStore()

const film = computed(() => {
  return cinema.value.filmList[currentFilm.value]
})

const swiperSelect = (e) => {
  if (e.target.tagName === 'IMG') {
    currentFilm.value = Number(e.target.dataset.index)
  }
}
const prev = () => {
  if (swiperBegin.value > 0) {
    swiperBegin.value -= 1 * 170
    currentFilm.value = swiperBegin.value / 170
  }
}
const next = () => {
  if (swiperBegin.value < (cinema.value.filmList.length - 7) * 170) {
    swiperBegin.value += 1 * 170
    currentFilm.value = swiperBegin.value / 170
  }
}
const setStorage = (i) => {
  if (cinema.value && cinema.value.filmList[currentFilm.value] && dateList.value[filmSession.value] && sessions.value[dateList.value[filmSession.value]][i]) {
    filmSessionStore.film.value = cinema.value.filmList[currentFilm.value]
    filmSessionStore.cinema.value = cinema.value
    filmSessionStore.session.value = sessions.value[dateList.value[filmSession.value]][i]

    // fixme 此处该不该加value?  不加可以访问，加了反而不行
    console.log(filmSessionStore.date)
    console.log(filmSessionStore.date.value)
    filmSessionStore.date = dateList.value[filmSession.value]

    router.push('/seat')
  } else {
    return false
  }
}
onMounted(async () => {
  let id = Number(route.query.id)
  if (!id) {
    ElMessage.error('请选择影院')
    setTimeout(() => {
      router.replace('/cinemas')
    }, 1000)
    return
  }
  const res = await getCinemaById(id)
  cinema.value = res.data.cinema
  dataLoaded.value = true
  watchEffect(async () => {
    sessions.value = []
    dateList.value = []
    const res = await getCinemaFilmSession(cinema.value.filmList[currentFilm.value].id, cinema.value.id)
    timeList.value = res.data.sort((a, b) => {
      let aa = new Date(a.playTime)
      let bb = new Date(b.playTime)
      return aa.getTime() - bb.getTime()
    })
    timeList.value.forEach(e => {
      let playTime = new Date(e.playTime)
      let now = new Date()
      let isToday = playTime.getDate() === now.getDate()
      let weeks = ['周日', '周一', '周二', '周三', '周四', '周五', '周六']
      let date = `${isToday ? '今日' : weeks[playTime.getDay()]} ${playTime.getMonth() + 1}月${playTime.getDate()}日`
      if (dateList.value.indexOf(date) === -1) {
        dateList.value.push(date)
        sessions.value[date] = []
      }
      sessions.value[date].push(e)
    })
  })
})
</script>

<style scoped>
.banner {
  margin-top: 81px;
  height: 330px;
  width: 100%;
  background: #392f59 url(https://s3.meituan.net/static-prod01/com.sankuai.movie.fe.mywww-files/banner_bg.f7fd103e3b8c16b6f449cce43fc57f45.png) no-repeat 50%;
}

.banner .banner-continer {
  width: 1200px;
  height: 100%;
  margin: 0 auto;
}

.banner .banner-continer .left {
  float: left;
  width: 300px;
  height: 300px;
  margin: 49px 30px 0 30px;
  box-shadow: 0 10px 10px rgba(0, 0, 0, .1);
}

.banner .banner-continer .left .avatar {
  border: 4px solid #fff;
  height: 292px;
  width: 292px;
}

.banner .banner-continer .mid {
  float: left;
  margin-top: 33px;
  width: 600px;
  height: 100px;
  color: #fff;
  font-size: 14px;
}

.banner .banner-continer .mid .name {
  font-size: 26px;
  line-height: 34px;
  margin-bottom: 9px;
  font-weight: 400;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

.banner .banner-continer .mid .address {
  margin-bottom: 6px;
  line-height: 1.3;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

.banner .banner-continer .mid .phone {
  margin-bottom: 20px;
  line-height: 1.3;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

.banner .banner-continer .mid .service {
  width: 410px;
  overflow: hidden;
}

.banner .banner-continer .mid .service .title {
  margin-bottom: 5px;
}

.banner .banner-continer .mid .service .title::after {
  display: block;
  content: "";
  position: relative;
  border-top: 1px solid hsla(0, 0%, 100%, .7);
  top: -10px;
  left: 70px;
}

.banner .banner-continer .mid .service .item {
  margin-bottom: 6px;
  line-height: 18.4px;
  font-size: 9.6px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.banner .banner-continer .mid .service .item span {
  min-width: 50px;
  max-width: 60px;
  text-align: center;
  display: inline-block;
  border: 0.8px solid hsla(0, 0%, 100%, .6);
  border-radius: 2px;
  margin-right: 5px;
}

.banner .banner-continer .mid .service .item p {
  display: inline-block;
  vertical-align: middle;
}

.banner .banner-continer .right {
  margin-top: 99px;
  float: right;
  width: 200px;
  height: 200px;
  background-color: #fff;
  position: relative;
}

.main {
  width: 1200px;
  margin: 67px auto;
}

.main .nav {
  font-size: 14px;
  color: #666;
  margin-bottom: 25px;
}

.main .swiper-continer {
  position: relative;
  box-sizing: border-box;
  height: 280px;
  padding: 22px 5px;
  background-color: #ededed;
  overflow: hidden;
}

.main .swiper-continer .item-list {
  position: relative;
  display: flex;
  flex-wrap: nowrap;
  height: 235px;
  transition: transform .2s;
}

.main .swiper-continer .item-list li {
  flex: none;
  width: 162px;
  height: 227px;
  border: 4px solid #fff;
  transform: scale(0.8);
  transition: transform .2s;
}

.main .swiper-continer .item-list li img {
  width: 100%;
  height: 100%;
}

.main .swiper-continer .item-list li.active {
  position: relative;
  transform: scale(1);
  border-color: #f24030;
}

.main .swiper-continer .item-list li.active::after {
  position: absolute;
  left: 71px;
  bottom: -27px;
  display: block;
  content: '';
  border-width: 11px 14px;
  border-style: solid;
  border-color: transparent transparent #fff transparent;
}

.main .swiper-continer .swiper-button-prev {
  position: absolute;
  top: 0;
  left: 0;
  width: 30px;
  height: 100%;
  background: url('@/assets/images/button-prev.png') no-repeat 50% 50%;
}

.main .swiper-continer .swiper-button-next {
  position: absolute;
  top: 0;
  right: 0;
  width: 30px;
  height: 100%;
  background: url('@/assets/images/button-next.png') no-repeat 50% 50%;
}

.main .info-tab {
  margin-top: 20px;
}

.main .info-tab .title span {
  display: inline-block;
}

.main .info-tab .title .name {
  height: 34px;
  line-height: 34px;
  font-size: 26px;
  font-weight: 400;
  color: #333;
  margin: 0 20px 20px 0;
}

.main .info-tab .title .score.num {
  font-size: 24px;
  color: #faaf00;
}

.main .info-tab .title .score.num::after {
  content: '分';
  font-size: 12px;
}

.main .info-tab .title .movie-desc {
  display: flex;
  font-size: 14px;
  color: #151515;
}

.main .info-tab .title .movie-desc > div {
  margin: 0 40px 20px 0;
  color: #999;
}

.main .info-tab .title .movie-desc div span {
  color: #151515;
}

.main .info-tab .show-date {
  padding: 30px 0;
  border-top: 1px solid #e5e5e5;
  font-size: 14px;
  color: #999;
}

.main .info-tab .show-date .date-item {
  display: inline-block;
  padding: 2px 10px;
  margin-left: 12px;
  line-height: 1.4;
  color: #333;
}

.main .info-tab .show-date .date-item.active {
  color: #fff;
  background-color: #f03d37;
  border-radius: 100px;
}

.main .info-tab .show-time {
  width: 100%;
  color: #333;
  font-size: 14px;
}

.main .info-tab .show-time thead {
  font-size: 16px;
  background-color: #f7f7f7;
}

.main .info-tab .show-time thead tr th {
  width: 20%;
  padding: 16px 0;
  font-weight: bold;
}

.main .info-tab .show-time tbody tr {
  height: 82px;
}

.main .info-tab .show-time tbody tr:nth-child(2n) {
  background-color: #f9f9f9;
}

.main .info-tab .show-time tbody tr td {
  width: 20%;
  text-align: center;
  vertical-align: middle;
}

.main .info-tab .show-time tbody tr td .begin-time {
  font-size: 18px;
  color: #333;
  font-weight: 700;
}

.main .info-tab .show-time tbody tr td .end-time {
  margin-top: 10px;
  font-size: 12px;
  color: #999;
}

.main .info-tab .show-time tbody tr td .money {
  color: #f03d37;
}

.main .info-tab .show-time tbody tr td .money span {
  font-size: 18px;
  font-weight: 700;
}

.main .info-tab .show-time tbody tr td a {
  display: inline-block;
  width: 80px;
  height: 30px;
  color: #fff;
  background-color: #f03d37;
  font-size: 14px;
  line-height: 30px;
  border-radius: 100px;
  text-align: center;
  box-shadow: 0 2px 10px -2px #f03d37;
}

.main .info-tab .show-time tbody tr td a:hover {
  background-color: #ff5e59;
}

.main .info-tab .related-cinemas {
  margin-top: 120px;
}

.main .info-tab .related-cinemas .title {
  color: #000;
  font-size: 1.17em;
  font-weight: bold;
  margin: 19px 0;
}

.main .info-tab .related-cinemas .cinema-list {
  line-height: 21px;
}

.main .info-tab .related-cinemas .cinema-list a {
  margin-right: 5px;
}


</style>
