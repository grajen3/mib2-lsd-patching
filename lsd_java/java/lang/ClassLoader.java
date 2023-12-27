/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.AbstractClassLoader;
import com.ibm.oti.vm.BootstrapClassLoader;
import com.ibm.oti.vm.URLAppClassLoader;
import com.ibm.oti.vm.URLExtensionClassLoader;
import com.ibm.oti.vm.VM;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

public abstract class ClassLoader {
    static ClassLoader systemClassLoader;
    private static ClassLoader applicationClassLoader;
    private static boolean initSystemClassLoader;
    private long vmRef;
    ClassLoader parent;
    private Object assertionLock = new ClassLoader$AssertionLock();
    private boolean defaultAssertionStatus;
    private Map packageAssertionStatus;
    private Map classAssertionStatus;
    private Hashtable packages = new Hashtable();
    private Object lazyInitLock = new ClassLoader$LazyInitLock();
    private Hashtable classSigners = null;
    private Hashtable packageSigners = new Hashtable();
    private static Certificate[] emptyCertificates;
    private ProtectionDomain defaultProtectionDomain;
    private Hashtable bundleCache;
    static /* synthetic */ Class class$0;

    static {
        initSystemClassLoader = false;
        emptyCertificates = new Certificate[0];
    }

    static final void initializeClassLoaders() {
        if (systemClassLoader != null) {
            return;
        }
        ClassLoader classLoader = null;
        String string = System.getProperty("systemClassLoader");
        if (string == null) {
            classLoader = BootstrapClassLoader.singleton();
        } else {
            try {
                classLoader = (ClassLoader)Class.forName(string, true, null).newInstance();
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                System.exit(1);
            }
        }
        systemClassLoader = classLoader;
        AbstractClassLoader.setBootstrapClassLoader(systemClassLoader);
        applicationClassLoader = systemClassLoader;
        ClassLoader classLoader2 = null;
        String string2 = System.getProperty("extensionClassLoader");
        if (string2 == null) {
            classLoader2 = new URLExtensionClassLoader();
        } else {
            try {
                classLoader2 = (ClassLoader)Class.forName(string2, true, systemClassLoader).newInstance();
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                System.exit(1);
            }
        }
        applicationClassLoader = classLoader2;
        ClassLoader classLoader3 = null;
        String string3 = System.getProperty("applicationClassLoader");
        if (string3 == null) {
            classLoader3 = new URLAppClassLoader(applicationClassLoader);
        } else {
            try {
                classLoader3 = (ClassLoader)Class.forName(string3, true, applicationClassLoader).newInstance();
                super.setParent(applicationClassLoader);
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                System.exit(1);
            }
        }
        applicationClassLoader = classLoader3;
    }

    protected ClassLoader() {
        this(applicationClassLoader);
    }

    protected ClassLoader(ClassLoader classLoader) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkCreateClassLoader();
        }
        this.parent = classLoader;
        if (systemClassLoader != null) {
            VM.initializeClassLoader(this, false);
        }
        this.initializeClassLoaderAssertStatus();
    }

    protected final Class defineClass(String string, byte[] byArray, int n, int n2) {
        return this.defineClass(string, byArray, n, n2, null);
    }

    private String checkClassName(String string) {
        int n = string.lastIndexOf(46);
        if (n >= 0) {
            String string2 = string.substring(0, n);
            if (string.startsWith("java.")) {
                throw new SecurityException(Msg.getString("K01d2", string2, string));
            }
            return string2;
        }
        return "";
    }

    protected final Class defineClass(String string, byte[] byArray, int n, int n2, ProtectionDomain protectionDomain) {
        Object object;
        Object[] objectArray = null;
        if (protectionDomain != null && (object = protectionDomain.getCodeSource()) != null) {
            objectArray = ((CodeSource)object).getCertificates();
        }
        if (string != null) {
            object = this.checkClassName(string);
            this.checkPackageSigners((String)object, string, (Certificate[])objectArray);
        }
        if (n < 0 || n2 < 0 || n > byArray.length || n2 > byArray.length - n) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (protectionDomain == null) {
            protectionDomain = this.getDefaultProtectionDomain();
        }
        object = protectionDomain;
        Class clazz = System.getSecurityManager() == null ? this.defineClassImpl(string, byArray, n, n2, object) : (Class)AccessController.doPrivileged(new ClassLoader$1(this, string, byArray, n, n2, (ProtectionDomain)object), new AccessControlContext(new ProtectionDomain[]{object}));
        if (this.isVerboseImpl()) {
            URL uRL;
            CodeSource codeSource;
            String string2 = "<unknown>";
            if (object != null && (codeSource = ((ProtectionDomain)object).getCodeSource()) != null && (uRL = codeSource.getLocation()) != null) {
                string2 = uRL.toString();
            }
            VM.dumpString(new StringBuffer("class load: ").append(clazz.getName()).append(" from: ").append(string2).append("\n").toString());
        }
        if (objectArray != null) {
            this.setSigners(clazz, objectArray);
        }
        return clazz;
    }

    private native boolean isVerboseImpl() {
    }

    private void checkPackageSigners(String string, String string2, Certificate[] certificateArray) {
        Certificate[] certificateArray2 = (Certificate[])this.packageSigners.get(string);
        if (certificateArray2 == null) {
            if (certificateArray == null) {
                this.packageSigners.put(string, emptyCertificates);
            } else {
                this.packageSigners.put(string, certificateArray);
            }
        } else {
            if (certificateArray == null && certificateArray2.length == 0 || certificateArray == certificateArray2) {
                return;
            }
            if (certificateArray != null && certificateArray.length == certificateArray2.length) {
                boolean bl = true;
                int n = 0;
                while (n < certificateArray.length) {
                    block11: {
                        if (certificateArray[n] != certificateArray2[n] && !certificateArray[n].equals(certificateArray2[n])) {
                            int n2 = 0;
                            while (n2 < certificateArray2.length) {
                                if (n2 == n || certificateArray[n] != certificateArray2[n2] && !certificateArray[n].equals(certificateArray2[n2])) {
                                    ++n2;
                                    continue;
                                }
                                break block11;
                            }
                            bl = false;
                            break;
                        }
                    }
                    ++n;
                }
                if (bl) {
                    return;
                }
            }
            throw new SecurityException(Msg.getString("K01d1", string2));
        }
    }

    private final ProtectionDomain getDefaultProtectionDomain() {
        if (this.defaultProtectionDomain == null) {
            CodeSource codeSource = new CodeSource(null, null);
            this.defaultProtectionDomain = new ProtectionDomain(codeSource, null, this, null);
        }
        return this.defaultProtectionDomain;
    }

    private final native Class defineClassImpl(String string, byte[] byArray, int n, int n2, Object object) {
    }

    protected Class findClass(String string) {
        throw new ClassNotFoundException();
    }

    protected final Class findLoadedClass(String string) {
        if (string != null && string.length() > 0 && string.charAt(0) == '[') {
            return null;
        }
        return this.findLoadedClassImpl(string);
    }

    private native Class findLoadedClassImpl(String string) {
    }

    protected final Class findSystemClass(String string) {
        return applicationClassLoader.loadClass(string);
    }

    public final ClassLoader getParent() {
        ClassLoader classLoader;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null && (classLoader = ClassLoader.callerClassLoader()) != null && classLoader != this && !classLoader.isAncestorOf(this)) {
            securityManager.checkPermission(RuntimePermission.permissionToGetClassLoader);
        }
        return this.parent;
    }

    public URL getResource(String string) {
        URL uRL;
        URL uRL2 = uRL = this.parent == null ? systemClassLoader.findResource(string) : this.parent.getResource(string);
        if (uRL != null) {
            return uRL;
        }
        return this.findResource(string);
    }

    public final Enumeration getResources(String string) {
        ClassLoader classLoader = this;
        Vector vector = new Vector();
        while (true) {
            Enumeration enumeration;
            if ((enumeration = classLoader.findResources(string)) != null && enumeration.hasMoreElements()) {
                vector.addElement(enumeration);
            }
            if (classLoader == systemClassLoader) break;
            classLoader = classLoader.parent;
            if (classLoader != null) continue;
            classLoader = systemClassLoader;
        }
        return new ClassLoader$2(this, vector);
    }

    public InputStream getResourceAsStream(String string) {
        URL uRL = this.getResource(string);
        try {
            if (uRL != null) {
                return uRL.openStream();
            }
        }
        catch (IOException iOException) {}
        return null;
    }

    static void completeInitialization() {
        initSystemClassLoader = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ClassLoader getSystemClassLoader() {
        Object object;
        Object object2;
        if (initSystemClassLoader) {
            Class clazz = class$0;
            if (clazz == null) {
                try {
                    clazz = class$0 = Class.forName("java.lang.ClassLoader");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            object = object2 = clazz;
            synchronized (object) {
                if (initSystemClassLoader) {
                    initSystemClassLoader = false;
                    String string = System.getProperty("java.system.class.loader");
                    if (string != null) {
                        try {
                            Class clazz2 = Class.forName(string, true, applicationClassLoader);
                            Constructor constructor = clazz2.getConstructor(new Class[]{object2});
                            applicationClassLoader = (ClassLoader)constructor.newInstance(new Object[]{applicationClassLoader});
                        }
                        catch (Throwable throwable) {
                            throw new Error(throwable);
                        }
                    }
                }
            }
        }
        if ((object2 = System.getSecurityManager()) != null && (object = ClassLoader.callerClassLoader()) != null && object != applicationClassLoader && !super.isAncestorOf(applicationClassLoader)) {
            ((SecurityManager)object2).checkPermission(RuntimePermission.permissionToGetClassLoader);
        }
        return applicationClassLoader;
    }

    public static URL getSystemResource(String string) {
        return ClassLoader.getSystemClassLoader().getResource(string);
    }

    public static Enumeration getSystemResources(String string) {
        return ClassLoader.getSystemClassLoader().getResources(string);
    }

    public static InputStream getSystemResourceAsStream(String string) {
        return ClassLoader.getSystemClassLoader().getResourceAsStream(string);
    }

    public Class loadClass(String string) {
        return this.loadClass(string, false);
    }

    protected synchronized Class loadClass(String string, boolean bl) {
        Class clazz = this.findLoadedClass(string);
        if (clazz == null) {
            try {
                clazz = this.parent == null ? systemClassLoader.loadClass(string) : this.parent.loadClass(string, bl);
            }
            catch (ClassNotFoundException classNotFoundException) {}
            if (clazz == null) {
                clazz = this.findClass(string);
            }
        }
        if (bl) {
            this.resolveClass(clazz);
        }
        return clazz;
    }

    protected final void resolveClass(Class clazz) {
        if (clazz == null) {
            throw new NullPointerException();
        }
        J9VMInternals.verify(clazz);
    }

    private void setParent(ClassLoader classLoader) {
        this.parent = classLoader;
    }

    final boolean isSystemClassLoader() {
        if (this == systemClassLoader) {
            return true;
        }
        ClassLoader classLoader = applicationClassLoader;
        while (classLoader != null) {
            if (this == classLoader) {
                return true;
            }
            classLoader = classLoader.parent;
        }
        return false;
    }

    final boolean isAncestorOf(ClassLoader classLoader) {
        if (classLoader == null) {
            return false;
        }
        if (this == systemClassLoader) {
            return true;
        }
        ClassLoader classLoader2 = classLoader.parent;
        while (classLoader2 != null) {
            if (this == classLoader2) {
                return true;
            }
            classLoader2 = classLoader2.parent;
        }
        return false;
    }

    protected URL findResource(String string) {
        return null;
    }

    protected Enumeration findResources(String string) {
        return new Vector().elements();
    }

    protected String findLibrary(String string) {
        return null;
    }

    protected Package getPackage(String string) {
        if (this != systemClassLoader) {
            Package package_;
            ClassLoader classLoader = this.parent;
            if (classLoader == null) {
                classLoader = systemClassLoader;
            }
            if ((package_ = classLoader.getPackage(string)) != null) {
                return package_;
            }
        }
        return (Package)this.packages.get(string);
    }

    protected Package[] getPackages() {
        Package[] packageArray = null;
        if (this.parent == null) {
            if (this != systemClassLoader) {
                packageArray = systemClassLoader.getPackages();
            }
        } else {
            packageArray = this.parent.getPackages();
        }
        int n = this.packages.size();
        if (packageArray != null) {
            n += packageArray.length;
        }
        Package[] packageArray2 = new Package[n];
        Enumeration enumeration = this.packages.elements();
        int n2 = 0;
        if (packageArray != null) {
            while (n2 < packageArray.length) {
                packageArray2[n2] = packageArray[n2];
                ++n2;
            }
        }
        while (enumeration.hasMoreElements()) {
            packageArray2[n2++] = (Package)enumeration.nextElement();
        }
        return packageArray2;
    }

    protected Package definePackage(String string, String string2, String string3, String string4, String string5, String string6, String string7, URL uRL) {
        Hashtable hashtable = this.packages;
        synchronized (hashtable) {
            if (this.getPackage(string) == null) {
                Package package_ = new Package(string, string2, string3, string4, string5, string6, string7, uRL);
                this.packages.put(string, package_);
                return package_;
            }
            throw new IllegalArgumentException(Msg.getString("K0053", string));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final Object[] getSigners(Class clazz) {
        Object object = this.lazyInitLock;
        synchronized (object) {
            if (this.classSigners == null) {
                return null;
            }
        }
        try {
            object = this.classSigners.get(clazz);
            if (object != null) {
                return (Object[])object.clone();
            }
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {}
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final void setSigners(Class clazz, Object[] objectArray) {
        if (clazz.getClassLoaderImpl() == this) {
            if (objectArray == null) {
                Object object = this.lazyInitLock;
                synchronized (object) {
                    if (this.classSigners == null) {
                        return;
                    }
                }
                this.classSigners.remove(clazz);
            } else {
                Object object = this.lazyInitLock;
                synchronized (object) {
                    if (this.classSigners == null) {
                        this.classSigners = new Hashtable();
                    }
                }
                this.classSigners.put(clazz, objectArray);
            }
        } else {
            clazz.getClassLoaderImpl().setSigners(clazz, objectArray);
        }
    }

    static final native ClassLoader getStackClassLoader(int n) {
    }

    static ClassLoader callerClassLoader() {
        ClassLoader classLoader = ClassLoader.getStackClassLoader(2);
        if (classLoader == systemClassLoader) {
            return null;
        }
        return classLoader;
    }

    static synchronized void loadLibraryWithClassLoader(String string, ClassLoader classLoader) {
        String string2;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkLink(string);
        }
        if (classLoader != null && (string2 = classLoader.findLibrary(string)) != null) {
            ClassLoader.loadLibraryWithPath(string2, classLoader, null);
            return;
        }
        ClassLoader.loadLibraryWithPath(string, classLoader, System.internalGetProperties().getProperty(classLoader == null ? "com.ibm.oti.vm.bootstrap.library.path" : "java.library.path"));
    }

    static void loadLibraryWithPath(String string, ClassLoader classLoader, String string2) {
        byte[] byArray = ClassLoader.loadLibraryWithPath(Util.getBytes(string), classLoader, string2 == null ? null : Util.getBytes(string2));
        if (byArray != null) {
            String string3;
            try {
                string3 = Util.convertFromUTF8(byArray, 0, byArray.length);
            }
            catch (IOException iOException) {
                string3 = Util.toString(byArray);
            }
            throw new UnsatisfiedLinkError(new StringBuffer(String.valueOf(string)).append(" (").append(string3).append(")").toString());
        }
    }

    private static native byte[] loadLibraryWithPath(byte[] byArray, ClassLoader classLoader, byte[] byArray2) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setClassAssertionStatus(String string, boolean bl) {
        Object object = this.assertionLock;
        synchronized (object) {
            if (this.classAssertionStatus == null) {
                this.classAssertionStatus = new HashMap();
            }
            this.classAssertionStatus.put(string, bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setPackageAssertionStatus(String string, boolean bl) {
        Object object = this.assertionLock;
        synchronized (object) {
            if (this.packageAssertionStatus == null) {
                this.packageAssertionStatus = new HashMap();
            }
            this.packageAssertionStatus.put(string, bl);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setDefaultAssertionStatus(boolean bl) {
        Object object = this.assertionLock;
        synchronized (object) {
            this.defaultAssertionStatus = bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clearAssertionStatus() {
        Object object = this.assertionLock;
        synchronized (object) {
            this.defaultAssertionStatus = false;
            this.classAssertionStatus = null;
            this.packageAssertionStatus = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean getClassAssertionStatus(String string) {
        Object object = this.assertionLock;
        synchronized (object) {
            int n = -1;
            if (this.classAssertionStatus != null) {
                Boolean bl = (Boolean)this.classAssertionStatus.get(string);
                if (bl != null) {
                    return bl;
                }
                n = string.indexOf(36);
                if (n > 0 && (bl = (Boolean)this.classAssertionStatus.get(string.substring(0, n))) != null) {
                    return bl;
                }
            }
            if ((n = string.lastIndexOf(46)) > 0) {
                return this.getPackageAssertionStatus(string.substring(0, n));
            }
            return this.getDefaultAssertionStatus();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean getPackageAssertionStatus(String string) {
        Object object = this.assertionLock;
        synchronized (object) {
            int n = -1;
            if (this.packageAssertionStatus != null) {
                Boolean bl = (Boolean)this.packageAssertionStatus.get(string);
                if (bl != null) {
                    return bl;
                }
                n = string.lastIndexOf(46);
                if (n > 0) {
                    return this.getPackageAssertionStatus(string.substring(0, n));
                }
            }
            return this.getDefaultAssertionStatus();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean getDefaultAssertionStatus() {
        Object object = this.assertionLock;
        synchronized (object) {
            return this.defaultAssertionStatus;
        }
    }

    private void initializeClassLoaderAssertStatus() {
        boolean bl = systemClassLoader == null;
        String[] stringArray = VM.getVMArgs();
        String[] stringArray2 = new String[stringArray.length];
        String[] stringArray3 = new String[stringArray.length];
        int n = 0;
        while (n < stringArray2.length) {
            boolean bl2;
            int n2 = stringArray[n].indexOf(58);
            if (n2 == -1) {
                stringArray2[n] = stringArray[n];
            } else {
                stringArray2[n] = stringArray[n].substring(0, n2);
                stringArray3[n] = stringArray[n].substring(n2 + 1);
            }
            if (stringArray2[n].compareTo("-ea") == 0 || stringArray2[n].compareTo("-enableassertions") == 0 || stringArray2[n].compareTo("-da") == 0 || stringArray2[n].compareTo("-disableassertions") == 0) {
                bl2 = stringArray2[n].charAt(1) == 'e';
                if (stringArray3[n] == null) {
                    if (!bl) {
                        this.setDefaultAssertionStatus(bl2);
                    }
                } else {
                    String string = stringArray3[n];
                    int n3 = string.length();
                    if (n3 > 3 && string.charAt(n3 - 1) == '.' && string.charAt(n3 - 2) == '.' && string.charAt(n3 - 3) == '.') {
                        string = string.substring(0, n3 - 3);
                        this.setPackageAssertionStatus(string, bl2);
                    } else {
                        this.setClassAssertionStatus(string, bl2);
                    }
                }
            } else if ((stringArray2[n].compareTo("-esa") == 0 || stringArray2[n].compareTo("-enablesystemassertions") == 0 || stringArray2[n].compareTo("-dsa") == 0 || stringArray2[n].compareTo("-disablesystemassertions") == 0) && bl) {
                bl2 = stringArray2[n].charAt(1) == 'e';
                this.setDefaultAssertionStatus(bl2);
            }
            ++n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Hashtable getBundleCache() {
        Object object = this.lazyInitLock;
        synchronized (object) {
            if (this.bundleCache == null) {
                this.bundleCache = new Hashtable();
            }
        }
        return this.bundleCache;
    }

    static /* synthetic */ Class access$0(ClassLoader classLoader, String string, byte[] byArray, int n, int n2, Object object) {
        return classLoader.defineClassImpl(string, byArray, n, n2, object);
    }
}

