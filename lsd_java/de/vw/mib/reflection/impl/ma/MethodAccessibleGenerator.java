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
package de.vw.mib.reflection.impl.ma;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.reflection.LightReflectionClassData;
import de.vw.mib.reflection.LightReflectionException;
import de.vw.mib.reflection.impl.ClassGenerator;
import de.vw.mib.reflection.impl.Constants;
import de.vw.mib.reflection.impl.GeneratorArea;
import de.vw.mib.reflection.impl.ma.IndexSwitchGenerator;
import de.vw.mib.reflection.impl.ma.InvokeSwitchGenerator;
import java.util.Arrays;
import java.util.List;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.commons.TableSwitchGenerator;

public final class MethodAccessibleGenerator
extends ClassGenerator
implements Constants {
    private static final GeneratorArea GA = GeneratorArea.PUBLIC_MAO_AREA;
    private static final Class BASIC_CL = class$de$vw$mib$reflection$MethodAccessibleObject == null ? (class$de$vw$mib$reflection$MethodAccessibleObject = MethodAccessibleGenerator.class$("de.vw.mib.reflection.MethodAccessibleObject")) : class$de$vw$mib$reflection$MethodAccessibleObject;
    private static final String BASIC_CL_NAME = BASIC_CL.getName().replace('.', '/');
    private static final Type BASIC_T = Type.getType((Class)BASIC_CL);
    private static final String SUB_PACKAGE;
    private static final String BASIC_CONSTR_M_DECL;
    private static final Method BASIC_CONSTR_ASM_M;
    private static final String CONSTR_M_DECL;
    private static final Method CONSTR_ASM_M;
    private static final String GET_INDEX_M_DECL;
    private static final Method GET_INDEX_M_ASM_M;
    private static final String INVOKE_M_DECL;
    private static final Method INVOKE_ASM_M;
    private static final Type[] EXCEPTIONS;
    static /* synthetic */ Class class$de$vw$mib$reflection$MethodAccessibleObject;
    static /* synthetic */ Class class$de$vw$mib$reflection$impl$ma$MethodAccessibleGenerator;

    public static void validate(String string, java.lang.reflect.Method[] methodArray, ClassLoader classLoader) {
        try {
            List list = methodArray != null ? Arrays.asList(methodArray) : null;
            Class clazz = classLoader.loadClass(string);
            java.lang.reflect.Method[] methodArray2 = clazz.getMethods();
            IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(methodArray2.length);
            IntObjectOptHashMap intObjectOptHashMap2 = new IntObjectOptHashMap(methodArray2.length);
            for (int i2 = 0; i2 < methodArray2.length; ++i2) {
                if (list != null && list.contains(methodArray2[i2])) continue;
                String string2 = methodArray2[i2].getName();
                int n = MethodAccessibleGenerator.buildKey(string2);
                if (intObjectOptHashMap.containsKey(n)) {
                    if (!intObjectOptHashMap.get(n).equals(string2)) {
                        MethodAccessibleGenerator.throwHashCodeDuplicatedException(clazz, (String)intObjectOptHashMap.get(n), string2);
                    }
                } else {
                    intObjectOptHashMap.put(n, string2);
                    intObjectOptHashMap2.put(n, new IntObjectOptHashMap());
                }
                Class[] classArray = methodArray2[i2].getParameterTypes();
                int n2 = MethodAccessibleGenerator.buildKey(classArray);
                IntObjectMap intObjectMap = (IntObjectMap)intObjectOptHashMap2.get(n);
                if (intObjectMap.containsKey(n2)) {
                    if (intObjectMap.get(n2).equals(classArray)) continue;
                    MethodAccessibleGenerator.throwHashCodeDuplicatedException(clazz, (Class[])intObjectMap.get(n2), classArray);
                    continue;
                }
                intObjectMap.put(n2, classArray);
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new LightReflectionException(classNotFoundException);
        }
    }

    public static LightReflectionClassData create(String string, String string2, java.lang.reflect.Method[] methodArray) {
        ClassLoader classLoader = MethodAccessibleGenerator.getClassLoader(class$de$vw$mib$reflection$impl$ma$MethodAccessibleGenerator == null ? (class$de$vw$mib$reflection$impl$ma$MethodAccessibleGenerator = MethodAccessibleGenerator.class$("de.vw.mib.reflection.impl.ma.MethodAccessibleGenerator")) : class$de$vw$mib$reflection$impl$ma$MethodAccessibleGenerator);
        return MethodAccessibleGenerator.create(string, string2, methodArray, classLoader);
    }

    public static LightReflectionClassData create(String string, String string2, java.lang.reflect.Method[] methodArray, ClassLoader classLoader) {
        try {
            int n = MethodAccessibleGenerator.buildKey(string2);
            String string3 = MethodAccessibleGenerator.createFullPackageName(string);
            String string4 = MethodAccessibleGenerator.createClassName(GA, n, string3, classLoader);
            String string5 = string4.substring(string4.lastIndexOf(".") + 1);
            byte[] byArray = MethodAccessibleGenerator.generateClassBytecode(string4, string2, methodArray, classLoader);
            return new LightReflectionClassData(string4, string5, byArray);
        }
        catch (Exception exception) {
            throw new LightReflectionException(exception);
        }
    }

    private static String createFullPackageName(String string) {
        if (!string.endsWith(".")) {
            string = new StringBuffer().append(string).append(".").toString();
        }
        return new StringBuffer().append(string).append("ma").toString();
    }

    private static byte[] generateClassBytecode(String string, String string2, java.lang.reflect.Method[] methodArray, ClassLoader classLoader) {
        Object object;
        Method[] methodArray2;
        Method[] methodArray3 = null;
        if (methodArray != null) {
            methodArray3 = new Method[methodArray.length];
            for (int i2 = 0; i2 < methodArray.length; ++i2) {
                methodArray3[i2] = Method.getMethod((java.lang.reflect.Method)methodArray[i2]);
            }
        }
        Class clazz = classLoader.loadClass(string2);
        java.lang.reflect.Method[] methodArray4 = clazz.getMethods();
        java.lang.reflect.Method[] methodArray5 = clazz.getMethods();
        Method[] methodArray6 = new Method[methodArray4.length];
        int n = 0;
        Object object2 = new int[methodArray4.length];
        int n2 = -1;
        int[][] nArrayArray = new int[methodArray4.length][];
        for (int i3 = 0; i3 < methodArray4.length; ++i3) {
            methodArray2 = methodArray4[i3];
            object = Method.getMethod((java.lang.reflect.Method)methodArray2);
            if (MethodAccessibleGenerator.contains(object, methodArray3)) continue;
            methodArray5[n] = methodArray2;
            methodArray6[n] = object;
            ++n;
            int n3 = MethodAccessibleGenerator.buildKey(methodArray2.getName());
            int n4 = MethodAccessibleGenerator.buildKey(methodArray2.getParameterTypes());
            int n5 = MethodAccessibleGenerator.getMethodNameHashCodeIndex(object2, n2 + 1, n3);
            if (n5 < 0) {
                object2[++n2] = n3;
                nArrayArray[n2] = new int[0];
            }
            int[] nArray = new int[nArrayArray[n2].length + 1];
            System.arraycopy((Object)nArrayArray[n2], 0, (Object)nArray, 0, nArrayArray[n2].length);
            nArrayArray[n2] = nArray;
            nArrayArray[n2][nArrayArray[n2].length - 1] = n4;
        }
        java.lang.reflect.Method[] methodArray7 = new java.lang.reflect.Method[n];
        System.arraycopy((Object)methodArray5, 0, (Object)methodArray7, 0, n);
        methodArray2 = new Method[n];
        System.arraycopy((Object)methodArray6, 0, (Object)methodArray2, 0, n);
        object = new int[n2 + 1];
        System.arraycopy(object2, 0, object, 0, n2 + 1);
        object2 = object;
        int[][] nArrayArray2 = new int[n2 + 1][];
        System.arraycopy(nArrayArray, 0, nArrayArray2, 0, n2 + 1);
        nArrayArray = nArrayArray2;
        int[] nArray = new int[methodArray7.length];
        int[][][] nArrayArray3 = new int[methodArray7.length][][];
        int n6 = 0;
        for (int i4 = 0; i4 < ((int[])object2).length; ++i4) {
            nArrayArray3[i4] = new int[nArrayArray[i4].length][];
            for (int i5 = 0; i5 < nArrayArray[i4].length; ++i5) {
                nArray[n6] = n6;
                nArrayArray3[i4][i5] = new int[]{nArrayArray[i4][i5], n6++};
            }
        }
        ClassWriter classWriter = new ClassWriter(1);
        String string3 = string.replace('.', '/');
        classWriter.visit(48, 17, string3, null, BASIC_CL_NAME, null);
        MethodAccessibleGenerator.addConstructor(classWriter);
        MethodAccessibleGenerator.addGetIndex(classWriter, object2, nArrayArray3);
        MethodAccessibleGenerator.addInvokeMethod(classWriter, nArray, clazz, methodArray7, methodArray2);
        return classWriter.toByteArray();
    }

    private static void addConstructor(ClassWriter classWriter) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, CONSTR_ASM_M, null, null, (ClassVisitor)classWriter);
        generatorAdapter.loadThis();
        generatorAdapter.invokeConstructor(BASIC_T, BASIC_CONSTR_ASM_M);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();
    }

    private static void addGetIndex(ClassWriter classWriter, int[] nArray, int[][][] nArray2) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, GET_INDEX_M_ASM_M, null, null, (ClassVisitor)classWriter);
        int n = generatorAdapter.newLocal(INT_ASM_T);
        generatorAdapter.push(-1);
        generatorAdapter.storeLocal(n);
        int n2 = generatorAdapter.newLocal(INT_ASM_T);
        generatorAdapter.loadArg(0);
        generatorAdapter.invokeStatic(RU_ASM_T, RU_BUILD_KEY_STR_ASM_M);
        generatorAdapter.storeLocal(n2, INT_ASM_T);
        int n3 = generatorAdapter.newLocal(BOOL_ASM_T);
        int n4 = generatorAdapter.newLocal(INT_ASM_T);
        Label label = generatorAdapter.newLabel();
        Label label2 = generatorAdapter.newLabel();
        generatorAdapter.loadArg(1);
        generatorAdapter.ifNull(label);
        generatorAdapter.push(true);
        generatorAdapter.storeLocal(n3, BOOL_ASM_T);
        generatorAdapter.loadArg(1);
        generatorAdapter.invokeStatic(RU_ASM_T, RU_BUILD_KEY_CLASS_A_ASM_M);
        generatorAdapter.storeLocal(n4, INT_ASM_T);
        generatorAdapter.goTo(label2);
        generatorAdapter.mark(label);
        generatorAdapter.push(false);
        generatorAdapter.storeLocal(n3, BOOL_ASM_T);
        generatorAdapter.push(0);
        generatorAdapter.storeLocal(n4, INT_ASM_T);
        generatorAdapter.mark(label2);
        generatorAdapter.loadLocal(n2);
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
        IndexSwitchGenerator indexSwitchGenerator = new IndexSwitchGenerator(nArray3, nArrayArray, n3, n4, n, generatorAdapter);
        generatorAdapter.tableSwitch(nArray3, (TableSwitchGenerator)indexSwitchGenerator);
        generatorAdapter.loadLocal(n);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();
    }

    private static void addInvokeMethod(ClassWriter classWriter, int[] nArray, Class clazz, java.lang.reflect.Method[] methodArray, Method[] methodArray2) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, INVOKE_ASM_M, null, EXCEPTIONS, (ClassVisitor)classWriter);
        Label label = generatorAdapter.newLabel();
        Label label2 = generatorAdapter.newLabel();
        generatorAdapter.mark(label);
        generatorAdapter.loadArg(0);
        InvokeSwitchGenerator invokeSwitchGenerator = new InvokeSwitchGenerator(clazz, methodArray, methodArray2, generatorAdapter);
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

    private MethodAccessibleGenerator() {
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
        GET_INDEX_M_ASM_M = Method.getMethod((String)"int getIndex(String, Class[])");
        INVOKE_ASM_M = Method.getMethod((String)"Object invoke(int, Object, Object[])");
        EXCEPTIONS = new Type[]{INV_T_EXC_ASM_T};
    }
}

