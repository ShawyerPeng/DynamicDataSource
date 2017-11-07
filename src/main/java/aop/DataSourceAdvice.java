package aop;

import annotation.DataSourceEnum;
import annotation.DateSource;
import datasource.DataSourceSwitcher;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据源切面类，通过 aop 来控制数据源的切换。获取方法上的自定义注解，然后根据注解内容判断，动态设置数据源。
 */
@Aspect
@Component
public class DataSourceAdvice {
    /**
     * 必须为 final String 类型的, 注解里要使用的变量只能是静态常量类型的
     */
    private static final String EDP = "execution(* mapper.*.*(..))";

    @After(EDP)
    public void afterReturning() {
        DataSourceSwitcher.setSlave();
    }

    @Before(EDP)
    public void before(JoinPoint joinPoint) {
        System.out.println("=================");
        String methodNm = joinPoint.getSignature().getName();
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodNm)) {
                DateSource d = method.getAnnotation(DateSource.class);
                if (d != null) {
                    DataSourceEnum value = d.value();
                    if (value.equals(DataSourceEnum.MASTER)) {
                        DataSourceSwitcher.setMaster();
                    } else {
                        DataSourceSwitcher.setSlave();
                    }
                }
                break;
            }
        }
    }
}
