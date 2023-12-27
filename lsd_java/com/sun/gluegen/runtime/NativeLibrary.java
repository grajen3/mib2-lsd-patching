/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import com.sun.gluegen.runtime.DynamicLinker;
import com.sun.gluegen.runtime.MacOSXDynamicLinkerImpl;
import com.sun.gluegen.runtime.NativeLibLoader;
import com.sun.gluegen.runtime.NativeLibrary$1;
import com.sun.gluegen.runtime.NativeLibrary$2;
import com.sun.gluegen.runtime.NativeLibrary$3;
import com.sun.gluegen.runtime.NativeLibrary$4;
import com.sun.gluegen.runtime.NativeLibrary$5;
import com.sun.gluegen.runtime.UnixDynamicLinkerImpl;
import com.sun.gluegen.runtime.WindowsDynamicLinkerImpl;
import java.io.File;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class NativeLibrary {
    private static final int WINDOWS;
    private static final int UNIX;
    private static final int MACOSX;
    private static boolean DEBUG;
    private static int platform;
    private static DynamicLinker dynLink;
    private static String[] prefixes;
    private static String[] suffixes;
    private long libraryHandle;
    private String libraryPath;
    private static boolean initializedFindLibraryMethod;
    private static Method findLibraryMethod;
    private static volatile boolean loadedDynLinkNativeLib;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$java$lang$ClassLoader;
    static /* synthetic */ Class class$com$sun$gluegen$runtime$NativeLibrary;

    private NativeLibrary(long l, String string) {
        this.libraryHandle = l;
        this.libraryPath = string;
    }

    public static NativeLibrary open(String string, ClassLoader classLoader) {
        return NativeLibrary.open(string, string, string, true, classLoader);
    }

    public static NativeLibrary open(String string, String string2, String string3, boolean bl, ClassLoader classLoader) {
        List list = NativeLibrary.enumerateLibraryPaths(string, string2, string3, bl, classLoader);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string4 = (String)iterator.next();
            if (DEBUG) {
                System.out.println(new StringBuffer().append("Trying to load ").append(string4).toString());
            }
            NativeLibrary.ensureNativeLibLoaded();
            long l = dynLink.openLibrary(string4);
            if (l == 0L) continue;
            if (DEBUG) {
                System.out.println(new StringBuffer().append("Successfully loaded ").append(string4).append(": res = 0x").append(Long.toHexString(l)).toString());
            }
            return new NativeLibrary(l, string4);
        }
        if (DEBUG) {
            System.out.println(new StringBuffer().append("Did not succeed in loading (").append(string).append(", ").append(string2).append(", ").append(string3).append(")").toString());
        }
        return null;
    }

    public long lookupFunction(String string) {
        if (this.libraryHandle == 0L) {
            throw new RuntimeException("Library is not open");
        }
        return dynLink.lookupSymbol(this.libraryHandle, string);
    }

    public long getLibraryHandle() {
        return this.libraryHandle;
    }

    public String getLibraryPath() {
        return this.libraryPath;
    }

    public void close() {
        if (this.libraryHandle == 0L) {
            throw new RuntimeException("Library already closed");
        }
        long l = this.libraryHandle;
        this.libraryHandle = 0L;
        dynLink.closeLibrary(l);
    }

    private static List enumerateLibraryPaths(String string, String string2, String string3, boolean bl, ClassLoader classLoader) {
        Object object;
        String string4;
        ArrayList arrayList = new ArrayList();
        String string5 = NativeLibrary.selectName(string, string2, string3);
        if (string5 == null) {
            return arrayList;
        }
        File file = new File(string5);
        if (file.isAbsolute()) {
            arrayList.add(string5);
            return arrayList;
        }
        String[] stringArray = NativeLibrary.buildNames(string5);
        if (bl) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                arrayList.add(stringArray[i2]);
            }
        }
        String string6 = NativeLibrary.getPathFromClassLoader(string5, classLoader);
        if (DEBUG) {
            System.out.println(new StringBuffer().append("Class loader path to ").append(string5).append(": ").append(string6).toString());
        }
        if (string6 != null) {
            arrayList.add(string6);
        }
        if ((string4 = (String)AccessController.doPrivileged(new NativeLibrary$2())) != null) {
            object = new StringTokenizer(string4, File.pathSeparator);
            while (((StringTokenizer)object).hasMoreTokens()) {
                NativeLibrary.addPaths(((StringTokenizer)object).nextToken(), stringArray, arrayList);
            }
        }
        object = (String)AccessController.doPrivileged(new NativeLibrary$3());
        NativeLibrary.addPaths((String)object, stringArray, arrayList);
        if (platform == 3) {
            NativeLibrary.addPaths(new StringBuffer().append("/Library/Frameworks/").append(string5).append(".Framework").toString(), stringArray, arrayList);
            NativeLibrary.addPaths(new StringBuffer().append("/System/Library/Frameworks/").append(string5).append(".Framework").toString(), stringArray, arrayList);
        }
        if (!bl) {
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                arrayList.add(stringArray[i3]);
            }
        }
        return arrayList;
    }

    private static String selectName(String string, String string2, String string3) {
        switch (platform) {
            case 1: {
                return string;
            }
            case 2: {
                return string2;
            }
            case 3: {
                return string3;
            }
        }
        throw new InternalError();
    }

    private static String[] buildNames(String string) {
        int n;
        int n2;
        int n3;
        if (string.startsWith(prefixes[0])) {
            if (string.endsWith(suffixes[0])) {
                return new String[]{string};
            }
            int n4 = string.indexOf(suffixes[0]);
            n3 = 1;
            if (n4 >= 0) {
                for (n2 = n4 + suffixes[0].length(); n2 < string.length(); ++n2) {
                    n = string.charAt(n2);
                    if (n == 46 || n >= 48 && n <= 57) continue;
                    n3 = 0;
                    break;
                }
                if (n3 != 0) {
                    return new String[]{string};
                }
            }
        }
        String[] stringArray = new String[prefixes.length * suffixes.length];
        n3 = 0;
        for (n2 = 0; n2 < prefixes.length; ++n2) {
            for (n = 0; n < suffixes.length; ++n) {
                stringArray[n3++] = new StringBuffer().append(prefixes[n2]).append(string).append(suffixes[n]).toString();
            }
        }
        return stringArray;
    }

    private static void addPaths(String string, String[] stringArray, List list) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            list.add(new StringBuffer().append(string).append(File.separator).append(stringArray[i2]).toString());
        }
    }

    private static String getPathFromClassLoader(String string, ClassLoader classLoader) {
        block5: {
            if (classLoader == null) {
                return null;
            }
            if (!initializedFindLibraryMethod) {
                AccessController.doPrivileged(new NativeLibrary$4());
            }
            if (findLibraryMethod != null) {
                try {
                    return (String)AccessController.doPrivileged(new NativeLibrary$5(classLoader, string));
                }
                catch (Exception exception) {
                    if (!DEBUG) break block5;
                    exception.printStackTrace();
                }
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void ensureNativeLibLoaded() {
        if (!loadedDynLinkNativeLib) {
            Class clazz = class$com$sun$gluegen$runtime$NativeLibrary == null ? (class$com$sun$gluegen$runtime$NativeLibrary = NativeLibrary.class$("com.sun.gluegen.runtime.NativeLibrary")) : class$com$sun$gluegen$runtime$NativeLibrary;
            synchronized (clazz) {
                if (!loadedDynLinkNativeLib) {
                    loadedDynLinkNativeLib = true;
                    NativeLibLoader.loadGlueGenRT();
                }
            }
        }
    }

    static /* synthetic */ int access$002(int n) {
        platform = n;
        return platform;
    }

    static /* synthetic */ boolean access$102(boolean bl) {
        DEBUG = bl;
        return DEBUG;
    }

    static /* synthetic */ Method access$202(Method method) {
        findLibraryMethod = method;
        return findLibraryMethod;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ Method access$200() {
        return findLibraryMethod;
    }

    static /* synthetic */ boolean access$302(boolean bl) {
        initializedFindLibraryMethod = bl;
        return initializedFindLibraryMethod;
    }

    static {
        AccessController.doPrivileged(new NativeLibrary$1());
        switch (platform) {
            case 1: {
                dynLink = new WindowsDynamicLinkerImpl();
                prefixes = new String[]{""};
                suffixes = new String[]{".dll"};
                break;
            }
            case 2: {
                dynLink = new UnixDynamicLinkerImpl();
                prefixes = new String[]{"lib"};
                suffixes = new String[]{".so"};
                break;
            }
            case 3: {
                dynLink = new MacOSXDynamicLinkerImpl();
                prefixes = new String[]{"lib", ""};
                suffixes = new String[]{".dylib", ".jnilib", ""};
                break;
            }
            default: {
                throw new InternalError("Platform not initialized properly");
            }
        }
        initializedFindLibraryMethod = false;
        findLibraryMethod = null;
    }
}

