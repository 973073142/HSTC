// pages/My/userInfo/userInfo.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    user: {},
    defaultIcon: 'https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1567900679&di=b467d9d22622a4262f51f5d1fe602b06&src=http://upload.mairuan.cn/Uploads/./Thumb/2017-05-09/ebd319eee7e2d1590f2dfe5f402e7732.jpg',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var CanUse = wx.getStorageSync("CanUse");
    this.setData({
      user:app.user,
      hasUser:app.hasUser,
      defaultIcon: this.data.defaultIcon
    })


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
    this.setData({
      user: app.user,
      hasUser: app.hasUser,
      defaultIcon: this.data.defaultIcon

    })

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

  }
})