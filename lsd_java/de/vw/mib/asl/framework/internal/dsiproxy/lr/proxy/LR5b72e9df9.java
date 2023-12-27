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
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener;
import org.dsi.ifc.online.DSIOnlineTrafficListener;
import org.dsi.ifc.online.FCDPosition;
import org.dsi.ifc.online.LocatablePosition;

public final class LR5b72e9df9
extends AbstractProxy
implements DSIOnlineTrafficLightInfoListener,
DSIOnlineTrafficListener {
    private static final Method[] JMS = new Method[14];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5b72e9df9(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateTrafficLightInfo(int n, int n2, int[] nArray, int n3, int n4, int n5) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = nArray;
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = RuntimeUtil.valueOf(n4);
            objectArray[5] = RuntimeUtil.valueOf(n5);
            this.h.invoke(this, LR5b72e9df9.gjm(0, "org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener", -985004244, 514058505), 0, objectArray);
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
    public void updateTrafficLightSpeed(CarBCSpeed carBCSpeed, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCSpeed;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b72e9df9.gjm(1, "org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener", 1519611733, 734093362), 1, objectArray);
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
    public void updateTrafficLightTime(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5b72e9df9.gjm(2, "org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener", -466088916, 1043255048), 2, objectArray);
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
            this.h.invoke(this, LR5b72e9df9.gjm(3, "org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateConsumerReady(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b72e9df9.gjm(4, "org.dsi.ifc.online.DSIOnlineTrafficListener", 2042038763, 1676164096), 4, objectArray);
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
    public void updateWantOnlineTrafficData(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b72e9df9.gjm(5, "org.dsi.ifc.online.DSIOnlineTrafficListener", -255896268, 1676164096), 5, objectArray);
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
    public void getNewDataResult(int n, LocatablePosition[] locatablePositionArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = locatablePositionArray;
            this.h.invoke(this, LR5b72e9df9.gjm(6, "org.dsi.ifc.online.DSIOnlineTrafficListener", -428312263, -1514310245), 6, objectArray);
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
    public void setNewDataResult(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b72e9df9.gjm(7, "org.dsi.ifc.online.DSIOnlineTrafficListener", 1524584396, -645498553), 7, objectArray);
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
    public void getNewSession() {
        try {
            this.h.invoke(this, LR5b72e9df9.gjm(8, "org.dsi.ifc.online.DSIOnlineTrafficListener", 1092027528, 17), 8, ZOA);
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
    public void setTimeoutForFallbackResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b72e9df9.gjm(9, "org.dsi.ifc.online.DSIOnlineTrafficListener", 1586266332, 1687814400), 9, objectArray);
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
    public void getNewFCDInformationResult(FCDPosition fCDPosition) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = fCDPosition;
            this.h.invoke(this, LR5b72e9df9.gjm(10, "org.dsi.ifc.online.DSIOnlineTrafficListener", -518014615, -794014703), 10, objectArray);
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
    public void getInventoryResult(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5b72e9df9.gjm(11, "org.dsi.ifc.online.DSIOnlineTrafficListener", -668193904, -633848249), 11, objectArray);
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
    public void getDownloadFileResult(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5b72e9df9.gjm(12, "org.dsi.ifc.online.DSIOnlineTrafficListener", -862205452, -633848249), 12, objectArray);
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

