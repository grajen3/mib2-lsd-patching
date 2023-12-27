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
import org.dsi.ifc.albumbrowser.DSIAlbumBrowser;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.DSIAndroidAuto;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ServiceConfiguration;
import org.dsi.ifc.androidauto.TouchEvent;
import org.dsi.ifc.base.DSIListener;

public final class LR53412a9f7
extends AbstractProxy
implements DSIAndroidAuto,
DSIAlbumBrowser {
    private static final Method[] JMS = new Method[30];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR53412a9f7(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void startService(ServiceConfiguration serviceConfiguration) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = serviceConfiguration;
            this.h.invoke(this, LR53412a9f7.gjm(0, "org.dsi.ifc.androidauto.DSIAndroidAuto", 1749696622, -1399607841), 0, objectArray);
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
    public void postButtonEvent(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53412a9f7.gjm(1, "org.dsi.ifc.androidauto.DSIAndroidAuto", 1031315929, 1676164096), 1, objectArray);
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
    public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = touchEventArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53412a9f7.gjm(2, "org.dsi.ifc.androidauto.DSIAndroidAuto", -796821186, 931194510), 2, objectArray);
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
    public void postRotaryEvent(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53412a9f7.gjm(3, "org.dsi.ifc.androidauto.DSIAndroidAuto", -1633028759, 1687814400), 3, objectArray);
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
    public void setMode(Resource[] resourceArray, AppState[] appStateArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceArray;
            objectArray[1] = appStateArray;
            this.h.invoke(this, LR53412a9f7.gjm(4, "org.dsi.ifc.androidauto.DSIAndroidAuto", -1704243850, 1661976155), 4, objectArray);
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
    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceArray;
            objectArray[1] = appStateArray;
            this.h.invoke(this, LR53412a9f7.gjm(5, "org.dsi.ifc.androidauto.DSIAndroidAuto", -913782451, 1661976155), 5, objectArray);
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
    public void requestNightMode(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR53412a9f7.gjm(6, "org.dsi.ifc.androidauto.DSIAndroidAuto", -2115617535, -1653679357), 6, objectArray);
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
            this.h.invoke(this, LR53412a9f7.gjm(7, "org.dsi.ifc.androidauto.DSIAndroidAuto", -501696838, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR53412a9f7.gjm(8, "org.dsi.ifc.androidauto.DSIAndroidAuto", -501696838, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR53412a9f7.gjm(9, "org.dsi.ifc.androidauto.DSIAndroidAuto", -501696838, -864245041), -1, objectArray);
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
            this.h.invoke(this, LR53412a9f7.gjm(10, "org.dsi.ifc.androidauto.DSIAndroidAuto", 1300919239, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR53412a9f7.gjm(11, "org.dsi.ifc.androidauto.DSIAndroidAuto", 1300919239, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR53412a9f7.gjm(12, "org.dsi.ifc.androidauto.DSIAndroidAuto", 1300919239, -864245041), -1, objectArray);
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
    public void stop() {
        try {
            this.h.invoke(this, LR53412a9f7.gjm(13, "org.dsi.ifc.albumbrowser.DSIAlbumBrowser", 1997157888, 17), 13, ZOA);
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
    public void initializeBrowser(long l, long l2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53412a9f7.gjm(14, "org.dsi.ifc.albumbrowser.DSIAlbumBrowser", -304666105, 739712016), 14, objectArray);
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
    public void deinitializeBrowser() {
        try {
            this.h.invoke(this, LR53412a9f7.gjm(15, "org.dsi.ifc.albumbrowser.DSIAlbumBrowser", -1942140949, 17), 15, ZOA);
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
    public void startSingle() {
        try {
            this.h.invoke(this, LR53412a9f7.gjm(16, "org.dsi.ifc.albumbrowser.DSIAlbumBrowser", -1075501168, 17), 16, ZOA);
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
    public void startPreview() {
        try {
            this.h.invoke(this, LR53412a9f7.gjm(17, "org.dsi.ifc.albumbrowser.DSIAlbumBrowser", 2070349285, 17), 17, ZOA);
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
    public void startActive() {
        try {
            this.h.invoke(this, LR53412a9f7.gjm(18, "org.dsi.ifc.albumbrowser.DSIAlbumBrowser", 2111839857, 17), 18, ZOA);
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
    public void setScrollMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53412a9f7.gjm(19, "org.dsi.ifc.albumbrowser.DSIAlbumBrowser", -2022812384, 1687814400), 19, objectArray);
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
    public void scrollTicks(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR53412a9f7.gjm(20, "org.dsi.ifc.albumbrowser.DSIAlbumBrowser", 507935866, -238538240), 20, objectArray);
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
    public void selectAlbum(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR53412a9f7.gjm(21, "org.dsi.ifc.albumbrowser.DSIAlbumBrowser", 1209609483, -238538240), 21, objectArray);
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
    public void moveFocus(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53412a9f7.gjm(22, "org.dsi.ifc.albumbrowser.DSIAlbumBrowser", -52081602, -266965504), 22, objectArray);
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
    public void albumIdxForFID(long l) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR53412a9f7.gjm(23, "org.dsi.ifc.albumbrowser.DSIAlbumBrowser", 1536443739, -238538240), 23, objectArray);
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

