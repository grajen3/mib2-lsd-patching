/*
 * Decompiled with CFR 0.152.
 */
package java.lang.reflect;

import com.ibm.oti.lang.reflect.ProxyClassFile;
import com.ibm.oti.util.Msg;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Proxy
implements Serializable {
    private static final long serialVersionUID;
    private static Map loaderCache;
    private static Map proxyCache;
    private static int NextClassNameIndex;
    protected InvocationHandler h;
    static /* synthetic */ Class class$0;

    static {
        loaderCache = new WeakHashMap();
        proxyCache = new WeakHashMap();
        NextClassNameIndex = 0;
    }

    private Proxy() {
    }

    protected Proxy(InvocationHandler invocationHandler) {
        this.h = invocationHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Class getProxyClass(ClassLoader classLoader, Class[] classArray) {
        int n;
        Object object;
        Object object2;
        if (classArray == null) {
            throw new NullPointerException();
        }
        String string = null;
        int n2 = 0;
        int n3 = classArray.length;
        while (n2 < n3) {
            object2 = classArray[n2];
            if (object2 == null) {
                throw new NullPointerException();
            }
            object = ((Class)object2).getName();
            if (!((Class)object2).isInterface()) {
                throw new IllegalArgumentException(Msg.getString("K00ed", object));
            }
            if (classLoader != ((Class)object2).getClassLoader()) {
                try {
                    if (object2 != Class.forName((String)object, false, classLoader)) {
                        throw new IllegalArgumentException(Msg.getString("K00ee", object));
                    }
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new IllegalArgumentException(Msg.getString("K00ee", object));
                }
            }
            n = n2 + 1;
            while (n < n3) {
                if (object2 == classArray[n]) {
                    throw new IllegalArgumentException(Msg.getString("K00ef", object));
                }
                ++n;
            }
            if (!Modifier.isPublic(((Class)object2).getModifiers())) {
                String string2;
                n = ((String)object).lastIndexOf(46);
                String string3 = string2 = n == -1 ? "" : ((String)object).substring(0, n);
                if (string == null) {
                    string = string2;
                } else if (!string.equals(string2)) {
                    throw new IllegalArgumentException(Msg.getString("K00f0"));
                }
            }
            ++n2;
        }
        Map map = loaderCache;
        synchronized (map) {
            Map map2 = (Map)loaderCache.get(classLoader);
            if (map2 == null) {
                map2 = new HashMap();
                loaderCache.put(classLoader, map2);
            }
            object2 = "";
            if (classArray.length == 1) {
                object2 = classArray[0].getName();
            } else {
                object = new StringBuffer();
                n = 0;
                int n4 = classArray.length;
                while (n < n4) {
                    ((StringBuffer)object).append(classArray[n].getName());
                    ((StringBuffer)object).append(' ');
                    ++n;
                }
                object2 = ((StringBuffer)object).toString();
            }
            WeakReference weakReference = (WeakReference)map2.get(object2);
            if (weakReference == null) {
                String string4 = new StringBuffer("$Proxy").append(NextClassNameIndex++).toString();
                if (string != null && string.length() > 0) {
                    string4 = new StringBuffer(String.valueOf(string)).append(".").append(string4).toString();
                }
                byte[] byArray = ProxyClassFile.generateBytes(string4, classArray);
                if (classLoader == null) {
                    classLoader = ClassLoader.getSystemClassLoader();
                }
                object = Proxy.defineClassImpl(classLoader, string4.replace('.', '/'), byArray);
                map2.put(object2, new WeakReference(object));
                Map map3 = proxyCache;
                synchronized (map3) {
                    proxyCache.put(object, "");
                }
            } else {
                object = (Class)weakReference.get();
            }
            return object;
        }
    }

    public static Object newProxyInstance(ClassLoader classLoader, Class[] classArray, InvocationHandler invocationHandler) {
        if (invocationHandler != null) {
            try {
                Class clazz = Proxy.getProxyClass(classLoader, classArray);
                Class[] classArray2 = new Class[1];
                Class clazz2 = class$0;
                if (clazz2 == null) {
                    try {
                        clazz2 = class$0 = Class.forName("java.lang.reflect.InvocationHandler");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray2[0] = clazz2;
                return clazz.getConstructor(classArray2).newInstance(new Object[]{invocationHandler});
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new InternalError(noSuchMethodException.toString());
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new InternalError(illegalAccessException.toString());
            }
            catch (InstantiationException instantiationException) {
                throw new InternalError(instantiationException.toString());
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new InternalError(invocationTargetException.getTargetException().toString());
            }
        }
        throw new NullPointerException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean isProxyClass(Class clazz) {
        if (clazz != null) {
            Map map = proxyCache;
            synchronized (map) {
                return proxyCache.containsKey(clazz);
            }
        }
        throw new NullPointerException();
    }

    public static InvocationHandler getInvocationHandler(Object object) {
        if (Proxy.isProxyClass(object.getClass())) {
            return ((Proxy)object).h;
        }
        throw new IllegalArgumentException(Msg.getString("K00f1"));
    }

    private static native Class defineClassImpl(ClassLoader classLoader, String string, byte[] byArray) {
    }
}

