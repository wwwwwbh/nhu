/*将DataTables的数据源转换成json格式的字符串*/
function datatableDataToJsonString(data)
{
    var jsonString = "[";
    var dataLength = data.length;
    $.each(data, function (index, obj) {
        jsonString += JSON.stringify(obj);
        if (index < dataLength - 1) {
            jsonString += ",";
        }
    });
    if (jsonString != "") {
        jsonString = jsonString.replace("undefined", "");
    }
    jsonString += "]";
    return jsonString;
}