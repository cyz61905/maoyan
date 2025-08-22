<template>
  <DefaultLayout>
    <div class="content">
      <div class="content-left">
        <div class="reying">
          <div class="title">
            <span>正在热映（49部）</span><a href="#">全部<i class="iconfont icon-xiangyoujiantou"></i></a>
          </div>
          <div class="movie-list">
            <div class="movie" v-for="item in playingFilmList" :key="item.id">
              <router-link :to="'/detail?id='+item.id" target="_blank">
                <img :src="item.posterUrl" :alt="item.name"/>
                <div class="info">
                  <div class="name">{{item.name}}</div>
                  <div class="score"><span>{{(item.score+'').substring(0,2)}}</span>{{(item.score+'').substring(2,3)}}</div>
                </div>
              </router-link>
              <div class="buy">
                <a href="" target="_blank">购票</a>
              </div>
            </div>
          </div>
        </div>
        <div class="coming">
          <div class="title">
            <span>即将上映（140部）</span><a>全部<i class="iconfont icon-xiangyoujiantou"></i></a>
          </div>
          <div class="movie-list">
            <div class="list" v-for="(item, index) in noPlayFilmList" :key="item.id">
              <div class="movie">
                <router-link :to="'/detail?id='+item.id" target="_blank">
                  <img :src="item.posterUrl" :alt="item.name"/>
                  <div class="info">
                    <div class="name">{{item.name}}</div>
                  </div>
                </router-link>
                <div class="want">{{item.wantSee}}人想看</div>
                <div class="btns"><span>预告片</span>
                  <a href="">预售</a>
                </div>
              </div>
              <div class="show">{{item.releaseDate}}上映</div>
            </div>
          </div>
        </div>

        <div class="other">
          <div class="movie-list">
            <div class="movie first">
              <a href="./detail.html">
                <img
                  src="https://p0.pipi.cn/basicdata/54ecde3311e8d3ecd8af330a8a30d2306c10e.jpg?imageView2/1/w/350/h/220" />
                <div class="info">
                  <div class="name">唐人街探案111111111</div>
                  <div class="score"><span>9.</span>5</div>
                </div>
              </a>
            </div>
            <div class="movie">
              <a href="./detail.html">
                <img
                  src="https://p0.pipi.cn/mediaplus/friday_image_fe/0fa334254eabf814dc5b283f9c1d680b493c7.jpg?imageView2/1/w/160/h/220" />
                <div class="info">
                  <div class="name">唐人街探案111111111</div>
                  <div class="score"><span>9.</span>5</div>
                </div>
              </a>
            </div>
            <div class="movie">
              <a href="./detail.html">
                <img
                  src="https://p0.pipi.cn/mediaplus/friday_image_fe/0fa334254eabf814dc5b283f9c1d680b493c7.jpg?imageView2/1/w/160/h/220" />
                <div class="info">
                  <div class="name">唐人街探案111111111</div>
                  <div class="score"><span>9.</span>5</div>
                </div>
              </a>
            </div>
            <div class="movie">
              <a href="./detail.html">
                <img
                  src="https://p0.pipi.cn/mediaplus/friday_image_fe/0fa334254eabf814dc5b283f9c1d680b493c7.jpg?imageView2/1/w/160/h/220" />
                <div class="info">
                  <div class="name">唐人街探案111111111</div>
                  <div class="score"><span>9.</span>5</div>
                </div>
              </a>
            </div>
            <div class="movie">
              <a href="./detail.html">
                <img
                  src="https://p0.pipi.cn/mediaplus/friday_image_fe/0fa334254eabf814dc5b283f9c1d680b493c7.jpg?imageView2/1/w/160/h/220" />
                <div class="info">
                  <div class="name">唐人街探案111111111</div>
                  <div class="score"><span>9.</span>5</div>
                </div>
              </a>
            </div>
            <div class="movie">
              <a href="./detail.html">
                <img
                  src="https://p0.pipi.cn/mediaplus/friday_image_fe/0fa334254eabf814dc5b283f9c1d680b493c7.jpg?imageView2/1/w/160/h/220" />
                <div class="info">
                  <div class="name">唐人街探案111111111</div>
                  <div class="score"><span>9.</span>5</div>
                </div>
              </a>
            </div>
            <div class="movie">
              <a href="./detail.html">
                <img
                  src="https://p0.pipi.cn/mediaplus/friday_image_fe/0fa334254eabf814dc5b283f9c1d680b493c7.jpg?imageView2/1/w/160/h/220" />
                <div class="info">
                  <div class="name">唐人街探案111111111</div>
                  <div class="score"><span>9.</span>5</div>
                </div>
              </a>
            </div>
          </div>
        </div>
      </div>
      <div class="content-right">
        <div class="jinripiaofang">
          <div class="title">
            <p>今日票房</p>
          </div>
          <ul>
            <li class="first">
              <i class="iconfont icon-jiangbei"></i>
              <div>
                <img
                  src="https://p0.pipi.cn/mediaplus/friday_image_fe/0fa3342525c77e6e38d8a15e40480cafec999.jpg?imageView2/1/w/120/h/80"
                  alt="" />
              </div>
              <div class="info">
                <div class="name">碟中谍8：最终清算</div>
                <div class="sale">94.65万</div>
              </div>
            </li>
            <li>
              <div><span class="num">2</span><span>时间之子</span></div>
              <span class="sale">63.63万</span>
            </li>
            <li>
              <div><span class="num">3</span><span>时间之子</span></div>
              <span class="sale">63.63万</span>
            </li>
            <li>
              <div><span class="num gray">4</span><span>时间之子</span></div>
              <span class="sale">63.63万</span>
            </li>
            <li>
              <div><span class="num gray">5</span><span>时间之子</span></div>
              <span class="sale">63.63万</span>
            </li>
          </ul>
        </div>
        <div class="jinridapan">
          <div class="dapan">今日大盘</div>
          <div class="dapan-right">
            <div class="show">
              <div><span>310.3</span>万</div>
              <a>查看更多<i class="iconfont icon-xiangyoujiantou"></i></a>
            </div>
            <div class="time">
              <span>北京时间 09:15:04</span>
              <span>猫眼专业版实时票房数据</span>
            </div>
          </div>
        </div>
        <div class="zuishouqidai" v-if="dataLoaded">
          <div class="title">
            <span>最受期待</span>
            <a href="#">查看完整榜单<i class="iconfont icon-xiangyoujiantou"></i></a>
          </div>
          <a class="first">
            <i class="iconfont icon-jiangbei"></i>
            <img :src="expectationFilmList[0].posterUrl" :alt="expectationFilmList[0].name" />
            <div class="info">
              <div class="name">{{ expectationFilmList[0].name }}</div>
              <div class="time">上映时间：{{ expectationFilmList[0].releaseDate }}</div>
              <div class="want">{{ expectationFilmList[0].wantSee }}人想看</div>
            </div>
          </a>
          <div class="st">
            <template v-for="i in 2">
              <a class="second-third" href="./detail.html?id=${data[i+1].id}">
                <i>{{ i + 1 }}</i>
                <img :src="expectationFilmList[i].posterUrl"
                     :alt="expectationFilmList[i].name" />
                <div class="name">{{ expectationFilmList[i].name }}</div>
                <div class="want">{{ expectationFilmList[i].wantSee }}人想看</div>
              </a>
            </template>
          </div>
          <ul id="expectation">
            <template v-for="(item, index) in expectationFilmList">
              <li v-if="index > 2">
                <a href="./movie.html?id=${value.id}">
                  <div>
                    <span class="gray">{{ index + 1 }}</span>
                    <span class="name">{{ item.name }}</span>
                  </div>
                  <span class="want">{{ item.wantSee }}人想看</span>
                </a>
              </li>
            </template>
          </ul>
        </div>
        <div class="top100">
          <div class="title">
            <span>TOP 100</span><a href="#">查看完整榜单<i class="iconfont icon-xiangyoujiantou"></i></a>
          </div>
          <ul id="top100List">
            <template v-for="(item, index) in top100FilmList">
              <li v-if="index === 0">
                <a href="./detail.html?id=${value.id}" class="first" target="_blank">
                  <i class="iconfont icon-jiangbei"></i>
                  <img :src="item.posterUrl"
                       :alt="item.name" />
                  <div class="info">
                    <span class="name">{{ item.name }}</span>
                    <span class="score">{{ (item.score + '').substring(0, 3) }}分</span>
                  </div>
                </a>
              </li>
              <li v-else>
                <a href="./detail.html?id=${value.id}" target="_blank">
                  <div>
                    <span :class="index < 3 ? 'num' : 'num gray'">{{ index + 1 }}</span><span
                    class="name">{{ item.name }}</span>
                  </div>
                  <span class="score">{{ (item.score + '').substring(0, 3) }}分</span>
                </a>
              </li>
            </template>
          </ul>
        </div>
      </div>
    </div>
  </DefaultLayout>
</template>

<script setup>
import DefaultLayout from '@/layout/DefaultLayout.vue'
import { getHomepageFilmList, getTop100FilmList } from '@/api/film.js'
import { onMounted, ref } from 'vue'

const dataLoaded = ref(false)
const top100FilmList = ref([])
const playingFilmList = ref([])
const noPlayFilmList = ref([])
const expectationFilmList = ref([])

onMounted(async () => {
  const top100Res = await getTop100FilmList()
  top100FilmList.value = top100Res.data
  const homepageRes = await getHomepageFilmList()
  playingFilmList.value = homepageRes.data.playing
  noPlayFilmList.value = homepageRes.data.noPlay
  expectationFilmList.value = homepageRes.data.expectation
  dataLoaded.value = true
})
</script>

<style scoped>
.content {
  margin-top: 80px;
  height: 2200px;
  width: 1200px;
  display: flex;
  align-items: start;
  justify-content: center;
}

.content-left {
  width: 790px;
  display: flex;
  flex-direction: column;
  justify-content: start;
  align-items: start;
}

.content-left .reying,
.content-left .coming {
  width: 100%;
  margin-top: 62px;
}

.title {
  color: #ef4238;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.reying .title, .coming .title {
  margin: 0 20px 0 23px;
}

.title span {
  font-size: 26px;
}

.movie-list {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
}

.movie {
  position: relative;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  width: 160px;
  height: 260px;
  margin: 30px 0 0 30px;
  border: 1px solid #efefef;
}

.movie a {
  display: block;
}

.movie img {
  display: block;
  width: 160px;
  height: 220px;
}

.movie:hover {
  box-shadow: 0 10px 10px 0 rgba(0, 0, 0, 0.2);
}

.movie .info {
  height: 50px;
  padding: 10px;
  width: 140px;
  color: white;
  background: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 1));
  position: absolute;
  bottom: 40px;
  left: 0;
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
}

.movie .info .name {
  height: 20px;
  line-height: 20px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.movie .info .score {
  height: 20px;
  line-height: 20px;
  color: #ffb400;
  font-style: italic;
  font-size: 14px;
}

.reying .movie .info span {
  font-size: 18px;
}

.reying .movie .buy {
  display: flex;
  color: #ef4238;
  justify-content: center;
  align-items: center;
  width: 160px;
  height: 40px;
}

.reying .movie .buy:hover {
  color: white;
  background-color: #ef4238;
}

.reying .movie .buy a {
  display: block;
  text-align: center;
  line-height: 40px;
  width: 100%;
  height: 100%;
}


.coming .movie {
  height: 295px;
}

.coming .info {
  bottom: 75px;
}

.coming .want {
  height: 34px;
  font-size: 14px;
  color: #ffb400;
  background-color: #fbfbfb;
  text-align: left;
  padding-left: 10px;

  line-height: 34px;
  text-align: left;
}

.coming .btns {
  height: 39px;
  display: flex;
  justify-content: space-between;
}

.coming .btns span {
  width: 50%;
  box-sizing: border-box;
  border-right: 1px dotted #e5e5e5;
  line-height: 39px;
  text-align: center;
  color: #999;
}

.coming .btns a {
  color: #2d98f3;
  width: 50%;
  line-height: 39px;
  text-align: center;
}

.coming .btns a:hover {
  color: white;
  background-color: #2d98f3;
  cursor: pointer;
}

.coming .list .show {
  height: 35px;
  margin-left: 30px;
  line-height: 35px;
  text-align: center;
  color: #999;
}

.other .movie {
  height: 220px;
}

.other .first {
  width: 350px;
}

.other .first img {
  width: 350px;
}

.other .first .info {
  width: 330px;
}

.other .info {
  bottom: 0;
}

.content-right {
  width: 360px;
  margin-left: 50px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: start;
}

.content-right .jinripiaofang {
  margin-top: 62px;
  width: 100%;
  height: 400px;
}

.content-right .jinripiaofang .title p {
  margin-bottom: 30px;
  font-size: 26px;
  color: red;
}

.content-right .jinripiaofang ul li {
  height: 35px;
  line-height: 35px;
  width: 100%;
  padding: 10px 0;
  display: flex;
  justify-content: space-between;
  font-size: 16px;
}

.content-right .jinripiaofang ul li:hover {
  cursor: pointer;
  background-color: #d6d6d6;
}

.content-right .jinripiaofang ul li.first {
  height: 80px;
  padding: 0;
  position: relative;
  justify-content: flex-start;
  border: 1px solid #efefef;
  margin-bottom: 10px;
}

.content-right .jinripiaofang .first .icon-jiangbei {
  position: absolute;
  left: 0;
  top: 0;
  background-color: #ef4238;
  width: 30px;
  height: 30px;
  line-height: 30px;
  text-align: center;
}

.content-right .jinripiaofang .first .info {
  padding-left: 10px;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}

.content-right .jinripiaofang .first .info .name {
  font-size: 18px;
  color: #333;
}

.content-right .jinripiaofang .sale {
  font-size: 14px;
  color: #ef4238;
}

.content-right .jinripiaofang ul li .num {
  font-style: italic;
  font-size: 18px;
  color: #ef4238;
  margin-right: 10px;
}

.content-right .jinripiaofang ul li .num.gray {
  color: #999;
}

.content-right .jinridapan {
  display: flex;
  width: 100%;
  background-color: #fdfdfd;
  border: 1px solid #efefef;
}

.content-right .jinridapan .dapan {
  padding: 10px;
  width: 20px;
  height: 83px;
  line-height: 21px;
  text-align: center;
  background-color: #ef4238;
  color: #fff;
  font-size: 17px;
}

.content-right .jinridapan .dapan-right {
  flex-grow: 1;
  padding: 0 10px;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}

.content-right .jinridapan .show {
  height: 30px;
  line-height: 30px;
  display: flex;
  justify-content: space-between;
  font-size: 14px;
  color: #ef4238;
}

.content-right .jinridapan .show span {
  font-size: 30px;
}

.content-right .jinridapan .show a:hover {
  cursor: pointer;
}

.content-right .jinridapan .time {
  display: flex;
  font-size: 14px;
  color: #999;
  justify-content: space-between;
}

.content-right .zuishouqidai {
  margin-top: 70px;
  width: 100%;
}

.content-right .zuishouqidai .title {
  font-size: 14px;
  height: 26px;
  color: #ffb400;
  display: flex;
  justify-content: space-between;
}

.content-right .zuishouqidai .title span {
  font-size: 26px;
}

.content-right .zuishouqidai .title a {
  margin-top: 10px;
}

.content-right .zuishouqidai .first {
  position: relative;
  display: flex;
  border: 1px solid #efefef;
  height: 194px;
  padding: 0;
  margin-top: 20px;
}

.content-right .zuishouqidai .first i {
  position: absolute;
  left: 0;
  top: 0;
  background-color: #ffb400;
  width: 20px;
  height: 20px;
  line-height: 20px;
  text-align: center;
}

.content-right .zuishouqidai .first .info {
  flex-grow: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-left: 10px;
}

.content-right .zuishouqidai .first .info .name {
  font-size: 18px;
  color: #333;
}

.content-right .zuishouqidai .first .info .time {
  font-size: 16px;
  margin-top: 12px;
  color: #999;
}

.content-right .zuishouqidai .first .info .want {
  font-size: 14px;
  margin-top: 12px;
  color: #ffb400;
}

.content-right .zuishouqidai .st {
  display: flex;
  justify-content: space-between;
  margin: 20px 0;
}

.content-right .zuishouqidai .second-third {
  position: relative;
  font-size: 14px;
  width: 170px;
  border: 1px solid #efefef;
}

.content-right .zuishouqidai .second-third:hover {
  background-color: #f7f7f7;
}

.content-right .zuishouqidai .second-third i {
  position: absolute;
  top: 0;
  left: 0;
  height: 20px;
  width: 20px;
  line-height: 20px;
  text-align: center;
  background-color: #ffb400;
  font-style: italic;
  font-size: 18px;
  color: #fff;
}

.content-right .zuishouqidai .second-third img {
  display: block;
  width: 170px;
  height: 118px;
}

.content-right .zuishouqidai .second-third .name {
  width: 150px;
  height: 23px;
  margin: 8px 10px 0 10px;
  font-size: 18px;
  color: #333;
}

.content-right .zuishouqidai .second-third .want {
  width: 90px;
  height: 18px;
  margin: 6px 0 0 10px;
  color: #fdb863;
}

.content-right .zuishouqidai ul li:hover {
  background-color: #f7f7f7;
}

.content-right .zuishouqidai ul li a {
  width: 100%;
  height: 35px;
  line-height: 35px;
  padding: 10px 0;
  text-align: left;
  display: flex;
  justify-content: space-between;
}

.content-right .zuishouqidai ul li .gray {
  display: inline-block;
  width: 25px;
  font-style: italic;
  color: #999;
  font-size: 18px;
}

.content-right .zuishouqidai ul li .name {
  font-size: 16px;
  color: #333;
}

.content-right .zuishouqidai ul li .want {
  font-size: 14px;
  color: #fdb863;
}

.content-right .top100 {
  margin-top: 80px;
  width: 100%;
}

.content-right .top100 .title {
  color: #ffb400;
  font-size: 14px;
}

.content-right .top100 .title span {
  font-size: 26px;
}

.content-right .top100 ul li:hover {
  background-color: #f5f5f5;
}

.content-right .top100 ul li a {
  width: 100%;
  height: 35px;
  line-height: 35px;
  padding: 10px 0;
  text-align: left;
  display: flex;
  justify-content: space-between;
}

.content-right .top100 .first {
  margin-top: 20px;
  position: relative;
  height: 78px;
  padding: 0;
  border: 1px solid #efefef;
  margin: 20px 0;
}

.content-right .top100 .first i {
  position: absolute;
  left: 0;
  top: 0;
  background-color: #ffb400;
  width: 20px;
  height: 20px;
  line-height: 20px;
  text-align: center;
}


.content-right .top100 .first .info {
  margin-left: 10px;
  flex-grow: 1;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}

.content-right .top100 .first .info .name {
  font-size: 18px;
  color: #333;
}

.content-right .top100 .first .info .score {
  font-size: 14px;
  color: #ffb400;
}

.content-right .top100 ul li .num {
  display: inline-block;
  width: 25px;
  font-style: italic;
  color: #ffb400;
  font-size: 18px;
}

.content-right .top100 ul li .num.gray {
  color: #999;
}

.content-right .top100 ul li .name {
  font-size: 16px;
  color: #333;
}

.content-right .top100 ul li .score {
  color: #fdb863;
  font-size: 14px;
}


</style>
