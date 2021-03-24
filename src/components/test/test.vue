<template>
  <div>
    <div v-for="i in datalist" :key="i.name">
      <li>{{ i.name }}</li>
      <li>{{ i.sex }}</li>
      <li>{{ i.age }}</li>
    </div>
    <input type="button" @click="getValue()" value="按钮" />
  </div>
</template>

<script>
import { ApiHelper } from "@/apis/AxiosHelper";
export default {
  name: 'test',
  data() {
    return {
      datalist: [],
    };
  },

  created() {
    this.datalist = [
      {
        name: 'aa',
        age: '14',
        sex: 'nan',
      },
      {
        name: 'bb',
        age: '15',
        sex: 'nan',
      },
    ];
  },

  methods: {
    getValue() {
      let aa = ApiHelper.get('getAll');
      console.log(aa);
      this.datalist = [
        {
          name: 'bb',
          age: '16',
          sex: 'nv',
        },
      ];
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
ul,
li {
  padding: 0;
  margin: 0;
  list-style: none;
}
</style>
