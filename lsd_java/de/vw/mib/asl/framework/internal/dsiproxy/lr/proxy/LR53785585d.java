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
import org.dsi.ifc.kombisync2.DSIKombiSync;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.MenuState;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;

public final class LR53785585d
extends AbstractProxy
implements DSIKOMOGfxStreamSink,
DSIKombiSync {
    private static final Method[] JMS = new Method[23];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR53785585d(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setFGLayer(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53785585d.gjm(0, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink", -484409534, 1687814400), 0, objectArray);
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
    public void fadeIn(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53785585d.gjm(1, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink", 909350067, 1043255048), 1, objectArray);
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
    public void fadeOut(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53785585d.gjm(2, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink", -1493044546, 1687814400), 2, objectArray);
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
            this.h.invoke(this, LR53785585d.gjm(3, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink", -501696838, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR53785585d.gjm(4, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink", -501696838, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR53785585d.gjm(5, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink", -501696838, -864245041), -1, objectArray);
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
            this.h.invoke(this, LR53785585d.gjm(6, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink", 1300919239, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR53785585d.gjm(7, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink", 1300919239, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR53785585d.gjm(8, "org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink", 1300919239, -864245041), -1, objectArray);
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
            this.h.invoke(this, LR53785585d.gjm(9, "org.dsi.ifc.kombisync2.DSIKombiSync", 1816829296, -1653679357), 9, objectArray);
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
    public void setMMIDisplayStatus(DisplayStatus displayStatus) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = displayStatus;
            this.h.invoke(this, LR53785585d.gjm(10, "org.dsi.ifc.kombisync2.DSIKombiSync", 47639433, -386125191), 10, objectArray);
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
            this.h.invoke(this, LR53785585d.gjm(11, "org.dsi.ifc.kombisync2.DSIKombiSync", -1518987520, -2031391656), 11, objectArray);
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
    public void setMMIDisplayRequestResponse(DisplayRequestResponse displayRequestResponse) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = displayRequestResponse;
            this.h.invoke(this, LR53785585d.gjm(12, "org.dsi.ifc.kombisync2.DSIKombiSync", 709457325, 75879518), 12, objectArray);
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
    public void setMMIPopupRegisterRequest(PopupRegisterRequestResponse popupRegisterRequestResponse) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = popupRegisterRequestResponse;
            this.h.invoke(this, LR53785585d.gjm(13, "org.dsi.ifc.kombisync2.DSIKombiSync", 1013976485, -140383835), 13, objectArray);
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
    public void setMMIPopupActionResponse(PopupActionRequestResponse popupActionRequestResponse) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = popupActionRequestResponse;
            this.h.invoke(this, LR53785585d.gjm(14, "org.dsi.ifc.kombisync2.DSIKombiSync", 1363983777, 1149447382), 14, objectArray);
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
    public void setMMIPopupStatus(PopupStatus popupStatus) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = popupStatus;
            this.h.invoke(this, LR53785585d.gjm(15, "org.dsi.ifc.kombisync2.DSIKombiSync", -1395645355, 309965865), 15, objectArray);
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
    public void setMMIDisplayIdentification(DisplayIdentification displayIdentification) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = displayIdentification;
            this.h.invoke(this, LR53785585d.gjm(16, "org.dsi.ifc.kombisync2.DSIKombiSync", 2122143596, 1683920002), 16, objectArray);
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

