import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', () => {
  const user = ref({})

  function logout () {
    user.value = {}
    localStorage.removeItem('user')
  }
  return { user , logout}
})
