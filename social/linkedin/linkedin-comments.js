var mentiontm = '<a class="ql-mention" href="#" data-entity-urn="urn:li:fsd_profile:#hash" data-guid="1" data-object-urn="urn:li:member:#uid" data-original-text="#fullname" spellcheck="false">#shortname</a>';
var authertm = '<span class="comments-post-meta__name-text hoverable-link-text" data-entity-hovercard-id="urn:li:fs_miniProfile:ACoAAButFR0BIfm7aL-YF-tuN6Cii5bv8WcE2OQ" aria-expanded="false" aria-controls="undefined" tabindex="-1">Bahare Savarzade</span >';
var idl = document.querySelectorAll('.comments-post-meta__name-text');
var usnl = [];
var usnoa = [];
for (var i = 0; i <= idl.length - 1; i++) {
    usnl[usnl.length] = idl[i].innerText;
    usnoa[usnoa.length] = autherobj(idl[i]);
}
var reacts = document.querySelectorAll('.comments-comment-social-bar__reactions-count');
var reactint;
var reactindx = 0;
function autherobj(el) {
    var hashcode = el.getAttribute('data-entity-hovercard-id').split('urn:li:fs_miniProfile:')[1];
    var mename = el.innerText.split(' ')[0];
    return { hash: hashcode, sname: mename, fname: el.innerText, uid: randuid() };
}
function randuid() {
    return parseInt(Math.random() * (600000000 - 500000000) + 500000000);
}
function openreact() {
    clearInterval(reactint);
    if (reactindx < reacts.length - 1) {
        lastsdif = 0;
        reacts[reactindx].click();
        reactindx++;
        reactint = setInterval(reactusers, 5000);
    } else {
        //printusers();
        printusersactive();
    }
}
var lastsdif = 0;
function reactusers() {
    clearInterval(reactint);
    var scrodif = parseInt(document.querySelectorAll('.social-details-reactors-modal__content')[0].scrollHeight - document.querySelectorAll('.social-details-reactors-modal__content')[0].scrollTop);
    if (scrodif != lastsdif) {
        lastsdif = scrodif;
        document.querySelectorAll('.social-details-reactors-modal__content')[0].scrollTop = document.querySelectorAll('.social-details-reactors-modal__content')[0].scrollHeight;
        reactint = setInterval(reactusers, 5000);
    } else {
        var reusl = document.querySelectorAll('.artdeco-entity-lockup__title');
        for (var i = 0; i <= reusl.length - 1; i++) {
            usnl[usnl.length] = reusl[i].innerText;
        }
        document.querySelectorAll('.artdeco-modal__dismiss')[0].click();
        reactint = setInterval(openreact, 1000);
    }
}
function printusers() {
    var unique = usnl.filter(onlyUnique);
    var outp = '';
    for (var i = 0; i <= unique.length - 1; i++) {
        outp += '@' + unique[i] + ' , ';
    }
    var inp = document.createElement('input');
    document.body.appendChild(inp)
    inp.value = outp;
    lastselectedprice = inp.value;
    inp.select();
    document.execCommand('copy', false);
    inp.remove();
    console.log('output copy to ram...');
}
function onlyUnique(value, index, self) {
    return self.indexOf(value) === index;
}
function replaceallstr(ts, tv, rv) {
    while (ts.indexOf(tv) > -1) {
        ts = ts.replace(tv, rv);
    }
    return ts;
}
function printusersactive() {
    var duplicateElementa = usnl.filter((item, index) => usnl.indexOf(item) !== index);
    var unique = duplicateElementa.filter(onlyUnique);
    var finalauthers = [];
    for (var i = 0; i <= unique.length - 1; i++) {
        for (var j = 0; j <= usnoa.length - 1; j++) {
            if (usnoa[j].fname == unique[i]) {
                finalauthers[finalauthers.length] = usnoa[j];
                break;
            }
        }
    }

    var outp = '';
    for (var i = 0; i <= finalauthers.length - 1; i++) {
        var tm = mentiontm;
        tm = replaceallstr(tm, '#hash', finalauthers[i].hash);
        tm = replaceallstr(tm, '#uid', finalauthers[i].uid);
        tm = replaceallstr(tm, '#fullname', finalauthers[i].fname);
        tm = replaceallstr(tm, '#shortname', finalauthers[i].sname);
        outp += tm + ' , ';
    }

    document.querySelectorAll('.ql-editor')[0].innerHTML = '<p>' + outp + '<br></p>';

    var inp = document.createElement('input');
    document.body.appendChild(inp)
    inp.value = outp;
    lastselectedprice = inp.value;
    inp.select();
    document.execCommand('copy', false);
    inp.remove();
    console.log('output copy to ram...');
}
openreact();
