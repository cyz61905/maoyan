<template>
  <div class="header">
    <div class="header-inner">
      <div class="header-left">
        <div class="logo">
          <router-link to="/index"></router-link>
        </div>
        <div class="city">
          郑州
          <span class="arrow"></span>
          <div class="select">
            <div class="gps-city">
              <span>定位城市：</span><a href="">郑州</a><a href="">郑州</a><a href="">郑州</a>
            </div>
            <div class="recent-city">
              <span>近期定位：</span><a href="">郑州</a><a href="">郑州</a><a href="">郑州</a>
            </div>
            <div class="city-list">
              <ul>
                <li>
                  <span>A</span>
                  <div>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                  </div>
                </li>
                <li>
                  <span>A</span>
                  <div>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                  </div>
                </li>
                <li>
                  <span>A</span>
                  <div>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                  </div>
                </li>
                <li>
                  <span>A</span>
                  <div>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                  </div>
                </li>
                <li>
                  <span>A</span>
                  <div>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                  </div>
                </li>
                <li>
                  <span>A</span>
                  <div>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                    <a href="">阿拉善盟</a>
                    <a href="">鞍山</a>
                    <a href="">安庆</a>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="nav">
          <router-link to="/index" exact-active-class="active">首页</router-link>
          <router-link to="/film" exact-active-class="active">电影</router-link>
          <router-link to="/cinemas" exact-active-class="active">影院</router-link>
          <a href="">演出</a>
        </div>
      </div>
      <div class="header-right">
        <div class="APP">
          <i class="iconfont icon-shouji"></i>
          <span>APP下载</span>
          <span class="arrow"></span>
          <div class="download">
            <img src="" alt="" />
            <p>扫码下载APP</p>
            <p>选座更优惠</p>
          </div>
        </div>

        <div class="user">
          <img src="https://p0.meituan.net/movie/7dd82a16316ab32c8359debdb04396ef2897.png" alt="logo" />
          <span class="arrow"></span>
          <div class="login" v-if="!isLogin">
            <router-link to="/login">登录</router-link>
          </div>
          <div class="login" v-else>
            <router-link to="/order">我的订单</router-link>
            <router-link to="/profile">基本信息</router-link>
            <a class="logout" @click.prevent="logout">退出登录</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js'
import { computed, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'

const userStore = useUserStore()
const isLogin = computed(() => {
  return Object.keys(userStore.user).length !== 0
})

const logout = () => {
  ElMessageBox.confirm(
    '确定要退出登录吗?',
    '警告',
    {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }
  )
    .then(() => {
      userStore.logout()
      ElMessage.success('已退出登录')

    })
    .catch(() => {
      console.log('已取消')
    })
}

</script>

<style scoped>

</style>
