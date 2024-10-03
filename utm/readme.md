<h1>SETUP Instruction:</h1>
apt install build-essential libpcap-dev libpcre3-dev libnet1-dev zlib1g-dev luajit hwloc libdnet-dev libdumbnet-dev bison flex liblzma-dev openssl libssl-dev pkg-config libhwloc-dev
<br>
cmake cpputest libsqlite3-dev uuid-dev libcmocka-dev libnetfilter-queue-dev libmnl-dev autotools-dev libluajit-5.1-dev libunwind-dev libfl-dev -y
<br>
mkdir snort-source-files && cd snort-source-files
<br>
git clone https://github.com/snort3/libdaq.git
<br>
cd libdaq
<br>
./bootstrap
<br>
./configure
<br>
make
<br>
make install
<br>
cd ../
<br>
wget https://github.com/gperftools/gperftools/releases/download/gperftools-2.9.1/gperftools-2.9.1.tar.gz
<br>
tar xzf gperftools-2.9.1.tar.gz
<br>
cd gperftools-2.9.1/
<br>
./configure
<br>
make
<br>
make install
<br>
cd ../
<br>
wget https://github.com/snort3/snort3/archive/refs/tags/3.3.5.0.tar.gz
<br>
tar xzf 3.3.5.0.tar.gz
<br>
cd snort3-3.3.5.0
<br>
./configure_cmake.sh --prefix=/usr/local --enable-tcmalloc
<br>
cd build
<br>
make
<br>
make install
<br>
sudo ln -s /usr/local/bin/snort /usr/sbin/snort
<br>
ldconfig
<br>
snort -V
<br>
apt update
<br>
apt install net-tools
<br>
ifconfig
<br>
#to find main network interface, for example my main interface name is 'ens33'
<br>
ip link set dev enp5s0 promisc on
<br>
ip add sh enp5s0
<br>
ethtool -k enp5s0 | grep receive-offload
<br>
ethtool -K enp5s0 gro off lro off
<br>
mkdir /usr/local/etc/rules
<br>
wget https://www.snort.org/downloads/community/snort3-community-rules.tar.gz
<br>
tar xzf snort3-community-rules.tar.gz -C /usr/local/etc/rules/
<br>
wget https://raw.githubusercontent.com/dewebdes/FatMouse/main/utm/snort3/2022A.rules
<br>
cp 2022A.rules /usr/local/etc/rules/
<br>
mkdir -p /var/log/snort
<br>
cd /usr/local/etc/snort
<br>
#edit snort.lua
<br>
HOME_NET = 'server_ip_1 server_ip_2 server_ip_3 ...'
<br>
EXTERNAL_NET = '!$HOME_NET'
<br>
...
<br>
alert_fast = {
file = true,
packet = false,
limit = 10,
}
<br>
...
<br>
#save & exit
<br>
#upload & customize firewall source and rules...

<hr>
#Restrict acsses to SSH:
<br>
iptables -A INPUT -p tcp --dport 22 --source [white-ip-list] -j ACCEPT;iptables -A INPUT -p tcp --dport 22 -j DROP;
