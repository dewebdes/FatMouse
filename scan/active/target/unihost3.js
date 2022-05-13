var alltargets0 = document.body.innerText.split('\n');
var alltargets = new Array();
for(var i=0;i<=alltargets0.length-1;i++){
    if((alltargets0[i].indexOf('*')==-1) && (alltargets0[i].indexOf('.')>-1)){
    alltargets = alltargets.concat(alltargets0[i].split(','));
    }
    if(alltargets0[i].indexOf('====')>-1){
     alltargets = alltargets.concat(alltargets0[i].split(','));
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
