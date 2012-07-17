var $Class = function(clsName, methods){
	var a = function(){
		methods.init.apply(this, arguments);
	};
	$.extend(a.prototype, methods);
	window[clsName] = a;
};

$Class("abc", {
	init: function(){},
	a: function(){}
});

new abc({
	
});

function aa(){
	var c = function(){};
	return {
		a:function(){c();},
		b:function(){}
	}
}
var cgy = {};

