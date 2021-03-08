# Springboot框架源码解读学习
> Spring框架主要有SpirngMVC提供Web功能执行  
> Springboot提供自动配置功能以及大部分常用资源配置整合做到开箱即用  
> SpringCloud定义了一整套微服务架构所需组件的解决方案
## 1. [Springboot启动过程](https://blog.csdn.net/he1154910941/article/details/114343464)
> 这里启动的ApplicationContextInitializer、ApplicationLinstener和SpringApplicationRunLinstener均在应用上下文实例化之前就已经实例化完毕了,用来参与ApplicationContext应用上下文的构建工作.

> 当ApplicationContext上下文准备完毕后执行ApplicationRunner和CommandLineRunner.
## 2. [SpringBean生命周期](https://blog.csdn.net/he1154910941/article/details/114420353)

### 名词解释
######  BeanDefinition
> Bean整个生命周期包括实例化、初始化、销毁操作需要一个对象进行执行,这个对象就是该Bean的BeanDefinition它包含了Bean的元信息.例如该Bean是否懒加载、是否单例、父类路径、自身类路径、初始化方法名称、销毁方法名称等  
@Configuration注解标记配置类会被解析为AnnotatedGenericBeanDefinition  
@Bean注解标记会被解析为ConfigurationClassBeanDefinition   
 @Service、@Controller、@Repository 以及 @Component 等注解标记的 Bean 则会被识别为 ScannedGenericBeanDefinition

### Bean声明周期经历流程.
> 可查看依赖spring-beans代码中org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory各方法执行流程辅助理解.
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
>
#### Bean销毁工作
> 14. 如果Bean实现了DisposableBean/加了@PreDestroy/定义销毁方法,则Bean在销毁前会执行destory方法  
> 执行顺序 @PreDestroy > DisposableBean > destoryMethod

## 3. AbstractApplicationContext.refresh()
> 该方法被调用于Springboot启动时ApplicationContext初始化完成后执行的refresh(context)方法中.

#### 方法目的
> 该方法实现了将声明/配置的Bean通过Bean加载机制加载到应用上下文容器中.并且在刷新过程中进行了部分的事件广播

## 4. Springboot自动化配置

## 5. Spring AOP

## 6. Spring IOC

## 7. Spring事务

## 8. Spring过滤器

## 9. Spring监听器

## 10. Spring拦截器

## 11. Spring循环依赖

## 12. BeanFactory和FactoryBean区别

