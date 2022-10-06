<%--
  Created by IntelliJ IDEA.
  User: 33199
  Date: 2019/8/6
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/head.jsp" %>
<%--保卫处--%>
<div id="content" class="span10">
    <%--导航页加标签页--%>
    <div class="row-fluid sortable" style="z-index:2">
        <div class="box span12" style="z-index:1">
            <div class="box-header well" data-original-titl>
                <h2><i class="icon-th"></i> 易制毒爆化学品统计</h2>
            </div>
            <%-- <div class="table-bordered">--%>

            <%-- </div>--%>
            <%--最外层导航区：车间使用量，车间领用量，车间库存，仓库入库，仓库出库，仓库库存，基础资料维护--%>
            <div class="tabbable table-bordered">
                <div class="tabbable">
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active">
                            <a href="#tabli1" role="tab" data-toggle="tab">车间使用量</a>
                        </li>
                        <li role="presentation">
                            <a href="#tabli2" role="tab" data-toggle="tab">车间领用量</a>
                        </li>
                        <li role="presentation">
                            <a href="#tabli3" role="tab" data-toggle="tab">车间库存</a>
                        </li>
                        <li role="presentation">
                            <a href="#tabli4" role="tab" data-toggle="tab">仓库入库</a>
                        </li>
                        <li role="presentation">
                            <a href="#tabli5" role="tab" data-toggle="tab">仓库出库</a>
                        </li>
                        <li role="presentation">
                            <a href="#tabli6" role="tab" data-toggle="tab">仓库库存</a>
                        </li>
                        <li role="presentation">
                            <a href="#tabli7" role="tab" data-toggle="tab">基础资料维护</a>
                        </li>
                    </ul>

                    <div class="clear"></div>
                    <div class="tab-content" style="margin-top:40px">
                        <div role="tabpanel" class="tab-pane active" id="tabli1">
                            <span class="btn btn-small btn-primary " style="float: right" id="btn_s_findDeptUsed"
                                  type="button"><i class="icon-search icon-white"></i> 查询</span>
                            <div class="row-fluid sortable">
                                <!--导航区，四个类型的-->
                                <div class="tabbable table-bordered">
                                    <div class="tabbable">
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li role="presentation" class="active">
                                                <a href="#tabli11" role="tab" data-toggle="tab">${typeArr[0]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli12" role="tab" data-toggle="tab">${typeArr[1]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli13" role="tab" data-toggle="tab">${typeArr[2]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli14" role="tab" data-toggle="tab">${typeArr[3]}</a>
                                            </li>
                                        </ul>
                                        <!--标签页，四个类型的-->
                                        <div class="tab-content" style="margin-top:20px">
                                            <div role="tabpanel" class="tab-pane active" id="tabli11">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn11"></th>
                                                            <th>日期</th>
                                                                <c:forEach items="${Col1}" var="colOne">
                                                                <th>${colOne.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>

                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli12">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn12"></th>
                                                            <th>日期</th>
                                                            <c:forEach items="${Col2}" var="colTwo">
                                                                <th>${colTwo.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli13">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn13"></th>
                                                            <th>日期</th>
                                                            <c:forEach items="${Col3}" var="colThree">
                                                                <th>${colThree.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli14">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn14"></th>
                                                            <th>日期</th>
                                                            <c:forEach items="${Col4}" var="colFour">
                                                                <th>${colFour.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="tabli2">
                            <div class="row-fluid sortable">
                                <!--导航区，四个类型的-->
                                <div class="tabbable table-bordered">
                                    <div class="tabbable">
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li role="presentation" class="active">
                                                <a href="#tabli21" role="tab" data-toggle="tab">${typeArr[0]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli22" role="tab" data-toggle="tab">${typeArr[1]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli23" role="tab" data-toggle="tab">${typeArr[2]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli24" role="tab" data-toggle="tab">${typeArr[3]}</a>
                                            </li>
                                        </ul>
                                        <!--标签页，四个类型的-->
                                        <div class="tab-content" style="margin-top:20px">
                                            <div role="tabpanel" class="tab-pane active" id="tabli21">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn21"></th>
                                                            <th>日期</th>
                                                            <th>产品名称</th>
                                                            <th>单位</th>
                                                            <th>领用量</th>
                                                            <th>是否接收</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>

                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli22">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn22"></th>
                                                            <th>日期</th>
                                                            <th>产品名称</th>
                                                            <th>单位</th>
                                                            <th>领用量</th>
                                                            <th>是否接收</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli23">
                                                <%--<table id="tb_typethree" class="table table-bordered hover compact"
                                                       style="white-space: nowrap;width:100%;cursor:pointer"
                                                       cellspacing="0"></table>--%>
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn23"></th>
                                                            <th>日期</th>
                                                            <th>产品名称</th>
                                                            <th>单位</th>
                                                            <th>领用量</th>
                                                            <th>是否接收</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli24">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn24"></th>
                                                            <th>日期</th>
                                                            <th>产品名称</th>
                                                            <th>单位</th>
                                                            <th>领用量</th>
                                                            <th>是否接收</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="tabli3">
                            <div class="row-fluid sortable">
                                <!--导航区，四个类型的-->
                                <div class="tabbable table-bordered">
                                    <div class="tabbable">
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li role="presentation" class="active">
                                                <a href="#tabli31" role="tab" data-toggle="tab">${typeArr[0]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli32" role="tab" data-toggle="tab">${typeArr[1]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli33" role="tab" data-toggle="tab">${typeArr[2]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli34" role="tab" data-toggle="tab">${typeArr[3]}</a>
                                            </li>
                                        </ul>
                                        <!--标签页，四个类型的-->
                                        <div class="tab-content" style="margin-top:20px">
                                            <div role="tabpanel" class="tab-pane active" id="tabli31">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn31"></th>
                                                            <th>部门</th>
                                                            <c:forEach items="${Col1}" var="colOne">
                                                                <th>${colOne.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>

                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli32">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn32"></th>
                                                            <th>部门</th>
                                                            <c:forEach items="${Col2}" var="colTwo">
                                                                <th>${colTwo.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli33">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn33"></th>
                                                            <th>部门</th>
                                                            <c:forEach items="${Col3}" var="colThree">
                                                                <th>${colThree.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli34">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn34"></th>
                                                            <th>部门</th>
                                                            <c:forEach items="${Col4}" var="colFour">
                                                                <th>${colFour.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="tabli4">
                            <div class="row-fluid sortable">
                                <!--导航区，四个类型的-->
                                <div class="tabbable table-bordered">
                                    <div class="tabbable">
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li role="presentation" class="active">
                                                <a href="#tabli41" role="tab" data-toggle="tab">${typeArr[0]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli42" role="tab" data-toggle="tab">${typeArr[1]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli43" role="tab" data-toggle="tab">${typeArr[2]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli44" role="tab" data-toggle="tab">${typeArr[3]}</a>
                                            </li>
                                        </ul>
                                        <!--标签页，四个类型的-->
                                        <div class="tab-content" style="margin-top:20px">
                                            <div role="tabpanel" class="tab-pane active" id="tabli41">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn41"></th>
                                                            <th>日期</th>
                                                            <c:forEach items="${Col1}" var="colOne">
                                                                <th>${colOne.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>

                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli42">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn42"></th>
                                                            <th>日期</th>
                                                            <c:forEach items="${Col2}" var="colTwo">
                                                                <th>${colTwo.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli43">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn43"></th>
                                                            <th>日期</th>
                                                            <c:forEach items="${Col3}" var="colThree">
                                                                <th>${colThree.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli44">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn44"></th>
                                                            <th>日期</th>
                                                            <c:forEach items="${Col4}" var="colFour">
                                                                <th>${colFour.productunitname}</th>
                                                            </c:forEach>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="tabli5">
                            <span class="btn btn-small btn-primary " style="float: right" id="btn_s_findCKUsed"
                                  type="button"><i class="icon-search icon-white"></i> 查询</span>
                            <div class="row-fluid sortable">
                                <!--导航区，四个类型的-->
                                <div class="tabbable table-bordered">
                                    <div class="tabbable">
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li role="presentation" class="active">
                                                <a href="#tabli51" role="tab" data-toggle="tab">${typeArr[0]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli52" role="tab" data-toggle="tab">${typeArr[1]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli53" role="tab" data-toggle="tab">${typeArr[2]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli54" role="tab" data-toggle="tab">${typeArr[3]}</a>
                                            </li>
                                        </ul>
                                        <!--标签页，四个类型的-->
                                        <div class="tab-content" style="margin-top:20px">
                                            <div role="tabpanel" class="tab-pane active" id="tabli51">
                                                <%--<table id="tb_typeone" class="table table-bordered hover compact"
                                                       style="white-space: nowrap;width:100%;cursor:pointer"
                                                       cellspacing="0"></table>--%>
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="Btn"></th>
                                                            <th>领用日期</th>
                                                            <th>领用部门</th>
                                                            <th>易制毒化学品</th>
                                                            <th>单位</th>
                                                            <th>领用数量</th>
                                                            <th>是否接受</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${CKUsedList1 }" var="ckList">
                                                            <tr>
                                                                <td><input type="checkbox" class="checkbox"
                                                                           name="delTrain" value="${ckList.userid }">
                                                                </td>
                                                                <td>${ckList.thedate }</td>
                                                                <td>${ckList.username}</td>
                                                                <td>${ckList.productname}</td>
                                                                <td>${ckList.unitname }</td>
                                                                <td>${ckList.chuku }</td>
                                                                <td>${ckList.isreceived }</td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>

                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli52">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="Btn2"></th>
                                                            <th>领用日期</th>
                                                            <th>领用部门</th>
                                                            <th>易制毒化学品</th>
                                                            <th>单位</th>
                                                            <th>领用数量</th>
                                                            <th>是否接受</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${CKUsedList2 }" var="ckList2">
                                                            <tr>
                                                                <td><input type="checkbox" class="checkbox"
                                                                           name="delTrain" value="${ckList2.userid }">
                                                                </td>
                                                                <td>${ckList2.thedate }</td>
                                                                <td>${ckList2.username}</td>
                                                                <td>${ckList2.productname}</td>
                                                                <td>${ckList2.unitname }</td>
                                                                <td>${ckList2.chuku }</td>
                                                                <td>${ckList2.isreceived }</td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli53">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="Btn3"></th>
                                                            <th>领用日期</th>
                                                            <th>领用部门</th>
                                                            <th>易制毒化学品</th>
                                                            <th>单位</th>
                                                            <th>领用数量</th>
                                                            <th>是否接受</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${CKUsedList3 }" var="ckList3">
                                                            <tr>
                                                                <td><input type="checkbox" class="checkbox"
                                                                           name="delTrain" value="${ckList3.userid }">
                                                                </td>
                                                                <td>${ckList3.thedate }</td>
                                                                <td>${ckList3.username}</td>
                                                                <td>${ckList3.productname}</td>
                                                                <td>${ckList3.unitname }</td>
                                                                <td>${ckList3.chuku }</td>
                                                                <td>${ckList3.isreceived }</td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli54">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="Btn4"></th>
                                                            <th>领用日期</th>
                                                            <th>领用部门</th>
                                                            <th>易制毒化学品</th>
                                                            <th>单位</th>
                                                            <th>领用数量</th>
                                                            <th>是否接受</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${CKUsedList4 }" var="ckList4">
                                                            <tr>
                                                                <td><input type="checkbox" class="checkbox"
                                                                           name="delTrain" value="${ckList4.userid }">
                                                                </td>
                                                                <td>${ckList4.thedate }</td>
                                                                <td>${ckList4.username}</td>
                                                                <td>${ckList4.productname}</td>
                                                                <td>${ckList4.unitname }</td>
                                                                <td>${ckList4.chuku }</td>
                                                                <td>${ckList4.isreceived }</td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="tabli6">
                            <div class="row-fluid sortable">
                                <!--导航区，四个类型的-->
                                <div class="tabbable table-bordered">
                                    <div class="tabbable">
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li role="presentation" class="active">
                                                <a href="#tabli61" role="tab" data-toggle="tab">${typeArr[0]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli62" role="tab" data-toggle="tab">${typeArr[1]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli63" role="tab" data-toggle="tab">${typeArr[2]}</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli64" role="tab" data-toggle="tab">${typeArr[3]}</a>
                                            </li>
                                        </ul>
                                        <!--标签页，四个类型的-->
                                        <div class="tab-content" style="margin-top:20px">
                                            <div role="tabpanel" class="tab-pane active" id="tabli61">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn61"></th>
                                                            <th>易制毒化学品名称</th>
                                                            <th>单位</th>
                                                            <th>库存量</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${CKListOne }" var="cklist1">
                                                            <tr>
                                                                <td><input type="checkbox" class="checkbox"
                                                                           name="delTrain"></td>
                                                                <td>${cklist.productname}</td>
                                                                <td>${cklist.unitname}</td>
                                                                <td>${cklist.amount}</td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>

                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli62">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn62"></th>
                                                            <th>易制毒化学品名称</th>
                                                            <th>单位</th>
                                                            <th>库存量</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${CKListTwo }" var="cklist2">
                                                            <tr>
                                                                <td><input type="checkbox" class="checkbox"
                                                                           name="delTrain"></td>
                                                                <td>${cklist.productname}</td>
                                                                <td>${cklist.unitname}</td>
                                                                <td>${cklist.amount}</td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli63">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn63"></th>
                                                            <th>易制毒化学品名称</th>
                                                            <th>单位</th>
                                                            <th>库存量</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${CKListThree }" var="cklist3">
                                                            <tr>
                                                                <td><input type="checkbox" class="checkbox"
                                                                           name="delTrain"></td>
                                                                <td>${cklist.productname}</td>
                                                                <td>${cklist.unitname}</td>
                                                                <td>${cklist.amount}</td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli64">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn64"></th>
                                                            <th>易制毒化学品名称</th>
                                                            <th>单位</th>
                                                            <th>库存量</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${CKListFour }" var="cklist4">
                                                            <tr>
                                                                <td><input type="checkbox" class="checkbox"
                                                                           name="delTrain"></td>
                                                                <td>${cklist.productname}</td>
                                                                <td>${cklist.unitname}</td>
                                                                <td>${cklist.amount}</td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="tabli7">
                            <div class="row-fluid sortable">
                                <!--导航区，四个类型的-->
                                <div class="tabbable table-bordered">
                                    <div class="tabbable">
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li role="presentation" class="active">
                                                <a href="#tabli71" role="tab" data-toggle="tab">部门</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli72" role="tab" data-toggle="tab">物料类型</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli73" role="tab" data-toggle="tab">物料单位</a>
                                            </li>
                                            <li role="presentation">
                                                <a href="#tabli74" role="tab" data-toggle="tab">物料</a>
                                            </li>
                                        </ul>
                                        <!--标签页，四个类型的-->
                                        <div class="tab-content" style="margin-top:20px">
                                            <div role="tabpanel" class="tab-pane active" id="tabli71">
                                                <%--<table id="tb_typeone" class="table table-bordered hover compact"
                                                       style="white-space: nowrap;width:100%;cursor:pointer"
                                                       cellspacing="0"></table>--%>
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th>部门名称</th>
                                                            <th>是否生效</th>
                                                            <th><input type="button" value="删除" id="btn71"></th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <!-- 数据 -->
                                                        </tbody>
                                                    </table>
                                                </div>

                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli72">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn72"></th>
                                                            <th>物料类型名称</th>
                                                            <th>是否生效</th>
                                                            <th></th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <!-- 数据 -->
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli73">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn73"></th>
                                                            <th>物料单位名称</th>
                                                            <th>是否生效</th>
                                                            <th></th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <!-- 数据 -->
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="tabli74">
                                                <div class="box-content">
                                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                        <thead>
                                                        <tr>
                                                            <th><input type="button" value="删除" id="btn74"></th>
                                                            <th>物料名称</th>
                                                            <th>是否生效</th>
                                                            <th></th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <!-- 数据 -->
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<form class="form-inline" role="form" style="height: 30px">
    <div class="form-group" style="float: left">
        <span>年份</span>
        <select id="year">

        </select>

    <span>月份</span>
    <select id="month">

    </select>
    <span>部门</span>
    <select id="dept">
        <c:forEach items="${deptArr }" var="dept">
            <option value= ${dept} >${dept}</option>
        </c:forEach>
    </select>
    </div>
</form>
<button id="sethtml">设置html</button>
<button id="clearhtml">清空html</button>
<%@include file="/WEB-INF/pages/foot.jsp" %>
