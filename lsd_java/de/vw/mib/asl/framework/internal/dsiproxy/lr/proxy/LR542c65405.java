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
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbDataResolutionListener;
import org.dsi.ifc.organizer.DSIAdbEditListener;
import org.dsi.ifc.organizer.DataSet;

public final class LR542c65405
extends AbstractProxy
implements DSIAdbDataResolutionListener,
DSIAdbEditListener {
    private static final Method[] JMS = new Method[18];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR542c65405(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void resolveMailAddressResult(int n, DataSet[] dataSetArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dataSetArray;
            this.h.invoke(this, LR542c65405.gjm(0, "org.dsi.ifc.organizer.DSIAdbDataResolutionListener", -1555370923, 1431703443), 0, objectArray);
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
    public void resolvePhoneNumbersResult(int n, DataSet[] dataSetArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dataSetArray;
            this.h.invoke(this, LR542c65405.gjm(1, "org.dsi.ifc.organizer.DSIAdbDataResolutionListener", -1162519787, 1431703443), 1, objectArray);
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
            this.h.invoke(this, LR542c65405.gjm(2, "org.dsi.ifc.organizer.DSIAdbDataResolutionListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateNewEntryAvailable(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR542c65405.gjm(3, "org.dsi.ifc.organizer.DSIAdbEditListener", -474733965, -1665395196), 3, objectArray);
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
    public void updateNewPublicProfileEntryAvailable(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR542c65405.gjm(4, "org.dsi.ifc.organizer.DSIAdbEditListener", 1969305193, -1665395196), 4, objectArray);
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
    public void updateNewTopDestinationEntryAvailable(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR542c65405.gjm(5, "org.dsi.ifc.organizer.DSIAdbEditListener", 2083530337, -1665395196), 5, objectArray);
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
    public void updateNewPublicProfileTopDestEntryAvailable(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR542c65405.gjm(6, "org.dsi.ifc.organizer.DSIAdbEditListener", -1167750287, -1665395196), 6, objectArray);
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
    public void insertEntryResult(int n, AdbEntry adbEntry) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = adbEntry;
            this.h.invoke(this, LR542c65405.gjm(7, "org.dsi.ifc.organizer.DSIAdbEditListener", 726221388, 1349647600), 7, objectArray);
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
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = adbEntryArray;
            this.h.invoke(this, LR542c65405.gjm(8, "org.dsi.ifc.organizer.DSIAdbEditListener", -1941191802, -1835876800), 8, objectArray);
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
    public void getEntryDataSetsResult(int n, DataSet[] dataSetArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dataSetArray;
            this.h.invoke(this, LR542c65405.gjm(9, "org.dsi.ifc.organizer.DSIAdbEditListener", 1762093003, 1431703443), 9, objectArray);
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
    public void changeEntryResult(int n, AdbEntry adbEntry) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = adbEntry;
            this.h.invoke(this, LR542c65405.gjm(10, "org.dsi.ifc.organizer.DSIAdbEditListener", -729337845, 1349647600), 10, objectArray);
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
    public void copyEntryResult(int n, AdbEntry adbEntry) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = adbEntry;
            this.h.invoke(this, LR542c65405.gjm(11, "org.dsi.ifc.organizer.DSIAdbEditListener", -280080696, 1349647600), 11, objectArray);
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
    public void deleteEntriesResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR542c65405.gjm(12, "org.dsi.ifc.organizer.DSIAdbEditListener", 1460093623, 1687814400), 12, objectArray);
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
    public void setSpeedDialResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR542c65405.gjm(13, "org.dsi.ifc.organizer.DSIAdbEditListener", 122267784, 1687814400), 13, objectArray);
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
    public void deleteSpeedDialResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR542c65405.gjm(14, "org.dsi.ifc.organizer.DSIAdbEditListener", -1633382307, 1687814400), 14, objectArray);
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
    public void getEntryByReferenceIdResult(int n, AdbEntry adbEntry) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = adbEntry;
            this.h.invoke(this, LR542c65405.gjm(15, "org.dsi.ifc.organizer.DSIAdbEditListener", 96527171, 1349647600), 15, objectArray);
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
    public void updateNewOnlineDestinationEntryAvailable(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR542c65405.gjm(16, "org.dsi.ifc.organizer.DSIAdbEditListener", 1889447495, -1665395196), 16, objectArray);
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

