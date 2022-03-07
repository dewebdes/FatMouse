var tdl=document.querySelectorAll('tr');
var links=[];
var outp='';
for(var i=1;i<=tdl.length-1;i++){
var a1=tdl[i].querySelectorAll('a')[0].href;
    links[links.length]=a1;
outp+=a1+',';
}
