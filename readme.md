# DXnima-Android-Mold
安卓框架搭建

#借鉴csdn
#https://blog.csdn.net/renjianhhong/article/details/72844622


1. 前言1. 前言
安卓属于小团队开发，架构的重要性在很多公司其实不是那么的明显，加上现在的开源框架层出不穷，更好的帮助我们上手Android项目的开发。我前两年也在公司主导过项目开发，搭建过不少项目，以前主要的倾向是MVC，导致了activity/fragment过大，而且很多公共功能杂乱在项目中，后期维护起来不方便，最近刚好有时间，重新搭建了一个新的框架。（ps：有建议或者更好想法的可以留言。）
2. 用到的知识点：
UI—-面向对象 
数据交互—-MVP模式 
数据库——GreenDao 
网络图片加载—–picasso 
json解析—–gson 
http请求—-OKHttp 
事件总线—-eventbus
安卓属于小团队开发，架构的重要性在很多公司其实不是那么的明显，加上现在的开源框架层出不穷，更好的帮助我们上手Android项目的开发。我前两年也在公司主导过项目开发，搭建过不少项目，以前主要的倾向是MVC，导致了activity/fragment过大，而且很多公共功能杂乱在项目中，后期维护起来不方便，最近刚好有时间，重新搭建了一个新的框架。（ps：有建议或者更好想法的可以留言。）
2. 用到的知识点：
UI—-面向对象 
数据交互—-MVP模式 
数据库——GreenDao 
网络图片加载—–picasso 
json解析—–gson 
http请求—-OKHttp 
事件总线—-eventbus

3.以上知识点不熟悉的，可以先熟悉下基本知识，如果已经了解过，可以直接跳过下面的链接，直接看下文的使用。 
MVP模式 讲解地址：http://blog.csdn.net/dfskhgalshgkajghljgh/article/details/51317956 
GreenDao 讲解地址：http://blog.csdn.net/dfskhgalshgkajghljgh/article/details/51304390 
picasso 讲解地址：http://blog.csdn.net/dfskhgalshgkajghljgh/article/details/51684693 
OKHttp 讲解地址：鸿神的博客讲解地址： 
http://blog.csdn.net/lmj623565791/article/details/47911083 
eventbus 讲解地址：http://blog.csdn.net/dfskhgalshgkajghljgh/article/details/51681705


4.项目目录结构：

bean—————————————————存放Java model对象 

biz—————————————————–业务模块，根据不能业务建立子模块 

bridge————————————————-底层功能实现跟UI层的衔接层 

capabilities——————————————–底层功能具体实现（后期项目迭代到一定程度稳定后会考虑以jar形式导入） 

constant———————————————–常量 

ui——————————————————界面，根据不同业务建立子模块 

util—————————————————–业务层公共方法 

view—————————————————自定义view实现
