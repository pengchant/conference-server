(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-9341"],{"/XhV":function(t,e,i){"use strict";var n=i("K7ai");i.n(n).a},K7ai:function(t,e,i){},NeJP:function(t,e,i){},VPOV:function(t,e,i){},W2Fo:function(t,e,i){!function(t){"use strict";!function(){if("undefined"!=typeof document){var t=document.head||document.getElementsByTagName("head")[0],e=document.createElement("style"),i=" .timeline { padding: 0; position: relative; list-style: none; font-family: PingFangSC-light, Avenir, Helvetica, Arial, Hiragino Sans GB, Microsoft YaHei, sans-serif; -webkit-font-smoothing: antialiased; margin: 10px 20px; } .timeline:after { position: absolute; content: ''; left: 0; top: 0; width: 1px; height: 100%; background-color: var(--timelineTheme); } .timeline-item { position: relative; margin: 1.5em 0 0 28px; padding-bottom: 1.5em; border-bottom: 1px dotted var(--timelineTheme); } .timeline-item:last-child { border-bottom: none; } .timeline-circle { position: absolute; top: .28em; left: -34px; width: 10px; height: 10px; border-radius: 50%; border: 1px solid var(--timelineTheme); background-color: var(--timelineTheme); z-index: 1; box-sizing: content-box; } .timeline-circle.hollow { background-color: var(--timelineBg); } .timeline-title { position: relative; display: inline-block; /** * BFC inline-block 元素与其兄弟元素、子元素和父元素的外边距都不会折叠（包括其父元素和子元素） */ cursor: crosshair; margin: -.15em 0 15px 28px } .timeline-title:not(:first-child) { margin-top: 28px; } .timeline-title-circle { left: -36px; top: .15em; width: 16px; height: 16px; } .timeline-others { width: 40px; height: auto; top: .2em; left: -48px; line-height: 1; padding: 2px 0; text-align: center; border: none; background-color: var(--timelineBg); } ";e.type="text/css",e.styleSheet?e.styleSheet.cssText=i:e.appendChild(document.createTextNode(i)),t.appendChild(e)}}();var e={render:function(){var t=this.$createElement,e=this._self._c||t;return e("ul",{ref:"timeline",staticClass:"timeline"},[this._t("default")],2)},staticRenderFns:[],name:"Timeline",props:{timelineTheme:{type:String,default:"#dbdde0"},timelineBg:{type:String,default:"#fff"}},mounted:function(){var t=this.$refs.timeline;t.style.setProperty("--timelineTheme",this.timelineTheme),t.style.setProperty("--timelineBg",this.timelineBg)}};!function(){if("undefined"!=typeof document){var t=document.head||document.getElementsByTagName("head")[0],e=document.createElement("style");e.type="text/css",e.styleSheet?e.styleSheet.cssText="":e.appendChild(document.createTextNode("")),t.appendChild(e)}}();var i={name:"TimelineItemBase",props:{bgColor:{type:String,default:""},lineColor:{type:String,default:""},hollow:{type:Boolean,default:!1},fontColor:{type:String,default:"#37414a"}},data:function(){return{slotOthers:!1}},computed:{circleStyle:function(){if(this.bgColor||this.lineColor||this.hollow){var t={};return this.bgColor&&(t={"border-color":this.bgColor,"background-color":this.bgColor}),this.lineColor&&(t=Object.assign({},t,{"border-color":this.lineColor})),t}},itemStyle:function(){return{color:this.fontColor}},slotClass:function(){var t="";return this.slotOthers?t="timeline-others":this.hollow&&(t="hollow"),t}},mounted:function(){this.slotOthers=!!this.$refs.others.innerHTML}};!function(){if("undefined"!=typeof document){var t=document.head||document.getElementsByTagName("head")[0],e=document.createElement("style");e.type="text/css",e.styleSheet?e.styleSheet.cssText="":e.appendChild(document.createTextNode("")),t.appendChild(e)}}();var n={render:function(){var t=this.$createElement,e=this._self._c||t;return e("li",{staticClass:"timeline-item",style:this.itemStyle},[e("div",{ref:"others",staticClass:"timeline-circle",class:this.slotClass,style:this.circleStyle},[this._t("others")],2),this._v(" "),this._t("default")],2)},staticRenderFns:[],extends:i};!function(){if("undefined"!=typeof document){var t=document.head||document.getElementsByTagName("head")[0],e=document.createElement("style");e.type="text/css",e.styleSheet?e.styleSheet.cssText="":e.appendChild(document.createTextNode("")),t.appendChild(e)}}();var s={render:function(){var t=this.$createElement,e=this._self._c||t;return e("li",{staticClass:"timeline-title",style:this.itemStyle},[e("div",{ref:"others",staticClass:"timeline-circle timeline-title-circle",class:this.slotClass,style:this.circleStyle},[this._t("others")],2),this._v(" "),this._t("default")],2)},staticRenderFns:[],extends:i};"undefined"!=typeof window&&window.Vue&&(window.Vue.component(e.name,e),window.Vue.component(n.name,n),window.Vue.component(s.name,s)),t.Timeline=e,t.TimelineItem=n,t.TimelineTitle=s,Object.defineProperty(t,"__esModule",{value:!0})}(e)},XwdX:function(t,e,i){"use strict";var n=i("VPOV");i.n(n).a},g06K:function(t,e,i){"use strict";i.d(e,"g",function(){return l}),i.d(e,"a",function(){return r}),i.d(e,"e",function(){return c}),i.d(e,"k",function(){return a}),i.d(e,"d",function(){return d}),i.d(e,"c",function(){return u}),i.d(e,"h",function(){return h}),i.d(e,"f",function(){return f}),i.d(e,"b",function(){return m}),i.d(e,"m",function(){return p}),i.d(e,"n",function(){return g}),i.d(e,"j",function(){return v}),i.d(e,"i",function(){return _}),i.d(e,"l",function(){return b});var n=i("t3Un"),s=i("gjeX"),o=i.n(s);function l(){return Object(n.a)({url:"/comm/allpositon",method:"post"})}function r(){return Object(n.a)({url:"/comm/allduty",method:"post"})}function c(){return Object(n.a)({url:"/comm/alldepartment",method:"post"})}function a(t){return t.password=o()(t.password),t.confirmpass=o()(t.confirmpass),Object(n.a)({url:"/comm/registuser",method:"post",data:t})}function d(){return Object(n.a)({url:"/comm/allconflevel",method:"post"})}function u(){return Object(n.a)({url:"/comm/allconfattr",method:"post"})}function h(){return Object(n.a)({url:"/comm/allsemesters",method:"post"})}function f(){return Object(n.a)({url:"/comm/allduty",method:"post"})}function m(){return Object(n.a)({url:"/comm/allRoles",method:"post"})}function p(t){return Object(n.a)({url:"/comm/attendtag",method:"post",data:t})}function g(t){return Object(n.a)({url:"/comm/cancelattendtag",method:"post",data:t})}function v(t){return Object(n.a)({url:"/comm/getusrinfoview",method:"post",data:t})}function _(t){return Object(n.a)({url:"/comm/modifyUsrInfoView",method:"post",data:t})}function b(t){return Object(n.a)({url:"/comm/"+t+"/adapterHasRegisted",method:"post"})}},vAbR:function(t,e,i){"use strict";i.r(e);var n=i("QbLZ"),s=i.n(n),o=i("iCc5"),l=i.n(o),r=i("L2JU"),c=i("4LaD"),a=(i("NeJP"),i("W2Fo")),d=i("DkQT"),u={name:"FlagPager",props:{initindex:{default:0,type:Number},titles:{default:null,type:Array},titlekey:{default:"",type:String},titlevalue:{default:"",type:String}},data:function(){return{curindex:0,pre_title:"",next_title:"",cur_title:""}},watch:{titles:function(t,e){this.init()}},mounted:function(){},created:function(){},methods:{init:function(){this.curindex=this.initindex,this.titles&&this.titles.length>0&&(this.cur_title=this.filterValue(this.titles[this.curindex][this.titlevalue]),this.titles.length>1&&(this.next_title=this.filterValue(this.titles[this.curindex+1][this.titlevalue])))},before:function(){this.titles&&this.titles.length>0&&this.curindex>0?(this.curindex-=1,this.cur_title=this.titles[this.curindex]?this.titles[this.curindex][this.titlevalue]:null,this.pre_title=this.filterValue(this.titles[this.curindex-1]?this.titles[this.curindex-1][this.titlevalue]:null),this.next_title=this.filterValue(this.titles[this.curindex+1]?this.titles[this.curindex+1][this.titlevalue]:null),this.$emit("triggerbefore",this.curindex)):this.$message.warning("没有更多了")},next:function(){this.titles&&this.titles.length>0&&this.curindex<this.titles.length-1?(this.curindex+=1,this.cur_title=this.titles[this.curindex]?this.titles[this.curindex][this.titlevalue]:null,this.pre_title=this.filterValue(this.titles[this.curindex-1]?this.titles[this.curindex-1][this.titlevalue]:null),this.next_title=this.filterValue(this.titles[this.curindex+1]?this.titles[this.curindex+1][this.titlevalue]:null),this.$emit("triggerafter",this.curindex)):this.$message.warning("没有更多了")},filterValue:function(t){return t?(t.length>10&&(t=t.substr(0,10)+"..."),t):"暂无"}}},h=(i("XwdX"),i("KHd+")),f=Object(h.a)(u,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"flagwrapper"},[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-button",{attrs:{round:"",type:"warning",plain:""},on:{click:t.before}},[t._v("上一个:  "+t._s(t.pre_title?t.pre_title:"暂无"))])],1),t._v(" "),i("el-col",{attrs:{span:8}},[t._v("当前议题:  "+t._s(t.cur_title?t.cur_title:"暂无"))]),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-button",{attrs:{round:"",type:"warning",plain:""},on:{click:t.next}},[t._v("下一个:  "+t._s(t.next_title?t.next_title:"暂无"))])],1)],1)],1)},[],!1,null,"fa114c28",null);f.options.__file="index.vue";var m=f.exports,p=i("g06K"),g=i("QrNZ"),v=i("V+NQ"),_=function t(e,i,n){l()(this,t),this.recordid=e,this.conftitle=i,this.speachlist=n||[]},b=function t(e,i,n,s,o){l()(this,t),this.speakerid=e,this.speakername=i,this.content=n,this.audiolist=s||[],this.speechid=o},w=function t(e,i,n){l()(this,t),this.audioid=e,this.audiourl=i,this.description=n},y={name:"Recconf",components:{MRecorder:d.a,Timeline:a.Timeline,TimelineItem:a.TimelineItem,TimelineTitie:a.TimelineTitie,FlagPager:m},data:function(){return{confid:"",activeName:"second",attendersViews:[],basicConfInfoView:{confid:"",confname:"",endtime:"",hoster:"",hosterid:"",levelname:"",recorder:"",recorderid:"",roomid:"",roomname:"",semestername:"",starttime:""},confCollectBasicInfoView:{},confCurIssueViewsList:[],confLastIssueViewList:[],confSuggestionViewList:[],confTitleConclusions:[],initPagerIndex:0,confattrs:[],recordlist:[],curspeaker:{},curtitle:null,dialogVisible:!1,newConftitleTXT:""}},computed:s()({},Object(r.b)(["name","accid"])),mounted:function(){c.a.set("高校党政云记录管理平台 "+this.name,this.$refs.recconf_ref)},created:function(){var t=this,e=this;this.confid=this.$route.query.confid,Object(g.i)(this.confid).then(function(i){if(i.ok){var n=i.data;t.basicConfInfoView=n.basicConfInfoView,t.basicConfInfoView.hosterid=String(t.basicConfInfoView.hosterid),t.tinymceHtml=t.basicConfInfoView.conclusion,t.attendersViews=n.attendersViews,t.confattrs=n.confattrs,t.confCollectBasicInfoView=n.confCollectBasicInfoView,t.confLastIssueViewList=n.confLastIssueViewList,t.confCurIssueViewsList=n.confCurIssueViewsList,t.confSuggestionViewList=n.confSuggestionViewList,t.confTitleConclusions=n.confTitleViewList;var s=n.confRecVoicDetailViewList,o=s.length,l=t.recordlist;t.confCurIssueViewsList&&t.confCurIssueViewsList.length>0&&(t.curtitle=t.confCurIssueViewsList[0].mainconent);for(var r=0;r<o;r++)if(null!=s[r].recordid){var c=0,a=0;for(a=0;a<l.length;a++)if(s[r].titlename===l[a].conftitle){c=1;break}if(0===c&&null!=s[r].recordid){var d=new _(s[r].titleid,s[r].titlename,[]);t.recordlist.push(d),a=t.recordlist.length-1}if(null!=s[r].speakerid){var u=0,h=l[a].speachlist,f=0;for(f=0;f<h.length;f++)if(s[r].recordid===h[f].speechid){u=1;break}if(0===u&&null!=s[r].speakerid){var m=new b(s[r].speakerid,s[r].speakername,s[r].speaking,[],s[r].recordid);t.recordlist[a].speachlist.push(m),f=t.recordlist[a].speachlist.length-1}if(null!=s[r].voiceid){var p=s[r].voiceid,g=s[r].voiceurl;if(null!=p){var y=new w(p,Object(v.c)(g),"");e.recordlist[a].speachlist[f].audiolist.push(y)}}}}}else t.$message.error(i.msg)})},methods:{sageCurTitleConclusion:function(t){var e=this,i=this.confTitleConclusions[t];Object(v.r)({conclusion:i.conclusion,conftitleid:i.id}).then(function(t){t.ok?e.$message.success("保存结论成功"):e.$message.error(t.msg)})},handleBefore:function(t){this.curtitle=this.confCurIssueViewsList[t].mainconent},handleAfter:function(t){this.curtitle=this.confCurIssueViewsList[t].mainconent},handleAttend:function(t,e){var i=this;Object(p.m)({confid:this.confid,workerid:e.workerid}).then(function(t){t.ok&&Object(g.h)(i.confid).then(function(t){i.attendersViews=t.data})})},exportcollect:function(){var t=this;Object(g.b)(this.confid).then(function(e){var i=window.URL.createObjectURL(new Blob([e])),n=document.createElement("a");n.style.display="none",n.href=i,n.setAttribute("download",t.basicConfInfoView.confname+"会议采集表.docx"),document.body.appendChild(n),n.click()})},handleCancelAttend:function(t,e){var i=this;Object(p.n)({confid:this.confid,workerid:e.workerid}).then(function(t){t.ok&&Object(g.h)(i.confid).then(function(t){i.attendersViews=t.data})})},handelEndRecord:function(t,e,i){console.log(e,i,t);var n=new w(null,t,"");this.recordlist[e].speachlist[i].audiolist.push(n)},newConfTitle:function(){this.dialogVisible=!0},handleClicked:function(t,e){var i=this.curtitle;this.curspeaker=e;var n=!1;if(""!==i&&null!==i){for(var s=0;s<this.recordlist.length;s++)if(i===this.recordlist[s].conftitle){n=!0;var o=this.recordlist[s].speachlist,l={};if(o.length>0)o[0].speakerid===this.curspeaker.workerid?this.$message.error("请继续输入发言内容"):(l=new b(e.workerid,e.usrname,"",[],null),o.unshift(l));else l=new b(e.workerid,e.usrname,"",[],null),o.push(l);break}if(!1===n){var r=new _(null,i,[]);this.recordlist.push(r);var c=new b(e.workerid,e.usrname,"",[],null);this.recordlist[this.recordlist.length-1].speachlist.push(c)}}else this.$message.error("请先选择当前会议的议题")},handleRemoveRecitem:function(t,e,i,n){var s=this,o=this;try{this.$confirm("你确定要删除该条记录吗，包括录音将一起删除?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var i=o.recordlist[t].speachlist[e].speechid;null!=i&&""!==i&&void 0!==i?Object(v.o)({recorid:i}).then(function(i){!0===i.ok?(o.recordlist[t].speachlist.splice(e,1),s.$message({type:"success",message:"删除成功!"})):o.$message.error(i.msg)}):o.recordlist[t].speachlist.splice(e,1)}).catch(function(){s.$message({type:"info",message:"已取消删除"})})}catch(t){console.log(t)}},handleSaveRecitem:function(t,e){var i=this,n=this,s={confid:this.confid,conftitle:this.curtitle,content:this.recordlist[t].speachlist[e].content,speakerid:this.curspeaker.workerid,speakername:this.curspeaker.usrname};Object(v.i)(s).then(function(s){if(!0===s.ok){n.$message.success("保存成功!");var o=s.data;n.recordlist[t].speachlist[e].speechid=o.id,n.recordlist[t].recordid=o.conftitleid,Object(v.m)(i.confid).then(function(t){i.confTitleConclusions=t.data,console.log("重新加载议题后:",i.confTitleConclusions)})}else n.$message.error(s.msg)})},handleUploadVoice:function(t,e,i){var n=this,s=this;this.$confirm("确定要上传该录音?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var n=s.recordlist[t].speachlist[e].audiolist[i].audiourl,o=s.curtitle,l=s.recordlist[t].speachlist[e].speechid;null!==o&&""!==o&&void 0!==o?null!=l&&""!==l&&void 0!==l?Object(v.u)({confrecid:l,voice:n.mblob},function(n){console.log(n),!0===n.ok?(s.$message.success("上传录音成功!"),s.recordlist[t].speachlist[e].audiolist[i].audioid=n.data.id):s.$message.error("上传录音失败!")}):s.$message.error("请先上传该条记录"):s.$message.error("对不起请先选择议题!")}).catch(function(){n.$message.info("录音已经取消上传")})},handleModifyRecitem:function(t,e){var i=this,n=this.recordlist[t].speachlist[e],s=n.speechid,o=n.content;Object(v.h)({recorid:s,content:o}).then(function(t){!0===t.ok?i.$message.success("修改成功!"):i.$message.error(t.msg)})},handleRMVoice:function(t,e,i){var n=this,s=this.recordlist[t].speachlist[e].audiolist,o=s[i].audioid;this.$confirm("确定要删除该录音，删除后将无法撤回?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){s.splice(i,1),null!==o&&(console.log("准备请求后台删除,",o),Object(v.p)({voiceid:o}).then(function(t){!0===t.ok?n.$message.success("删除录音成功!"):n.$message.error(t.msg)})),n.$message({type:"success",message:"删除成功!"})}).catch(function(){n.$message({type:"info",message:"已取消删除"})})},handleAddConfTitle:function(){var t=this,e=this.newConftitleTXT,i=this.confCollectBasicInfoView.collectid;console.log("add：",e,i),Object(v.j)({content:e,conftitleid:i}).then(function(e){!0===e.ok?(t.$message.success("录入会议议题成功!"),Object(v.n)({workerid:t.confid}).then(function(e){console.log("增加议题之后==========>",e),!0===e.ok?(t.confCurIssueViewsList=e.data,t.initPagerIndex=t.confTitleConclusions.length-1):t.$message.error("加载失败")}),t.newConftitleTXT="",t.dialogVisible=!1):t.$message.error("录入会议议题失败!")})},saveconclusion:function(){var t=this,e=this.tinymceHtml,i=this.confid;Object(v.q)({confid:i,consolusion:e}).then(function(e){!0===e.ok?t.$message.success("保存会议成功!"):t.$message.error(e.msg)})},modifyholder:function(){var t=this,e=this.confid,i=this.basicConfInfoView.hosterid;console.log("准备修改holderid：",e,i),Object(v.g)({confid:e,holderid:i}).then(function(e){!0!==e.ok&&t.$message.error(e.msg)})},endRecordConf:function(){var t=this;this.$confirm("您确定要结束会议录入吗，结束后您将无法修改?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(v.b)(t.basicConfInfoView.confid).then(function(e){e.ok?(t.$message.success("操作成功!"),t.$router.push({path:"/dashboard"})):t.$message.error(e.msg)})}).catch(function(){t.$message({type:"info",message:"已取消"})})}}},x=(i("/XhV"),Object(h.a)(y,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{ref:"recconf_ref",staticStyle:{padding:"20px"}},[i("el-container",[i("el-main",{staticStyle:{padding:"0px"}},[i("el-card",{staticClass:"box-card",attrs:{"body-style":{padding:"20px"},shadow:"never"}},[i("table",{staticClass:"mytable",attrs:{border:"0",cellspacing:"0",cellpadding:"0"}},[i("tr",[i("td",{staticStyle:{width:"120px"}},[t._v("会议名称")]),t._v(" "),i("td",{staticClass:"align-center",staticStyle:{color:"red","font-weight":"700","font-size":"20px"},attrs:{colspan:"5"}},[t._v(t._s(t.basicConfInfoView.confname))])]),t._v(" "),i("tr",[i("td",[t._v("学期")]),t._v(" "),i("td",{attrs:{colspan:"5"}},[t._v(t._s(t.basicConfInfoView.semestername))])]),t._v(" "),i("tr",[i("td",[t._v("会议属性")]),t._v(" "),i("td",{attrs:{colspan:"5"}},t._l(t.confattrs,function(e){return i("el-tag",{key:e.attrdes,staticStyle:{"margin-left":"20px"}},[t._v(t._s(e.attrdes))])}))]),t._v(" "),i("tr",[i("td",[t._v("会议类别")]),t._v(" "),i("td",{staticStyle:{"min-width":"140px"}},[t._v("校级会议")]),t._v(" "),i("td",{staticStyle:{width:"100px"}},[t._v("主持人")]),t._v(" "),i("td",[i("el-select",{staticStyle:{width:"100%",border:"none"},attrs:{placeholder:"请选择主持人"},on:{change:t.modifyholder},model:{value:t.basicConfInfoView.hosterid,callback:function(e){t.$set(t.basicConfInfoView,"hosterid",e)},expression:"basicConfInfoView.hosterid"}},t._l(t.attendersViews,function(t){return i("el-option",{key:t.workerid,attrs:{label:t.usrname,value:t.workerid}})}))],1),t._v(" "),i("td",{staticStyle:{width:"100px"}},[t._v("录入人")]),t._v(" "),i("td",[i("el-select",{staticStyle:{width:"100%",border:"none"},attrs:{placeholder:"请选择录入人"},model:{value:t.basicConfInfoView.recorderid,callback:function(e){t.$set(t.basicConfInfoView,"recorderid",e)},expression:"basicConfInfoView.recorderid"}},t._l(t.attendersViews,function(t){return i("el-option",{key:t.workerid,attrs:{label:t.usrname,value:t.workerid}})}))],1)]),t._v(" "),i("tr",[i("td",[t._v("会议地点")]),t._v(" "),i("td",[t._v(t._s(t.basicConfInfoView.roomname))]),t._v(" "),i("td",[t._v("开始时间")]),t._v(" "),i("td",[t._v(t._s(t.basicConfInfoView.starttime.substr(0,19)))]),t._v(" "),i("td",[t._v("结束时间")]),t._v(" "),i("td",[t._v(t._s(t.basicConfInfoView.endtime.substr(0,19)))])])])])],1)],1),t._v(" "),i("el-container",[i("el-aside",{attrs:{width:"290px"}},[i("el-card",{staticClass:"box-card",staticStyle:{"min-height":"200px"},attrs:{"body-style":{padding:"0px"}}},[i("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[i("span",[t._v("参会人员")])]),t._v(" "),i("el-table",{staticStyle:{width:"100%"},attrs:{data:t.attendersViews,"show-header":!1,border:""}},[i("el-table-column",{attrs:{prop:"usrname"}}),t._v(" "),i("el-table-column",{attrs:{width:"180",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return["1"===e.row.hasattend?i("span",[i("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(i){t.handleCancelAttend(e.$index,e.row)}}},[i("i",{staticClass:"el-icon-error"}),t._v(" 取消\n                ")]),t._v(" "),i("el-button",{attrs:{type:"success",size:"mini"},on:{click:function(i){t.handleClicked(e.$index,e.row)}}},[i("i",{staticClass:"el-icon-edit-outline"}),t._v(" 发言\n                ")])],1):i("span",[i("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(i){t.handleAttend(e.$index,e.row)}}},[i("i",{staticClass:"el-icon-success"}),t._v(" 签到\n                ")])],1)]}}])})],1)],1)],1),t._v(" "),i("el-container",[i("el-main",{staticStyle:{padding:"0px"}},[i("el-card",{staticClass:"box-card",attrs:{"body-style":{padding:"20px"}}},[i("el-tabs",{attrs:{type:"card"},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[i("el-tab-pane",{attrs:{label:"议题采集表格",name:"first"}},[i("table",{staticClass:"mytable",attrs:{border:"0",cellspacing:"0",cellpadding:"0"}},[i("tr",[i("td",{staticClass:"align-center",attrs:{colspan:"2"}},[t._v(t._s(t.basicConfInfoView.confname)+"会议议题采集表")])]),t._v(" "),i("tr",[i("td",{attrs:{colspan:"2"}},[t._v("一、会议召集人："+t._s(t.confCollectBasicInfoView.collegeleader))])]),t._v(" "),i("tr",[i("td",{attrs:{colspan:"2"}},[t._v("二、上次会议所提议题/问题的解决情况")])]),t._v(" "),t._l(t.confLastIssueViewList,function(e,n){return i("tr",{key:"last_"+e.issuelastid},[i("td",{staticClass:"align-center",staticStyle:{width:"30px"}},[t._v(t._s(n+1))]),t._v(" "),i("td",[t._v(t._s(e.maincontent))])])}),t._v(" "),i("tr",[i("td",{attrs:{colspan:"2"}},[t._v("二、本次会议需决议的议题")])]),t._v(" "),t._l(t.confCurIssueViewsList,function(e,n){return i("tr",{key:"cur_"+e.issuecurrent},[i("td",{staticClass:"align-center",staticStyle:{width:"30px"}},[t._v(t._s(n+1))]),t._v(" "),i("td",[t._v(t._s(e.mainconent))])])}),t._v(" "),i("tr",[i("td",{attrs:{colspan:"2"}},[t._v("三、建议解决方案")])]),t._v(" "),t._l(t.confSuggestionViewList,function(e,n){return i("tr",{key:"sug_"+e.issuecurrent},[i("td",{staticClass:"align-center",staticStyle:{width:"30px"}},[t._v(t._s(n+1))]),t._v(" "),i("td",[t._v(t._s(e.maincontent))])])})],2),t._v(" "),i("div",{staticStyle:{"margin-top":"20px","text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:t.exportcollect}},[i("i",{staticClass:"el-icon-download"}),t._v("导出议题采集表\n                ")])],1)]),t._v(" "),i("el-tab-pane",{attrs:{label:"记录会议内容",name:"second"}},[i("el-row",{staticStyle:{"margin-top":"10px","margin-bottom":"10px"}},[i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:16}},[i("FlagPager",{attrs:{initindex:t.initPagerIndex,titles:t.confCurIssueViewsList,titlekey:"issuecurrent",titlevalue:"mainconent"},on:{triggerafter:t.handleAfter,triggerbefore:t.handleBefore}})],1),t._v(" "),i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:4}},[i("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"primary",icon:"el-icon-plus"},on:{click:t.newConfTitle}},[t._v("新增议题")])],1),t._v(" "),i("el-col",{attrs:{span:4}},[i("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"success",icon:"el-icon-success"},on:{click:t.endRecordConf}},[t._v("结束会议")])],1)],1),t._v(" "),i("div",{staticClass:"speechsection"},t._l(t.recordlist,function(e,n){return i("div",{key:n},[e.conftitle===t.curtitle?i("section",[i("el-form",[t._l(e.speachlist,function(s,o){return i("section",{key:o},[i("el-form-item",{staticStyle:{"margin-top":"20px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center"},attrs:{span:3}},[i("div",[i("svg-icon",{staticStyle:{"font-size":"40px"},attrs:{"icon-class":"fy_usr"}}),t._v(" "),i("br"),t._v(" "),i("span",{staticStyle:{display:"block","margin-top":"-20px"}},[t._v(t._s(s.speakername||"请选择发言人"))])],1)]),t._v(" "),i("el-col",{attrs:{span:13}},[i("el-input",{attrs:{rows:5,type:"textarea",placeholder:"请输入发言内容"},model:{value:s.content,callback:function(e){t.$set(s,"content",e)},expression:"uspeach.content"}})],1),t._v(" "),i("el-col",{attrs:{span:4}},[i("MRecorder",{on:{handleStop:function(e){t.handelEndRecord(e,n,o)}}})],1),t._v(" "),i("el-col",{attrs:{span:4}},[null==s.speechid?i("section",[i("el-button",{staticStyle:{float:"right","margin-top":"20px","margin-right":"20px"},attrs:{plain:"",type:"primary"},on:{click:function(e){t.handleSaveRecitem(n,o)}}},[t._v("保存")])],1):i("section",[i("el-button",{staticStyle:{float:"right","margin-top":"20px","margin-right":"20px"},attrs:{plain:"",type:"success"},on:{click:function(e){t.handleModifyRecitem(n,o)}}},[t._v("修改")])],1),t._v(" "),i("el-button",{staticStyle:{float:"right","margin-top":"20px","margin-right":"20px"},attrs:{plain:"",type:"danger"},on:{click:function(i){t.handleRemoveRecitem(n,o,e.recordid,s.speechid)}}},[t._v("删除")])],1)],1)],1),t._v(" "),t._l(s.audiolist,function(e,s){return i("section",{key:s},[i("el-card",{attrs:{shadow:"never"}},[i("el-row",[i("el-col",{attrs:{span:14}},[i("vue-audio-native",{attrs:{"show-current-time":!0,"show-controls":!1,"show-download":!0,autoplay:!1,"wait-buffer":!0,url:e.audiourl.url}})],1),t._v(" "),i("el-col",{staticStyle:{"text-align":"right"},attrs:{span:10}},[null==e.audioid?i("section",[i("el-button",{staticStyle:{float:"right","margin-right":"20px"},attrs:{type:"success",icon:"el-icon-upload",plain:"",circle:""},on:{click:function(e){t.handleUploadVoice(n,o,s)}}})],1):t._e(),t._v(" "),i("el-button",{staticStyle:{float:"right","margin-right":"20px"},attrs:{type:"danger",icon:"el-icon-delete",plain:"",circle:""},on:{click:function(e){t.handleRMVoice(n,o,s)}}})],1)],1)],1)],1)})],2)}),t._v(" "),t._l(t.confTitleConclusions,function(e,n){return i("section",{key:"curcon_"+n},[e.conftitlecnt==t.curtitle?i("section",[i("el-row",[i("el-col",{staticClass:"text-center",attrs:{span:3}},[t._v("议题结论")]),t._v(" "),i("el-col",{attrs:{span:21}},[i("el-input",{attrs:{rows:6,type:"textarea",placeholder:"请输入当前议题的结论"},model:{value:t.confTitleConclusions[n].conclusion,callback:function(e){t.$set(t.confTitleConclusions[n],"conclusion",e)},expression:"confTitleConclusions[conftitleindex].conclusion"}})],1)],1),t._v(" "),i("el-row",{staticStyle:{"margin-top":"30px"}},[i("el-col",{staticClass:"text-center",attrs:{span:24}},[i("el-button",{attrs:{type:"danger"},on:{click:function(e){t.sageCurTitleConclusion(n)}}},[t._v("保存议题结论")])],1)],1)],1):t._e()])})],2)],1):t._e()])}))],1)],1)],1)],1)],1)],1),t._v(" "),i("el-dialog",{attrs:{visible:t.dialogVisible,title:"新增议题",width:"40%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[i("div",[i("el-input",{attrs:{placeholder:"请输入议题内容",clearable:""},model:{value:t.newConftitleTXT,callback:function(e){t.newConftitleTXT=e},expression:"newConftitleTXT"}})],1),t._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(e){t.dialogVisible=!1}}},[t._v("取 消")]),t._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:t.handleAddConfTitle}},[t._v("确 定")])],1)])],1)},[],!1,null,"adb2e2b0",null));x.options.__file="index.vue";e.default=x.exports}}]);