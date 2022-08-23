<template>

    <v-card outlined>
        <v-card-title>
            OrderPush # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="StoreStatus" v-model="item.storeStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="IsPicked" v-model="item.isPicked" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="IsDelivered" v-model="item.isDelivered" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'OrderPushViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/orderPushes/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

