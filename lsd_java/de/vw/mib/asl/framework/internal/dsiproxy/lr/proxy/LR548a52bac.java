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
import org.dsi.ifc.connectedradio.DSIHybridRadioListener;
import org.dsi.ifc.connectedradio.DSIOnlineRadioListener;
import org.dsi.ifc.connectedradio.RadioStation;

public final class LR548a52bac
extends AbstractProxy
implements DSIOnlineRadioListener,
DSIHybridRadioListener {
    private static final Method[] JMS = new Method[26];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR548a52bac(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void profileReset(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR548a52bac.gjm(0, "org.dsi.ifc.connectedradio.DSIOnlineRadioListener", -1689832120, 1676164096), -1, objectArray);
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
    public void profileResetAll(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR548a52bac.gjm(1, "org.dsi.ifc.connectedradio.DSIOnlineRadioListener", 283450095, 1687814400), -1, objectArray);
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
    public void updateProfileState(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR548a52bac.gjm(2, "org.dsi.ifc.connectedradio.DSIOnlineRadioListener", 1184260366, 1043255048), -1, objectArray);
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
    public void profileChanged(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR548a52bac.gjm(3, "org.dsi.ifc.connectedradio.DSIOnlineRadioListener", 1089708026, 1676164096), -1, objectArray);
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
    public void profileCopied(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR548a52bac.gjm(4, "org.dsi.ifc.connectedradio.DSIOnlineRadioListener", 1112303269, 1043255048), -1, objectArray);
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
    public void getRadioStationLogoResult(int n, int n2, RadioStation radioStation, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = radioStation;
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR548a52bac.gjm(5, "org.dsi.ifc.connectedradio.DSIOnlineRadioListener", -1393288405, 1708181102), 5, objectArray);
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
    public void getStreamUrlResult(int n, int n2, RadioStation radioStation) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = radioStation;
            this.h.invoke(this, LR548a52bac.gjm(6, "org.dsi.ifc.connectedradio.DSIOnlineRadioListener", 192913575, -1095261647), 6, objectArray);
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
    public void getMetaInformationResult(int n, int n2, RadioStation radioStation) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = radioStation;
            this.h.invoke(this, LR548a52bac.gjm(7, "org.dsi.ifc.connectedradio.DSIOnlineRadioListener", -1547627294, -1095261647), 7, objectArray);
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
    public void downloadDatabaseResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR548a52bac.gjm(8, "org.dsi.ifc.connectedradio.DSIOnlineRadioListener", -1786339943, 1676164096), 8, objectArray);
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
    public void cancelDownloadDatabaseResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR548a52bac.gjm(9, "org.dsi.ifc.connectedradio.DSIOnlineRadioListener", -1343681467, 1676164096), 9, objectArray);
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
            this.h.invoke(this, LR548a52bac.gjm(10, "org.dsi.ifc.connectedradio.DSIOnlineRadioListener", -1459926625, 1276482132), -1, objectArray);
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
    public void getRadioStationLogoResult(int n, int n2, RadioStation[] radioStationArray, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = radioStationArray;
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR548a52bac.gjm(16, "org.dsi.ifc.connectedradio.DSIHybridRadioListener", -1393288405, -1019722137), 16, objectArray);
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
    public void getOnlineRadioAvailabilityResult(int n, int n2, RadioStation[] radioStationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = radioStationArray;
            this.h.invoke(this, LR548a52bac.gjm(17, "org.dsi.ifc.connectedradio.DSIHybridRadioListener", -1616939730, 471867946), 17, objectArray);
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
    public void indicateRadioStationLogoResult(int n, int n2, RadioStation[] radioStationArray, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = radioStationArray;
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR548a52bac.gjm(18, "org.dsi.ifc.connectedradio.DSIHybridRadioListener", -821869873, -1019722137), 18, objectArray);
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
    public void getStreamResult(int n, int n2, RadioStation radioStation) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = radioStation;
            this.h.invoke(this, LR548a52bac.gjm(19, "org.dsi.ifc.connectedradio.DSIHybridRadioListener", -1460133879, -1095261647), 19, objectArray);
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
    public void startSlideshowResult(int n, int n2, RadioStation radioStation) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = radioStation;
            this.h.invoke(this, LR548a52bac.gjm(20, "org.dsi.ifc.connectedradio.DSIHybridRadioListener", -1634262521, -1095261647), 20, objectArray);
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
    public void stopSlideshowResult(int n, int n2, RadioStation radioStation) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = radioStation;
            this.h.invoke(this, LR548a52bac.gjm(21, "org.dsi.ifc.connectedradio.DSIHybridRadioListener", -23112886, -1095261647), 21, objectArray);
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
    public void updateSlideshow(int n, RadioStation radioStation, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = radioStation;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR548a52bac.gjm(22, "org.dsi.ifc.connectedradio.DSIHybridRadioListener", -627871976, -1097252031), 22, objectArray);
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
    public void updateRadioText(int n, RadioStation radioStation, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = radioStation;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR548a52bac.gjm(23, "org.dsi.ifc.connectedradio.DSIHybridRadioListener", 1947403790, -1097252031), 23, objectArray);
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
    public void cancelGetRadioStationLogoResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR548a52bac.gjm(24, "org.dsi.ifc.connectedradio.DSIHybridRadioListener", 1384339778, 1676164096), 24, objectArray);
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

