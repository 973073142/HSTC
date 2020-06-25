// pages/agriCircle/agriCircle.js
var app = getApp();
Page({


  /**
   * 页面的初始数据
   */
  data: {
    shareList: {},
    imageList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  /**
   * options是页面跳转携带过来的参数，
   * &参数1=？&参数2=？？
   */
  onLoad: function(options) {

    console.log(options);

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
        //获取好列表信息之后，最后将进行排序，sid大的在前 （即发布时间离当前最近）
        console.log(res.data);
        var shareList = res.data;
        //按时间排序// 其实就是按照id进行排序而已
        var high = shareList.length - 1;
        var i = 0;
        for (i = 0; i <= (high / 2); i++) {
          var tempShare = shareList[i];
          shareList[i] = shareList[high - i];
          shareList[high - i] = tempShare;
        }
        console.log("经过排序之后的 shareList===");
        console.log(shareList);
        var imageList = [];
        for (var i = 0; i < shareList.length; i++) {
          var images = [];
          if (shareList[i].stitle.length > 16) {
            shareList[i].stitle = shareList[i].stitle.substring(0, 15) + '...';
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
        console.log(imageList.join('\n'));

        _this.setData({
          shareList: shareList,
          imageList: imageList
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
  openShareContentDetail: function(event) {
    console.log(event);
    wx.navigateTo({
      url: 'shareContentDetail/shareContentDetail' + "?sid=" + event.currentTarget.dataset.sid,
    })
  },
  openShareContentDetailByImage: function(e) {
    console.log(e);
    console.log(e.currentTarget.dataset.index);
    var index = e.currentTarget.dataset.index;
    var sid = this.data.shareList[index].sid;
    wx.navigateTo({
      url: 'shareContentDetail/shareContentDetail' + "?sid=" + sid,
    })
  },
  TapAddV: function(e) {
    if (app.user.uid > 0) {
      wx.navigateTo({
        url: 'addShare/addShare',
      });
    } else {
      wx.showToast({
        title: '请检查是否已登陆',
        icon: 'none',
        duration: 1500,
        mask: true
      })
    }

  },

  previewImg: function(e) {
    console.log(e);
    console.log(e.currentTarget.dataset.index);
    var index = e.currentTarget.dataset.index;
    var imgArr = this.data.share.images;
    wx.previewImage({
      current: imgArr[index], //当前图片地址
      urls: imgArr, //所有要预览的图片的地址集合 数组形式
      success: function(res) {},
      fail: function(res) {},
      complete: function(res) {},
    })

  }

})




// var kk = "<p style=\"text-align: center;\"><span id=\"videoGuidCode1\" class=\"videoGuidCode video\" len=\"10:16\" rel=\"vidVideoGuid1\" logo=\"vidVideoLogo1\" style=\"display:none\" videosize=\"4:3\" videotype=\"0\"></span><p><input type='hidden' data='f8611fa53cba4202a91853541b07e5d4' name='0'/></p></p>\n<p>在上海有一家叫<span style=\"font-size: 18px;\">“梦工坊”的咖啡店，这家咖啡店有些特殊。</span>除了店长之外，7名员工都是上海辅读学校的毕业生，他们都有不同程度的心智障碍，有的患有自闭症，有的患有唐氏综合征，有的智商只相当于六七岁的孩子。<br /></p>\n<p>然而，身心上的障碍，并没有妨碍他们对生活和工作独立的追求。</p>\n<p><span style=\"color: rgb(31, 73, 125);\"><strong>这家咖啡店 每位店员都很特别</strong></span></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081038926_141.gif\" localname=\"1568081038926_141.gif\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081038926_141.gif\" /></p>\n<p>每位走进咖啡吧的顾客，第一眼看到的就是杨安昆。这个患有自闭症的大男孩对数字很敏感，每天都会把实时到店人数记录在小黑板上。店里的装饰画很多也是出自他手。<br /></p>\n<p><strong><strong style=\"font-size: 18px; white-space: normal;\"></strong></strong></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081065669_743_701x401.png\" localname=\"1568081065669_743_701x401.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081065669_743_701x401.png\" /></p>\n<p><strong><strong style=\"font-size: 18px; white-space: normal;\">店员 杨安昆：</strong></strong>我画的是啄木鸟一家人，我们要把梦工坊咖啡吧当作我们的家，我的快乐是天天要保持微笑。<span style=\"white-space:pre\"> </span><br /></p>\n<p>咖啡师殷昊很有派头，营业前总是把发型打理得油光锃亮。在店长的帮助下，他已经可以独立完成几款简单的咖啡调制。</p>\n<p>因为想给顾客最大的实惠，他调制的咖啡总是满到快溢出来，这给负责跑堂的小伙伴带来了不少麻烦。</p>\n<p><strong></strong></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081084039_814_694x409.png\" localname=\"1568081084039_814_694x409.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081084039_814_694x409.png\" /></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081100427_168_678x406.png\" localname=\"1568081100427_168_678x406.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081100427_168_678x406.png\" /></p>\n<p><strong>店员 奚骏磊：</strong>只要每次接触到客人，我都感觉很开心。<br /></p>\n<p>收银员王颖异的腿脚不方便，因此她很少喝水，就怕上厕所耽误客人的时间。</p>\n<p><strong></strong></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081120952_578_698x409.png\" localname=\"1568081120952_578_698x409.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081120952_578_698x409.png\" /></p>\n<p><strong>店员 王颖异：</strong>学校里面都是熟悉的老师，这边都是陌生的顾客，刚开始的时候会紧张，现在基本上没有什么问题了。<br /></p>\n<p>吴薇是大家眼中的大姐姐，制作果汁色拉之余，还分担其他小伙伴岗位上的工作。</p>\n<p><strong></strong></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081142107_339_663x402.png\" localname=\"1568081142107_339_663x402.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081142107_339_663x402.png\" /></p>\n<p><strong>店员 吴薇：</strong>像上班族一样，晚上还能看夜景。在学校里做的话，老师可能会包容我们一些。然而在这里的话，有些客人不一定了解我们是些特殊的孩子。<br /></p>\n<p>一份好工作，对绝大多数人来说都很重要，对于这些特殊的孩子，咖啡馆这份工作尤其珍贵。</p>\n<p>这些心智障碍的年轻人，虽然学起来也许要比普通人慢一些，但干起活来格外认真。现在梦工坊咖啡吧已经试营业两个多月了，累计接待了上万名顾客。</p>\n<p><span style=\"color: rgb(31, 73, 125);\"><strong>服务标准不降 店员格外认真</strong></span></p>\n<p>每天早晨8点半，梦工坊咖啡吧的店员都是从检查指甲开始一天的工作。</p>\n<p><strong></strong></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081174231_441_683x403.png\" localname=\"1568081174231_441_683x403.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081174231_441_683x403.png\" /></p>\n<p><strong>店员 吴薇：</strong>榨汁、做咖啡都会触碰到这个手。所以，每天要检查一下手指甲，没剪就立刻剪掉。<br /></p>\n<p>打扫卫生、制作咖啡、跑堂上菜，这些工作，孩子们在学校已经进行了系统的培训，但现在每天面对上百个陌生顾客，要想做到服务不打折扣，还需要孩子们反复练习每一个动作，把每一道程序都牢牢根植在大脑中。</p>\n<p><strong></strong></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081242531_522_688x398.png\" localname=\"1568081242531_522_688x398.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081242531_522_688x398.png\" /></p>\n<p><strong>店长 小何：</strong>他的忘性会非常大。比如，今天这个摩卡是需要放巧克力酱，明天他就不会放巧克力酱了，他的意识里面只会做拿铁跟美式。<br /></p>\n<p>一开始，大家的心里都没底。19岁的秦佳晨患有唐氏综合征，在店里负责保洁工作，因为行动较为缓慢，最初，他的妈妈担心佳晨干不好这份工作。</p>\n<p><strong></strong></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081208456_902_692x387.png\" localname=\"1568081208456_902_692x387.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081208456_902_692x387.png\" /></p>\n<p><strong>秦佳晨妈妈 陆美英：</strong>我当时担心，我说他能胜任吗？因为没想到他能参加工作。校长说，能胜任的，你要鼓励孩子，每一个孩子身上都有闪光点。<br /></p>\n<p>慢慢的，大家发现，孩子们虽然忘得快学得慢，但一旦学会了就能不折不扣地执行，做起来还格外认真。</p>\n<p><strong>秦佳晨妈妈 陆美英：</strong>毛巾四四方方，四个角整整齐齐，就按照老师在学校时候教他的（那样），一板一眼地（叠）。</p>\n<p>店员们都是特殊的，但店里的服务标准却不能因此降低。店长小何希望孩子们在工作中真正学到东西，而不是简单地被人照顾和同情。</p>\n<p><strong></strong></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081225121_737_697x397.png\" localname=\"1568081225121_737_697x397.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081225121_737_697x397.png\" /></p>\n<p><strong>店长 小何：</strong>给他们讲述的一个观念，就是你进了这个门，就是一个职场的人了，你对工作就要负责了，他们都知道。<br /></p>\n<p>记者在采访的时候发现，这群特殊的孩子其实是非常愿意对人敞开心扉的，他们纯真、善良，和健全人一样有思想、有感情。</p>\n<p>他们渴望被理解、被尊重，更渴望体现自己的价值。</p>\n<p><span style=\"color: rgb(31, 73, 125);\"><strong>创造价值 收获自信</strong></span></p>\n<p>学习钢琴两年，殷昊现在会弹二十多首曲子。他每天一大早就到店里来，这里，已经成了他最喜欢的地方。</p>\n<p><strong></strong></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081259525_592_682x405.png\" localname=\"1568081259525_592_682x405.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081259525_592_682x405.png\" /></p>\n<p><strong>顾客 郭帝业：</strong>他能弹这么好真不容易啊，这真的有欧美咖啡馆的味道了，这么好的服务态度。<br /></p>\n<p><strong>店员 殷昊</strong>：弹钢琴也属于我的工作，要好好做好本职工作，管理好自己的情绪和脾气，不能嘴上说，要看行动。</p>\n<p>患有唐氏综合征的秦佳晨，以前即便是在家里，也很少开口说话，在咖啡吧工作的这个两个月，他渐渐开朗了起来。</p>\n<p><strong>秦佳晨妈妈 陆美英：</strong>现在工作了以后，他精神面貌不一样了，慢慢话讲得也多了。他跟老板说，阿姨（顾客）表扬我了，老板问他表扬的什么？干得好，认真。我说那你要干，要努力的，要坚持的。这两个多月他很开心，有时候还会哼歌。如果没有这份工作，佳晨肯定闭门不出。在家待一年，他绝对倒退三年。他等于与世隔绝了，跟社会脱节了。</p>\n<p>梦工坊咖啡吧的后门连接着辅读学校，走出校园迈入社会的这短短几步却不好走。浦东新区辅读学校应届毕业生每年都保持着80%以上的就业率。但一两年之后学校做回访，却发现很多人已经回家了，就业率降到50%，甚至更低。</p>\n<p><strong></strong></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081282373_211_689x402.png\" localname=\"1568081282373_211_689x402.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081282373_211_689x402.png\" /></p>\n<p><strong>上海市浦东新区辅读学校校长 王英：</strong>我们有这样的数据，也有这样的案例。因为在外面企业不适应，在基地不适应，就回家。回家了以后，整个人的状态全部会退化、会丧失。那么他就在家里，比如说人会变得木讷，交流的能力也会丧失，更何况是这种劳动技能。<br /></p>\n<p>上海市浦东新区辅读学校提前把职场的规则渗入到课程当中，在校内打造了梦工坊咖啡吧，让学生模拟做咖啡吧服务员。今年夏天，通过校企合作，面向社会的梦工坊咖啡吧开始营业。</p>\n<p><strong></strong></p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081329410_117_692x403.png\" localname=\"1568081329410_117_692x403.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081329410_117_692x403.png\" /></p>\n<p><strong>万初鹏妈妈 卢玉丽：</strong>拯救我们家庭一样。因为后期的话，老人年龄越来越大的话，我们不可能总是跟着孩子一辈子。总归的话，他自己要能自理一部分，能力越强的话，他将来的生活质量会越高。<br /></p>\n<p>咖啡吧里，孩子们通过提供服务，感受他人的接纳和尊重，从这方小天地出发，慢慢融入大社会。外面的世界总是节奏飞快，而这些特殊的孩子显然需要更多的时间和耐心。竞争激烈的大社会，也需要更多像“梦工坊”一样的氤氲着咖啡香气、造梦、护梦、最终圆梦的小天地。</p>\n<p style=\"text-align: center;\"><img src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081355559_839_685x403.png\" localname=\"1568081355559_839_685x403.png\" localpath=\"/cportal/data/img/2019/9/10/\" publishflag=\"\" imginfo=\"\" style=\"max-width: 100%\" _src=\"https://p1.img.cctvpic.com/cportal/img/2019/9/10/1568081355559_839_685x403.png\" /></p>\n<p>他们用热爱和努力来弥补身体的不足，靠自己的双手，去创造美好生活。刚才片子中讲到了，可能比起正常人，他们学得要慢一点，但一旦学会了，就会加倍认真的去做、去执行，对工作没有丝毫的抱怨，只有热爱。这家店的经营，靠的不是人们对特殊孩子的同情，而是自身高标准的服务品质。对这些孩子们来说，认可远比同情有意义，希望他们的咖啡吧越来越好。<br /></p>\n<p><br /></p>\n<p style=\"text-align: right;\"><span style=\"font-size: 14px;\">（编辑 田野）</span></p> ";
// var reg = /<img.+?src=('|")?([^'"]+)('|")?(?:\s+|>)/img;
// var arr = "";
// var tem;
// var arr;
// while (tem = reg.exec(kk)) {
//   arr = arr + tem[2] + ";";
// }
// console.log("agriCircle==onLoad尝试获取图片获取的图片：===");
// var temImages = arr.split(";");
// console.log((arr.split(";")).join("\n"));
// var images = [];
// for (var i = 0; i < temImages.length; i++) {
//   if (temImages[i].substring(temImages[i].length - 3) == "png" || temImages[i].substring(temImages[i].length - 3) == "jpg") {
//     images = images.concat(temImages[i]);
//   }
// }
// console.log("images的数据值为：===");
// console.log(images.join("\n"));

