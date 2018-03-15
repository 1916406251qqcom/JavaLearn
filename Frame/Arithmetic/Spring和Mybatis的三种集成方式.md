# 1.搭建一个Mybatis 的执行环境   在sql定义文件中 定义一个 根据money排序

    可以指定一页显示多少条  和  第几页的一个查询。

# 2.接口中的多个参数 传递给sql语句的问题 
## 2.1  修改接口参数 为一个 map 或者 一个对象类型
## 2.2  如果多参  不修改接口 可以使用  #{0} 代表第一个参数  #{1} 代表第二个参数 
## 2.3  如果多参  不修改接口 可以使用  #{param1} 代表第一个参数  #{param2} 代表第二个参数 
## 2.4  @Param 标注加在接口方法参数上   可以增强sql语句中可读性
# 3.第三方的分页插件 
## 3.1 搭建查询所有的数据一个环境 
## 3.2 配置一个分页的拦截器

          拷贝分页插件jar包 到lib（pagehelper-4.1.6.jar jsqlparser-0.9.1.jar ）
          在主配置文件中配置 拦截器 
        <plugins>
             <plugin interceptor="com.github.pagehelper.PageHelper"></plugin>
        </plugins>
        
## 3.3 在执行sql 的方法前 使用  分页的api 进行设置

            PageHelper.startPage(2, 3);
     
# 4.别名问题

           java.lang.String    string
           java.util.Map        map 
           
             自定义类型  也可以起别名 
          com.xdl.bean.XdlBankAccount    account
  
# 5.Spring  和 Mybatis 的集成  第一种方式

        使用  SqlSessionFactoryBean  和  MapperFactoryBean  集成
   
## 5.1 建立一个项目  拷贝Spring 容器对应的配置文件  和 jar包(ioc aop orm mybatis dbcp

        驱动  dao  spring 和 mybatis的集成包)
    
## 5.2 在Spring  配置文件中 配置 数据源     SqlSessionFactoryBean 和  MapperFactoryBean  
## 5.3 写sql 定义文件  
## 5.4 写dao 接口 
## 5.5 测试 
  
# 6. 使用Spring  和 Mybatis 集成  来完成可以根据一个员工的编号获取员工信息的实现。
  
## 6.1 建立一张 员工表  xdl_emp_2018  插入几条测试数据

           id    number   pk
           name  varchar2(30)
           age   number
           salary  number
           dept_id  number 
           create  table  xdl_emp_2018(
               id   number constraint xdl_emp_2018_id_pk primary key,
               name varchar2(30),
               age   number,
               salary  number,
               dept_id   number
           );
           insert  into   xdl_emp_2018  values(1,'ea',21,12345,1);
           commit; 
           insert  into   xdl_emp_2018  values(2,'eb',22,8345,1);
           insert  into   xdl_emp_2018  values(3,'ec',31,22345,1);
           insert  into   xdl_emp_2018  values(4,'ed',41,72345,2);
           insert  into   xdl_emp_2018  values(5,'ee',23,52345,2);
           commit;
       
## 6.2 建立一个项目 导入 jar包(ioc  aop dao orm mybatis jdbc 
     mybatis-spring  连接池 数据库驱动包)  并拷贝spring 的配置
          文件到src 下 
## 6.3 根据表 设计一个 员工的实体类 
## 6.4 写员工操作对应的sql定义文件
## 6.5 根据sql定义文件 写对应的 mapper 接口 
## 6.6 在spring 对应的配置文件中  定义 DataSource 

           SqlSessionFactoryBean (注入 dataSouce 和 sql定义文件)
           MapperFactoryBean (注入 SqlSessionFactoryBean  和 接口)
   
## 6.7 通过Spring 容器获取对应Mapper(就是dao) 
   
# 7. 使用Spring  和 Mybatis 集成  来完成可以根据一个部门的编号获取部门信息的实现。
  
    id    name   loc_addr
    
## 7.1 建立部门表 xdl_dept_2018   并插入测试数据

           create table xdl_dept_2018(
               id   number  constraint xdl_dept_2018_id_pk primary key,
               name varchar2(30),
               loc_addr  varchar2(50)
           );
           insert into  xdl_dept_2018 values(1,'test1','bj');
           insert into  xdl_dept_2018 values(2,'test2','nj');
           commit;
   
## 7.2 建立一个对应的实体类 
## 7.3 建立一个sql 定义文件 
## 7.4 建立对应dao 接口 
## 7.5 在Spring  配置文件中

        MapperFactoryBean (注入 SqlSessionFactoryBean  和 接口)
    
## 7.6 测试
   
# 8.分别在部门接口 和 员工接口中增 listAll方法   以及 增加数据的方法

            增删改 自动提交  如果允许参数值为null 则使用 jdbcType
      
# 9.批量产生 Mapper的实现类   并且使用标注精准控制

            <!--  批量产生接口实现类 -->
            <bean  class="org.mybatis.spring.mapper.MapperScannerConfigurer">
                 <property name="basePackage"  value="com.xdl.mapper.dao" ></property>
                 <property name="annotationClass" value="com.xdl.annotation.MyAnnotation"></property>
            </bean>
    
# 10.第二种mybatis集成Spring的方式

        使用SqlSessionTemplate  自己来写接口的实现类  
        使用SqlSessionTemplate 的api 完成对数据库的访问
         根据部门id  获取部门信息
         
## 10.1  建立一张表  并插入测试数据 (已经存在)
## 10.2  建立一个项目  拷贝Spring 配置文件 和 jar包 (从上一个项目中复制)

          保留 dataSource  和  SqlSessionFactoryBean
          
## 10.3  自定义sql 文件 (拷贝)  和  实体类
## 10.4  写sql文件对应的 接口 
## 10.5  写一个实现类  实现 接口

          在Spring 容器 创建 一个 SqlSessionTemplate 对象  注入给实现类
          
## 10.6  开启组件扫描     把实现类加载到Spring 容器 
## 10.7  测试 
      
# 11.使用自动生成dao 实现类的方式  写一个银行账户登录功能

          spring ioc  + spring mvc  + mybatis   
             使用  用户名 和 密码 进行 登录 
