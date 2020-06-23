//app.js
App({
  onLaunch: function() {
    // 展示本地存储能力
    // var logs = wx.getStorageSync('logs') || []
    // logs.unshift(Date.now())
    // wx.setStorageSync('logs', logs)

    // if (user){
    //   console.log("user的值为11111" + this.user);
    // }
    // if(!user){
    //   console.log("user的值为222222" + this.user);
    // }
    // this.user={uid:20};
    // console.log(this.user.uid);
    // console.log(this.user.uaccount);
    // this.user = { uaccount: 20 };
    // console.log(this.user.uid);
    // this.CanUse = false;
    // console.log("CanUse的值为："+this.CanUse);
    // console.log("user的值为"+this.user);
    // if(this.user.uid==null){
    //   console.log("user的值为空");
    // }
    // wx.setStorageSync("user", this.user);
    // wx.setStorageSync("CanUse", this.CanUse);
    //进入小程序直接先获取hasUser,若未登录过，则直接获取
    this.hasUser = wx.getStorageSync("hasUser");
    //数据缓存中 只存取 0：无登陆状态 1：微信用户登陆  2： 管理员登陆

    console.log("缓存中hasUser::" + this.hasUser);
    if (this.hasUser == 2) {
      this.hasUser = 0;
      wx.setStorageSync('hasUser', this.hasUser);
      console.log("先前是管理员登陆，现在把管理员退出登陆");
      console.log("此时，hasUser 的值为：===" + this.hasUser);
    }




    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        var code = res.code;
        var _this = this;
        console.log("获取的code：：" + code);
        /**不能直接获取微信id 需要在服务器上进行获取 */
        /*openid是唯一不变的 */
        wx.request({
          url: 'http://localhost:8081/wxid/' + code + '/restUser',
          method: 'GET',
          success: function(res) {
            console.log("app.js中获取到的UserOpenId===res.data===：" + res.data);
            _this.user.uaccount = res.data;
            // var _this = this;
            _this.UserOpenId = res.data;
            console.log("_this.UserOpenId的值为" + _this.UserOpenId)


            console.log(res);
            console.log(res.data);
            console.log(_this.user);
          }
        });

        if (this.user.uaccount == null) {
          console.log("这是一个很神奇的事情,wx.request的返回式在其外括号语句执行完成之后，它才会执行request的success中的语句");
        }

      }
    })


    // 登陆获取openID用作用户uid 
    var _this = this;

    if (this.hasUser == 1) {
      // 获取用户信息
      setTimeout(function() {
        wx.getSetting({
          success: res => {
            if (res.authSetting['scope.userInfo']) {
              // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框

              wx.getUserInfo({
                success: res => {
                  // 可以将 res 发送给后台解码出 unionId
                  //在这一个函数里面，无法调用接口：wx.request
                  _this.globalData.userInfo = res.userInfo;
                  console.log(" wx.getSetting下的 wx.getUserInfo：：：" + res.userInfo);
                  console.log(_this.globalData.userInfo.nickName);
                  _this.user.uname = _this.globalData.userInfo.nickName; //昵称
                  _this.user.uicon = _this.globalData.userInfo.avatarUrl //头像



                  /**如果数据库中存在该用户，则获取该用户的id */
                  wx.request({
                    url: 'http://localhost:8081/getUid/' + _this.user.uaccount + '/restUser',
                    success: function(res) {
                      console.log("尝试获取id：" + res.data);
                      if (res.data > 0) {
                        _this.user.uid = res.data;
                        console.log("获取id后的user：" + _this.user.uid);
                      }
                      // else{
                      //   _this.hasUser=0;
                      // }


                    }
                  })
                  console.log("用户的openID：" + _this.user.uaccount);
                  console.log("用户名称" + _this.user.uname);
                  // console.log("用户头像"+_this.user.avatarUrl);
                  console.log("uicon的类型" + typeof(_this.user.uicon));
                  console.log("hasUser::" + _this.hasUser);
                  // console.log("landed::" + this.landed);
                  console.log(_this.user);
                  // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
                  // 所以此处加入 callback 以防止这种情况
                  if (_this.userInfoReadyCallback) {
                    _this.userInfoReadyCallback(res)
                  }
                }
              })
            }
          }
        })
      }, 500);



      // =======================
    } else if (hasUser == 2) {

    }
  },
  globalData: {
    userInfo: null
  },
  // user:{},
  user: {
    uid: null,
    uaccount: null,
    upsw: null,
    uname: null,
    uicon: null
  },
  hasUser: 0,
  landed: false,
  UserOpenId: 0,
  newsList: []
})