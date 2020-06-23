// pages/agriCircle/shareContentDetail/shareContentDetail.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // change:true,
    // isAutoplay: true
    focus: false,
    inputValue: '',
    responseVShow: 'flex',
    inputFocus: false,
    sid: '',
    share: {}, //经验信息
    sayGoodYorN: '',
    collectYorN: '',
    commentList: {}, //评论
    uid: app.user.uid,
    uid2: app.user.uid,
    ccontent: '',
    appUser: app.user,
    commentList: []

  },
  /**应该还有有两数  uid  和  uid2 对于评论时使用
   * uid 是本次登陆用户的uid
   * uid2 是要回复的对方的uid
   */

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    console.log(app.user);
    console.log("最开始的uid2的值为：" + this.data.uid2); //？？？？？？这个地方为什么会是null
    console.log("最开始的uid的值为：" + this.data.uid2); //？？？？？？这个地方为什么也是null
    this.setData({
      uid: app.user.uid,
      uid2: app.user.uid,
    });
    console.log("setData后的uid2的值为：" + this.data.uid2);
    console.log("setData后的uid的值为：" + this.data.uid2);
    console.log(options.sid);
    console.log("进入onload函数");
    this.data.sid = options.sid;
    var _this = this;
    /**获取sid的share数据 */
    wx.request({
      url: "http://localhost:8081/withUser/" + this.data.sid + "/restShare",
      method: 'GET',
      success: function(res) {
        console.log("onload函数===经验信息数据+用户信息");
        console.log(res.data);

        _this.data.share = res.data;
        var scontent = _this.data.share.scontent;
        console.log("scontent 的内容为：===+" + scontent);

        console.log("要将多余的空格符号，替换成换行符")
        console.log("onload函数===");
        console.log(_this.data.share);
        console.log("onload函数下，_this.data.share.sid的值为：" + _this.data.share.sid);
        /** 
         * 显示删除图片，将share.user.uid和 app.user.uid 进行判断
         */
        if (app.user.uid == res.data.user.uid || (app.user.uid <= 7 && app.user.uid > 0)) {
          /**是否为本用户发布的经验信息，如果是，则可以删除，若不是，则不显示删除 */
          _this.data.isShowDelShare = true;
        } else {
          _this.data.isShowDelShare = false;
        }
        var share = _this.data.share;
        var images = [];
        if (share.simg1 != null && share.simg1 != '') {
          images = images.concat(share.simg1);
          // console.log(shareList[i].simg1+"\n");
        }
        if (share.simg2 != null && share.simg2 != '') {
          images = images.concat(share.simg2);
        }
        if (share.simg3 != null && share.simg3 != '') {
          images = images.concat(share.simg3);
        }
        if (share.simg4 != null && share.simg4 != '') {
          images = images.concat(share.simg4);
        }
        if (share.simg5 != null && share.simg5 != '') {
          images = images.concat(share.simg5);
        }
        if (share.simg6 != null && share.simg6 != '') {
          images = images.concat(share.simg6);
        }
        _this.data.share.images = images;
        console.log("onload函数上===将图片载入到一个数组的时候  share::");
        console.log(_this.data.share);
        console.log("_this.data.appUser.uid的值为：" + _this.data.appUser.uid);
        _this.setData({
          share: _this.data.share,
          isShowDelShare: _this.data.isShowDelShare
        })
      }
    }) //
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
    console.log("进入onShow函数");
    this.setData({
      isAutoPlay: true,
      switchShow: false,
      responseVShow: this.data.responseVShow,
      isShowDelRecom: true,
      sayGoodYorN: false,
      collectYorN: false,
      inputValue: '',
      isShowDelShare: true,
      appUser: app.user

    })
    var _this = this;
    /**获取sid的share数据 */
    wx.request({
      url: "http://localhost:8081/withUser/" + this.data.sid + "/restShare",
      method: 'GET',
      success: function(res) {
        console.log("onShow函数===经验信息数据+用户信息");
        console.log("onShow函数===");
        console.log(res.data);
        _this.data.share = res.data;
        console.log(_this.data.share);
        /** 
         * 显示删除图片，将share.user.uid和 app.user.uid 进行判断
         */
        if (app.user.uid == res.data.user.uid || (app.user.uid <= 7 && app.user.uid > 0)) {
          /**是否为本用户发布的经验信息，如果是，则可以删除，若不是，则不显示删除 */
          _this.data.isShowDelShare = true;
        } else {
          _this.data.isShowDelShare = false;
        }
        var share = _this.data.share;
        var images = [];
        if (share.simg1 != null && share.simg1 != '') {
          images = images.concat(share.simg1);
          // console.log(shareList[i].simg1+"\n");
        }
        if (share.simg2 != null && share.simg2 != '') {
          images = images.concat(share.simg2);
        }
        if (share.simg3 != null && share.simg3 != '') {
          images = images.concat(share.simg3);
        }
        if (share.simg4 != null && share.simg4 != '') {
          images = images.concat(share.simg4);
        }
        if (share.simg5 != null && share.simg5 != '') {
          images = images.concat(share.simg5);
        }
        if (share.simg6 != null && share.simg6 != '') {
          images = images.concat(share.simg6);
        }
        _this.data.share.images = images;
        console.log("onShow函数===将图片载入到一个数组的时候  share::");
        console.log(_this.data.share);

        console.log("================");
        console.log("================");
        console.log("对信息内容里面的空格符进行去除\n");
        var content = _this.data.share.scontent;
        console.log("最开始的scontent是==\n" + content);
        content = content.replace(/\s*/g, "");//将所有空格去掉
        _this.data.share.scontent = content;
        console.log("进行replace去空格之后的content的数值")
        console.log(content);
        console.log("================");
        console.log("================");


        _this.setData({
          share: _this.data.share,
          isShowDelShare: _this.data.isShowDelShare
        })
      }
    }) //

    /**获取是否已经对这个经验信息点赞 */
    /**当前sid 和app.user.uid来进行判断 */
    console.log("onShow函数===_this.data.share.sid的数值为：：" + _this.data.share.sid); /**在这里读取不到sid？？？ */
    var sid = parseInt(_this.data.share.sid);
    var uid = parseInt(app.user.uid);

    //登陆了才可以获得是否点赞  还是收藏  了
    if (app.user.uid != -1 && app.user.uid != null) {

      wx.request({
        url: "http://localhost:8081/" + parseInt(_this.data.sid) + '/' + uid + "/restSayGood",
        method: 'GET',
        success: function(res) {
          //判断是否点赞
          console.log("onShow函数===判断是否点赞网络请求返回函数中的res：");
          console.log(res);
          console.log("onShow函数===判断是否点赞" + res.data);
          _this.data.sayGoodYorN = res.data.sgid > 0;
          console.log("onShow函数===是否点赞_this.data.sayGoodYorN：" + _this.data.sayGoodYorN);
          _this.setData({
            sayGoodYorN: _this.data.sayGoodYorN
          })
        }
      })
      //判断是否收藏
      wx.request({
        url: "http://localhost:8081/" + parseInt(_this.data.sid) + '/' + parseInt(app.user.uid) + "/restCollect",
        method: 'GET',
        success: function(res) {
          //判断是否收藏
          console.log("onShow函数===判断是否收藏网络请求返回函数中的res：");
          console.log(res);
          console.log("onShow函数===判断是否收藏" + res.data);
          _this.data.collectYorN = res.data.clid > 0;
          console.log("onShow函数===是否点赞_this.data.collectYorN" + _this.data.collectYorN);
          _this.setData({
            collectYorN: _this.data.collectYorN
          })
        }
      })

    }
    /**获取点赞人数 */
    wx.request({
      url: "http://localhost:8081/" + this.data.sid + "/restSayGood",
      method: 'GET',
      success: function(res) {
        //返回的是点赞的人数
        console.log("onShow函数===点赞的人数" + res.data);
        _this.data.share.slike = res.data;
        console.log("onShow函数===修改点赞人数之后的经验信息+用户数据："); /**这条语句有成功执行 */
        console.log(_this.data.share);
        _this.setData({
          share: _this.data.share
        })
      }
    });

    /**获取是否收藏和收藏的人数 */
    /**收藏人数 */
    wx.request({
      url: "http://localhost:8081/" + this.data.sid + "/restCollect",
      method: 'GET',
      success: function(res) {
        //返回的是收藏的人数
        console.log("onShow函数===收藏的人数" + res.data);
        _this.data.share.scollect = res.data;
        console.log("onShow函数===修改收藏人数之后的经验信息+用户数据："); /**这条语句有成功执行 */
        console.log(_this.data.share);
        _this.setData({
          share: _this.data.share
        })
      }
    });

    /**接下来是获取评论的内容 */
    wx.request({
      url: "http://localhost:8081/" + this.data.sid + "/restComment",
      method: "GET",
      success: function(res) {
        console.log("res的内容是：：：");
        if (res.data == '') {
          console.log("res.data==''"); /**用这个判断评论的返回函数中的返回的数据是不是空*/
        } else {
          _this.setData({
            commentList: res.data
          });
        }


        console.log(" _this.data.commentList在_this.setData之后的数值为：");
        console.log(_this.data.commentList);
        console.log("_this.data.commentList的长度为：" + _this.data.commentList.length);

        // for (var i = 0; i < _this.data.commentList.length; i++) {

        //     _commentList=_commentList.concat(_this.data.commentList[i]);

        // }
        // console.log("_commentList的数值为：：")
        // console.log(_commentList);
        console.log(res);
        console.log("restComment获取评论内容：res.data");
        console.log("获取评论内容：");
        console.log(res.data);
      }
    })

    console.log("onShow函数下，没有包含在网络请求的返回函数中===执行到此处，做个标记");



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
  onShareAppMessage: function() {},
  onPageScroll: function(e) {
    this.setData({
      scrollTop: e.scrollTop
    })
  },
  switchChangeV: function(e) {
    this.setData({
      isAutoPlay: !this.data.isAutoPlay
    });

  },
  /**
   * 删除经验消息按钮 */
  delDetail: function(e) {
    console.log(e);
    /**删除一条经验分享消息 按sid 进行删除 */
    var _this = this;
    wx.showModal({
      title: '删除',
      content: '是否删除经验分享信息',
      success: function(res) {
        if (res.confirm == true) {
          wx.request({
            url: "http://localhost:8081/" + _this.data.sid + "/restShare",
            method: "DELETE",
            success: function(res) {
              console.log("删除一条经验信息：返回的res的数据为：res==");
              console.log(res.data);

              wx.showLoading({
                title: '正在删除...',
                mask: true
              });
              setTimeout(function() {
                wx.hideLoading();
              }, 500);
              setTimeout(function() {
                wx.showToast({
                  title: '成功删除',
                  icon: 'success',
                  duration: 1500,
                  mask: true
                });
                wx.navigateBack({
                  delta: 1
                })
              }, 1000)

            }
          })
        }
      }
    })



  },

  changeSayGood: function(e) {
    console.log(e);

    if (app.user.id != -1 && app.user.uid != null&&app.hasUser!=2) {
      var _this = this;
      // var slike = (this.share.slike == null || this.share.slike == '') ? 0 : this.share.slike;
      // console.log("获取的点赞人数为" + slike);
      var sayGoodYorN = !this.data.sayGoodYorN;
      this.setData({
        sayGoodYorN: !this.data.sayGoodYorN
        // collectNum: parseInt(e.currentTarget.dataset.num) + 200
        /** sayGoodYorN 图片的转换在页面对sayGoodYorN进行判断*/
      })
      /**sayGoodYorN 为true的话，那就是      点赞
       * sayGoodYorN 为false的话，那就是 没有点赞
       */
      if (!sayGoodYorN) {
        /**true 代表已经点赞
         * false代表没有点赞
         */
        /**删除一条点赞的数据 */

        wx.showToast({
          title: '取消点赞',
          duration: 1000,
          mask: true
        })
        console.log("sayGoodYorN应该是false的" + sayGoodYorN);
        var sid = parseInt(this.data.sid);
        var uid = parseInt(app.user.uid);

        wx.request({
          url: 'http://localhost:8081/' + sid + '/' + uid + '/restSayGood',
          method: "DELETE",
          success: function(res) {
            console.log(res);
            console.log("是否能进行修改 返回的是点赞的人数::" + res.data);
            _this.data.share.slike = res.data;
            _this.setData({
              share: _this.data.share
            })
          }
        })
      } else {
        console.log("sayGoodYorN应该是true的" + sayGoodYorN);
        /**增加一条点赞的数据 */

        var sid = this.data.sid;
        var uid = app.user.uid;
        wx.request({

          url: 'http://localhost:8081/restSayGood',
          method: "POST",
          data: JSON.stringify({
            sid: sid,
            uid: uid
          }),
          success: function(res) {
            wx.showToast({
              title: '成功点赞',
              duration: 1000,
              mask: true
            })
            console.log("是否能进行修改" + res.data);
            _this.data.share.slike = res.data;
            console.log("修改点赞人数之后的share数据");
            console.log(_this.data.share);
            _this.setData({
              share: _this.data.share,


            })
            console.log("增加一条点赞数据之后的share")
            console.log(_this.data.share)
            // _this.data.share.slike = res.data;
            // _this.setData({

            // })
          }
        })

      }

    } else {
      wx.showToast({
        title: '请检查是否为微信用户登陆',
        icon: 'none',
        duration: 2000,
        mask: true,
      })
    }

  },


  changeCollect: function(e) {
    console.log(e);

    if (app.user.id != -1 && app.user.uid != null) {
      //是否收藏，都要发起网络请求来验证是否收藏；
      //包括收藏的数量，都有网络请求来进行
      var _this = this;
      // var scollect = (this.share.scollect == null || this.share.scollect == '') ? 0 : this.share.scollect;
      // console.log("获取的收藏人数为" + scollect);
      var collectYorN = !this.data.collectYorN;
      this.setData({
        collectYorN: !this.data.collectYorN
        // collectNum: parseInt(e.currentTarget.dataset.num) + 200
        /** collectYorN 图片的转换在页面对collectYorN进行判断*/
      })
      /**collectYorN 为true的话，那就是      收藏
       * collectYorN 为false的话，那就是 没有收藏
       */
      if (!collectYorN) {
        /**true 代表已经收藏
         * false代表没有收藏
         */
        /**删除一条收藏的数据 */
        wx.showToast({
          title: '取消收藏',
          duration: 1000,
          mask: true
        })
        console.log("collectYorN应该是false的" + collectYorN);
        var sid = parseInt(this.data.sid);
        var uid = parseInt(app.user.uid);

        wx.request({
          url: 'http://localhost:8081/' + sid + '/' + uid + '/restCollect',
          method: "DELETE",
          success: function(res) {
            console.log(res);
            console.log("是否能进行修改 返回的是收藏的人数::" + res.data);
            _this.data.share.scollect = res.data;
            _this.setData({
              share: _this.data.share
            })
          }
        })
      } else {
        console.log("collectYorN 应该是true的" + collectYorN);
        /**增加一条收藏的数据 */
        wx.showToast({
          title: '成功收藏',
          duration: 1000,
          mask: true
        })
        var sid = this.data.sid;
        var uid = app.user.uid;
        wx.request({

          url: 'http://localhost:8081/restCollect',
          method: "POST",
          data: JSON.stringify({
            sid: sid,
            uid: uid
          }),
          success: function(res) {
            console.log("是否能进行修改" + res.data);
            _this.data.share.scollect = res.data;
            console.log("修改收藏人数之后的share数据");
            console.log(_this.data.share);
            _this.setData({
              share: _this.data.share,


            })
            console.log("增加一条收藏数据之后的share")
            console.log(_this.data.share)
            // _this.data.share.scollect = res.data;
            // _this.setData({

            // })
          }
        })
      }
    } else {
      wx.showToast({
        title: '请检查是否为微信用户登陆',
        icon: 'none',
        duration: 2000,
        mask: true,
      })
    }
  },
  delRecom: function(e) {
    var _this = this;
    console.log(e);
    console.log("获得的评论的cid数：" + e.currentTarget.dataset.cid);
    var cid = e.currentTarget.dataset.cid;
    wx.showModal({
      title: '删除确认',
      content: '是否删除',
      success: function(res) {
        console.log(res);
        console.log(res.confirm);
        if (res.confirm) {
          wx.request({
            url: 'http://localhost:8081/' + cid + '/restComment',
            method: "DELETE",
            success: function(res) {
              console.log(res);
              console.log("删除一条评论数据后会success回调函数");
              var _commentList = [];
              for (var i = 0; i < _this.data.commentList.length; i++) {
                if (_this.data.commentList[i].cid != cid) {
                  _commentList = _commentList.concat(_this.data.commentList[i]);
                }
              }
              _this.setData({
                commentList: _commentList
              })

              if (res.data) {
                wx.showToast({
                  title: '删除成功',
                  icon: 'success',
                  duration: 1500,
                  mask: true
                })
              }
            }
          })
        }
      }
    })

  },

  textInput: function(e) {
    console.log("输入框的值为：");
    console.log(e.detail.value);
    console.log(e);
    if (e.detail.value.length>=50){
      wx.showToast({
        title: '最多输入50个字符',
        icon:"none",
        mask:true
      })
    }
    this.data.ccontent = e.detail.value;
    this.setData({
      inputFocus: true
    });

  },




  sendBtn: function(e) {
    console.log("最发送的的uid2的值为：" + this.data.uid2);
    console.log("输入框内的数值为" + this.data.ccontent);
    if (this.data.ccontent.length > 0) {
      console.log(this.data.ccontent);
      /**sid uid(app.user.uid) uid2 ccontent  */
      if (app.user.uid != null && app.user.uid != '' && app.hasUser == 1) {
        var _this = this;
        var sid = this.data.sid;
        var uid = app.user.uid;
        var uid2 = this.data.uid2;
        var ccontent = this.data.ccontent;
        /**将评论数据发送到后台进行添加 */
        wx.request({
          url: 'http://localhost:8081/restComment',
          method: 'POST',
          data: JSON.stringify({
            sid: sid,
            uid: uid,
            uid2: uid2,
            ccontent: ccontent
          }),
          success: function(res) {
            console.log("添加一条评论返回函数数据：res==");
            console.log(res);
            if (res.data != "") {
              _this.data.commentList = _this.data.commentList.concat(res.data);
              console.log("把添加的评论数据添加到评论列表上，CommentWithUserUname");
              console.log(_this.data.commentList);
              _this.setData({
                commentList: _this.data.commentList,
                inputValue: ''
              })
              /**inputValue:'' 是input框中的值，确认之后，将框中的值，置空
               * 就会重新出现默认内容：输入内容
               */
            } else {
              wx.showToast({
                title: '请检查是否微信登陆',
                iocn: 'none',
                duration: 1500,
                mask: true
              })
            }
          }
        })




      } else {
        wx.showToast({
          title: '请检查是否微信登陆',
          icon: 'none',
          duration: 1500,
          mask: true
        })
      }
    } else {
      wx.showToast({
        title: '请输入内容',
        icon: 'none',
        duration: 1000,
        mask: true
      })
      console.log("输入框无值");
    }


  },
  getCommentCid: function(e) {
    console.log(e);
    this.data.uid2 = e.currentTarget.dataset.uid;
    this.setData({
      inputFocus: !this.data.inputFocus
    })
  },
  //点击图片进行放大功能
  previewImg:function(e){
    console.log(e);
    console.log(e.currentTarget.dataset.index);
    var index = e.currentTarget.dataset.index;
    var imgArr = this.data.share.images;
    wx.previewImage({
      current: imgArr[index],     //当前图片地址
      urls: imgArr,               //所有要预览的图片的地址集合 数组形式
      success: function (res) { },
      fail: function (res) { },
      complete: function (res) { },
    })

  }
})