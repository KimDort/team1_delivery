
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import DeliveryStatusManager from "./components/listers/DeliveryStatusCards"
import DeliveryStatusDetail from "./components/listers/DeliveryStatusDetail"

import PayManager from "./components/listers/PayCards"
import PayDetail from "./components/listers/PayDetail"


import OrderPushView from "./components/OrderPushView"
import OrderPushViewDetail from "./components/OrderPushViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/deliveryStatuses',
                name: 'DeliveryStatusManager',
                component: DeliveryStatusManager
            },
            {
                path: '/deliveryStatuses/:id',
                name: 'DeliveryStatusDetail',
                component: DeliveryStatusDetail
            },

            {
                path: '/pays',
                name: 'PayManager',
                component: PayManager
            },
            {
                path: '/pays/:id',
                name: 'PayDetail',
                component: PayDetail
            },


            {
                path: '/orderPushes',
                name: 'OrderPushView',
                component: OrderPushView
            },
            {
                path: '/orderPushes/:id',
                name: 'OrderPushViewDetail',
                component: OrderPushViewDetail
            },


    ]
})
