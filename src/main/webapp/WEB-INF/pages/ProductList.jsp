<%--
  Created by IntelliJ IDEA.
  User: 33199
  Date: 2019/8/6
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/head.jsp" %>

<div id="content" class="span10">

    <div>
        <ul class="breadcrumb">
            <li><a href="javascript:void();">易制毒(爆)化学品统计</a> <span class="divider">/</span></li>
            <li><a href="javascript:void();">车间使用量</a></li>
        </ul>
    </div>

    <div class="row-fluid sortable">

        <div class="box span12">
            <div class="box-header well" data-original-title>
                <h2><i class="icon-th"></i> 车间使用量</h2>
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
                                            <th><input type="button" value="删除" id="btn"></th>
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
                            <div role="tabpanel" class="tab-pane" id="tabli2">
                                <%--<table id="tb_typetwo" class="table table-bordered hover compact"
                                       style="white-space: nowrap;width:100%;cursor:pointer"
                                       cellspacing="0"></table>--%>
                                <div class="box-content">
                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                        <thead>
                                        <tr>
                                            <th><input type="button" value="删除" id="myDelTrainBtn"></th>
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
                            <div role="tabpanel" class="tab-pane" id="tabli3">
                                <%--<table id="tb_typethree" class="table table-bordered hover compact"
                                       style="white-space: nowrap;width:100%;cursor:pointer"
                                       cellspacing="0"></table>--%>
                                <div class="box-content">
                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                        <thead>
                                        <tr>
                                            <th><input type="button" value="删除" id="myDelTrainBtn"></th>
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
                            <div role="tabpanel" class="tab-pane" id="tabli4">
                                <%--<table id="tb_typefour" class="table table-bordered hover compact"
                                       style="white-space: nowrap;width:100%;cursor:pointer"
                                       cellspacing="0"></table>--%>
                                <div class="box-content">
                                    <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                        <thead>
                                        <tr>
                                            <th><input type="button" value="删除" id="myDelTrainBtn"></th>
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
    </div>
</div>


<!-- 查看火车信息 -->
<div class="modal hide fade" id="viewTrainModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>火车车次详情</h3>
    </div>
    <div class="modal-body">

        <table class="table table-bordered bootstrap-datatable ">
            <tbody>
            <tr>
                <td>车次</td>
                <td id="trainNo"></td>
            </tr>
            <tr>
                <td>发车 —— 到达</td>
                <td><span id="trainStartStation"></span> ——
                    <span id="trainAarrivalStation"></span></td>
            </tr>
            <tr>
                <td>发时 —— 到时</td>
                <td><span id="trainStartTime"></span> ——
                    <span id="trainAarrivalTime"></span></td>
            </tr>
            <tr>
                <td>车型</td>
                <td id="trainType"></td>
            </tr>
            <tr>
                <td>运行时间（小时）</td>
                <td id="trainRuntime"></td>
            </tr>
            <tr>
                <td>里程（千米）</td>
                <td id="trainMile"></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn btn-primary" data-dismiss="modal">关闭</a>
    </div>
</div>


<!-- 添加信息的表单 -->
<div class="modal hide fade" id="addTrainDiv">
    <form action="product/addProduct.html" method="post" onsubmit="return addTrainFunction();">
        <div class="modal-header">
            <button type="button" class="close  addtraincancel" data-dismiss="modal">×</button>
            <h3>添加火车车次</h3>
        </div>
        <div class="modal-body">
            <ul id="add_formtip"></ul>
            <ul class="topul">
                <li><label>车次：</label><input type="text" id="a_trainNo" name="train_no" value=""/>
                    <span style="color:red;font-weight: bold;">*</span></li>
                <li><label>里程：</label><input type="text" id="a_trainMile" name="mile" value=""></li>
                <li><label>发车：</label><input type="text" id="a_trainStartStation" name="start_station" value="">
                    <span style="color:red;font-weight: bold;">*</span></li>
                <li><label>到达：</label><input type="text" id="a_trainArrStation" name="arrival_station" value="">
                    <span style="color:red;font-weight: bold;">*</span></li>
                <li><label>发时：</label><input type="text" id="a_trainStartTime" name="start_time" value="">
                    <span style="color:red;font-weight: bold;">*</span></li>
                <li><label>到时：</label><input type="text" id="a_trainArrTime" name="arrival_time" value="">
                    <span style="color:red;font-weight: bold;">*</span></li>
                <li><label>车型：</label><input type="text" id="a_trainType" name="type" value="">
                    <span style="color:red;font-weight: bold;">*</span></li>
                <li><label>运行时间：</label><input type="text" id="a_trainRuntime" name="runtime" value=""></li>
            </ul>
        </div>
        <div class="modal-footer">
            <a href="#" class="btn addtraincancel" data-dismiss="modal">关闭</a>
            <input type="submit" class="btn btn-primary" value="保存"/>
        </div>
    </form>
</div>


<%@include file="/WEB-INF/pages/foot.jsp" %>
