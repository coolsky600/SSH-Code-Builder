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
```
![image](https://github.com/coolsky600/SSH-Code-Builder/blob/master/Raw/Architecture.png)
