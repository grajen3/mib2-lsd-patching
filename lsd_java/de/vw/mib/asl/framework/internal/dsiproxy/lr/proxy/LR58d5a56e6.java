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
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.DSIBrowserBoardbookListener;
import org.dsi.ifc.browser.DSIBrowserBookmarkListener;
import org.dsi.ifc.browser.ImportReport;
import org.dsi.ifc.browser.PathInfo;
import org.dsi.ifc.browser.SearchHit;

public final class LR58d5a56e6
extends AbstractProxy
implements DSIBrowserBoardbookListener,
DSIBrowserBookmarkListener {
    private static final Method[] JMS = new Method[17];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR58d5a56e6(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void indicateSearchResults(String string, int n, SearchHit[] searchHitArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = searchHitArray;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58d5a56e6.gjm(0, "org.dsi.ifc.browser.DSIBrowserBoardbookListener", 1791823846, -921385051), 0, objectArray);
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
    public void updateBoardbookStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58d5a56e6.gjm(1, "org.dsi.ifc.browser.DSIBrowserBoardbookListener", 220380174, 1676164096), 1, objectArray);
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
            this.h.invoke(this, LR58d5a56e6.gjm(2, "org.dsi.ifc.browser.DSIBrowserBoardbookListener", -1459926625, 1276482132), -1, objectArray);
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
    public void listBookmarksResult(String string, Bookmark[] bookmarkArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = bookmarkArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58d5a56e6.gjm(3, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", 1904137293, -1322319048), 3, objectArray);
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
    public void bookmarkListInvalid() {
        try {
            this.h.invoke(this, LR58d5a56e6.gjm(4, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", -665650329, 17), 4, ZOA);
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
    public void addBookmarkResult(Bookmark bookmark, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bookmark;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58d5a56e6.gjm(5, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", 1764888352, 1453558626), 5, objectArray);
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
    public void editBookmarkResult(Bookmark bookmark, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bookmark;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58d5a56e6.gjm(6, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", 318515877, 1453558626), 6, objectArray);
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
    public void deleteBookmarkResult(Bookmark bookmark, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bookmark;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58d5a56e6.gjm(7, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", -207246494, 1453558626), 7, objectArray);
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
    public void createFolderResult(Bookmark bookmark, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bookmark;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58d5a56e6.gjm(8, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", -1130138836, 1453558626), 8, objectArray);
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
    public void deleteFolderResult(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58d5a56e6.gjm(9, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", -335949974, -645498553), 9, objectArray);
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
    public void renameFolderResult(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58d5a56e6.gjm(10, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", -18452647, -645498553), 10, objectArray);
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
    public void exportBookmarksResult(PathInfo pathInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = pathInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58d5a56e6.gjm(11, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", -1681099685, -1818193356), 11, objectArray);
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
    public void updateExportBookmarksProgress(PathInfo pathInfo, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = pathInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58d5a56e6.gjm(12, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", 1647643274, 1860576317), 12, objectArray);
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
    public void importBookmarksResult(PathInfo pathInfo, ImportReport importReport, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = pathInfo;
            objectArray[1] = importReport;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR58d5a56e6.gjm(13, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", -1972575079, -56816085), 13, objectArray);
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
    public void updateImportBookmarksProgress(PathInfo pathInfo, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = pathInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR58d5a56e6.gjm(14, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", -1852501525, 1860576317), 14, objectArray);
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
    public void getQuotaInformationResult(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR58d5a56e6.gjm(15, "org.dsi.ifc.browser.DSIBrowserBookmarkListener", 1020418066, 1043255048), 15, objectArray);
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

