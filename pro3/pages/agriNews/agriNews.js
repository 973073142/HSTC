// pages/agriNews/agriNews.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    cctvIcon: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568209055248&di=a2b153fd80795bdfc18c34f00808d56e&imgtype=0&src=http%3A%2F%2Fs10.sinaimg.cn%2Fmw690%2F0044i01Nzy72HmcEt0l09%26690",
    httpUrlHead: "http://api01.idataapi.cn:8000/news/cntv?catid=",
    typeUrl: "Nav-GxfrDirK3AR2nnyMC9Ub160812",
    apikey: "bmLUk1y1Og0jPracz7H1jwSyG2XfooyICt23wngoecMrXzeCIm5uwLhDFTrX6hiD",


    tempNewsList: [],

    defaultImage: ["https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568209837625&di=47b471364a7d96501abd4b5177cde363&imgtype=0&src=http%3A%2F%2Fs3.sinaimg.cn%2Fmw690%2F003vNYwKgy6EaglQtvI52%26690",
      "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568212808472&di=b55be78749015b15c9f2ccd0a25ec7b6&imgtype=0&src=http%3A%2F%2Fimg.wifizs.cn%2Fmaterial%2Fnews%2Fimg%2F2016%2F01%2F20160107151916Hht8.jpg"
    ],
    imageUrls: [],


    newsPage: 1
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    console.log("pages/agriNews/agriNews.js加载");
    console.log("pages/agriNews/agriNews.js加载");
    console.log("pages/agriNews/agriNews.js加载");

    console.log("加载新闻信息，一个种类");
    var _this = this;
    wx.request({
      url: 'http://route.showapi.com/109-35',
      method: "GET",
      "dataType": "json",
      data: {
        "showapi_appid": '104956',
        "showapi_sign": "22f326bc14324cbc8ea1d8031218b0c3",
        "channelId": "",
        "channelName": "",
        "title": "种植养殖",
        "needContent": 1,
        "page": _this.data.newsPage,
        "maxResult": "20",
        "id": ""
      },
      success: function(res) {
        console.log(res);
        console.log(res.data);
        // 信息列表   数组
        console.log(res.data.showapi_res_body.pagebean.contentlist);
        var contentlist = res.data.showapi_res_body.pagebean.contentlist;
        //  列表 数组 res.data.showapi_res_body.pagebean.contentlist
        // 频道名称 res.data.showapi_res_body.pagebean.contentlist[0].channelName  
        // 来源  source 
        // 是否有照片 havePic
        // 图片链接 数组类型 imageurls  imageurls[0].url  imageurls[1].url
        // 新闻id  id
        _this.data.tempNewsList = contentlist;
        _this.data.newsPage = res.data.showapi_res_body.pagebean.currentPage;
        _this.changeNewsToList(_this.data.tempNewsList);
        console.log("_this.changeNewsToList之后执行");
        //这是将获取的新闻数据，进行转换
      }

    });
    // wx.showNavigationBarLoading();
    // 央视新闻的民生新闻模块
    // wx.request({
    //   url: this.data.httpUrlHead + this.data.typeUrl + "&apikey=" + this.data.apikey + "&pageToken=" + this.data.pageToken,
    //   method: "GET",
    //   header: {
    //     'content-type': 'application/json' // 默认值
    //   },
    //   success: function(res) {
    //     console.log(res);
    //     console.log(res.data);
    //     _this.data.tempNewsList = res.data.data;
    //     console.log("新闻数据集合tempNewsList：");
    //     console.log(_this.data.tempNewsList);
    //     _this.changeNewsToList(_this.data.tempNewsList);
    //     _this.data.pageToken = res.data.pageToken;
    //     console.log("pageToken经过回调函数返回的值为：== " + _this.data.pageToken);
    //     wx.hideNavigationBarLoading();
    //   }

    // })
    // 央视新闻的民生新闻模块 end

    /**
    http://api01.idataapi.cn:8000/news/cntv?catid=Nav-ZzGRAcda1ZRF2a2M05n9170412&apikey=bmLUk1y1Og0jPracz7H1jwSyG2XfooyICt23wngoecMrXzeCIm5uwLhDFTrX6hiD */

  },
  changeNewsToList: function(tempNewsList) {

    console.log("进入到_this.changeNewsToList当中来");
    for (var i = 0; i < tempNewsList.length; i++) {
      // var kk = tempNewsList[i].html;
      // var reg = /<img.+?src=('|")?([^'"]+)('|")?(?:\s+|>)/img;
      // var arr = "";
      // var tem;
      // var arr;
      // while (tem = reg.exec(kk)) {
      //   arr = arr + tem[2] + ";";
      // }
      // // console.log("agriCircle==onLoad尝试获取图片获取的图片：===");
      // var temImages = arr.split(";");
      // // console.log((arr.split(";")).join("\n"));
      // var images = [];
      // // console.log("只截取png,或者是jpg结尾的图片")
      // for (var i = 0; i < temImages.length; i++) {
      //   if (temImages[i].substring(temImages[i].length - 3) == "png" || temImages[i].substring(temImages[i].length - 3) == "jpg") {
      //     images = images.concat(temImages[i]);
      //   }
      // }
      // // console.log("images的数据值为：===");
      // // console.log(images.join("\n"));
      // tempNewsList[i].imageUrls = images;
      // // console.log("分析取出png和jpg图片的结果为：====tempNewsList[i].imageUrls");
      // // console.log(tempNewsList[i].imageUrls.join("\n"));
      if (tempNewsList[i].imageurls.length == 0) {
        tempNewsList[i].imageurls = this.data.defaultImage
      } else {
        console.log("进入到图片的选取当中来");
        var imageurls = [];
        for (var j = 0; j < tempNewsList[i].imageurls.length; j++) {
          imageurls = imageurls.concat(tempNewsList[i].imageurls[j].url);
        }
        tempNewsList[i].imageurls = imageurls;
      }
      var news = {
        id: tempNewsList[i].id,
        title: tempNewsList[i].title,
        subTitle: tempNewsList[i].title.substring(0, 10) + "...",
        content: tempNewsList[i].content,
        Icon: tempNewsList[i].imageurls[Math.floor(Math.random() * (2 - 0))],
        posterScreenName: tempNewsList[i].source,
        publishDateStr: tempNewsList[i].pubDate.substring(0, 10),
        imageurls: tempNewsList[i].imageurls,
        publish: "农村·农业",
      }
      console.log("连接信息列表："+i);
      app.newsList = app.newsList.concat(news);

    }
    console.log("当前app.newsList的值为：===");
    console.log(app.newsList);
    wx.hideNavigationBarLoading();
    this.setData({
      newsList: app.newsList
    });



  },
  selectImageByHtml: function(newsList) {
    for (var i = 0; i < newsList.length; i++) {
      var kk = newsList[i].html;
      var reg = /<img.+?src=('|")?([^'"]+)('|")?(?:\s+|>)/img;
      var arr = "";
      var tem;
      var arr;
      var count = 0
      while (tem = reg.exec(kk)) {
        arr = arr + tem[2] + ";";
        if (++count == 3) {
          break;
        }
      }
      // console.log("agriCircle==onLoad尝试获取图片获取的图片：===");
      var temImages = arr.split(";");
      // console.log((arr.split(";")).join("\n"));
      var images = [];
      // console.log("只截取png,或者是jpg结尾的图片")
      for (var i = 0; i < temImages.length; i++) {
        if (temImages[i].substring(temImages[i].length - 3) == "png" || temImages[i].substring(temImages[i].length - 3) == "jpg") {
          images = images.concat(newsList[i]);
        }
      }
      // console.log("images的数据值为：===");
      // console.log(images.join("\n"));
      newsList[i].imageUrls = images;
      // console.log("分析取出png和jpg图片的结果为：====tempNewsList[i].imageUrls");
      // console.log(tempNewsList[i].imageUrls.join("\n"));
      if (newsList[i].imageUrls == null) {
        newsList[i].imageUrls = this.data.defaultImage
      }
    }
    this.setData({
      newsList: app.newsList
    });
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
    wx.showNavigationBarLoading();
    var _this = this;
    _this.data.newsPage = _this.data.newsPage+1;
    wx.request({
      url: 'http://route.showapi.com/109-35',
      method: "GET",
      "dataType": "json",
      data: {
        "showapi_appid": '104956',
        "showapi_sign": "22f326bc14324cbc8ea1d8031218b0c3",
        "channelId": "",
        "channelName": "",
        "title": "农业 农村 农民 农作物 乡村 种植",
        "needContent": 1,
        "page": _this.data.newsPage,
        "maxResult": "20",
        "id": ""
      },
      success: function (res) {
        console.log(res);
        console.log(res.data);
        // 信息列表   数组
        console.log(res.data.showapi_res_body.pagebean.contentlist);
        var contentlist = res.data.showapi_res_body.pagebean.contentlist;
        //  列表 数组 res.data.showapi_res_body.pagebean.contentlist
        // 频道名称 res.data.showapi_res_body.pagebean.contentlist[0].channelName  
        // 来源  source 
        // 是否有照片 havePic
        // 图片链接 数组类型 imageurls  imageurls[0].url  imageurls[1].url
        // 新闻id  id
        _this.data.tempNewsList = contentlist;
        _this.data.newsPage = res.data.showapi_res_body.pagebean.currentPage;
        _this.changeNewsToList(_this.data.tempNewsList);
        console.log("_this.changeNewsToList之后执行");
        //这是将获取的新闻数据，进行转换
      }

    });
    // wx.request({
    //   url: this.data.httpUrlHead + this.data.typeUrl + "&apikey=" + this.data.apikey + "&pageToken=" + this.data.pageToken,
    //   method: "GET",
    //   header: {
    //     'content-type': 'application/json' // 默认值
    //   },
    //   success: function(res) {
    //     console.log(res);
    //     console.log(res.data);
    //     // for (var i = 0; i < res.data.data.length - 1; i--) {
    //     //   // _this.data.imageUrls = res.data.data[i].imageUrls;
    //     //   // if (_this.data.imageUrls == null || _this.data.imageUrls == '') {
    //     //   //   _this.data.imageUrls = _this.data.defaultImage
    //     //   // }
    //     //   // var news = {
    //     //   //   title: res.data.data[i].title,
    //     //   //   subTitle: res.data.data[i].title.substring(0, 10) + "...",
    //     //   //   content: res.data.data[i].content,
    //     //   //   cctvIcon: _this.data.cctvIcon,
    //     //   //   posterScreenName: res.data.data[i].posterScreenName,
    //     //   //   publishDateStr: res.data.data[i].publishDateStr.substring(0, 10),
    //     //   //   imageUrls: res.data.data[i].imageUrls,
    //     //   //   publish: "央视·民生·新闻"

    //     //   // }
    //     //   // _this.data.newsList = _this.data.newsList.concat(news);

    //     // }
    //     _this.data.tempNewsList = res.data.data;
    //     console.log("新闻数据集合tempNewsList：");
    //     console.log(_this.data.tempNewsList);
    //     _this.changeNewsToList(_this.data.tempNewsList);
    //     _this.data.pageToken = res.data.pageToken;
    //     console.log("pageToken经过回调函数返回的值为：== " + _this.data.pageToken);

    //   }

    // })


  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },
  goNewsDetail: function(e) {
    console.log(e);

    wx.navigateTo({
      url: 'newsContentDetail/newsContentDetail?id=' + e.currentTarget.dataset.id,
    })
  }
})