/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.util;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyDebugInterceptor;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyInterceptor;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIProxyException;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Cfg$C;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Utils {
    private static long systemTimeFreqMls = 0L;
    private static long systemTimeFreqMcs = 0L;
    private static final String UNKNOWN_METHOD;
    private static final List DEBUG_IRS;
    private static final ObjectIntMap TYPE_INDEXES;
    private static final int NO_ENTRY;
    public static final long ELAPSED_TIME_NOT_SET;
    public static final String TRACE_PREFIX_SERVICE_INVOCATION;
    public static final String TRACE_PREFIX_UPDATE_INVOCATION;
    public static final String TRACE_PREFIX_LISTENER_INVOCATION;
    private static final IntObjectMap[] SERVICE_METHOD_NAMES;
    private static final IntObjectMap[] LISTENER_METHOD_NAMES;
    private static final List TR_PROXY_EXC_FS;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIBase;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$de$vw$mib$reflection$AbstractProxy;

    private static void storeIndexes(ObjectIntMap objectIntMap, String[] stringArray) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            objectIntMap.put(stringArray[i2], i2);
        }
    }

    public static long currentTimeMillis() {
        if (systemTimeFreqMls == 0L) {
            systemTimeFreqMls = ServiceManager.timerManager.getSystemTimeFrequency() / 0;
        }
        return ServiceManager.timerManager.getSystemTime() / systemTimeFreqMls;
    }

    public static long currentTimeMicros() {
        if (systemTimeFreqMcs == 0L) {
            systemTimeFreqMcs = ServiceManager.timerManager.getSystemTimeFrequency() / 0;
        }
        return ServiceManager.timerManager.getSystemTime() / systemTimeFreqMcs;
    }

    public static void putRuntimeServiceMethodName(int n, int n2, String string) {
        Utils.putSafe(SERVICE_METHOD_NAMES, n, n2, string);
    }

    public static String getRuntimeServiceMethodName(int n, int n2) {
        String string = (String)Utils.getSafe(SERVICE_METHOD_NAMES, n, n2);
        return null != string ? string : "unknown";
    }

    public static void putRuntimeListenerMethodName(int n, int n2, String string) {
        Utils.putSafe(LISTENER_METHOD_NAMES, n, n2, string);
    }

    public static String getRuntimeListenerMethodName(int n, int n2) {
        String string = (String)Utils.getSafe(LISTENER_METHOD_NAMES, n, n2);
        return null != string ? string : "unknown";
    }

    private static Object getSafe(IntObjectMap[] intObjectMapArray, int n, int n2) {
        IntObjectMap intObjectMap = intObjectMapArray[n];
        return null != intObjectMap ? intObjectMap.get(n2) : null;
    }

    private static void putSafe(IntObjectMap[] intObjectMapArray, int n, int n2, Object object) {
        IntObjectMap intObjectMap = intObjectMapArray[n];
        if (null == intObjectMap) {
            intObjectMapArray[n] = intObjectMap = new IntObjectOptHashMap().synchronize();
        }
        intObjectMap.put(n2, object);
    }

    public static int getTypeIndex(Class clazz) {
        return TYPE_INDEXES.get(clazz.getName());
    }

    public static int getTypeIndex(String string) {
        return TYPE_INDEXES.get(string);
    }

    public static void checkDSIServiceType(Class clazz) {
        Utils.checkType(clazz, class$org$dsi$ifc$base$DSIBase == null ? (class$org$dsi$ifc$base$DSIBase = Utils.class$("org.dsi.ifc.base.DSIBase")) : class$org$dsi$ifc$base$DSIBase);
    }

    public static void checkDSIListenerType(Class clazz) {
        Utils.checkType(clazz, class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = Utils.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener);
    }

    public static int getInstDepObjIdx(int n, int n2) {
        return Cfg$C.getInstancesDepObjStartPositions()[n] + n2;
    }

    public static int getNotificationAttrIndex(int n, int[] nArray) {
        int n2;
        for (n2 = 0; n2 < nArray.length && nArray[n2] != n; ++n2) {
        }
        if (nArray.length <= n2) {
            ServiceManager.loggerDSIProxy.error().append("The attribute ").append(n).append(" was not found in attributes collection. ").log();
            n2 = -1;
        }
        return n2;
    }

    public static boolean before(Object[] objectArray, String string, int n, int n2, Object[] objectArray2) {
        boolean bl = true;
        String string2 = string.intern();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            DSIProxyInterceptor dSIProxyInterceptor = (DSIProxyInterceptor)objectArray[i2];
            try {
                bl = bl && dSIProxyInterceptor.before(string2, n, n2, objectArray2);
                continue;
            }
            catch (Throwable throwable) {
                ServiceManager.loggerDSIProxy.error().append(throwable.getMessage()).attachThrowable(throwable).log();
            }
        }
        return bl;
    }

    public static void after(Object[] objectArray, String string, int n, int n2, Object[] objectArray2) {
        String string2 = string.intern();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            DSIProxyInterceptor dSIProxyInterceptor = (DSIProxyInterceptor)objectArray[i2];
            try {
                dSIProxyInterceptor.after(string2, n, n2, objectArray2);
                continue;
            }
            catch (Throwable throwable) {
                ServiceManager.loggerDSIProxy.error().append(throwable.getMessage()).attachThrowable(throwable).log();
            }
        }
    }

    public static void addDebugInterceptor(DSIProxyDebugInterceptor dSIProxyDebugInterceptor) {
        DEBUG_IRS.add(dSIProxyDebugInterceptor);
    }

    public static void removeDebugInterceptor(DSIProxyDebugInterceptor dSIProxyDebugInterceptor) {
        DEBUG_IRS.remove(dSIProxyDebugInterceptor);
    }

    public static void debugInvokeService(int n, int n2, int n3, int n4, Object[] objectArray) {
        if (DEBUG_IRS.size() > 0) {
            for (int i2 = 0; i2 < DEBUG_IRS.size(); ++i2) {
                ((DSIProxyDebugInterceptor)DEBUG_IRS.get(i2)).invokeService(n, n2, n3, n4, objectArray);
            }
        }
    }

    public static void debugInvokeResponseListener(int n, int n2, int n3, Object[] objectArray) {
        if (DEBUG_IRS.size() > 0) {
            for (int i2 = 0; i2 < DEBUG_IRS.size(); ++i2) {
                ((DSIProxyDebugInterceptor)DEBUG_IRS.get(i2)).invokeResponseListener(n, n2, n3, objectArray);
            }
        }
    }

    public static void debugInvokeNotificationListener(int n, int n2, int n3, Object[] objectArray) {
        if (DEBUG_IRS.size() > 0) {
            for (int i2 = 0; i2 < DEBUG_IRS.size(); ++i2) {
                ((DSIProxyDebugInterceptor)DEBUG_IRS.get(i2)).invokeNotificationListener(n, n2, n3, objectArray);
            }
        }
    }

    public static void debugInvokeListenerMethodAdapter(String string, int n, Object[] objectArray) {
        if (DEBUG_IRS.size() > 0) {
            for (int i2 = 0; i2 < DEBUG_IRS.size(); ++i2) {
                ((DSIProxyDebugInterceptor)DEBUG_IRS.get(i2)).invokeListenerMethodAdapter(string, n, objectArray);
            }
        }
    }

    public static boolean isTraceEnabled(int n) {
        return ServiceManager.dsiTraceLogger.isTraceEnabled(RuntimeGeneratedConstants.DSI_TR_SUBCL_MX[n]);
    }

    public static void traceServiceInvoke(int n, int n2, int n3, String string, Object[] objectArray) {
        LogMessage logMessage = ServiceManager.dsiTraceLogger.trace(RuntimeGeneratedConstants.DSI_TR_SUBCL_MX[n]);
        Utils.appendElapsedTime(logMessage, -1L).append("-> DSI-S: ");
        Utils.appendInstanceMethod(logMessage, RuntimeGeneratedConstants.SERVICE_TS_NS[n], n2, string);
        Utils.appendArgs(logMessage, objectArray);
        Utils.appendTargetId(logMessage, n3);
        logMessage.log();
    }

    public static void traceListenerInvocation(int n, int n2, long l, String string, Object[] objectArray) {
        LogMessage logMessage = ServiceManager.dsiTraceLogger.trace(RuntimeGeneratedConstants.DSI_TR_SUBCL_MX[n]);
        Utils.appendElapsedTime(logMessage, l).append("<- DSI-R: ");
        Utils.appendInstanceMethod(logMessage, RuntimeGeneratedConstants.LISTENER_TS_NS[n], n2, string);
        Utils.appendArgs(logMessage, objectArray);
        logMessage.log();
    }

    public static void traceListenerUpdateInvocation(int n, int n2, String string, Object[] objectArray) {
        LogMessage logMessage = ServiceManager.dsiTraceLogger.trace(RuntimeGeneratedConstants.DSI_TR_SUBCL_MX[n]);
        Utils.appendElapsedTime(logMessage, -1L).append("<- DSI-U: ");
        Utils.appendInstanceMethod(logMessage, RuntimeGeneratedConstants.LISTENER_TS_NS[n], n2, string);
        Utils.appendArgs(logMessage, objectArray);
        logMessage.log();
    }

    public static void logListenerAsyncException(int n, int n2, String string, Object[] objectArray) {
        LogMessage logMessage = ServiceManager.dsiTraceLogger.error(RuntimeGeneratedConstants.DSI_TR_SUBCL_MX[n]);
        Utils.appendElapsedTime(logMessage, -1L).append("<- DSI-R: ");
        Utils.appendInstanceMethod(logMessage, RuntimeGeneratedConstants.LISTENER_TS_NS[n], n2, string);
        Utils.appendArgs(logMessage, objectArray);
        logMessage.log();
    }

    public static LogMessage appendArgs(LogMessage logMessage, Object[] objectArray) {
        logMessage.append("(");
        if (0 < objectArray.length) {
            Utils.appendObject(logMessage, objectArray[0]);
            for (int i2 = 1; i2 < objectArray.length; ++i2) {
                logMessage.append(",");
                Utils.appendObject(logMessage, objectArray[i2]);
            }
        }
        return logMessage.append(")");
    }

    private static LogMessage appendElapsedTime(LogMessage logMessage, long l) {
        if (l != -1L) {
            logMessage.append("[").append(l).append("]");
        } else {
            logMessage.append("[na]");
        }
        return logMessage;
    }

    public static LogMessage appendInstance(LogMessage logMessage, String string, int n) {
        return logMessage.append(string).append("[").append(n).append("]");
    }

    public static LogMessage appendInstanceMethod(LogMessage logMessage, String string, int n, String string2) {
        return logMessage.append(string).append("[").append(n).append("].").append(string2);
    }

    public static StringBuffer appendInstanceMethod(StringBuffer stringBuffer, String string, int n, String string2) {
        return stringBuffer.append(string).append("[").append(n).append("].").append(string2);
    }

    public static LogMessage appendTargetId(LogMessage logMessage, int n) {
        logMessage.append(" [target: ");
        if (-2 == n) {
            logMessage.append("ALL");
        } else if (-1 == n) {
            logMessage.append("UNDEF");
        } else {
            logMessage.append(n);
        }
        return logMessage.append("]");
    }

    private static LogMessage appendObject(LogMessage logMessage, Object object) {
        if (object == null) {
            logMessage.append("null");
        } else {
            Class clazz = object.getClass();
            if (clazz.isArray()) {
                Utils.appendArray(logMessage, object);
            } else {
                logMessage.append(object.toString());
                if ((class$de$vw$mib$reflection$AbstractProxy == null ? (class$de$vw$mib$reflection$AbstractProxy = Utils.class$("de.vw.mib.reflection.AbstractProxy")) : class$de$vw$mib$reflection$AbstractProxy).isAssignableFrom(clazz)) {
                    logMessage.append("[");
                    Field[] fieldArray = clazz.getDeclaredFields();
                    boolean bl = true;
                    for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                        Field field = fieldArray[i2];
                        if (Modifier.isStatic(field.getModifiers()) || TR_PROXY_EXC_FS.contains(field.getName())) continue;
                        if (!bl) {
                            logMessage.append(",");
                        } else {
                            bl = false;
                        }
                        Utils.appendField(logMessage, field, object);
                    }
                    logMessage.append("]");
                }
            }
        }
        return logMessage;
    }

    private static LogMessage appendArray(LogMessage logMessage, Object object) {
        logMessage.append("{");
        int n = Array.getLength(object);
        if (0 < n) {
            Utils.appendObject(logMessage, Array.get(object, 0));
            for (int i2 = 1; i2 < n; ++i2) {
                logMessage.append(",");
                Utils.appendObject(logMessage, Array.get(object, i2));
            }
        }
        return logMessage.append("}");
    }

    private static LogMessage appendField(LogMessage logMessage, Field field, Object object) {
        field.setAccessible(true);
        logMessage.append(field.getName());
        logMessage.append("=");
        try {
            Utils.appendObject(logMessage, field.get(object));
        }
        catch (IllegalAccessException illegalAccessException) {
            logMessage.append("???");
        }
        return logMessage;
    }

    private static void checkType(Class clazz, Class clazz2) {
        if (!clazz2.isAssignableFrom(clazz)) {
            String string = new StringBuffer().append("Wrong type. The class ").append(clazz).append(" is not assignable from ").append(clazz2).toString();
            ServiceManager.loggerDSIProxy.error().append(string).log();
            throw new DSIProxyException(string);
        }
    }

    private Utils() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        DEBUG_IRS = new ArrayList();
        SERVICE_METHOD_NAMES = new IntObjectMap[RuntimeGeneratedConstants.INST_NMBS.length];
        LISTENER_METHOD_NAMES = new IntObjectMap[RuntimeGeneratedConstants.INST_NMBS.length];
        int n = RuntimeGeneratedConstants.SERVICE_TS_NS.length + RuntimeGeneratedConstants.LISTENER_TS_NS.length;
        ObjectIntOptHashMap objectIntOptHashMap = ObjectIntOptHashMap.createWithNeutralValue(n, 63, 63, -1);
        Utils.storeIndexes(objectIntOptHashMap, RuntimeGeneratedConstants.SERVICE_TS_NS);
        Utils.storeIndexes(objectIntOptHashMap, RuntimeGeneratedConstants.LISTENER_TS_NS);
        TYPE_INDEXES = objectIntOptHashMap;
        TR_PROXY_EXC_FS = Arrays.asList(new String[]{"p", "h"});
    }
}

