/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.vw.mib.asl.framework.internal.framework.build.CommonUtil
 */
package de.vw.mib.asl.framework.internal.framework.dsi.build;

import de.vw.mib.asl.framework.internal.framework.build.CommonUtil;
import de.vw.mib.asl.framework.internal.framework.dsi.build.CommonCompiler;
import de.vw.mib.asl.framework.internal.framework.dsi.build.ProxyTargetCompiler;
import de.vw.mib.asl.framework.internal.framework.dsi.build.UtilsCompiler;
import de.vw.mib.asl.framework.internal.framework.dsi.util.CompileGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler;
import de.vw.mib.asl.framework.internal.framework.reflection.build.LogUtils;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionConfiguration;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionFactory;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class DSIProxyConfigurationCompiler
extends Compiler {
    private static final int ARGIDX_OUTPUT_DIR;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler;

    static int[][] createServicesSyncMsIds(DSIReflectionFactory dSIReflectionFactory) {
        int[][] nArrayArray = new int[CompileGeneratedConstants.SERVICE_SYNC_MS_NS.length][];
        for (int i2 = 0; i2 < CompileGeneratedConstants.SERVICE_SYNC_MS_NS.length; ++i2) {
            MultipleMethodAccessibleObject multipleMethodAccessibleObject = dSIReflectionFactory.getServicesMmao(i2);
            int[] nArray = new int[CompileGeneratedConstants.SERVICE_SYNC_MS_NS[i2].length];
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                nArray[i3] = multipleMethodAccessibleObject.getIndex(RuntimeGeneratedConstants.SERVICE_TS_NS[i2], CompileGeneratedConstants.SERVICE_SYNC_MS_NS[i2][i3]);
            }
            nArrayArray[i2] = nArray;
        }
        return nArrayArray;
    }

    public static void main(String[] stringArray) {
        try {
            String string = DSIProxyConfigurationCompiler.readArg(stringArray, 0);
            if (string == null || string.equals("")) {
                string = new StringBuffer().append(new File((class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler == null ? (class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler = DSIProxyConfigurationCompiler.class$("de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler")) : class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler).getProtectionDomain().getCodeSource().getLocation().getFile()).getAbsolutePath()).append(File.separator).toString();
            } else if (!string.endsWith(File.separator)) {
                string = new StringBuffer().append(string).append(File.separator).toString();
            }
            File file = new File(string);
            DSIProxyConfigurationCompiler.compileAll(file);
        }
        catch (RuntimeException runtimeException) {
            LogUtils.logError(runtimeException);
            throw runtimeException;
        }
    }

    public static void compileAll(File file) {
        DSIReflectionConfiguration dSIReflectionConfiguration = new DSIReflectionConfiguration("de.vw.mib.asl.framework.internal.dsiproxy.lr.DSIRFCC");
        DSIReflectionFactory dSIReflectionFactory = new DSIReflectionFactory(dSIReflectionConfiguration);
        File file2 = new File(file, "de.vw.mib.asl.framework.internal.dsiproxy.lr".replace('.', File.separatorChar));
        CommonUtil.mkdirs((File)file2);
        CommonCompiler.compile(file, "de.vw.mib.asl.framework.internal.dsiproxy.lr", dSIReflectionFactory);
        file2 = new File(file, "de.vw.mib.asl.framework.internal.dsiproxy.lr".replace('.', File.separatorChar));
        CommonUtil.mkdirs((File)file2);
        ProxyTargetCompiler proxyTargetCompiler = ProxyTargetCompiler.create("de.vw.mib.asl.framework.internal.dsiproxy.lr", dSIReflectionFactory);
        proxyTargetCompiler.compile(file);
        file2 = new File(file, "de.vw.mib.asl.framework.internal.dsiproxy.lr".replace('.', File.separatorChar));
        CommonUtil.mkdirs((File)file2);
        UtilsCompiler.compile(file, "de.vw.mib.asl.framework.internal.dsiproxy.lr", dSIReflectionFactory);
    }

    protected static Object deepArrayCopy(Object object) {
        Object object2;
        Class clazz;
        if (null != object && (clazz = object.getClass()).isArray()) {
            Class clazz2 = clazz.getComponentType();
            int n = Array.getLength(object);
            object2 = Array.newInstance(clazz2, n);
            if (clazz2.isPrimitive() || clazz2.isInterface()) {
                System.arraycopy(object, 0, object2, 0, n);
            } else {
                for (int i2 = 0; i2 < n; ++i2) {
                    Array.set(object2, i2, DSIProxyConfigurationCompiler.deepArrayCopy(Array.get(object, i2)));
                }
            }
        } else {
            object2 = object;
        }
        return object2;
    }

    protected static int[][] sort(int[][] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int[] nArray2 = nArray[i2];
            if (null == nArray2) continue;
            Arrays.sort(nArray2);
        }
        return nArray;
    }

    protected static void sort(int[][] nArray, Object[] objectArray) {
        Object[] objectArray2 = new Object[objectArray.length];
        if (null != nArray) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                for (int i3 = 0; i3 < objectArray2.length; ++i3) {
                    objectArray2[i3] = Array.get(objectArray[i3], i2);
                }
                DSIProxyConfigurationCompiler.sort(nArray[i2], objectArray2);
            }
        }
    }

    protected static void sort(int[] nArray, Object[] objectArray) {
        if (null != nArray) {
            for (int i2 = 0; i2 < nArray.length - 1; ++i2) {
                int n = DSIProxyConfigurationCompiler.findMin(nArray, i2);
                if (n == i2) continue;
                DSIProxyConfigurationCompiler.swap(i2, n, nArray, objectArray);
            }
        }
    }

    private static int findMin(int[] nArray, int n) {
        int n2 = -129;
        int n3 = n;
        for (int i2 = n; i2 < nArray.length; ++i2) {
            if (nArray[i2] >= n2) continue;
            n2 = nArray[i2];
            n3 = i2;
        }
        return n3;
    }

    private static void swap(int n, int n2, int[] nArray, Object[] objectArray) {
        int n3 = nArray[n];
        nArray[n] = nArray[n2];
        nArray[n2] = n3;
        for (n3 = 0; n3 < objectArray.length; ++n3) {
            Object object = objectArray[n3];
            if (null == object || 0 >= Array.getLength(object)) continue;
            Object object2 = Array.get(object, n);
            Array.set(object, n, Array.get(object, n2));
            Array.set(object, n2, object2);
        }
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

