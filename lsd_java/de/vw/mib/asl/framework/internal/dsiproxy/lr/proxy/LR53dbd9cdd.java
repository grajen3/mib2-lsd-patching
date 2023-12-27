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
import org.dsi.ifc.exlap.DSIExlapListener;
import org.dsi.ifc.exlap.Service;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.DSIFileBrowserListener;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public final class LR53dbd9cdd
extends AbstractProxy
implements DSIExlapListener,
DSIFileBrowserListener {
    private static final Method[] JMS = new Method[23];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR53dbd9cdd(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void startResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53dbd9cdd.gjm(0, "org.dsi.ifc.exlap.DSIExlapListener", -1809236594, 1687814400), 0, objectArray);
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
    public void stopResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53dbd9cdd.gjm(1, "org.dsi.ifc.exlap.DSIExlapListener", 875892653, 1687814400), 1, objectArray);
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
    public void updateAvailableServices(Service[] serviceArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = serviceArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53dbd9cdd.gjm(2, "org.dsi.ifc.exlap.DSIExlapListener", -205871165, -150851648), 2, objectArray);
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
            this.h.invoke(this, LR53dbd9cdd.gjm(3, "org.dsi.ifc.exlap.DSIExlapListener", -1459926625, 1276482132), -1, objectArray);
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
    public void startResult(int n, int n2, Path path) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = path;
            this.h.invoke(this, LR53dbd9cdd.gjm(4, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", -1809236594, -327400916), 4, objectArray);
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
    public void setFileExtensionFilterResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53dbd9cdd.gjm(5, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", -1410915323, 1676164096), 5, objectArray);
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
    public void setFileTypeFilterResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR53dbd9cdd.gjm(6, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", -1567504773, 1676164096), 6, objectArray);
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
    public void getViewWindowResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = browsedFileSet;
            objectArray[4] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR53dbd9cdd.gjm(7, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", 1560628540, 1509154938), 7, objectArray);
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
    public void getViewWindowWithPreviewsResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, PreviewInfo[] previewInfoArray, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = browsedFileSet;
            objectArray[4] = previewInfoArray;
            objectArray[5] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR53dbd9cdd.gjm(8, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", -835933903, -414876240), 8, objectArray);
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
    public void getResourceLocatorWindowResult(int n, int n2, int n3, ResourceLocator[] resourceLocatorArray, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = resourceLocatorArray;
            objectArray[4] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR53dbd9cdd.gjm(9, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", 881757973, -1596423190), 9, objectArray);
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
    public void indicateSelectionResult(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53dbd9cdd.gjm(10, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", 1157868556, 1043255048), 10, objectArray);
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
    public void changeFolderResult(int n, int n2, Path path) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = path;
            this.h.invoke(this, LR53dbd9cdd.gjm(11, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", 1890085527, -327400916), 11, objectArray);
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
    public void getSelectedFilesResult(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53dbd9cdd.gjm(12, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", 418343497, 1043255048), 12, objectArray);
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
    public void getResourceLocatorsResult(int n, int n2, ResourceLocator[] resourceLocatorArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = resourceLocatorArray;
            this.h.invoke(this, LR53dbd9cdd.gjm(13, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", 857402980, -162971537), 13, objectArray);
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
    public void getFileCountResult(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR53dbd9cdd.gjm(14, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", 792716241, 1043255048), 14, objectArray);
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
    public void getFileCountWithFileTypeFilterResult(int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR53dbd9cdd.gjm(15, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", 1674795017, -448335035), 15, objectArray);
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
    public void spellerResult(int n, int n2, String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = string;
            objectArray[3] = string2;
            this.h.invoke(this, LR53dbd9cdd.gjm(16, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", -953763336, -918199202), 16, objectArray);
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
    public void setLanguageResult(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR53dbd9cdd.gjm(17, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", 211664293, 1909456715), 17, objectArray);
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
    public void setFileTypeActiveResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53dbd9cdd.gjm(18, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", -1327329455, 1687814400), 18, objectArray);
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
    public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = string;
            objectArray[3] = string2;
            this.h.invoke(this, LR53dbd9cdd.gjm(19, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", 1886213843, -918199202), 19, objectArray);
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
    public void createPreviewImageResult(ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = resourceLocator;
            objectArray[1] = resourceLocator2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53dbd9cdd.gjm(20, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", 22915431, -1229977572), 20, objectArray);
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
    public void cancelPreviewCreationResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR53dbd9cdd.gjm(21, "org.dsi.ifc.filebrowser.DSIFileBrowserListener", -544910477, 1687814400), 21, objectArray);
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

