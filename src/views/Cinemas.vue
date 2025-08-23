<template>
  <default-layout>
    <div class="main">
      <div class="select-continer">
        <div class="type brand">
          <span>品牌:</span>
          <div class="options" @click="optionsChange('brand',$event)">
            <a :class="{active: brand === '全部'}">全部</a>
            <a v-for="item in cinemaBrandList"
               :class="{active: brand === item}">
              {{ item }}
            </a>
          </div>
        </div>
        <div class="type">
          <span>行政区:</span>
          <div class="options">
          </div>
        </div>
        <div class="type">
          <span>影厅类型:</span>
          <div class="options" @click="optionsChange('hallType',$event)">
            <a :class="{active: hallType === '全部'}">全部</a>
            <a v-for="item in cinemaLevelList"
               :class="{active: hallType === item}">
              {{ item }}
            </a>
          </div>
        </div>
        <div class="type">
          <span>影院服务:</span>
          <div class="options">
          </div>

        </div>
      </div>
      <div class="cinema-list">
        <div class="title">
          <span>影院列表</span>
          <div class="filter">
            <img src="//p1.meituan.net/scarlett/af58aa7b387e1c4d26797f027733ace2309.png">
            <span>筛选</span>
            <div class="filter-list">
              <div><a href="">距离近</a></div>
              <div><a href="">价格低</a></div>
            </div>
          </div>
        </div>
        <ul>
          <li class="cell" v-for="e in cinemaList">
            <div class="left">
              <div class="name">
                <router-link :to="'/cinema?id='+e.id" target="_blank">{{ e.title }}</router-link>
              </div>
              <div class="address">{{ e.address }}</div>
              <div class="tag">
                <span v-for="item in JSON.parse(e.services)">{{ item.service_name }}</span>
              </div>
            </div>
            <div class="right">
              <div class="price">
                <div class="price-num">
                  <span>￥</span><span class="num">{{ e.lowPrice }}</span>起
                </div>
                <div class="distance">
                  <span>10</span>km
                </div>
              </div>
              <div class="buy-btn">
                <router-link :to="'/cinema?id='+e.id">选座购票</router-link>
              </div>
            </div>
          </li>
        </ul>
      </div>
      <div class="list-page">
        <el-pagination
          background
          layout="prev, pager, next, jumper"
          :total="total"
          :page-size="pageSize"
          v-model:current-page="pageNum"
        />
      </div>
    </div>
  </default-layout>
</template>

<script setup>
import DefaultLayout from '@/layout/DefaultLayout.vue'
import { onMounted, ref, watchEffect } from 'vue'
import { getCinemaBrandList, getCinemaLevelList, getCinemaList } from '@/api/cinema.js'

const cinemaBrandList = ref([])
const cinemaLevelList = ref([])
const brand = ref('全部')
const hallType = ref('全部')
const pageNum = ref(1)
const pageSize = ref(10)
const total = ref(0)
const cinemaList = ref([])

const optionsChange = (type, e) => {
  if (e.target.tagName === 'A') {
    if (type === 'brand') {
      brand.value = e.target.textContent
    }
    if (type === 'hallType') {
      hallType.value = e.target.textContent
    }
  }
}
onMounted(async () => {
  const cinemaBrandListRes = await getCinemaBrandList()
  cinemaBrandList.value = cinemaBrandListRes.data
  const cinemaLevelListRes = await getCinemaLevelList()
  cinemaLevelList.value = cinemaLevelListRes.data
  watchEffect(async () => {
    const res = await getCinemaList(brand.value, hallType.value, pageNum.value, pageSize.value)
    cinemaList.value = res.data.list
    total.value = res.data.total
  })
})
</script>

<style scoped>
.main {
  width: 1200px;
  margin-top: 80px;
}

.main .select-continer {
  margin: 40px 0;
  padding: 0 20px;
  border: 1px solid #e5e5e5;
  color: #333;
  font-size: 14px;
}

.main .select-continer .type {
  display: flex;
  padding: 10px 0;
  border-bottom: 1px dashed #e5e5e5;
}

.main .select-continer .type:last-child {
  border-bottom: none;
}

.main .select-continer .type span {
  flex-shrink: 0;
  display: block;
  color: #999;
  margin-top: 6px;
}

.main .select-continer .type .options {
  display: flex;
  flex-wrap: wrap;
}

.main .select-continer .type .options a {
  display: block;
  padding: 3px 9px;
  margin-left: 12px;
  line-height: 1.5;
  border-radius: 14px;
  cursor: pointer;
}

.main .select-continer .type .options a.active {
  background-color: #f34d41;
  color: #fff;
}

.main .cinema-list .title {
  position: relative;
  display: flex;
  justify-content: space-between;
  border-left: 4px solid #f03d37;
  line-height: 18px;
}

.main .cinema-list .title > span {
  margin-left: 6px;
  color: #333;
  font-size: 18px;
  font-weight: bold;

}

.main .cinema-list .title .filter {
  width: 70px;
  font-size: 13px;
  color: #666;
  letter-spacing: 0;
  font-weight: 400;
  cursor: pointer;
}

.main .cinema-list .title .filter:hover .filter-list {
  display: block;
}

.main .cinema-list .title .filter img {
  padding-left: 10px;
  vertical-align: middle;
}

.main .cinema-list .title .filter .filter-list {
  position: absolute;
  top: 18px;
  right: 0;
  width: 80px;
  display: none;
  text-align: center;
  padding-top: 10px;
  background-color: #fff;
}

.main .cinema-list .title .filter .filter-list div {
  height: 28px;
  margin: 0;
  line-height: 28px;
  width: 64px;
  padding-left: 16px;
}

.main .cinema-list .title .filter .filter-list div:hover {
  background-color: #ccc;
}

.main .cinema-list .cell {
  display: flex;
  justify-content: space-between;
  padding: 20px 0;
  border-bottom: 1px dashed #e5e5e5;
}

.main .cinema-list .cell .left .name {
  height: 18px;
  font-size: 16px;
  color: #333;
  margin-bottom: 10px;
}

.main .cinema-list .cell .left .address {
  font-size: 14px;
  line-height: 14px;
  color: #999;
}

.main .cinema-list .cell .left .tag {
  margin-top: 10px;
  font-size: 12px;
  color: #509fc9;
  line-height: 18px;
}

.main .cinema-list .cell .left .tag span {
  display: inline-block;
  border: .7px solid #509fc9;
  border-radius: 3px;
  padding: 0 2px;
  margin-right: 8px;
}

.main .cinema-list .cell .right {
  display: flex;
}

.main .cinema-list .cell .right .price {
  color: #999;
  font-size: 12px;
  margin-top: 15px;
}

.main .cinema-list .cell .right .price .price-num span {
  color: #f03d37;
}

.main .cinema-list .cell .right .price .price-num .num {
  font-size: 16px;
  font-weight: 700;
}

.main .cinema-list .cell .right .price .distance {
  margin-top: 10px;
  text-align: center;
}

.main .cinema-list .cell .right .buy-btn {
  width: 80px;
  height: 45px;
  line-height: 45px;
  margin-left: 36px;
  margin-right: 20px;
}

.main .cinema-list .cell .right .buy-btn a {
  display: inline-block;
  width: 100%;
  height: 30px;
  color: #fff;
  background-color: #f03d37;
  font-size: 14px;
  line-height: 30px;
  border-radius: 100px;
  text-align: center;
  box-shadow: 0 2px 10px -2px #f03d37;
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
