<template>
  <RouterView v-if="show"/>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js'
import { nextTick, onMounted, provide, ref } from 'vue'

const userStore = useUserStore()
const show = ref(true)
const refresh = () => {
  show.value = false
  nextTick(() => {
    show.value = true
  })
}
onMounted(() => {
  userStore.user = JSON.parse(localStorage.getItem('user')) || {}
  console.log(userStore.user)
  console.log('App.vue mounted')
})
provide('refresh', refresh)
</script>

<style scoped>

</style>
