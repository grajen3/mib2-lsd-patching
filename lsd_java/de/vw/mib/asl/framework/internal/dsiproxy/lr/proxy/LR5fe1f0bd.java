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
import org.dsi.ifc.uota.DSIUotAListener;
import org.dsi.ifc.uota.PackageInfo;
import org.dsi.ifc.upnp.DSIUPNPBrowserListener;
import org.dsi.ifc.upnp.ListEntry;

public final class LR5fe1f0bd
extends AbstractProxy
implements DSIUPNPBrowserListener,
DSIUotAListener {
    private static final Method[] JMS = new Method[21];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5fe1f0bd(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateBrowseFolder(ListEntry[] listEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = listEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fe1f0bd.gjm(0, "org.dsi.ifc.upnp.DSIUPNPBrowserListener", 1992906468, -1785378338), 0, objectArray);
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
    public void updateListSize(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5fe1f0bd.gjm(1, "org.dsi.ifc.upnp.DSIUPNPBrowserListener", 491524740, 1043255048), 1, objectArray);
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
    public void responseList(ListEntry[] listEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = listEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5fe1f0bd.gjm(2, "org.dsi.ifc.upnp.DSIUPNPBrowserListener", -197999275, -1785378338), 2, objectArray);
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
    public void invalidBrowsePath() {
        try {
            this.h.invoke(this, LR5fe1f0bd.gjm(3, "org.dsi.ifc.upnp.DSIUPNPBrowserListener", -1691286944, 17), 3, ZOA);
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
            this.h.invoke(this, LR5fe1f0bd.gjm(4, "org.dsi.ifc.upnp.DSIUPNPBrowserListener", -1459926625, 1276482132), -1, objectArray);
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
    public void toggleSelection(int n, int n2, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = nArray;
            this.h.invoke(this, LR5fe1f0bd.gjm(5, "org.dsi.ifc.uota.DSIUotAListener", 223832056, 1160087040), 5, objectArray);
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
    public void startDownload(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5fe1f0bd.gjm(6, "org.dsi.ifc.uota.DSIUotAListener", 2138156636, 1676164096), 6, objectArray);
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
    public void getServerList(int n, String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = stringArray;
            this.h.invoke(this, LR5fe1f0bd.gjm(7, "org.dsi.ifc.uota.DSIUotAListener", -323721343, -785441950), 7, objectArray);
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
    public void getUpdatePackages(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = packageInfoArray;
            objectArray[3] = nArray;
            this.h.invoke(this, LR5fe1f0bd.gjm(8, "org.dsi.ifc.uota.DSIUotAListener", 1105737295, 270115921), 8, objectArray);
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
    public void abortDownload(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5fe1f0bd.gjm(9, "org.dsi.ifc.uota.DSIUotAListener", 1294105649, 1676164096), 9, objectArray);
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
    public void triggerAction(int n, int n2, int n3, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = string;
            this.h.invoke(this, LR5fe1f0bd.gjm(10, "org.dsi.ifc.uota.DSIUotAListener", -2087170430, -1008715669), 10, objectArray);
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
    public void customerDownloadFinished(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5fe1f0bd.gjm(11, "org.dsi.ifc.uota.DSIUotAListener", -1926285446, 1676164096), 11, objectArray);
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
    public void getUpdatePackagesForDestinations(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = packageInfoArray;
            objectArray[3] = nArray;
            this.h.invoke(this, LR5fe1f0bd.gjm(12, "org.dsi.ifc.uota.DSIUotAListener", -1757671607, 270115921), 12, objectArray);
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
    public void updateDownloadState(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5fe1f0bd.gjm(13, "org.dsi.ifc.uota.DSIUotAListener", 359209726, 1043255048), 13, objectArray);
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
    public void updateDownloadProgress(int n, int n2, int n3, String string, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = string;
            objectArray[4] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR5fe1f0bd.gjm(14, "org.dsi.ifc.uota.DSIUotAListener", 867438776, -428838847), 14, objectArray);
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
    public void updatePackagesAvailable(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5fe1f0bd.gjm(15, "org.dsi.ifc.uota.DSIUotAListener", 136705093, 1676164096), 15, objectArray);
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
    public void featureResult(String string, int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5fe1f0bd.gjm(16, "org.dsi.ifc.uota.DSIUotAListener", 681660067, -2051937305), 16, objectArray);
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
    public void attributeResult(int n, int n2, int n3, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = string;
            this.h.invoke(this, LR5fe1f0bd.gjm(17, "org.dsi.ifc.uota.DSIUotAListener", 1325194944, -1008715669), 17, objectArray);
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
    public void updateServcieReady(int n, boolean bl, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5fe1f0bd.gjm(18, "org.dsi.ifc.uota.DSIUotAListener", 403500712, 2077903511), 18, objectArray);
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
    public void getUpdatePackagesViaApp(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = packageInfoArray;
            objectArray[3] = nArray;
            this.h.invoke(this, LR5fe1f0bd.gjm(19, "org.dsi.ifc.uota.DSIUotAListener", -1797070015, 270115921), 19, objectArray);
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

