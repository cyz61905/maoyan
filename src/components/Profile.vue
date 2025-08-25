<template>
  <div class="right">
    <div class="title">基本信息</div>
    <div class="content" v-if="dataLoaded">
      <div class="avatar">
        <img
          :src="userInfo.avatar ? userInfo.avatar : 'https://img.meituan.net/maoyanuser/23f19f4cdfe538bdf85f0ccd863346639437.png'">
        <div class="edit"><span>更换头像</span><input type="file" name="file"></div>
        <div class="tips">支持JPG,JPEG,PNG格式,且文件需小于1M</div>
      </div>
      <form class="info">
        <div class="item">
          <div class="tag">昵称：</div>
          <div class="val"><input class="in" type="text"
                                  name="nickname" v-model="userInfo.nickName">
          </div>
        </div>
        <div class="item">
          <div class="tag">性别：</div>
          <div class="val">
            <el-radio-group v-model="userInfo.sex">
              <el-radio label="男">男</el-radio>
              <el-radio label="女">女</el-radio>
            </el-radio-group>
          </div>
        </div>
        <div class="item">
          <div class="tag">生日：</div>
          <div class="val">
            <select v-model="userInfo.birthday.split('-')[0]" name="year" class="bir-select">
              <option value="">--</option>
              <option value="2025">2025</option>
              <option value="2024">2024</option>
              <option value="2023">2023</option>
              <option value="2022">2022</option>
              <option value="2021">2021</option>
              <option value="2020">2020</option>
              <option value="2019">2019</option>
              <option value="2018">2018</option>
              <option value="2017">2017</option>
              <option value="2016">2016</option>
              <option value="2015">2015</option>
              <option value="2014">2014</option>
              <option value="2013">2013</option>
              <option value="2012">2012</option>
              <option value="2011">2011</option>
              <option value="2010">2010</option>
              <option value="2009">2009</option>
              <option value="2008">2008</option>
              <option value="2007">2007</option>
              <option value="2006">2006</option>
              <option value="2005">2005</option>
              <option value="2004">2004</option>
              <option value="2003">2003</option>
              <option value="2002">2002</option>
              <option value="2001">2001</option>
              <option value="2000">2000</option>
              <option value="1999">1999</option>
              <option value="1998">1998</option>
              <option value="1997">1997</option>
              <option value="1996">1996</option>
              <option value="1995">1995</option>
              <option value="1994">1994</option>
              <option value="1993">1993</option>
              <option value="1992">1992</option>
              <option value="1991">1991</option>
              <option value="1990">1990</option>
              <option value="1989">1989</option>
              <option value="1988">1988</option>
              <option value="1987">1987</option>
              <option value="1986">1986</option>
              <option value="1985">1985</option>
              <option value="1984">1984</option>
              <option value="1983">1983</option>
              <option value="1982">1982</option>
              <option value="1981">1981</option>
              <option value="1980">1980</option>
              <option value="1979">1979</option>
              <option value="1978">1978</option>
              <option value="1977">1977</option>
              <option value="1976">1976</option>
              <option value="1975">1975</option>
              <option value="1974">1974</option>
              <option value="1973">1973</option>
              <option value="1972">1972</option>
              <option value="1971">1971</option>
              <option value="1970">1970</option>
              <option value="1969">1969</option>
              <option value="1968">1968</option>
              <option value="1967">1967</option>
              <option value="1966">1966</option>
              <option value="1965">1965</option>
              <option value="1964">1964</option>
              <option value="1963">1963</option>
              <option value="1962">1962</option>
              <option value="1961">1961</option>
              <option value="1960">1960</option>
              <option value="1959">1959</option>
              <option value="1958">1958</option>
              <option value="1957">1957</option>
              <option value="1956">1956</option>
              <option value="1955">1955</option>
              <option value="1954">1954</option>
              <option value="1953">1953</option>
              <option value="1952">1952</option>
              <option value="1951">1951</option>
              <option value="1950">1950</option>
              <option value="1949">1949</option>
              <option value="1948">1948</option>
              <option value="1947">1947</option>
              <option value="1946">1946</option>
            </select>年&nbsp;
            <select v-model="userInfo.birthday.split('-')[1]" name="month" class="bir-select">
              <option value="">--</option>
              <option value="01">1</option>
              <option value="02">2</option>
              <option value="03">3</option>
              <option value="04">4</option>
              <option value="05">5</option>
              <option value="06">6</option>
              <option value="07">7</option>
              <option value="08">8</option>
              <option value="09">9</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
            </select>月&nbsp;
            <select v-model="userInfo.birthday.split('-')[2]" name="date" class="bir-select">
              <option value="">--</option>
              <option value="01">1</option>
              <option value="02">2</option>
              <option value="03">3</option>
              <option value="04">4</option>
              <option value="05">5</option>
              <option value="06">6</option>
              <option value="07">7</option>
              <option value="08">8</option>
              <option value="09">9</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
              <option value="13">13</option>
              <option value="14">14</option>
              <option value="15">15</option>
              <option value="16">16</option>
              <option value="17">17</option>
              <option value="18">18</option>
              <option value="19">19</option>
              <option value="20">20</option>
              <option value="21">21</option>
              <option value="22">22</option>
              <option value="23">23</option>
              <option value="24">24</option>
              <option value="25">25</option>
              <option value="26">26</option>
              <option value="27">27</option>
              <option value="28">28</option>
              <option value="29">29</option>
              <option value="30">30</option>
              <option value="31">31</option>
            </select>日
          </div>
        </div>
        <div class="item">
          <div class="tag">生活状态：</div>
          <div class="val">
            <el-radio-group v-model="userInfo.livingState">
              <el-radio label="单身">单身</el-radio>
              <el-radio label="热恋中">热恋中</el-radio>
              <el-radio label="已婚">已婚</el-radio>
              <el-radio label="为人父母">为人父母</el-radio>
            </el-radio-group>
          </div>
        </div>
        <div class="item">
          <div class="tag">从事行业：</div>
          <div class="val" style="display: flex">
            <el-select class="job-select" v-model="industry0" style="width: 100px">
              <el-option
                v-for="item in Object.keys(occupation)"
                :key="item"
                :value="item"
                :label="item"
              />
            </el-select>&nbsp;&nbsp;&nbsp;
            <el-select class="job-select" v-model="industry1" style="width: 100px">
              <el-option
                v-for="item in occupation[industry0]"
                :key="item"
                :value="item"
                :label="item"
              />
            </el-select>
          </div>
        </div>
        <div class="item interest">
          <div class="tag">兴趣：</div>
          <div class="val">
            <el-checkbox-group v-model="interest" style="width: 400px">
              <el-checkbox v-for="item in interestList" :key="item" :label="item">{{ item }}</el-checkbox>
            </el-checkbox-group>
            <span>选择你的兴趣使你获得个性化的电影推荐哦</span>
          </div>
        </div>
        <div class="item">
          <div class="tag">个性签名：</div>
          <div class="val"><input class="in" type="text" name="signature" placeholder="20个字以内"
                                  v-model="userInfo.signature"></div>
        </div>
        <div class="submit" @click="submit">保存</div>
      </form>
    </div>
  </div>
</template>

<script setup>

import { inject, onMounted, ref } from 'vue'
import { useRouter } from 'vue-router'
import { useUserStore } from '@/stores/userStore.js'
import { ElMessage } from 'element-plus'
import { getUserById, updateUser } from '@/api/user.js'

const router = useRouter()
const refresh = inject('refresh')
const userStore = useUserStore()
const occupation = {
  '信息技术': ['互联网', 'IT', '通信', '电子', '游戏'],
  '金融保险': ['投资', '股票基金', '保险', '银行', '信托担保'],
  '商业服务': ['资讯', '贸易', '美容保健', '家政服务', '旅游', '餐饮酒店', '娱乐休闲', '批发零售', '汽车'],
  '建筑地产': ['房地产', '建筑', '物业', '装修'],
  '工程制造': ['机械制造', '生物医药', '食品', '服装', '能源', '化工'],
  '交通运输': ['航空', '铁路', '航运船舶', '公共交通', '物流运输'],
  '文化传媒': ['媒体出版', '设计', '广告创意', '动漫', '公关会展', '摄影'],
  '娱乐体育': ['影视', '运动体育', '音乐', '模特'],
  '公共事业': ['医疗', '教育', '政府机关', '科研', '公益机构', '农林牧渔'],
  '学生': ['学生'],
  '其他': ['其他']
}
const interestList = [
  '美食', '动漫', '摄影', '电影', '体育', '财经', '音乐', '游戏', '科技', '旅游', '文学', '公益', '汽车', '时尚', '宠物'
]
const userInfo = ref({})
const industry0 = ref('')
const industry1 = ref('')
const interest = ref([])
const dataLoaded = ref(false)

const submit = async () => {
  const data = {
    ...userInfo.value,
    industry: industry0.value + '-' + industry1.value,
    interest: JSON.stringify(interest.value)
  }
  const res = await updateUser(data)
  if (res.code === 200) {
    ElMessage.success('修改成功')
    userStore.user = data
    refresh()
  } else {
    ElMessage.error(res.msg)
  }
}

onMounted(async () => {
  if (Object.keys(userStore.user).length === 0) {
    ElMessage.warning('请先登录')
    setTimeout(() => {
      router.push('/login')
    }, 1000)
    return
  }
  const res = await getUserById(userStore.user.id)
  if (res.code !== 200) {
    ElMessage.error(res.msg)
    return
  }
  userInfo.value = res.data
  if (userInfo.value.industry !== '') {
    const industry = userInfo.value.industry.split('-')
    industry0.value = industry[0]
    industry1.value = industry[1]
  }
  interest.value = JSON.parse(userInfo.value.interest)
  dataLoaded.value = true
})

</script>

<style scoped>
.container .right {
  flex-grow: 1;
  padding-left: 40px;
}

.container .right .title {
  padding: 26px 0;
  color: #ec443f;
  font-size: 18px;
  border-bottom: 1px solid #e1e1e1;
  margin-bottom: 30px;
}

.container .right .content {
  display: flex;
}

.container .right .content .avatar {
  width: 270px;
  height: 408px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container .right .content .avatar img {
  width: 258px;
  height: 258px;
}

.container .right .content .avatar .edit {
  position: relative;
  width: 182px;
  height: 56px;
  line-height: 56px;
  text-align: center;
  color: #5b5b5b;
  background-color: #e6e6e6;
  border-radius: 10px;
  margin-top: 20px;
}

.container .right .content .avatar input {
  position: absolute;
  top: 0;
  left: 0;
  opacity: 0;
  width: 182px;
  height: 56px;
}

.container .right .content .avatar .tips {
  margin-top: 10px;
  color: #999;
  font-size: 18px;
  line-height: 30px;
  text-align: center;
}

.container .right .content .info {
  width: 495px;
  height: 490px;
  margin-left: 58px;
}

.container .right .content .info .item {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
  height: 30px;
}

.container .right .content .info .item .tag {
  flex-shrink: 0;
  width: 80px;
  text-align: right;
  font-size: 16px;
  color: #333;
}

.container .right .content .info .item .val {
  color: #666;
  font-size: 14px;
}

.container .right .content .info .item .in {
  width: 240px;
  font-size: 12px;
  height: 30px;
  padding-left: 10px;
}

.container .right .content .info .item select {
  font-size: 12px;
  height: 30px;
  padding-left: 10px;
}

.container .right .content .info .item.interest {
  height: 120px;
  align-items: flex-start;
}

.container .right .content .info .item.interest .tag {
  margin-top: 6px;
}

.container .right .content .info .item.interest .val {
  width: 300px;
  height: 120px;
}

.container .right .content .info .item.interest .val div {
  display: inline-block;
  line-height: 30px;
}

.container .right .content .info .item.interest .val span {
  color: #ccc;
}

.container .right .content .info .submit {
  margin: 20px 0 0 80px;
  cursor: pointer;
  border-radius: 5px;
  width: 100px;
  height: 40px;
  color: #fff;
  font-size: 18px;
  line-height: 40px;
  text-align: center;
  border: none;
  background-color: #ed3931;
  padding: 0;
}
</style>
