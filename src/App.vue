<template>
  <RouterView />
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js'
import { onMounted } from 'vue'

const userStore = useUserStore()

onMounted(() => {
  userStore.user.value = JSON.parse(localStorage.getItem('user')) || {}
  console.log('App.vue mounted')
})

</script>

<style scoped>

</style>
