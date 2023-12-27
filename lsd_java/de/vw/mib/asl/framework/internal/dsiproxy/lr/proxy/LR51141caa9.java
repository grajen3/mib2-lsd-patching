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
import org.dsi.ifc.ddp20.DSIDDP20Listener;
import org.dsi.ifc.ddp20.DisplayStatus;
import org.dsi.ifc.ddp20.VersionInfo;
import org.dsi.ifc.diagnose.DSIComponentProtectionListener;

public final class LR51141caa9
extends AbstractProxy
implements DSIComponentProtectionListener,
DSIDDP20Listener {
    private static final Method[] JMS = new Method[7];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR51141caa9(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void authStringResponse(String string, String string2, byte by) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(by);
            this.h.invoke(this, LR51141caa9.gjm(0, "org.dsi.ifc.diagnose.DSIComponentProtectionListener", -1344406165, 1931103883), 0, objectArray);
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
            this.h.invoke(this, LR51141caa9.gjm(1, "org.dsi.ifc.diagnose.DSIComponentProtectionListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateVersionInfo(VersionInfo versionInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = versionInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR51141caa9.gjm(2, "org.dsi.ifc.ddp20.DSIDDP20Listener", -1844240411, 1949137921), 2, objectArray);
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
    public void updatePowerStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51141caa9.gjm(3, "org.dsi.ifc.ddp20.DSIDDP20Listener", 1140283094, 1676164096), 3, objectArray);
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
    public void updateDisplayStatus(DisplayStatus displayStatus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = displayStatus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR51141caa9.gjm(4, "org.dsi.ifc.ddp20.DSIDDP20Listener", -2147222384, -1565518548), 4, objectArray);
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
    public void updateBufferStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR51141caa9.gjm(5, "org.dsi.ifc.ddp20.DSIDDP20Listener", 818591051, 1676164096), 5, objectArray);
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

