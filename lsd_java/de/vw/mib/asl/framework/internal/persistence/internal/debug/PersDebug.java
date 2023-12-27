/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.debug;

import de.vw.mib.asl.framework.api.persistence.PersistenceNamespace;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.LogUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.PrivateUtil;
import java.lang.reflect.Field;
import java.util.HashMap;

public final class PersDebug {
    public static boolean mVerbose = false;
    public static final String PTEXT;
    private static final int LEN_ACTION;
    private static final int LEN_TYPE;
    private static final int LEN_RESULT;
    private static final int LEN_KEYNAME;
    private static final int LEN_KEY;
    private static final int LEN_NAMESPACE;
    private static HashMap mKeyNames;

    public static String getNamespaceName(int n) {
        if (n <= 5028 && n >= 1101) {
            int n2 = PrivateUtil.getIndexOfNamespaceInArray(n);
            if (n2 >= 0) {
                return PersistenceNamespace.NAMESPACENAMES[n2];
            }
        } else {
            int n3 = PrivateUtil.getIndexOfDiagNamespaceInArray(n);
            if (n3 >= 0) {
                return PersistenceNamespace.DIAG_NAMESPACENAMES[n3];
            }
        }
        return "?";
    }

    static Class getNamespace(int n) {
        int n2 = PrivateUtil.getIndexOfNamespaceInArray(n);
        if (n2 >= 0) {
            return PersistenceNamespace.NAMESPACECLASSES[n2];
        }
        return null;
    }

    static String keyString(long l) {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("0x");
        stringBuffer.append(Long.toHexString(l));
        stringBuffer.append("(");
        long l2 = l & 0;
        stringBuffer.append(l2);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public static String namespaceKeyString(int n, long l) {
        StringBuffer stringBuffer = new StringBuffer(60);
        stringBuffer.append("[namespace=");
        stringBuffer.append(n);
        stringBuffer.append("][key=");
        stringBuffer.append(PersDebug.keyString(l));
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    static String resultString(int n) {
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append("[result=");
        stringBuffer.append(n);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static String dirtyString(boolean bl) {
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append("[dirty=");
        stringBuffer.append(bl);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static String getKeyName(int n, long l) {
        Class clazz;
        Long l2 = new Long((long)n * l);
        String string = (String)mKeyNames.get(l2);
        if (string == null && (clazz = PersDebug.getNamespace(n)) != null) {
            Field[] fieldArray = clazz.getFields();
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                try {
                    if (l != fieldArray[i2].getLong(null)) continue;
                    string = fieldArray[i2].getName();
                    mKeyNames.put(l2, string);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                }
                catch (IllegalAccessException illegalAccessException) {}
                break;
            }
        }
        return string == null ? "?" : string;
    }

    static String getResultName(int n) {
        String string;
        switch (n) {
            case 5: {
                string = "corrupt data";
                break;
            }
            case 9: {
                string = "device busy";
                break;
            }
            case 10: {
                string = "dummy data";
                break;
            }
            case 2: {
                string = "invalid key";
                break;
            }
            case 1: {
                string = "invalid namespace";
                break;
            }
            case 6: {
                string = "no device available";
                break;
            }
            case 0: {
                string = "ok";
                break;
            }
            case 3: {
                string = "no space";
                break;
            }
            case 11: {
                string = "not notified";
                break;
            }
            case 8: {
                string = "timeout";
                break;
            }
            case 4: {
                string = "transaction failed";
                break;
            }
            case 7: {
                string = "wrong param length";
                break;
            }
            default: {
                string = "---";
            }
        }
        return string;
    }

    static String getTypeString(byte by) {
        String string;
        switch (by) {
            case 1: {
                string = "Integer";
                break;
            }
            case 3: {
                string = "byte[]";
                break;
            }
            case 2: {
                string = "String";
                break;
            }
            case 4: {
                string = "String[]";
                break;
            }
            default: {
                string = "---";
            }
        }
        return string;
    }

    public static void ioLog(String string, int n, long l, int n2, byte by, String string2) {
        if (PersDebug.isDebugEnabled()) {
            String string3;
            String string4;
            String string5 = PersDebug.getNamespaceName(n);
            if (string5 != null) {
                string4 = PersDebug.keyString(l);
                string3 = PersDebug.getKeyName(n, l);
            } else {
                string5 = Integer.toHexString(n);
                string4 = Long.toHexString(l);
                string3 = PersDebug.keyString(l);
            }
            PersDebug.ioLog(string, string5, string4, string3, PersDebug.getResultName(n2), PersDebug.getTypeString(by), string2);
        }
    }

    private static boolean isDebugEnabled() {
        return ServiceManager.logger.isTraceEnabled(32);
    }

    public static void writeTableHeader() {
        PersDebug.ioLog("ACTION", "NAMESPACE", "KEY HEX", "ID", "RESULT", "TYPE", "DATA");
    }

    private static void ioLog(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        if (PersDebug.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer(200);
            stringBuffer.append("Persistence: ");
            stringBuffer.append(LogUtil.fixLength(string, 6, false));
            stringBuffer.append('|');
            stringBuffer.append(LogUtil.fixLength(string2, 13, false));
            stringBuffer.append('|');
            stringBuffer.append(LogUtil.fixLength(string3, 17, false));
            stringBuffer.append('|');
            stringBuffer.append(LogUtil.fixLength(string4, 40, false));
            stringBuffer.append('|');
            stringBuffer.append(LogUtil.fixLength(string5, 20, false));
            stringBuffer.append('|');
            stringBuffer.append(LogUtil.fixLength(string6, 7, false));
            stringBuffer.append('|');
            stringBuffer.append(string7);
            PersDebug.trace(stringBuffer.toString(), false);
        }
    }

    public static void trace(String string, boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(32)) {
            if (bl) {
                ServiceManager.logger.trace(32).append("Persistence: ").append(string).log();
            } else {
                ServiceManager.logger.trace(32, string);
            }
        }
    }

    public static boolean isTraceEnabled() {
        return ServiceManager.logger.isTraceEnabled(32);
    }

    public static void info(String string) {
        ServiceManager.logger.info(32, string);
    }

    public static void info(String string, String string2) {
        ServiceManager.logger.info(32).append("Persistence: ").append(string).append(string2).log();
    }

    public static void warn(String string) {
        ServiceManager.logger.warn(32, string);
    }

    public static void error(Throwable throwable) {
        ServiceManager.logger.error(32).append("Persistence: ").attachThrowable(throwable).log();
    }

    public static void error(String string, Throwable throwable) {
        ServiceManager.logger.error(32).append("Persistence: ").append(string).attachThrowable(throwable).log();
    }

    static {
        mKeyNames = new HashMap(100);
    }
}

