// pages/My/myCollectList/myCollectList.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    collectList:[],
    shareList:[]

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var CanUse = wx.getStorageSync("CanUse");
    this.setData({
      hasUser: app.hasUser,
      appUser:app.user,
      shareList:[]
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
    /**判断是否用户登陆 如果没有登陆，那么就直接显示 "未登陆"  */
    this.setData({
      hasUser: app.hasUser
    });
    /**接下来就是获取经验信息列表的时候了
     * 根据uid来查找
     */
    var _this=this;
    wx.request({
      url: "http://localhost:8081/" + "myCollect/" + app.user.uid +"/restCollect",
      method:"GET",
      success:function(res){
        console.log("获得的数据：res.data===");
        console.log(res.data);
        _this.setData({
          shareList:res.data
        })
      }
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

  },
  /**点击一条信息 ，进入到详情页面 跟经验信息详情页面一样 */
  goDetail: function(e) {
    //  console.log(e);
    console.log(e);
    wx.navigateTo({
      url: '../../agriCircle/shareContentDetail/shareContentDetail?sid=' + e.currentTarget.dataset.sid,
    })
  }
})