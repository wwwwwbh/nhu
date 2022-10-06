<%--
  Created by IntelliJ IDEA.
  User: 33199
  Date: 2019/8/12
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/head.jsp" %>

<div id="content" class="span10">

    <div>
        <ul class="breadcrumb">
            <li><a href="javascript:void();">易制毒(爆)化学品统计</a> <span class="divider">/</span></li>
            <li><a href="javascript:void();">仓库出库</a></li>
        </ul>
    </div>

    <div class="row-fluid sortable">

        <div class="box span12">
            <div class="box-header well" data-original-title>
                <h2><i class="icon-th"></i> 仓库出库</h2>
                <div class="box-icon"><span class="btn btn-small btn-primary addTrain">
								<i class="icon-plus icon-white"></i> 添加 </span>
                </div>

            </div>
            <div class="row-fluid sortable">
                <!--导航区，四个类型的-->
                <div class="tabbable table-bordered">
                    <div class="tabbable">
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#tabli1" role="tab" data-toggle="tab">${typeArr[0]}</a>
                            </li>
                            <li role="presentation">
                                <a href="#tabli2" role="tab" data-toggle="tab">${typeArr[1]}</a>
                            </li>
                            <li role="presentation">
                                <a href="#tabli3" role="tab" data-toggle="tab">${typeArr[2]}</a>
                            </li>
                            <li role="presentation">
                                <a href="#tabli4" role="tab" data-toggle="tab">${typeArr[3]}</a>
                            </li>
                        </ul>
                        <!--标签页，四个类型的-->
                        <div class="tab-content" style="margin-top:20px">
                            <div role="tabpanel" class="tab-pane active" id="tabli1">
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
                                                <td><input type="checkbox" class="checkbox" name="delTrain" value="${ckList.userid }"></td>
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
                            <div role="tabpanel" class="tab-pane" id="tabli2">
                                <%--<table id="tb_typetwo" class="table table-bordered hover compact"
                                       style="white-space: nowrap;width:100%;cursor:pointer"
                                       cellspacing="0"></table>--%>
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
                                                <td><input type="checkbox" class="checkbox" name="delTrain" value="${ckList2.userid }"></td>
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
                            <div role="tabpanel" class="tab-pane" id="tabli3">
                                <%--<table id="tb_typethree" class="table table-bordered hover compact"
                                       style="white-space: nowrap;width:100%;cursor:pointer"
                                       cellspacing="0"></table>--%>
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
                                                <td><input type="checkbox" class="checkbox" name="delTrain" value="${ckList3.userid }"></td>
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
                            <div role="tabpanel" class="tab-pane" id="tabli4">
                                <%--<table id="tb_typefour" class="table table-bordered hover compact"
                                       style="white-space: nowrap;width:100%;cursor:pointer"
                                       cellspacing="0"></table>--%>
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
                                                <td><input type="checkbox" class="checkbox" name="delTrain" value="${ckList4.userid }"></td>
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
    </div>
</div>

<%@include file="/WEB-INF/pages/foot.jsp" %>
