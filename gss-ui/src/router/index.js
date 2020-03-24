import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/* Router Modules */
import componentsRouter from './modules/components'
import chartsRouter from './modules/charts'
import tableRouter from './modules/table'
import nestedRouter from './modules/nested'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    noCache: true                if set true, the page will no be cached(default is false)
    affix: true                  if set true, the tag will affix in the tags-view
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index'),
        name: 'Dashboard',
        meta: { title: 'Dashboard', icon: 'dashboard', affix: true }
      }
    ]
  },
  {
    path: '/documentation',
    component: Layout,
    children: [
      {
        path: 'index',
        component: () => import('@/views/documentation/index'),
        name: 'Documentation',
        meta: { title: 'Documentation', icon: 'documentation', affix: true }
      }
    ]
  },
 
  {
    path: '/profile',
    component: Layout,
    redirect: '/profile/index',
    hidden: true,
    children: [
      {
        path: 'index',
        component: () => import('@/views/profile/index'),
        name: 'Profile',
        meta: { title: 'Profile', icon: 'user', noCache: true }
      }
    ]
  }
]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
  {
    path: '/base',
    component: Layout,
    children: [
      {
        path: 'list',
        component: () => import('@/pages/base/List'),
        name: 'base_list',
        meta: { title: '用户管理', icon: 'user', affix: true }
      }
    ]
  },
  {
    path: '/base',
    component: Layout,
    children: [
      {
        hidden: true,
        path: 'add',
        component: () => import('@/pages/base/Add'),
        name: 'base_add',
        meta: { title: '添加用户', icon: 'user', affix: true }
      }
    ]
  },
  {
    path: '/academy',
    component: Layout,
    children: [
      {
        path: 'list',
        component: () => import('@/pages/academy/List'),
        name: 'academy_list',
        meta: { title: '学院管理', icon: 'user', affix: true }
      }
    ]
  },
  {
    path: '/academy',
    component: Layout,
    children: [
      {
        hidden:true,
        path: 'add',
        component: () => import('@/pages/academy/Add'),
        name: 'academy_add',
        meta: { title: '添加学院', icon: 'user', affix: true }
      }
    ]
  },
  {
    path: '/cla',
    component: Layout,
    children: [
      {
        path: 'list',
        component: () => import('@/pages/cla/List'),
        name: 'cla_list',
        meta: { title: '班级管理', icon: 'user', affix: true }
      }
    ]
  },
  {
    path: '/cla',
    component: Layout,
    children: [
      {
        hidden:true,
        path: 'add',
        component: () => import('@/pages/cla/Add'),
        name: 'cla_add',
        meta: { title: '添加班级', icon: 'user', affix: true }
      }
    ]
  },
  {
    path: '/grants',
    component: Layout,
    children: [
      {
        path: 'add',
        component: () => import('@/pages/grants/Add'),
        name: 'grants_add',
        meta: { title: '助学金申请', icon: 'edit', affix: true ,role:'学生'}
      }
    ]
  },
  {
    path: '/scholarship',
    component: Layout,
    children: [
      {
        path: 'add',
        component: () => import('@/pages/scholarship/Add'),
        name: 'scholarship_add',
        meta: { title: '奖学金申请', icon: 'edit', affix: true }
      }
    ]
  },
  {
    path: '/detailed',
    component: Layout,
    children: [
      {
        path: 'add',
        component: () => import('@/pages/detailed/Add'),
        name: 'detailed_add',
        meta: { title: '个人详细信息', icon: 'edit', affix: true }
      }
    ]
  },
  {
    path: '/check',
    component: Layout,
    children: [
      {
        path: 'grant',
        component: () => import('@/pages/check/Grant'),
        name: 'check_grant',
        meta: { title: '助学金审核', icon: 'list', affix: true }
      }
    ]
  },
  {
    path: '/check',
    component: Layout,
    children: [
      {
        path: 'scholarship',
        component: () => import('@/pages/check/Scholarship'),
        name: 'check_scholarship',
        meta: { title: '奖学金审核', icon: 'list', affix: true }
      }
    ]
  },
  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
