// pages/agriNews/newsContentDetail/newsContentDetail.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    defaultImage: ["https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568209837625&di=47b471364a7d96501abd4b5177cde363&imgtype=0&src=http%3A%2F%2Fs3.sinaimg.cn%2Fmw690%2F003vNYwKgy6EaglQtvI52%26690",
      "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568212808472&di=b55be78749015b15c9f2ccd0a25ec7b6&imgtype=0&src=http%3A%2F%2Fimg.wifizs.cn%2Fmaterial%2Fnews%2Fimg%2F2016%2F01%2F20160107151916Hht8.jpg"
    ],
    news: []
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    // var news = options.news;
    wx.showNavigationBarLoading();
    console.log("options携带的数据");
    console.log(options);
    var id = options.id;

    var i = 0;
    for (i = 0; i < app.newsList.length && app.newsList[i].id != id; i++);
    if (i == app.newsList.length) {
      wx.navigateBack({
        delta: 1
      })
    } else {
      this.data.news = app.newsList[i];
    }

    // var kk = news.html;
    // var reg = /<img.+?src=('|")?([^'"]+)('|")?(?:\s+|>)/img;
    // var arr = "";
    // var tem;
    // var arr;

    // while (tem = reg.exec(kk)) {
    //   arr = arr + tem[2] + ";";
    // }
    // console.log("newsContentDetail==onLoad尝试获取图片获取的图片：===");
    // var temImages = arr.split(";");
    // console.log((arr.split(";")).join("\n"));
    // var images = [];
    // console.log("只截取png,或者是jpg结尾的图片")
    // for (var i = 0; i < temImages.length; i++) {
    //   if (temImages[i].substring(temImages[i].length - 3) == "png" || temImages[i].substring(temImages[i].length - 3) == "jpg") {
    //     images = images.concat(temImages[i]);
    //   }
    // }
    // console.log("images的数据值为：===");
    // console.log(images.join("\n"));
    // news.imageUrls = images;
    // console.log("分析取出png和jpg图片的结果为：====news.imageUrls");
    // console.log(news.imageUrls.join("\n"));
    // if (news.imageUrls == null || news.imageUrls == "") {
    //   news.imageUrls = this.data.defaultImage
    // }



    // console.log("options.news赋值给news之后的news数值");
    // console.log(news);
    var imageSwiper = {
      isAutoplay: true,
      imageUrls: this.data.news.imageurls
    }
    //在外面把内容总的空格，全部替换成换行符
    // news.content
    this.data.news.content = this.data.news.content.replace(/\s*/g, "");
    wx.hideNavigationBarLoading();
    this.setData({
      isAutoplay: true,

      news: this.data.news,
      imageSwiper: imageSwiper
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
  switchChangeV: function(e) {
    //var imageSwiper = {
    //   isAutoplay: true,
    //     imageUrls: news.imageUrls
    // }
    //被包含在里面，所以，直接选染一整个
    this.data.imageSwiper.isAutoplay = !this.data.imageSwiper.isAutoplay
    this.setData({
      imageSwiper: this.data.imageSwiper
    });
  },
  previewImg: function(e) {
    console.log(e);
    console.log(e.currentTarget.dataset.index);
    var index = e.currentTarget.dataset.index;
    var imgArr = this.data.news.imageurls;
    wx.previewImage({
      current: imgArr[index], //当前图片地址
      urls: imgArr, //所有要预览的图片的地址集合 数组形式
      success: function(res) {},
      fail: function(res) {},
      complete: function(res) {},
    })

  }
})