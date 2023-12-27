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
import org.dsi.ifc.travelguide.DSITravelGuideListener;
import org.dsi.ifc.travelguide.TravelGuideMemoryListElement;
import org.dsi.ifc.travellink.DSITravelLinkCommonListener;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class LR537563288
extends AbstractProxy
implements DSITravelLinkCommonListener,
DSITravelGuideListener {
    private static final Method[] JMS = new Method[7];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR537563288(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateFromApp(int n, GenericPropertyContainer[] genericPropertyContainerArray, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = genericPropertyContainerArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR537563288.gjm(0, "org.dsi.ifc.travellink.DSITravelLinkCommonListener", -2089850749, -1934604269), 0, objectArray);
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
            this.h.invoke(this, LR537563288.gjm(1, "org.dsi.ifc.travellink.DSITravelLinkCommonListener", -1459926625, 1276482132), -1, objectArray);
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
    public void importTravelGuideResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR537563288.gjm(2, "org.dsi.ifc.travelguide.DSITravelGuideListener", 256154240, 1676164096), 2, objectArray);
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
    public void updateTravelGuideMemoryListElement(TravelGuideMemoryListElement travelGuideMemoryListElement, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = travelGuideMemoryListElement;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR537563288.gjm(3, "org.dsi.ifc.travelguide.DSITravelGuideListener", -1187480845, 472772861), 3, objectArray);
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
    public void deleteTravelGuideResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR537563288.gjm(4, "org.dsi.ifc.travelguide.DSITravelGuideListener", -910260559, 1687814400), 4, objectArray);
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
    public void updateTravelGuideMemoryList(TravelGuideMemoryListElement[] travelGuideMemoryListElementArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = travelGuideMemoryListElementArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR537563288.gjm(5, "org.dsi.ifc.travelguide.DSITravelGuideListener", 227025990, -780628192), 5, objectArray);
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

