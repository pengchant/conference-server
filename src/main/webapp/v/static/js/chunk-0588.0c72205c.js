(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-0588"],{HV3O:function(t,e,n){"use strict";n.r(e);var o=n("QbLZ"),r=n.n(o),a=n("L2JU"),i=n("QrNZ"),c={data:function(){return{currentPage:1,total:1e3,pageSize:10,multipleSelection:[],tableData:[],conditions:{order:"",sort:"",page:1,pagesize:10,search:{confname:"",endtime:"",startime:"",workerid:"0"}},dialogFormVisible:!1,confattrform:{id:"",attrname:"",attrdes:""},newFormVisible:!1,confdetail:""}},computed:r()({},Object(a.b)(["name","accid"])),created:function(){this.conditions.search.workerid=this.accid,this.fetchData()},methods:{handleSelectionChange:function(t){this.multipleSelection=t},handlecurrentchange:function(t){this.currentPage=t,this.conditions.page=t,this.fetchData()},fetchData:function(){var t=this;Object(i.n)(this.conditions).then(function(e){var n=e.data;t.tableData=n.list,t.total=n.total,t.currentPage=n.pageNum})},handleEdit:function(t,e){var n=this;Object(i.o)(e.conferenceid).then(function(t){n.confdetail=t.data}),this.dialogFormVisible=!0},conditionsearch:function(){this.fetchData()},formattime:function(t){return t.substr(0,16)},handlerSortchange:function(t){this.conditions.sort=t.prop,this.conditions.order="descending"===t.order?"desc":"ascending"===t.order?"asc":"",this.fetchData()},handlePass:function(t,e){var n=this;this.$confirm("将通过该会议的预约，通过后不可更改?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(i.l)(e.conferenceid).then(function(t){t.ok?(n.$message.success("执行成功!"),n.fetchData()):n.$message.error(t.msg)})}).catch(function(){n.$message({type:"info",message:"已取消"})})},handleUnpass:function(t,e){var n=this;this.$confirm("将不通过该会议的预约，操作后将不可更改?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(i.s)(e.conferenceid).then(function(t){t.ok?(n.$message.success("执行成功!"),n.fetchData()):n.$message.error(t.msg)})}).catch(function(){n.$message({type:"info",message:"已取消"})})}}},s=(n("ydmw"),n("KHd+")),l=Object(s.a)(c,function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticStyle:{width:"90%",margin:"0 auto"}},[n("div",{staticStyle:{"margin-top":"20px"}},[n("el-row",{attrs:{gutter:5}},[n("el-col",{attrs:{span:6}},[n("el-date-picker",{attrs:{type:"date",format:"yyyy-MM-dd","value-format":"yyyy-MM-dd",placeholder:"选择开始日期"},model:{value:t.conditions.search.startime,callback:function(e){t.$set(t.conditions.search,"startime",e)},expression:"conditions.search.startime"}})],1),t._v(" "),n("el-col",{attrs:{span:6}},[n("el-date-picker",{attrs:{type:"date",format:"yyyy-MM-dd","value-format":"yyyy-MM-dd",placeholder:"选择结束日期"},model:{value:t.conditions.search.entime,callback:function(e){t.$set(t.conditions.search,"entime",e)},expression:"conditions.search.entime"}})],1),t._v(" "),n("el-col",{attrs:{span:12}},[n("el-form",{staticStyle:{float:"right"},attrs:{inline:!0}},[n("el-form-item",[n("el-input",{attrs:{placeholder:"请输入会议关键字"},nativeOn:{keyup:function(e){return"button"in e||!t._k(e.keyCode,"enter",13,e.key,"Enter")?t.conditionsearch(e):null}},model:{value:t.conditions.search.confname,callback:function(e){t.$set(t.conditions.search,"confname",e)},expression:"conditions.search.confname"}})],1),t._v(" "),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:t.conditionsearch}},[t._v("查询")])],1)],1)],1)],1)],1),t._v(" "),n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData,height:"700",border:""},on:{"selection-change":t.handleSelectionChange,"sort-change":t.handlerSortchange}},[n("el-table-column",{attrs:{prop:"confname",label:"会议名称",sortable:"custom"}}),t._v(" "),n("el-table-column",{attrs:{prop:"levelname",sortable:"custom",label:"会议类别"}}),t._v(" "),n("el-table-column",{attrs:{prop:"recorder",sortable:"custom",label:"申请人"}}),t._v(" "),n("el-table-column",{attrs:{label:"请求时间",sortable:"custom",prop:"colltime"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(t.formattime(e.row.colltime)))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"操作",fixed:"right",width:"280"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{size:"mini",plain:"",type:"primary"},on:{click:function(n){t.handleEdit(e.$index,e.row)}}},[t._v("预约详情")]),t._v(" "),n("el-button",{attrs:{size:"mini",plain:"",type:"success"},on:{click:function(n){t.handlePass(e.$index,e.row)}}},[n("i",{staticClass:"el-icon-success",staticStyle:{color:"#67c23a"}}),t._v("通过")]),t._v(" "),n("el-button",{attrs:{size:"mini",plain:"",type:"danger"},on:{click:function(n){t.handleUnpass(e.$index,e.row)}}},[n("i",{staticClass:"el-icon-error",staticStyle:{color:"#F56C6C"}}),t._v("不通过")])]}}])})],1),t._v(" "),n("el-pagination",{attrs:{total:t.total,"page-size":t.pageSize,"current-page":t.currentPage,background:"",layout:"prev, pager, next"},on:{"current-change":t.handlecurrentchange}}),t._v(" "),n("el-dialog",{attrs:{visible:t.dialogFormVisible,width:"60%",title:"预约会议详情"},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[void 0!=t.confdetail?n("section",[n("table",{staticClass:"mytable",attrs:{border:"0",cellspacing:"0",cellpadding:"0"}},[n("tr",[n("td",[t._v("会议名称")]),t._v(" "),n("td",[t._v(t._s(t.confdetail?t.confdetail.basicConfInfoView.confname:""))]),t._v(" "),n("td",[t._v("会议地点")]),t._v(" "),n("td",[t._v(t._s(t.confdetail?t.confdetail.basicConfInfoView.roomname:""))])]),t._v(" "),n("tr",[n("td",[t._v("开始时间")]),t._v(" "),n("td",[t._v(t._s(t.formattime(t.confdetail?t.confdetail.basicConfInfoView.starttime:"")))]),t._v(" "),n("td",[t._v("结束时间")]),t._v(" "),n("td",[t._v(t._s(t.formattime(t.confdetail?t.confdetail.basicConfInfoView.endtime:"")))])]),t._v(" "),n("tr",[n("td",[t._v("会议类别")]),t._v(" "),n("td",[t._v(t._s(t.confdetail?t.confdetail.basicConfInfoView.levelname:""))]),t._v(" "),n("td",[t._v("会议属性")]),t._v(" "),n("td",t._l(t.confdetail.confattrs,function(e){return n("el-tag",{key:e.attrdes,staticStyle:{"margin-right":"5px"}},[t._v(t._s(e.attrdes)+"  ")])}))]),t._v(" "),n("tr",[n("td",[t._v("参会人员")]),t._v(" "),n("td",{attrs:{colspan:"3"}},t._l(t.confdetail.attendersViews,function(e){return n("span",{key:e.workerid},[t._v(t._s(e.usrname)+" ")])}))]),t._v(" "),n("tr",[n("td",{attrs:{colspan:"4"}},[t._v("上次会议所提议题/问题的解决情况")])]),t._v(" "),t._l(t.confdetail.confLastIssueViewList,function(e,o){return n("tr",{key:"last_"+e.issuelastid},[n("td",{staticClass:"align-center"},[t._v(t._s(o+1))]),t._v(" "),n("td",{attrs:{colspan:"3"}},[t._v(t._s(e.maincontent))])])}),t._v(" "),n("tr",[n("td",{attrs:{colspan:"4"}},[t._v("本次会议需决议的议题")])]),t._v(" "),t._l(t.confdetail.confCurIssueViewsList,function(e,o){return n("tr",{key:"cur_"+e.issuecurrent},[n("td",{staticClass:"align-center"},[t._v(t._s(o+1))]),t._v(" "),n("td",{attrs:{colspan:"3"}},[t._v(t._s(e.mainconent))])])}),t._v(" "),n("tr",[n("td",{attrs:{colspan:"4"}},[t._v("建议解决方案")])]),t._v(" "),t._l(t.confdetail.confSuggestionViewList,function(e,o){return n("tr",{key:"sug_"+e.issuecurrent},[n("td",{staticClass:"align-center"},[t._v(t._s(o+1))]),t._v(" "),n("td",{attrs:{colspan:"3"}},[t._v(t._s(e.maincontent))])])})],2)]):t._e(),t._v(" "),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{attrs:{type:"warning"},on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("关 闭")])],1)]),t._v(" "),n("div",{staticStyle:{height:"50px"}})],1)},[],!1,null,"06fa1b56",null);l.options.__file="index.vue";e.default=l.exports},QrNZ:function(t,e,n){"use strict";n.d(e,"g",function(){return r}),n.d(e,"f",function(){return a}),n.d(e,"e",function(){return i}),n.d(e,"r",function(){return c}),n.d(e,"i",function(){return s}),n.d(e,"b",function(){return l}),n.d(e,"d",function(){return d}),n.d(e,"c",function(){return u}),n.d(e,"h",function(){return f}),n.d(e,"a",function(){return m}),n.d(e,"k",function(){return p}),n.d(e,"q",function(){return h}),n.d(e,"m",function(){return _}),n.d(e,"o",function(){return v}),n.d(e,"n",function(){return b}),n.d(e,"l",function(){return g}),n.d(e,"s",function(){return y}),n.d(e,"j",function(){return w}),n.d(e,"p",function(){return O}),n.d(e,"t",function(){return k});var o=n("t3Un");function r(t){return Object(o.a)({url:"/order/queryrooms",method:"post",data:t})}function a(t){return Object(o.a)({url:"/order/queryconfroom/"+t,method:"post"})}function i(t){return Object(o.a)({url:"/order/querypeoples",method:"post",data:t})}function c(t){return Object(o.a)({url:"/order/sureSubOrder",method:"post",data:t})}function s(t){return Object(o.a)({url:"/record/"+t+"/loadconf",method:"post"})}function l(t){return Object(o.a)({url:"/record/"+t+"/exportconfcoll",method:"post",responseType:"blob"})}function d(t){return Object(o.a)({url:"/record/"+t+"/exportconfrecord",method:"post",responseType:"blob"})}function u(t){return Object(o.a)({url:"/record/"+t+"/exportDirconfrecord",method:"post",responseType:"blob"})}function f(t){return Object(o.a)({url:"/record/"+t+"/getAttendursts",method:"post"})}function m(t){return Object(o.a)({url:"/order/addNewRoom",method:"post",data:t})}function p(t){return Object(o.a)({url:"/order/modifyRoom",method:"post",data:t})}function h(t){return Object(o.a)({url:"/order/"+t+"/removeConfRoom",method:"post"})}function _(t){return Object(o.a)({url:"/order/queryorderedconf",method:"post",data:t})}function v(t){return Object(o.a)({url:"/order/"+t+"/queryorderdetail",method:"post"})}function b(t){return Object(o.a)({url:"/order/queryvaliconf",method:"post",data:t})}function g(t){return Object(o.a)({url:"/order/"+t+"/passOrderConf",method:"post"})}function y(t){return Object(o.a)({url:"/order/"+t+"/unpassOrderConf",method:"post"})}function w(t){return Object(o.a)({url:"/comm/getcurdepusr/"+t,method:"post"})}function O(t){return Object(o.a)({url:"/order/"+t+"/removeOrderConf",method:"post"})}function k(t){return Object(o.a)({url:"/order/"+t+"/flagInConference",method:"post"})}},"f6+G":function(t,e,n){},ydmw:function(t,e,n){"use strict";var o=n("f6+G");n.n(o).a}}]);