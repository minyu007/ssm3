/**
 * handling main page JS processing
 */
var PayUtils = Class.extend({

	init : function(rootId, mergeId, jDatas) {
		this.rootId = $(rootId);
		this.mergeId = $(mergeId);
		if (!this.rootId && !this.mergeId)
			return;
		this.jDatas = jDatas;
		this.selected = [];
		this._analysisDatas(jDatas);
		this._bindEvent();
	},
	
	_bindEvent : function() {
		var _this = this;
		$('#mergeBtn').bind('click', function(){
			if(_this.selected.length < 2){
				alert('请至少选择2桌，再进行合并付款!');
			}else{
				console.log(_this.selected);
			}
		});
	},
	
	_analysisDatas: function(jDatas){
		var _this = this;
		_this.datas = [];
		var datas 
		for(var i = 0, l = jDatas.length; i < l ; i++){
			if(i%6==0){
				_this.datas.push([]);
				datas = _this.datas[_this.datas.length-1];
			}
			datas.push(i);
		}
		_this._creatTables();
	},
	
	_creatTables: function(){
		var _this = this;
		for(var i=0, l = _this.datas.length; i< l; i++){
			var ul = _this._drawUl();
			for(var j=0, len = _this.datas[i].length; j< len; j++){
				var li = _this._drawLi(_this.jDatas[_this.datas[i][j]]);
				ul.append(li);
			}
			_this.rootId.append(ul);
		}
	},
	
	_drawUl: function(){
		var ul = $('<ul>');ul.addClass("thumbnails");
		return ul;
	},
	
	_drawLi: function(data){
		var _this = this;
		var li = $('<li>');li.addClass("span2");li.attr("id", "li_"+data.tableId);
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
		
		var a3 = $('<a>');a3.css({"padding" : "4px 5px 4px 7px"});a3.addClass("btn");
		var i3 = $('<i>');i3.addClass("icon-white");
		if(_this.selected.indexOf(data.tableId) != -1){
			console.log(_this.selected , data.tableId);
			a3.addClass("btn-danger");
			i3.addClass("icon-remove");
		}else{
			console.log(_this.selected , data.tableId);
			a3.addClass("btn-success");
			i3.addClass("icon-ok");
		}
		a3.append(i3);
		div3.append(a1);
		div3.append(a2);
		div3.append(a3);
		a3.bind("click", function(e) {
			_this._sltBtn($(this), data);
		});
		thumbDiv.append(div1);
		thumbDiv.append(div2);
		thumbDiv.append(div3);
		
		return li;
	},
	
	_sltBtn : function(el, data) {
		var _this = this;
		var t = el, i = el.find("i");
		if (t.hasClass("btn-success")) {
			_this._setMergeDatas(true, data);
			t.removeClass("btn-success");
			t.addClass("btn-danger");
			i.removeClass("icon-ok");
			i.addClass("icon-remove");
			
		} else {
			_this._setMergeDatas(false, data);
			t.removeClass("btn-danger");
			t.addClass("btn-success");
			i.removeClass("icon-remove");
			i.addClass("icon-ok");
			
		}
	},
	
	_drawSpan: function(data){
		var _this = this;
		var span = $('<span>');span.addClass("label");span.addClass("label-success");span.css({"font-size":"13px","margin-right":"5px"});span.attr("id", "span_"+ data.tableId);
		var a = $('<a>');a.css({"cursor":"pointer","color":"#ffffff"});a.attr("data-original-title", "点击删除");a.text(data.name+" x");
		span.append(a);
		_this.mergeId.append(span);
		a.bind("click", function(){
			$(this).parent().remove();
			var el = $("#li_"+ data.tableId);
			if(el){
				var t = el.find(" .btn-group .btn").eq(2);
				var i = t.find("i");
				t.removeClass("btn-danger");
				t.addClass("btn-success");
				i.removeClass("icon-remove");
				i.addClass("icon-ok");
			}
			var idx = _this.selected.indexOf(data.tableId);
			if(idx == -1) return;
			_this.selected[idx] = null;
			_this._filterArray();
		});
	},
	
	_setMergeDatas: function(bln, data){
		var _this = this;
		var tId = data.tableId;
		if(bln){
			var idx = _this.selected.indexOf(tId);
			if(idx == -1){
				_this.selected.push(tId);
				_this._drawSpan(data);
			}
		}else{
			var idx = _this.selected.indexOf(tId);
			if(idx == -1) return;
			_this.selected[idx] = null;
			_this._filterArray();
			$("#span_"+ tId).remove();
		}
	},
	
	_filterArray: function(){
		var arr = [], _this = this;
		for(var i = 0, l = _this.selected.length; i < l; i++){
			if(_this.selected[i] != null)
				arr.push(_this.selected[i]);
		}
		console.log(arr);
		_this.selected = arr;
	}
});
/**
 * for IE Array.indexOf
*/
Array.prototype.indexOf = function(obj) {
	for(var i=0; i<this.length; i++)  { 
		if(this[i]==obj) { 
			return i; 
		} 
	} 
	return -1; 
};