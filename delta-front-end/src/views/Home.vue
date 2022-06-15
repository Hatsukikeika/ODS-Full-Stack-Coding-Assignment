<template>
  <div class="home">
      <el-card class="box-card">
        <div slot="header" class="searchOpt">
          <el-switch
            v-model="useAdvSearch"
            active-text="Auto Suggest">
          </el-switch>
        </div>
        <el-row :gutter="10">
          <el-col :span="12" :offset="4">
            <el-autocomplete
              v-model="searchKeyWord"
              :fetch-suggestions="autoSuggestion"
              placeholder="Enter Keyword"
              :trigger-on-focus="false"
              @select="handleSelect"
            >
              <el-select v-model="searchOptionCode" slot="prepend">
                <el-option
                  v-for="item in searchOptions"
                  :key="item.value"
                  :label="item.text"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-autocomplete>
          </el-col>
          <el-col :span="4">
            <el-button icon="el-icon-search" type="info" @click="searchFlights(0)">
              Search
            </el-button>
          </el-col>
        </el-row>
      </el-card>
      <el-card class="result-block">
        <el-table
          :data="searchResult"
          border
          style="width: 100%"
          height="710px"
          max-height="710px"
          id = "result-table">
          <el-table-column
            fixed
            width="70px"
            prop="id"
            label="ID">
          </el-table-column>
          <el-table-column
            v-for="item in resultTableMapping"
            :key="item.text"
            :prop="item.value"
            :label="item.text"
            :min-width="item.width">
          </el-table-column>
        </el-table>
        <el-pagination
          @current-change="quickPager"
          :current-page.sync="currentPage"
          :page-size="pageSizeLimitation"
          layout="prev, pager, next, jumper"
          :total="totalResultFound"
          id="result-pagination"
          >
        </el-pagination>
      </el-card>
  </div>
</template>

<script>
// @ is an alias to /src
export default {
  name: 'Home',
  components: {},
  data () {
    return {
      useAdvSearch: true,
      searchResult: [],
      searchOptions: [
        { text: 'All', value: 'all' },
        { text: 'From', value: 'from' },
        { text: 'To', value: 'to' }
      ],
      searchKeyWord: '',
      searchOptionCode: 'all',
      resultTableMapping: [
        { text: 'Created Time', value: 'createAt', width: 160 },
        { text: 'Updated Time', value: 'updateAt', width: 160 },
        { text: 'Flight UUID', value: 'flightUID', width: 320 },
        { text: 'Flight Number', value: 'flightNum', width: 150 },
        { text: 'Origin Gate', value: 'gateOrigin', width: 120 },
        { text: 'Destination Gate', value: 'gateDestination', width: 140 },
        { text: 'Out', value: 'out', width: 160 },
        { text: 'In', value: 'in', width: 160 },
        { text: 'Off', value: 'off', width: 160 },
        { text: 'On', value: 'on', width: 160 },
        { text: 'Destination Code', value: 'destination', width: 140 },
        { text: 'Origin Code', value: 'origin', width: 130 },
        { text: 'Destination Name', value: 'fullDestination', width: 250 },
        { text: 'Origin Name', value: 'fullOrigin', width: 250 }
      ],
      currentPage: 1,
      totalResultFound: 0,
      pageSizeLimitation: 10
    }
  },
  methods: {
    quickPager (index) {
      this.searchFlights(index - 1)
    },
    handleSelect (keyword) {
      this.searchKeyWord = keyword.value
    },
    async autoSuggestion (prefix, callback) {
      var suggestion = []
      if (!this.useAdvSearch) {
        callback(suggestion)
        return
      }

      await this.$axios({
        method: 'get',
        url: '/station/lookup/' + prefix + '?limit=6'
      })
        .then((res) => {
          if (res.data.payload.status !== 200) return this.$message.error(res.data.payload.message)

          suggestion = (res.data.data).map(value => ({ value }))
          callback(suggestion)
        })
        .catch((err) => {
          this.$handleResError(err.response)
        })
    },
    async searchFlights (index) {
      if (this.searchKeyWord === '') return

      await this.$axios({
        method: 'get',
        url: '/flights/' + this.searchKeyWord + '?type=' + this.searchOptionCode + '&page=' + index
      })
        .then((res) => {
          if (res.data.payload.status !== 200) return this.$message.error(res.data.payload.message)

          this.searchResult = res.data.data.content
          this.totalResultFound = res.data.data.totalElements
          this.pageSizeLimitation = res.data.data.size
          this.currentPage = res.data.data.number + 1
        })
        .catch((err) => {
          this.$handleResError(err.response)
        })
    }
  }
}
</script>

<style lang="less" scoped>
  .result-block {
    margin-top: 15px;

    #result-pagination {
      margin-top: 10px;
    }
  }

  .searchOpt {
    text-align: right;
  }

  .searchInput{
    margin: 0 0 10 10;
  }

  .el-select {
    width: 85px;
  }

  .el-autocomplete {
    width: 100%;
  }
</style>
