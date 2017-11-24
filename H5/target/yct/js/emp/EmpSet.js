var afterDialog = function(dlg, dlgWin, dlgDoc, gridId){
    
    showForm(dlgDoc);
    
	if(dlg.id == "pwdChangeDlg"){//如果是密码修改对话框则退出
		return;
	}
	
    //添加修改密码按钮
	dlg.addButton({
        id : "pwdBtn",
        text : "修改密码",
        width : 70,
        onclick : function(btn, dlg, opt) {
            addedit("pwdChangeDlg", null, "jsp/emp/PwdChange.jsp")();
        }
    });
}