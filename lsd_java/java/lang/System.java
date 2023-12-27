/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.SystemProperties;
import com.ibm.oti.util.SystemPropertiesHook;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.AccessController;
import java.util.Properties;
import java.util.PropertyPermission;

public final class System {
    public static final InputStream in;
    public static final PrintStream out;
    public static final PrintStream err;
    private static final Runtime RUNTIME;
    private static Properties systemProperties;
    private static SecurityManager security;
    private static final int InitLocale;
    private static final int PlatformEncoding;
    private static final int FileEncoding;
    private static final int OSEncoding;

    static {
        RUNTIME = Runtime.getRuntime();
        System.ensureProperties();
        err = new String$ConsolePrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.err)));
        out = new String$ConsolePrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)));
        in = new BufferedInputStream(new FileInputStream(FileDescriptor.in));
    }

    static void completeInitialization() {
        String string = (String)systemProperties.get("com.ibm.util.extralibs.properties");
        if (string != null) {
            int n = 0;
            while (n < string.length()) {
                int n2 = string.indexOf(58, n);
                if (n2 == -1) {
                    n2 = string.length();
                }
                String string2 = string.substring(n, n2).trim();
                n = n2 + 1;
                if (string2.length() == 0) continue;
                try {
                    String string3 = new StringBuffer("com.ibm.oti.").append(string2).append(".SystemPropertyExtension").toString();
                    Class clazz = Class.forName(string3);
                    Object object = clazz.newInstance();
                    try {
                        if (object instanceof SystemPropertiesHook) {
                            systemProperties = (Properties)((SystemPropertiesHook)object).extendSystemProperties(systemProperties);
                            continue;
                        }
                        ((SystemProperties)object).extendSystemProperties(systemProperties);
                    }
                    catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
                catch (Throwable throwable) {}
            }
        }
        System.installSecurityManager();
    }

    private static void installSecurityManager() {
        String string;
        if (System.getSecurityManager() == null && (string = System.getProperty("java.security.manager")) != null) {
            SecurityManager securityManager = null;
            if (string.length() == 0) {
                securityManager = new SecurityManager();
            } else {
                try {
                    Class clazz = Class.forName(string);
                    securityManager = (SecurityManager)clazz.newInstance();
                }
                catch (Exception exception) {
                    throw new InternalError(Msg.getString("K00e3", string));
                }
            }
            System.setSecurityManager(securityManager);
        }
    }

    public static void setIn(InputStream inputStream) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(RuntimePermission.permissionToSetIO);
        }
        System.setFieldImpl("in", inputStream);
    }

    public static void setOut(PrintStream printStream) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(RuntimePermission.permissionToSetIO);
        }
        System.setFieldImpl("out", printStream);
    }

    public static void setErr(PrintStream printStream) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(RuntimePermission.permissionToSetIO);
        }
        System.setFieldImpl("err", printStream);
    }

    private System() {
    }

    public static native void arraycopy(Object object, int n, Object object2, int n2, int n3) {
    }

    private static void arraycopy(Object[] objectArray, int n, Object[] objectArray2, int n2, int n3) {
        if (objectArray == null || objectArray2 == null) {
            throw new NullPointerException();
        }
        if (n >= 0 && n2 >= 0 && n3 >= 0 && n3 <= objectArray.length - n && n3 <= objectArray2.length - n2) {
            if (objectArray != objectArray2 || n > n2 || n + n3 <= n2) {
                int n4 = 0;
                while (n4 < n3) {
                    objectArray2[n2 + n4] = objectArray[n + n4];
                    ++n4;
                }
            } else {
                int n5 = n3 - 1;
                while (n5 >= 0) {
                    objectArray2[n2 + n5] = objectArray[n + n5];
                    --n5;
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static native long currentTimeMillis() {
    }

    private static void ensureProperties() {
        String string;
        systemProperties = new Properties();
        String string2 = null;
        String string3 = null;
        String string4 = System.getEncoding(2);
        String string5 = System.getEncoding(3);
        if (string4 != null) {
            string = string4;
            if (string5 == null) {
                string3 = string2 = System.getEncoding(1);
            } else {
                System.getEncoding(0);
            }
        } else {
            string = string2 = System.getEncoding(1);
        }
        if (string3 == null) {
            string3 = string5;
        }
        if (string3 != null) {
            systemProperties.put("os.encoding", string3);
        }
        systemProperties.put("file.encoding", string);
        systemProperties.put("microedition.commports", System.getCommPortList());
        systemProperties.put("java.specification.vendor", "Sun Microsystems Inc.");
        systemProperties.put("java.specification.name", "J2ME Foundation Specification");
        systemProperties.put("java.specification.version", "1.1");
        systemProperties.put("java.version", "J2ME Foundation Specification v1.1");
        systemProperties.put("com.ibm.oti.configuration", "foun11");
        systemProperties.put("com.ibm.oti.configuration.dir", "jclFoundation11");
        String[] stringArray = System.getPropertyList();
        int n = 0;
        while (n < stringArray.length) {
            String string6 = stringArray[n];
            if (string6 == null) break;
            systemProperties.put(string6, stringArray[n + 1]);
            n += 2;
        }
        String string7 = (String)systemProperties.get("console.encoding");
        if (string7 == null) {
            if (string2 == null) {
                string2 = System.getEncoding(1);
            }
            string7 = string2;
            systemProperties.put("console.encoding", string7);
        }
        systemProperties.put("com.ibm.oti.jcl.build", "20070313_1930");
    }

    public static void exit(int n) {
        RUNTIME.exit(n);
    }

    public static void gc() {
        RUNTIME.gc();
    }

    public static Properties getProperties() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPropertiesAccess();
        }
        return systemProperties;
    }

    static Properties internalGetProperties() {
        return systemProperties;
    }

    public static String getProperty(String string) {
        return System.getProperty(string, null);
    }

    public static String getProperty(String string, String string2) {
        if (string.length() == 0) {
            throw new IllegalArgumentException();
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPropertyAccess(string);
        }
        return systemProperties.getProperty(string, string2);
    }

    public static String setProperty(String string, String string2) {
        if (string.length() == 0) {
            throw new IllegalArgumentException();
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new PropertyPermission(string, "write"));
        }
        return (String)systemProperties.setProperty(string, string2);
    }

    private static native String[] getPropertyList() {
    }

    private static native String getCommPortList() {
    }

    private static native String getEncoding(int n) {
    }

    public static SecurityManager getSecurityManager() {
        return security;
    }

    public static native int identityHashCode(Object object) {
    }

    public static void load(String string) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkLink(string);
        }
        ClassLoader.loadLibraryWithPath(string, ClassLoader.callerClassLoader(), null);
    }

    public static void loadLibrary(String string) {
        ClassLoader.loadLibraryWithClassLoader(string, ClassLoader.callerClassLoader());
    }

    public static void runFinalization() {
        RUNTIME.runFinalization();
    }

    public static void setProperties(Properties properties) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPropertiesAccess();
        }
        if (properties == null) {
            System.ensureProperties();
        } else {
            systemProperties = properties;
        }
    }

    public static void setSecurityManager(SecurityManager securityManager) {
        SecurityManager securityManager2 = security;
        if (securityManager != null) {
            try {
                securityManager.checkPackageAccess("java.lang");
            }
            catch (Exception exception) {}
            try {
                AccessController.doPrivileged(new System$1(securityManager2, securityManager));
            }
            catch (Exception exception) {}
        }
        if (securityManager2 != null) {
            securityManager2.checkPermission(RuntimePermission.permissionToSetSecurityManager);
        }
        security = securityManager;
    }

    public static native String mapLibraryName(String string) {
    }

    private static native void setFieldImpl(String string, Object object) {
    }
}

