var alltargets = document.body.innerText.split('\n');
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
