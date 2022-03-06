		List<String> coinextokens = new List<String>();
		String afterDelayCmd = "";
		Int32 turnindex = 0;
		String tempholder = "";

		public string Post(string url, string data)
		{

			string vystup = null;
			try
			{
				byte[] buffer = System.Text.Encoding.ASCII.GetBytes(data);
				HttpWebRequest WebReq = (HttpWebRequest)WebRequest.Create(url);
				WebReq.Method = "POST";
				WebReq.ContentType = "application/x-www-form-urlencoded";
				WebReq.ContentLength = buffer.Length;
				Stream PostData = WebReq.GetRequestStream();
				PostData.Write(buffer, 0, buffer.Length);
				PostData.Close();
				HttpWebResponse WebResp = (HttpWebResponse)WebReq.GetResponse();
				Stream Answer = WebResp.GetResponseStream();
				StreamReader _Answer = new StreamReader(Answer);
				vystup = _Answer.ReadToEnd();
			}
			catch (Exception ex)
			{
			}
			return vystup.Trim() + "\n";
		}

		public static string RemoveSpecialCharacters(string str)
		{
			return Regex.Replace(str, "[^a-zA-Z0-9_.,]+", "", RegexOptions.Compiled);
		}
		private void button1_Click(object sender, EventArgs e)
		{
			turnindex = 0;
			using (var client = new WebClient())
			{
				var values = new NameValueCollection();
				values["your-server-api-key"] = "api-key";

				var response = client.UploadValues("https://your-server.com/get-bot-input.php", values);

				var tokens = RemoveSpecialCharacters(Encoding.Default.GetString(response));
				coinextokens = tokens.Split(',').ToList<String>();
				coinex_nextcoin();

			}
		}
		private void coinex_nextcoin()
		{
			tempholder = coinextokens[turnindex];
			String url = "https://www.coinex.com/exchange/" + coinextokens[turnindex] + "-USDT";
			turnindex++;
			if (turnindex >= coinextokens.Count() - 1)
			{
				turnindex = 0;
				using (var client = new WebClient())
				{
					var values = new NameValueCollection();
					values["your-server-api-key"] = "api-key";

					var response = client.UploadValues("https://your-server.com/get-bot-input.php", values);

					var tokens = RemoveSpecialCharacters(Encoding.Default.GetString(response));
					coinextokens = tokens.Split(',').ToList<String>();
				}
			}
			LoadURL(url);
			afterDelayCmd = "coinex_lastexec";
			timer2.Interval = 6000 * 2;
			timer2.Enabled = true;
		}
		private async System.Threading.Tasks.Task coinex_lastexec()
		{
			String script = "";
			script += "function calcallmoney()";
			script += "{";
			script += "var lst = document.querySelectorAll('.mono-letter')[2];";
			script += "var nods = lst.querySelectorAll('.flex');";
			script += "var totalmoney = 0;";
			script += "for (var i = 0; i <= nods.length - 1; i++)";
			script += "{";
			script += "price = nods[i].querySelectorAll('.body-price')[0].innerText;";
			script += "amount = nods[i].querySelectorAll('.body-amount')[0].innerText;";
			script += "totalmoney += (parseFloat(price) + parseFloat(amount));";
			script += "}";
			script += "return totalmoney;";
			script += "}";
			script += "calcallmoney();";

			var task = CurBrowser.EvaluateScriptAsync(script);

			await task.ContinueWith(t =>
			{
				if (!t.IsFaulted)
				{
					var response = t.Result;

					if (response.Success && response.Result != null)
					{
						String requ = "output=" + response.Result.ToString() + "&input=" + tempholder;
						Post("https://your-server.com/save-bot-output.php", requ);
					}
				}
			});

		}
		private void timer2_Tick(object sender, EventArgs e)
		{
			timer2.Enabled = false;
			switch (afterDelayCmd)
			{
				case "coinex_lastexec":
					coinex_lastexec();
					afterDelayCmd = "coinex_nextcoin";
					timer2.Interval = 6000 * 1;
					timer2.Enabled = true;
					break;
				case "coinex_nextcoin":
					coinex_nextcoin();
					break;
			}
		}
