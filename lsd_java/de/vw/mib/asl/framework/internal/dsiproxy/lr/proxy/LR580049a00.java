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
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;
import org.dsi.ifc.picturestore.DSIPictureViewerListener;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;
import org.dsi.ifc.picturestore.PictureEntryInfo;

public final class LR580049a00
extends AbstractProxy
implements DSIPictureStoreListener,
DSIPictureViewerListener {
    private static final Method[] JMS = new Method[37];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR580049a00(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void pictureExists(ResourceLocator resourceLocator, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceLocator;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR580049a00.gjm(0, "org.dsi.ifc.picturestore.DSIPictureStoreListener", 1862915367, -196227482), 0, objectArray);
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
    public void resetToFactorySettingsResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR580049a00.gjm(1, "org.dsi.ifc.picturestore.DSIPictureStoreListener", 902702266, 1687814400), 1, objectArray);
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
    public void invalidData(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR580049a00.gjm(2, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -1232852793, -1034208512), 2, objectArray);
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
    public void importPictureResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = resourceLocator;
            objectArray[2] = resourceLocator2;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(3, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -1955766034, 1025655565), 3, objectArray);
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
    public void freeSlots(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(4, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -1636467227, 1676164096), 4, objectArray);
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
    public void getReferencesResult(ResourceLocator resourceLocator, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceLocator;
            objectArray[1] = nArray;
            this.h.invoke(this, LR580049a00.gjm(5, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -1329414288, 1917721048), 5, objectArray);
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
    public void deletedPictures(ResourceLocator[] resourceLocatorArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = resourceLocatorArray;
            this.h.invoke(this, LR580049a00.gjm(6, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -474988934, -591118422), 6, objectArray);
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
    public void responseLRUPictures(int n, ResourceLocator[] resourceLocatorArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = resourceLocatorArray;
            this.h.invoke(this, LR580049a00.gjm(7, "org.dsi.ifc.picturestore.DSIPictureStoreListener", 2017159623, -1156892261), 7, objectArray);
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
    public void listResult(ResourceLocator[] resourceLocatorArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = resourceLocatorArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR580049a00.gjm(8, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -789038829, -619545686), 8, objectArray);
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
    public void listForContextResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = resourceLocatorArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(9, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -1776819378, -1773024349), 9, objectArray);
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
    public void getPictureAttributesResult(ResourceLocator resourceLocator, PictureAttribute[] pictureAttributeArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = resourceLocator;
            objectArray[1] = pictureAttributeArray;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR580049a00.gjm(10, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -1324407941, -190658865), 10, objectArray);
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
    public void importPictureFromSourceResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = resourceLocator;
            objectArray[2] = resourceLocator2;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(11, "org.dsi.ifc.picturestore.DSIPictureStoreListener", 278614650, 1025655565), 11, objectArray);
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
    public void listForContextWithFilterResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = resourceLocatorArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(12, "org.dsi.ifc.picturestore.DSIPictureStoreListener", 351051943, -1773024349), 12, objectArray);
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
    public void listForContextWithFilterSortDistResult(int n, ResourceLocator[] resourceLocatorArray, int n2, float f2, float f3) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = resourceLocatorArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(f2);
            objectArray[4] = RuntimeUtil.valueOf(f3);
            this.h.invoke(this, LR580049a00.gjm(13, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -1730981721, 375687144), 13, objectArray);
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
    public void getRectanglePicturesGridResult(GeoPicture[] geoPictureArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = geoPictureArray;
            this.h.invoke(this, LR580049a00.gjm(14, "org.dsi.ifc.picturestore.DSIPictureStoreListener", 647335263, 1340852966), 14, objectArray);
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
    public void getAvailableYearsResult(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR580049a00.gjm(15, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -168863474, 3523), 15, objectArray);
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
    public void getAvailableMonthsResult(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR580049a00.gjm(16, "org.dsi.ifc.picturestore.DSIPictureStoreListener", 405705211, 3523), 16, objectArray);
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
    public void createFilterSetResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR580049a00.gjm(17, "org.dsi.ifc.picturestore.DSIPictureStoreListener", 1616704672, 1687814400), 17, objectArray);
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
    public void cloneFilterSetResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(18, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -541984342, 1676164096), 18, objectArray);
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
    public void getAvailableFoldersResult(int n, String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = stringArray;
            this.h.invoke(this, LR580049a00.gjm(19, "org.dsi.ifc.picturestore.DSIPictureStoreListener", 1688955662, -785441950), 19, objectArray);
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
    public void countPicturesInContextResult(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR580049a00.gjm(20, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -119715706, 1043255048), 20, objectArray);
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
            this.h.invoke(this, LR580049a00.gjm(21, "org.dsi.ifc.picturestore.DSIPictureStoreListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateListPosition(long l, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(22, "org.dsi.ifc.picturestore.DSIPictureViewerListener", -975617229, -883163127), 22, objectArray);
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
            this.h.invoke(this, LR580049a00.gjm(23, "org.dsi.ifc.picturestore.DSIPictureViewerListener", 1224641709, -266965504), 23, objectArray);
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
            this.h.invoke(this, LR580049a00.gjm(24, "org.dsi.ifc.picturestore.DSIPictureViewerListener", 785804471, 1676164096), 24, objectArray);
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
    public void selectionResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR580049a00.gjm(25, "org.dsi.ifc.picturestore.DSIPictureViewerListener", 1053784719, 1687814400), 25, objectArray);
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
    public void listForContextWithFilterResult(int n, ResourceLocator[] resourceLocatorArray, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = resourceLocatorArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR580049a00.gjm(26, "org.dsi.ifc.picturestore.DSIPictureViewerListener", 351051943, 1030418400), 26, objectArray);
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
    public void getAvailableYearsResult(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR580049a00.gjm(27, "org.dsi.ifc.picturestore.DSIPictureViewerListener", -168863474, -1034208512), 27, objectArray);
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
    public void getAvailableMonthsResult(int[] nArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR580049a00.gjm(28, "org.dsi.ifc.picturestore.DSIPictureViewerListener", 405705211, -1034208512), 28, objectArray);
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
    public void createFilterSetResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(29, "org.dsi.ifc.picturestore.DSIPictureViewerListener", 1616704672, 1676164096), 29, objectArray);
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
    public void updateViewerState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(30, "org.dsi.ifc.picturestore.DSIPictureViewerListener", -1956156162, 1676164096), 30, objectArray);
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
    public void updateNumSelectedEntries(long l, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR580049a00.gjm(31, "org.dsi.ifc.picturestore.DSIPictureViewerListener", 765223711, -266965504), 31, objectArray);
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
    public void getPictureInfoResult(long l, PictureEntryInfo pictureEntryInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(l);
            objectArray[1] = pictureEntryInfo;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR580049a00.gjm(32, "org.dsi.ifc.picturestore.DSIPictureViewerListener", -931429717, -486158878), 32, objectArray);
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
    public void deleteFilterSetResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(33, "org.dsi.ifc.picturestore.DSIPictureViewerListener", -777828964, 1676164096), 33, objectArray);
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
    public void changedFilterSetResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(34, "org.dsi.ifc.picturestore.DSIPictureViewerListener", -1460417602, 1676164096), 34, objectArray);
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
    public void deletePicturesWithFilterSetResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR580049a00.gjm(35, "org.dsi.ifc.picturestore.DSIPictureViewerListener", 917839019, 1676164096), 35, objectArray);
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

