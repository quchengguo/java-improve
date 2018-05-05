## 分布式爬虫
按照架构图在centos6中搭建环境，安装redis、mysql、jdk
。在程序代码中注意redis和数据库对应的IP以及pom文件中主启动类的加载。


## 注意
克隆虚拟机步骤：
* 虚拟机关机状态下，在网络适配器中自动生成MAC地址，记录
* 虚拟机开机状态下，```vi /etc/sysconfig/network-scripts/ifcfg-eth0```将```HWADDR```修改为刚才记录的MAC
* 修改主机hostname ``` vi  /etc/sysconfig/network```中修改```hostname node01```
* 删除虚拟网卡设备MAC地址``` rm -rf /etc/udev/rules.d/70-persistent-net.rules```
* 重启network，重启虚拟机reboot
