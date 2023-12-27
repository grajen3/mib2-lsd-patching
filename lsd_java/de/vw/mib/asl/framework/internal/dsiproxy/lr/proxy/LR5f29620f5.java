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
import org.dsi.ifc.kombisync2.DSIKombiSyncListener;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener;

public final class LR5f29620f5
extends AbstractProxy
implements DSIKombiSyncListener,
DSIKOMOGfxStreamSinkListener {
    private static final Method[] JMS = new Method[21];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5f29620f5(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateKombiCommunicationState(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f29620f5.gjm(0, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", 2008009553, -1665395196), 0, objectArray);
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
    public void updateKombiMessageStateDisplayStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f29620f5.gjm(1, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", -1743194014, 1676164096), 1, objectArray);
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
    public void updateKombiMessageStatePopupStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f29620f5.gjm(2, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", -1027576608, 1676164096), 2, objectArray);
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
    public void responseKombiDisplayStatus(DisplayStatus displayStatus) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = displayStatus;
            this.h.invoke(this, LR5f29620f5.gjm(3, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", 975966717, -386125191), 3, objectArray);
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
    public void responseKombiPopupStatus(PopupStatus popupStatus) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = popupStatus;
            this.h.invoke(this, LR5f29620f5.gjm(4, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", -464217457, 309965865), 4, objectArray);
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
    public void updateKombiMessageStateDisplayIdentification(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f29620f5.gjm(5, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", 348789502, 1676164096), 5, objectArray);
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
    public void updateKombiMessageStateDisplayRequestResponse(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f29620f5.gjm(6, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", 1418664788, 1676164096), 6, objectArray);
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
    public void updateKombiMessageStatePopupActionRequest(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f29620f5.gjm(7, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", 856388309, 1676164096), 7, objectArray);
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
    public void updateKombiMessageStatePopupRegisterResponse(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f29620f5.gjm(8, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", 340757393, 1676164096), 8, objectArray);
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
    public void responseKombiDisplayRequestResponse(DisplayRequestResponse displayRequestResponse) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = displayRequestResponse;
            this.h.invoke(this, LR5f29620f5.gjm(9, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", -227475184, 75879518), 9, objectArray);
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
    public void responseKombiDisplayIdentification(DisplayIdentification displayIdentification) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = displayIdentification;
            this.h.invoke(this, LR5f29620f5.gjm(10, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", -1239695530, 1683920002), 10, objectArray);
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
    public void responseKombiPopupRegisterResponse(PopupRegisterRequestResponse popupRegisterRequestResponse) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = popupRegisterRequestResponse;
            this.h.invoke(this, LR5f29620f5.gjm(11, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", -1231015958, -140383835), 11, objectArray);
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
    public void responseKombiPopupActionRequest(PopupActionRequestResponse popupActionRequestResponse) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = popupActionRequestResponse;
            this.h.invoke(this, LR5f29620f5.gjm(12, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", -773030621, 1149447382), 12, objectArray);
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
            this.h.invoke(this, LR5f29620f5.gjm(13, "org.dsi.ifc.kombisync2.DSIKombiSyncListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateGfxState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f29620f5.gjm(14, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener", -154222620, 1676164096), 14, objectArray);
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
    public void updateRequestSync(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f29620f5.gjm(15, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener", -1226072832, 1676164096), 15, objectArray);
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
    public void updateDataRate(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5f29620f5.gjm(16, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener", 143818654, 1676164096), 16, objectArray);
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
    public void setFGLayerResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5f29620f5.gjm(17, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener", -1597321106, 1687814400), 17, objectArray);
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
    public void fadeInResult() {
        try {
            this.h.invoke(this, LR5f29620f5.gjm(18, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener", -1282214574, 17), 18, ZOA);
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
    public void fadeOutResult() {
        try {
            this.h.invoke(this, LR5f29620f5.gjm(19, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener", 1678303553, 17), 19, ZOA);
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

