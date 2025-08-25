import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return { top: 0 }
    }
  },
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
    {
      path: '/seat',
      name: 'seat',
      component: () => import('../views/Seat.vue')
    },
    {
      path: '/confirm',
      name: 'confirm',
      component: () => import('../views/Confirm.vue')
    },
    {
      path: '/personal',
      name: 'personal',
      component: () => import('../views/Personal.vue'),
      redirect: '/personal/order',
      children: [
        {
          path: 'order',
          name: 'order',
          component: () => import('../components/Order.vue')
        },
        {
          path: 'profile',
          name: 'profile',
          component: () => import('../components/Profile.vue')
        }
      ]
    },
    {
      path: '/orderDetail',
      name: 'orderDetail',
      component: () => import('../views/OrderDetail.vue')
    }
  ],
})

export default router
