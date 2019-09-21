<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html class="x-admin-sm">
    <head>
             
    </head>

    <body>
      <form action="Servletspot?op=update2" method="post">
      		<table>
      			<tr>
      				<td>
      					景区名称
      				</td>
      				<td>
      					<input type="text" name="spotname" value="${ s.spotname }" />
      					<input type="hidden" name="spotid" value="${ s.spotid }" />
      				</td>
      			</tr>
      			
      			<tr>
      				<td>
      					景区信息
      				</td>
      				<td>
      					<input type="text" name="spotcontext" value="${ s.spotcontext }" />
      				</td>
      			</tr>
      			
      			
      			<tr>
      				<td colspan="2" align="center">
      					<input type="submit" value="修改" />
      				</td>
      			</tr>
      		</table>
      </form>
       
       
       
       
        <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
        <script type="text/javascript">
        // åºäºåå¤å¥½çdomï¼åå§åechartså®ä¾
        var myChart = echarts.init(document.getElementById('main'));

        // æå®å¾è¡¨çéç½®é¡¹åæ°æ®
        var option = {
            title: {
                text: 'åºç¡é·è¾¾å¾'
            },
            tooltip: {},
            legend: {
                data: ['é¢ç®åéï¼Allocated Budgetï¼', 'å®éå¼éï¼Actual Spendingï¼']
            },
            radar: {
                // shape: 'circle',
                indicator: [
                   { name: 'éå®ï¼salesï¼', max: 6500},
                   { name: 'ç®¡çï¼Administrationï¼', max: 16000},
                   { name: 'ä¿¡æ¯ææ¯ï¼Information Techologyï¼', max: 30000},
                   { name: 'å®¢æï¼Customer Supportï¼', max: 38000},
                   { name: 'ç åï¼Developmentï¼', max: 52000},
                   { name: 'å¸åºï¼Marketingï¼', max: 25000}
                ]
            },
            series: [{
                name: 'é¢ç® vs å¼éï¼Budget vs spendingï¼',
                type: 'radar',
                // areaStyle: {normal: {}},
                data : [
                    {
                        value : [4300, 10000, 28000, 35000, 50000, 19000],
                        name : 'é¢ç®åéï¼Allocated Budgetï¼'
                    },
                     {
                        value : [5000, 14000, 28000, 31000, 42000, 21000],
                        name : 'å®éå¼éï¼Actual Spendingï¼'
                    }
                ]
            }]
        };

        // ä½¿ç¨åæå®çéç½®é¡¹åæ°æ®æ¾ç¤ºå¾è¡¨ã
        myChart.setOption(option);
    </script>
    <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
    </body>
</html>
