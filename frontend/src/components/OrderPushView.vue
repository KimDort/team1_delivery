<template>

    <v-data-table
        :headers="headers"
        :items="orderPush"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderPushView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "storeStatus", value: "storeStatus" },
                { text: "isPicked", value: "isPicked" },
                { text: "isDelivered", value: "isDelivered" },
            ],
            orderPush : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orderPushes'))

            temp.data._embedded.orderPushes.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.orderPush = temp.data._embedded.orderPushes;
        },
        methods: {
        }
    }
</script>

