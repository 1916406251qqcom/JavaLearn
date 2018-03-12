# 1.什么是AOP

        Aspect  Oriented   Programming  面向切面编程或者面向方面编程
        不修改原有组件源代码的情况下 就能增加方法的能力
    
# 2.AOP 技术的组成部分 
  * Aspect  切面  切面就是一个封装共同处理的一个对象 
  * JoinPoint 连接点  目标对象的作用位置(一般指的就是一个方法)
  * Pointcut  切入点  一堆连接点的集合
      (以后使用表达式来表达切入点)
  Target  目标对象 
  * Advice  通知  切面中的逻辑在切入点上执行的时机(前置 后置 环绕 异常 最终)
  * Proxy  代理    通过代理对象 来增强目标对象 
  * JDK 的动态代理 
  * CGLIB 的动态代理 
  * (切面 通知  切点)
  
# 3.写一个服务类UserService  使用IOC 装入Spring  容器 

       有两个方法 一个是 登录  一个是 注册  都是无参。
       在这两个方法中 都做对应的输入。
       在这两个方法执行之前 使用 AOP 输出 $$$$$$
       
# 4.在这两个方法执行之后 使用 AOP 输出 ######  
  
# 5.切入点表达式的写法 
## 5.1 类型限定表达式

           within(表达式)
                  表达式    com.xdl.service.UserService   包  com.xdl.service 下的UserService
                        类型下的所有方法都要纳入到切入点 
                  表达式    com.xdl.service.*   包  com.xdl.service 下的所有类型
                        类型下的所有方法都要纳入到切入点
                  表达式    com.xdl.service.*.*   包  com.xdl.service的直接子包下的所有
                        类型下的所有方法都要纳入到切入点
                 表达式    com.xdl..*   包  com.xdl 包下的 以及子包下的所有
                        类型下的所有方法都要纳入到切入点
                    
## 5.2 方法限定表达式

           execution(表达式)
                   表达式 的构成   权限   返回值类型   方法名 (参数)  异常  这些限制中
                        权限  参数 异常 不是必须的
           void  login()   对所有的login 方法 返回值是void 起作用
           void  log*()    对所有的log 开头方法返回值是void 起作用 
           *   com.xdl.service.UserService.*()   对com.xdl.service.UserService 类型的
                   所有的方法  起作用
               
## 5.3 bean 限定表达式

               以Spring 容器中的 id  名 做的限定  bean(表达式)
       
# 6.通知的五种类型

        <aop:before>    前置通知  目标方法执行之前去切入
        <aop:after-returning>   后置通知 目标方法执行之后去织入 
        <aop:after>   最终通知      目标方法执行之后 无论是否发生异常都会执行
        <aop:around>  环绕通知       目标方法执行的前后 都进行织入 
        <aop:after-throwing>     异常通知  目标方法执行出现异常 则调用对应切面逻辑
    
# 7.基于标注的 aop
## 7.1 建立一个项目   拷贝Spring 的配置文件   和 导入jar包(ioc  和 aop)
## 7.2 开启组件扫描 

            <context:component-scan   base-package="扫描的包"  />
        
## 7.3 开启标注形式的aop 

            <aop:aspectj-autoproxy     proxy-target-class="true" />
            proxy-target-class   是否优先采用cglib 产生代理 
            true 就是直接使用 cglib  false  先使用jdk  如果生不成代理 则使用 cglib
        
## 7.4 写一个业务组件  在业务组件上加对应的标注
## 7.5 编写切面组件  然后在切面组件上加对应的组件扫描标注

              然后在类上加@Aspect 
              然后在切面组件的方法上  加对应的通知标注 
       @Before(切点表达式)   @After(切点表达式)   @Around(切点表达式)  ....
       
## 7.6 获取业务组件 测试 
# 8.通知对应的五个标注

            @Before("表达式")   前置通知   业务方法执行之前
            @After("表达式")   最终通知     业务方法执行之后
            @AfterReturning("表达式")  后置通知  业务方法执行执行之后 
                和  最终通知的区别 是 业务方法出现异常 则不执行 
            @Around("表达式") 环绕通知   业务方法的前后执行  可以 ProceedingJoinPoint 
                   来获取目标对象 以及目标方法的信息 
            @AfterThrowing("表达式")   出现异常就执行 不出现异常就不执行
                  
            正常的执行顺序: 环绕前  前置  业务方法  最终   环绕   后置  
            出异常:  环绕前  前置  业务方法  最终   异常 
     
# 9.使用标注形式的AOP  完成一个登录逻辑 (有余力的可以访问数据库)  
            要求有用户的服务类  和 服务类对应的接口。 要求 统计登录方法的执行时间。
