import { reactive, ref } from 'vue'
import { defineStore } from 'pinia'

export const useFilmSessionStore = defineStore('filmSession', () => {
  const film = ref({})
  const cinema = ref({})
  const session = ref({})
  const date = ref('')
  return { film, cinema, session, date}
})
