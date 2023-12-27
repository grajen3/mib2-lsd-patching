/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.Label
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.commons.GeneratorAdapter
 *  org.objectweb.asm.commons.Method
 *  org.objectweb.asm.commons.TableSwitchGenerator
 */
package de.vw.mib.reflection.impl.mma;

import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.reflection.LightReflectionClassData;
import de.vw.mib.reflection.LightReflectionException;
import de.vw.mib.reflection.impl.ClassGenerator;
import de.vw.mib.reflection.impl.GeneratorArea;
import de.vw.mib.reflection.impl.ma.MethodAccessibleGenerator;
import de.vw.mib.reflection.impl.mma.IndexNameSwitchGenerator;
import de.vw.mib.reflection.impl.mma.IndexTypeSwitchGenerator;
import de.vw.mib.reflection.impl.mma.InvokeSwitchGenerator;
import de.vw.mib.reflection.impl.mma.SegmentInvokeSwitchGenerator;
import java.util.Arrays;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.commons.TableSwitchGenerator;

public final class MultipleMethodAccessibleGenerator
extends ClassGenerator {
    private static final GeneratorArea GA = GeneratorArea.PUBLIC_MMAO_AREA;
    private static final Class BASIC_CL = class$de$vw$mib$reflection$MultipleMethodAccessibleObject == null ? (class$de$vw$mib$reflection$MultipleMethodAccessibleObject = MultipleMethodAccessibleGenerator.class$("de.vw.mib.reflection.MultipleMethodAccessibleObject")) : class$de$vw$mib$reflection$MultipleMethodAccessibleObject;
    private static final String BASIC_CL_NAME = BASIC_CL.getName().replace('.', '/');
    private static final Type BASIC_T = Type.getType((Class)BASIC_CL);
    private static final String SUB_PACKAGE;
    private static final String BASIC_CONSTR_M_DECL;
    private static final Method BASIC_CONSTR_ASM_M;
    private static final String CONSTR_M_DECL;
    private static final Method CONSTR_ASM_M;
    private static final String GET_INDEX_M_DECL;
    private static final Method GET_INDEX_M_ASM_M;
    private static final String T_GET_INDEX_M_PRE;
    private static final String T_GET_INDEX_M_SUF;
    private static final String INVOKE_M_DECL;
    private static final Method INVOKE_ASM_M;
    private static final String S_INVOKE_M_PRE;
    private static final String S_INVOKE_M_SUF;
    private static final int S_I_BITS;
    private static final int S_I_FACTOR;
    private static final Type[] S_EXCEPTIONS;
    private static final Type[] EXCEPTIONS;
    static /* synthetic */ Class class$de$vw$mib$reflection$MultipleMethodAccessibleObject;
    static /* synthetic */ Class class$de$vw$mib$reflection$impl$mma$MultipleMethodAccessibleGenerator;

    public static void validate(String[] stringArray, java.lang.reflect.Method[] methodArray) {
        ClassLoader classLoader = MultipleMethodAccessibleGenerator.getClassLoader(class$de$vw$mib$reflection$impl$mma$MultipleMethodAccessibleGenerator == null ? (class$de$vw$mib$reflection$impl$mma$MultipleMethodAccessibleGenerator = MultipleMethodAccessibleGenerator.class$("de.vw.mib.reflection.impl.mma.MultipleMethodAccessibleGenerator")) : class$de$vw$mib$reflection$impl$mma$MultipleMethodAccessibleGenerator);
        MultipleMethodAccessibleGenerator.validate(stringArray, methodArray, classLoader);
    }

    public static void validate(String[] stringArray, java.lang.reflect.Method[] methodArray, ClassLoader classLoader) {
        int n;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            for (n = 0; n < stringArray.length; ++n) {
                if (n == i2 || !stringArray[i2].equals(stringArray[n])) continue;
                MultipleMethodAccessibleGenerator.throwClassDuplicatedException(stringArray[i2]);
            }
        }
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(stringArray.length);
        for (n = 0; n < stringArray.length; ++n) {
            int n2 = MultipleMethodAccessibleGenerator.buildKey(stringArray[n]);
            if (intObjectOptHashMap.containsKey(n2)) {
                if (!intObjectOptHashMap.get(n2).equals(stringArray[n])) {
                    MultipleMethodAccessibleGenerator.throwHashCodeDuplicatedException((String)intObjectOptHashMap.get(n2), stringArray[n]);
                }
            } else {
                intObjectOptHashMap.put(n2, stringArray[n]);
            }
            MethodAccessibleGenerator.validate(stringArray[n], methodArray, classLoader);
        }
    }

    public static LightReflectionClassData create(String string, String[] stringArray, java.lang.reflect.Method[] methodArray) {
        ClassLoader classLoader = MultipleMethodAccessibleGenerator.getClassLoader(class$de$vw$mib$reflection$impl$mma$MultipleMethodAccessibleGenerator == null ? (class$de$vw$mib$reflection$impl$mma$MultipleMethodAccessibleGenerator = MultipleMethodAccessibleGenerator.class$("de.vw.mib.reflection.impl.mma.MultipleMethodAccessibleGenerator")) : class$de$vw$mib$reflection$impl$mma$MultipleMethodAccessibleGenerator);
        return MultipleMethodAccessibleGenerator.create(string, stringArray, methodArray, classLoader);
    }

    public static LightReflectionClassData create(String string, String[] stringArray, java.lang.reflect.Method[] methodArray, ClassLoader classLoader) {
        try {
            int n = MultipleMethodAccessibleGenerator.buildKey(stringArray);
            String string2 = MultipleMethodAccessibleGenerator.createFullPackageName(string);
            String string3 = MultipleMethodAccessibleGenerator.createClassName(GA, n, string2, classLoader);
            String string4 = string3.substring(string3.lastIndexOf(".") + 1);
            byte[] byArray = MultipleMethodAccessibleGenerator.generateClassBytecode(string3, stringArray, methodArray, classLoader);
            return new LightReflectionClassData(string3, string4, byArray);
        }
        catch (Exception exception) {
            throw new LightReflectionException(exception);
        }
    }

    private static String createFullPackageName(String string) {
        if (!string.endsWith(".")) {
            string = new StringBuffer().append(string).append(".").toString();
        }
        return new StringBuffer().append(string).append("mma").toString();
    }

    private static byte[] generateClassBytecode(String string, String[] stringArray, java.lang.reflect.Method[] methodArray, ClassLoader classLoader) {
        int n;
        Object[] objectArray;
        int[] nArray;
        int n2;
        int n3;
        int n4;
        Object object;
        Object object2;
        int n5;
        Method[] methodArray2 = null;
        if (methodArray != null) {
            methodArray2 = new Method[methodArray.length];
            for (n5 = 0; n5 < methodArray.length; ++n5) {
                methodArray2[n5] = Method.getMethod((java.lang.reflect.Method)methodArray[n5]);
            }
        }
        n5 = stringArray.length;
        Class[] classArray = new Class[n5];
        Type[] typeArray = new Type[n5];
        java.lang.reflect.Method[][] methodArray3 = new java.lang.reflect.Method[n5][];
        Method[][] methodArrayArray = new Method[n5][];
        int n6 = 0;
        int[] nArray2 = new int[n5];
        int[][] nArrayArray = new int[n5][];
        int[][][] nArrayArray2 = new int[n5][][];
        for (int i2 = 0; i2 < n5; ++i2) {
            Object object3;
            classArray[i2] = classLoader.loadClass(stringArray[i2]);
            typeArray[i2] = Type.getType((Class)classArray[i2]);
            nArray2[i2] = MultipleMethodAccessibleGenerator.buildKey(stringArray[i2]);
            object2 = classArray[i2].getMethods();
            object = new java.lang.reflect.Method[((int[][])object2).length];
            Method[] methodArray4 = new Method[((int[][])object2).length];
            n4 = 0;
            int[] nArray3 = new int[((int[][])object2).length];
            n3 = -1;
            int[][] nArrayArray3 = new int[((int[][])object2).length][];
            for (int i3 = 0; i3 < ((int[][])object2).length; ++i3) {
                object3 = object2[i3];
                Method method = Method.getMethod((java.lang.reflect.Method)object3);
                if (MultipleMethodAccessibleGenerator.contains(method, methodArray2)) continue;
                object[n4] = (int[][][])object3;
                methodArray4[n4] = method;
                ++n4;
                int n7 = MultipleMethodAccessibleGenerator.buildKey(object3.getName());
                int n8 = MultipleMethodAccessibleGenerator.buildKey(object3.getParameterTypes());
                n2 = MultipleMethodAccessibleGenerator.getMethodNameHashCodeIndex(nArray3, n3 + 1, n7);
                if (n2 < 0) {
                    nArray3[++n3] = n7;
                    nArrayArray3[n3] = new int[0];
                }
                nArray = new int[nArrayArray3[n3].length + 1];
                System.arraycopy((Object)nArrayArray3[n3], 0, (Object)nArray, 0, nArrayArray3[n3].length);
                nArrayArray3[n3] = nArray;
                nArrayArray3[n3][nArrayArray3[n3].length - 1] = n8;
            }
            methodArray3[i2] = new java.lang.reflect.Method[n4];
            System.arraycopy(object, 0, (Object)methodArray3[i2], 0, n4);
            methodArrayArray[i2] = new Method[n4];
            System.arraycopy((Object)methodArray4, 0, (Object)methodArrayArray[i2], 0, n4);
            n6 += n4;
            objectArray = new int[n3 + 1];
            System.arraycopy((Object)nArray3, 0, (Object)objectArray, 0, n3 + 1);
            object3 = new int[n3 + 1][];
            System.arraycopy(nArrayArray3, 0, object3, 0, n3 + 1);
            nArrayArray[i2] = (int[])objectArray;
            nArrayArray2[i2] = (int[][])object3;
        }
        int[] nArray4 = new int[n6];
        object2 = new int[n6][2];
        object = new int[n5][][][];
        int n9 = 0;
        for (n4 = 0; n4 < nArray2.length; ++n4) {
            int n10 = 0;
            object[n4] = new int[nArrayArray[n4].length][][];
            for (n3 = 0; n3 < nArrayArray[n4].length; ++n3) {
                object[n4][n3] = new int[nArrayArray2[n4][n3].length][];
                for (int i4 = 0; i4 < nArrayArray2[n4][n3].length; ++i4) {
                    nArray4[n9] = n9;
                    object2[n9] = new int[]{n4, n10++};
                    object[n4][n3][i4] = new int[]{nArrayArray2[n4][n3][i4], n9++};
                }
            }
        }
        ClassWriter classWriter = new ClassWriter(1);
        String string2 = string.replace('.', '/');
        StringBuffer stringBuffer = new StringBuffer(string.length() + 2);
        stringBuffer.append("L").append(string2).append(";");
        Type type = Type.getType((String)stringBuffer.toString());
        classWriter.visit(48, 17, string2, null, BASIC_CL_NAME, null);
        MultipleMethodAccessibleGenerator.addConstructor(classWriter);
        objectArray = new Method[n5];
        for (n = 0; n < n5; ++n) {
            objectArray[n] = Method.getMethod((String)new StringBuffer().append("int a").append(n).append("(int, boolean, int)").toString());
            MultipleMethodAccessibleGenerator.addTypeGetIndex(classWriter, objectArray[n], nArrayArray[n], object[n]);
        }
        MultipleMethodAccessibleGenerator.addGetIndex(classWriter, type, nArray2, objectArray);
        n = nArray4.length >> 5;
        int n11 = nArray4.length - n * 32;
        Method[] methodArray5 = n11 == 0 ? new Method[n] : new Method[n + 1];
        int[] nArray5 = n11 == 0 ? new int[n] : new int[n + 1];
        for (n2 = 0; n2 < n; ++n2) {
            nArray = new int[32];
            for (int i5 = 0; i5 < 32; ++i5) {
                nArray[i5] = (n2 << 5) + i5;
            }
            methodArray5[n2] = Method.getMethod((String)new StringBuffer().append("Object f").append(n2).append("(int, Object, Object[])").toString());
            nArray5[n2] = n2;
            MultipleMethodAccessibleGenerator.addSegmentInvokeMethod(classWriter, methodArray5[n2], nArray, classArray, typeArray, methodArray3, methodArrayArray, object2);
        }
        if (n11 > 0) {
            int[] nArray6 = new int[n11];
            for (int i6 = 0; i6 < n11; ++i6) {
                nArray6[i6] = nArray4.length - n11 + i6;
            }
            methodArray5[n] = Method.getMethod((String)new StringBuffer().append("Object f").append(n).append("(int, Object, Object[])").toString());
            nArray5[n] = n;
            MultipleMethodAccessibleGenerator.addSegmentInvokeMethod(classWriter, methodArray5[n], nArray6, classArray, typeArray, methodArray3, methodArrayArray, object2);
        }
        MultipleMethodAccessibleGenerator.addInvokeMethod(classWriter, nArray5, type, methodArray5);
        return classWriter.toByteArray();
    }

    private static void addConstructor(ClassWriter classWriter) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, CONSTR_ASM_M, null, null, (ClassVisitor)classWriter);
        generatorAdapter.loadThis();
        generatorAdapter.invokeConstructor(BASIC_T, BASIC_CONSTR_ASM_M);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();
    }

    private static void addTypeGetIndex(ClassWriter classWriter, Method method, int[] nArray, int[][][] nArray2) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(2, method, null, null, (ClassVisitor)classWriter);
        int n = generatorAdapter.newLocal(INT_ASM_T);
        generatorAdapter.push(-1);
        generatorAdapter.storeLocal(n);
        generatorAdapter.loadArg(0);
        int[] nArray3 = (int[])nArray.clone();
        Arrays.sort(nArray3);
        int[][][] nArrayArray = new int[nArray3.length][][];
        block0: for (int i2 = 0; i2 < nArray3.length; ++i2) {
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (nArray3[i2] != nArray[i3]) continue;
                nArrayArray[i2] = nArray2[i3];
                continue block0;
            }
        }
        IndexNameSwitchGenerator indexNameSwitchGenerator = new IndexNameSwitchGenerator(nArray3, nArrayArray, n, generatorAdapter);
        generatorAdapter.tableSwitch(nArray3, (TableSwitchGenerator)indexNameSwitchGenerator);
        generatorAdapter.loadLocal(n);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();
    }

    private static void addGetIndex(ClassWriter classWriter, Type type, int[] nArray, Method[] methodArray) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, GET_INDEX_M_ASM_M, null, null, (ClassVisitor)classWriter);
        int n = generatorAdapter.newLocal(INT_ASM_T);
        generatorAdapter.push(-1);
        generatorAdapter.storeLocal(n);
        int n2 = generatorAdapter.newLocal(INT_ASM_T);
        generatorAdapter.loadArg(0);
        generatorAdapter.invokeStatic(RU_ASM_T, RU_BUILD_KEY_STR_ASM_M);
        generatorAdapter.storeLocal(n2, INT_ASM_T);
        int n3 = generatorAdapter.newLocal(INT_ASM_T);
        generatorAdapter.loadArg(1);
        generatorAdapter.invokeStatic(RU_ASM_T, RU_BUILD_KEY_STR_ASM_M);
        generatorAdapter.storeLocal(n3, INT_ASM_T);
        int n4 = generatorAdapter.newLocal(BOOL_ASM_T);
        int n5 = generatorAdapter.newLocal(INT_ASM_T);
        Label label = generatorAdapter.newLabel();
        Label label2 = generatorAdapter.newLabel();
        generatorAdapter.loadArg(2);
        generatorAdapter.ifNull(label);
        generatorAdapter.push(true);
        generatorAdapter.storeLocal(n4, BOOL_ASM_T);
        generatorAdapter.loadArg(2);
        generatorAdapter.invokeStatic(RU_ASM_T, RU_BUILD_KEY_CLASS_A_ASM_M);
        generatorAdapter.storeLocal(n5, INT_ASM_T);
        generatorAdapter.goTo(label2);
        generatorAdapter.mark(label);
        generatorAdapter.push(false);
        generatorAdapter.storeLocal(n4, BOOL_ASM_T);
        generatorAdapter.push(0);
        generatorAdapter.storeLocal(n5, INT_ASM_T);
        generatorAdapter.mark(label2);
        generatorAdapter.loadLocal(n2);
        int[] nArray2 = (int[])nArray.clone();
        Arrays.sort(nArray2);
        Method[] methodArray2 = new Method[nArray2.length];
        block0: for (int i2 = 0; i2 < nArray2.length; ++i2) {
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (nArray2[i2] != nArray[i3]) continue;
                methodArray2[i2] = methodArray[i3];
                continue block0;
            }
        }
        IndexTypeSwitchGenerator indexTypeSwitchGenerator = new IndexTypeSwitchGenerator(nArray2, type, methodArray2, n3, n4, n5, n, generatorAdapter);
        generatorAdapter.tableSwitch(nArray2, (TableSwitchGenerator)indexTypeSwitchGenerator);
        generatorAdapter.loadLocal(n);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();
    }

    private static void addSegmentInvokeMethod(ClassWriter classWriter, Method method, int[] nArray, Class[] classArray, Type[] typeArray, java.lang.reflect.Method[][] methodArray, Method[][] methodArray2, int[][] nArray2) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(2, method, null, S_EXCEPTIONS, (ClassVisitor)classWriter);
        generatorAdapter.loadArg(0);
        SegmentInvokeSwitchGenerator segmentInvokeSwitchGenerator = new SegmentInvokeSwitchGenerator(classArray, typeArray, methodArray, methodArray2, nArray2, generatorAdapter);
        generatorAdapter.tableSwitch(nArray, (TableSwitchGenerator)segmentInvokeSwitchGenerator);
        generatorAdapter.endMethod();
    }

    private static void addInvokeMethod(ClassWriter classWriter, int[] nArray, Type type, Method[] methodArray) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, INVOKE_ASM_M, null, EXCEPTIONS, (ClassVisitor)classWriter);
        Label label = generatorAdapter.newLabel();
        Label label2 = generatorAdapter.newLabel();
        generatorAdapter.mark(label);
        generatorAdapter.loadArg(0);
        generatorAdapter.push(5);
        generatorAdapter.math(122, INT_ASM_T);
        InvokeSwitchGenerator invokeSwitchGenerator = new InvokeSwitchGenerator(type, methodArray, generatorAdapter);
        generatorAdapter.tableSwitch(nArray, (TableSwitchGenerator)invokeSwitchGenerator);
        generatorAdapter.mark(label2);
        generatorAdapter.catchException(label, label2, THR_ASM_T);
        int n = generatorAdapter.newLocal(THR_ASM_T);
        generatorAdapter.storeLocal(n);
        generatorAdapter.newInstance(INV_T_EXC_ASM_T);
        generatorAdapter.dup();
        generatorAdapter.loadLocal(n);
        generatorAdapter.invokeConstructor(INV_T_EXC_ASM_T, INV_T_EXC_C_ASM_M);
        generatorAdapter.throwException();
        generatorAdapter.endMethod();
    }

    private MultipleMethodAccessibleGenerator() {
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
        BASIC_CONSTR_ASM_M = Method.getMethod((String)"void <init>()");
        CONSTR_ASM_M = Method.getMethod((String)"void <init> ()");
        GET_INDEX_M_ASM_M = Method.getMethod((String)"int getIndex(String, String, Class[])");
        INVOKE_ASM_M = Method.getMethod((String)"Object invoke(int, Object, Object[])");
        S_EXCEPTIONS = new Type[]{THR_ASM_T};
        EXCEPTIONS = new Type[]{INV_T_EXC_ASM_T};
    }
}

