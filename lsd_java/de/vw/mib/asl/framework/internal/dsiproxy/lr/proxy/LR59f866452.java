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
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.DSIIconExtractorListener;
import org.dsi.ifc.iconhandling.TextRenderingInfo;
import org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorderListener;

public final class LR59f866452
extends AbstractProxy
implements DSIInfotainmentRecorderListener,
DSIIconExtractorListener {
    private static final Method[] JMS = new Method[21];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR59f866452(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateEnabledTriggers(boolean[] blArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = blArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f866452.gjm(0, "org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorderListener", -2009675386, -748995840), 0, objectArray);
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
            this.h.invoke(this, LR59f866452.gjm(1, "org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorderListener", -1459926625, 1276482132), -1, objectArray);
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
    public void resourceIdForTMCEventIcon(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(2, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", 511530365, -1202513960), 2, objectArray);
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
    public void resourceIdForPOIIcon(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(3, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", -118931995, -1202513960), 3, objectArray);
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
    public void renderingInformationForRoadIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceLocator;
            objectArray[1] = textRenderingInfo;
            this.h.invoke(this, LR59f866452.gjm(4, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", -149275035, 461999728), 4, objectArray);
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
    public void resourceIdForTargetIcon(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(5, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", 2144502070, -1202513960), 5, objectArray);
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
    public void resourceIdForRoadClassIcon(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(6, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", -427163140, -1202513960), 6, objectArray);
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
    public void resourceIdForTrafficRegulationIcon(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(7, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", -1253145599, -1202513960), 7, objectArray);
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
    public void renderingInformationForExitIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceLocator;
            objectArray[1] = textRenderingInfo;
            this.h.invoke(this, LR59f866452.gjm(8, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", -182096119, 461999728), 8, objectArray);
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
    public void resourceIdForAdditionalIcon(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(9, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", 367959250, -1202513960), 9, objectArray);
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
    public void resourceIdForCountryIcon(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(10, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", 1144860351, -1202513960), 10, objectArray);
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
    public void renderingInformationForExitIconWithVariant(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceLocator;
            objectArray[1] = textRenderingInfo;
            this.h.invoke(this, LR59f866452.gjm(11, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", -1274852659, 461999728), 11, objectArray);
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
    public void iconResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f866452.gjm(12, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", 1811208415, 1687814400), 12, objectArray);
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
    public void resourceIdForTrafficRegulationIconWithSubIndex(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(13, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", 764682885, -1202513960), 13, objectArray);
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
    public void setBrandIconStyleResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59f866452.gjm(14, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", 1696266667, 1687814400), 14, objectArray);
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
    public void resourceIdForTrafficSourceIconResult(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(15, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", -1554236608, -1202513960), 15, objectArray);
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
    public void resourceIdForAreaWarningIconResult(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(16, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", -1173509632, -1202513960), 16, objectArray);
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
    public void resourceIdForAdditionalTurnListIconResult(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(17, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", 1839260300, -1202513960), 17, objectArray);
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
    public void resourceIdForComposedPOIIconResult(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(18, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", 55319218, -1202513960), 18, objectArray);
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
    public void resourceIdForPOIIconFromRawDataResult(ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocator;
            this.h.invoke(this, LR59f866452.gjm(19, "org.dsi.ifc.iconhandling.DSIIconExtractorListener", 1468795840, -1202513960), 19, objectArray);
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

