<template>
  <view class="template-login">
    顶部自定义导航
    <tn-nav-bar fixed alpha customBack>
      <view slot="back" class='tn-custom-nav-bar__back'
        @click="goBack">
        <text class='icon tn-icon-left'></text>
        <text class='icon tn-icon-home-capsule-fill'></text>
      </view>
    </tn-nav-bar>
    <view class="login">
      <!-- 顶部背景图片-->
      <view class="login__bg login__bg--top">
        <image class="bg" src="https://resource.tuniaokj.com/images/login/1/login_top2.jpg" mode="widthFix"></image>
      </view>
      <view class="login__bg login__bg--top">
        <image class="rocket rocket-sussuspension" src="https://resource.tuniaokj.com/images/login/1/login_top3.png" mode="widthFix"></image>
      </view>
      
      <view class="login__wrapper">
        <!-- 登录/注册切换 -->
        <view class="login__mode tn-flex tn-flex-direction-row tn-flex-nowrap tn-flex-col-center tn-flex-row-center">
          <view class="login__mode__item tn-flex-1 " :class="[{'login__mode__item--active': currentModeIndex === 0}]" @tap.stop="modeSwitch(0)">
            进度
          </view>
          <view class="login__mode__item tn-flex-1" :class="[{'login__mode__item--active': currentModeIndex === 1}]" @tap.stop="modeSwitch(1)">
            认证
          </view>
          
          <!-- 滑块-->
          <view class="login__mode__slider tn-cool-bg-color-15--reverse" :style="[modeSliderStyle]"></view>
        </view>
        
        <!-- 输入框内容-->
        <view class="login__info tn-flex tn-flex-direction-column tn-flex-col-center tn-flex-row-center">
          <!-- 登录 -->
          <block v-if="currentModeIndex === 0">
            <view class="login__info__item__input tn-flex tn-flex-direction-row tn-flex-nowrap tn-flex-col-center tn-flex-row-left">
              <view class="login__info__item__input__left-icon">
                <view class="tn-icon-phone"></view>
              </view>
              <view class="login__info__item__input__content">
                <input maxlength="20" placeholder-class="input-placeholder" placeholder="请输入登录手机号码" />
              </view>
            </view>
            
            <view class="login__info__item__input tn-flex tn-flex-direction-row tn-flex-nowrap tn-flex-col-center tn-flex-row-left">
              <view class="login__info__item__input__left-icon">
                <view class="tn-icon-lock"></view>
              </view>
              <view class="login__info__item__input__content">
                <input :password="!showPassword" placeholder-class="input-placeholder" placeholder="请输入登录密码" />
              </view>
              <view class="login__info__item__input__right-icon" @click="showPassword = !showPassword">
                <view :class="[showPassword ? 'tn-icon-eye' : 'tn-icon-eye-hide']"></view>
              </view>
            </view>
          </block>
          <!-- 注册 -->
          <block v-if="currentModeIndex === 1">
          
            
			<view class="login__info__item__input tn-flex tn-flex-direction-row tn-flex-nowrap tn-flex-col-center tn-flex-row-left">
			  <view class="login__info__item__input__left-icon">
			    <view class="tn-icon-company"></view>
			  </view>
			  <view class="login__info__item__input__content ">
			    <input placeholder-class="input-placeholder" placeholder="请输入企业名称" />
			  </view>
			</view>
			
			<view class="login__info__item__input tn-flex tn-flex-direction-row tn-flex-nowrap tn-flex-col-center tn-flex-row-left">
			  <view class="login__info__item__input__left-icon">
			    <view class="tn-icon-totop"></view>
			  </view>
			  <view class="login__info__item__input__content login__info__item__input__content--verify-code">
			   <tn-input 
			   placeholder-class="input-placeholder" 
			   type="select" 
			   placeholder="选择企业代码类型" 
			   :selectOpen="selectShow" 
			   @click="selectShow = true"   
		       v-model="selectedValue"
			   :options="selectList"></tn-input>
			  </view>
			</view>
			
            <view class="login__info__item__input tn-flex tn-flex-direction-row tn-flex-nowrap tn-flex-col-center tn-flex-row-left">
              <view class="login__info__item__input__left-icon">
                <view class="tn-icon-code"></view>
              </view>
			  <view class="login__info__item__input__content login__info__item__input__content--verify-code">
                <input placeholder-class="input-placeholder" placeholder="请输入企业代码" />
              </view>
            </view>
			
			<view class="login__info__item__input tn-flex tn-flex-direction-row tn-flex-nowrap tn-flex-col-center tn-flex-row-left">
			  <view class="login__info__item__input__left-icon">
			    <view class="tn-icon-identity"></view>
			  </view>
			  <view class="login__info__item__input__content login__info__item__input__content--verify-code">
			    <input placeholder-class="input-placeholder" placeholder="请输入法人姓名" />
			  </view>
			</view>
			
            
            <view class="login__info__item__input tn-flex tn-flex-direction-row tn-flex-nowrap tn-flex-col-center tn-flex-row-left">
              <view class="login__info__item__input__left-icon">
                <view class="tn-icon-wechat"></view>
              </view>
              <view class="login__info__item__input__content login__info__item__input__content--verify-code">
                <input :password="!showPassword" placeholder-class="input-placeholder" placeholder="请输入法人微信号非手机号" />
              </view>
              <!-- <view class="login__info__item__input__right-icon" @click="showPassword = !showPassword">
                <view :class="[showPassword ? 'tn-icon-eye' : 'tn-icon-eye-hide']"></view>
              </view> -->
            </view>
			
			<view class="login__info__item__input tn-flex tn-flex-direction-row tn-flex-nowrap tn-flex-col-center tn-flex-row-left">
			  <view class="login__info__item__input__left-icon">
			    <view class="tn-icon-phone"></view>
			  </view>
			  <view class="login__info__item__input__content login__info__item__input__content--verify-code">
			    <input maxlength="20" placeholder-class="input-placeholder" placeholder="请输入法人手机号码" />
			  </view>
			</view>
			
          </block>
          
		  <!-- 底部按钮 -->
          <button @click="submitData" class="login__info__item__button tn-cool-bg-color-7--reverse" hover-class="tn-hover" :hover-stay-time="150">{{ currentModeIndex === 0 ? '登录' : '立即认证'}}</button> 
          <view v-if="currentModeIndex === 0" class="login__info__item__tips">忘记密码?</view>
        </view>
        
        <!-- 其他登录方式 -->
        <view class="login__way tn-flex tn-flex-col-center tn-flex-row-center">
          <view class="tn-padding-sm tn-margin-xs">
            <view class="login__way__item--icon tn-flex tn-flex-row-center tn-flex-col-center tn-shadow-blur tn-bg-green tn-color-white">
              <view class="tn-icon-wechat-fill"></view>
            </view>
          </view>
          <view class="tn-padding-sm tn-margin-xs">
            <view class="login__way__item--icon tn-flex tn-flex-row-center tn-flex-col-center tn-shadow-blur tn-bg-red tn-color-white">
              <view class="tn-icon-sina"></view>
            </view>
          </view>
          <view class="tn-padding-sm tn-margin-xs">
            <view class="login__way__item--icon tn-flex tn-flex-row-center tn-flex-col-center tn-shadow-blur tn-bg-blue tn-color-white">
              <view class="tn-icon-qq"></view>
            </view>
          </view>
        </view>
      </view>
      
      
      <!-- 底部背景图片-->
      <view class="login__bg login__bg--bottom">
        <image src="https://resource.tuniaokj.com/images/login/1/login_bottom_bg.jpg" mode="widthFix"></image>
      </view>
    </view>
    
    <!-- 验证码倒计时 -->
    <tn-verification-code
      ref="code"
      uniqueKey="login-demo-1"
      :seconds="60"
      @change="codeChange">
    </tn-verification-code>
	
	<!-- 业务类型select -->
	<tn-select
	  v-model="selectShow"
	  mode="single"
	  :list="selectList"
	  @confirm="businessSelectConfirm"
	></tn-select>
	
  </view>

</template>

<script>
  import template_page_mixin from '@/libs/mixin/template_page_mixin.js'
  // 如果在Node.js中使用，需要引入axios
  export default {
    name: 'login-demo-1',
    mixins: [template_page_mixin],
    data() {
      return {
		  selectedValue:null,
		  selectShow: false,
		  selectList: [
		    {
		      label: '统一社会信用代码(18位)',
		      value: 1101
		    },
		    {
		      label: '组织机构代码(9位xxxxxx-x)',
		      value: 1102
		    },
		    {
		      label: '营业执照注册号(15位)',
		      value: 1103
		    }
		  ],
        // 当前选中的模式
        currentModeIndex: 0,
        // 模式选中滑块,
        modeSliderStyle: {
          left: 0
        },
        // 是否显示密码
        showPassword: false,
        // 倒计时提示文字
        tips: '获取验证码'
      }
    },
    watch: {
      currentModeIndex(value) {
        const sliderWidth = uni.upx2px(476 / 2)
        this.modeSliderStyle.left = `${sliderWidth * value}px`
      }
    },
    methods: {
      // 切换模式
      modeSwitch(index) {
        this.currentModeIndex = index
        this.showPassword = false
      },
      // 获取验证码
      getCode() {
        if (this.$refs.code.canGetCode) {
          this.$tn.message.loading('正在获取验证码')
          setTimeout(() => {
            this.$tn.message.closeLoading()
            this.$tn.message.toast('验证码已经发送')
            // 通知组件开始计时
            this.$refs.code.start()
          }, 2000)
        } else {
          this.$tn.message.toast(this.$refs.code.secNum + '秒后再重试')
        }
      },
      // 获取验证码倒计时被修改
      codeChange(event) {
        this.tips = event
      },
	  businessSelectConfirm(event) {
	   
	       this.selectedValue = event[0]['label']
	       
	        this.selectShow = false;
	  },
	  // 按钮_提交数据
	  submitData() {
		   console.log('后端响应数据:');
	        // 定义要发送的数据
	        const data = {
	          component_appid: "appid_value",
	          component_appsecret: "appsecret_value",
	          component_verify_ticket: "ticket_value"
	        };
	        
	        // 发送POST请求
	        axios.post('https://your-backend-api.com/your-endpoint', data)
	          .then(response => {
	            // 请求成功，返回值存储在response.data中
	            console.log('后端响应数据:', response.data);
	        
	            // 判断请求是否成功
	            if (response.data === 'success') {
	              console.log('请求成功');
	            } else {
	              console.log('请求失败');
	            }
	          })
	          .catch(error => {
	            // 请求失败
	            console.error('请求失败:', error);
	          });

	      },
		  // 
		  
		  
	      forgotPassword() {
	        // 构建要发送到后端的数据
	        const data = {
	          action: '忘记密码',
	          // 添加其他数据字段
	        };
	  
	        axios.post('https://your-backend-api.com/submit', data)
	          .then(response => {
	            console.log('后端响应数据:', response.data);
	          })
	          .catch(error => {
	            console.error('发生错误:', error);
	          });
	      }
    }
  }
</script>

<style lang="scss" scoped>
  @import '@/static/css/templatePage/custom_nav_bar.scss';
  /* 悬浮 */
  .rocket-sussuspension{
    animation: suspension 3s ease-in-out infinite;
  }
  
  @keyframes suspension {
    0%, 100% {
      transform: translate(0 , 0);
    }
    50% {
      transform: translate(-0.8rem , 1rem);
    }
  }
  
  .login { 
    position: relative;
    height: 100%;
    z-index: 1;
    
    /* 背景图片 start */
    &__bg {
      z-index: -1;
      position: fixed;
      
      &--top {
        top: 0;
        left: 0;
        right: 0;
        width: 100%;
        
        .bg {
          width: 750rpx;
          will-change: transform;
        }
        .rocket {
          margin: 50rpx 28%;
          width: 400rpx;
          will-change: transform;
        }
      }
      
      &--bottom {
        bottom: -10rpx;
        left: 0;
        right: 0;
        width: 100%;
        // height: 144px;
        margin-bottom: env(safe-area-inset-bottom);
        
        image {
          width: 750rpx;
          will-change: transform;
        }
      }
    }
    /* 背景图片 end */
    
    /* 内容 start */
    &__wrapper {
      margin-top: 403rpx;
      width: 100%;
    }
    
    /* 切换 start */
    &__mode {
      position: relative;
      margin: 0 auto;
      width: 476rpx;
      height: 77rpx;
      background-color: #FFFFFF;
      box-shadow: 0rpx 10rpx 50rpx 0rpx rgba(0, 3, 72, 0.1);
      border-radius: 39rpx;
      
      &__item {
        height: 77rpx;
        width: 100%;
        line-height: 77rpx;
        text-align: center;
        font-size: 31rpx;
        color: #908f8f;
        letter-spacing: 1em;
        text-indent: 1em;
        z-index: 2;
        transition: all 0.4s;
        
        &--active {
          font-weight: bold;
          color: #FFFFFF;
        }
      }
      
      &__slider {
        position: absolute;
        height: inherit;
        width: calc(476rpx / 2);
        border-radius: inherit;
        box-shadow: 0rpx 18rpx 72rpx 18rpx rgba(0, 195, 255, 0.1);
        z-index: 1;
        transition: all 0.3s cubic-bezier(0.68, -0.55, 0.265, 1.55);
      }
    }
    /* 切换 end */
    
    /* 登录注册信息 start */
    &__info {
      margin: 0 30rpx;
      margin-top: 105rpx;
      padding: 30rpx 51rpx;
      padding-bottom: 0;
      border-radius: 20rpx;
      background-color: #ffff;
      box-shadow: 0rpx 10rpx 50rpx 0rpx rgba(0, 3, 72, 0.1);
      
      &__item {
        
        &__input {
          margin-top: 59rpx;
          width: 100%;
          height: 77rpx;
          border: 1rpx solid #E6E6E6;
          border-radius: 39rpx;
          
          &__left-icon {
            width: 10%;
            font-size: 44rpx;
            margin-left: 20rpx;
            color: #AAAAAA;
          }
          
          &__content {
            width: 100%;
            padding-left: 10rpx;
            
            &--verify-code {
              width: 80%;
            }
            
            input {
              font-size: 24rpx;
              // letter-spacing: 0.1em;
            }
          }
          
          &__right-icon {
            width: 10%;
            font-size: 44rpx;
            margin-right: 20rpx;
            color: #AAAAAA;
          }
          
          &__right-verify-code {
            width: 34%;
            margin-right: 20rpx;
          }
        }
        
        &__button {
          margin-top: 75rpx;
          margin-bottom: 39rpx;
          width: 100%;
          height: 77rpx;
          text-align: center;
          font-size: 31rpx;
          font-weight: bold;
          line-height: 77rpx;
          letter-spacing: 1em;
          text-indent: 1em;
          border-radius: 39rpx;
          box-shadow: 1rpx 10rpx 24rpx 0rpx rgba(60, 129, 254, 0.35);
        }
        
        &__tips {
          margin: 30rpx 0;
          color: #AAAAAA;
        }
      }
    }
    /* 登录注册信息 end */
    
    /* 登录方式切换 start */
    &__way {
      margin: 0 auto;
      margin-top: 110rpx;
      
      &__item {
        &--icon {
          width: 77rpx;
          height: 77rpx;
          font-size: 50rpx;
          border-radius: 100rpx;
          margin-bottom: 18rpx;
          position: relative;
          z-index: 1;
          
          &::after {
            content: " ";
            position: absolute;
            z-index: -1;
            width: 100%;
            height: 100%;
            left: 0;
            bottom: 0;
            border-radius: inherit;
            opacity: 1;
            transform: scale(1, 1);
            background-size: 100% 100%;
            background-image: url(https://resource.tuniaokj.com/images/cool_bg_image/icon_bg5.png);
          }
        }
      }
    }
    /* 登录方式切换 end */
    /* 内容 end */
    
  }
  
  /deep/.input-placeholder {
    font-size: 24rpx;
    color: #808080;
  }
  
</style>
