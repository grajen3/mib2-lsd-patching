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
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.DSIMediaBrowserListener;
import org.dsi.ifc.media.DSIMediaOnlineListener;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public final class LR58dd3aa70
extends AbstractProxy
implements DSIMediaBrowserListener,
DSIMediaOnlineListener {
    private static final Method[] JMS = new Method[22];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR58dd3aa70(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateBrowseMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58dd3aa70.gjm(0, "org.dsi.ifc.media.DSIMediaBrowserListener", 1802480809, 1676164096), 0, objectArray);
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
    public void updateContentFilter(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58dd3aa70.gjm(1, "org.dsi.ifc.media.DSIMediaBrowserListener", 2100665810, 1676164096), 1, objectArray);
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
    public void updateBrowseMedia(long l, long l2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58dd3aa70.gjm(2, "org.dsi.ifc.media.DSIMediaBrowserListener", 1722408075, 739712016), 2, objectArray);
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
    public void updateBrowseFolder(ListEntry[] listEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = listEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58dd3aa70.gjm(3, "org.dsi.ifc.media.DSIMediaBrowserListener", 1992906468, 2084990025), 3, objectArray);
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
            this.h.invoke(this, LR58dd3aa70.gjm(4, "org.dsi.ifc.media.DSIMediaBrowserListener", 491524740, 1043255048), 4, objectArray);
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
    public void updateAlphabeticalIndex(CharacterInfo[] characterInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = characterInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58dd3aa70.gjm(5, "org.dsi.ifc.media.DSIMediaBrowserListener", -1506749587, -325145337), 5, objectArray);
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
            this.h.invoke(this, LR58dd3aa70.gjm(6, "org.dsi.ifc.media.DSIMediaBrowserListener", -197999275, 2084990025), 6, objectArray);
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
    public void responsePickList(ListEntry[] listEntryArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = listEntryArray;
            this.h.invoke(this, LR58dd3aa70.gjm(7, "org.dsi.ifc.media.DSIMediaBrowserListener", 894863130, 2113417289), 7, objectArray);
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
    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        try {
            Object[] objectArray = this.p.borrowArray(8);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            objectArray[3] = RuntimeUtil.valueOf(l);
            objectArray[4] = RuntimeUtil.valueOf(l2);
            objectArray[5] = RuntimeUtil.valueOf(l3);
            objectArray[6] = RuntimeUtil.valueOf(l4);
            objectArray[7] = RuntimeUtil.valueOf(l5);
            this.h.invoke(this, LR58dd3aa70.gjm(8, "org.dsi.ifc.media.DSIMediaBrowserListener", 1053784719, -282811157), 8, objectArray);
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
    public void responseSetSearchCriteria(int n, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58dd3aa70.gjm(9, "org.dsi.ifc.media.DSIMediaBrowserListener", 1573786366, -1600866162), 9, objectArray);
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
    public void updateSearchSize(int n, int n2, int n3, int n4, int n5) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = RuntimeUtil.valueOf(n5);
            this.h.invoke(this, LR58dd3aa70.gjm(10, "org.dsi.ifc.media.DSIMediaBrowserListener", -418045047, 148318748), 10, objectArray);
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
    public void responseSelectSearchResult(long l, long l2, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(l2);
            objectArray[2] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58dd3aa70.gjm(11, "org.dsi.ifc.media.DSIMediaBrowserListener", -1747985607, -33817689), 11, objectArray);
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
    public void responseSetSearchString(String string, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR58dd3aa70.gjm(12, "org.dsi.ifc.media.DSIMediaBrowserListener", 1339933021, 372504021), 12, objectArray);
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
    public void updateSearchSpellerState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58dd3aa70.gjm(13, "org.dsi.ifc.media.DSIMediaBrowserListener", -1564338336, 1676164096), 13, objectArray);
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
    public void responseSearchList(SearchListEntry[] searchListEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = searchListEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58dd3aa70.gjm(14, "org.dsi.ifc.media.DSIMediaBrowserListener", -53775125, -2071916182), 14, objectArray);
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
    public void responseSearchListExt(SearchListEntryExt[] searchListEntryExtArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = searchListEntryExtArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58dd3aa70.gjm(15, "org.dsi.ifc.media.DSIMediaBrowserListener", -1895192245, -652084908), 15, objectArray);
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
    public void responseFullyQualifiedName(long l, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = string;
            this.h.invoke(this, LR58dd3aa70.gjm(16, "org.dsi.ifc.media.DSIMediaBrowserListener", 860803602, -16961460), 16, objectArray);
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
            this.h.invoke(this, LR58dd3aa70.gjm(17, "org.dsi.ifc.media.DSIMediaBrowserListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateBufferState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58dd3aa70.gjm(18, "org.dsi.ifc.media.DSIMediaOnlineListener", 489836670, 1676164096), 18, objectArray);
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
    public void updateBufferFillInfo(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR58dd3aa70.gjm(19, "org.dsi.ifc.media.DSIMediaOnlineListener", -813674565, 1043255048), 19, objectArray);
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
    public void updateAudioSettings(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR58dd3aa70.gjm(20, "org.dsi.ifc.media.DSIMediaOnlineListener", 1171141087, 1043255048), 20, objectArray);
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

