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
package de.vw.mib.reflection.impl.ca;

import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.reflection.LightReflectionClassData;
import de.vw.mib.reflection.LightReflectionException;
import de.vw.mib.reflection.impl.ClassGenerator;
import de.vw.mib.reflection.impl.Constants;
import de.vw.mib.reflection.impl.GeneratorArea;
import de.vw.mib.reflection.impl.ca.IndexSwitchGenerator;
import de.vw.mib.reflection.impl.ca.NewInstanceSwitchGenerator;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.commons.TableSwitchGenerator;

public final class ConstructorAccessibleGenerator
extends ClassGenerator
implements Constants {
    private static final GeneratorArea GA = GeneratorArea.PUBLIC_CAO_AREA;
    private static final Class BASIC_CL = class$de$vw$mib$reflection$ConstructorAccessibleObject == null ? (class$de$vw$mib$reflection$ConstructorAccessibleObject = ConstructorAccessibleGenerator.class$("de.vw.mib.reflection.ConstructorAccessibleObject")) : class$de$vw$mib$reflection$ConstructorAccessibleObject;
    private static final String BASIC_CL_NAME = BASIC_CL.getName().replace('.', '/');
    private static final Type BASIC_T = Type.getType((Class)BASIC_CL);
    private static final String SUB_PACKAGE;
    private static final String BASIC_CONSTR_M_DECL;
    private static final Method BASIC_CONSTR_ASM_M;
    private static final String CONSTR_M_DECL;
    private static final Method CONSTR_ASM_M;
    private static final String GET_INDEX_M_DECL;
    private static final Method GET_INDEX_M_ASM_M;
    private static final String NEW_INSTANCE_M_DECL;
    private static final Method NEW_INSTANCE_ASM_M;
    private static final Type[] EXCEPTIONS;
    static /* synthetic */ Class class$de$vw$mib$reflection$ConstructorAccessibleObject;
    static /* synthetic */ Class class$de$vw$mib$reflection$impl$ca$ConstructorAccessibleGenerator;

    public static void validate(String string, ClassLoader classLoader) {
        try {
            Class clazz = classLoader.loadClass(string);
            Constructor[] constructorArray = clazz.getConstructors();
            IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(constructorArray.length);
            for (int i2 = 0; i2 < constructorArray.length; ++i2) {
                Class[] classArray = constructorArray[i2].getParameterTypes();
                int n = ConstructorAccessibleGenerator.buildKey(classArray);
                if (intObjectOptHashMap.containsKey(n)) {
                    if (intObjectOptHashMap.get(n).equals(classArray)) continue;
                    ConstructorAccessibleGenerator.throwHashCodeDuplicatedException(clazz, (Class[])intObjectOptHashMap.get(n), classArray);
                    continue;
                }
                intObjectOptHashMap.put(n, classArray);
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new LightReflectionException(classNotFoundException);
        }
    }

    public static LightReflectionClassData create(String string, String string2) {
        ClassLoader classLoader = ConstructorAccessibleGenerator.getClassLoader(class$de$vw$mib$reflection$impl$ca$ConstructorAccessibleGenerator == null ? (class$de$vw$mib$reflection$impl$ca$ConstructorAccessibleGenerator = ConstructorAccessibleGenerator.class$("de.vw.mib.reflection.impl.ca.ConstructorAccessibleGenerator")) : class$de$vw$mib$reflection$impl$ca$ConstructorAccessibleGenerator);
        return ConstructorAccessibleGenerator.create(string, string2, classLoader);
    }

    public static LightReflectionClassData create(String string, String string2, ClassLoader classLoader) {
        try {
            int n = ConstructorAccessibleGenerator.buildKey(string2);
            String string3 = ConstructorAccessibleGenerator.createFullPackageName(string);
            String string4 = ConstructorAccessibleGenerator.createClassName(GA, n, string3, classLoader);
            String string5 = string4.substring(string4.lastIndexOf(".") + 1);
            byte[] byArray = ConstructorAccessibleGenerator.generateClassBytecode(string4, string2, classLoader);
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
        return new StringBuffer().append(string).append("ca").toString();
    }

    private static byte[] generateClassBytecode(String string, String string2, ClassLoader classLoader) {
        Class clazz = classLoader.loadClass(string2);
        Constructor[] constructorArray = clazz.getConstructors();
        int[] nArray = new int[constructorArray.length];
        for (int i2 = 0; i2 < constructorArray.length; ++i2) {
            Constructor constructor = constructorArray[i2];
            nArray[i2] = ConstructorAccessibleGenerator.buildKey(constructor.getParameterTypes());
        }
        int[] nArray2 = new int[constructorArray.length];
        int n = 0;
        for (int i3 = 0; i3 < constructorArray.length; ++i3) {
            nArray2[n] = n;
            ++n;
        }
        ClassWriter classWriter = new ClassWriter(1);
        String string3 = string.replace('.', '/');
        classWriter.visit(48, 17, string3, null, BASIC_CL_NAME, null);
        ConstructorAccessibleGenerator.addConstructor(classWriter);
        ConstructorAccessibleGenerator.addGetIndex(classWriter, nArray);
        ConstructorAccessibleGenerator.addNewInstanceMethod(classWriter, nArray2, clazz, constructorArray);
        return classWriter.toByteArray();
    }

    private static void addConstructor(ClassWriter classWriter) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, CONSTR_ASM_M, null, null, (ClassVisitor)classWriter);
        generatorAdapter.loadThis();
        generatorAdapter.invokeConstructor(BASIC_T, BASIC_CONSTR_ASM_M);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();
    }

    private static void addGetIndex(ClassWriter classWriter, int[] nArray) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, GET_INDEX_M_ASM_M, null, null, (ClassVisitor)classWriter);
        generatorAdapter.loadArg(0);
        generatorAdapter.invokeStatic(RU_ASM_T, RU_BUILD_KEY_CLASS_A_ASM_M);
        int[] nArray2 = (int[])nArray.clone();
        Arrays.sort(nArray2);
        int[] nArray3 = new int[nArray2.length];
        block0: for (int i2 = 0; i2 < nArray2.length; ++i2) {
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (nArray2[i2] != nArray[i3]) continue;
                nArray3[i2] = i3;
                continue block0;
            }
        }
        IndexSwitchGenerator indexSwitchGenerator = new IndexSwitchGenerator(nArray2, nArray3, generatorAdapter);
        generatorAdapter.tableSwitch(nArray2, (TableSwitchGenerator)indexSwitchGenerator);
        generatorAdapter.endMethod();
    }

    private static void addNewInstanceMethod(ClassWriter classWriter, int[] nArray, Class clazz, Constructor[] constructorArray) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, NEW_INSTANCE_ASM_M, null, EXCEPTIONS, (ClassVisitor)classWriter);
        Label label = generatorAdapter.newLabel();
        Label label2 = generatorAdapter.newLabel();
        generatorAdapter.mark(label);
        generatorAdapter.loadArg(0);
        Type type = Type.getType((Class)clazz);
        NewInstanceSwitchGenerator newInstanceSwitchGenerator = new NewInstanceSwitchGenerator(type, constructorArray, generatorAdapter);
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

    private ConstructorAccessibleGenerator() {
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
        GET_INDEX_M_ASM_M = Method.getMethod((String)"int getIndex(Class[])");
        NEW_INSTANCE_ASM_M = Method.getMethod((String)"Object newInstance( int, Object[] )");
        EXCEPTIONS = new Type[]{INV_T_EXC_ASM_T};
    }
}

