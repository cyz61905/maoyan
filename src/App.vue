<template>
  <RouterView/>
</template>

<script setup>

import { useUserStore } from '@/stores/userStore.js'

const userStore = useUserStore()
userStore.user.value = JSON.parse(localStorage.getItem('user'))


</script>

<style scoped>

</style>
