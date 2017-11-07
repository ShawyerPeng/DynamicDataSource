# 简介
项目中我们经常会遇到多数据源的问题，尤其是数据同步或定时任务等项目更是如此；又例如：读写分离数据库配置的系统。

* 静态数据源切换：一般情况下，我们可以配置多个数据源，然后为每个数据源写一套对应的 sessionFactory 和 dao 层代码 (以 hibernate 为例，mybatis 同理)
* 动态数据源切换：可看出在 Dao 层代码中写死了两个 SessionFactory，这样日后如果再多一个数据源，还要改代码添加一个 SessionFactory，显然这并不符合开闭原则。比较好的做法是，配置多个数据源，只对应一套 sessionFactory，数据源之间可以动态切换。

# 参考资料
[zhiqiang-bianjie/DynamicDataSource](https://github.com/zhiqiang-bianjie/DynamicDataSource)  
[基于 spring 的 aop 实现多数据源动态切换](https://lanjingling.github.io/2016/02/15/spring-aop-dynamicdatasource/)  
[SSM(八) 动态切换数据源](https://crossoverjie.top/2017/01/05/SSM8/)  
[Spring 实现动态数据源，支持动态添加、删除和设置权重及读写分离](https://www.dexcoder.com/selfly/article/4048)  
[异常解决：springMVC+MyBatis 多数据源动态切换](http://blog.zous-windows.com/archives/207.html)  
