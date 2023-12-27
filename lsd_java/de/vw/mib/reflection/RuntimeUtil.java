/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.reflection;

import de.vw.mib.reflection.LightReflectionException;
import de.vw.mib.reflection.MethodsRetriever;
import de.vw.mib.reflection.RuntimeUtil$ClassMethodKeys;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class RuntimeUtil {
    public static final int NF_IDX;
    private static final int KB_I_TOTAL;
    private static final int KB_I_CONSTANT;
    private static final int BC_SV;
    private static final int BC_OS;
    private static final int BC_L;
    private static final Byte[] BYTE_CACHE;
    private static final int CHC_L;
    private static final Character[] CHARACTER_CACHE;
    private static final int SC_SV;
    private static final int SC_OS;
    private static final int SC_L;
    private static final Short[] SHORT_CACHE;
    private static final int IC_SV;
    private static final int IC_OS;
    private static final int IC_L;
    private static final Integer[] INTEGER_CACHE;
    private static final int LC_SV;
    private static final int LC_OS;
    private static final int LC_L;
    private static final Long[] LONG_CACHE;
    private static final Map CLASS_METHOD_KEYS;
    private static final List MS_RS;

    public static void addMethodsRetriever(MethodsRetriever methodsRetriever) {
        MS_RS.add(methodsRetriever);
    }

    public void removeMethodsRetriever(MethodsRetriever methodsRetriever) {
        MS_RS.remove(methodsRetriever);
    }

    public static int buildKey(Class clazz) {
        return 629 + clazz.getName().hashCode();
    }

    public static int buildKey(Class[] classArray) {
        int n = 17;
        for (int i2 = classArray.length - 1; i2 >= 0; --i2) {
            n = n * 37 + classArray[i2].getName().hashCode();
        }
        return n;
    }

    public static int buildKey(String string) {
        return 629 + string.hashCode();
    }

    public static int buildKey(String[] stringArray) {
        int n = 17;
        for (int i2 = stringArray.length - 1; i2 >= 0; --i2) {
            n = n * 37 + stringArray[i2].hashCode();
        }
        return n;
    }

    public static Boolean valueOf(boolean bl) {
        return bl ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Byte valueOf(byte by) {
        return BYTE_CACHE[by + BC_OS];
    }

    public static Character valueOf(char c2) {
        if (c2 >= '\u0080') {
            return new Character(c2);
        }
        return CHARACTER_CACHE[c2];
    }

    public static Short valueOf(short s) {
        if (s < -64 || s >= 448) {
            return new Short(s);
        }
        return SHORT_CACHE[s + SC_OS];
    }

    public static Integer valueOf(int n) {
        if (n < -64 || n >= 448) {
            return new Integer(n);
        }
        return INTEGER_CACHE[n + IC_OS];
    }

    public static Long valueOf(long l) {
        if (l < -64L || l >= 0) {
            return new Long(l);
        }
        return LONG_CACHE[(int)l + LC_OS];
    }

    public static Double valueOf(double d2) {
        return new Double(d2);
    }

    public static Float valueOf(float f2) {
        return new Float(f2);
    }

    public static Method getMethod(int n, Method[] methodArray, String string, int n2, int n3) {
        Method method = methodArray[n];
        if (method == null) {
            try {
                RuntimeUtil$ClassMethodKeys runtimeUtil$ClassMethodKeys = (RuntimeUtil$ClassMethodKeys)CLASS_METHOD_KEYS.get(string);
                if (null == runtimeUtil$ClassMethodKeys) {
                    runtimeUtil$ClassMethodKeys = RuntimeUtil$ClassMethodKeys.create(RuntimeUtil.getMethods(string));
                    CLASS_METHOD_KEYS.put(string, runtimeUtil$ClassMethodKeys);
                }
                method = methodArray[n] = runtimeUtil$ClassMethodKeys.findMethod(n2, n3);
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new LightReflectionException(classNotFoundException);
            }
        }
        return method;
    }

    private static synchronized Method[] getMethods(String string) {
        Method[] methodArray = null;
        Class clazz = Class.forName(string);
        for (int i2 = 0; i2 < MS_RS.size() && (methodArray = ((MethodsRetriever)MS_RS.get(i2)).getMethods(clazz)) == null; ++i2) {
        }
        if (methodArray == null) {
            methodArray = clazz.getMethods();
        }
        return methodArray;
    }

    static {
        int n;
        BC_OS = Math.abs(-128);
        BYTE_CACHE = new Byte[256];
        CHARACTER_CACHE = new Character[128];
        SC_OS = Math.abs(-64);
        SHORT_CACHE = new Short[512];
        IC_OS = Math.abs(-64);
        INTEGER_CACHE = new Integer[512];
        LC_OS = Math.abs(-64);
        LONG_CACHE = new Long[512];
        CLASS_METHOD_KEYS = Collections.synchronizedMap(new IdentityHashMap());
        MS_RS = new ArrayList();
        for (n = 0; n < BYTE_CACHE.length; ++n) {
            RuntimeUtil.BYTE_CACHE[n] = new Byte((byte)(n + -128));
        }
        for (n = 0; n < CHARACTER_CACHE.length; ++n) {
            RuntimeUtil.CHARACTER_CACHE[n] = new Character((char)n);
        }
        for (n = 0; n < SHORT_CACHE.length; ++n) {
            RuntimeUtil.SHORT_CACHE[n] = new Short((short)(n + -64));
        }
        for (n = 0; n < INTEGER_CACHE.length; ++n) {
            RuntimeUtil.INTEGER_CACHE[n] = new Integer(n + -64);
        }
        for (n = 0; n < LONG_CACHE.length; ++n) {
            RuntimeUtil.LONG_CACHE[n] = new Long(n + -64);
        }
    }
}

