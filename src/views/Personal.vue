<template>
  <DefaultLayout>
    <div class="container">
      <div class="left">
        <div class="title">个人中心</div>
        <router-link to="/personal/order" exact-active-class="active">我的订单</router-link>
        <router-link to="/personal/profile" exact-active-class="active">基本信息</router-link>
      </div>
      <router-view></router-view>
    </div>
  </DefaultLayout>
</template>

<script setup>

import DefaultLayout from '@/layout/DefaultLayout.vue'
</script>

<style scoped>
.container {
  width: 1164px;
  height: 900px;
  margin-top: 110px;
  border: 1px solid #e1e1e1;
  display: flex;
}

.container .left {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 200px;
  background-color: #f4f3f4;
  border-right: 1px solid #e1e1e1;
}

.container .left .title {
  line-height: 28.67px;
  font-size: 22px;
  color: #222;
  margin: 40px 0 30px 0;
}

.container .left a {
  width: 100%;
  height: 40px;
  line-height: 40px;
  text-align: center;
  font-size: 18px;
}

.container .left a.active {
  color: #fff;
  background-color: #ed3931;
}
</style>
