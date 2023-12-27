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
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.organizer.DSIAdbVCardExchange;

public final class LR5ea66fe38
extends AbstractProxy
implements DSIAdbUserProfile,
DSIAdbVCardExchange {
    private static final Method[] JMS = new Method[27];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5ea66fe38(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void downloadToProfile(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5ea66fe38.gjm(0, "org.dsi.ifc.organizer.DSIAdbUserProfile", 2069194993, 1687814400), 0, objectArray);
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
    public void restartDownload() {
        try {
            this.h.invoke(this, LR5ea66fe38.gjm(1, "org.dsi.ifc.organizer.DSIAdbUserProfile", 743367804, 17), 1, ZOA);
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
    public void setProfileName(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5ea66fe38.gjm(2, "org.dsi.ifc.organizer.DSIAdbUserProfile", -2026319750, -633848249), 2, objectArray);
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
    public void deleteProfiles(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR5ea66fe38.gjm(3, "org.dsi.ifc.organizer.DSIAdbUserProfile", 717087817, 3523), 3, objectArray);
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
    public void commonEntryCount() {
        try {
            this.h.invoke(this, LR5ea66fe38.gjm(4, "org.dsi.ifc.organizer.DSIAdbUserProfile", 2108567611, 17), 4, ZOA);
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
    public void entryMeter() {
        try {
            this.h.invoke(this, LR5ea66fe38.gjm(5, "org.dsi.ifc.organizer.DSIAdbUserProfile", -1406347383, 17), 5, ZOA);
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
    public void setPairingCode(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5ea66fe38.gjm(6, "org.dsi.ifc.organizer.DSIAdbUserProfile", -2008456022, -633848249), 6, objectArray);
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
    public void setHomeId(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5ea66fe38.gjm(7, "org.dsi.ifc.organizer.DSIAdbUserProfile", -778366192, -238538240), 7, objectArray);
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
    public void setSOSButton(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5ea66fe38.gjm(8, "org.dsi.ifc.organizer.DSIAdbUserProfile", -600577886, -1653679357), 8, objectArray);
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
            this.h.invoke(this, LR5ea66fe38.gjm(9, "org.dsi.ifc.organizer.DSIAdbUserProfile", -501696838, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR5ea66fe38.gjm(10, "org.dsi.ifc.organizer.DSIAdbUserProfile", -501696838, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR5ea66fe38.gjm(11, "org.dsi.ifc.organizer.DSIAdbUserProfile", -501696838, -864245041), -1, objectArray);
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
            this.h.invoke(this, LR5ea66fe38.gjm(12, "org.dsi.ifc.organizer.DSIAdbUserProfile", 1300919239, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR5ea66fe38.gjm(13, "org.dsi.ifc.organizer.DSIAdbUserProfile", 1300919239, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR5ea66fe38.gjm(14, "org.dsi.ifc.organizer.DSIAdbUserProfile", 1300919239, -864245041), -1, objectArray);
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
    public void importVCard(ResourceLocator[] resourceLocatorArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceLocatorArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5ea66fe38.gjm(15, "org.dsi.ifc.organizer.DSIAdbVCardExchange", 1994586454, -619545686), 15, objectArray);
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
    public void exportVCard(int n, String string, long[] lArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = lArray;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5ea66fe38.gjm(16, "org.dsi.ifc.organizer.DSIAdbVCardExchange", -940339582, 1395289481), 16, objectArray);
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
    public void exportSpellerVCard(int n, int n2, String string, long[] lArray, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = string;
            objectArray[3] = lArray;
            objectArray[4] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5ea66fe38.gjm(17, "org.dsi.ifc.organizer.DSIAdbVCardExchange", 436927924, -290076452), 17, objectArray);
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
    public void createVCard(int n, long[] lArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = lArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5ea66fe38.gjm(18, "org.dsi.ifc.organizer.DSIAdbVCardExchange", 2138308577, 517707016), 18, objectArray);
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
    public void parseVCard(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5ea66fe38.gjm(19, "org.dsi.ifc.organizer.DSIAdbVCardExchange", 678754244, -633848249), 19, objectArray);
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
    public void requestAbort(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5ea66fe38.gjm(20, "org.dsi.ifc.organizer.DSIAdbVCardExchange", 1451556683, 1687814400), 20, objectArray);
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

