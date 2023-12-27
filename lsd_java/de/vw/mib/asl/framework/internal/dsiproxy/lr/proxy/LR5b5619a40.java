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
import org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.audio.DSIAudioManagementListener;
import org.dsi.ifc.global.DateTime;

public final class LR5b5619a40
extends AbstractProxy
implements DSIAudioManagementListener,
DSIAsiaTrafficInfoMenuListener {
    private static final Method[] JMS = new Method[22];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5b5619a40(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5b5619a40.gjm(0, "org.dsi.ifc.audio.DSIAudioManagementListener", 2068128299, 1043255048), 0, objectArray);
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
    public void fadedIn(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b5619a40.gjm(1, "org.dsi.ifc.audio.DSIAudioManagementListener", 575402686, 1676164096), 1, objectArray);
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
    public void pauseConnection(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b5619a40.gjm(2, "org.dsi.ifc.audio.DSIAudioManagementListener", -385382302, 1676164096), 2, objectArray);
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
    public void updateActiveConnection(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5b5619a40.gjm(3, "org.dsi.ifc.audio.DSIAudioManagementListener", -501759216, 1043255048), 3, objectArray);
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
    public void updateActiveEntertainmentConnection(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5b5619a40.gjm(4, "org.dsi.ifc.audio.DSIAudioManagementListener", -857991035, 1043255048), 4, objectArray);
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
    public void startConnection(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b5619a40.gjm(5, "org.dsi.ifc.audio.DSIAudioManagementListener", 1435437123, 1676164096), 5, objectArray);
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
    public void stopConnection(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b5619a40.gjm(6, "org.dsi.ifc.audio.DSIAudioManagementListener", -171267252, 1676164096), 6, objectArray);
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
    public void updateAMAvailable(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5b5619a40.gjm(7, "org.dsi.ifc.audio.DSIAudioManagementListener", 162956268, 1043255048), 7, objectArray);
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
    public void responseVolumelock(int n, int n2, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5b5619a40.gjm(8, "org.dsi.ifc.audio.DSIAudioManagementListener", -605793863, 252948384), 8, objectArray);
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
            this.h.invoke(this, LR5b5619a40.gjm(9, "org.dsi.ifc.audio.DSIAudioManagementListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateActiveInterrupts(Interrupt[] interruptArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = interruptArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b5619a40.gjm(10, "org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener", 1949788640, -1848896417), 10, objectArray);
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
    public void updateTrafficType(TrafficInformation[] trafficInformationArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = trafficInformationArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b5619a40.gjm(11, "org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener", -1020751782, 1540874370), 11, objectArray);
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
    public void updatePrefecture(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b5619a40.gjm(12, "org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener", 331000923, -645498553), 12, objectArray);
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
    public void updateProbeDataSetting(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b5619a40.gjm(13, "org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener", -727571819, -1665395196), 13, objectArray);
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
    public void updateFrequency(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b5619a40.gjm(14, "org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener", 138522179, 1676164096), 14, objectArray);
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
    public void updateReceptionStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b5619a40.gjm(15, "org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener", 234537887, 1676164096), 15, objectArray);
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
    public void updateReceptionDate(DateTime dateTime, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = dateTime;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b5619a40.gjm(16, "org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener", 1238087319, -721724903), 16, objectArray);
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
    public void requestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = resourceInformation;
            this.h.invoke(this, LR5b5619a40.gjm(17, "org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener", 85267463, -1427738526), 17, objectArray);
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
    public void requestTrafficInformationDetailsResponse(int n, TrafficInformationDetails[] trafficInformationDetailsArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = trafficInformationDetailsArray;
            this.h.invoke(this, LR5b5619a40.gjm(18, "org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener", 1513590687, 1497062907), 18, objectArray);
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
    public void updateReceivableStations(TunerData[] tunerDataArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tunerDataArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b5619a40.gjm(19, "org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener", 428836069, -798997638), 19, objectArray);
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
    public void setLanguageResponse(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5b5619a40.gjm(20, "org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener", -1338868692, -1653679357), 20, objectArray);
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

