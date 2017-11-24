
//设置角色
function setRole(roleId){
    return function(organizationId){
        var combox = liger.get(roleId);
        if(combox == null) {
            return;
        }
        combox.options.url = "role/roleList?organizationId=" + organizationId;//重设url，如果是属性或表格下拉，要重设子对象的url
        combox.clear();
        combox.reload();
    }
}