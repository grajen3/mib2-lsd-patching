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
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.DSIBrowserBoardbook;
import org.dsi.ifc.browser.DSIBrowserBookmark;
import org.dsi.ifc.browser.PathInfo;

public final class LR539c42da2
extends AbstractProxy
implements DSIBrowserBookmark,
DSIBrowserBoardbook {
    private static final Method[] JMS = new Method[26];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR539c42da2(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void listBookmarks(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR539c42da2.gjm(0, "org.dsi.ifc.browser.DSIBrowserBookmark", 1950680652, -633848249), 0, objectArray);
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
    public void addBookmark(Bookmark bookmark) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = bookmark;
            this.h.invoke(this, LR539c42da2.gjm(1, "org.dsi.ifc.browser.DSIBrowserBookmark", 1817408829, 1465208930), 1, objectArray);
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
    public void editBookmark(Bookmark bookmark, Bookmark bookmark2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bookmark;
            objectArray[1] = bookmark2;
            this.h.invoke(this, LR539c42da2.gjm(2, "org.dsi.ifc.browser.DSIBrowserBookmark", -707793138, 1974004887), 2, objectArray);
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
    public void deleteBookmark(Bookmark bookmark) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = bookmark;
            this.h.invoke(this, LR539c42da2.gjm(3, "org.dsi.ifc.browser.DSIBrowserBookmark", 1991649789, 1465208930), 3, objectArray);
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
    public void createFolder(Bookmark bookmark) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = bookmark;
            this.h.invoke(this, LR539c42da2.gjm(4, "org.dsi.ifc.browser.DSIBrowserBookmark", -126651, 1465208930), 4, objectArray);
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
    public void deleteFolder(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR539c42da2.gjm(5, "org.dsi.ifc.browser.DSIBrowserBookmark", 1852062396, -633848249), 5, objectArray);
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
    public void renameFolder(String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = string2;
            this.h.invoke(this, LR539c42da2.gjm(6, "org.dsi.ifc.browser.DSIBrowserBookmark", -1050981656, -412271469), 6, objectArray);
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
    public void exportBookmarks(PathInfo pathInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = pathInfo;
            this.h.invoke(this, LR539c42da2.gjm(7, "org.dsi.ifc.browser.DSIBrowserBookmark", 519823090, -1806543052), 7, objectArray);
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
    public void importBookmarks(PathInfo pathInfo, boolean bl, boolean bl2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = pathInfo;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(bl2);
            this.h.invoke(this, LR539c42da2.gjm(8, "org.dsi.ifc.browser.DSIBrowserBookmark", 1308279973, 2088206435), 8, objectArray);
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
    public void getQuotaInformation() {
        try {
            this.h.invoke(this, LR539c42da2.gjm(9, "org.dsi.ifc.browser.DSIBrowserBookmark", 2131565584, 17), 9, ZOA);
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
            this.h.invoke(this, LR539c42da2.gjm(10, "org.dsi.ifc.browser.DSIBrowserBookmark", -501696838, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR539c42da2.gjm(11, "org.dsi.ifc.browser.DSIBrowserBookmark", -501696838, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR539c42da2.gjm(12, "org.dsi.ifc.browser.DSIBrowserBookmark", -501696838, -864245041), -1, objectArray);
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
            this.h.invoke(this, LR539c42da2.gjm(13, "org.dsi.ifc.browser.DSIBrowserBookmark", 1300919239, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR539c42da2.gjm(14, "org.dsi.ifc.browser.DSIBrowserBookmark", 1300919239, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR539c42da2.gjm(15, "org.dsi.ifc.browser.DSIBrowserBookmark", 1300919239, -864245041), -1, objectArray);
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
    public void search(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539c42da2.gjm(16, "org.dsi.ifc.browser.DSIBrowserBoardbook", 493419209, -645498553), 16, objectArray);
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
    public void setLanguage(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR539c42da2.gjm(17, "org.dsi.ifc.browser.DSIBrowserBoardbook", 1328833814, -633848249), 17, objectArray);
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
    public void startBoardbook(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR539c42da2.gjm(18, "org.dsi.ifc.browser.DSIBrowserBoardbook", 41101963, 1909456715), 18, objectArray);
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
    public void openPage(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR539c42da2.gjm(19, "org.dsi.ifc.browser.DSIBrowserBoardbook", 1858791905, 1687814400), 19, objectArray);
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

