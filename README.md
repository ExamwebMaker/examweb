# 研究生报名网站

## 介绍

由信管的学生制作,一个研究生报名网站

本网站是在 Springboot 基础上的搭建的一个平台采用了 bootstrap 框架实现界面设计,后端语言为 java.

用于研究生报名,包括前台和后台界面.

前台:

1. 用户登录
2. 研究生报名
3. 查询专业

后台:

界面风格采用了结构简单,性能优良,页面美观大气的 Twitter Bootstrap 页面展示框架分为三个管理权限:普通用户,超级管理员,普通管理员

**超级管理员**:公告管理,用户信息管理,普通管理员的分配与管理

**管理员**:查看报名信息,审核报名信息

**用户**:注册登录,研究生报名,用户信息修改

## 界面
前台界面:
![](https://i.imgur.com/7cugrG7.png)
![](https://i.imgur.com/Dva6ncx.png)
![](https://i.imgur.com/bZFs9b8.png)

![](https://i.imgur.com/xLypX2E.png)
![](https://i.imgur.com/Rz3KZ1B.png)

超级管理员界面:


管理员界面:
![](https://i.imgur.com/bu7TaF5.png)
![](https://i.imgur.com/Qb0Wy7y.png)
![](https://i.imgur.com/AJM1xAu.png)

## 技术选型

1,后端

* 核心框架：Spring Boot
* 安全框架：
* 模板引擎：Thymeleaf
* 持久层框架：MyBatis
* 数据库连接池：Alibaba Druid
* 缓存框架：
* 日志管理：log4j,
* 工具类：swaggerui,

2,前端:

* js 框架: jQuery
* 界面框架:Bootstrap
* 数据表格:jquerydatatable
*

3,平台

* 服务器中间件：SpringBoot 内置
* 数据库支持：MySql
* 开发环境：Java,IDEA, Java EE ,Maven ,Git

## 安装使用

JDK,maven,数据库(修改数据库密码), 环境准备好之后直接在**IDEA**中运行`CourseApplication`即可,端口 8081,<br>
前台:<br/>
后台:
  * 首页地址: `localhost:8081/`
  * 管理员地址: `localhost:8081/admin`
  * 超级管理员地址: `localhost:8081/superindex`
  * API地址: `localhost:8081/swagger-ui.html`

## 演示地址:

######

## githab 地址 https://github.com/ExamwebMaker/examweb

## 版权声明

本网站由我们制作,版权所有,翻版必究.
