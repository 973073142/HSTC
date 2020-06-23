// pages/My/landing/landing.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    defaultImg: 'https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1567845974&di=f97a72379fa0f286b109ad0a44d1206b&src=http://s16.sinaimg.cn/mw690/70b5496btdc97f32f0d1f&690',
    account: '',
    name: '',
    icon: '',
    psw: '',
    btnText1: '微信登陆',
    btnText2: '管理员登录',

    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    hasMask: false,
    userInfo: {},



  },
  //hasUser 放到app.js文件中去

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    this.setData({
      box1: true,
      box2: false,
      icon: this.data.defaultImg,
      btnText: !this.data.box1 ? this.data.btnText1 : this.data.btnText2,
      isShowNameV: this.data.box1 ? 'none' : 'flex',
      showInput: app.user.uid > 0 ? false : true
    });
    console.log("showInput用户判断输入框要不要显示出来，用app.user.uid来判断" + app.user.uid!=null);
    if (app.hasUser == 1) { //1 ： 是微信登陆状态
      console.log("showInput用户判断输入框要不要显示出来，用app.user.uid来判断" + app.user.uid !=null);
      app.hasUser = 1;
      // wx.setStorageSync('hasUser', 1);
      console.log('hasUser: app.hasUser:' + app.hasUser);
      console.log("app.user的值为：：" + app.user);
      this.setData({
        hasUser: app.hasUser
      })
    } else  {
      // app.hasUser = 0;
      // wx.setStorageSync('hasUser', 0);


      this.setData({
        hasUser: app.hasUser
      })
    }

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },
  // 账户名
  accountInput: function(e) {
    console.log(e);
    this.data.account = e.detail.value;
    if (this.data.account.length >= 10) {
      wx.showToast({
        title: '长度不能超过10',
        icon: 'none',
        duration: 2000,
        mask: true
      })
    }
  },
  nameInput: function(e) {
    console.log(e);
    this.data.name = e.detail.value;
    if (this.data.name.length >= 10) {
      wx.showToast({
        title: '名称长度不大于10',
        icon: 'none',
        duration: 2000,
        mask: true
      })
    }
  },




  // changeOneImage: function(e) {
  //   console.log(e);
  //   var _this = this;
  //   /** data-iconSrc='{{icon}}'   虽然传过来的参数是iconSrc，在jS文件中全都小写*/
  //   var iconSrc = e.target.dataset.iconsrc;
  //   console.log(e.target.dataset.iconsrc);

  //   wx.chooseImage({
  //     count: 1,
  //     sizeType: ['original', 'compressed'],
  //     sourceType: ['album', 'camera'],
  //     success: function(res) {


  //       _this.setData({
  //         icon: res.tempFilePaths[0]
  //       });
  //     }
  //   });
  // },
  pswInput: function(e) {
    console.log(e);
    console.log(e.detail.value);
    this.data.psw = e.detail.value;
    if (this.data.psw.length >= 10) {
      wx.showToast({
        title: '密码长度不大于10',
        icon: 'none',
        duration: 2000,
        mask: true
      })
    }
  },

  radioChange: function(e) {
    console.log(e);
    this.setData({
      box1: !this.data.box1,
      box2: !this.data.box2,
      btnText: !this.data.box1 ? this.data.btnText1 : this.data.btnText2
    })
    console.log(this.data.box1);
  },

  /**
   * 确认按钮，中间包含着很多判断
   * 管理员登录
   */
  confirm: function(e) {
    var _this = this;
    if (_this.data.box2 == true) {
      /** box2 是管理员登录 */
      if (this.data.account.length == 0) {
        wx.showToast({
          title: '账号不能为空',
          icon: 'none',
          duration: 2000,
          mask: true
        });
      } else if (this.data.psw.length == 0) {
        wx.showToast({
          title: '密码不能为空',
          icon: 'none',
          duration: 2000,
          mask: true
        });
      } else {
        wx.request({
          url: "http://localhost:8081/" + this.data.account + "/" + this.data.psw + "/restUser",
          method: 'GET',
          header: {
            'content-type': 'application/json' //原来是content-type 可以改成Content-Type
          },
          success: function(res) {

            console.log("管理员登陆===登录员登陆===");
            console.log(res);
            console.log("管理员登陆===登录员登陆===res.data||res.data")
            console.log(res.data);
            /**res.data==''才能判读是否返回的数据为空 
             * 后台代码使用的是 "如果为空则返回 null" 此处为''  
             */
            if (res.data == '') {
              console.log("res.data为空");
            } else {
              app.user = res.data;
              console.log('app.user的值为');
              console.log(app.user);
              app.hasUser = 2; //2 是管理员登陆
              wx.setStorageSync('hasUser', app.hasUser);
              wx.setStorageSync('adminAccount', app.user.uaccount);
              _this.setData({
                box1: !_this.data.box1,
                user: res.data,
                hasUser: app.hasUser
              });
            }
          },
          fail: function(res) {
            console.log(res);
          }
        })
      }

    } //confirm 是微信用户登陆
  },

  getUserInfo: function(e) {
    console.log(e);
    console.log(e)
    var _this = this;
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              console.log("此处的res.userInfo：：：" + res.userInfo);
              console.log(res);
              app.user.uname = res.userInfo.nickName;
              //微信用户登陆是是没有密码的
              app.user.uicon = res.userInfo.avatarUrl;
              // app.globalData.userInfo = e.detail.userInfo
              // console.log("1111111111111"+app.user.uname);
              console.log(" app.user.uaccount  有可能是上一个管理员登陆再退出后 残留下来的")
              console.log("用户：++++uaccount" + app.user.uaccount);
              app.user.uaccount=app.UserOpenId;
              console.log("将app.UserOpenId 赋值给用户：++++ uaccount 之后的值为" + app.user.uaccount);
              console.log("用户：++++uname" + app.user.uname);
              console.log("用户uicon的uicon：++++" + app.user.uicon);
              console.log("用户uicon的长度：++++" + app.user.uicon.length);
              // app.user.uicon

              wx.request({
                url: "http://localhost:8081/account/" + app.UserOpenId + "/restUser",
                method: 'GET',
                success: function(res) {
                  console.log("是否有此账号" + res.data);
                  if (!res.data) {
                    /**如果没有这一条数据，就添加进去 */
                    wx.request({
                      url: "http://localhost:8081/restUser",
                      data: JSON.stringify({
                        uaccount: app.UserOpenId,
                        upsw: app.user.upsw,
                        uname: app.user.uname,
                        uicon: app.user.uicon.toString()
                      }),
                      header: {
                        'content-type': 'application/json' // 默认值
                      },
                      method: 'POST',
                      success: function(res) {
                        console.log(res.data);

                      }
                    })
                  } else {
                    
                    /**获取用户id   */

                    wx.request({
                      url: 'http://localhost:8081/getUid/' + app.user.uaccount + '/restUser',
                      success: function(res) {
                        console.log("landing.js中尝试获取id：" + res.data);
                        app.user.uid = res.data;
                        console.log("在landing.js中，登陆之后的后app.user:")
                        console.log(app.user);


                      }
                    })


                  }
                }
              })

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况

              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res);
                comsole.log("userInfoReadyCallback:userInfoReadyCallback:" + this.userInfoReadyCallback(res));
              }

            }
          })
        }
      }
    })

setTimeout(function(){
  if (app.UserOpenId != null && app.UserOpenId!=''){
    app.hasUser = 1;
    wx.setStorageSync('hasUser', app.hasUser);
    _this.setData({
      hasUser: app.hasUser
    });

    if (app.hasUser == 1 && _this.data.canIUse) {

      wx.showToast({
        title: '授权成功',
      });
    }
  }else{
    wx.showToast({
      title: '授权失败',
      icon:"none"
    });
  }
  
},1000);
    


  },
  exitLangding: function(e) {
    app.user.uid = null;
    // app.user.uaccount = null;
    app.user.uname = null;
    app.user.uicon = null;
    app.hasUser = 0;
    wx.setStorageSync('hasUser', app.hasUser);
    wx.setStorageSync('adminAccount', 0)
    // this.setData({
    //   user: app.user,
    //   hasUser: false
    // })
    this.setData({
      showInput: app.user.uid > 0 ? false : true,
      hasUser: app.hasUser
    });
    console.log("退出后的user：" + app.user);
    console.log("退出后的user：" + app.user.uname);
    wx.showToast({
      title: '成功退出',
    })
  },
  reBackPage: function(e) {
    /**  delta:1   返回到上一个界面
     *  delta:1   返回到上两个个界面
     */

    wx.navigateBack({
      delta: 1
    })

  }




})