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
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionFactory;
import java.io.File;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

public final class CommonCompiler
extends DSIProxyConfigurationCompiler {
    private static final String INST_DEP_OBJ_S_P_FN;
    private static final String LISTENERS_ASYNC_EXC_MS_IDS_FN;
    private static final int C_CC_ALL_F_L;
    private static final String ASYNC_EXC_M_NAME;
    static /* synthetic */ Class class$java$lang$Object;

    public static void compile(File file, String string, DSIReflectionFactory dSIReflectionFactory) {
        try {
            String string2 = new StringBuffer().append(string).append(".").append("CCC").toString();
            String string3 = string2.replace('.', '/');
            Type type = Type.getType((String)new StringBuffer().append("L").append(string3).append(";").toString());
            ClassWriter classWriter = new ClassWriter(1);
            classWriter.visit(48, 17, string3, null, Type.getType((Class)(class$java$lang$Object == null ? (class$java$lang$Object = CommonCompiler.class$("java.lang.Object")) : class$java$lang$Object)).getInternalName(), null);
            Method method = Method.getMethod((String)"void <clinit>()");
            GeneratorAdapter generatorAdapter = new GeneratorAdapter(10, method, null, null, (ClassVisitor)classWriter);
            int[] nArray = new int[RuntimeGeneratedConstants.INST_NMBS.length];
            int n = 0;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                nArray[i2] = n;
                n += RuntimeGeneratedConstants.INST_NMBS[i2];
            }
            int[] nArray2 = CommonCompiler.createListenersAsyncExceptionMsIds(dSIReflectionFactory);
            CommonCompiler.addInstancesDepObjStartPositions(classWriter, generatorAdapter, type, nArray);
            CommonCompiler.addListenersAsyncExceptionMsIds(classWriter, generatorAdapter, type, nArray2);
            CommonCompiler.addCommonAllCfg(classWriter, generatorAdapter, type);
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

    private static void addInstancesDepObjStartPositions(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, int[] nArray) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, "C0", INT_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        CommonCompiler.push(generatorAdapter, type, nArray);
        generatorAdapter.putStatic(type, "C0", INT_A_TYPE);
    }

    private static int[] createListenersAsyncExceptionMsIds(DSIReflectionFactory dSIReflectionFactory) {
        int[] nArray = new int[RuntimeGeneratedConstants.LISTENER_TS_NS.length];
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.LISTENER_TS_NS.length; ++i2) {
            nArray[i2] = dSIReflectionFactory.getListenersMmao(i2).getIndex(RuntimeGeneratedConstants.LISTENER_TS_NS[i2], "asyncException");
        }
        return nArray;
    }

    private static void addListenersAsyncExceptionMsIds(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, int[] nArray) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, "C1", INT_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        CommonCompiler.push(generatorAdapter, type, nArray);
        generatorAdapter.putStatic(type, "C1", INT_A_TYPE);
    }

    private static void addCommonAllCfg(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, "CFG", OBJ_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        generatorAdapter.push(2);
        generatorAdapter.newArray(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(0);
        generatorAdapter.getStatic(type, "C0", INT_A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(1);
        generatorAdapter.getStatic(type, "C1", INT_A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.putStatic(type, "CFG", OBJ_A_TYPE);
    }

    private CommonCompiler() {
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

