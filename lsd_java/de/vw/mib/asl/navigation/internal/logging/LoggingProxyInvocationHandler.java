/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navigation.internal.logging;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoggingProxyInvocationHandler
implements InvocationHandler {
    private Object proxyTarget;

    public LoggingProxyInvocationHandler(Object object) {
        this.proxyTarget = object;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) {
        Object object2;
        if (method == null) {
            throw new NullPointerException("Method to invoke is null");
        }
        String string = this.proxyTarget.getClass().getName();
        String string2 = string.substring(string.lastIndexOf(46) + 1);
        String string3 = method.getName();
        String string4 = this.buildParameterString(objectArray);
        String string5 = new StringBuffer().append("[LoggingProxy] Start calling method ").append(string3).append(" on class ").append(string2).append(" with parameters ").append(string4).toString();
        String string6 = new StringBuffer().append("[LoggingProxy] Calling method ").append(string3).append(" on class ").append(string2).append(" finished.").toString();
        try {
            ServiceManager.logger.trace(16384, string5);
            object2 = method.invoke(this.proxyTarget, objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new InvocationTargetException(invocationTargetException, new StringBuffer().append("InvocationTargetException for method ").append(string3).append(" in class ").append(string2).toString());
        }
        catch (Exception exception) {
            throw new RuntimeException(new StringBuffer().append("unexpected invocation exception: ").append(exception.getMessage()).toString());
        }
        finally {
            ServiceManager.logger.trace(16384, string6);
        }
        return object2;
    }

    private String buildParameterString(Object[] objectArray) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                Object object = objectArray[i2];
                if (object == null) {
                    stringBuffer.append("null");
                } else {
                    String string = object.toString();
                    int n = string.lastIndexOf(46);
                    if (n > -1) {
                        string = string.substring(n + 1);
                    }
                    stringBuffer.append(string);
                }
                if (i2 >= objectArray.length - 1) continue;
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

