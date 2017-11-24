/**
 * 系统格式化工具对象
 */
var Formatter = function() {
    var MATH_CEIL = 0; // 进位
    var MATH_FLOOR = 1; // 舍位
    return {
        formatPrec : function(v, prec, split, mathType) {
            if (isNaN(v) || $.trim(String(v)).length == 0)
                return v;
            prec = (prec == undefined || typeof prec != "number" || prec < 0) ? 2 : prec;
            v = parseFloat(v);
            var whole, sub;
            var mathfn = Math.round;
            if (typeof mathType == "number") {
                switch (mathType) {
                case MATH_CEIL:
                    mathfn = Math.ceil;
                    break;
                case MATH_FLOOR:
                    mathfn = Math.floor;
                    break;
                }
            }
            if (prec != 0) {
                v = (mathfn((v - 0) * Math.pow(10, prec))) / Math.pow(10, prec);
                var zeroFill = String(Math.pow(10, prec)).substring(1);
                v = (v == Math.floor(v)) ? v + "." + zeroFill : v;
                v = String(v);
                var ps = v.split('.');
                whole = ps[0];
                sub = ps[1] ? '.' + (ps[1].length == prec ? ps[1] : ps[1] + String(Math.pow(10, prec - ps[1].length)).substring(1)) : '.' + zeroFill;
            } else {
                whole = String(mathfn(v));
                sub = '';
            }
            if (split && split == true) {
                var r = /(\d+)(\d{3})/;
                while (r.test(whole)) {
                    whole = whole.replace(r, '$1' + ',' + '$2');
                }
            }
            return whole + sub;
        },
        formatPercent : function(val, flag, prec) {
            prec = (!prec || typeof prec != "number") ? 2 : prec;
            return Formatter.formatPrec(val * (flag == true ? 1 : Math.pow(10, 2)), prec) + "%";
        },
        formatAmt : function(v, prec) {
            return Formatter.formatPrec(v, prec, true);
        },
        formatAmtRet : function(v) {
            return v.replace(/\,/g, "");
        },
        fillStr : function(str, length, char, lr) {
            str = String(str);
            if (!$.isNumeric(length)) {
                return str;
            }
            if (str.length > length) {
                return str;
            } else {
                for (var i = 0, len = length - str.length; i < len; i++) {
                    if (!lr) {
                        str = (char || ' ') + str;
                    } else {
                        str += (char || ' ');
                    }
                }
                return str;
            }
        },
        formatDate : function(date, pattern) {
            if ($.type(date) != 'date')
                return "";
            return (pattern || 'yyyy-MM-dd hh:mm:ss').replace(/yyyy/g, date.getFullYear()).replace(/MM/g, this.fillStr(date.getUTCMonth() + 1, 2, '0')).replace(/dd/g, this.fillStr(date.getUTCDate(), 2, '0')).replace(/hh/g, this.fillStr(date.getHours(), 2, '0')).replace(/mm/g, this.fillStr(date.getMinutes(), 2, '0')).replace(/ss/g, this.fillStr(date.getSeconds(), 2, '0'));
        },
        formatDateStr : function(value) {
            value = String(value);
            if (value.length < 8)
                return "";
            return value.substring(0, 4) + "-" + value.substring(4, 6) + "-" + value.substring(6, 8);
        },
        formatTimeStr : function(value) {
            value = String(value);
            if (value.indexOf(":") != -1) {
                return value;
            }
            if (value.length < 5) {
                return "";
            }
            if (value.length == 5) {
                value = "0" + value;
            }
            return value.substring(0, 2) + ":" + value.substring(2, 4) + ":" + value.substring(4, 6);
        },
        toNumber : function(value) {
            return !!value ? value.replace(/[^\d^\.]/g, "") : "";
        },
        NumberTreat : function(value, split, prec, mathfn) {
            value = $.isNumeric(value) ? (value + "") : $.trim((this.toNumber(value) + "").toLowerCase());
            if (value == "") {
                return "";
            }
            if (value.length == 1) {
                if (value.charAt(0) >= 0 && value.charAt(0) <= 9 || value == "k" || value == "m") {
                    value = ((value == "k" || value == "m") ? "1" : "0") + value;
                } else {
                    return "格式有误";
                }
            }
            var sub_val = value.indexOf(".") == -1 ? "" : value.substring(dotindex);
            if (value.length > 1) {
                var regex = new RegExp(/^-?\d*[KkMm]{0,1}(\.\d*[KkMm]{0,1})?$/gi);
                if (!regex.test(value)) {
                    return "格式有误";
                }
            }
            if (prec == undefined)
                prec = 2;
            if (mathfn == undefined)
                mathfn = 4;
            var num = null;
            if (value.indexOf("k") != -1) {
                if (value.indexOf(".") != -1 && value.indexOf("k") == value.length - 1) {
                    num = 1000 * value.substring(0, value.indexOf("k"));
                } else {
                    num = (1000 * value.substring(0, value.indexOf("k"))) + sub_val;
                }
                return Formatter.formatPrec(num, Number(prec), split, mathfn);
            } else if (value.indexOf("m") != -1) {
                if (value.indexOf(".") != -1 && value.indexOf("m") == value.length - 1) {
                    num = 1000000 * value.substring(0, value.indexOf("m"));
                } else {
                    num = (1000000 * value.substring(0, value.indexOf("m"))) + sub_val;
                }
                return Formatter.formatPrec(num, Number(prec), split, mathfn);
            } else {
                return Formatter.formatPrec(Number(value), Number(prec), split, mathfn);
            }
        }
    };
}();