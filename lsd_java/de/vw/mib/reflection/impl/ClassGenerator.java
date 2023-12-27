/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.commons.GeneratorAdapter
 *  org.objectweb.asm.commons.Method
 */
package de.vw.mib.reflection.impl;

import de.vw.mib.reflection.LightReflectionException;
import de.vw.mib.reflection.RuntimeUtil;
import de.vw.mib.reflection.impl.Constants;
import de.vw.mib.reflection.impl.GeneratorArea;
import java.util.Set;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

public class ClassGenerator
extends RuntimeUtil
implements Constants {
    private static final String NT;
    public static final String CLF_SUF;

    public static ClassLoader getClassLoader(Class clazz) {
        ClassLoader classLoader = clazz.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        throw new LightReflectionException("Cannot determine classloader.");
    }

    public static int getMethodNameHashCodeIndex(int[] nArray, int n, int n2) {
        int n3 = -1;
        for (int i2 = 0; i2 < Math.min(nArray.length, n); ++i2) {
            if (nArray[i2] != n2) continue;
            n3 = i2;
            break;
        }
        return n3;
    }

    protected static boolean contains(Method method, Method[] methodArray) {
        boolean bl = false;
        if (method != null && methodArray != null) {
            for (int i2 = methodArray.length - 1; !bl && i2 >= 0; --i2) {
                bl = methodArray[i2].equals((Object)method);
            }
        }
        return bl;
    }

    public static void box(Type type, GeneratorAdapter generatorAdapter) {
        switch (type.getSort()) {
            case 1: {
                generatorAdapter.invokeStatic(RU_ASM_T, RU_V_OF_BL_ASM_M);
                break;
            }
            case 2: {
                generatorAdapter.invokeStatic(RU_ASM_T, RU_V_OF_CH_ASM_M);
                break;
            }
            case 3: {
                generatorAdapter.invokeStatic(RU_ASM_T, RU_V_OF_B_ASM_M);
                break;
            }
            case 4: {
                generatorAdapter.invokeStatic(RU_ASM_T, RU_V_OF_S_ASM_M);
                break;
            }
            case 5: {
                generatorAdapter.invokeStatic(RU_ASM_T, RU_V_OF_I_ASM_M);
                break;
            }
            case 7: {
                generatorAdapter.invokeStatic(RU_ASM_T, RU_V_OF_L_ASM_M);
                break;
            }
            case 8: {
                generatorAdapter.invokeStatic(RU_ASM_T, RU_V_OF_D_ASM_M);
                break;
            }
            case 6: {
                generatorAdapter.invokeStatic(RU_ASM_T, RU_V_OF_F_ASM_M);
                break;
            }
        }
    }

    public static String createClassName(GeneratorArea generatorArea, int n, String string, ClassLoader classLoader) {
        StringBuffer stringBuffer = new StringBuffer(32);
        stringBuffer.append(ClassGenerator.getClassNamePrefix(generatorArea, n, string));
        int n2 = stringBuffer.length();
        Set set = generatorArea.getClassNameCache(classLoader);
        int n3 = 1;
        while (set.contains(stringBuffer.toString())) {
            stringBuffer.setLength(n2);
            stringBuffer.append("$").append(n3);
            ++n3;
        }
        return stringBuffer.toString();
    }

    public static StringBuffer getClassNamePrefix(GeneratorArea generatorArea, int n, String string) {
        StringBuffer stringBuffer = new StringBuffer(32);
        stringBuffer.append(string);
        if (!string.endsWith(".")) {
            stringBuffer.append(".");
        }
        stringBuffer.append("LR");
        stringBuffer.append(generatorArea.getId());
        stringBuffer.append(Integer.toHexString(n));
        return stringBuffer;
    }

    public static void throwClassDuplicatedException(String string) {
        StringBuffer stringBuffer = new StringBuffer().append("Class ").append(string).append(" occurs more than one time.");
        throw new LightReflectionException(stringBuffer.toString());
    }

    public static void throwHashCodeDuplicatedException(String string, String string2) {
        StringBuffer stringBuffer = new StringBuffer().append("Duplicated hash code. Class name 1: ").append(string).append(", class name 2: ").append(string2).append(".");
        throw new LightReflectionException(stringBuffer.toString());
    }

    public static void throwHashCodeDuplicatedException(Class clazz, String string, String string2) {
        StringBuffer stringBuffer = new StringBuffer().append("Duplicated hash code. Class: ").append(clazz.getName()).append(", method name 1: ").append(string).append(", method name 2: ").append(string2).append(".");
        throw new LightReflectionException(stringBuffer.toString());
    }

    public static void throwHashCodeDuplicatedException(Class clazz, Class[] classArray, Class[] classArray2) {
        StringBuffer stringBuffer = new StringBuffer().append("Duplicated hash code. Class: ").append(clazz.getName()).append(", parameter types 1: ").append(ClassGenerator.parameterTypesToStringBuffer(classArray)).append(", parameter types 2: ").append(ClassGenerator.parameterTypesToStringBuffer(classArray2)).append(".");
        throw new LightReflectionException(stringBuffer.toString());
    }

    private static StringBuffer parameterTypesToStringBuffer(Class[] classArray) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            stringBuffer.append(classArray[i2].getName());
            if (i2 >= classArray.length - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append(']');
        return stringBuffer;
    }
}

