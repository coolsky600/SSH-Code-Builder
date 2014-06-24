SSH-Code-Builder
================

## Why do we need this? 

Just as you know, web developers always spend much time on doing some repetitive work. 
For example,  writing Create-Read-Update-Delete(CRUD) code. 
For .net web developers, It generally include data tier code, business tier code and presentation layer code(Three-tier B/S Architecture).
For Java web developers, it might be model code, view code and controller code(MVC). But It is almost impossible for Java web developers  to write a source code generator which can compatible to any framework.
Maybe you have used IBM Rational Architecture to draw UML diagrams and generator EJB code, but EJB is totally out of fashion now. 

We need to create a source code generator for a specific Java Web architecture!

## Architecture description
As SSH(Spring + hibernate +structs) and RIA(Rich Internet Applications) become more and more popular. We decide to create a source code generator for
```
    1. Spring 3.0.5 RELEASE
    2. hibernate 3.5.5
    3. structs 2.0
    4. Jquery EasyUI 1.3.6
    5. Apache shiro 1.2
    6. HighCharts 4.0
```
This is the architectural description diagram of target Java web project 
![Image text](http://raw.github.com/coolsky600/SSH-Code-Builder/master/Raw/Architecture.jpg)

SSH-Code-Builder can generate source code for each level.

Srever side description diagram detial

![Image text](http://raw.github.com/coolsky600/SSH-Code-Builder/master/Raw/ssh.png)

##Usage 

###Step1 Get source code

    
###Step2 Config CodeBuilder.java

```
//Mysql connection string
private String url = "jdbc:mysql://localhost:3306/wechat";

//Mysql user name
private String user = "root";

//Mysql user password
private String pass = "19900624";

//table name (to generate)
private String tableName = "config";

//generated file save path
private String path = "d:/"+tableName;

```

###Step3 Run CodeBuilder.java

###Step4 Drag generated file to ssh project
