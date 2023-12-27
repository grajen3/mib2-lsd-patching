/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.FieldVisitor
 *  org.objectweb.asm.Label
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.commons.GeneratorAdapter
 *  org.objectweb.asm.commons.Method
 */
package de.vw.mib.reflection.impl.proxy;

import de.vw.mib.reflection.LightReflectionClassData;
import de.vw.mib.reflection.LightReflectionException;
import de.vw.mib.reflection.impl.ClassGenerator;
import de.vw.mib.reflection.impl.GeneratorArea;
import de.vw.mib.reflection.impl.ma.MethodAccessibleGenerator;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

public final class ProxyGenerator
extends ClassGenerator {
    private static final GeneratorArea GA = GeneratorArea.PROXY_J_AREA;
    private static final Class BASIC_CL = class$de$vw$mib$reflection$AbstractProxy == null ? (class$de$vw$mib$reflection$AbstractProxy = ProxyGenerator.class$("de.vw.mib.reflection.AbstractProxy")) : class$de$vw$mib$reflection$AbstractProxy;
    private static final String BASIC_CL_NAME = BASIC_CL.getName().replace('.', '/');
    private static final Type BASIC_T = Type.getType((Class)BASIC_CL);
    private static final String SUB_PACKAGE;
    private static final String J_MS_CONST_NAME;
    private static final String J_MS_D;
    private static final String ZOA_CONST_NAME;
    private static final String ZOA_D;
    private static final String CL_INIT_M_DECL;
    private static final Method CL_INIT_ASM_M;
    private static final String GET_J_METHOD_M_DECL;
    private static final Method GET_J_METHOD_ASM_M;
    private static final String P_FIELD_NAME;
    private static final Type P_FIELD_ASM_T;
    private static final String P_FIELD_D;
    private static final String P_BORROW_M_DECL;
    private static final Method P_BORROW_ASM_M;
    private static final String H_FIELD_NAME;
    private static final Type H_FIELD_ASM_T;
    private static final String H_FIELD_D;
    private static final String H_INVOKE_M_DECL;
    private static final Method H_INVOKE_ASM_M;
    private static final String BASIC_CONSTR_M_DECL;
    private static final Method BASIC_CONSTR_ASM_M;
    private static final String CONSTR_M_DECL;
    private static final Method CONSTR_ASM_M;
    private static final Type UNDECL_THR_EXC_ASM_T;
    private static final Method UNDECL_THR_EXC_CONSTR_ASM_M;
    private static final int AJMM_S_ID;
    private static final int AJMM_S_T_IDX;
    private static final int AJMM_S_MMAO_IDX;
    static /* synthetic */ Class class$de$vw$mib$reflection$AbstractProxy;
    static /* synthetic */ Class class$de$vw$mib$reflection$impl$mma$MultipleMethodAccessibleGenerator;
    static /* synthetic */ Class class$de$vw$mib$reflection$impl$proxy$ProxyGenerator;

    public static void validate(String[] stringArray) {
        ClassLoader classLoader = ProxyGenerator.getClassLoader(class$de$vw$mib$reflection$impl$mma$MultipleMethodAccessibleGenerator == null ? (class$de$vw$mib$reflection$impl$mma$MultipleMethodAccessibleGenerator = ProxyGenerator.class$("de.vw.mib.reflection.impl.mma.MultipleMethodAccessibleGenerator")) : class$de$vw$mib$reflection$impl$mma$MultipleMethodAccessibleGenerator);
        ProxyGenerator.validate(stringArray, classLoader);
    }

    public static void validate(String[] stringArray, ClassLoader classLoader) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            MethodAccessibleGenerator.validate(stringArray[i2], null, classLoader);
        }
    }

    public static LightReflectionClassData create(String string, String[] stringArray) {
        ClassLoader classLoader = ProxyGenerator.getClassLoader(class$de$vw$mib$reflection$impl$proxy$ProxyGenerator == null ? (class$de$vw$mib$reflection$impl$proxy$ProxyGenerator = ProxyGenerator.class$("de.vw.mib.reflection.impl.proxy.ProxyGenerator")) : class$de$vw$mib$reflection$impl$proxy$ProxyGenerator);
        return ProxyGenerator.create(string, stringArray, classLoader);
    }

    public static LightReflectionClassData create(String string, String[] stringArray, ClassLoader classLoader) {
        try {
            int n = ProxyGenerator.buildKey(stringArray);
            String string2 = ProxyGenerator.createFullPackageName(string);
            String string3 = ProxyGenerator.createClassName(GA, n, string2, classLoader);
            String string4 = string3.substring(string3.lastIndexOf(".") + 1);
            byte[] byArray = ProxyGenerator.generateClassBytecode(string3, stringArray, classLoader);
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
        return new StringBuffer().append(string).append("proxy").toString();
    }

    private static byte[] generateClassBytecode(String string, String[] stringArray, ClassLoader classLoader) {
        int n;
        FieldVisitor fieldVisitor;
        Object object;
        FieldVisitor fieldVisitor2;
        FieldVisitor fieldVisitor3;
        Object object2;
        Object object3;
        int n2;
        String[] stringArray2 = new String[stringArray.length];
        java.lang.reflect.Method[] methodArray = new java.lang.reflect.Method[]{};
        Method[] methodArray2 = new Method[]{};
        int[][] nArrayArray = new int[][]{};
        Method[] methodArray3 = new Method[]{};
        int n3 = 0;
        for (n2 = 0; n2 < stringArray.length; ++n2) {
            Method[] methodArray4;
            object3 = classLoader.loadClass(stringArray[n2]);
            stringArray2[n2] = Type.getInternalName((Class)object3);
            object2 = ((Class)object3).getMethods();
            int n4 = ((java.lang.reflect.Method[])object2).length;
            fieldVisitor3 = new java.lang.reflect.Method[n4];
            fieldVisitor2 = new Method[n4];
            object = new int[n4][];
            fieldVisitor = new Method[n4];
            n = 0;
            int n5 = 0;
            for (int i2 = 0; i2 < n4; ++i2) {
                methodArray4 = Method.getMethod((java.lang.reflect.Method)object2[i2]);
                if (!ProxyGenerator.contains((Method)methodArray4, methodArray2)) {
                    fieldVisitor3[n] = object2[i2];
                    fieldVisitor2[n] = methodArray4;
                    object[n] = new int[]{n3, n2, n3};
                    ++n;
                } else if (!ProxyGenerator.contains((Method)methodArray4, methodArray3)) {
                    fieldVisitor[n5] = methodArray4;
                    ++n5;
                }
                ++n3;
            }
            if (n > 0) {
                java.lang.reflect.Method[] methodArray5 = new java.lang.reflect.Method[methodArray.length + n];
                System.arraycopy((Object)methodArray, 0, (Object)methodArray5, 0, methodArray.length);
                System.arraycopy(fieldVisitor3, 0, (Object)methodArray5, methodArray.length, n);
                methodArray = methodArray5;
                methodArray4 = new Method[methodArray2.length + n];
                System.arraycopy((Object)methodArray2, 0, (Object)methodArray4, 0, methodArray2.length);
                System.arraycopy(fieldVisitor2, 0, (Object)methodArray4, methodArray2.length, n);
                methodArray2 = methodArray4;
                int[][] nArrayArray2 = new int[nArrayArray.length + n][];
                System.arraycopy(nArrayArray, 0, nArrayArray2, 0, nArrayArray.length);
                System.arraycopy(object, 0, nArrayArray2, nArrayArray.length, n);
                nArrayArray = nArrayArray2;
            }
            if (n5 <= 0) continue;
            Method[] methodArray6 = new Method[methodArray3.length + n5];
            System.arraycopy((Object)methodArray3, 0, (Object)methodArray6, 0, methodArray3.length);
            System.arraycopy(fieldVisitor, 0, (Object)methodArray6, methodArray3.length, n5);
            methodArray3 = methodArray6;
        }
        for (n2 = 0; n2 < methodArray2.length; ++n2) {
            if (!ProxyGenerator.contains(methodArray2[n2], methodArray3)) continue;
            nArrayArray[n2] = new int[]{nArrayArray[n2][0], nArrayArray[n2][1], -1};
        }
        ClassWriter classWriter = new ClassWriter(1);
        object3 = string.replace('.', '/');
        object2 = new StringBuffer(string.length() + 2);
        ((StringBuffer)object2).append("L").append((String)object3).append(";");
        Type type = Type.getType((String)((StringBuffer)object2).toString());
        classWriter.visit(48, 17, (String)object3, null, BASIC_CL_NAME, stringArray2);
        fieldVisitor3 = classWriter.visitField(26, "JMS", J_MS_D, null, null);
        fieldVisitor3.visitEnd();
        fieldVisitor2 = classWriter.visitField(26, "ZOA", ZOA_D, null, null);
        fieldVisitor2.visitEnd();
        ProxyGenerator.addClassInitialize(classWriter, type, n3);
        ProxyGenerator.addGetJavaMethod(classWriter, type);
        object = classWriter.visitField(18, "p", P_FIELD_D, null, null);
        object.visitEnd();
        fieldVisitor = classWriter.visitField(18, "h", H_FIELD_D, null, null);
        fieldVisitor.visitEnd();
        ProxyGenerator.addConstructor(classWriter, type);
        for (n = 0; n < methodArray2.length; ++n) {
            ProxyGenerator.addMethod(classWriter, type, methodArray2[n], methodArray[n], stringArray[nArrayArray[n][1]], nArrayArray[n]);
        }
        return classWriter.toByteArray();
    }

    private static void addClassInitialize(ClassWriter classWriter, Type type, int n) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(8, CL_INIT_ASM_M, null, null, (ClassVisitor)classWriter);
        generatorAdapter.push(n);
        generatorAdapter.newArray(J_METHOD_ASM_T);
        generatorAdapter.putStatic(type, "JMS", J_METHOD_A_ASM_T);
        generatorAdapter.push(0);
        generatorAdapter.newArray(OBJ_ASM_T);
        generatorAdapter.putStatic(type, "ZOA", OBJ_A_ASM_T);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();
    }

    private static void addGetJavaMethod(ClassWriter classWriter, Type type) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(10, GET_J_METHOD_ASM_M, null, null, (ClassVisitor)classWriter);
        generatorAdapter.loadArg(0);
        generatorAdapter.getStatic(type, "JMS", J_METHOD_A_ASM_T);
        generatorAdapter.loadArg(1);
        generatorAdapter.loadArg(2);
        generatorAdapter.loadArg(3);
        generatorAdapter.invokeStatic(RU_ASM_T, RU_G_M_ASM_M);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();
    }

    private static void addConstructor(ClassWriter classWriter, Type type) {
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, CONSTR_ASM_M, null, null, (ClassVisitor)classWriter);
        generatorAdapter.loadThis();
        generatorAdapter.invokeConstructor(BASIC_T, BASIC_CONSTR_ASM_M);
        generatorAdapter.loadThis();
        generatorAdapter.loadArg(0);
        generatorAdapter.putField(type, "p", P_FIELD_ASM_T);
        generatorAdapter.loadThis();
        generatorAdapter.loadArg(1);
        generatorAdapter.putField(type, "h", H_FIELD_ASM_T);
        generatorAdapter.returnValue();
        generatorAdapter.endMethod();
    }

    private static void addMethod(ClassWriter classWriter, Type type, Method method, java.lang.reflect.Method method2, String string, int[] nArray) {
        int n;
        boolean bl = true;
        boolean bl2 = true;
        Class[] classArray = method2.getExceptionTypes();
        Type[] typeArray = new Type[classArray.length];
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            typeArray[i2] = Type.getType((Class)classArray[i2]);
            bl = bl && !typeArray[i2].equals((Object)RT_EXC_ASM_T);
            bl2 = bl2 && !typeArray[i2].equals((Object)THR_ASM_T);
        }
        GeneratorAdapter generatorAdapter = new GeneratorAdapter(1, method, null, typeArray, (ClassVisitor)classWriter);
        Label label = generatorAdapter.newLabel();
        Label label2 = generatorAdapter.newLabel();
        generatorAdapter.mark(label);
        generatorAdapter.loadThis();
        generatorAdapter.getField(type, "h", H_FIELD_ASM_T);
        generatorAdapter.loadThis();
        generatorAdapter.push(nArray[0]);
        generatorAdapter.push(string);
        generatorAdapter.push(ProxyGenerator.buildKey(method2.getName()));
        generatorAdapter.push(ProxyGenerator.buildKey(method2.getParameterTypes()));
        generatorAdapter.invokeStatic(type, GET_J_METHOD_ASM_M);
        generatorAdapter.push(nArray[2]);
        Type[] typeArray2 = method.getArgumentTypes();
        if (typeArray2.length == 0) {
            generatorAdapter.getStatic(type, "ZOA", OBJ_A_ASM_T);
        } else {
            generatorAdapter.loadThis();
            generatorAdapter.getField(type, "p", P_FIELD_ASM_T);
            generatorAdapter.push(typeArray2.length);
            generatorAdapter.invokeVirtual(P_FIELD_ASM_T, P_BORROW_ASM_M);
            for (int i3 = 0; i3 < typeArray2.length; ++i3) {
                generatorAdapter.dup();
                generatorAdapter.push(i3);
                generatorAdapter.loadArg(i3);
                ProxyGenerator.box(typeArray2[i3], generatorAdapter);
                generatorAdapter.arrayStore(OBJ_ASM_T);
            }
        }
        generatorAdapter.invokeVirtual(H_FIELD_ASM_T, H_INVOKE_ASM_M);
        Type type2 = method.getReturnType();
        if (type2.getSort() != 0) {
            generatorAdapter.unbox(type2);
        } else {
            generatorAdapter.pop();
        }
        generatorAdapter.mark(label2);
        generatorAdapter.returnValue();
        for (n = 0; n < typeArray.length; ++n) {
            generatorAdapter.catchException(label, label2, typeArray[n]);
            generatorAdapter.throwException();
        }
        if (bl) {
            generatorAdapter.catchException(label, label2, RT_EXC_ASM_T);
            generatorAdapter.throwException();
        }
        if (bl2) {
            generatorAdapter.catchException(label, label2, THR_ASM_T);
            n = generatorAdapter.newLocal(THR_ASM_T);
            generatorAdapter.storeLocal(n);
            generatorAdapter.newInstance(UNDECL_THR_EXC_ASM_T);
            generatorAdapter.dup();
            generatorAdapter.loadLocal(n);
            generatorAdapter.invokeConstructor(UNDECL_THR_EXC_ASM_T, UNDECL_THR_EXC_CONSTR_ASM_M);
            generatorAdapter.throwException();
        }
        generatorAdapter.endMethod();
    }

    private ProxyGenerator() {
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
        J_MS_D = J_METHOD_A_ASM_T_D;
        ZOA_D = OBJ_A_ASM_T_D;
        CL_INIT_ASM_M = Method.getMethod((String)"void <clinit>()");
        GET_J_METHOD_ASM_M = Method.getMethod((String)"java.lang.reflect.Method gjm ( int, String, int, int )");
        P_FIELD_ASM_T = Type.getType((String)"Lde/vw/mib/reflection/pool/ObjArrayPool;");
        P_FIELD_D = P_FIELD_ASM_T.getDescriptor();
        P_BORROW_ASM_M = Method.getMethod((String)"Object[] borrowArray ( int )");
        H_FIELD_ASM_T = Type.getType((String)"Lde/vw/mib/reflection/InvocationHandler;");
        H_FIELD_D = H_FIELD_ASM_T.getDescriptor();
        H_INVOKE_ASM_M = Method.getMethod((String)"Object invoke ( Object, java.lang.reflect.Method, int, Object[] )");
        BASIC_CONSTR_ASM_M = Method.getMethod((String)"void <init>()");
        CONSTR_ASM_M = Method.getMethod((String)"void <init> ( de.vw.mib.reflection.pool.ObjArrayPool, de.vw.mib.reflection.InvocationHandler )");
        UNDECL_THR_EXC_ASM_T = Type.getType((String)"Ljava/lang/reflect/UndeclaredThrowableException;");
        UNDECL_THR_EXC_CONSTR_ASM_M = new Method("<init>", "(Ljava/lang/Throwable;)V");
    }
}

