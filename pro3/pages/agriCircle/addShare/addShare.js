// pages/agriCircle/addShare/addShare.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    defaultImg: '../../images/addPhoto.png',
    tempFilePaths: [],
    imgPaths: [],
    scontent: '',
    stitle: '',
    httpFilePaths: []



  },

  /**
  https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567399717779&di=2ec64998e98b0c46c6253ff765b38467&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F01%2F01%2F78%2F58de76599bc9d_610.jpg


   */
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    this.setData({
      imgAdd: this.data.defaultImg,
      isAddImgShow: true

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

  /** 标题 */
  shareInputTitle: function(e) {
    this.data.stitle = e.detail.value;
    console.log("经验信息的标题是：" + this.data.stitle);
  },
  /**获取内容文本区域的文字 */
  shareInputText: function(e) {
    // console.log(e.detail.value);
    this.data.scontent = e.detail.value;
    console.log("经验信息的内容为" + this.data.scontent)


  },

  /**获得本地图片 */
  getLocalImg: function(e) {
    var _this = this;
    wx.chooseImage({
      count: 6, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function(res) {
        wx.showLoading({
          title: '正在加载图片',
          mask: true
        })
        var oldLen = _this.data.tempFilePaths.length;
        for (var idx = 0, len = _this.data.tempFilePaths.length; len < 6 && idx < res.tempFilePaths.length; len++, idx++) {
          _this.data.tempFilePaths = _this.data.tempFilePaths.concat(res.tempFilePaths[idx]);
        }
        _this.setData({
          isAddImgShow: _this.data.tempFilePaths.length >= 6 ? false : true,
          tempFilePaths: _this.data.tempFilePaths
        })
        wx.hideLoading();
        // var httpFilePaths = [];
        // _this.data.httpFilePaths=[];

        // for (var i = oldLen; i < _this.data.tempFilePaths.length; i++) {
        //   console.log("进入转换函数中：：==");
        //   if (_this.data.tempFilePaths[i] != '' && _this.data.tempFilePaths[i] != null) {
        //     /** 将本地图片转换成  服务器图片 */
        //     wx.uploadFile({
        //       url: "http://localhost:8081/" + "wx_upload.do",
        //       filePath: _this.data.tempFilePaths[i],
        //       name: 'file',
        //       formData: {
        //         'user': 'test'
        //       },
        //       success: function(res) {
        //         var serviceRes = JSON.parse(res.data);
        //         var serverAddress = serviceRes.address;
        //         var httpAddress = "http://localhost:8081" + serverAddress; /**把地址加上 域名 */
        //         // _this.data.tempFilePaths[i] = httpAddress;

        //         ///
        //         _this.data.httpFilePaths = _this.data.httpFilePaths.concat(httpAddress);
        //       },
        //       fail: function(err) {
        //         console.log(err)
        //       }
        //     })
        //   }
        // }
        // _this.data.tempFilePaths本分就是一个数组
        /**注意！！！ setTimeout 这个异步函数 仍然是  设置 在chooseImage的回调函数之中的    */
        // setTimeout(function() {
        //   console.log("getLocalImg之后，经过函数异步之后的图片数据：");
        //   console.log(_this.data.httpFilePaths.join('\n'));
        //   console.log("getLocalImg之后，经过函数异步之后的图片的个数为：" + _this.data.httpFilePaths.length);
        //   wx.hideLoading();
        //   _this.setData({
        //     isAddImgShow: _this.data.tempFilePaths.length >= 6 ? false : true,
        //     tempFilePaths: _this.data.httpFilePaths
        //   })
        // }, 1000);
        /**用的这个最愚蠢的方法 ，来克服这个异步请求 带来的数据 前后不一致问题 */
      }
    });
    // console.log("经过setData之后的图片路径为：" + this.data.Img1); 
    /*很好奇为什么这个语句在 wx.chooseImage执行之后不会被执行，然后   只有再点击一次之后，才会被执行*/
  },
  /**单独修改一张图片 */
  changeOneImage: function(e) {
    var _this = this;
    var imgSrc = e.currentTarget.dataset.src;
    var i = 0;
    wx.showActionSheet({
      itemList: ['重新选择', '删除该图'],
      success(res) {
        switch (res.tapIndex) {
          case 0:
            /**重新选择 */
            wx.chooseImage({
              count: 1,
              sizeType: ['original', 'compressed'],
              sourceType: ['album', 'camera'],
              success: function(res) {
                wx.showLoading({
                  title: '正在加载图片',
                  mask: true
                });
                var newChooseImage = res.tempFilePaths[0];
                for (i = 0; i < _this.data.tempFilePaths.length && _this.data.tempFilePaths[i] != imgSrc; i++); //得到的i是选中的图片的下标值（从0开始）
                _this.data.tempFilePaths[i] = newChooseImage;
                _this.setData({
                  isAddImgShow: _this.data.tempFilePaths.length >= 6 ? false : true,
                  tempFilePaths: _this.data.tempFilePaths
                })
                //隐藏 加载框
                wx.hideLoading();


              }

              //选择 一张图片
            });
            break;
          case 1:
            /** 删除图片 */
            var tem = [];
            for (i = 0; i < _this.data.tempFilePaths.length; i++) {
              if (_this.data.tempFilePaths[i] != imgSrc) {
                tem = tem.concat(_this.data.tempFilePaths[i]);
              }
            }
            console.log("删除图片的的临时缓存tem：");
            console.log(tem.join('\n'));
            _this.data.tempFilePaths = [];
            _this.data.httpFilePaths = [];
            _this.data.tempFilePaths = tem;
            _this.data.httpFilePaths = tem; /**httpFilePaths和tempFilePaths同步更新  */
            console.log("临时tem的值赋给_this.data.tempFilePaths后的值为");
            console.log(_this.data.tempFilePaths.join('\n'));
            _this.setData({
              isAddImgShow: _this.data.tempFilePaths.length >= 6 ? false : true,
              tempFilePaths: _this.data.tempFilePaths
            });
            wx.showToast({
              title: '删除成功',
              icon: 'success',
              duration: 1000,
              mask: true
            })
            break;
        }
      }
    })
  },


  /**
   * 发表 按钮
   * 发表经验信息
   * 
   */
  confirm: function(e) {
    /**7之前都是 管理员的账号，uid */
    if (app.user.uid > 7) {
      var stitle = this.data.stitle;
      var scontent = this.data.scontent;
      var tempFilePaths = this.data.tempFilePaths;
      console.log(this.data.tempFilePaths);
      console.log("图片的个数：" + this.data.tempFilePaths.length);

      var _this = this;

      _this.data.httpFilePaths = []; //先置空//然后再循环将其一个一个得转换成服务器地址
      for (var i = 0; i < _this.data.tempFilePaths.length; i++) {
        console.log("进入转换函数中：：==");
        if (_this.data.tempFilePaths[i] != '' && _this.data.tempFilePaths[i] != null) {
          /** 将本地图片转换成  服务器图片 */
          wx.uploadFile({
            url: "http://localhost:8081/" + "wx_upload.do",
            filePath: _this.data.tempFilePaths[i],
            name: 'file',
            formData: {
              'user': 'test'
            },
            success: function(res) {
              var serviceRes = JSON.parse(res.data);
              var serverAddress = serviceRes.address;
              var httpAddress = "http://localhost:8081" + serverAddress; /**把地址加上 域名 */
              // _this.data.tempFilePaths[i] = httpAddress;

              ///
              _this.data.httpFilePaths = _this.data.httpFilePaths.concat(httpAddress);
            },
            fail: function(err) {
              console.log(err)
            }
          })
        }
      }






      //利用 拖后1.5s的运行，来给图片插入服务器腾出时间
      //都是请求惹的祸
      setTimeout(function() {

        _this.data.tempFilePaths = _this.data.httpFilePaths;

        //填补 到6张图片，没选中的，就置 ''
        if (_this.data.tempFilePaths.length < 6) {
          console.log("进入到图片数组填补中来")
          for (var i = _this.data.tempFilePaths.length; i < 6; i++) {
            _this.data.tempFilePaths = _this.data.tempFilePaths.concat('');
          }
        }

        console.log(_this.data.tempFilePaths);
        console.log(_this.data.tempFilePaths[5].toString());
        console.log("图片的个数：" + _this.data.tempFilePaths.length);
        wx.request({
          url: 'http://localhost:8081/restShare',
          data: JSON.stringify({
            uid: app.user.uid,
            stitle: stitle,
            scontent: scontent.toString(),
            simg1: _this.data.tempFilePaths[0],
            simg2: _this.data.tempFilePaths[1],
            simg3: _this.data.tempFilePaths[2],
            simg4: _this.data.tempFilePaths[3],
            simg5: _this.data.tempFilePaths[4],
            simg6: _this.data.tempFilePaths[5],
            sdate: new Date()
          }),
          header: {
            'content-type': 'application/json' // 默认值
          },
          method: 'POST',
          success: function(res) {
            console.log(res.data);
          },
          success: function(res) {
            console.log("执行插入经验信息数据：===")
            if (res.data == true) {

              wx.navigateBack({
                delta: 1
              });
              wx.showToast({
                title: '发布成功',
                icon: 'success',
                duration: 2000,
                mask: true
              })

            }
          }
        });
      }, 1000);

    } else {
      wx.showToast({
        title: '请复制保存当前信息后检查是否登陆成功，或者刷新页面',
        icon: 'none',
        duration: 1000,
        mask: true
      });
    }



  }
})