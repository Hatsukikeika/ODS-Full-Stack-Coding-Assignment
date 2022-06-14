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
            <el-input placeholder="Enter the Station Code Here" v-model="searchKeyWord" class="input-with-select">
              <el-select v-model="searchOptionCode" slot="prepend">
                <el-option
                  v-for="item in searchOptions"
                  :key="item.value"
                  :label="item.text"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-input>
          </el-col>
          <el-col :span="4">
            <el-button icon="el-icon-search" type="info">
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
          id = "result-table">
          <el-table-column
            fixed
            prop="date"
            label="date">
          </el-table-column>
          <el-table-column
            prop="origin"
            label="origin">
          </el-table-column>
          <el-table-column
            prop="destination"
            label="destination">
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
      useAdvSearch: false,
      searchResult: [],
      searchOptions: [
        { text: 'All', value: 0 },
        { text: 'From', value: 1 },
        { text: 'To', value: 2 }
      ],
      searchKeyWord: '',
      searchOptionCode: 0,
      currentPage: 1,
      totalResultFound: 0,
      pageSizeLimitation: 10
    }
  },
  methods: {
    quickPager (index) {
      // Update Table content
    }
  }
}
</script>

<style lang="less" scoped>
  .result-block {
    margin-top: 15px;

    #result-table {
      height: 520px;
    }

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
</style>
