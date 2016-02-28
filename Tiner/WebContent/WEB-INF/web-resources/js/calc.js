/**
 * 
 */
var rates = null;
var goodsInfo = [];
$(document).ready(function() {
	initTable();
	initCurrentRate();
	setGoodsInfo();
	
});

function setGoodsInfo(trELement){
	if(!trELement){
		trELement = $(".calc-body tr");
	}
	trELement.each(function(i,tr){
		var item = {};
		item.id = $(tr).find("input[name='id']");
		$(tr).find("td").each(function(index,td){
			
			var element = $(td).find("input,textarea");
			var value = "";
			var key = "";
			if(element.length > 0){
				key = element.attr("name");
				item[key] = {};
				item[key].element = element;
			}else{
				if($(td).hasClass("cnyPrice")){
					key = "cnyPrice";
				}else if($(td).hasClass("productProfit")){
					key = "productProfit";
				}else{
					key = "created";
				}
				item[key] = {};
				item[key].element = $(td);
			}
			
		});
		$(tr).attr("row",i);
		goodsInfo.push({
			status:0,
			items:item
		});
	});
}
/**
 * 初期化表格
 */
function initTable(){
	var tbody = $(".calc-body");
	var tr = $(".calc-body").find("tr.clone");

	var currentTR = tr;

	var setNowToFirstTd = function(tr) {
		tr.find("td:eq(0)").text(getNow());
	}
	setNowToFirstTd(currentTR);

	tbody.mousedown(function(event) {
		var current = $(event.target).parents("tr");
		currentTR.removeClass("active");
		current.addClass("active");
		currentTR = current;
	});

	$("#addRow").click(function() {
		var cloneTR = tr.clone();
		cloneTR.find("td.cnyPrice,td.cnyProfit").text("");
		cloneTR.find("input").val("");
		cloneTR.find("textarea").text("");
		cloneTR.removeClass("active");
		setNowToFirstTd(cloneTR);
		generatePriceChange(cloneTR);
		setGoodsInfo(cloneTR);
		cloneTR.attr("row",tbody.find("tr").length)
		tbody.append(cloneTR);
	});
	$("#delRow").click(function() {
		var row = currentTR.attr("row");
		goodsInfo[row].status = -1;
		currentTR.remove();
	});
	generatePriceChange(currentTR);
	
	$("#submit").click(function(){
		var list = [];
		for(var row in goodsInfo){
			var status = goodsInfo[row].status;
			var items = goodsInfo[row].items;
			var item = {};
			for(var key in items){
				var element = items[key].element;
				var value = null;
				if(element.is("input")){
					value = element.val();
				}else if(element.is("textarea")){
					value = element.text();
				}else if(element.is("td")){
					value = element.text();
				}
				item[key] = value;
			}
			item.status = status;
			list.push(item);
		}
		
		$("input[name='goodsJsonString']").val(JSON.stringify(list));
		$("#calcForm").submit();
	});
}

function generatePriceChange(trElem){

	trElem.find("input[name='jpyPrice'],input[name='quantity'],input[name='cnyDealPrice']").change(function(event){
		var tr = $(event.target).parents("tr");
		var jpyPrice = tr.find("input[name='jpyPrice']").val();
		var quantity = tr.find("input[name='quantity']").val();
		var cnyDealPrice = tr.find("input[name='cnyDealPrice']").val();
		
		if(jpyPrice != "" && quantity != ""){
			var cnyRate = $("span.rate").text();
			
			// 人民币价格计算
			var cnyPrice = new Number(parseFloat(rates.CNY) * parseInt(jpyPrice) * parseInt(quantity));
			cnyPrice =  cnyPrice.toFixed(2);
			
			tr.find("td.cnyPrice").text(cnyPrice);
			
			// 利润计算
			if(cnyDealPrice != ""){
				var profit = new Number(parseFloat(cnyDealPrice) - cnyPrice);
				
				tr.find("td.productProfit").text(profit.toFixed(2));
				if(profit < 0){
					tr.find("td.productProfit").addClass("minus");
				}
			}
		}
	});
}

function initCurrentRate(){
	// 取得当前汇率
	$.ajax({
		accepts : "application/json; charset=utf-8",
		url : "http://api.aoikujira.com/kawase/jsonp/jpy",
		dataType : "jsonp",
		type : "get",
		complete : function(data) {
			rates = callback();
			var cny = rates.CNY * 100;
			
			$("span.rate").text(cny);
		}

	});
}

function getNow() {
	var now = new Date();

	return $.datepicker.formatDate("yy-mm-d", now) + ' ' + now.getHours() + ':'
			+ now.getMinutes() + ':' + now.getSeconds();
}