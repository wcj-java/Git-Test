/**
 * 系统cookie工具对象
 * 
 * Example:
 * Cookie.write("myCookie", "my name", 24);
 * Stores the string "my name" in the cookie "myCookie" which expires after 24 hours.
 */
var Cookie = {
    read : function(name) {
        var cookieValue = "";
        var search = name + "=";
        if (document.cookie.length > 0) {
            offset = document.cookie.indexOf(search);
            if (offset != -1) {
                offset += search.length;
                end = document.cookie.indexOf(";", offset);
                if (end == -1) end = document.cookie.length;
                cookieValue = unescape(document.cookie.substring(offset, end));
            }
        }
        return cookieValue;
    },

    write : function(name, value, hours, path) {
        var expire = "";
        if (hours != null) {
            expire = new Date((new Date()).getTime() + hours * 3600000);
            expire = "; expires=" + expire.toGMTString();
        }
        document.cookie = name + "=" + escape(value) + expire + (path ? '; path=' + path : '');
    },

    delOne : function(name) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval = Cookie.read(name);
        document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
    },

    delAll : function(d) {
        if (d == null) return;
        var ck = d.cookie.split(";");
        if (ck != null && ck != '') {
            var re = /.*?=/;
            var ne = [];
            for ( var i = 0, len = ck.length; i < len; i++) {
                var erst = re.exec(ck[i]);
                if (erst && erst.length) {
                    ne[i] = erst[0];
                    d.cookie = ne[i] + ";expires=-1";
                }
            }
        }
    },
    readAll : function() {
        var ck = document.cookie.split(";");
        if (ck != null && ck != '') {
            var re = /.*?=/;
            for ( var i = 0, len = ck.length; i < len; i++) {
                var erst = re.exec(ck[i]);
                console && console.log(erst);
            }
        }
    }
};