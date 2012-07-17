/**
 * handling main page JS processing
 */
var PayUtils = Class.extend({

	init : function(rootId, mergeId, datas) {
		this.rootId = $(rootId);
		this.mergeId = $(mergeId);
		if (!this.rootId && !this.mergeId)
			return;
		//this.lis = this.rootId.find("li");
		this._createTables(datas);
		this._bindEvent();
	},
	
	_analysisDatas: function(datas){
		for(var i = 1, l=datas.length; i <= l ; i++){
			if(i%6 == 0) this.rootId
		}
	},
	
	_drawUl: function(){
		
	},
	
	_drawLi: function(data){
		var li = $('<li>');li.addClass("span2");li.attr("id", data.tableId);
		var thumbDiv = $('<div>');thumbDiv.addClass("thumbnail");thumbDiv.addClass("clearfix");
		li.append(thumbDiv);
		
		var div1 = $('<div>');
		var img = $('<img>');img.css({"cursor":"pointer"});img.attr("src", "http://localhost:8080/ssm3/images/table4.jpg");
		div1.append(img);
		
		var div2 = $('<div>');div2.addClass("caption");
		var h5 = $("<h5>");h5.text(data.name);
		var p = $("<p>");p.text(data.msg);
		div2.append(h5);
		div2.append(p);
		
		var div3 = $('<div>');div3.addClass("btn-group");
		
		var a1 =$('<a>');a1.addClass("btn");a1.css({"padding" : "4px 6px 4px 7px"});
		var i1 = $('<i>');i1.addClass("icon-shopping-cart");
		a1.append(i1);
		
		var a2 =$('<a>');a2.addClass("btn");a2.css({"padding" : "4px 6px 4px 7px"});a2.attr("data-toggle", "modal");a2.attr("href" ,"#myModal");
		var i2 = $('<i>');i2.addClass("icon-pencil");
		a2.append(i2);
		
		var a3 = $('<a>');a3.addClass("btn");a3.addClass("btn-success");a3.css({"padding" : "4px 5px 4px 7px"});
		var i3 = $('<i>');i3.addClass("icon-plus");i3.addClass("icon-white");
		a3.append(i3);
		div3.append(a1);
		div3.append(a2);
		div3.append(a3);
		
		thumbDiv.append(div1);
		thumbDiv.append(div2);
		thumbDiv.append(div3);
	},
	
	_bindEvent : function() {
		var _this = this;
		this.lis.find(".btn-group").each(function(i, v) {
			var btn = $(v).find('.btn').eq(2);
			btn.bind("click", function(e) {
				_this._sltBtn($(this), _this.lis.eq(i).find("h5"));
			});
		});
	},

	_sltBtn : function(el, h5) {
		var t = el, i = el.find("i");
		if (t.hasClass("btn-success")) {
			t.removeClass("btn-success");
			t.addClass("btn-danger");
			i.removeClass("icon-plus");
			i.addClass("icon-minus");
			
		} else {
			t.removeClass("btn-danger");
			t.addClass("btn-success");
			i.removeClass("icon-minus");
			i.addClass("icon-plus");
		}
	},

	_setMergeMsg : function() {
		
	}
});