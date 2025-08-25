<template>
  <DefaultLayout>
    <div class="banner">
      <div class="wrapper">
        <div class="left">
          <img class="image" :src="film.posterUrl" :alt="film.name">
          <img class="_2dimax" src="@/assets/images/2dimax.png" alt="">
          <div id="go"></div>
        </div>
        <div class="right">
          <div class="info">
            <div class="name">{{ film.name }}</div>
            <div class="e-name">{{ film.englishName }}</div>
            <div class="type">
              <!-- <a href="">动作 </a>
              <a href="">惊悚 </a>
              <a href="">冒险</a> -->
              <a :href="'./film?typeId='+item.id" target="_blank"
                 v-for="item in film.typeList">{{ item.name + ' ' }}</a>
            </div>
            <div class="area">{{ film.showingArea + ' / ' + film.duration + '分钟' }}</div>
            <div class="showtime">{{ film.releaseDate + ' ' + film.showingArea + '上映' }}</div>
          </div>
          <div class="btns">
            <div class="want-score">
              <a href="" @click.prevent="toggleWantSee" class="want"><i class="iconfont icon-aixin"
                                                                        :style="{color: isWantSee? '#ef4238' : '#fff'}"></i>
                <span>{{ isWantSee ? '已想看' : ' 想看' }}</span></a>
              <a href="javascript:void(0)"><i class="iconfont icon-star"></i> <span>评分</span></a>
            </div>
            <a class="buy" href="">特惠购票</a>
          </div>
          <div class="movie-stats-container">
            <div class="title">猫眼口碑</div>
            <div class="stats">
              <div class="score">{{ filmScore }}</div>
              <div class="box">
                <div class="star">
                  <div class="star-on" :style="{width: film.score * 10 + '%'}"></div>
                </div>
                <div class="count">{{ film.commentCount + '人评分' }}</div>
              </div>
            </div>
            <div class="title">累计票房</div>
            <div class="total"><span>3.62</span> 亿</div>
          </div>
        </div>
      </div>
    </div>
    <div class="main">
      <div class="left">
        <div class="nav">
          <a href="./index">猫眼电影</a>
          >
          <a href="./film">电影</a>
          > <span>{{ film.name }}</span>
        </div>
        <div class="tab" @click="changeTab">
          <span :class="{ active: currentTab === 'desc'}" data-tab="desc">介绍</span>
          <span :class="{ active: currentTab === 'actor'}" data-tab="actor">演职人员</span>
          <span :class="{ active: currentTab === 'prize'}" data-tab="prize">奖项</span>
          <span :class="{ active: currentTab === 'img'}" data-tab="img">图集</span>
          <span :class="{ active: currentTab === 'comment'}" data-tab="comment">评论</span>
        </div>
        <div class="tab-content" v-if="dataLoaded">
          <div class="tab-desc" :class="{active : currentTab === 'desc'}">
            <div class="module">
              <div class="title">剧情简介</div>
              <div class="content">{{ film.introduction }}</div>
            </div>
            <div class="module">
              <div class="title">演职人员<a href="#go" @click="goTab('actor')">全部<i
                class="iconfont icon-xiangyoujiantou"></i></a></div>
              <div class="content">
                <template v-for="(item, index) in [film.filmCastList.director, film.filmCastList.actor.slice(0,4)]">
                  <div class="celebrity-group">
                    <div class="type">{{ item.position }}</div>
                    <div class="list">
                      <template v-for="(value, index) in item">
                        <div class="info">
                          <img :src="value.imgUrl" :alt="value.realName">
                          <div class="name">{{ value.realName }}</div>
                        </div>
                      </template>
                    </div>
                  </div>
                </template>
              </div>
            </div>
            <div class="module">
              <div class="title">奖项<a href="#go" @click="goTab('prize')">全部<i
                class="iconfont icon-xiangyoujiantou"></i></a></div>
              <div class="content">
                <ul>
                  <li>
                    <div class="award-title">
                      <img src="https://p1.meituan.net/movie/93c7e76ea0613b230023c7f0348e77327514.jpg@50w_50h_1e_1c"
                           alt="">第38届香港金像奖
                    </div>
                    <div class="award">
                      <p>获奖：最佳两岸华语电影</p>
                    </div>
                  </li>
                  <li class="last">
                    <div class="award-title">
                      <img src="https://p1.meituan.net/movie/93c7e76ea0613b230023c7f0348e77327514.jpg@50w_50h_1e_1c"
                           alt="">第38届香港金像奖
                    </div>
                    <div class="award">
                      <p>提名：最佳剧情片 / 最佳男配角 / 最佳造型设计 / 最佳剪辑</p>
                      <p>获奖：最佳男主角 / 最佳新导演 / 最佳原著剧本 / 最佳原著剧本 / 最佳原著剧本</p>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
            <div class="module">
              <div class="title">图集<a href="#go" @click="goTab('img')">全部<i
                class="iconfont icon-xiangyoujiantou"></i></a></div>
              <div class="content">
                <div class="album">
                  <img class="img1"
                       src="https://p0.pipi.cn/basicdata/54ecdedd2ff5bfbe12b12dd52568af0eff03b.jpg?imageView2/1/w/465/h/258"
                       alt="">
                  <img class="img2"
                       src="https://p0.pipi.cn/basicdata/54ecdeddd7c9abc696be12d18f68a7ef43dc6.jpg?imageView2/1/w/126/h/126"
                       alt="">
                  <img class="img3"
                       src="https://p0.pipi.cn/basicdata/54ecdeddd7c9abc696be12d18f68a7ef43dc6.jpg?imageView2/1/w/126/h/126"
                       alt="">
                  <img class="img4"
                       src="https://p0.pipi.cn/basicdata/54ecdeddd7c9abc696be12d18f68a7ef43dc6.jpg?imageView2/1/w/126/h/126"
                       alt="">
                  <img class="img5"
                       src="https://p0.pipi.cn/basicdata/54ecdeddd7c9abc696be12d18f68a7ef43dc6.jpg?imageView2/1/w/126/h/126"
                       alt="">
                </div>
              </div>
            </div>
            <div class="module">
              <div class="title">影片资料</div>
              <div class="content">
                <div class="attribute">
                  <div class="item">
                    <div class="item-title">
                      <img src="https://p0.meituan.net/mmdb/250a17bc199c0b942073bec5429d2f422175.png@14w_14h_1e_1c"
                           alt="">家长引导
                    </div>
                    <div class="item-content">本片在中国香港的评级为【IIA】，未满16岁的儿童不宜观看。</div>
                  </div>
                  <div class="item">
                    <div class="item-title">
                      <img src="https://p0.meituan.net/mmdb/1764aeeb280e07c55b861481cc717e2c1511.png@14w_14h_1e_1c"
                           alt="">出品发行
                    </div>
                    <div class=" item-content">霍尔果斯坏猴子影视文化传播有限公司
                    </div>
                  </div>
                  <div class="item">
                    <div class="item-title">
                      <img src="https://p0.meituan.net/mmdb/c694fd8f82f4e706e5318a5175265b552010.png@14w_14h_1e_1c"
                           alt="">技术参数
                    </div>
                    <div class="item-content">1小时57分钟</div>
                  </div>
                </div>
              </div>
            </div>
            <div class="module">
              <div class="title">荣誉奖项</div>
              <div class="content">
                <div class="honor">
                  <div class="honor-item">
                    <div class="honor-item-num">33次</div>
                    <div class="honor-item-title">获奖</div>
                  </div>
                  <div class="honor-item">
                    <div class="honor-item-num">31次</div>
                    <div class="honor-item-title">提名</div>
                  </div>
                  <div class="honor-item">
                    <div class="honor-item-num">第32届金鸡奖</div>
                    <div class="honor-item-title">最佳导演处女作</div>
                  </div>
                </div>
              </div>
            </div>
            <div class="module">
              <div class="title">票房<a href="">票房详情<i class="iconfont icon-xiangyoujiantou"></i></a></div>
              <div class="content">
                <div class="sale-info">
                  <div class="sale-item">
                    <div class="sale-item-num">123812
                    </div>
                    <div class="sale-item-title">首周票房(万)</div>
                  </div>
                  <div class="sale-item">
                    <div class="sale-item-num">310002</div>
                    <div class="sale-item-title">累计票房(万)</div>
                  </div>
                </div>
              </div>
            </div>
            <div class="module">
              <div class="title">电影原声</div>
              <div class="content">
                <div class="film-music">
                  <img class="film-music-icon"
                       src="//p0.meituan.net/scarlett/52ed06a649b14df78ebee02e9959c32911524.png@140w_140h_1e_1c"
                       alt="电影原声">
                  <div class="music-info">
                    <div class="music-title">生如夏花</div>
                    <div class="music-author">徐峥 王传君 谭卓 章宇</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="tab-actor" :class="{active : currentTab === 'actor'}">
            <div class="actor-container">
              <template v-for="(item, index) in Object.values(film.filmCastList)">
                <div class="actor-group">
                  <div class="actor-type">{{ item[0].position }}<span>（{{ item.length }}）</span></div>
                  <ul class="actor-list">
                    <template v-for="(value, index) in item">
                      <li>
                        <img :src="value.imgUrl" :alt="value.realName">
                        <div class="actor-info">
                          <div class="actor-name">{{ value.realName }}</div>
                          <div class="actor-role">{{ value.role ? '饰：' + value.role : '' }}</div>
                        </div>
                      </li>
                    </template>
                  </ul>
                </div>
              </template>
            </div>
          </div>
          <div class="tab-prize" :class="{active : currentTab === 'prize'}">
            <div class="prize-container">
              <ul>
                <li>
                  <div class="award-title">
                    <img src="https://p1.meituan.net/movie/93c7e76ea0613b230023c7f0348e77327514.jpg@50w_50h_1e_1c"
                         alt="">第38届香港金像奖
                  </div>
                  <div class="award">
                    <p>获奖：最佳两岸华语电影</p>
                  </div>
                </li>
                <li>
                  <div class="award-title">
                    <img src="https://p1.meituan.net/movie/93c7e76ea0613b230023c7f0348e77327514.jpg@50w_50h_1e_1c"
                         alt="">第38届香港金像奖
                  </div>
                  <p>提名：最佳剧情片 / 最佳男配角 / 最佳造型设计 / 最佳剪辑</p>
                  <p>获奖：最佳男主角 / 最佳新导演 / 最佳原著剧本 / 最佳原著剧本 / 最佳原著剧本</p>
                </li>
                <li>
                  <div class="award-title">
                    <img src="https://p1.meituan.net/movie/93c7e76ea0613b230023c7f0348e77327514.jpg@50w_50h_1e_1c"
                         alt="">第38届香港金像奖
                  </div>
                  <p>提名：最佳剧情片 / 最佳男配角 / 最佳造型设计 / 最佳剪辑</p>
                  <p>获奖：最佳男主角 / 最佳新导演 / 最佳原著剧本 / 最佳原著剧本 / 最佳原著剧本</p>
                </li>
                <li>
                  <div class="award-title">
                    <img src="https://p1.meituan.net/movie/93c7e76ea0613b230023c7f0348e77327514.jpg@50w_50h_1e_1c"
                         alt="">第38届香港金像奖
                  </div>
                  <p>提名：最佳剧情片 / 最佳男配角 / 最佳造型设计 / 最佳剪辑</p>
                  <p>获奖：最佳男主角 / 最佳新导演 / 最佳原著剧本 / 最佳原著剧本 / 最佳原著剧本</p>
                </li>
              </ul>
            </div>
          </div>
          <div class="tab-img" :class="{active : currentTab === 'img'}">
            <div class="img-container">
              <ul>
                <template v-for="(item, index) in film.atlasList">
                  <li>
                    <img :src="item.url" :alt="''">
                  </li>
                </template>
              </ul>
            </div>
          </div>
          <div class="tab-comment" :class="{active : currentTab === 'comment'}">
            <div class="comment-container">
              <div class="comment-title">评论<span>共<span>10</span>条评论</span></div>
              <div class="comment-publish">
                <div class="publish-left">
                  <img
                    :src="user.avatar ? user.avatar : 'https://img0.baidu.com/it/u=2989859098,2005260256&amp;fm=253&amp;fmt=auto&amp;app=120&amp;f=JPEG?w=515&amp;h=500'"
                    :alt="user.nickName">
                </div>
                <div class="publish-right">
                  <textarea placeholder="说说你的看法..." v-model="commentContent"></textarea>
                  <div class="publish-btn">
                    <div class="star" @mousemove="width=$event.offsetX;console.log(width)"
                         @mouseleave="width = commentScore*8" @click="commentScore=Math.ceil($event.offsetX/8)">
                      <div class="star-on" :style="{width:width+'px'}"></div>
                    </div>
                    <button class="publish" @click="publishComment">发布</button>
                  </div>
                </div>
              </div>
              <div class="comment-filter">
                <div class="filter-item">
                  <span class="sort-active">热门</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>最新</span>
                </div>
                <div class="filter-item">
                  <select name="" id="">
                    <option>全部评分</option>
                    <option>5星</option>
                    <option>4星</option>
                    <option>3星</option>
                    <option>2星</option>
                    <option>1星</option>
                  </select>
                </div>
              </div>
              <ul class="comment-list">
                <li v-for="element in commentList">
                  <div class="comment-user">
                    <img
                      :src="element.user.avatar ? element.user.avatar : 'https://img0.baidu.com/it/u=2989859098,2005260256&amp;fm=253&amp;fmt=auto&amp;app=120&amp;f=JPEG?w=515&amp;h=500'"
                      :alt="element.user.nickName">
                    <p>{{ element.user.nickName || element.user.username || '未知用户' }}</p>
                  </div>
                  <div class="comment-info">
                    <div class="info-header">
                      <div class="star">
                        <div class="star-on" :style="{width:element.score * 10+'%'}"></div>
                      </div>
                      <div class="time">{{ element.createTime }}</div>
                    </div>
                    <div class="info-text">{{ element.content }}</div>
                  </div>
                  <div class="comment-action">
                    <a href=""><i class="iconfont icon-dianzan"></i>赞(1024)</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href=""><i class="iconfont icon-huifu"></i>回复</a>
                  </div>
                </li>
              </ul>
              <div class="comment-page">
                <el-pagination
                  v-model:current-page="pageNum"
                  v-model:page-size="pageSize"
                  background
                  layout="prev, pager, next, jumper"
                  :total="total"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="right" v-if="dataLoaded">
        <div class="title">预告片</div>
        <div class="content">
          <ul>
            <template v-if="film.trailerList.length>0">
              <li v-for="i in 3">
                <i class="rank">{{ i }}</i>
                <a href="">
                  <img :src="film.trailerList[i-1].coverUrl" :alt="''">
                </a>
                <div class="video-info">
                  <a class="video-title" href="">{{ film.trailerList[i - 1].name }}</a>
                  <div class="video-play-count">{{ film.trailerList[i - 1].thumbUp / 10000 }}万</div>
                </div>
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
import { computed, onMounted, ref, watchEffect } from 'vue'
import { addComment, getFilmComment, getFilmDetail, getUserIsWant, userUnWantFilm, userWantFilm } from '@/api/film.js'
import { useRoute, useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import { useUserStore } from '@/stores/userStore.js'

const route = useRoute()
const router = useRouter()
const film = ref({})
const dataLoaded = ref(false)
const isWantSee = ref(false)
const commentList = ref([])
const pageNum = ref(1)
const pageSize = ref(10)
const total = ref(0)
const commentContent = ref('')
const commentScore = ref(0)
const width = ref(0)
const { user } = useUserStore()

const filmScore = computed(() => {
  return film.value.score ? (String(film.value.score).length >= 3 ? String(film.value.score).substring(0, 3) : film.value.score + '.0') : '0.0'
})
const currentTab = ref('desc')
const changeTab = e => {
  if (e.target.tagName === 'SPAN') {
    currentTab.value = e.target.dataset.tab
  }
}
const goTab = tab => {
  currentTab.value = tab
}
const toggleWantSee = async () => {
  try {
    if (!Object.keys(user)) {
      ElMessage.error('请先登录')
      return
    }
    if (isWantSee.value) {
      const res = await userUnWantFilm(film.value.id, user.id)
      if (res.code === 200) {
        isWantSee.value = false
        ElMessage.success('取消想看成功')
      }
    } else {
      const res = await userWantFilm(film.value.id, user.id)
      if (res.code === 200) {
        isWantSee.value = true
        ElMessage.success('想看成功')
      }
    }
  } catch (e) {
    ElMessage.error('操作失败')
  }
}
const publishComment = async () => {
  try {
    const res = await addComment(commentContent.value, commentScore.value, film.value.id, user.id)
    if (res.code === 200) {
      ElMessage.success('评论成功')
      commentContent.value = ''
      commentScore.value = 0
      await getCommentList()
    }
  } catch (e) {
    ElMessage.error('操作失败')
  }
}
const getCommentList = async () => {
  const commentRes = await getFilmComment(film.value.id, pageNum.value, pageSize.value)
  commentList.value = commentRes.data.list
  total.value = commentRes.data.total
}

onMounted(async () => {
  const id = route.query.id
  console.log(user)
  if (Object.keys(user).length === 0) {
    ElMessage.error('请先登录')
    router.push('/login')
    return
  }
  if (!id) {
    ElMessage.error('参数错误')
    router.back()
    return
  }

  const filmDetailRes = await getFilmDetail(id)
  film.value = filmDetailRes.data
  dataLoaded.value = true

  const IsWantRes = await getUserIsWant(film.value.id, user.id)
  isWantSee.value = IsWantRes.code === 200

  watchEffect(async () => {
    await getCommentList()
  })
})

</script>

<style scoped>
.banner {
  margin-top: 80px;
  width: 100%;
  height: 376px;
  background: #392f59 url("https://s3.meituan.net/static-prod01/com.sankuai.movie.fe.mywww-files/banner_bg.f7fd103e3b8c16b6f449cce43fc57f45.png") no-repeat 50%;
  display: flex;
  justify-content: center;
}

.banner .wrapper {
  position: relative;
  width: 1200px;
  height: 100%;
  display: flex;
}

.banner .wrapper .left {
  position: absolute;
  top: 70px;
  left: 30px;
}

.banner .wrapper .left .image {
  box-sizing: border-box;
  display: block;
  width: 240px;
  height: 330px;
  border: 4px solid #fff;
  box-shadow: 0 10px 10px rgba(0, 0, 0, .1);
}

.banner .wrapper .left ._2dimax {
  position: absolute;
  display: block;
  top: 4px;
  left: -2px;
}

.banner .wrapper .right {
  width: 100%;
  height: 300px;
  margin: 70px 30px 0 300px;
  position: relative;
}

.banner .wrapper .right .info {
  position: absolute;
  top: 0;
  left: 0;
  font-size: 14px;
  color: #fff;
}

.banner .wrapper .right .info .name {
  font-weight: 700;
  line-height: 32px;
  font-size: 26px;
}

.banner .wrapper .right .info .e-name {
  width: 340px;
  font-size: 18px;
  margin-bottom: 14px;
  line-height: 1.3;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.banner .wrapper .right .info .area {
  margin: 12px 0;
}

.banner .wrapper .right .btns {
  position: absolute;
  bottom: 20px;
  left: 0;
  width: 250px;
  height: 86px;
  color: #fff;
  text-align: center;
}

.banner .wrapper .right .btns .want-score {
  width: 100%;
  height: 36px;
  font-size: 14px;
  display: flex;
  justify-content: space-between;
}

.banner .wrapper .right .btns .want-score a {
  display: inline-block;
  line-height: 36px;
  width: 120px;
  background-color: #756189;
  border-radius: 2px;
}

.banner .wrapper .right .btns .want-score i {
  vertical-align: middle;
}

.banner .wrapper .right .btns .want-score span {
  vertical-align: middle;
}

.banner .wrapper .right .btns .buy {
  display: block;
  height: 40px;
  width: 100%;
  margin-top: 10px;
  font-size: 16px;
  background-color: #df2d2d;
  line-height: 40px;
  border-radius: 2px;
}

.banner .wrapper .right .movie-stats-container {
  position: absolute;
  top: 158px;
  left: 342px;
  height: 142px;
  width: 123px;
  font-size: 12px;
  color: #fff;
}

.banner .wrapper .right .movie-stats-container .title {
  width: 100%;
  line-height: 1;
  margin-bottom: 8px;
}

.banner .wrapper .right .movie-stats-container .stats {
  width: 100%;
  margin-bottom: 16px;
  display: flex;
  justify-content: space-between;
}

.banner .wrapper .right .movie-stats-container .stats .score {
  width: 40px;
  height: 30px;
  color: #ffc600;
  font-size: 30px;
}

.banner .wrapper .right .movie-stats-container .stats .box {
  margin-left: 10px;
}

.banner .wrapper .right .movie-stats-container .stats .box .star {
  width: 60px;
  height: 12px;
  margin-bottom: 4px;
  background: url('@/assets/images/star-white.png') repeat-x;
}

.banner .wrapper .right .movie-stats-container .stats .box .star .star-on {
  height: 100%;
  width: 94%;
  background: url('@/assets/images/star-orange.png') repeat-x;
}

.banner .wrapper .right .movie-stats-container .total {
  height: 38px;
}

.banner .wrapper .right .movie-stats-container .total span {
  font-size: 30px;
}

.main {
  width: 1200px;
  margin-top: 80px;
  display: flex;
  justify-content: space-between;
}

.main .left {
  width: 730px;
}

.main .left .nav {
  margin-bottom: 25px;
  font-size: 16px;
  color: #333;
  line-height: 1.3;
}

.main .left .tab {
  box-sizing: border-box;
  height: 30px;
  border-bottom: 2px solid #eee;
  display: flex;
}

.main .left .tab span {
  display: block;
  font-size: 18px;
  margin-right: 30px;
  margin-bottom: -2px;
}

.main .left .tab span:hover {
  cursor: pointer;
}

.main .left .tab span.active {
  color: #ef4238;
  border-bottom: 2px solid #ef4238;
}

.main .left .tab-content {
  margin-top: 40px;
}

.main .left .tab-content > div {
  display: none;
}

.main .left .tab-content > .active {
  display: block;
}

.main .left .tab-content .tab-desc .module {
  margin-bottom: 60px;
  color: #333;
}

.main .left .tab-content .tab-desc .module .title {
  line-height: 18px;
  font-size: 18px;
  font-weight: 400;
  margin-bottom: 20px;
  padding-left: 6px;
  border-left: 4px solid #ef4238;
  display: flex;
  justify-content: space-between;
}

.main .left .tab-content .tab-desc .module .title a {
  font-size: 14px;
  color: #999;
}

.main .left .tab-content .tab-desc .module .content {
  margin-top: 20px;
  font-size: 14px;
  line-height: 26px;
  display: flex;
  overflow: hidden;
}

.main .left .tab-content .tab-desc .module .content .celebrity-group {
  font-size: 16px;
  flex-shrink: 0;
}

.main .left .tab-content .tab-desc .module .content .celebrity-group:nth-child(2) {
  margin-left: 30px;
  flex-grow: 1;
}

.main .left .tab-content .tab-desc .module .content .celebrity-group .type {
  margin-bottom: 16px;
}

.main .left .tab-content .tab-desc .module .content .celebrity-group .list {
  display: flex;
  margin-left: -20px;
  margin-bottom: 6px;
  text-align: center;
}

.main .left .tab-content .tab-desc .module .content .celebrity-group .list .info {
  margin-left: 20px;
  display: flex;
  flex-direction: column;
}

.main .left .tab-content .tab-desc .module .content .celebrity-group .list .info .name {
  margin-top: 14px;
  width: 128px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.main .left .tab-content .tab-desc .module .content .celebrity-group .list .info .role {
  line-height: 1.2;
  font-size: 14px;
  color: #666;
}

.main .left .tab-content .tab-desc .module .content ul {
  flex-grow: 1;
}

.main .left .tab-content .tab-desc .module .content ul li {
  padding-bottom: 20px;
  border-bottom: 1px dashed #ccc;
}

.main .left .tab-content .tab-desc .module .content ul li.last {
  padding-bottom: 0;
  border-bottom: none;
}

.main .left .tab-content .tab-desc .module .content ul li .award-title {
  display: flex;
  align-items: center;
  font-size: 16px;
}

.main .left .tab-content .tab-desc .module .content ul li .award-title img {
  margin: 20px 20px 20px 0;
  border-radius: 50%;
}

.main .left .tab-content .tab-desc .module .content ul li .award {
  font-size: 14px;
  line-height: 26px;
}

.main .left .tab-content .tab-desc .module .content .album img {
  display: block;
  float: left;
  margin-left: 6px;
}

.main .left .tab-content .tab-desc .module .content .album .img1 {
  margin-left: 0;
}

.main .left .tab-content .tab-desc .module .content .album .img4,
.main .left .tab-content .tab-desc .module .content .album .img5 {
  margin-top: 6px;
}

.main .left .tab-content .tab-desc .module .content .attribute {
  width: 100%;
  display: flex;
  flex-wrap: wrap;
}

.main .left .tab-content .tab-desc .module .content .attribute .item {
  box-sizing: border-box;
  border: 0.5px solid #e5e5e5;
  width: 50%;
  height: 93px;
  padding: 20px 0 20px 27px;
}

.main .left .tab-content .tab-desc .module .content .attribute .item:nth-child(3) {
  border-top: none;
}

.main .left .tab-content .tab-desc .module .content .attribute .item:nth-child(2) {
  border-left: none;
}

.main .left .tab-content .tab-desc .module .content .attribute .item .item-title {
  font-size: 18px;
}

.main .left .tab-content .tab-desc .module .content .attribute .item .item-title img {
  margin-right: 10px;
}

.main .left .tab-content .tab-desc .module .content .attribute .item .item-content {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-size: 16px;
  color: #666;
  margin-top: 8px;
  padding: 0 25px;
}

.main .left .tab-content .tab-desc .module .content .honor {
  flex-grow: 1;
  height: 130px;
  display: flex;
  justify-content: space-around;
  align-items: center;
  background-color: #f8f8f8;
}

.main .left .tab-content .tab-desc .module .content .honor .honor-item .honor-item-num {
  font-size: 26px;
}

.main .left .tab-content .tab-desc .module .content .honor .honor-item:nth-child(1) {
  color: #f03d37;
}

.main .left .tab-content .tab-desc .module .content .honor .honor-item:nth-child(2) {
  color: #faaf00;
}

.main .left .tab-content .tab-desc .module .content .honor .honor-item:nth-child(3) {
  color: #333;
}

.main .left .tab-content .tab-desc .module .content .honor .honor-item .honor-item-title {
  color: #666;
  margin-top: 6px;
  font-size: 20px;
}

.main .left .tab-content .tab-desc .module .content .sale-info {
  flex-grow: 1;
  height: 130px;
  display: flex;
  justify-content: space-around;
  align-items: center;
  background-color: #f8f8f8;
  text-align: center;
}

.main .left .tab-content .tab-desc .module .content .sale-info .sale-item .sale-item-num {
  color: #f03d37;
  font-size: 26px;
}

.main .left .tab-content .tab-desc .module .content .sale-info .sale-item .sale-item-title {
  color: #666;
  margin-top: 6px;
  font-size: 20px;
}

.main .left .tab-content .tab-desc .module .content .film-music {
  flex-grow: 1;
  display: flex;
  align-items: center;
  border: 1px solid #e8e8e8;
}

.main .left .tab-content .tab-desc .module .content .film-music .music-info {
  width: 218px;
  margin-left: 20px;
  color: #999;
  font-size: 20px;
  line-height: 28px;
}

.main .left .tab-content .tab-desc .module .content .film-music .music-info .music-title {
  font-size: 26px;
  line-height: 37px;
  color: #333;
}


.main .left .tab-content .tab-actor .actor-container {
  width: 100%;
  margin-top: 40px;
}

.main .left .tab-content .tab-actor .actor-container .actor-group {
  margin-bottom: 30px;
  color: #333;
  font-size: 16px;
}

.main .left .tab-content .tab-actor .actor-container .actor-group .actor-type {
  line-height: 1.3;
  margin-bottom: 16px;
}

.main .left .tab-content .tab-actor .actor-container .actor-group .actor-type span {
  font-size: 14px;
  color: #999;
}

.main .left .tab-content .tab-actor .actor-container .actor-group ul {
  display: flex;
  flex-wrap: wrap;
  margin-left: -20px;
}

.main .left .tab-content .tab-actor .actor-container .actor-group ul li {
  width: 128px;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-left: 20px;
  margin-bottom: 20px;
}

.main .left .tab-content .tab-actor .actor-container .actor-group ul li .actor-info {
  margin-top: 14px;
  width: 100%;
  text-align: center;
  white-space: nowrap;
}

.main .left .tab-content .tab-actor .actor-container .actor-group ul li .actor-name {
  line-height: 1.2;
  text-overflow: ellipsis;
  overflow: hidden;
}

.main .left .tab-content .tab-actor .actor-container .actor-group ul li .actor-role {
  margin-top: 5px;
  font-size: 14px;
  color: #666;
  text-overflow: ellipsis;
  overflow: hidden;
}

.main .left .tab-content .tab-prize .prize-container {
  margin-top: -40px;
}

.main .left .tab-content .tab-prize .prize-container ul li {
  padding-bottom: 20px;
  border-bottom: 1px dashed #ccc;
}

.main .left .tab-content .tab-prize .prize-container ul li:last-child {
  padding-bottom: 0;
  border-bottom: none;
}

.main .left .tab-content .tab-prize .prize-container ul li .award-title {
  height: 90px;
  display: flex;
  align-items: center;
}

.main .left .tab-content .tab-prize .prize-container ul li .award-title img {
  height: 50px;
  width: 50px;
  margin-right: 24px;
  border-radius: 50%;
}

.main .left .tab-content .tab-prize .prize-container ul li p {
  font-size: 14px;
  line-height: 26px;
}

.main .left .tab-content .tab-img .img-container {
  margin-top: -40px;
}

.main .left .tab-content .tab-img .img-container ul {
  margin-left: -20px;
  display: flex;
  flex-wrap: wrap;
}

.main .left .tab-content .tab-img .img-container li {
  margin-top: 20px;
  margin-left: 20px;
}

.main .left .tab-content .tab-img .img-container li img {
  display: block;
  width: 104px;
  height: 104px;
}

.main .left .tab-content .tab-comment .comment-container .comment-title {
  display: flex;
  justify-content: space-between;
  border-left: 3px solid #ef4238;
  padding-left: 10px;
  font-size: 18px;
  color: #333;
  margin-bottom: 10px;
}

.main .left .tab-content .tab-comment .comment-container .comment-title span {
  font-size: 14px;
  color: #999;
}

.main .left .tab-content .tab-comment .comment-container .comment-publish {
  display: flex;
  padding: 20px;
  background-color: #f9f9f9;
  margin-bottom: 30px;
}

.main .left .tab-content .tab-comment .comment-container .comment-publish .publish-left img {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  margin-right: 20px;
}

.main .left .tab-content .tab-comment .comment-container .comment-publish .publish-right {
  flex-grow: 1;
}

.main .left .tab-content .tab-comment .comment-container .comment-publish .publish-right textarea {
  height: 80px !important;
  width: 100% !important;
  margin-bottom: 10px;
}

.main .left .tab-content .tab-comment .comment-container .comment-publish .publish-right .publish-btn {
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.main .left .tab-content .tab-comment .comment-container .comment-publish .publish-right .publish-btn .star {
  width: 80px;
  height: 16px;
  background: url("@/assets/images/star-border.png") repeat-x;
}

.main .left .tab-content .tab-comment .comment-container .comment-publish .publish-right .publish-btn .star .star-on {
  width: 0px;
  height: 16px;
  background: url("@/assets/images/star-border-full.png") repeat-x;
}

.main .left .tab-content .tab-comment .comment-container .comment-publish .publish-right .publish-btn .star i:hover {
  cursor: pointer;
}

.main .left .tab-content .tab-comment .comment-container .comment-publish .publish-right .publish-btn button {
  padding: 8px 20px;
  color: #fff;
  background-color: #ef4238;
  border: none;
  border-radius: 5px;
}

.main .left .tab-content .tab-comment .comment-container .comment-filter {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
  padding: 10px 0;
  border-bottom: 1px solid #e5e5e5;
  color: #666;
  font-size: 14px;
}

.main .left .tab-content .tab-comment .comment-container .comment-filter .sort-active {
  color: #ef4238;
}

.main .left .tab-content .tab-comment .comment-container ul li {
  display: flex;
  height: 70px;
  padding: 20px 0;
  font-size: 14px;
}

.main .left .tab-content .tab-comment .comment-container ul li .comment-user {
  flex-shrink: 0;
  margin-right: 20px;
  width: 60px;
  text-align: center;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-size: 12px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.main .left .tab-content .tab-comment .comment-container ul li .comment-user img {
  display: block;
  margin-bottom: 10px;
  width: 40px;
  height: 40px;
  border-radius: 50%;
}

.main .left .tab-content .tab-comment .comment-container ul li .comment-info {
  flex-grow: 1;
}

.main .left .tab-content .tab-comment .comment-container ul li .comment-info .info-header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

.main .left .tab-content .tab-comment .comment-container ul li .comment-info .info-header .star {
  width: 80px;
  height: 16px;
  background: url("@/assets/images/star-border.png") repeat-x;
}

.main .left .tab-content .tab-comment .comment-container ul li .comment-info .info-header .star .star-on {
  width: 0px;
  max-width: 80px;
  height: 16px;
  background: url("@/assets/images/star-border-full.png") repeat-x;
}

.main .left .tab-content .tab-comment .comment-container ul li .comment-info .info-header .time {
  color: #999;
  font-size: 12px;
}

.main .left .tab-content .tab-comment .comment-container ul li .comment-action {
  flex-shrink: 0;
  color: #999;
  line-height: 70px;
}

.main .left .tab-content .tab-comment .comment-container ul li .comment-action a:hover {
  color: #ef4238;
}

.main .left .tab-content .tab-comment .comment-container .comment-page {
  margin-top: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 14px;
  color: #333;
}

.main .left .tab-content .tab-comment .comment-container .comment-page a {
  display: block;
  width: 30px;
  height: 30px;
  border-radius: 5px;
  margin: 0 5px;
  text-align: center;
  line-height: 30px;
}

.main .left .tab-content .tab-comment .comment-container .comment-page .current {
  display: block;
  width: 30px;
  height: 30px;
  border-radius: 5px;
  margin: 0 5px;
  background-color: #ef4238;
  color: #fff;
  text-align: center;
  line-height: 30px;
}

.main .left .tab-content .tab-comment .comment-container .comment-page span {
  margin-left: 30px;
}

.main .left .tab-content .tab-comment .comment-container .comment-page input {
  width: 40px;
  height: 30px;
  text-align: center;
  margin: 0 5px;
  border: 1px solid #e5e5e5;
  border-radius: 4px;
}

.main .left .tab-content .tab-comment .comment-container .comment-page button {
  padding: 0 10px;
  height: 30px;
  background-color: #ef4238;
  color: #fff;
  border: none;
  border-radius: 4px;
  margin-left: 5px;
  cursor: pointer;
}


.main .right {
  width: 360px;
  color: #333;
}

.main .right .title {
  font-weight: 400;
  font-size: 18px;
  line-height: 18px;
  border-left: 4px solid #ef4238;
  padding-left: 6px;
}

.main .right .content {
  margin-top: 20px;
}

.main .right .content ul li {
  position: relative;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

.main .right .content ul li img {
  display: block;
}

.main .right .content ul li i {
  position: absolute;
  left: 0;
  bottom: 0;
  font-style: italic;
  font-size: 16px;
  line-height: 20px;
  color: #fff;
  display: block;
  height: 18px;
  width: 15px;
  padding-left: 3px;
  background-color: #f90;
}

.main .right .content ul li .video-info {
  width: 224px;
}

.main .right .content ul li .video-info .video-title {
  display: block;
  text-align: center;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin: 10px 0 16px 0;
}

.main .right .content ul li .video-info .video-title:hover {
  color: #ff0000;

}

.main .right .content ul li .video-info .video-play-count {
  color: #999;
  font-size: 12px
}

.main .right .content ul li .video-info .video-play-count::before {
  content: '';
  width: 0;
  height: 0;
  margin-right: 5px;
  display: inline-block;
  border-width: 5px 0 5px 8px;
  border-style: solid;
  border-color: transparent transparent transparent #d8d8d8;
}
</style>
