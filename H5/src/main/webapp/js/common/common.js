/**
 * Created by Administrator on 14-11-16.
 */
//全局路径
var baseUrl = $("base").attr("href");
var loginJSP = "jsp/main/login.jsp";

var Grid = BUI.Grid, Store = BUI.Data.Store, columns, store, grid;
function BaseGrid(url, columns, params, gridId) {
	var store = new Store({
		url : url,
		autoLoad : true,
		pageSize : 15,
		proxy : {
			ajaxOptions : { //ajax的配置项，不要覆盖success,和error方法
				traditional : true,
				type : 'post'
			}
		},
		root : 'data',
		totalProperty : 'totalRows'
	}), grid = new Grid.Grid({
		render : '#' + gridId,
		loadMask : true,
		forceFit : true,
		columns : columns,
		store : store,
		plugins : [ Grid.Plugins.CheckSelection, Grid.Plugins.AutoFit ], //勾选插件、自适应宽度插件
		// 底部工具栏
		tbar : {
			items : [ bars ]
		},
		// 顶部工具栏
		bbar : {
			//items 也可以在此配置
			// pagingBar:表明包含分页栏
			pagingBar : true
		}
	});

	grid.render();
}