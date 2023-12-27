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
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIDataConnection;
import org.dsi.ifc.networking.DSIWLAN;
import org.dsi.ifc.networking.Profile;

public final class LR5658b7e37
extends AbstractProxy
implements DSIWLAN,
DSIDataConnection {
    private static final Method[] JMS = new Method[24];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5658b7e37(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setRole(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5658b7e37.gjm(0, "org.dsi.ifc.networking.DSIWLAN", 1840402294, 1687814400), 0, objectArray);
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
    public void factoryReset() {
        try {
            this.h.invoke(this, LR5658b7e37.gjm(1, "org.dsi.ifc.networking.DSIWLAN", -636211313, 17), 1, ZOA);
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
    public void setRFActive(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5658b7e37.gjm(2, "org.dsi.ifc.networking.DSIWLAN", 825975204, -1653679357), 2, objectArray);
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
    public void setProfile(Profile profile) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = profile;
            this.h.invoke(this, LR5658b7e37.gjm(3, "org.dsi.ifc.networking.DSIWLAN", 1544932766, 169078964), 3, objectArray);
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
    public void requestNetworkSearch(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5658b7e37.gjm(4, "org.dsi.ifc.networking.DSIWLAN", -1661910889, 1676164096), 4, objectArray);
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
    public void requestAbortSearch() {
        try {
            this.h.invoke(this, LR5658b7e37.gjm(5, "org.dsi.ifc.networking.DSIWLAN", 1579766822, 17), 5, ZOA);
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
    public void requestConnectNetwork(String string, String string2, String string3, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = string3;
            objectArray[3] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5658b7e37.gjm(6, "org.dsi.ifc.networking.DSIWLAN", -937895705, 1865490124), 6, objectArray);
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
    public void requestDisconnectNetwork(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR5658b7e37.gjm(7, "org.dsi.ifc.networking.DSIWLAN", -1731070609, -412271469), 7, objectArray);
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
    public void requestDeleteTrustedNetwork(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR5658b7e37.gjm(8, "org.dsi.ifc.networking.DSIWLAN", 1719641236, -412271469), 8, objectArray);
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
    public void requestActivateWps(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5658b7e37.gjm(9, "org.dsi.ifc.networking.DSIWLAN", 760188635, 1043255048), 9, objectArray);
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
    public void requestCancelWPS() {
        try {
            this.h.invoke(this, LR5658b7e37.gjm(10, "org.dsi.ifc.networking.DSIWLAN", -2038939188, 17), 10, ZOA);
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
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5658b7e37.gjm(11, "org.dsi.ifc.networking.DSIWLAN", -501696838, -904616957), -1, objectArray);
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
    public void setNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5658b7e37.gjm(12, "org.dsi.ifc.networking.DSIWLAN", -501696838, 1805755651), -1, objectArray);
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
    public void setNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR5658b7e37.gjm(13, "org.dsi.ifc.networking.DSIWLAN", -501696838, -864245041), -1, objectArray);
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
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5658b7e37.gjm(14, "org.dsi.ifc.networking.DSIWLAN", 1300919239, -904616957), -1, objectArray);
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
    public void clearNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5658b7e37.gjm(15, "org.dsi.ifc.networking.DSIWLAN", 1300919239, 1805755651), -1, objectArray);
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
    public void clearNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR5658b7e37.gjm(16, "org.dsi.ifc.networking.DSIWLAN", 1300919239, -864245041), -1, objectArray);
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
    public void forceDisconnectRequest() {
        try {
            this.h.invoke(this, LR5658b7e37.gjm(17, "org.dsi.ifc.networking.DSIDataConnection", 0x1D15D115, 17), 17, ZOA);
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

