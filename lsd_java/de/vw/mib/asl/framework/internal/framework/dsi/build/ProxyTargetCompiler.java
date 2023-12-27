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
import de.vw.mib.asl.framework.internal.framework.dsi.build.ProxyTargetCompiler$EmptyIsNullArrayWriter;
import de.vw.mib.asl.framework.internal.framework.dsi.build.ProxyTargetCompiler$MethodIdRetriever;
import de.vw.mib.asl.framework.internal.framework.dsi.util.CompileGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.reflection.build.ArrayWriter;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

public final class ProxyTargetCompiler
extends DSIProxyConfigurationCompiler {
    private static final String SERVICES_NOTIF_ATTRS_FN;
    private static final String LISTENERS_NOTIF_MS_IDS_FN;
    private static final String LISTENERS_NON_VALIDATE_NOTIF_MS_IDS_FN;
    private static final String LISTENERS_NON_DISCARDABLE_NOTIF_MS_IDS_FN;
    private static final String LISTENERS_INDIC_MS_IDS_FN;
    private static final String SERVICES_SYNC_MS_IDS_FN;
    private static final String LISTENERS_SYNC_MS_IDS_FN;
    private static final String SYNC_CMP_ANALYZERS_CS_IDS_FN;
    private static final String SERVICES_ASYNC_EXC_RTS_FN;
    private static final String SERVICES_SYNC_REQ_TIMEOUTS_FN;
    private static final String SERVICES_SYNC_REQUEST_TYPES_FN;
    private static final String SERVICES_TYPES_FN;
    private static final int P_T_CC_ALL_F_L;
    private final String targetPackageName;
    private final DSIReflectionFactory factory;
    private final ProxyTargetCompiler$MethodIdRetriever listenersIdsRetriever;
    private final ProxyTargetCompiler$MethodIdRetriever servicesIdsRetriever;
    private final ArrayWriter emptyIsNullWriter;
    private final String className;
    private final String typeName;
    private final Type classAsmType;
    static /* synthetic */ Class array$I;
    static /* synthetic */ Class array$$I;
    static /* synthetic */ Class class$java$lang$Object;
    static /* synthetic */ Class array$$B;
    static /* synthetic */ Class array$S;
    static /* synthetic */ Class array$$$I;

    static ProxyTargetCompiler create(String string, DSIReflectionFactory dSIReflectionFactory) {
        return new ProxyTargetCompiler(string, dSIReflectionFactory);
    }

    private ProxyTargetCompiler(String string, DSIReflectionFactory dSIReflectionFactory) {
        this.targetPackageName = string;
        this.factory = dSIReflectionFactory;
        this.listenersIdsRetriever = ProxyTargetCompiler$MethodIdRetriever.createListenersIdsRetriever(dSIReflectionFactory);
        this.servicesIdsRetriever = ProxyTargetCompiler$MethodIdRetriever.createServicesIdsRetriever(dSIReflectionFactory);
        this.className = new StringBuffer().append(this.targetPackageName).append(".").append("PTCC").toString();
        this.typeName = this.className.replace('.', '/');
        this.classAsmType = Type.getType((String)new StringBuffer().append("L").append(this.typeName).append(";").toString());
        this.emptyIsNullWriter = new ProxyTargetCompiler$EmptyIsNullArrayWriter();
    }

    public void compile(File file) {
        try {
            int[] nArray = ProxyTargetCompiler.createNonSyncServicesIdxs();
            int[][] nArray2 = ProxyTargetCompiler.allMethodNamesToIds(this.listenersIdsRetriever, CompileGeneratedConstants.LISTENER_NOTIF_MS_NS);
            int[][] nArray3 = (int[][])ProxyTargetCompiler.deepArrayCopy(CompileGeneratedConstants.SERVICE_NOTIF_ATTRS);
            ProxyTargetCompiler.sort(nArray2, new Object[]{nArray3});
            int[][] nArray4 = ProxyTargetCompiler.sort(ProxyTargetCompiler.allMethodNamesToIds(this.listenersIdsRetriever, CompileGeneratedConstants.LISTENER_NON_VALIDATE_NOTIF_MS_NS));
            int[][] nArray5 = ProxyTargetCompiler.sort(ProxyTargetCompiler.allMethodNamesToIds(this.listenersIdsRetriever, CompileGeneratedConstants.LISTENER_NON_DISCARDABLE_NOTIF_MS_NS));
            int[][] nArray6 = ProxyTargetCompiler.sort(ProxyTargetCompiler.allMethodNamesToIds(this.listenersIdsRetriever, CompileGeneratedConstants.LISTENER_INDIC_MS_NS));
            int[][] nArray7 = ProxyTargetCompiler.allMethodNamesToIds(this.servicesIdsRetriever, CompileGeneratedConstants.SERVICE_SYNC_MS_NS);
            int[][][] nArray8 = this.createListenersSyncMsIds();
            int[][] nArray9 = (int[][])ProxyTargetCompiler.deepArrayCopy(CompileGeneratedConstants.SERVICE_SYNC_ASYNC_EXC_RTS);
            int[][] nArray10 = (int[][])ProxyTargetCompiler.deepArrayCopy(CompileGeneratedConstants.SERVICE_SYNC_REQ_TS);
            ProxyTargetCompiler.sort(nArray7, new Object[]{nArray8, nArray9, nArray10});
            int[] nArray11 = this.createSyncCmpAnalyzersConstrIds();
            byte[][] byArray = this.createRequestTypes(nArray7, nArray8);
            short[] sArray = ProxyTargetCompiler.createServiceTypes(byArray, nArray);
            byArray = ProxyTargetCompiler.packRequestTypes(byArray);
            ProxyTargetCompiler.packRTs(nArray9);
            ProxyTargetCompiler.packRequestTimeouts(nArray10);
            ClassWriter classWriter = new ClassWriter(1);
            classWriter.visit(48, 17, this.typeName, null, Type.getType((Class)(class$java$lang$Object == null ? (class$java$lang$Object = ProxyTargetCompiler.class$("java.lang.Object")) : class$java$lang$Object)).getInternalName(), null);
            GeneratorAdapter generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C0");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C0", nArray3, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C1");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C1", nArray2, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C2");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C2", nArray4, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C3");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C3", nArray5, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C4");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C4", nArray6, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C5");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C5", nArray7, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C6");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C6", nArray8, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C7");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C7", nArray11, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C8");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C8", nArray9, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C9");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C9", nArray10, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C10");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C10", byArray, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            generatorAdapter = ProxyTargetCompiler.createInitMethod(classWriter, "C11");
            ProxyTargetCompiler.storeField(classWriter, generatorAdapter, this.classAsmType, "C11", sArray, this.emptyIsNullWriter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            Method method = Method.getMethod((String)"void <clinit>()");
            generatorAdapter = new GeneratorAdapter(10, method, null, null, (ClassVisitor)classWriter);
            this.addProxyTargetAllCfg(classWriter, generatorAdapter);
            generatorAdapter.returnValue();
            generatorAdapter.endMethod();
            byte[] byArray2 = classWriter.toByteArray();
            AsmUtil.saveClass((File)file, (String)this.className, (byte[])byArray2);
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    private static GeneratorAdapter createInitMethod(ClassWriter classWriter, String string) {
        Method method = Method.getMethod((String)new StringBuffer().append("void init").append(string).append("()").toString());
        return new GeneratorAdapter(10, method, null, null, (ClassVisitor)classWriter);
    }

    private void addInvokeInitMethod(GeneratorAdapter generatorAdapter, String string) {
        Method method = Method.getMethod((String)new StringBuffer().append("void init").append(string).append("()").toString());
        generatorAdapter.invokeStatic(this.classAsmType, method);
    }

    private byte[][] createRequestTypes(int[][] nArray, int[][][] nArray2) {
        int[][] nArray3 = ProxyTargetCompiler.allMethodNamesToIds(this.servicesIdsRetriever, CompileGeneratedConstants.SERVICE_SYNC_CH_MS_NS);
        int[][] nArray4 = ProxyTargetCompiler.allMethodNamesToIds(this.servicesIdsRetriever, CompileGeneratedConstants.SERVICE_SYNC_SEQ_MS_NS);
        int[][] nArray5 = ProxyTargetCompiler.allMethodNamesToIds(this.servicesIdsRetriever, CompileGeneratedConstants.SERVICE_SYNC_CMP_MS_NS);
        byte[][] byArrayArray = new byte[nArray.length][];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            byArrayArray[i2] = ProxyTargetCompiler.createRequestTypes(nArray[i2], nArray3[i2], nArray4[i2], nArray5[i2], nArray2[i2]);
        }
        return byArrayArray;
    }

    private static byte[] createRequestTypes(int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, int[][] nArray5) {
        byte[] byArray;
        byte[] byArray2 = byArray = null != nArray ? new byte[nArray.length] : null;
        if (null != byArray) {
            ProxyTargetCompiler.fillRequestType((byte)4, byArray, nArray, nArray2);
            ProxyTargetCompiler.fillRequestType((byte)3, byArray, nArray, nArray3);
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                if (1 != nArray5[i2].length) continue;
                byArray[i2] = 2;
            }
            ProxyTargetCompiler.fillRequestType((byte)5, byArray, nArray, nArray4);
        }
        return byArray;
    }

    private static void fillRequestType(byte by, byte[] byArray, int[] nArray, int[] nArray2) {
        if (null != nArray2) {
            for (int i2 = 0; i2 < nArray2.length; ++i2) {
                int n = Arrays.binarySearch(nArray, nArray2[i2]);
                byArray[n] = by;
            }
        }
    }

    private static short[] createServiceTypes(byte[][] byArray, int[] nArray) {
        int n;
        short[] sArray = new short[byArray.length];
        int n2 = 0;
        for (n = 0; n < byArray.length; ++n) {
            int n3 = 0;
            byte[] byArray2 = byArray[n];
            if (null != byArray2) {
                for (int i2 = 0; i2 < byArray2.length; ++i2) {
                    n3 = (byte)(n3 | 1 << byArray2[i2]);
                }
            }
            sArray[n] = (short)n3;
            if (0 == (n3 & n3 - 1)) {
                byArray[n] = null;
                continue;
            }
            if (n2 != n) {
                byArray[n2] = byArray[n];
                byArray[n] = null;
            }
            int n4 = n;
            sArray[n4] = (short)(sArray[n4] | (n2++ << 7 | 0x40));
        }
        for (n = 0; n < nArray.length; ++n) {
            sArray[nArray[n]] = 2;
        }
        return sArray;
    }

    private static byte[][] packRequestTypes(byte[][] byArray) {
        ArrayList arrayList = new ArrayList(byArray.length);
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            byte[] byArray2 = byArray[i2];
            if (null == byArray2 || 0 >= byArray2.length) continue;
            int n = byArray2.length >>> 1;
            byte[] byArray3 = new byte[n + (byArray2.length & 1)];
            int n2 = 0;
            for (int i3 = 0; i3 < n; ++i3) {
                byArray3[i3] = (byte)(0xF & byArray2[n2++] | 0xF0 & byArray2[n2++] << 4);
            }
            if (n2 < byArray2.length) {
                byArray3[byArray3.length - 1] = byArray2[n2];
            }
            arrayList.add(byArray3);
        }
        return (byte[][])arrayList.toArray((Object[])new byte[arrayList.size()][]);
    }

    private static void packRTs(int[][] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int[] nArray2 = nArray[i2];
            int n = 0;
            while (n < nArray2.length) {
                int n2 = n++;
                nArray2[n2] = nArray2[n2] - 1000;
            }
        }
    }

    private static void packRequestTimeouts(int[][] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int[] nArray2 = nArray[i2];
            for (int i3 = 0; i3 < nArray2.length; ++i3) {
                if (0 >= nArray2[i3]) continue;
                nArray2[i3] = Math.max(1, nArray2[i3] / 1000);
            }
        }
    }

    private static int[] createNonSyncServicesIdxs() {
        int[] nArray = new int[CompileGeneratedConstants.NON_SYNC_SERVICE_TS_NS.length];
        block0: for (int i2 = 0; i2 < CompileGeneratedConstants.NON_SYNC_SERVICE_TS_NS.length; ++i2) {
            for (int i3 = 0; i3 < RuntimeGeneratedConstants.SERVICE_TS_NS.length; ++i3) {
                if (!CompileGeneratedConstants.NON_SYNC_SERVICE_TS_NS[i2].equals(RuntimeGeneratedConstants.SERVICE_TS_NS[i3])) continue;
                nArray[i2] = i3;
                continue block0;
            }
        }
        Arrays.sort(nArray);
        return nArray;
    }

    private static void storeField(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, String string, byte[][] byArray, ArrayWriter arrayWriter) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, string, BYTE_2A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        arrayWriter.pushArray(generatorAdapter, array$$B == null ? (array$$B = ProxyTargetCompiler.class$("[[B")) : array$$B, byArray);
        generatorAdapter.putStatic(type, string, BYTE_2A_TYPE);
    }

    private static void storeField(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, String string, short[] sArray, ArrayWriter arrayWriter) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, string, SHORT_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        arrayWriter.pushArray(generatorAdapter, array$S == null ? (array$S = ProxyTargetCompiler.class$("[S")) : array$S, sArray);
        generatorAdapter.putStatic(type, string, SHORT_A_TYPE);
    }

    private static void storeField(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, String string, int[] nArray, ArrayWriter arrayWriter) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, string, INT_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        arrayWriter.pushArray(generatorAdapter, array$I == null ? (array$I = ProxyTargetCompiler.class$("[I")) : array$I, nArray);
        generatorAdapter.putStatic(type, string, INT_A_TYPE);
    }

    private static void storeField(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, String string, int[][] nArray, ArrayWriter arrayWriter) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, string, INT_2A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        arrayWriter.pushArray(generatorAdapter, array$$I == null ? (array$$I = ProxyTargetCompiler.class$("[[I")) : array$$I, nArray);
        generatorAdapter.putStatic(type, string, INT_2A_TYPE);
    }

    private static void storeField(ClassWriter classWriter, GeneratorAdapter generatorAdapter, Type type, String string, int[][][] nArray, ArrayWriter arrayWriter) {
        FieldVisitor fieldVisitor = classWriter.visitField(25, string, INT_3A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        arrayWriter.pushArray(generatorAdapter, array$$$I == null ? (array$$$I = ProxyTargetCompiler.class$("[[[I")) : array$$$I, nArray);
        generatorAdapter.putStatic(type, string, INT_3A_TYPE);
    }

    private static int[][] allMethodNamesToIds(ProxyTargetCompiler$MethodIdRetriever proxyTargetCompiler$MethodIdRetriever, String[][] stringArray) {
        int[][] nArrayArray = new int[stringArray.length][];
        for (int i2 = 0; i2 < nArrayArray.length; ++i2) {
            String[] stringArray2 = stringArray[i2];
            if (null == stringArray2 || 0 >= stringArray2.length) continue;
            nArrayArray[i2] = ProxyTargetCompiler.methodNamesToIds(proxyTargetCompiler$MethodIdRetriever, i2, stringArray2);
        }
        return nArrayArray;
    }

    private static int[] methodNamesToIds(ProxyTargetCompiler$MethodIdRetriever proxyTargetCompiler$MethodIdRetriever, int n, String[] stringArray) {
        int[] nArray = new int[stringArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = proxyTargetCompiler$MethodIdRetriever.get(n, stringArray[i2]);
        }
        return nArray;
    }

    private int[][][] createListenersSyncMsIds() {
        int[][][] nArrayArray = new int[CompileGeneratedConstants.LISTENER_SYNC_MS_NS.length][][];
        for (int i2 = 0; i2 < CompileGeneratedConstants.LISTENER_SYNC_MS_NS.length; ++i2) {
            int[][] nArrayArray2 = new int[CompileGeneratedConstants.LISTENER_SYNC_MS_NS[i2].length][];
            for (int i3 = 0; i3 < CompileGeneratedConstants.LISTENER_SYNC_MS_NS[i2].length; ++i3) {
                nArrayArray2[i3] = ProxyTargetCompiler.methodNamesToIds(this.listenersIdsRetriever, i2, CompileGeneratedConstants.LISTENER_SYNC_MS_NS[i2][i3]);
            }
            nArrayArray[i2] = nArrayArray2;
        }
        return nArrayArray;
    }

    private int[] createSyncCmpAnalyzersConstrIds() {
        int[] nArray = new int[CompileGeneratedConstants.SYNC_CMP_ANALYZER_TS.length];
        for (int i2 = 0; i2 < CompileGeneratedConstants.SYNC_CMP_ANALYZER_TS.length; ++i2) {
            if (CompileGeneratedConstants.SYNC_CMP_ANALYZER_TS[i2] == null) continue;
            nArray[i2] = this.factory.getSyncCmpAnalyzersMcao().getIndex(CompileGeneratedConstants.SYNC_CMP_ANALYZER_TS[i2]);
        }
        return nArray;
    }

    private void addProxyTargetAllCfg(ClassWriter classWriter, GeneratorAdapter generatorAdapter) {
        this.addInvokeInitMethod(generatorAdapter, "C0");
        this.addInvokeInitMethod(generatorAdapter, "C1");
        this.addInvokeInitMethod(generatorAdapter, "C2");
        this.addInvokeInitMethod(generatorAdapter, "C3");
        this.addInvokeInitMethod(generatorAdapter, "C4");
        this.addInvokeInitMethod(generatorAdapter, "C5");
        this.addInvokeInitMethod(generatorAdapter, "C6");
        this.addInvokeInitMethod(generatorAdapter, "C7");
        this.addInvokeInitMethod(generatorAdapter, "C8");
        this.addInvokeInitMethod(generatorAdapter, "C9");
        this.addInvokeInitMethod(generatorAdapter, "C10");
        this.addInvokeInitMethod(generatorAdapter, "C11");
        FieldVisitor fieldVisitor = classWriter.visitField(25, "CFG", OBJ_A_TYPE_DESCRIPTOR, null, null);
        fieldVisitor.visitEnd();
        generatorAdapter.push(12);
        generatorAdapter.newArray(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(0);
        generatorAdapter.getStatic(this.classAsmType, "C0", INT_2A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(1);
        generatorAdapter.getStatic(this.classAsmType, "C1", INT_2A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(2);
        generatorAdapter.getStatic(this.classAsmType, "C2", INT_2A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(3);
        generatorAdapter.getStatic(this.classAsmType, "C3", INT_2A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(4);
        generatorAdapter.getStatic(this.classAsmType, "C4", INT_2A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(5);
        generatorAdapter.getStatic(this.classAsmType, "C5", INT_2A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(6);
        generatorAdapter.getStatic(this.classAsmType, "C6", INT_3A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(7);
        generatorAdapter.getStatic(this.classAsmType, "C7", INT_A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(8);
        generatorAdapter.getStatic(this.classAsmType, "C8", INT_2A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(9);
        generatorAdapter.getStatic(this.classAsmType, "C9", INT_2A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(10);
        generatorAdapter.getStatic(this.classAsmType, "C10", BYTE_2A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.dup();
        generatorAdapter.push(11);
        generatorAdapter.getStatic(this.classAsmType, "C11", SHORT_A_TYPE);
        generatorAdapter.arrayStore(OBJ_TYPE);
        generatorAdapter.putStatic(this.classAsmType, "CFG", OBJ_A_TYPE);
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

