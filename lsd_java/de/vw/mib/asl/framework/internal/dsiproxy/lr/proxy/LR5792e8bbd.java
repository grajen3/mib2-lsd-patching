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
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbDataResolution;
import org.dsi.ifc.organizer.DSIAdbEdit;

public final class LR5792e8bbd
extends AbstractProxy
implements DSIAdbEdit,
DSIAdbDataResolution {
    private static final Method[] JMS = new Method[23];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5792e8bbd(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void getEntries(long[] lArray, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = lArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5792e8bbd.gjm(0, "org.dsi.ifc.organizer.DSIAdbEdit", -809308194, -1633563384), 0, objectArray);
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
    public void insertEntry(AdbEntry adbEntry, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = adbEntry;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5792e8bbd.gjm(1, "org.dsi.ifc.organizer.DSIAdbEdit", -1373410824, -1938851384), 1, objectArray);
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
    public void getEntryDataSets(long[] lArray, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = lArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5792e8bbd.gjm(2, "org.dsi.ifc.organizer.DSIAdbEdit", 1827180776, -1633563384), 2, objectArray);
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
    public void changeEntry(AdbEntry adbEntry, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = adbEntry;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5792e8bbd.gjm(3, "org.dsi.ifc.organizer.DSIAdbEdit", 399896987, -1938851384), 3, objectArray);
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
    public void copyEntry(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5792e8bbd.gjm(4, "org.dsi.ifc.organizer.DSIAdbEdit", 1925991768, -238538240), 4, objectArray);
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
    public void deleteEntries(long[] lArray, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = lArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5792e8bbd.gjm(5, "org.dsi.ifc.organizer.DSIAdbEdit", -621613676, -1633563384), 5, objectArray);
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
    public void setSpeedDial(AdbEntry adbEntry) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = adbEntry;
            this.h.invoke(this, LR5792e8bbd.gjm(6, "org.dsi.ifc.organizer.DSIAdbEdit", -1975987207, -1927201080), 6, objectArray);
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
    public void deleteSpeedDial(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5792e8bbd.gjm(7, "org.dsi.ifc.organizer.DSIAdbEdit", 1641132492, 1687814400), 7, objectArray);
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
    public void getEntryByReferenceId(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5792e8bbd.gjm(8, "org.dsi.ifc.organizer.DSIAdbEdit", 138853320, -633848249), 8, objectArray);
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
            this.h.invoke(this, LR5792e8bbd.gjm(9, "org.dsi.ifc.organizer.DSIAdbEdit", -501696838, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR5792e8bbd.gjm(10, "org.dsi.ifc.organizer.DSIAdbEdit", -501696838, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR5792e8bbd.gjm(11, "org.dsi.ifc.organizer.DSIAdbEdit", -501696838, -864245041), -1, objectArray);
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
            this.h.invoke(this, LR5792e8bbd.gjm(12, "org.dsi.ifc.organizer.DSIAdbEdit", 1300919239, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR5792e8bbd.gjm(13, "org.dsi.ifc.organizer.DSIAdbEdit", 1300919239, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR5792e8bbd.gjm(14, "org.dsi.ifc.organizer.DSIAdbEdit", 1300919239, -864245041), -1, objectArray);
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
    public void resolveMailAddresses(String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = stringArray;
            this.h.invoke(this, LR5792e8bbd.gjm(15, "org.dsi.ifc.organizer.DSIAdbDataResolution", -1807500362, -1166448617), 15, objectArray);
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
    public void resolvePhoneNumbers(String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = stringArray;
            this.h.invoke(this, LR5792e8bbd.gjm(16, "org.dsi.ifc.organizer.DSIAdbDataResolution", 2112353977, -1166448617), 16, objectArray);
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

