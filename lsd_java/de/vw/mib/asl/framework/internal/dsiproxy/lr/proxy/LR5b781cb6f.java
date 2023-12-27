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
import org.dsi.ifc.albumbrowser.AlbumEntryInfo;
import org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.AppStateRequest;
import org.dsi.ifc.androidauto.CallState;
import org.dsi.ifc.androidauto.DSIAndroidAutoListener;
import org.dsi.ifc.androidauto.PlaybackInfo;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ResourceRequest;
import org.dsi.ifc.androidauto.TelephonyState;
import org.dsi.ifc.androidauto.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public final class LR5b781cb6f
extends AbstractProxy
implements DSIAndroidAutoListener,
DSIAlbumBrowserListener {
    private static final Method[] JMS = new Method[20];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5b781cb6f(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setMode(Resource[] resourceArray, AppState[] appStateArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = resourceArray;
            objectArray[1] = appStateArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b781cb6f.gjm(0, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", -1704243850, 1045778532), 0, objectArray);
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
    public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = resourceRequestArray;
            objectArray[1] = appStateRequestArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b781cb6f.gjm(1, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", -1755491709, -1797146216), 1, objectArray);
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
    public void updateCallState(CallState[] callStateArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = callStateArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b781cb6f.gjm(2, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", 2145441544, -1010989258), 2, objectArray);
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
    public void updateTelephonyState(TelephonyState telephonyState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = telephonyState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b781cb6f.gjm(3, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", -144512574, 1125460870), 3, objectArray);
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
    public void updateNowPlayingData(TrackData trackData, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = trackData;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b781cb6f.gjm(4, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", -522503428, -752819116), 4, objectArray);
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
    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = playbackInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b781cb6f.gjm(5, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", 1658809285, -751561115), 5, objectArray);
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
    public void updatePlayposition(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b781cb6f.gjm(6, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", 995756741, 1676164096), 6, objectArray);
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
    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceLocator;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b781cb6f.gjm(7, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", -1892111725, -1214164264), 7, objectArray);
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
    public void updateNavigationNextTurnEvent(String string, int n, int n2, int n3, int n4, int n5) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = RuntimeUtil.valueOf(n4);
            objectArray[5] = RuntimeUtil.valueOf(n5);
            this.h.invoke(this, LR5b781cb6f.gjm(8, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", 586436346, -1924501671), 8, objectArray);
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
    public void updateNavigationNextTurnDistance(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5b781cb6f.gjm(9, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", 2001890729, 1043255048), 9, objectArray);
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
    public void setExternalDestination(double d2, double d3, String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(d2);
            objectArray[1] = RuntimeUtil.valueOf(d3);
            objectArray[2] = string;
            objectArray[3] = string2;
            this.h.invoke(this, LR5b781cb6f.gjm(10, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", -160867016, 1427760290), 10, objectArray);
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
            this.h.invoke(this, LR5b781cb6f.gjm(11, "org.dsi.ifc.androidauto.DSIAndroidAutoListener", -1459926625, 1276482132), -1, objectArray);
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
            this.h.invoke(this, LR5b781cb6f.gjm(12, "org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener", 1209609483, -238538240), 12, objectArray);
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
    public void albumIdxForFID(long l, long l2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            this.h.invoke(this, LR5b781cb6f.gjm(13, "org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener", 1536443739, 1372686599), 13, objectArray);
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
    public void updateBrowserState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b781cb6f.gjm(14, "org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener", 655156525, 1676164096), 14, objectArray);
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
    public void updateFocusedEntry(AlbumEntryInfo albumEntryInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = albumEntryInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b781cb6f.gjm(15, "org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener", 432625625, -1803110358), 15, objectArray);
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
    public void updateListPosition(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b781cb6f.gjm(16, "org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener", -975617229, -266965504), 16, objectArray);
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
    public void updateNumEntries(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5b781cb6f.gjm(17, "org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener", 1224641709, -266965504), 17, objectArray);
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
    public void updateScrollMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5b781cb6f.gjm(18, "org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener", 785804471, 1676164096), 18, objectArray);
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

