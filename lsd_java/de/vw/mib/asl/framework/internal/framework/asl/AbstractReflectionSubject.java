/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.asl;

import de.vw.mib.asl.framework.api.framework.reflection.MethodAccessible;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.asl.ApiHandler;
import de.vw.mib.asl.framework.internal.framework.asl.EventNameResolver;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.reflection.MethodAccessibleObject;
import java.lang.reflect.Method;

public class AbstractReflectionSubject
implements MethodAccessible {
    final MethodAccessibleObject mao = ServiceManager.reflectionFactory.getMao(super.getClass().getName());
    public final ApiHandler myTarget;

    public AbstractReflectionSubject(ApiHandler apiHandler) {
        this.myTarget = apiHandler;
        Method[] methodArray = super.getClass().getMethods();
        for (int i2 = 0; i2 < methodArray.length; ++i2) {
            String string = methodArray[i2].getName();
            if (!string.startsWith("evtASL")) continue;
            try {
                int n = EventNameResolver.resolveEventId(string.substring(3));
                this.myTarget.regEvt(n);
                continue;
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public boolean handleBefore(String string, Class[] classArray, Object[] objectArray) {
        boolean bl = true;
        int n = this.mao.getIndex(new StringBuffer().append("before").append(string).toString());
        if (n != -1) {
            try {
                Object object = this.mao.invoke(n, this, new Object[]{classArray, objectArray});
                if (Boolean.FALSE.equals(object)) {
                    bl = false;
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
        return bl;
    }

    public void handleNormal(String string, Class[] classArray, Object[] objectArray) {
        int n = this.mao.getIndex(new StringBuffer().append("evt").append(string).toString());
        if (n != -1) {
            try {
                int n2;
                LogMessage logMessage;
                if (this.myTarget.isFuntionNameTracing()) {
                    logMessage = ServiceManager.logger.trace(16384).append("ENTER ").append(super.getClass().getName()).append(".").append("evt").append(string).append("(");
                    for (n2 = 0; n2 < objectArray.length; ++n2) {
                        if (n2 > 0) {
                            logMessage = logMessage.append(", ");
                        }
                        logMessage = logMessage.append(objectArray[n2]);
                    }
                    logMessage.append(" )").log();
                }
                this.mao.invoke(n, this, objectArray);
                if (this.myTarget.isFuntionNameTracing()) {
                    logMessage = ServiceManager.logger.trace(16384).append("LEAVE ").append(super.getClass().getName()).append(".").append("evt").append(string).append("(");
                    for (n2 = 0; n2 < objectArray.length; ++n2) {
                        if (n2 > 0) {
                            logMessage = logMessage.append(", ");
                        }
                        logMessage = logMessage.append(objectArray[n2]);
                    }
                    logMessage.append(" )").log();
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public void handleAfter(String string, Class[] classArray, Object[] objectArray) {
        int n = this.mao.getIndex(new StringBuffer().append("after").append(string).toString());
        if (n != -1) {
            try {
                this.mao.invoke(n, this, new Object[]{classArray, objectArray});
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }
}

