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
import org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone;
import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public final class LR54dc552fd
extends AbstractProxy
implements DSIFastListScrollingTelephone,
DSIFastListScrollingNavigation {
    private static final Method[] JMS = new Method[36];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR54dc552fd(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void pushFunctionAvailabilityTelephone(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54dc552fd.gjm(0, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", 1817787216, 1687814400), 0, objectArray);
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
    public void pushMOSTOperationStateTelephone(short s) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(s);
            this.h.invoke(this, LR54dc552fd.gjm(1, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", -766011319, -242842362), 1, objectArray);
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
    public void responsePhonebook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        try {
            Object[] objectArray = this.p.borrowArray(13);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = RuntimeUtil.valueOf(n5);
            objectArray[5] = RuntimeUtil.valueOf(l);
            objectArray[6] = RuntimeUtil.valueOf(n6);
            objectArray[7] = RuntimeUtil.valueOf(n7);
            objectArray[8] = RuntimeUtil.valueOf(n8);
            objectArray[9] = RuntimeUtil.valueOf(n9);
            objectArray[10] = RuntimeUtil.valueOf(n10);
            objectArray[11] = RuntimeUtil.valueOf(n11);
            objectArray[12] = RuntimeUtil.valueOf(n12);
            this.h.invoke(this, LR54dc552fd.gjm(2, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", -1957115825, -517043040), 2, objectArray);
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
    public void responsePhonebookArray(int n, int n2, DataPhonebook[] dataPhonebookArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = dataPhonebookArray;
            this.h.invoke(this, LR54dc552fd.gjm(3, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", 1485590839, 686300067), 3, objectArray);
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
    public void responseGetInitialsTelephone(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = dataInitialsArray;
            this.h.invoke(this, LR54dc552fd.gjm(4, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", -1243696234, 1075837853), 4, objectArray);
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
    public void pushupdateFavoriteList(int n, int n2, DataFavoriteList[] dataFavoriteListArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = dataFavoriteListArray;
            this.h.invoke(this, LR54dc552fd.gjm(5, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", -767116260, -1554131600), 5, objectArray);
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
    public void pushCombinedNumbers(int n, int n2, DataCombinedNumbers[] dataCombinedNumbersArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = dataCombinedNumbersArray;
            this.h.invoke(this, LR54dc552fd.gjm(6, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", -2135984468, 721347137), 6, objectArray);
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
    public void pushCurrentListSizeTelephone(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR54dc552fd.gjm(7, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", 989882864, 1043255048), 7, objectArray);
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
    public void responsePhonebookJobs(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR54dc552fd.gjm(8, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", 28182249, 1043255048), 8, objectArray);
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
    public void responseNotifyCombinedNumbersPush(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54dc552fd.gjm(9, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", 1789906814, -1653679357), 9, objectArray);
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
    public void responseNotifyCurrentListSizes(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54dc552fd.gjm(10, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", -1702707988, -1653679357), 10, objectArray);
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
    public void responseNotifyFavoriteListPush(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54dc552fd.gjm(11, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", 335284329, -1653679357), 11, objectArray);
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
            this.h.invoke(this, LR54dc552fd.gjm(12, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", -501696838, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR54dc552fd.gjm(13, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", -501696838, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR54dc552fd.gjm(14, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", -501696838, -864245041), -1, objectArray);
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
            this.h.invoke(this, LR54dc552fd.gjm(15, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", 1300919239, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR54dc552fd.gjm(16, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", 1300919239, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR54dc552fd.gjm(17, "org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone", 1300919239, -864245041), -1, objectArray);
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
    public void pushFunctionAvailabilityNavigation(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54dc552fd.gjm(18, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", -154727041, 1687814400), 18, objectArray);
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
    public void pushMOSTOperationStateNavigation(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR54dc552fd.gjm(19, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", 1352028337, 1687814400), 19, objectArray);
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
    public void responseNavBook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        try {
            Object[] objectArray = this.p.borrowArray(13);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = RuntimeUtil.valueOf(n5);
            objectArray[5] = RuntimeUtil.valueOf(l);
            objectArray[6] = RuntimeUtil.valueOf(n6);
            objectArray[7] = RuntimeUtil.valueOf(n7);
            objectArray[8] = RuntimeUtil.valueOf(n8);
            objectArray[9] = RuntimeUtil.valueOf(n9);
            objectArray[10] = RuntimeUtil.valueOf(n10);
            objectArray[11] = RuntimeUtil.valueOf(n11);
            objectArray[12] = RuntimeUtil.valueOf(n12);
            this.h.invoke(this, LR54dc552fd.gjm(20, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", -1602657910, -517043040), 20, objectArray);
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
    public void responseNavBookArray(int n, int n2, DataAddress[] dataAddressArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = dataAddressArray;
            this.h.invoke(this, LR54dc552fd.gjm(21, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", 1674582568, 1940681915), 21, objectArray);
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
    public void responseGetInitialsNavigation(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = dataInitialsArray;
            this.h.invoke(this, LR54dc552fd.gjm(22, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", -840194809, 1075837853), 22, objectArray);
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
    public void pushLastDestList(int n, int n2, DataAddress[] dataAddressArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = dataAddressArray;
            this.h.invoke(this, LR54dc552fd.gjm(23, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", -986594307, 1940681915), 23, objectArray);
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
    public void pushUpdateFavoriteDestList(int n, int n2, DataAddress[] dataAddressArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = dataAddressArray;
            this.h.invoke(this, LR54dc552fd.gjm(24, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", 877519678, 1940681915), 24, objectArray);
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
    public void pushCurrentListSizeNavigation(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR54dc552fd.gjm(25, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", 133928164, 1043255048), 25, objectArray);
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
    public void responseNavBookJobs(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR54dc552fd.gjm(26, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", -1774432511, 1043255048), 26, objectArray);
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
    public void responseNotifyCurrentListSizesNavigation(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54dc552fd.gjm(27, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", -1908538634, -1653679357), 27, objectArray);
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
    public void responseNotifyFavoriteDestList(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54dc552fd.gjm(28, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", -1683397546, -1653679357), 28, objectArray);
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
    public void responseNotifyLastDestList(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR54dc552fd.gjm(29, "org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation", -1779619810, -1653679357), 29, objectArray);
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

