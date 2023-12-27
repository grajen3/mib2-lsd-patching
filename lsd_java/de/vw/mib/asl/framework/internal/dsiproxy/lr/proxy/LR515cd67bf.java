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
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;
import org.dsi.ifc.kombisync.DSIKombiSync;
import org.dsi.ifc.kombisync.MMIDisplayRequest;
import org.dsi.ifc.kombisync.MMIDisplayStatus;
import org.dsi.ifc.kombisync.MMIPopupRequest;
import org.dsi.ifc.kombisync.MenuState;

public final class LR515cd67bf
extends AbstractProxy
implements DSIKombiPictureServer,
DSIKombiSync {
    private static final Method[] JMS = new Method[27];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR515cd67bf(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setKombiHmiReady() {
        try {
            this.h.invoke(this, LR515cd67bf.gjm(0, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", -501298299, 17), 0, ZOA);
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
    public void responseCoverArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = resourceLocator;
            this.h.invoke(this, LR515cd67bf.gjm(1, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", 44672305, -1453520460), 1, objectArray);
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
    public void responseStationArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = resourceLocator;
            this.h.invoke(this, LR515cd67bf.gjm(2, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", 626717199, -1453520460), 2, objectArray);
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
    public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = resourceLocator;
            this.h.invoke(this, LR515cd67bf.gjm(3, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", 242654363, 1916861332), 3, objectArray);
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
    public void responseActiveCallPictureInstance(int n, int n2, int n3, ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = resourceLocator;
            this.h.invoke(this, LR515cd67bf.gjm(4, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", -1010478913, 1776832904), 4, objectArray);
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
    public void responseDynamicIcon(int n, int n2, boolean bl, ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            objectArray[3] = resourceLocator;
            this.h.invoke(this, LR515cd67bf.gjm(5, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", -856889196, 986525984), 5, objectArray);
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
    public void responseAdbContactPicture(long l, int n, int n2, ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = resourceLocator;
            this.h.invoke(this, LR515cd67bf.gjm(6, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", 1900537580, -166296696), 6, objectArray);
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
    public void responseInternalAddressID(long l, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR515cd67bf.gjm(7, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", 103730386, -883163127), 7, objectArray);
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
    public void responsePictureServerAbilities(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR515cd67bf.gjm(8, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", 2113556235, 1687814400), 8, objectArray);
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
    public void responsePictureStream(int n, short s, short s2, int n2, int n3, byte[] byArray) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(s);
            objectArray[2] = RuntimeUtil.valueOf(s2);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            objectArray[4] = RuntimeUtil.valueOf(n3);
            objectArray[5] = byArray;
            this.h.invoke(this, LR515cd67bf.gjm(9, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", -768484047, -1245520798), 9, objectArray);
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
            this.h.invoke(this, LR515cd67bf.gjm(10, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", -501696838, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR515cd67bf.gjm(11, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", -501696838, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR515cd67bf.gjm(12, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", -501696838, -864245041), -1, objectArray);
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
            this.h.invoke(this, LR515cd67bf.gjm(13, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", 1300919239, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR515cd67bf.gjm(14, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", 1300919239, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR515cd67bf.gjm(15, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServer", 1300919239, -864245041), -1, objectArray);
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
    public void setHMIIsReady(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR515cd67bf.gjm(16, "org.dsi.ifc.kombisync.DSIKombiSync", 1816829296, -1653679357), 16, objectArray);
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
    public void setMMIDisplayStatus(MMIDisplayStatus mMIDisplayStatus) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = mMIDisplayStatus;
            this.h.invoke(this, LR515cd67bf.gjm(17, "org.dsi.ifc.kombisync.DSIKombiSync", 47639433, 151219309), 17, objectArray);
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
    public void setMMIDisplayRequest(MMIDisplayRequest mMIDisplayRequest) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = mMIDisplayRequest;
            this.h.invoke(this, LR515cd67bf.gjm(18, "org.dsi.ifc.kombisync.DSIKombiSync", -916131483, -1562872078), 18, objectArray);
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
    public void setMenuState(MenuState menuState) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = menuState;
            this.h.invoke(this, LR515cd67bf.gjm(19, "org.dsi.ifc.kombisync.DSIKombiSync", -1518987520, 2127803989), 19, objectArray);
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
    public void setMMIPopupRequest(MMIPopupRequest mMIPopupRequest) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = mMIPopupRequest;
            this.h.invoke(this, LR515cd67bf.gjm(20, "org.dsi.ifc.kombisync.DSIKombiSync", 1606407937, 2018880248), 20, objectArray);
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

