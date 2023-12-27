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
package de.vw.mib.reflection.impl.mca;

import de.vw.mib.reflection.LightReflectionClassData;
import de.vw.mib.reflection.LightReflectionException;
import de.vw.mib.reflection.impl.ClassGenerator;
import de.vw.mib.reflection.impl.Constants;
import de.vw.mib.reflection.impl.GeneratorArea;
import de.vw.mib.reflection.impl.mca.IndexParameterTypeSwitchGenerator;
import de.vw.mib.reflection.impl.mca.IndexTypeSwitchGenerator;
import de.vw.mib.reflection.impl.mca.NewInstanceSwitchGenerator;
import de.vw.mib.reflection.impl.mca.SegmentNewInstanceSwitchGenerator;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.commons.TableSwitchGenerator;

public final class MultipleConstructorAccessibleGenerator
extends ClassGenerator
implements Constants {
    private static final GeneratorArea GA = GeneratorArea.PUBLIC_MCAO_AREA;
    private static final Class BASIC_CL = class$de$vw$mib$reflection$MultipleConstructorAccessibleObject == null ? (class$de$vw$mib$reflection$MultipleConstructorAccessibleObject = MultipleConstructorAccessibleGenerator.class$("de.vw.mib.reflection.MultipleConstructorAccessibleObject")) : class$de$vw$mib$reflection$MultipleConstructorAccessibleObject;
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
    private static final String NEW_INSTANCE_M_DECL;
    private static final Method NEW_INSTANCE_ASM_M;
    private static final String S_NEW_INSTANCE_M_PRE;
    private static final String S_NEW_INSTANCE_M_SUF;
    private static final int S_NI_BITS;
    private static final int S_NI_FACTOR;
    private static final Type[] S_EXCEPTIONS;
    private static final Type[] EXCEPTIONS;
    static /* synthetic */ Class class$de$vw$mib$reflection$MultipleConstructorAccessibleObject;

    public static LightReflectionClassData create(String string, String[] stringArray) {
        ClassLoader classLoader = MultipleConstructorAccessibleGenerator.getClassLoader(class$de$vw$mib$reflection$MultipleConstructorAccessibleObject == null ? (class$de$vw$mib$reflection$MultipleConstructorAccessibleObject = MultipleConstructorAccessibleGenerator.class$("de.vw.mib.reflection.MultipleConstructorAccessibleObject")) : class$de$vw$mib$reflection$MultipleConstructorAccessibleObject);
        return MultipleConstructorAccessibleGenerator.create(string, stringArray, classLoader);
    }

    public static LightReflectionClassData create(String string, String[] stringArray, ClassLoader classLoader) {
        try {
            int n = MultipleConstructorAccessibleGenerator.buildKey(stringArray);
            String string2 = MultipleConstructorAccessibleGenerator.createFullPackageName(string);
            String string3 = MultipleConstructorAccessibleGenerator.createClassName(GA, n, string2, classLoader);
            String string4 = string3.substring(string3.lastIndexOf(".") + 1);
            byte[] byArray = MultipleConstructorAccessibleGenerator.generateClassBytecode(string3, stringArray, classLoader);
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
        return new StringBuffer().append(string).append("mca").toString();
    }

    private static byte[] generateClassBytecode(String string, String[] stringArray, ClassLoader classLoader) {
        int n;
        Object object;
        int n2 = stringArray.length;
        Class[] classArray = new Class[n2];
        Type[] typeArray = new Type[n2];
        Constructor[][] constructorArray = new Constructor[n2][];
        int n3 = 0;
        int[] nArray = new int[n2];
        int[][] nArrayArray = new int[n2][];
        for (int i2 = 0; i2 < n2; ++i2) {
            classArray[i2] = classLoader.loadClass(stringArray[i2]);
            typeArray[i2] = Type.getType((Class)classArray[i2]);
            nArray[i2] = MultipleConstructorAccessibleGenerator.buildKey(stringArray[i2]);
            constructorArray[i2] = classArray[i2].getConstructors();
            nArrayArray[i2] = new int[constructorArray[i2].length];
            for (int i3 = 0; i3 < constructorArray[i2].length; ++i3) {
                object = constructorArray[i2][i3];
                nArrayArray[i2][i3] = MultipleConstructorAccessibleGenerator.buildKey(((Constructor)object).getParameterTypes());
                ++n3;
            }
        }
        int[] nArray2 = new int[n3];
        int[][] nArray3 = new int[n3][2];
        object = new int[n2][];
        int n4 = 0;
        for (int i4 = 0; i4 < nArray.length; ++i4) {
            object[i4] = new int[nArrayArray[i4].length];
            for (int i5 = 0; i5 < object[i4].length; ++i5) {
                nArray3[n4] = new int[]{i4, i5};
                object[i4][i5] = n4;
                nArray2[n4] = n4;
                ++n4;
            }
        }
        ClassWriter classWriter = new ClassWriter(1);
        String string2 = string.replace('.', '/');
        StringBuffer stringBuffer = new StringBuffer(string.length() + 2);
        stringBuffer.append("L").append(string2).append(";");
        Type type = Type.getType((String)stringBuffer.toString());
        classWriter.visit(48, 17, string2, null, BASIC_CL_NAME, null);
        MultipleConstructorAccessibleGenerator.addConstructor(classWriter);
        Method[] methodArray = new Method[n2];
        for (n = 0; n < n2; ++n) {
            methodArray[n] = Method.getMethod((String)new StringBuffer().append("int a").append(n).append("(int)").toString());
            MultipleConstructorAccessibleGenerator.addTypeGetIndex(classWriter, methodArray[n], nArrayArray[n], (int[])object[n]);
        }
        MultipleConstructorAccessibleGenerator.addGetIndex(classWriter, type, nArray, methodArray, (int[][])object);
        n = nArray2.length >> 5;
        int n5 = nArray2.length - n * 32;
        Method[] methodArray2 = n5 == 0 ? new Method[n] : new Method[n + 1];
        int[] nArray4 = n5 == 0 ? new int[n] : new int[n + 1];
        for (int i6 = 0; i6 < n; ++i6) {
            int[] nArray5 = new int[32];
            for (int i7 = 0; i7 < 32; ++i7) {
                nArray5[i7] = (i6 << 5) + i7;
            }
            methodArray2[i6] = Method.getMethod((String)new StringBuffer().append("Object f").append(i6).append("(int, Object[])").toString());
            nArray4[i6] = i6;
            MultipleConstructorAccessibleGenerator.addSegmentNewInstanceMethod(classWriter, methodArray2[i6], nArray5, typeArray, constructorArray, nArray3);
        }
        if (n5 > 0) {
            int[] nArray6 = new int[n5];
            for (int i8 = 0; i8 < n5; ++i8) {
                nArray6[i8] = nArray2.length - n5 + i8;
            }
            methodArray2[n] = Method.getMethod((String)new StringBuffer().append("Object f").append(n).append("(int, Object[])").toString());
            nArray4[n] = n;
            MultipleConstructorAccessibleGenerator.addSegmentNewInstanceMethod(classWriter, methodArray2[n], nArray6, typeArray, constructorArray, nArray3);
        }
        MultipleConstructorAccessibleGenerator.addNewInstanceMethod(classWriter, nArray4, type, methodArray2);
        return classWriter.toByteArray();
    }

    private static void addConstructor(ClassWriter classWriter) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, CONSTR_ASM_M, null, null, (ClassVisitor)classWriter);
        generatorAdapter.loadThis();
        generatorAdapter.invokeConstructor(BASIC_T, BASIC_CONSTR_ASM_M);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();
    }

    private static void addTypeGetIndex(ClassWriter classWriter, Method method, int[] nArray, int[] nArray2) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(2, method, null, null, (ClassVisitor)classWriter);
        generatorAdapter.loadArg(0);
        int[] nArray3 = (int[])nArray.clone();
        Arrays.sort(nArray3);
        int[] nArray4 = new int[nArray3.length];
        block0: for (int i2 = 0; i2 < nArray3.length; ++i2) {
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (nArray3[i2] != nArray[i3]) continue;
                nArray4[i2] = nArray2[i3];
                continue block0;
            }
        }
        IndexParameterTypeSwitchGenerator indexParameterTypeSwitchGenerator = new IndexParameterTypeSwitchGenerator(nArray3, nArray4, generatorAdapter);
        generatorAdapter.tableSwitch(nArray3, (TableSwitchGenerator)indexParameterTypeSwitchGenerator);
        generatorAdapter.endMethod();
    }

    private static void addGetIndex(ClassWriter classWriter, Type type, int[] nArray, Method[] methodArray, int[][] nArray2) {
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
        Method[] methodArray2 = new Method[nArray3.length];
        int[][] nArrayArray = new int[nArray3.length][];
        block0: for (int i2 = 0; i2 < nArray3.length; ++i2) {
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (nArray3[i2] != nArray[i3]) continue;
                methodArray2[i2] = methodArray[i3];
                nArrayArray[i2] = nArray2[i3];
                continue block0;
            }
        }
        IndexTypeSwitchGenerator indexTypeSwitchGenerator = new IndexTypeSwitchGenerator(nArray3, type, methodArray2, nArrayArray, n3, n4, n, generatorAdapter);
        generatorAdapter.tableSwitch(nArray3, (TableSwitchGenerator)indexTypeSwitchGenerator);
        generatorAdapter.loadLocal(n);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();
    }

    private static void addSegmentNewInstanceMethod(ClassWriter classWriter, Method method, int[] nArray, Type[] typeArray, Constructor[][] constructorArray, int[][] nArray2) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(2, method, null, S_EXCEPTIONS, (ClassVisitor)classWriter);
        generatorAdapter.loadArg(0);
        SegmentNewInstanceSwitchGenerator segmentNewInstanceSwitchGenerator = new SegmentNewInstanceSwitchGenerator(typeArray, constructorArray, nArray2, generatorAdapter);
        generatorAdapter.tableSwitch(nArray, (TableSwitchGenerator)segmentNewInstanceSwitchGenerator);
        generatorAdapter.endMethod();
    }

    private static void addNewInstanceMethod(ClassWriter classWriter, int[] nArray, Type type, Method[] methodArray) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, NEW_INSTANCE_ASM_M, null, EXCEPTIONS, (ClassVisitor)classWriter);
        Label label = generatorAdapter.newLabel();
        Label label2 = generatorAdapter.newLabel();
        generatorAdapter.mark(label);
        generatorAdapter.loadArg(0);
        generatorAdapter.push(5);
        generatorAdapter.math(122, INT_ASM_T);
        NewInstanceSwitchGenerator newInstanceSwitchGenerator = new NewInstanceSwitchGenerator(type, methodArray, generatorAdapter);
        generatorAdapter.tableSwitch(nArray, (TableSwitchGenerator)newInstanceSwitchGenerator);
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

    private MultipleConstructorAccessibleGenerator() {
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
        NEW_INSTANCE_ASM_M = Method.getMethod((String)"Object newInstance( int, Object[] )");
        S_EXCEPTIONS = new Type[]{THR_ASM_T};
        EXCEPTIONS = new Type[]{INV_T_EXC_ASM_T};
    }
}

