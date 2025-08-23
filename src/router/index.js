import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/index'
    },
    {
      path: '/index',
      name: 'index',
      component: () => import('../views/Index.vue')
    },
    {
      path: '/detail',
      name: 'detail',
      component: () => import('../views/Detail.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/Login.vue')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('../views/Register.vue')
    },
    {
      path: '/film',
      name: 'film',
      component: () => import('../views/Film.vue')
    },
    {
      path: '/cinemas',
      name: 'cinemas',
      component: () => import('../views/Cinemas.vue')
    },
    {
      path: '/cinema',
      name: 'cinema',
      component: () => import('../views/Cinema.vue')
    },
  ],
})

export default router
