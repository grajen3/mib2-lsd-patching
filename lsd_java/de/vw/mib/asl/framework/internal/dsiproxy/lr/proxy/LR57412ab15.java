/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.proxy;

import de.vw.mib.reflection.AbstractProxy;
import de.vw.mib.reflection.InvocationHandler;
import de.vw.mib.reflection.RuntimeUtil;
import de.vw.mib.reflection.pool.ObjArrayPool;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener;
import org.dsi.ifc.swdllogging.DSISwdlLoggingListener;

public final class LR57412ab15
extends AbstractProxy
implements DSISwdlLoggingListener,
DSISwdlDeviceInfoListener {
    private static final Method[] JMS = new Method[22];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR57412ab15(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void getHistory(String[] stringArray, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stringArray;
            objectArray[1] = nArray;
            this.h.invoke(this, LR57412ab15.gjm(0, "org.dsi.ifc.swdllogging.DSISwdlLoggingListener", -752743051, 1953786391), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setUpdate(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57412ab15.gjm(1, "org.dsi.ifc.swdllogging.DSISwdlLoggingListener", 1083329574, 1687814400), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getGeneralInformation(boolean bl, String string, String string2, boolean bl2, String string3, String string4, int[] nArray, boolean bl3, int n, int[] nArray2) {
        try {
            Object[] objectArray = this.p.borrowArray(10);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = string;
            objectArray[2] = string2;
            objectArray[3] = RuntimeUtil.valueOf(bl2);
            objectArray[4] = string3;
            objectArray[5] = string4;
            objectArray[6] = nArray;
            objectArray[7] = RuntimeUtil.valueOf(bl3);
            objectArray[8] = RuntimeUtil.valueOf(n);
            objectArray[9] = nArray2;
            this.h.invoke(this, LR57412ab15.gjm(2, "org.dsi.ifc.swdllogging.DSISwdlLoggingListener", -1890096023, 676618512), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getUnusualEvents(int[] nArray, String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = stringArray;
            this.h.invoke(this, LR57412ab15.gjm(3, "org.dsi.ifc.swdllogging.DSISwdlLoggingListener", 1104298180, 815995234), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getUnusualEvent(int n, String string, String string2, String string3, byte by, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = string2;
            objectArray[3] = string3;
            objectArray[4] = RuntimeUtil.valueOf(by);
            objectArray[5] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR57412ab15.gjm(4, "org.dsi.ifc.swdllogging.DSISwdlLoggingListener", -60609695, -1833258442), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR57412ab15.gjm(5, "org.dsi.ifc.swdllogging.DSISwdlLoggingListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getModules(int n, String[] stringArray, int[] nArray, short[] sArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = stringArray;
            objectArray[2] = nArray;
            objectArray[3] = sArray;
            this.h.invoke(this, LR57412ab15.gjm(6, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", -966396282, -851603), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getErrors(int n, int[] nArray, short[] sArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = nArray;
            objectArray[2] = sArray;
            this.h.invoke(this, LR57412ab15.gjm(7, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", -694883305, 2047298816), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getVersions(int n, int n2, long[] lArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = lArray;
            this.h.invoke(this, LR57412ab15.gjm(8, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", -2034333691, -1641380352), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getFileNames(int n, int n2, String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = stringArray;
            this.h.invoke(this, LR57412ab15.gjm(9, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", -344850256, 612495149), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getAdditionalInfo(int n, int n2, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = nArray;
            this.h.invoke(this, LR57412ab15.gjm(10, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", -533428812, 1160087040), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getPopup(int n, int n2, String string, int n3, int n4, int n5, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(7);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = string;
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = RuntimeUtil.valueOf(n4);
            objectArray[5] = RuntimeUtil.valueOf(n5);
            objectArray[6] = string2;
            this.h.invoke(this, LR57412ab15.gjm(11, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", 1796865140, -293143216), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getDevices(String[] stringArray, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stringArray;
            objectArray[1] = nArray;
            this.h.invoke(this, LR57412ab15.gjm(12, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", 485213594, 1953786391), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getLanguages(int n, String[] stringArray, short s, short s2, short s3) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = stringArray;
            objectArray[2] = RuntimeUtil.valueOf(s);
            objectArray[3] = RuntimeUtil.valueOf(s2);
            objectArray[4] = RuntimeUtil.valueOf(s3);
            this.h.invoke(this, LR57412ab15.gjm(13, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", -632558247, -247758128), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void isDataModule(int n, int n2, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57412ab15.gjm(14, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", -174457150, 252948384), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void isNoExclusiveBoloUpdate(int n, int n2, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57412ab15.gjm(15, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", -1579397035, 252948384), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getTargetVersions(int n, int n2, long[] lArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = lArray;
            this.h.invoke(this, LR57412ab15.gjm(16, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", -1224580839, -1641380352), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getFileDetails(int n, int n2, int n3, long l, long l2, long l3, boolean bl, boolean bl2, String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(10);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(l);
            objectArray[4] = RuntimeUtil.valueOf(l2);
            objectArray[5] = RuntimeUtil.valueOf(l3);
            objectArray[6] = RuntimeUtil.valueOf(bl);
            objectArray[7] = RuntimeUtil.valueOf(bl2);
            objectArray[8] = string;
            objectArray[9] = string2;
            this.h.invoke(this, LR57412ab15.gjm(17, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", 1710939047, -53603983), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getInfoFilePath(int n, String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = string2;
            this.h.invoke(this, LR57412ab15.gjm(18, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", 2055144698, 1383775559), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getNumberOfPopups(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57412ab15.gjm(19, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", -766020004, 1687814400), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSummaryChanged(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57412ab15.gjm(20, "org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener", -855682814, -645498553), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}

