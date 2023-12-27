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
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener;
import org.dsi.ifc.kombisync.DSIKombiSyncListener;
import org.dsi.ifc.kombisync.KombiDisplayRequest;
import org.dsi.ifc.kombisync.KombiDisplayStatus;
import org.dsi.ifc.kombisync.KombiPopupStatus;

public final class LR5a596ed5f
extends AbstractProxy
implements DSIKombiSyncListener,
DSIKombiPictureServerListener {
    private static final Method[] JMS = new Method[18];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5a596ed5f(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateKombiCommunicationState(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a596ed5f.gjm(0, "org.dsi.ifc.kombisync.DSIKombiSyncListener", 2008009553, -1665395196), 0, objectArray);
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
    public void updateKombiMessageStateDisplayStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a596ed5f.gjm(1, "org.dsi.ifc.kombisync.DSIKombiSyncListener", -1743194014, 1676164096), 1, objectArray);
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
    public void updateKombiMessageStateDisplayRequest(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a596ed5f.gjm(2, "org.dsi.ifc.kombisync.DSIKombiSyncListener", -210473554, 1676164096), 2, objectArray);
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
    public void updateKombiMessageStatePopupStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a596ed5f.gjm(3, "org.dsi.ifc.kombisync.DSIKombiSyncListener", -1027576608, 1676164096), 3, objectArray);
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
    public void responseKombiDisplayStatus(KombiDisplayStatus kombiDisplayStatus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = kombiDisplayStatus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a596ed5f.gjm(4, "org.dsi.ifc.kombisync.DSIKombiSyncListener", 975966717, 1640193194), 4, objectArray);
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
    public void responseKombiDisplayRequest(KombiDisplayRequest kombiDisplayRequest) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = kombiDisplayRequest;
            this.h.invoke(this, LR5a596ed5f.gjm(5, "org.dsi.ifc.kombisync.DSIKombiSyncListener", -1848281513, 1773236044), 5, objectArray);
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
    public void responseKombiPopupStatus(KombiPopupStatus kombiPopupStatus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = kombiPopupStatus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a596ed5f.gjm(6, "org.dsi.ifc.kombisync.DSIKombiSyncListener", -464217457, 186005139), 6, objectArray);
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
            this.h.invoke(this, LR5a596ed5f.gjm(7, "org.dsi.ifc.kombisync.DSIKombiSyncListener", -1459926625, 1276482132), -1, objectArray);
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
    public void indicationCoverArt(long l, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a596ed5f.gjm(8, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener", 490186007, -883163127), 8, objectArray);
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
    public void indicationStationArt(long l, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a596ed5f.gjm(9, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener", -2134030732, -883163127), 9, objectArray);
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
    public void indicationActiveCallPicture(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a596ed5f.gjm(10, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener", 1402403716, 1687814400), 10, objectArray);
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
    public void indicationActiveCallPictureInstance(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a596ed5f.gjm(11, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener", 147915102, 1676164096), 11, objectArray);
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
    public void indicationDynamicIcon(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a596ed5f.gjm(12, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener", -773578053, 1676164096), 12, objectArray);
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
    public void indicationInternalAddressID(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a596ed5f.gjm(13, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener", 1263414204, -266965504), 13, objectArray);
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
    public void indicationAdbContactPicture(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a596ed5f.gjm(14, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener", -1234745898, -266965504), 14, objectArray);
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
    public void indicationPictureStreamAbilities() {
        try {
            this.h.invoke(this, LR5a596ed5f.gjm(15, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener", -1156492074, 17), 15, ZOA);
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
    public void indicationPictureStream(int n, short s, short s2, int n2, int n3, int n4, int n5, byte[] byArray) {
        try {
            Object[] objectArray = this.p.borrowArray(8);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(s);
            objectArray[2] = RuntimeUtil.valueOf(s2);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            objectArray[4] = RuntimeUtil.valueOf(n3);
            objectArray[5] = RuntimeUtil.valueOf(n4);
            objectArray[6] = RuntimeUtil.valueOf(n5);
            objectArray[7] = byArray;
            this.h.invoke(this, LR5a596ed5f.gjm(16, "org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener", -1757644367, 1473665532), 16, objectArray);
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

