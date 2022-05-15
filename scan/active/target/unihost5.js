var alltargets0 = document.body.innerText.split('\n');
var alltargets1 = new Array();
var alltargets2 = new Array();
var alltargets3 = new Array();
var alltargets = new Array();
for(var i=0;i<=alltargets0.length-1;i++){
    alltargets1 = alltargets1.concat(alltargets0[i].split(':'));
}
for(var i=0;i<=alltargets1.length-1;i++){
    if(alltargets1[i].split('.').length>1){
        if(alltargets1[i].split('.')[1].trim().length>1){
    alltargets2 = alltargets2.concat(alltargets1[i].split(':'));
        }
    }
}
for(var i=0;i<=alltargets2.length-1;i++){
    if(alltargets2[i].indexOf('+')==-1){
    alltargets3 = alltargets3.concat(alltargets2[i].split(':'));
    }
}
for(var i=0;i<=alltargets3.length-1;i++){
    if(alltargets3[i].indexOf('+')==-1){
    alltargets = alltargets.concat(alltargets3[i].split(':'));
    }
}

function onlyUnique(value, index, self) {
    return self.indexOf(value) === index;
}
var unique = alltargets.filter(onlyUnique);
let uniqtargets = unique.join("\n");
var filename = 'unitarget.txt'
var element = document.createElement('a');
element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(uniqtargets));
element.setAttribute('download', filename);
element.style.display = 'none';
document.body.appendChild(element);
element.click();
document.body.removeChild(element);
