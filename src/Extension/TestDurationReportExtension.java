package Extension;

import java.lang.reflect.Method;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

/**
 * This extension class measures how long a test runs
 * Calculated time is based on the difference between
 *   start and end execution time of each test cases
 * Code from: https://www.mscharhag.com/java/junit5-custom-extensions
 * */
public class TestDurationReportExtension implements InvocationInterceptor {
	 
    @Override
    public void interceptTestMethod(Invocation<Void> invocation,
            ReflectiveInvocationContext<Method> invocationContext,
            ExtensionContext extensionContext) throws Throwable {
 
        long beforeTest = System.currentTimeMillis();
        try {
            invocation.proceed();
        } finally {
            long afterTest = System.currentTimeMillis();
            long duration = afterTest - beforeTest;
             
            // InvocationContext is used obtain the names of the test class and test method
            String testClassName = invocationContext.getTargetClass().getSimpleName();
            String testMethodName = invocationContext.getExecutable().getName();
            // output formatted message
            System.out.println(String.format("%s.%s: %dms", testClassName, testMethodName, duration));
        }
    }
}
