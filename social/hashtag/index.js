function replaceallstr(ts, tv, rv) {
    while (ts.indexOf(tv) > -1) {
        ts = ts.replace(tv, rv);
    }
    return ts;
}
function gfilter(txt) {
    var ctit = txt;
    ctit = replaceallstr(ctit, '...', '');
    ctit = replaceallstr(ctit, '\n', '');
    ctit = replaceallstr(ctit, '\r', '');
    ctit = replaceallstr(ctit, '›', '');
    ctit = replaceallstr(ctit, '|', '');
    ctit = replaceallstr(ctit, '  ', ' ');
    ctit = replaceallstr(ctit, '-', '_');
    ctit = replaceallstr(ctit, ',', '');
    ctit = replaceallstr(ctit, '?', '');
    ctit = replaceallstr(ctit, ')', '');
    ctit = replaceallstr(ctit, '(', '');
    ctit = replaceallstr(ctit, '}', '');
    ctit = replaceallstr(ctit, '{', '');
    ctit = replaceallstr(ctit, "'", '');
    ctit = replaceallstr(ctit, ".", '');
    return ctit;   
}
var output = '';
function readresults() {
    var gd = document.querySelectorAll('.g');
    for (var i = 0; i <= gd.length - 1; i++) {
    	try{
        var tit = gd[i].querySelectorAll('h3')[0].innerText;
        var textl = gd[i].querySelectorAll('span');
        var text = '';
        for (var j = 0; j <= textl.length - 1; j++) {
            if (textl[j].innerText.length > text.length) {
                text = textl[j].innerText;
            }
        }
        tit = gfilter(tit);
        text = gfilter(text);
        
        output = output + tit + ' ' + text + ' ';
    }catch(ex){}
    }
    var offers = document.querySelectorAll('#bres');
    if (offers.length > 0) {
        var acol = offers[0].querySelectorAll('a');
        for (var i = 0; i <= acol.length - 1; i++) {
            var tit = acol[i].innerText;
            tit = gfilter(tit);
            
            output = output + tit + ' ';
        }
    }
    output = replaceallstr(output, 'Translate this page', '');
    output = replaceallstr(output, '  ', ' ');
    var filename = 'google.txt'
    var text = output;
    var element = document.createElement('a');
    element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
    element.setAttribute('download', filename);
    element.style.display = 'none';
    //document.body.appendChild(element);
    //element.click();
    //document.body.removeChild(element);

    var keys = output.split(' ');
    var tags = '';
    for (var i = 0; i <= keys.length - 1; i++) {
        if (keys[i].trim().length > 5) {
            if (tags.indexOf(keys[i].trim()) == -1) {
                tags += '#' + keys[i].trim() + ' ' + String.fromCharCode(13) + ' ';
            }
        }
    }

    var filename = 'tags.txt'
    var text = tags;
    var element = document.createElement('a');
    element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
    element.setAttribute('download', filename);
    element.style.display = 'none';
    document.body.appendChild(element);
    element.click();
    document.body.removeChild(element);

}
readresults();
