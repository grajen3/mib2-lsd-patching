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
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener;

public final class LR5790ae19d
extends AbstractProxy
implements DSIFastListScrollingNavigationListener,
DSIFastListScrollingTelephoneListener {
    private static final Method[] JMS = new Method[14];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5790ae19d(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void indicationNavBook(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
        try {
            Object[] objectArray = this.p.borrowArray(11);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = RuntimeUtil.valueOf(l);
            objectArray[5] = RuntimeUtil.valueOf(n5);
            objectArray[6] = RuntimeUtil.valueOf(n6);
            objectArray[7] = RuntimeUtil.valueOf(n7);
            objectArray[8] = RuntimeUtil.valueOf(n8);
            objectArray[9] = RuntimeUtil.valueOf(n9);
            objectArray[10] = RuntimeUtil.valueOf(n10);
            this.h.invoke(this, LR5790ae19d.gjm(0, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener", 624720455, -1021381169), 0, objectArray);
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
    public void indicationGetInitialsNavigation(int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR5790ae19d.gjm(1, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener", -1839119888, -448335035), 1, objectArray);
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
    public void indicationNotifyLastDestListPUSH(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR5790ae19d.gjm(2, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener", -1975027738, -647458158), 2, objectArray);
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
    public void indicationNotifyFavoriteDestListPUSH(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR5790ae19d.gjm(3, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener", 279668463, -647458158), 3, objectArray);
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
    public void indicationNotifyCurrentListSizeNavigation(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR5790ae19d.gjm(4, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener", -1129032429, -647458158), 4, objectArray);
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
    public void indicationNavBookJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = arrayHeaderArray;
            this.h.invoke(this, LR5790ae19d.gjm(5, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener", -1691055833, -1575918000), 5, objectArray);
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
            this.h.invoke(this, LR5790ae19d.gjm(6, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener", -1459926625, 1276482132), -1, objectArray);
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
    public void indicationPhonebook(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
        try {
            Object[] objectArray = this.p.borrowArray(11);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = RuntimeUtil.valueOf(l);
            objectArray[5] = RuntimeUtil.valueOf(n5);
            objectArray[6] = RuntimeUtil.valueOf(n6);
            objectArray[7] = RuntimeUtil.valueOf(n7);
            objectArray[8] = RuntimeUtil.valueOf(n8);
            objectArray[9] = RuntimeUtil.valueOf(n9);
            objectArray[10] = RuntimeUtil.valueOf(n10);
            this.h.invoke(this, LR5790ae19d.gjm(7, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener", -796018135, -1021381169), 7, objectArray);
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
    public void indicationGetInitialsTelephone(int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR5790ae19d.gjm(8, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener", 1344053323, -448335035), 8, objectArray);
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
    public void indicationNotifyFavoriteListPush(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR5790ae19d.gjm(9, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener", -297870189, -647458158), 9, objectArray);
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
    public void indicationNotifyCombinedNumbersPush(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR5790ae19d.gjm(10, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener", -1346732003, -647458158), 10, objectArray);
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
    public void indicationNotifyCurrentListSizeTelephone(boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR5790ae19d.gjm(11, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener", -423919804, -647458158), 11, objectArray);
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
    public void indicationPhonebookJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = arrayHeaderArray;
            this.h.invoke(this, LR5790ae19d.gjm(12, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener", -960978328, -1575918000), 12, objectArray);
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

