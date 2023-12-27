/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.vw.mib.asl.framework.internal.framework.build.AsmUtil
 *  de.vw.mib.asl.framework.internal.framework.build.CommonUtil
 *  org.apache.bcel.classfile.JavaClass
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.FieldVisitor
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.commons.GeneratorAdapter
 *  org.objectweb.asm.commons.Method
 */
package de.vw.mib.asl.framework.internal.framework.reflection.build;

import de.vw.mib.asl.framework.internal.framework.build.AsmUtil;
import de.vw.mib.asl.framework.internal.framework.build.CommonUtil;
import de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler;
import de.vw.mib.asl.framework.internal.framework.reflection.build.LogUtils;
import de.vw.mib.reflection.MultipleConstructorAccessibleObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import org.apache.bcel.classfile.JavaClass;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

public final class ModuleReflectionCompiler
extends Compiler {
    private static final int VERSION;
    private static final int ARGIDX_OUTPUT_DIR;
    private static final int ARGIDX_TARGET_PACKAGE;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler;
    static /* synthetic */ Class class$java$lang$Object;
    static /* synthetic */ Class class$de$vw$mib$genericevents$Target;
    static /* synthetic */ Class class$de$vw$mib$genericevents$hsm$AbstractHsmState;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$framework$reflection$MethodAccessible;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$framework$AbstractASLTarget;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$framework$AbstractASLHsmTarget;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$list$ASLListElementFetcher;

    public static void main(String[] stringArray) {
        try {
            String string = ModuleReflectionCompiler.readArg(stringArray, 0);
            if (string == null || string.equals("")) {
                string = new StringBuffer().append(new File((class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler == null ? (class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler = ModuleReflectionCompiler.class$("de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler")) : class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler).getProtectionDomain().getCodeSource().getLocation().getFile()).getAbsolutePath()).append(File.separator).toString();
            } else if (!string.endsWith(File.separator)) {
                string = new StringBuffer().append(string).append(File.separator).toString();
            }
            String string2 = ModuleReflectionCompiler.readArg(stringArray, 1);
            if (string2 == null || string2.equals("")) {
                throw new RuntimeException("Could not execute module reflection compiler. The target package name was not set. ");
            }
            File file = new File(string);
            File file2 = new File(file, string2.replace('.', File.separatorChar));
            CommonUtil.mkdirs((File)file2);
            ModuleReflectionCompiler.compile(file, string2);
        }
        catch (RuntimeException runtimeException) {
            LogUtils.logError(runtimeException);
            throw runtimeException;
        }
        catch (Throwable throwable) {
            LogUtils.logError(throwable);
            throw new RuntimeException(throwable);
        }
    }

    public static void compile(File file, String string) {
        try {
            String string2 = new StringBuffer().append(string).append(".").append("MRFCC").toString();
            String string3 = string2.replace('.', '/');
            Type type = Type.getType((String)new StringBuffer().append("L").append(string3).append(";").toString());
            ClassWriter classWriter = new ClassWriter(1);
            classWriter.visit(48, 17, string3, null, Type.getType((Class)(class$java$lang$Object == null ? (class$java$lang$Object = ModuleReflectionCompiler.class$("java.lang.Object")) : class$java$lang$Object)).getInternalName(), null);
            Method method = Method.getMethod((String)"void <clinit>()");
            GeneratorAdapter generatorAdapter = new GeneratorAdapter(10, method, null, null, (ClassVisitor)classWriter);
            FieldVisitor fieldVisitor = classWriter.visitField(25, "_ZIA", INT_A_TYPE_DESCRIPTOR, null, null);
            fieldVisitor.visitEnd();
            generatorAdapter.push(0);
            generatorAdapter.newArray(INT_TYPE);
            generatorAdapter.putStatic(type, "_ZIA", INT_A_TYPE);
            fieldVisitor = classWriter.visitField(25, "_ZSA", STRING_A_TYPE_DESCRIPTOR, null, null);
            fieldVisitor.visitEnd();
            generatorAdapter.push(0);
            generatorAdapter.newArray(STRING_TYPE);
            generatorAdapter.putStatic(type, "_ZSA", STRING_A_TYPE);
            fieldVisitor = classWriter.visitField(25, "VERSION", INT_TYPE_DESCRIPTOR, null, null);
            fieldVisitor.visitEnd();
            generatorAdapter.push(1);
            generatorAdapter.putStatic(type, "VERSION", INT_TYPE);
            HashSet hashSet = new HashSet();
            JavaClass[] javaClassArray = ModuleReflectionCompiler.retrieveDerivedClasses(file, (class$de$vw$mib$genericevents$Target == null ? (class$de$vw$mib$genericevents$Target = ModuleReflectionCompiler.class$("de.vw.mib.genericevents.Target")) : class$de$vw$mib$genericevents$Target).getName());
            Object[] objectArray = new String[javaClassArray.length];
            for (int i2 = 0; i2 < javaClassArray.length; ++i2) {
                objectArray[i2] = javaClassArray[i2].getClassName();
            }
            Arrays.sort(objectArray);
            String string4 = ModuleReflectionCompiler.createTargetsMmao(string, file, (String[])objectArray);
            hashSet.add(string4);
            JavaClass[] javaClassArray2 = ModuleReflectionCompiler.retrieveDerivedClasses(file, (class$de$vw$mib$genericevents$hsm$AbstractHsmState == null ? (class$de$vw$mib$genericevents$hsm$AbstractHsmState = ModuleReflectionCompiler.class$("de.vw.mib.genericevents.hsm.AbstractHsmState")) : class$de$vw$mib$genericevents$hsm$AbstractHsmState).getName());
            Object[] objectArray2 = new String[javaClassArray2.length];
            for (int i3 = 0; i3 < javaClassArray2.length; ++i3) {
                objectArray2[i3] = javaClassArray2[i3].getClassName();
            }
            Arrays.sort(objectArray2);
            String string5 = ModuleReflectionCompiler.createHsmStatesMmao(string, file, (String[])objectArray2);
            hashSet.add(string5);
            ArrayList arrayList = new ArrayList();
            arrayList.add((class$de$vw$mib$asl$framework$api$framework$reflection$MethodAccessible == null ? (class$de$vw$mib$asl$framework$api$framework$reflection$MethodAccessible = ModuleReflectionCompiler.class$("de.vw.mib.asl.framework.api.framework.reflection.MethodAccessible")) : class$de$vw$mib$asl$framework$api$framework$reflection$MethodAccessible).getName());
            Map map = ModuleReflectionCompiler.retrieveDerivedClasses(file, arrayList);
            JavaClass[] javaClassArray3 = (JavaClass[])map.get((class$de$vw$mib$asl$framework$api$framework$reflection$MethodAccessible == null ? (class$de$vw$mib$asl$framework$api$framework$reflection$MethodAccessible = ModuleReflectionCompiler.class$("de.vw.mib.asl.framework.api.framework.reflection.MethodAccessible")) : class$de$vw$mib$asl$framework$api$framework$reflection$MethodAccessible).getName());
            Object[] objectArray3 = new String[javaClassArray3.length];
            for (int i4 = 0; i4 < javaClassArray3.length; ++i4) {
                objectArray3[i4] = javaClassArray3[i4].getClassName();
            }
            Arrays.sort(objectArray3);
            Properties properties = ModuleReflectionCompiler.createMaos(string, file, (String[])objectArray3);
            hashSet.addAll(properties.values());
            String string6 = ModuleReflectionCompiler.createMultipleConstructorAccessibleClass(string, (String[])hashSet.toArray(new String[0]), file);
            fieldVisitor = classWriter.visitField(25, "FACTORY", STRING_TYPE_DESCRIPTOR, null, null);
            fieldVisitor.visitEnd();
            generatorAdapter.push(string6);
            generatorAdapter.putStatic(type, "FACTORY", STRING_TYPE);
            Class clazz = Class.forName(string6);
            MultipleConstructorAccessibleObject multipleConstructorAccessibleObject = (MultipleConstructorAccessibleObject)clazz.newInstance();
            ModuleReflectionCompiler.addTargetsMmaoId(classWriter, generatorAdapter, type, multipleConstructorAccessibleObject, string4);
            ModuleReflectionCompiler.addHsmStatesMmaoId(classWriter, generatorAdapter, type, multipleConstructorAccessibleObject, string5);
            ModuleReflectionCompiler.addSupportedTargetsCsNs(classWriter, generatorAdapter, type, (String[])objectArray);
            ModuleReflectionCompiler.addSupportedHsmStatesCsNs(classWriter, generatorAdapter, type, (String[])objectArray2);
            ModuleReflectionCompiler.addMaosIds(classWriter, generatorAdapter, type, multipleConstructorAccessibleObject, (String[])objectArray3, properties);
            ModuleReflectionCompiler.addSupportedMethodAccessibleCsNs(classWriter, generatorAdapter, type, (String[])objectArray3);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            byte[] byArray = classWriter.toByteArray();
            AsmUtil.saveClass((File)file, (String)string2, (byte[])byArray);
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    private static String createTargetsMmao(String string, File file, String[] stringArray) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList((class$de$vw$mib$asl$framework$internal$framework$AbstractASLTarget == null ? (class$de$vw$mib$asl$framework$internal$framework$AbstractASLTarget = ModuleReflectionCompiler.class$("de.vw.mib.asl.framework.internal.framework.AbstractASLTarget")) : class$de$vw$mib$asl$framework$internal$framework$AbstractASLTarget).getMethods()));
        hashSet.addAll(Arrays.asList((class$de$vw$mib$asl$framework$internal$framework$AbstractASLHsmTarget == null ? (class$de$vw$mib$asl$framework$internal$framework$AbstractASLHsmTarget = ModuleReflectionCompiler.class$("de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget")) : class$de$vw$mib$asl$framework$internal$framework$AbstractASLHsmTarget).getMethods()));
        hashSet.addAll(Arrays.asList((class$de$vw$mib$asl$internal$list$ASLListElementFetcher == null ? (class$de$vw$mib$asl$internal$list$ASLListElementFetcher = ModuleReflectionCompiler.class$("de.vw.mib.asl.internal.list.ASLListElementFetcher")) : class$de$vw$mib$asl$internal$list$ASLListElementFetcher).getMethods()));
        return ModuleReflectionCompiler.createMultipleMethodAccessibleClass(string, stringArray, (java.lang.reflect.Method[])hashSet.toArray(new java.lang.reflect.Method[0]), file);
    }

    private static void addTargetsMmaoId(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, MultipleConstructorAccessibleObject multipleConstructorAccessibleObject, String string) {
        int n = multipleConstructorAccessibleObject.getIndex(string);
        FieldVisitor fieldVisitor = classWriter.visitField(25, "TARGETS_MMAO_IDX", INT_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        generatorAdapter.push(n);
        generatorAdapter.putStatic(type, "TARGETS_MMAO_IDX", INT_TYPE);
    }

    private static String createHsmStatesMmao(String string, File file, String[] stringArray) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList((class$de$vw$mib$genericevents$hsm$AbstractHsmState == null ? (class$de$vw$mib$genericevents$hsm$AbstractHsmState = ModuleReflectionCompiler.class$("de.vw.mib.genericevents.hsm.AbstractHsmState")) : class$de$vw$mib$genericevents$hsm$AbstractHsmState).getMethods()));
        return ModuleReflectionCompiler.createMultipleMethodAccessibleClass(string, stringArray, (java.lang.reflect.Method[])hashSet.toArray(new java.lang.reflect.Method[0]), file);
    }

    private static void addHsmStatesMmaoId(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, MultipleConstructorAccessibleObject multipleConstructorAccessibleObject, String string) {
        int n = multipleConstructorAccessibleObject.getIndex(string);
        FieldVisitor fieldVisitor = classWriter.visitField(25, "HSMSTATES_MMAO_IDX", INT_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        generatorAdapter.push(n);
        generatorAdapter.putStatic(type, "HSMSTATES_MMAO_IDX", INT_TYPE);
    }

    private static void addSupportedTargetsCsNs(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, String[] stringArray) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, "TARGETS_NAMES", STRING_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        ModuleReflectionCompiler.push(generatorAdapter, type, stringArray);
        generatorAdapter.putStatic(type, "TARGETS_NAMES", STRING_A_TYPE);
    }

    private static void addSupportedHsmStatesCsNs(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, String[] stringArray) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, "HSMSTATES_NAMES", STRING_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        ModuleReflectionCompiler.push(generatorAdapter, type, stringArray);
        generatorAdapter.putStatic(type, "HSMSTATES_NAMES", STRING_A_TYPE);
    }

    private static Properties createMaos(String string, File file, String[] stringArray) {
        Properties properties = new Properties();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string2 = ModuleReflectionCompiler.createMethodAccessibleClass(string, stringArray[i2], new java.lang.reflect.Method[0], file);
            properties.setProperty(stringArray[i2], string2);
        }
        return properties;
    }

    private static void addMaosIds(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, MultipleConstructorAccessibleObject multipleConstructorAccessibleObject, String[] stringArray, Properties properties) {
        int[] nArray = new int[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            nArray[i2] = multipleConstructorAccessibleObject.getIndex(properties.getProperty(stringArray[i2]));
        }
        FieldVisitor fieldVisitor = classWriter.visitField(25, "MA_MAO_IDS", INT_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        ModuleReflectionCompiler.push(generatorAdapter, type, nArray);
        generatorAdapter.putStatic(type, "MA_MAO_IDS", INT_A_TYPE);
    }

    private static void addSupportedMethodAccessibleCsNs(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, String[] stringArray) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, "MA_NAMES", STRING_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        ModuleReflectionCompiler.push(generatorAdapter, type, stringArray);
        generatorAdapter.putStatic(type, "MA_NAMES", STRING_A_TYPE);
    }

    private ModuleReflectionCompiler() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

