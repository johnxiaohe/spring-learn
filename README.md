# Springboot框架源码解读学习
> Spring框架主要有SpirngMVC提供Web功能执行  
> Springboot提供自动配置功能以及大部分常用资源配置整合做到开箱即用  
> SpringCloud定义了一整套微服务架构所需组件的解决方案
## 1. [Springboot启动过程](https://blog.csdn.net/he1154910941/article/details/114343464)
> 这里启动的Linstener均在应用上下文就已经实例化完毕了,而且Linstener也不是Spring组件,所以无法进行Spring的Bean注入操作.但是当context刷新完毕后可以通过context工厂获取Bean

## 2. SpringBean生命周期
git commit -m ":parkage: SpringBean生命周期全流程拓展类添加完毕"
> 1. Bean名称被扫描器加载到Context中
> 2. 所有BeanDefinition被注册后会执行BeanDefinitionRegistoryPostProcess.postProcessBeanDefinitionRegistory()方法,可在这找到BeanDefinition进行修改(选看)
> 3. BeanFactory被注册后会执行BeanFactoryPostProcessor.postProcessBeanFactory方法(选看)
> 4. Bean实例化之前会执行InstantiationAwareBeanPostProcess.postProcessBeforeInstantiation()方法
> 5. Bean实例化之后会执行InstantiationAwareBeanPostProcess.postProcessAfterInstantiation()方法
> 6. Bean实例化后设置属性后会继续执行InstantiationAwareBeanPostProcess.postProcessProperties方法
> 7. Bean实例化后设置属性值后会继续执行InstantiationAwareBeanPostProcess.postProcessPropertyValues方法
> 8. Bean如果实现了BeanNameAware则会执行setBeanName方法
> 9. Bean如果实现了BeanFactoryAware则会执行setBeanFactory方法
> 10. Bean如果实现了ApplicationContextAware则会执行setApplicationContext方法
> 11. Bean执行初始化之前执行BeanPostProcess.postProcessBeforInitialization方法
> 12. Bean如果实现了InitializingBean则会执行afterPropertiesSet方法/加了@PostConstruct/指定初始化方法则会执行初始化方法
> 13. Bean执行初始化之后执行BeanPostProcess.postProcessAfterInitialization方法
> 14. 如果Bean实现了DisposableBean/加了@PreDestroy/定义销毁方法,则Bean在销毁前会执行destory方法  
> 执行顺序 @PostConstruct > InitializingBean > init-method  
> 执行顺序 @PreDestroy > DisposableBean > destoryMethod
## 3. Spring AOP

## 4. Spring IOC

## 5. Spring事务

## 6. Spring过滤器

## 7. Spring监听器

## 8. Spring拦截器