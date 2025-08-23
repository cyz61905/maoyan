<template>
  <DefaultLayout>
    <div class="subnav">
      <a class="active" href="">正在热映</a>
      <a href="">即将上映</a>
      <a href="">经典影片</a>
    </div>
    <div class="main">
      <div class="movie-select">
        <div class="type">
          <span>类型:</span>
          <div class="options" @click="optionsChange('type',$event)">
            <a data-id="" :class="{active: typeId === ''}">全部</a>
            <a v-for="item in typeList" :key="item.id"
               :class="{active: Number(typeId) === item.id}"
               :data-id="item.id">
              {{ item.name }}
            </a>
          </div>
        </div>
        <div class="type border">
          <span>区域:</span>
          <div class="options" @click="optionsChange('region',$event)">
            <a data-id="" :class="{active: regionId === ''}">全部</a>
            <a v-for="item in regionList" :key="item.id"
               :class="{active: Number(regionId) === item.id}"
               :data-id="item.id">
              {{ item.name }}
            </a>
          </div>
        </div>
        <div class="type">
          <span>年代:</span>
          <div class="options" @click="optionsChange('year',$event)">
            <a data-id="" :class="{active: yearId === ''}">全部</a>
            <a v-for="item in 15" :key="item"
               :class="{active: Number(yearId) === 2026-item}"
               :data-id="2026-item">
              {{ 2026 - item }}
            </a>
            <a data-id="2000-2010" :class="{active: yearId === '2000-2010'}">2000-2010</a>
            <a data-id="1990-1999" :class="{active: yearId === '1990-1999'}">90年代</a>
            <a data-id="1980-1989" :class="{active: yearId === '1980-1989'}">80年代</a>
            <a data-id="1970-1979" :class="{active: yearId === '1970-1979'}">70年代</a>
            <a data-id="1900-1969" :class="{active: yearId === '1900-1969'}">70年代之前</a>
          </div>
        </div>
      </div>
      <div class="movies-sorter">
        <el-radio-group v-model="sortId">
          <el-radio :value="0">按热门排序</el-radio>
          <el-radio :value="1">按时间排序</el-radio>
          <el-radio :value="2">按评价排序</el-radio>
        </el-radio-group>
      </div>
      <div class="movie-list">
        <ul>
          <li v-for="item in formatFilmData" :key="item.id">
            <div class="img">
              <div class="_2dimax">
                <img src="@/assets/images/2dimax.png" alt="2dimax">
              </div>
              <img :src="item.posterUrl" :alt="item.name">
              <div class="big">
                <router-link :to="'/detail?id='+item.id" target="_blank">
                  <img :src="item.bigPosterUrl" :alt="item.name">
                  <div class="info">
                    <div class="title">
                      <div class="na">{{ item.name }}</div>
                      <div class="sc">
                        <span>{{ item.score[0] }}.</span>{{ item.score[2] }}
                      </div>
                    </div>
                    <div class="tag">
                      <span>类型：</span>纪录片／音乐
                    </div>
                    <div class="tag">
                      <span>主演：</span>张杰
                    </div>
                    <div class="tag time">
                      <span>上映时间：</span>{{ item.releaseDate }}
                    </div>
                  </div>
                </router-link>
              </div>
            </div>
            <div class="name">
              <router-link :to="'/detail?id='+item.id" target="_blank">{{ item.name }}</router-link>
            </div>
            <div class="score">
              <span>{{ item.score[0] }}.</span>{{ item.score[2] }}
            </div>
          </li>
        </ul>
      </div>
      <div class="list-page">
        <el-pagination
          v-model:current-page="pageNum"
          v-model:page-size="pageSize"
          background
          layout="prev, pager, next, jumper"
          :total="total"
        />
      </div>
    </div>
  </DefaultLayout>
</template>

<script setup>
import DefaultLayout from '@/layout/DefaultLayout.vue'
import { computed, onMounted, ref, watchEffect } from 'vue'
import { getFilmList, getFilmTypeList, getRegionList } from '@/api/film.js'

const typeList = ref([])
const regionList = ref([])
const typeId = ref('')
const regionId = ref('')
const yearId = ref('')
const sortId = ref(0)
const filmList = ref([])
const pageNum = ref(1)
const pageSize = ref(10)
const total = ref(0)
const formatFilmData = computed(() => {
  return filmList.value.map((value) => {
    let baseUrl = value.posterUrl.slice(0, value.posterUrl.indexOf('?'))
    let posterUrl = baseUrl + '?imageView2/1/w/160/h/220'
    let bigPosterUrl = baseUrl + '?imageView2/1/w/218/h/300'
    let score = value.score ? (String(value.score).length >= 3 ? String(value.score) : value.score + '.0') : '0.0'
    return { ...value, posterUrl, bigPosterUrl, score }
  })
})

const optionsChange = (option, e) => {
  if (e.target.tagName === 'A') {
    if (option === 'type') {
      typeId.value = e.target.dataset.id
      console.log(typeId.value)
    }
    if (option === 'region') {
      regionId.value = e.target.dataset.id
    }
    if (option === 'year') {
      console.log(e.target.dataset.id)
      yearId.value = e.target.dataset.id
    }
  }
}
onMounted(async () => {
  const typeListRes = await getFilmTypeList()
  typeList.value = typeListRes.data.list
  const regionListRes = await getRegionList()
  regionList.value = regionListRes.data.list
  watchEffect(async () => {
    const filmListRes = await getFilmList(typeId.value, regionId.value, yearId.value, sortId.value, pageNum.value, pageSize.value)
    filmList.value = filmListRes.data.list
    total.value = filmListRes.data.total
  })
})

</script>

<style scoped>
.subnav {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 80px;
  height: 60px;
  width: 100%;
  color: #999;
  background-color: #47464a;
  font-size: 16px;
}

.subnav a {
  display: inline-block;
  height: 60px;
  line-height: 60px;
  padding: 0 40px;
}

.subnav a:hover {
  color: #fff;
  cursor: pointer;
}

.subnav .active {
  color: #ef4238 !important;
  position: relative;
  cursor: default;
}

.subnav a.active::before {
  content: '';
  width: 0;
  height: 0;
  display: inline-block;
  position: absolute;
  left: 67px;
  top: 52px;
  border-bottom: 7px solid #fff;
  border-left: 8px solid transparent;
  border-right: 8px solid transparent;
  border-top: none;
}

.main {
  width: 1120px;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0 40px;
}

.movie-select {
  box-sizing: border-box;
  width: 100%;
  border: 1px solid #e5e5e5;
  margin-top: 40px;
  padding: 0 20px;
  font-size: 14px;
}

.movie-select .type {
  padding: 10px 0;
  display: flex;
}

.movie-select .type.border {
  border-top: 1px solid #e5e5e5;
  border-bottom: 1px solid #e5e5e5;
}

.movie-select .type span {
  display: block;
  width: 40px;
  line-height: 20px;
  height: 20px;
  margin-top: 3px;
  color: #999;
}

.movie-select .type .options {
  display: flex;
  flex-wrap: wrap;
  width: 1060px;
}

.movie-select .type .options a {
  margin-left: 12px;
  padding: 3px 9px;
  color: #333;
  height: 20px;
  line-height: 20px;
}

.movie-select .type .options a:hover {
  color: #ef4238;
  cursor: pointer;
}

.movie-select .type .options .active {
  border-radius: 14px;
  background-color: #f34d41;
  color: #fff !important;
}

.movie-select .type .options .active:hover {
  cursor: default;
}

.movies-sorter {
  margin: 30px 0 20px 0;
  display: flex;
  align-items: center;
  width: 100%;
  font-size: 14px;
}

.movies-sorter div {
  margin-right: 30px;
  height: 20px;
  line-height: 20px;
  vertical-align: top;
}

.movies-sorter div:hover {
  cursor: pointer;
}

.movies-sorter span {
  display: inline-block;
  margin-right: 5px;
  height: 20px;
  width: 20px;
  vertical-align: top;
}

.movies-sorter span.icon-xuanzhong {
  color: #ef4238;
}

.movie-list {
  width: 100%;
  height: 634px;
}

.movie-list ul {
  margin: -29px 0 20px -25px;
  display: flex;
  flex-wrap: wrap;
}

.movie-list ul li {
  position: relative;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 160px;
  margin: 30px 0 0 30px;
}

.movie-list ul li .img ._2dimax {
  position: absolute;
  top: 5px;
  left: -2px;
}

.movie-list ul li .img img {
  vertical-align: top;
}

.movie-list ul li .img > img {
  display: block;
  width: 160px;
  height: 220px;
}

.movie-list ul li .name {
  margin-top: 10px;
  width: 100%;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  text-align: center;
}

.movie-list ul li .name a {
  font-size: 16px;
  color: #333;
}

.movie-list ul li .score {
  font-style: italic;
  margin-top: 10px;
  font-size: 22px;
  color: #ffb400;
  width: 100%;
  height: 31px;
  line-height: 31px;
  text-align: center;
}

.movie-list ul li .score span {
  font-size: 24px;
}

.movie-list ul li .big {
  display: none;

}

.movie-list ul li .big a {
  display: block;
}

.movie-list ul li .big:hover {
  cursor: pointer;
}

.movie-list ul li .img:hover .big {
  display: block;
  position: absolute;
  z-index: 10;
  top: -40px;
  left: -29px;
  box-shadow: 0 0 16px #fff, 0 0 6px rgba(0, 0, 0, .2);
}

.movie-list ul li .big .info {
  box-sizing: border-box;
  position: absolute;
  top: 150px;
  background-color: #fff;
  width: 218px;
  height: 150px;
  padding: 16px;
  font-size: 16px;
}

.movie-list ul li .big .info .title {
  display: flex;
  justify-content: space-between;
  font-size: 20px;
  line-height: 20px;
  margin-top: 6px;
}

.movie-list ul li .big .info .title .na {
  width: 140px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  color: #333;
}

.movie-list ul li .big .info .title .sc {
  font-style: italic;
  font-size: 22px;
  color: #ffb400;
  text-align: center;
}

.movie-list ul li .big .info .title .sc span {
  font-size: 24px;
}

.movie-list ul li .big .info .tag {
  margin-top: 12px;
  font-size: 16px;
  color: #999;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.movie-list ul li .big .info .tag span {
  color: #333;
}

.movie-list ul li .big .info .tag.time {
  margin-top: 10px;
  /* text-overflow: unset;
  overflow: visible;
  white-space: wrap; */
}

.list-page {
  width: 100%;
  display: flex;
  justify-content: center;
  font-size: 14px;
  margin: 16px 0;
}

.list-page a {
  display: inline-block;
  height: 30px;
  line-height: 30px;
  padding: 0 12px;
  margin: 0 5px;
  border: 1px solid #d8d8d8;
}

.list-page a:hover {
  border-color: #ef4238;
}

.list-page .active {
  background-color: #ef4238;
  color: #fff;
  border-color: #ef4238;
  cursor: default;
}
</style>
