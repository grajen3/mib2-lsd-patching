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
import org.dsi.ifc.navservicesapi.AddressDataSDIS;
import org.dsi.ifc.navservicesapi.DSINavAsiaRemoteHMIListener;
import org.dsi.ifc.navservicesapi.DSINavAsiaSDISListener;

public final class LR549924bae
extends AbstractProxy
implements DSINavAsiaRemoteHMIListener,
DSINavAsiaSDISListener {
    private static final Method[] JMS = new Method[13];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR549924bae(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateDayNightView(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR549924bae.gjm(0, "org.dsi.ifc.navservicesapi.DSINavAsiaRemoteHMIListener", 2145170545, 1676164096), 0, objectArray);
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
    public void updateCurrentCityAndStreet(String string, String string2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR549924bae.gjm(1, "org.dsi.ifc.navservicesapi.DSINavAsiaRemoteHMIListener", 1958199094, -1028403557), 1, objectArray);
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
    public void updateDestination(double[] dArray, double[] dArray2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = dArray;
            objectArray[1] = dArray2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR549924bae.gjm(2, "org.dsi.ifc.navservicesapi.DSINavAsiaRemoteHMIListener", -91367578, -1706191864), 2, objectArray);
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
    public void updateDestinationDistanceAndTime(double[] dArray, int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = dArray;
            objectArray[1] = nArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR549924bae.gjm(3, "org.dsi.ifc.navservicesapi.DSINavAsiaRemoteHMIListener", -1087407204, 1397658632), 3, objectArray);
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
    public void updatePositionInfo(double d2, double d3, double d4, double d5, double d6, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(d2);
            objectArray[1] = RuntimeUtil.valueOf(d3);
            objectArray[2] = RuntimeUtil.valueOf(d4);
            objectArray[3] = RuntimeUtil.valueOf(d5);
            objectArray[4] = RuntimeUtil.valueOf(d6);
            objectArray[5] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR549924bae.gjm(4, "org.dsi.ifc.navservicesapi.DSINavAsiaRemoteHMIListener", 1432296136, 293586473), 4, objectArray);
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
    public void updateNavigationState(boolean bl, boolean bl2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR549924bae.gjm(5, "org.dsi.ifc.navservicesapi.DSINavAsiaRemoteHMIListener", 1236122486, -1263655781), 5, objectArray);
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
            this.h.invoke(this, LR549924bae.gjm(6, "org.dsi.ifc.navservicesapi.DSINavAsiaRemoteHMIListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateCarPosition(double d2, double d3, int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(d2);
            objectArray[1] = RuntimeUtil.valueOf(d3);
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            objectArray[4] = RuntimeUtil.valueOf(n3);
            objectArray[5] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR549924bae.gjm(7, "org.dsi.ifc.navservicesapi.DSINavAsiaSDISListener", 162741271, -1551912362), 7, objectArray);
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
    public void updateRouteGuidanceActive(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR549924bae.gjm(8, "org.dsi.ifc.navservicesapi.DSINavAsiaSDISListener", 329410326, -1665395196), 8, objectArray);
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
    public void updateDestinationInfo(AddressDataSDIS[] addressDataSDISArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = addressDataSDISArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR549924bae.gjm(9, "org.dsi.ifc.navservicesapi.DSINavAsiaSDISListener", 1209831377, 351368437), 9, objectArray);
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
    public void updateNextDestinationInfo(int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR549924bae.gjm(10, "org.dsi.ifc.navservicesapi.DSINavAsiaSDISListener", 1439802703, -448335035), 10, objectArray);
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
    public void startGuidanceToDestinationsResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR549924bae.gjm(11, "org.dsi.ifc.navservicesapi.DSINavAsiaSDISListener", -325344475, 1687814400), 11, objectArray);
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

