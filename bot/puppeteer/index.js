const puppeteer = require('puppeteer');
const prettier = require('prettier');
var page = null;
var browser = null;

async function coinex_money(cn){

	await page.goto('https://www.coinex.com/exchange/' + cn + '-USDT');
	
	
	money = 0;

	const getData = async() => {
	  return await page.evaluate(async () => {
	      return await new Promise(resolve => {
		setTimeout(() => {
			var lst = document.querySelectorAll('.via-table-body-list')[0];
			var nods = lst.querySelectorAll('.flex');
			var totalmoney = 0;
			for (var i = 0; i <= nods.length - 1; i++){
				price = nods[i].querySelectorAll('.body-price')[0].innerText;
				price = price.replace(',', '');
				amount = nods[i].querySelectorAll('.body-amount')[0].innerText;
				amount = amount.replace(',', '');
				totalmoney += (parseFloat(price) * parseFloat(amount));	
			}
		      	resolve(parseInt(totalmoney));
		}, 10000)
	    })
	  })
	}  

	money = await getData();
	console.log('totalmoney = ' + money);
	

}

(async function main(){

	browser = await puppeteer.launch({
	  headless:true, 
	  defaultViewport:null,
	  devtools: true,
	  args: ['--window-size=1920,1170','--window-position=0,0']
	});

	page = await browser.newPage();
	
	await coinex_money('BTC');
	await browser.close();
	

})();


