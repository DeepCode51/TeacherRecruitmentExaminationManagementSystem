import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import adminexam from '@/views/modules/exampaperlist/exam'
    import news from '@/views/modules/news/list'
    import examfailrecord from '@/views/modules/examfailrecord/list'
    import xuelifenlei from '@/views/modules/xuelifenlei/list'
    import yingpinyaoqing from '@/views/modules/yingpinyaoqing/list'
    import examquestion from '@/views/modules/examquestion/list'
    import yingpinjieguo from '@/views/modules/yingpinjieguo/list'
    import exampaper from '@/views/modules/exampaper/list'
    import menu from '@/views/modules/menu/list'
    import storeup from '@/views/modules/storeup/list'
    import yingpinxinxi from '@/views/modules/yingpinxinxi/list'
    import discusszhaopinxinxi from '@/views/modules/discusszhaopinxinxi/list'
    import zhaopinxinxi from '@/views/modules/zhaopinxinxi/list'
    import gerenjianli from '@/views/modules/gerenjianli/list'
    import yonghu from '@/views/modules/yonghu/list'
    import chat from '@/views/modules/chat/list'
    import exampaperlist from '@/views/modules/exampaperlist/list'
    import config from '@/views/modules/config/list'
    import examrecord from '@/views/modules/examrecord/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '招聘资讯',
        component: news
      }
      ,{
	path: '/examfailrecord',
        name: '错题本',
        component: examfailrecord
      }
      ,{
	path: '/xuelifenlei',
        name: '学历分类',
        component: xuelifenlei
      }
      ,{
	path: '/yingpinyaoqing',
        name: '应聘邀请',
        component: yingpinyaoqing
      }
      ,{
	path: '/examquestion',
        name: '笔试试题管理',
        component: examquestion
      }
      ,{
	path: '/yingpinjieguo',
        name: '应聘结果',
        component: yingpinjieguo
      }
      ,{
	path: '/exampaper',
        name: '试卷管理',
        component: exampaper
      }
      ,/**{
	path: '/menu',
        name: '菜单列表',
        component: menu
      }
      ,**/{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/yingpinxinxi',
        name: '应聘信息',
        component: yingpinxinxi
      }
      ,{
	path: '/discusszhaopinxinxi',
        name: '招聘信息评论',
        component: discusszhaopinxinxi
      }
      ,{
	path: '/zhaopinxinxi',
        name: '招聘信息',
        component: zhaopinxinxi
      }
      ,{
	path: '/gerenjianli',
        name: '个人简历',
        component: gerenjianli
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/chat',
        name: '在线沟通',
        component: chat
      }
      ,{
	path: '/exampaperlist',
        name: '试卷列表',
        component: exampaperlist
      }
      ,{
	path: '/config',
        name: '轮播图',
        component: config
      }
      ,{
	path: '/examrecord',
        name: '笔试记录',
        component: examrecord
      }
    ]
  },
  {
    path: '/adminexam',
    name: 'adminexam',
    component: adminexam,
    meta: {icon:'', title:'adminexam'}
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
