package com.reuben.springlearn.aop.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//表示该类为一个切面模块类, order越小执行顺序越靠前
@Slf4j
@Aspect
@Order(0)
@Component
public class MethodRunLogAspect {

    public static List<String> vips = new ArrayList<>();

    public MethodRunLogAspect() {
        vips.add("老王");
        vips.add("老许");
        vips.add("老李");
    }

    //通过注解定义切入点
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void requestLogAdvicePointcut(){}

    //通过路径表达式定义切入点
    /**
     * 第一个 * 表示定义返回值类型为所有类型
     * 中间路径为要切入的包名,包名后面两个点表示当前包和其下子包.一个点表示当前包
     * 第二个 * 表示定义的类名为所有类
     * 最后的 *(..) *表示所有方法,括号中两个.表示所有参数
     */
    @Pointcut("execution(* com.reuben.springlearn.aop.jointPoint.service.impl.*.*(..))")
    private void implMethodAdvicePointcut(){}

    // 连接点前置通知,将在连接点执行前执行.可进行一些日志记录工作
    @Before("requestLogAdvicePointcut()")
    public void beforRequest(JoinPoint joinPoint){
        Signature signature =joinPoint.getSignature();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();
        String name = args[0].toString();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();

        Boolean vip = vips.contains(name);
        log.info("===========================");
        log.info("访问人 : "+ name );
        log.info("源地址 : "+ ip);
        log.info("访问路径 : "+ url);
        log.info("是否是会员 : " + ( vip ? "是会员":"不是会员"));
        log.info("访问方法 : "+methodName);
        log.info("===========================");
    }

    //环绕通知,可在方法前后进行通知处理,效率计算,并根据判断进行方法执行/提前结束.类似于MethodInterceptor
    @SneakyThrows
    @Around("requestLogAdvicePointcut()")
    public Object filterVip(ProceedingJoinPoint joinPoint){
        Signature signature =joinPoint.getSignature();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();
        String name = args[0].toString();
        Boolean vip = vips.contains(name);
        if(methodName.contains("vip") && !vip){
            return "该服务只能尊贵的VIP会员才能享受";
        }
        Long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long end = System.currentTimeMillis();
        log.info(methodName+"方法执行使用了"+ (end-start)+"ms");
        return result;
    }

    //后置通知,可进行一些执行之后的处理记录工作,方法正常执行与否都会执行该注解标记的方法
    @After("implMethodAdvicePointcut()")
    public void implAfter(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        log.info(args[0].toString() +"访问方法"+methodName+"成功");
    }

    // 方法后置返回通知,该通知可获取到方法返回信息.对返回信息进行记录或增强.只有方法正常执行后才会执行
    @AfterReturning(pointcut = "implMethodAdvicePointcut()", returning = "result")
    public void checkResult(JoinPoint joinPoint, Boolean result){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        log.info("方法"+methodName+"返回值是: "+result.toString());
    }

    // 切入方法发生异常时会执行该注解标记的方法.
    @AfterThrowing(pointcut = "implMethodAdvicePointcut()", throwing = "e")
    public void throwMethod(JoinPoint joinPoint, RuntimeException e){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        log.info("方法"+methodName+"抛出异常"+e.getClass().getSimpleName()+";异常信息为 : "+e.getMessage());
    }

}
