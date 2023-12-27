/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.vw.mib.asl.framework.internal.framework.build.AsmUtil
 *  de.vw.mib.asl.framework.internal.framework.build.CommonUtil
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
import de.vw.mib.asl.framework.internal.framework.dsi.util.CompileGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler;
import de.vw.mib.asl.framework.internal.framework.reflection.build.LogUtils;
import de.vw.mib.asl.framework.internal.framework.reflection.util.Constants;
import de.vw.mib.reflection.MultipleConstructorAccessibleObject;
import java.io.File;
import java.util.HashSet;
import java.util.Properties;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

public final class DSIReflectionCompiler
extends Compiler
implements CompileGeneratedConstants {
    private static final int ARGIDX_OUTPUT_DIR;
    private static final String SERVICES_PS_PRE_CN;
    private static final String SERVICES_MMAOS_PRE_CN;
    private static final String LISTENERS_PS_PRE_CN;
    private static final String LISTENERS_MMAOS_PRE_CN;
    private static final String SYNC_CMP_ANALYZERS_MCAO_CN_PN;
    private static final String FACTORY_MCAO_CN_FN;
    private static final String SERVICES_PS_IDS_FN;
    private static final String SERVICES_MMAOS_IDS_FN;
    private static final String LISTENERS_PS_IDS_FN;
    private static final String LISTENERS_MMAOS_IDS_FN;
    private static final String SYNC_CMP_ANALYZERS_MCAO_ID_FN;
    private static final int DSI_R_F_CC_ALL_F_L;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler;
    static /* synthetic */ Class class$java$lang$Object;

    public static void main(String[] stringArray) {
        try {
            String string = DSIReflectionCompiler.readArg(stringArray, 0);
            File file = string == null || string.equals("") ? new File((class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler == null ? (class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler = DSIReflectionCompiler.class$("de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler")) : class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler).getProtectionDomain().getCodeSource().getLocation().getFile()) : new File(string);
            File file2 = new File(file, "de.vw.mib.asl.framework.internal.dsiproxy.lr".replace('.', File.separatorChar));
            CommonUtil.mkdirs((File)file2);
            DSIReflectionCompiler.compile(file);
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

    public static void compile(File file) {
        try {
            String string = "de.vw.mib.asl.framework.internal.dsiproxy.lr.DSIRFCC";
            String string2 = string.replace('.', '/');
            Type type = Type.getType((String)new StringBuffer().append("L").append(string2).append(";").toString());
            ClassWriter classWriter = new ClassWriter(1);
            classWriter.visit(48, 17, string2, null, Type.getType((Class)(class$java$lang$Object == null ? (class$java$lang$Object = DSIReflectionCompiler.class$("java.lang.Object")) : class$java$lang$Object)).getInternalName(), null);
            Method method = Method.getMethod((String)"void <clinit>()");
            GeneratorAdapter generatorAdapter = new GeneratorAdapter(10, method, null, null, (ClassVisitor)classWriter);
            FieldVisitor fieldVisitor = classWriter.visitField(25, "_ZIA", INT_A_TYPE_DESCRIPTOR, null, null);
            fieldVisitor.visitEnd();
            generatorAdapter.push(0);
            generatorAdapter.newArray(INT_TYPE);
            generatorAdapter.putStatic(type, "_ZIA", INT_A_TYPE);
            HashSet hashSet = new HashSet();
            Properties properties = DSIReflectionCompiler.createServicesReflectionClasses("de.vw.mib.asl.framework.internal.dsiproxy.lr", file);
            hashSet.addAll(properties.values());
            Properties properties2 = DSIReflectionCompiler.createListenersReflectionClasses("de.vw.mib.asl.framework.internal.dsiproxy.lr", file);
            hashSet.addAll(properties2.values());
            Properties properties3 = DSIReflectionCompiler.createSyncCmpAnalyzersReflectionClasses("de.vw.mib.asl.framework.internal.dsiproxy.lr", file);
            hashSet.addAll(properties3.values());
            String string3 = DSIReflectionCompiler.createMultipleConstructorAccessibleClass("de.vw.mib.asl.framework.internal.dsiproxy.lr", (String[])hashSet.toArray(new String[0]), file);
            fieldVisitor = classWriter.visitField(25, "C0", STRING_TYPE_DESCRIPTOR, null, null);
            fieldVisitor.visitEnd();
            generatorAdapter.push(string3);
            generatorAdapter.putStatic(type, "C0", STRING_TYPE);
            Class clazz = Class.forName(string3);
            MultipleConstructorAccessibleObject multipleConstructorAccessibleObject = (MultipleConstructorAccessibleObject)clazz.newInstance();
            DSIReflectionCompiler.addServicesIds(classWriter, generatorAdapter, type, multipleConstructorAccessibleObject, properties);
            DSIReflectionCompiler.addListenersIds(classWriter, generatorAdapter, type, multipleConstructorAccessibleObject, properties2);
            DSIReflectionCompiler.addSyncCmpAnalyzersIds(classWriter, generatorAdapter, type, multipleConstructorAccessibleObject, properties3);
            DSIReflectionCompiler.addReflectionFactoryAllCfg(classWriter, generatorAdapter, type);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            byte[] byArray = classWriter.toByteArray();
            AsmUtil.saveClass((File)file, (String)string, (byte[])byArray);
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    private static Properties createServicesReflectionClasses(String string, File file) {
        int n;
        Properties properties = new Properties();
        String string2 = null;
        HashSet hashSet = new HashSet();
        for (n = 0; n < Constants.SERVICE_FULL_C; ++n) {
            hashSet.clear();
            for (int i2 = 0; i2 < 2; ++i2) {
                hashSet.add(RuntimeGeneratedConstants.SERVICE_TS_NS[(n << 1) + i2]);
            }
            string2 = DSIReflectionCompiler.createProxyClass(string, (String[])hashSet.toArray(new String[0]), file);
            properties.setProperty(new StringBuffer().append("a").append(n).toString(), string2);
            string2 = DSIReflectionCompiler.createMultipleMethodAccessibleClass(string, (String[])hashSet.toArray(new String[0]), null, file);
            properties.setProperty(new StringBuffer().append("b").append(n).toString(), string2);
        }
        if (Constants.SERVICE_REMAIN > 0) {
            hashSet.clear();
            for (n = 0; n < Constants.SERVICE_REMAIN; ++n) {
                hashSet.add(RuntimeGeneratedConstants.SERVICE_TS_NS[RuntimeGeneratedConstants.SERVICE_TS_NS.length - Constants.SERVICE_REMAIN + n]);
            }
            string2 = DSIReflectionCompiler.createProxyClass(string, (String[])hashSet.toArray(new String[0]), file);
            properties.setProperty(new StringBuffer().append("a").append(Constants.SERVICE_C - 1).toString(), string2);
            string2 = DSIReflectionCompiler.createMultipleMethodAccessibleClass(string, (String[])hashSet.toArray(new String[0]), null, file);
            properties.setProperty(new StringBuffer().append("b").append(Constants.SERVICE_C - 1).toString(), string2);
        }
        return properties;
    }

    private static void addServicesIds(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, MultipleConstructorAccessibleObject multipleConstructorAccessibleObject, Properties properties) {
        int[] nArray = new int[Constants.SERVICE_C];
        int[] nArray2 = new int[Constants.SERVICE_C];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = multipleConstructorAccessibleObject.getIndex(properties.getProperty(new StringBuffer().append("a").append(i2).toString()));
            nArray2[i2] = multipleConstructorAccessibleObject.getIndex(properties.getProperty(new StringBuffer().append("b").append(i2).toString()));
        }
        FieldVisitor fieldVisitor = classWriter.visitField(25, "C1", INT_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        DSIReflectionCompiler.push(generatorAdapter, type, nArray);
        generatorAdapter.putStatic(type, "C1", INT_A_TYPE);
        fieldVisitor = classWriter.visitField(25, "C2", INT_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        DSIReflectionCompiler.push(generatorAdapter, type, nArray2);
        generatorAdapter.putStatic(type, "C2", INT_A_TYPE);
    }

    private static Properties createListenersReflectionClasses(String string, File file) {
        int n;
        Properties properties = new Properties();
        String string2 = null;
        HashSet hashSet = new HashSet();
        for (n = 0; n < Constants.LISTENER_FULL_C; ++n) {
            hashSet.clear();
            for (int i2 = 0; i2 < 2; ++i2) {
                hashSet.add(RuntimeGeneratedConstants.LISTENER_TS_NS[(n << 1) + i2]);
            }
            string2 = DSIReflectionCompiler.createProxyClass(string, (String[])hashSet.toArray(new String[0]), file);
            properties.setProperty(new StringBuffer().append("c").append(n).toString(), string2);
            string2 = DSIReflectionCompiler.createMultipleMethodAccessibleClass(string, (String[])hashSet.toArray(new String[0]), null, file);
            properties.setProperty(new StringBuffer().append("d").append(n).toString(), string2);
        }
        if (Constants.LISTENER_REMAIN > 0) {
            hashSet.clear();
            for (n = 0; n < Constants.LISTENER_REMAIN; ++n) {
                hashSet.add(RuntimeGeneratedConstants.LISTENER_TS_NS[RuntimeGeneratedConstants.LISTENER_TS_NS.length - Constants.LISTENER_REMAIN + n]);
            }
            string2 = DSIReflectionCompiler.createProxyClass(string, (String[])hashSet.toArray(new String[0]), file);
            properties.setProperty(new StringBuffer().append("c").append(Constants.LISTENER_C - 1).toString(), string2);
            string2 = DSIReflectionCompiler.createMultipleMethodAccessibleClass(string, (String[])hashSet.toArray(new String[0]), null, file);
            properties.setProperty(new StringBuffer().append("d").append(Constants.LISTENER_C - 1).toString(), string2);
        }
        return properties;
    }

    private static void addListenersIds(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, MultipleConstructorAccessibleObject multipleConstructorAccessibleObject, Properties properties) {
        int[] nArray = new int[Constants.LISTENER_C];
        int[] nArray2 = new int[Constants.LISTENER_C];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = multipleConstructorAccessibleObject.getIndex(properties.getProperty(new StringBuffer().append("c").append(i2).toString()));
            nArray2[i2] = multipleConstructorAccessibleObject.getIndex(properties.getProperty(new StringBuffer().append("d").append(i2).toString()));
        }
        FieldVisitor fieldVisitor = classWriter.visitField(25, "C3", INT_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        DSIReflectionCompiler.push(generatorAdapter, type, nArray);
        generatorAdapter.putStatic(type, "C3", INT_A_TYPE);
        fieldVisitor = classWriter.visitField(25, "C4", INT_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        DSIReflectionCompiler.push(generatorAdapter, type, nArray2);
        generatorAdapter.putStatic(type, "C4", INT_A_TYPE);
    }

    private static Properties createSyncCmpAnalyzersReflectionClasses(String string, File file) {
        Properties properties = new Properties();
        String string2 = null;
        HashSet hashSet = new HashSet(SYNC_CMP_ANALYZER_TS.length);
        for (int i2 = 0; i2 < SYNC_CMP_ANALYZER_TS.length; ++i2) {
            if (SYNC_CMP_ANALYZER_TS[i2] == null) continue;
            hashSet.add(SYNC_CMP_ANALYZER_TS[i2]);
        }
        string2 = DSIReflectionCompiler.createMultipleConstructorAccessibleClass(string, (String[])hashSet.toArray(new String[0]), file);
        properties.setProperty("e", string2);
        return properties;
    }

    private static void addSyncCmpAnalyzersIds(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, MultipleConstructorAccessibleObject multipleConstructorAccessibleObject, Properties properties) {
        int n = multipleConstructorAccessibleObject.getIndex(properties.getProperty("e"));
        FieldVisitor fieldVisitor = classWriter.visitField(25, "C5", INT_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        generatorAdapter.push(n);
        generatorAdapter.putStatic(type, "C5", INT_TYPE);
    }

    private static void addReflectionFactoryAllCfg(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, "CFG", OBJ_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        generatorAdapter.push(6);
        generatorAdapter.newArray(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(0);
        generatorAdapter.getStatic(type, "C0", STRING_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(1);
        generatorAdapter.getStatic(type, "C1", INT_A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(2);
        generatorAdapter.getStatic(type, "C2", INT_A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(3);
        generatorAdapter.getStatic(type, "C3", INT_A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(4);
        generatorAdapter.getStatic(type, "C4", INT_A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(5);
        generatorAdapter.getStatic(type, "C5", INT_TYPE);
        generatorAdapter.box(INT_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.putStatic(type, "CFG", OBJ_A_TYPE);
    }

    private DSIReflectionCompiler() {
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

