function displayEchartsData(documentId, showData, allData){
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById(documentId));
    // 指定图表的配置项和数据
    var option = {
        tooltip: {
            trigger: 'axis',
            formatter: formatterBySort
        },
        legend: {
            data: allData.legend
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: allData.xAxis
        },
        yAxis: {
            type: 'value'
        }
    };
    var sData = showData;
    var series = new Array(allData.legend.length);
    for ( var i = 0 ; i < allData.legend.length; i++ ){
        var obj = {
            name: allData.legend[i],
            type: "line",
            data: sData[allData.legend[i]]
        }
        series[i] = obj;
    }
    option['series'] = series;
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

function unSelectAllLegend(documentId, legendList){
    var myChart = echarts.init(document.getElementById(documentId));
    for ( var i = 0 ; i < legendList.length; i++ ){
        myChart.dispatchAction({type: 'legendUnSelect',name: legendList[i]});
    }
}

function selectAllLegend(documentId, legendList){
    var myChart = echarts.init(document.getElementById(documentId));
    for ( var i = 0 ; i < legendList.length; i++ ){
        myChart.dispatchAction({type: 'legendSelect',name: legendList[i]});
    }
}

function formatterBySort(allData){
    var html = "";
    var dataName = "";
    var sumValue = 0;
    allData.sort(sortMethod);
    for ( var i = 0 ; i < allData.length ; i++ ){
        var data = allData[i];
        dataName = data.name;
        sumValue += data.value;
        html += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:' + data.color + '"></span>' + data.seriesName + '：' + data.value + '<br/>'
    }
    return dataName + " - 累计："+ sumValue +"<br>" + html;
}

function sortMethod(k1, k2){
    return k2.data - k1.data;
}