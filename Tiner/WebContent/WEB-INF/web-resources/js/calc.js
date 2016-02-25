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
	
});


function getNow(){
	var now = new Date();
	
	return $.datepicker.formatDate("yy-m-d",now) 
	   + ' ' + now.getHours()
	   + ':' + now.getMinutes()
	   + ':' + now.getSeconds();
}