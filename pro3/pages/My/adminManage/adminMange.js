// pages/My/adminManage/adminMange.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

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
    var _this = this;
    wx.request({
      url: 'http://localhost:8081/withUser/restShare',
      method: 'GET',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function(res) {
        console.log(res.data);
        var shareList = res.data;
        var imageList = [];
        for (var i = 0; i < shareList.length; i++) {
          var images = [];
          if (shareList[i].stitle.length > 16) {
            shareList[i].stitle = shareList[i].stitle.substring(0, 10) + '...';
          }
          if (imageList.length < 5 && shareList[i].simg1 != null && shareList[i].simg1 != '') {
            imageList = imageList.concat(shareList[i].simg1);
            // console.log(shareList[i].simg1);
          }
          if (shareList[i].simg1 != null && shareList[i].simg1 != '') {
            images = images.concat(shareList[i].simg1);
            // console.log(shareList[i].simg1+"\n");
          }
          if (shareList[i].simg2 != null && shareList[i].simg2 != '') {
            images = images.concat(shareList[i].simg2);
          }
          if (shareList[i].simg3 != null && shareList[i].simg3 != '') {
            images = images.concat(shareList[i].simg3);
          }
          if (shareList[i].simg4 != null && shareList[i].simg4 != '') {
            images = images.concat(shareList[i].simg4);
          }
          if (shareList[i].simg5 != null && shareList[i].simg5 != '') {
            images = images.concat(shareList[i].simg5);
          }
          if (shareList[i].simg6 != null && shareList[i].simg6 != '') {
            images = images.concat(shareList[i].simg6);
          }
          shareList[i].images = images;
          // console.log(shareList[i]);

        }
        // console.log(shareList);
        

        _this.setData({
          shareList: shareList,
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
  //跳转到详情页面 
  goDetail: function(e) {
    //  console.log(e);
    console.log(e);
    wx.navigateTo({
      url: '../../agriCircle/shareContentDetail/shareContentDetail?sid=' + e.currentTarget.dataset.sid,
    })
  },
  delShare:function(e){
    console.log(e);
    console.log(e.currentTarget.dataset.sid);
    var sid = e.currentTarget.dataset.sid;
    var _this=this;
    wx.showModal({
      title: '删除',
      content: '是否删除',
      success:function(res){
        if(res.confirm==true){
          var i=0;
          var tem=[];
          for (i = 0; i < _this.data.shareList.length;i++){
            if (_this.data.shareList[i].sid!=sid){
              tem = tem.concat(_this.data.shareList[i]);
            }
          }
          _this.data.shareList=tem;
          
          wx.request({
            url: "http://localhost:8081/" + sid +"/restShare",
            method:"DELETE",
            success:function(res){
              if(res.data==true){
                wx.showToast({
                  title: '成功删除',
                })
              }
            }
          })
          _this.setData({
            shareList: _this.data.shareList
          })


        }
      }
    })
  }
})