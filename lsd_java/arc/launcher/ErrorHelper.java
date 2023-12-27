/*
 * Decompiled with CFR 0.152.
 */
package arc.launcher;

import arc.launcher.BundleLoader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.osgi.framework.BundleException;

public class ErrorHelper {
    private static String DEBUG_PREFIX_STRING;
    static /* synthetic */ Class class$0;

    public static void setDebugPrefix(String string) {
        DEBUG_PREFIX_STRING = string;
    }

    public static void println(String string) {
        System.out.println(new StringBuffer(String.valueOf(DEBUG_PREFIX_STRING)).append(string).toString());
    }

    public static void printStackTrace(Throwable throwable) {
        if (!BundleLoader.DEBUG) {
            return;
        }
        if (throwable == null) {
            return;
        }
        ErrorHelper.println(ErrorHelper.getStackTrace(throwable));
        Method[] methodArray = super.getClass().getMethods();
        int n = methodArray.length;
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.lang.Throwable");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        Class clazz2 = clazz;
        int n2 = 0;
        while (n2 < n) {
            Method method = methodArray[n2];
            if (Modifier.isPublic(method.getModifiers()) && method.getName().startsWith("get") && clazz2.isAssignableFrom(method.getReturnType()) && method.getParameterTypes().length == 0) {
                try {
                    Throwable throwable2 = (Throwable)method.invoke(throwable, null);
                    if (throwable2 != null && throwable2 != throwable) {
                        ErrorHelper.println("Nested Exception:");
                        ErrorHelper.printStackTrace(throwable2);
                    }
                }
                catch (IllegalAccessException illegalAccessException) {
                }
                catch (InvocationTargetException invocationTargetException) {}
            }
            ++n2;
        }
    }

    private static String getStackTrace(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        Throwable throwable2 = ErrorHelper.getRoot(throwable);
        if (throwable2 != null) {
            printWriter.println("Root exception:");
            throwable2.printStackTrace(printWriter);
        }
        return ((Object)stringWriter).toString();
    }

    private static Throwable getRoot(Throwable throwable) {
        Throwable throwable2;
        Throwable throwable3 = null;
        if (throwable instanceof BundleException) {
            throwable3 = ((BundleException)throwable).getNestedException();
        }
        if (throwable instanceof InvocationTargetException) {
            throwable3 = ((InvocationTargetException)throwable).getTargetException();
        }
        if ((throwable3 instanceof InvocationTargetException || throwable3 instanceof BundleException) && (throwable2 = ErrorHelper.getRoot(throwable3)) != null) {
            throwable3 = throwable2;
        }
        return throwable3;
    }
}

