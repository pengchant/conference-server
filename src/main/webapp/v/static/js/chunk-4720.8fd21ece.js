(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4720"],{"7hMs":function(t,e,n){},F9A0:function(t,e,n){"use strict";var i=n("QbLZ"),s=n.n(i),a=n("L2JU"),o=n("4LaD"),c={name:"ConfDetailView",props:{directconf:{type:Object,default:null}},computed:s()({},Object(a.b)(["name","roles"])),mounted:function(){o.a.set("高校党政云记录管理平台 "+this.name,this.$refs.confdetailview_ref)},methods:{handleArray:function(t){var e="";if(t instanceof Array)for(var n=0;n<t.length;n++)e+=t[n],n<t.length-1&&(e+=",");return e}}},r=(n("k0uz"),n("KHd+")),l=Object(r.a)(c,function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{ref:"confdetailview_ref",staticClass:"wrapper"},[null!==t.directconf?n("section",[n("table",{staticClass:"mtable",attrs:{border:"0",cellspacing:"0",cellpadding:"0"}},[n("tr",[n("td",[t._v("会议名称")]),t._v(" "),n("td",{attrs:{colspan:"5"}},[t._v("\n          "+t._s(t.directconf.confname)+"\n        ")])]),t._v(" "),n("tr",[n("td",[t._v("学期")]),t._v(" "),n("td",[t._v("\n          "+t._s(t.directconf.semester)+"\n        ")]),t._v(" "),n("td",[t._v("会议属性")]),t._v(" "),n("td",{attrs:{colspan:"3"}},[t._v("\n          "+t._s(t.handleArray(t.directconf.confattrsArray))+"\n        ")])]),t._v(" "),n("tr",[n("td",[t._v("会议类别")]),t._v(" "),n("td",[t._v("\n          "+t._s(t.directconf.conftype)+"\n        ")]),t._v(" "),n("td",[t._v("会议主持人")]),t._v(" "),n("td",[t._v("\n          "+t._s(t.directconf.hoster)+"\n        ")]),t._v(" "),n("td",[t._v("录入人")]),t._v(" "),n("td",[t._v("\n          "+t._s(t.directconf.recorder)+"\n        ")])]),t._v(" "),n("tr",[n("td",[t._v("会议地点")]),t._v(" "),n("td",[t._v("\n          "+t._s(t.directconf.confaddress)+"\n        ")]),t._v(" "),n("td",[t._v("开始时间")]),t._v(" "),n("td",[t._v("\n          "+t._s(t.directconf.starttime&&t.directconf.starttime.substr(0,16))+"\n        ")]),t._v(" "),n("td",[t._v("结束时间")]),t._v(" "),n("td",[t._v("\n          "+t._s(t.directconf.endtime&&t.directconf.endtime.substr(0,16))+"\n        ")])]),t._v(" "),n("tr",[n("td",[t._v("与会人员")]),t._v(" "),n("td",{attrs:{colspan:"5"}},[t._v("\n          "+t._s(t.handleArray(t.directconf.attendersArray))+"\n        ")])]),t._v(" "),n("tr",[n("td",[t._v("会议内容")]),t._v(" "),n("td",{attrs:{colspan:"5"}},[t._v("\n          "+t._s(t.directconf.conftext)+"\n        ")])]),t._v(" "),n("tr",[n("td",[t._v("会议结论")]),t._v(" "),n("td",{attrs:{colspan:"5"}},[t._v("\n          "+t._s(t.directconf.conclusion)+"\n        ")])])])]):t._e()])},[],!1,null,"5ad14a5e",null);l.options.__file="index.vue";e.a=l.exports},Zmvd:function(t,e,n){},k0uz:function(t,e,n){"use strict";var i=n("7hMs");n.n(i).a},"o0n+":function(t,e,n){"use strict";n.r(e);var i=n("QbLZ"),s=n.n(i),a=n("iCc5"),o=n.n(a),c=n("L2JU"),r=n("F9A0"),l=n("DkQT"),d=n("V+NQ"),u=n("QrNZ"),f=function t(e,n,i){o()(this,t),this.recordid=e,this.conftitle=n,this.speachlist=i||[]},v=function t(e,n,i,s,a){o()(this,t),this.speakerid=e,this.speakername=n,this.content=i,this.audiolist=s||[],this.speechid=a},_=function t(e,n,i){o()(this,t),this.audioid=e,this.audiourl=n,this.description=i},p={components:{MRecorder:l.a,ConfDetailView:r.a},data:function(){return{currentPage:1,total:1e3,pageSize:10,multipleSelection:[],tableData:[],conditions:{order:"",sort:"",page:1,pagesize:10,search:{confname:"",endtime:"",startime:"",workerid:""}},dialogFormVisible:!1,dialogRecordFormVisible:!1,confattrform:{id:"",attrname:"",attrdes:""},newFormVisible:!1,activeName:"first",attendersViews:[],tinymceHtml:"",curtitle:"",recordlist:[],confCurIssueViewsList:[],confdetail:"",confTitleConclusions:[],directflag:0,curconfrecorddetail:{}}},computed:s()({},Object(c.b)(["name","accid"])),mounted:function(){},created:function(){this.conditions.search.workerid=this.accid,this.fetchData()},methods:{handleSelectionChange:function(t){this.multipleSelection=t},handlecurrentchange:function(t){this.currentPage=t,this.conditions.page=t,this.fetchData()},fetchData:function(){var t=this;Object(d.e)(this.conditions).then(function(e){var n=e.data;t.tableData=n.list,t.total=n.total,t.currentPage=n.pageNum})},handleEdit:function(t,e){var n=this;Object(u.o)(e.conferenceid).then(function(t){n.confdetail=t.data}),this.dialogFormVisible=!0},handleRecord:function(t,e){var n=this;"0"===e.meetcollectid?(this.directflag=1,this.dialogRecordFormVisible=!0,Object(d.d)(e.conferenceid).then(function(t){n.curconfrecorddetail=t.data})):(this.directflag=0,this.queryConfDetail(e.conferenceid),this.dialogRecordFormVisible=!0)},conditionsearch:function(){this.fetchData()},formattime:function(t){return t.substr(0,16)},handlerSortchange:function(t){this.conditions.sort=t.prop,this.conditions.order="descending"===t.order?"desc":"ascending"===t.order?"asc":"",this.fetchData()},handlePass:function(t,e){var n=this;this.$confirm("是否确认通过审核?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"info"}).then(function(){"0"===e.meetcollectid?(console.log("处理通过会议",e.conferenceid),Object(d.k)(e.conferenceid).then(function(t){t.ok?(n.$message.success("操作成功"),n.fetchData()):n.$message.error(t.msg)})):Object(d.l)(e.conferenceid).then(function(t){t.ok?(n.$message({type:"success",message:"通过成功!"}),n.fetchData()):n.$message({type:"error",message:t.msg})})}).catch(function(){})},handleUnpass:function(t,e){var n=this;this.$confirm("是否确认不通过审核?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"info"}).then(function(){"0"===e.meetcollectid?(console.log("处理不通过会议",e.conferenceid),Object(d.s)(e.conferenceid).then(function(t){t.ok?(n.$message.success("操作成功"),n.fetchData()):n.$message.error(t.msg)})):Object(d.t)(e.conferenceid).then(function(t){t.ok?(n.$message({type:"success",message:"审核成功!"}),n.fetchData()):n.$message({type:"error",message:t.msg})})}).catch(function(){})},queryConfDetail:function(t){var e=this,n=this;Object(u.i)(t).then(function(t){if(t.ok){var i=t.data;e.basicConfInfoView=i.basicConfInfoView,e.tinymceHtml=e.basicConfInfoView.conclusion,e.attendersViews=i.attendersViews,e.confattrs=i.confattrs,e.confCurIssueViewsList=i.confCurIssueViewsList,e.curtitle=e.confCurIssueViewsList[0].mainconent,e.confTitleConclusions=i.confTitleViewList;for(var s=i.confRecVoicDetailViewList,a=s.length,o=e.recordlist,c=0;c<a;c++)if(null!=s[c].recordid){var r=0,l=0;for(l=0;l<o.length;l++)if(s[c].titlename===o[l].conftitle){r=1;break}if(0===r&&null!=s[c].recordid){var u=new f(s[c].titleid,s[c].titlename,[]);e.recordlist.push(u),l=e.recordlist.length-1}if(null!=s[c].speakerid){var p=0,m=o[l].speachlist,h=0;for(h=0;h<m.length;h++)if(s[c].recordid===m[h].speechid){p=1;break}if(0===p&&null!=s[c].speakerid){var b=new v(s[c].speakerid,s[c].speakername,s[c].speaking,[],s[c].recordid);e.recordlist[l].speachlist.push(b),h=e.recordlist[l].speachlist.length-1}if(null!=s[c].voiceid){var g=s[c].voiceid,y=s[c].voiceurl;if(null!=g){var w=new _(g,Object(d.c)(y),"");n.recordlist[l].speachlist[h].audiolist.push(w)}}}}}else e.$message.error(t.msg)})}}},m=(n("tKFb"),n("KHd+")),h=Object(m.a)(p,function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticStyle:{width:"90%",margin:"0 auto"}},[n("div",{staticStyle:{"margin-top":"20px"}},[n("el-row",{attrs:{gutter:5}},[n("el-col",{attrs:{span:6}},[n("el-date-picker",{attrs:{type:"date",format:"yyyy-MM-dd","value-format":"yyyy-MM-dd",placeholder:"选择开始日期"},model:{value:t.conditions.search.startime,callback:function(e){t.$set(t.conditions.search,"startime",e)},expression:"conditions.search.startime"}})],1),t._v(" "),n("el-col",{attrs:{span:6}},[n("el-date-picker",{attrs:{type:"date",format:"yyyy-MM-dd","value-format":"yyyy-MM-dd",placeholder:"选择结束日期"},model:{value:t.conditions.search.endtime,callback:function(e){t.$set(t.conditions.search,"endtime",e)},expression:"conditions.search.endtime"}})],1),t._v(" "),n("el-col",{attrs:{span:12}},[n("el-form",{staticStyle:{float:"right"},attrs:{inline:!0}},[n("el-form-item",[n("el-input",{attrs:{placeholder:"请输入会议关键字"},nativeOn:{keyup:function(e){return"button"in e||!t._k(e.keyCode,"enter",13,e.key,"Enter")?t.conditionsearch(e):null}},model:{value:t.conditions.search.confname,callback:function(e){t.$set(t.conditions.search,"confname",e)},expression:"conditions.search.confname"}})],1),t._v(" "),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:t.conditionsearch}},[t._v("查询")])],1)],1)],1)],1)],1),t._v(" "),n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData,height:"650",border:""},on:{"selection-change":t.handleSelectionChange,"sort-change":t.handlerSortchange}},[n("el-table-column",{attrs:{prop:"confname",label:"会议名称",sortable:"custom"}}),t._v(" "),n("el-table-column",{attrs:{prop:"levelname",sortable:"custom",label:"会议类别"}}),t._v(" "),n("el-table-column",{attrs:{prop:"recorder",sortable:"custom",label:"申请人"}}),t._v(" "),n("el-table-column",{attrs:{label:"请求时间",sortable:"custom",prop:"colltime"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v(t._s(t.formattime(e.row.colltime)))]}}])}),t._v(" "),n("el-table-column",{attrs:{label:"操作",width:"380",fixed:"right",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return["0"!==e.row.meetcollectid?n("span",[n("el-button",{attrs:{size:"mini",plain:"",type:"primary"},on:{click:function(n){t.handleEdit(e.$index,e.row)}}},[t._v("预约详情")])],1):n("span",[n("div",{staticStyle:{width:"80px",display:"inline-block"}})]),t._v(" "),n("el-button",{attrs:{size:"mini",plain:"",type:"warning"},on:{click:function(n){t.handleRecord(e.$index,e.row)}}},[t._v("会议记录")]),t._v(" "),n("el-button",{attrs:{size:"mini",plain:"",type:"success"},on:{click:function(n){t.handlePass(e.$index,e.row)}}},[n("i",{staticClass:"el-icon-success"}),t._v(" 通过\n        ")]),t._v(" "),n("el-button",{attrs:{size:"mini",plain:"",type:"danger"},on:{click:function(n){t.handleUnpass(e.$index,e.row)}}},[n("i",{staticClass:"el-icon-error"}),t._v(" 不通过\n        ")])]}}])})],1),t._v(" "),n("el-pagination",{attrs:{total:t.total,"page-size":t.pageSize,"current-page":t.currentPage,background:"",layout:"prev, pager, next"},on:{"current-change":t.handlecurrentchange}}),t._v(" "),n("el-dialog",{attrs:{visible:t.dialogFormVisible,width:"60%",title:"预约会议详情"},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[void 0!=t.confdetail?n("section",[n("table",{staticClass:"mytable",attrs:{border:"0",cellspacing:"0",cellpadding:"0"}},[n("tr",[n("td",[t._v("会议名称")]),t._v(" "),n("td",[t._v(t._s(t.confdetail?t.confdetail.basicConfInfoView.confname:""))]),t._v(" "),n("td",[t._v("会议地点")]),t._v(" "),n("td",[t._v(t._s(t.confdetail?t.confdetail.basicConfInfoView.roomname:""))])]),t._v(" "),n("tr",[n("td",[t._v("开始时间")]),t._v(" "),n("td",[t._v(t._s(t.formattime(t.confdetail?t.confdetail.basicConfInfoView.starttime:"")))]),t._v(" "),n("td",[t._v("结束时间")]),t._v(" "),n("td",[t._v(t._s(t.formattime(t.confdetail?t.confdetail.basicConfInfoView.endtime:"")))])]),t._v(" "),n("tr",[n("td",[t._v("会议类别")]),t._v(" "),n("td",[t._v(t._s(t.confdetail?t.confdetail.basicConfInfoView.levelname:""))]),t._v(" "),n("td",[t._v("会议属性")]),t._v(" "),n("td",t._l(t.confdetail.confattrs,function(e){return n("el-tag",{key:e.attrdes,staticStyle:{"margin-right":"5px"}},[t._v(t._s(e.attrdes)+"  ")])}))]),t._v(" "),n("tr",[n("td",[t._v("参会人员")]),t._v(" "),n("td",{attrs:{colspan:"3"}},t._l(t.confdetail.attendersViews,function(e){return n("span",{key:e.workerid},[t._v(t._s(e.usrname)+" ")])}))]),t._v(" "),n("tr",[n("td",{attrs:{colspan:"4"}},[t._v("上次会议所提议题/问题的解决情况")])]),t._v(" "),t._l(t.confdetail.confLastIssueViewList,function(e,i){return n("tr",{key:"last_"+e.issuelastid},[n("td",{staticClass:"align-center"},[t._v(t._s(i+1))]),t._v(" "),n("td",{attrs:{colspan:"3"}},[t._v(t._s(e.maincontent))])])}),t._v(" "),n("tr",[n("td",{attrs:{colspan:"4"}},[t._v("本次会议需决议的议题")])]),t._v(" "),t._l(t.confdetail.confCurIssueViewsList,function(e,i){return n("tr",{key:"cur_"+e.issuecurrent},[n("td",{staticClass:"align-center"},[t._v(t._s(i+1))]),t._v(" "),n("td",{attrs:{colspan:"3"}},[t._v(t._s(e.mainconent))])])}),t._v(" "),n("tr",[n("td",{attrs:{colspan:"4"}},[t._v("建议解决方案")])]),t._v(" "),t._l(t.confdetail.confSuggestionViewList,function(e,i){return n("tr",{key:"sug_"+e.issuecurrent},[n("td",{staticClass:"align-center"},[t._v(t._s(i+1))]),t._v(" "),n("td",{attrs:{colspan:"3"}},[t._v(t._s(e.maincontent))])])})],2)]):t._e(),t._v(" "),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{attrs:{type:"success"},on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("确 定")])],1)]),t._v(" "),n("el-dialog",{attrs:{visible:t.dialogRecordFormVisible,width:"70%",title:"会议记录详情"},on:{"update:visible":function(e){t.dialogRecordFormVisible=e}}},[0==t.directflag?n("section",[n("el-tabs",{attrs:{type:"card"},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[n("el-tab-pane",{attrs:{label:"与会人员",name:"first"}},[n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.attendersViews,"show-header":!1,border:""}},[n("el-table-column",{attrs:{prop:"usrname"}}),t._v(" "),n("el-table-column",{attrs:{width:"180",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return["1"===e.row.hasattend?n("span",{staticStyle:{color:"#67C23A"}},[n("i",{staticClass:"el-icon-success"}),t._v(" 签到\n                ")]):n("span",{staticStyle:{color:"#F56C6C"}},[n("i",{staticClass:"el-icon-error"}),t._v(" 缺席\n                ")])]}}])})],1)],1),t._v(" "),n("el-tab-pane",{attrs:{label:"记录内容",name:"second"}},[n("el-row",{staticStyle:{"margin-top":"10px","margin-bottom":"10px"}},[n("el-col",{staticStyle:{"text-align":"center"},attrs:{span:3}},[n("span",{staticStyle:{"line-height":"37px"}},[t._v("选择会议议题")])]),t._v(" "),n("el-col",{attrs:{span:10}},[n("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择会议议题"},model:{value:t.curtitle,callback:function(e){t.curtitle=e},expression:"curtitle"}},t._l(t.confCurIssueViewsList,function(t){return n("el-option",{key:t.issuecurrent,attrs:{label:t.mainconent,value:t.mainconent}})}))],1)],1),t._v(" "),n("div",{staticClass:"speechsection"},t._l(t.recordlist,function(e,i){return n("div",{key:i},[e.conftitle===t.curtitle?n("section",[n("el-form",[t._l(e.speachlist,function(e,i){return n("section",{key:i},[n("el-form-item",{staticStyle:{"margin-top":"20px"}},[n("el-row",[n("el-col",{staticStyle:{"text-align":"center"},attrs:{span:3}},[n("div",[n("svg-icon",{staticStyle:{"font-size":"40px"},attrs:{"icon-class":"fy_usr"}}),t._v(" "),n("br"),t._v(" "),n("span",{staticStyle:{display:"block","margin-top":"-20px"}},[t._v(t._s(e.speakername||"请选择发言人"))])],1)]),t._v(" "),n("el-col",{attrs:{span:21}},[t._v(t._s(e.content))])],1)],1),t._v(" "),t._l(e.audiolist,function(t,e){return n("section",{key:e},[n("el-card",{attrs:{shadow:"never"}},[n("el-row",[n("el-col",{attrs:{span:24}},[n("vue-audio-native",{attrs:{"show-current-time":!0,"show-controls":!1,"show-download":!0,autoplay:!1,"wait-buffer":!0,url:t.audiourl.url}})],1)],1)],1)],1)})],2)}),t._v(" "),t._l(t.confTitleConclusions,function(e,i){return n("section",{key:"curcon_"+i},[e.conftitlecnt==t.curtitle?n("section",[n("el-row",{staticStyle:{"margin-top":"10px"}},[n("el-col",{staticClass:"text-center",attrs:{span:3}},[t._v("议题结论")]),t._v(" "),n("el-col",{attrs:{span:21}},[n("el-input",{attrs:{disabled:!0,rows:6,type:"textarea",placeholder:"当前暂无议题的结论"},model:{value:t.confTitleConclusions[i].conclusion,callback:function(e){t.$set(t.confTitleConclusions[i],"conclusion",e)},expression:"confTitleConclusions[conftitleindex].conclusion"}})],1)],1)],1):t._e()])})],2)],1):t._e()])}))],1)],1)],1):n("section",[n("ConfDetailView",{attrs:{directconf:t.curconfrecorddetail}})],1),t._v(" "),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{attrs:{type:"primary"},on:{click:function(e){t.dialogRecordFormVisible=!1}}},[t._v("确 定")])],1)]),t._v(" "),n("div",{staticStyle:{height:"50px"}})],1)},[],!1,null,"64d60eae",null);h.options.__file="index.vue";e.default=h.exports},tKFb:function(t,e,n){"use strict";var i=n("Zmvd");n.n(i).a}}]);