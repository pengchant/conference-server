(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-1b35"],{"4LaD":function(t,e,n){"use strict";var o={},r=function(t,e){var n="1.23452384164.123412415";if(void 0!==e){if(null!==document.getElementById(n)){var o=document.getElementById(n);o.parentNode.removeChild(o)}var r=e.offsetWidth,a=e.offsetHeight;e.style.position="relative";var c=document.createElement("canvas");c.width=390,c.height=200;var i=c.getContext("2d");i.rotate(-20*Math.PI/180),i.font="20px Vedana",i.fillStyle="rgba(200, 200, 200, 0.20)",i.textAlign="left",i.textBaseline="Middle",i.fillText(t,0,4*c.height/5);var s=document.createElement("div");return s.id=n,s.style.pointerEvents="none",s.style.top="0px",s.style.left="0px",s.style.position="absolute",s.style.zIndex="1000000",s.style.width=r+"px",s.style.height=a+"px",s.style.background="url("+c.toDataURL("image/png")+") left top repeat",e.appendChild(s),n}};o.set=function(t,e){var n=r(t,e);setInterval(function(){null===document.getElementById(n)&&(n=r(t,e))},500),window.onresize=function(){r(t,e)}},e.a=o},"50Zg":function(t,e,n){"use strict";var o=n("WkVB");n.n(o).a},ArKd:function(t,e,n){},QrNZ:function(t,e,n){"use strict";n.d(e,"g",function(){return r}),n.d(e,"f",function(){return a}),n.d(e,"e",function(){return c}),n.d(e,"r",function(){return i}),n.d(e,"i",function(){return s}),n.d(e,"b",function(){return d}),n.d(e,"d",function(){return u}),n.d(e,"c",function(){return l}),n.d(e,"h",function(){return f}),n.d(e,"a",function(){return m}),n.d(e,"k",function(){return _}),n.d(e,"q",function(){return v}),n.d(e,"m",function(){return p}),n.d(e,"o",function(){return h}),n.d(e,"n",function(){return b}),n.d(e,"l",function(){return g}),n.d(e,"s",function(){return y}),n.d(e,"j",function(){return w}),n.d(e,"p",function(){return C}),n.d(e,"t",function(){return O});var o=n("t3Un");function r(t){return Object(o.a)({url:"/order/queryrooms",method:"post",data:t})}function a(t){return Object(o.a)({url:"/order/queryconfroom/"+t,method:"post"})}function c(t){return Object(o.a)({url:"/order/querypeoples",method:"post",data:t})}function i(t){return Object(o.a)({url:"/order/sureSubOrder",method:"post",data:t})}function s(t){return Object(o.a)({url:"/record/"+t+"/loadconf",method:"post"})}function d(t){return Object(o.a)({url:"/record/"+t+"/exportconfcoll",method:"post",responseType:"blob"})}function u(t){return Object(o.a)({url:"/record/"+t+"/exportconfrecord",method:"post",responseType:"blob"})}function l(t){return Object(o.a)({url:"/record/"+t+"/exportDirconfrecord",method:"post",responseType:"blob"})}function f(t){return Object(o.a)({url:"/record/"+t+"/getAttendursts",method:"post"})}function m(t){return Object(o.a)({url:"/order/addNewRoom",method:"post",data:t})}function _(t){return Object(o.a)({url:"/order/modifyRoom",method:"post",data:t})}function v(t){return Object(o.a)({url:"/order/"+t+"/removeConfRoom",method:"post"})}function p(t){return Object(o.a)({url:"/order/queryorderedconf",method:"post",data:t})}function h(t){return Object(o.a)({url:"/order/"+t+"/queryorderdetail",method:"post"})}function b(t){return Object(o.a)({url:"/order/queryvaliconf",method:"post",data:t})}function g(t){return Object(o.a)({url:"/order/"+t+"/passOrderConf",method:"post"})}function y(t){return Object(o.a)({url:"/order/"+t+"/unpassOrderConf",method:"post"})}function w(t){return Object(o.a)({url:"/comm/getcurdepusr/"+t,method:"post"})}function C(t){return Object(o.a)({url:"/order/"+t+"/removeOrderConf",method:"post"})}function O(t){return Object(o.a)({url:"/order/"+t+"/flagInConference",method:"post"})}},WkVB:function(t,e,n){},lAbF:function(t,e,n){"use strict";n.r(e);var o=n("QbLZ"),r=n.n(o),a=n("4LaD"),c=n("L2JU"),i=n("t3Un");var s=n("QrNZ"),d={name:"Dashboard",data:function(){return{commingconf:[],myorderdata:[],tableData:[],dialogFormVisible:!1,confdetail:""}},computed:r()({},Object(c.b)(["name","roles","accid"])),created:function(){var t=this;(function(t){return Object(i.a)({url:"/order/"+t+"/allmyorder",method:"post"})})(this.accid).then(function(e){t.myorderdata=e.data}),function(t){return Object(i.a)({url:"/order/"+t+"/commingConf",method:"post"})}(this.accid).then(function(e){t.commingconf=e.data})},mounted:function(){a.a.set("高校党政云记录管理平台 "+this.name,this.$refs.dashboard_ref)},methods:{handleComingConf:function(t,e){var n=this;(console.log(e),"3"===String(e.statusid))?this.$router.push("/confrecord/recconf?confid="+e.confid):new Date<new Date(e.starttime)?this.$confirm("距离预约还有一段时间，您是否提前开会?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"info"}).then(function(){Object(s.t)(e.confid).then(function(t){t.ok?n.$router.push("/confrecord/recconf?confid="+e.confid):n.$message.error("操作失败，请稍后重试!")})}).catch(function(){}):Object(s.t)(e.confid).then(function(t){t.ok?n.$router.push("/confrecord/recconf?confid="+e.confid):n.$message.error("操作失败，请稍后重试!")})},goseeorder:function(){this.$router.push({path:"/order/orderedconf"})},handleShow:function(t){return String(t)===String(this.accid)},handleDetailView:function(t,e){var n=this;Object(s.o)(e.confid).then(function(t){n.confdetail=t.data}),this.dialogFormVisible=!0},formattime:function(t){return t.substr(0,16)}}},u=(n("50Zg"),n("q01G"),n("KHd+")),l=Object(u.a)(d,function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{ref:"dashboard_ref",staticClass:"dashboard-container"},[n("el-row",{attrs:{gutter:20}},[n("el-col",{attrs:{span:12}},[n("el-card",{staticClass:"box-card",attrs:{"body-style":{padding:"0px"}}},[n("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[n("span",{staticStyle:{color:"#F56C6C"}},[n("svg-icon",{attrs:{"icon-class":"shalou"}}),t._v(" 即将开始的会议\n          ")],1)]),t._v(" "),n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.commingconf,"show-header":!1,border:""}},[n("el-table-column",{scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[n("svg-icon",{attrs:{"icon-class":"red_dt"}}),t._v("\n                "+t._s(e.row.confname)+"\n              ")],1)]}}])}),t._v(" "),n("el-table-column",{scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{staticStyle:{color:"green"}},[t._v("开始时间: "+t._s(e.row.starttime&&e.row.starttime.substr(0,16)))])]}}])}),t._v(" "),n("el-table-column",{attrs:{width:"100",prop:"confstatus"}}),t._v(" "),n("el-table-column",{attrs:{width:"190",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t.handleShow(e.row.recorderid)?n("span",[n("el-button",{attrs:{type:"danger",size:"mini"},on:{click:function(n){t.handleComingConf(e.$index,e.row)}}},[t._v("开始/继续")])],1):t._e(),t._v(" "),n("el-button",{attrs:{type:"success",size:"mini"},on:{click:function(n){t.handleDetailView(e.$index,e.row)}}},[t._v("查看详情")])]}}])})],1)],1)],1),t._v(" "),n("el-col",{attrs:{span:12}},[n("el-card",{staticClass:"box-card",attrs:{"body-style":{padding:"0px"}}},[n("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[n("span",{staticStyle:{color:"#409EFF"}},[n("svg-icon",{attrs:{"icon-class":"rili"}}),t._v(" 我的预约\n          ")],1)]),t._v(" "),n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.myorderdata,"show-header":!1,border:""}},[n("el-table-column",{scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[n("svg-icon",{attrs:{"icon-class":"blue_dt"}}),t._v("\n                "+t._s(e.row.confname)+"\n              ")],1)]}}])}),t._v(" "),n("el-table-column",{attrs:{width:"80",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.row.confstatus))])]}}])}),t._v(" "),n("el-table-column",{attrs:{width:"140",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(n){t.goseeorder(e.$index,e.row)}}},[t._v("查看我的预约")])]}}])})],1)],1)],1)],1),t._v(" "),n("el-dialog",{attrs:{visible:t.dialogFormVisible,width:"60%",title:"预约会议详情"},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[void 0!=t.confdetail?n("section",[n("table",{staticClass:"mytable",attrs:{border:"0",cellspacing:"0",cellpadding:"0"}},[n("tr",[n("td",[t._v("会议名称")]),t._v(" "),n("td",[t._v(t._s(t.confdetail?t.confdetail.basicConfInfoView.confname:""))]),t._v(" "),n("td",[t._v("会议地点")]),t._v(" "),n("td",[t._v(t._s(t.confdetail?t.confdetail.basicConfInfoView.roomname:""))])]),t._v(" "),n("tr",[n("td",[t._v("开始时间")]),t._v(" "),n("td",[t._v(t._s(t.formattime(t.confdetail?t.confdetail.basicConfInfoView.starttime:"")))]),t._v(" "),n("td",[t._v("结束时间")]),t._v(" "),n("td",[t._v(t._s(t.formattime(t.confdetail?t.confdetail.basicConfInfoView.endtime:"")))])]),t._v(" "),n("tr",[n("td",[t._v("会议类别")]),t._v(" "),n("td",[t._v(t._s(t.confdetail?t.confdetail.basicConfInfoView.levelname:""))]),t._v(" "),n("td",[t._v("会议属性")]),t._v(" "),n("td",t._l(t.confdetail.confattrs,function(e){return n("el-tag",{key:e.attrdes,staticStyle:{"margin-right":"5px"}},[t._v(t._s(e.attrdes)+"  ")])}))]),t._v(" "),n("tr",[n("td",[t._v("参会人员")]),t._v(" "),n("td",{attrs:{colspan:"3"}},t._l(t.confdetail.attendersViews,function(e){return n("span",{key:e.workerid},[t._v(t._s(e.usrname)+" ")])}))]),t._v(" "),n("tr",[n("td",{attrs:{colspan:"4"}},[t._v("上次会议所提议题/问题的解决情况")])]),t._v(" "),t._l(t.confdetail.confLastIssueViewList,function(e,o){return n("tr",{key:"last_"+e.issuelastid},[n("td",{staticClass:"align-center"},[t._v(t._s(o+1))]),t._v(" "),n("td",{attrs:{colspan:"3"}},[t._v(t._s(e.maincontent))])])}),t._v(" "),n("tr",[n("td",{attrs:{colspan:"4"}},[t._v("本次会议需决议的议题")])]),t._v(" "),t._l(t.confdetail.confCurIssueViewsList,function(e,o){return n("tr",{key:"cur_"+e.issuecurrent},[n("td",{staticClass:"align-center"},[t._v(t._s(o+1))]),t._v(" "),n("td",{attrs:{colspan:"3"}},[t._v(t._s(e.mainconent))])])}),t._v(" "),n("tr",[n("td",{attrs:{colspan:"4"}},[t._v("建议解决方案")])]),t._v(" "),t._l(t.confdetail.confSuggestionViewList,function(e,o){return n("tr",{key:"sug_"+e.issuecurrent},[n("td",{staticClass:"align-center"},[t._v(t._s(o+1))]),t._v(" "),n("td",{attrs:{colspan:"3"}},[t._v(t._s(e.maincontent))])])})],2)]):t._e(),t._v(" "),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{attrs:{type:"success"},on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("确 定")])],1)])],1)},[],!1,null,"247913cc",null);l.options.__file="index.vue";e.default=l.exports},q01G:function(t,e,n){"use strict";var o=n("ArKd");n.n(o).a}}]);