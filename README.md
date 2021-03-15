# Springboot框架源码解读学习
> Spring框架主要有SpirngMVC提供Web功能执行  
> Springboot提供自动配置功能以及大部分常用资源配置整合做到开箱即用  
> SpringCloud定义了一整套微服务架构所需组件的解决方案
> 每个大标题都是学习记录笔记
## 1. [Springboot启动过程](https://blog.csdn.net/he1154910941/article/details/114343464)
> 这里启动的ApplicationContextInitializer、ApplicationLinstener和SpringApplicationRunLinstener均在应用上下文实例化之前就已经实例化完毕了,用来参与ApplicationContext应用上下文的构建工作.

> 当ApplicationContext上下文准备完毕后执行ApplicationRunner和CommandLineRunner.
## 2. [SpringBean生命周期](https://blog.csdn.net/he1154910941/article/details/114420353)
> SpringBean生命周期其实就是考察Spring在对Bean实例化加入容器中时所执行的各种我们可拓展动作,这些动作按照时期分为`实例化准备前`、`实例化前后`、`赋值后`、`初始化前中后`以及`销毁`  
> 可通过查看`org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory的doCreateBean()方法`以及`Springboot启动`了解
```text
#### 实例化前期准备工作(只执行一次)
> 1. 扫描器加载类信息到Context中
> 2. 所有BeanDefinition被注册后会执行BeanDefinitionRegistoryPostProcess.postProcessBeanDefinitionRegistory()方法,可在这找到BeanDefinition进行修改(选看,这里可获取到BeanDefinitionRegistory.可进行Bean元数据信息修改)
> 3. BeanFactory被注册后会执行BeanFactoryPostProcessor.postProcessBeanFactory方法(选看,可获取到BeanFactory)

#### 实例化中工作
> 4. Bean实例化之前会执行InstantiationAwareBeanPostProcess.postProcessBeforeInstantiation()方法
> 5. Bean实例化之后会执行InstantiationAwareBeanPostProcess.postProcessAfterInstantiation()方法

#### 实例化后属性赋值工作
> 6. Bean实例化后设置属性后会继续执行InstantiationAwareBeanPostProcess.postProcessProperties方法
> 7. Bean实例化后设置属性值后会继续执行InstantiationAwareBeanPostProcess.postProcessPropertyValues方法

#### 属性设置完毕后Awear实现Bean全局属性设置操作
> 8. Bean如果实现了BeanNameAware则会执行setBeanName方法
> 9. Bean如果实现了BeanFactoryAware则会执行setBeanFactory方法
> 10. Bean如果实现了ApplicationContextAware则会执行setApplicationContext方法

#### Bean初始化工作
> 11. Bean执行初始化之前执行BeanPostProcess.postProcessBeforInitialization方法
> 12. Bean如果实现了InitializingBean则会执行afterPropertiesSet方法/加了@PostConstruct/指定初始化方法则会执行初始化方法
> 13. Bean执行初始化之后执行BeanPostProcess.postProcessAfterInitialization方法  
> 执行顺序 @PostConstruct > InitializingBean > init-method  

#### Bean销毁工作
> 14. 如果Bean实现了DisposableBean/加了@PreDestroy/定义销毁方法,则Bean在销毁前会执行destory方法  
> 执行顺序 @PreDestroy > DisposableBean > destoryMethod

```

## 3. AbstractApplicationContext.refresh()
> 该方法被调用于Springboot启动时ApplicationContext初始化完成后执行的refresh(context)方法中.

#### 方法目的
> 该方法实现了将声明/配置的Bean通过Bean加载机制加载到应用上下文容器中.并且在刷新过程中进行了部分的事件广播

## 4. [Springboot自动装配](https://blog.csdn.net/he1154910941/article/details/114684188)
> Springboot自动装配就是通过SPI思想将外部定义的自动配置类通过配置文件/注解获取类信息并加载以实现自动装配的功能,能让我们做到大部分功能依赖开箱即用

## 5. [Spring AOP](https://blog.csdn.net/he1154910941/article/details/114582978)
> Aop思想是对OOP思想的补充拓展,通过对离散的不同核心业务模块对象的共同系统需求功能,例如日志、性能监控等  
> 通过将共性需求在核心业务执行时动态的织入其中,实现对业务逻辑不造成侵入与代码重复性.

## 6. [Spring IOC](https://blog.csdn.net/he1154910941/article/details/114859502)
> SpringIOC设计思想是面向对象应用中对于对象间依赖关系松耦合、资源复用以及对象统一的生命周期管理的实现方案介绍  
> 对象的创建以及对象依赖组件的创建均由IOC容器实现,他们只需声明自己是否需要由IOC容器管理即可  
> 其次IOC容器还将对象的依赖在初始化时动态注入进去(DI),对象只需声明所需依赖类型即可,而不需要知道注入依赖的具体对象  
> 对于对象的生命周期管理交由IOC容器管理,对象仅对依赖有使用权,方便IOC容器进行功能拓展

## 7. Spring事务

## 8. Spring过滤器

## 9. Spring监听器

## 10. Spring拦截器

## 11. [Spring循环依赖](https://blog.csdn.net/he1154910941/article/details/114612034)
> 首先当Bean未有循环依赖三级缓存是没有什么意义的,当有循环依赖但Bean并没有AOP代理,则会直接返回原对象,也没有什么意义.  
> 主要在当Bean存在循环依赖并且还有AOP代理时,三级缓存才有效果  
> 三级缓存主要预防Bean有依赖时还可以完成代理增强(可查看`SmartInstanttiationAwareBeanPostProcessor.getEarlyBeanReference方法`以及`AbstractAutowireCapableBeanFactory类595行和966行`)  
> 而本身Spring设计Bean的代理增强是在Bean初始化完成后的AnnotationAwareAspectJAutoProxyCreator后置处理器中完成的.提前执行则和设计思路不服.所以**三级缓存主要起预防循环依赖作用,可能是一个补丁机制**

## 12. BeanFactory和FactoryBean区别
###### BeanFactory(Bean工厂)
> 是一个容器,用于管理Bean  
> 属于IOC容器接口,定义IOC容器管理Bean的规范接口.用于管理Bean(查找Bean以及获取Bean部分元信息)

###### FactoryBean(Bean创建工厂)
> 是一个功能Bean,用于创建目标对象  
> 是接口,提供了Bean创建的拓展方式.实现该接口并实现getObject方法用于自定义指定类的创建逻辑
> [使用Demo](https://github.com/johnxiaohe/spring-learn/blob/master/src/main/java/com/reuben/springlearn/start/config/CustomFactoryBean.java)

## 13. SpringMVC和Springboot分别负责什么功能(区别)
