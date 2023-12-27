/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.vw.mib.asl.framework.internal.framework.build.AsmUtil
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.FieldVisitor
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.commons.GeneratorAdapter
 *  org.objectweb.asm.commons.Method
 */
package de.vw.mib.asl.framework.internal.framework.dsi.build;

import de.vw.mib.asl.framework.internal.framework.build.AsmUtil;
import de.vw.mib.asl.framework.internal.framework.dsi.build.DSIProxyConfigurationCompiler;
import de.vw.mib.asl.framework.internal.framework.dsi.util.CompileGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionFactory;
import java.io.File;
import java.util.Arrays;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

public final class UtilsCompiler
extends DSIProxyConfigurationCompiler {
    private static final String SERVICES_SYNC_MS_NS_FN;
    private static final String LISTENERS_SYNC_MS_NS_FN;
    private static final int U_CC_ALL_F_L;
    static /* synthetic */ Class class$java$lang$Object;

    public static void compile(File file, String string, DSIReflectionFactory dSIReflectionFactory) {
        try {
            String string2 = new StringBuffer().append(string).append(".").append("UCC").toString();
            String string3 = string2.replace('.', '/');
            Type type = Type.getType((String)new StringBuffer().append("L").append(string3).append(";").toString());
            ClassWriter classWriter = new ClassWriter(1);
            classWriter.visit(48, 17, string3, null, Type.getType((Class)(class$java$lang$Object == null ? (class$java$lang$Object = UtilsCompiler.class$("java.lang.Object")) : class$java$lang$Object)).getInternalName(), null);
            Method method = Method.getMethod((String)"void <clinit>()");
            GeneratorAdapter generatorAdapter = new GeneratorAdapter(10, method, null, null, (ClassVisitor)classWriter);
            FieldVisitor fieldVisitor = classWriter.visitField(25, "_ZSA", STRING_A_TYPE_DESCRIPTOR, null, null);
            fieldVisitor.visitEnd();
            generatorAdapter.push(0);
            generatorAdapter.newArray(STRING_TYPE);
            generatorAdapter.putStatic(type, "_ZSA", STRING_A_TYPE);
            fieldVisitor = classWriter.visitField(25, "_ZS2A", STRING_2A_TYPE_DESCRIPTOR, null, null);
            fieldVisitor.visitEnd();
            generatorAdapter.push(0);
            generatorAdapter.newArray(STRING_A_TYPE);
            generatorAdapter.putStatic(type, "_ZS2A", STRING_2A_TYPE);
            fieldVisitor = classWriter.visitField(25, "_ZS3A", STRING_3A_TYPE_DESCRIPTOR, null, null);
            fieldVisitor.visitEnd();
            generatorAdapter.push(0);
            generatorAdapter.newArray(STRING_2A_TYPE);
            generatorAdapter.putStatic(type, "_ZS3A", STRING_3A_TYPE);
            int[][] nArray = UtilsCompiler.createServicesSyncMsIds(dSIReflectionFactory);
            String[][] stringArray = new String[CompileGeneratedConstants.SERVICE_SYNC_MS_NS.length][];
            String[][][] stringArray2 = new String[CompileGeneratedConstants.LISTENER_SYNC_MS_NS.length][][];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int[] nArray2 = nArray[i2];
                int[] nArray3 = new int[nArray2.length];
                System.arraycopy((Object)nArray2, 0, (Object)nArray3, 0, nArray2.length);
                Arrays.sort(nArray3);
                String[] stringArray3 = new String[CompileGeneratedConstants.SERVICE_SYNC_MS_NS[i2].length];
                String[][] stringArrayArray = new String[CompileGeneratedConstants.LISTENER_SYNC_MS_NS[i2].length][];
                block4: for (int i3 = 0; i3 < nArray3.length; ++i3) {
                    for (int i4 = 0; i4 < nArray2.length; ++i4) {
                        if (nArray3[i3] != nArray2[i4]) continue;
                        stringArray3[i3] = CompileGeneratedConstants.SERVICE_SYNC_MS_NS[i2][i4];
                        stringArrayArray[i3] = CompileGeneratedConstants.LISTENER_SYNC_MS_NS[i2][i4];
                        continue block4;
                    }
                }
                stringArray[i2] = stringArray3;
                stringArray2[i2] = stringArrayArray;
            }
            UtilsCompiler.addServicesSyncMsNs(classWriter, generatorAdapter, type, stringArray);
            UtilsCompiler.addListenersSyncMsNs(classWriter, generatorAdapter, type, stringArray2);
            UtilsCompiler.addUtilAllCfg(classWriter, generatorAdapter, type);
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

    private static void addServicesSyncMsNs(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, String[][] stringArray) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, "C0", STRING_2A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        UtilsCompiler.push(generatorAdapter, type, stringArray);
        generatorAdapter.putStatic(type, "C0", STRING_2A_TYPE);
    }

    private static void addListenersSyncMsNs(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, String[][][] stringArray) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, "C1", STRING_3A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        UtilsCompiler.push(generatorAdapter, type, stringArray);
        generatorAdapter.putStatic(type, "C1", STRING_3A_TYPE);
    }

    private static void addUtilAllCfg(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, "CFG", OBJ_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        generatorAdapter.push(2);
        generatorAdapter.newArray(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(0);
        generatorAdapter.getStatic(type, "C0", STRING_2A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(1);
        generatorAdapter.getStatic(type, "C1", STRING_3A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.putStatic(type, "CFG", OBJ_A_TYPE);
    }

    private UtilsCompiler() {
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

