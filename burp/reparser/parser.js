var xmlDoc;
var recol = new Array();
jQuery(document).ready(function () {
    jQuery("#xml").change(function () {
        var file = document.getElementById("xml").files[0];
        var reader = new FileReader();
        reader.readAsText(file);
        reader.onloadend = function () {
            var xmlData = (reader.result);
            parsexml(xmlData);
        };
    });
});
function replaceallstr(ts, tv, rv) {
    while (ts.indexOf(tv) > -1) {
        ts = ts.replace(tv, rv);
    }
    return ts;
}
function parsexml(data) {
    parser = new DOMParser();
    xmlDoc = parser.parseFromString(data, "text/xml");
    for (var i = 0; i <= xmlDoc.firstElementChild.children.length - 1; i++) {
        for (var j = 0; j <= xmlDoc.firstElementChild.children[i].children.length - 1; j++) {
            if (xmlDoc.firstElementChild.children[i].children[j].nodeName == 'request') {
                var req = replaceallstr(xmlDoc.firstElementChild.children[i].children[j].innerHTML, '<![CDATA[', '');
                req = replaceallstr(req, ']]>', '');
                
                recol[recol.length] = (atob(req));
            }
        }
    }
}
function parsechars(str) {
    for (var i = 0; i <= str.length - 1; i++) {
        console.log(str[i] + ' = ' + str.charCodeAt(i));
    }
}
function appendall() {
    for (var i = 0; i <= recol.length - 1; i++) {
        var txt = recol[i];// replaceallstr(recol[i], ' ', '<br>');
        $("#analis").append('<div style="width:100%;overflow:scroll;">' + txt + '</div><hr>');
    }
}