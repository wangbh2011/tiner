/**
 * 
 */

$(document).ready(function(){
	
	var tbody = $(".calc-body");
	var tr = $(".calc-body").find("tr:eq(0)");
	
	
	
	
	var currentTR = tr;
	
	var setNowToFirstTd = function(tr){
		tr.find("td:eq(0)").text(getNow());
	}
	setNowToFirstTd(currentTR);
	
	tbody.mousedown(function(event){
		var current = $(event.target).parents("tr");
		currentTR.removeClass("active");
		current.addClass("active");
		currentTR = current;
	});
	
	$("#addRow").click(function(){
		var cloneTR = tr.clone();
		cloneTR.find("input").val("");
		cloneTR.find("textarea").text("");
		setNowToFirstTd(cloneTR);
		tbody.append(cloneTR);
	});
	$("#delRow").click(function(){
		currentTR.remove();
	});
	
	
	// 取得当前汇率
	$.get({
		url:"http://api.aoikujira.com/kawase/json/jpy",
		dataType : "json",
		type:"get",
		
	}).done(function(res){
		var rate = JSON.parse(res);
		var cny = rate.CNY * 100;
		$(".rate").text(cny);
	});
	
});


function getNow(){
	var now = new Date();
	
	return $.datepicker.formatDate("yy-m-d",now) 
	   + ' ' + now.getHours()
	   + ':' + now.getMinutes()
	   + ':' + now.getSeconds();
}