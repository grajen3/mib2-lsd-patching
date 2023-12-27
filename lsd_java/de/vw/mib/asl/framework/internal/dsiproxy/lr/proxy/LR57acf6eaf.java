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
import org.dsi.ifc.swdlprogress.DSISwdlProgressListener;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;
import org.dsi.ifc.swdlselection.DSISwdlSelectionListener;
import org.dsi.ifc.swdlselection.LameClient;

public final class LR57acf6eaf
extends AbstractProxy
implements DSISwdlSelectionListener,
DSISwdlProgressListener {
    private static final Method[] JMS = new Method[35];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR57acf6eaf(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void setRelease(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR57acf6eaf.gjm(0, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", -1162657806, 1909456715), 0, objectArray);
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
    public void getMedia(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR57acf6eaf.gjm(1, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", -1558655628, 3523), 1, objectArray);
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
    public void storeNfsIpAddress(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57acf6eaf.gjm(2, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 1218122840, -633848249), 2, objectArray);
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
    public void storeNfsPath(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57acf6eaf.gjm(3, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", -734116435, -633848249), 3, objectArray);
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
    public void setMedium(int n, String string, String[] stringArray) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = stringArray;
            this.h.invoke(this, LR57acf6eaf.gjm(4, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", -320337384, 845722233), 4, objectArray);
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
    public void getUserDefinedAllowed(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57acf6eaf.gjm(5, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 1965831323, -1653679357), 5, objectArray);
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
    public void setTargetLanguage(short s) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(s);
            this.h.invoke(this, LR57acf6eaf.gjm(6, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", -2139128841, -242842362), 6, objectArray);
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
    public void getIncompatibleDevices(String[] stringArray, String[] stringArray2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stringArray;
            objectArray[1] = stringArray2;
            this.h.invoke(this, LR57acf6eaf.gjm(7, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 594811896, 655327865), 7, objectArray);
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
    public void startVersionUpload(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR57acf6eaf.gjm(8, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 741537039, -1653679357), 8, objectArray);
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
    public void storeFsPath(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR57acf6eaf.gjm(9, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 1219606652, -633848249), 9, objectArray);
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
    public void checkConsistency(int n, boolean bl, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = string;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR57acf6eaf.gjm(10, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 1705932557, 676895431), 10, objectArray);
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
    public void abortSetMedium() {
        try {
            this.h.invoke(this, LR57acf6eaf.gjm(11, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", -1669606201, 17), 11, ZOA);
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
    public void abortSetRelease() {
        try {
            this.h.invoke(this, LR57acf6eaf.gjm(12, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 175614011, 17), 12, ZOA);
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
    public void getFinalizeTargets(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR57acf6eaf.gjm(13, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 1125382506, 3523), 13, objectArray);
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
    public void setFinalizeTarget(int n, long l, long l2, long l3) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(l2);
            objectArray[3] = RuntimeUtil.valueOf(l3);
            this.h.invoke(this, LR57acf6eaf.gjm(14, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", -966607851, 77748311), 14, objectArray);
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
    public void enterComponentUpdateConfirmation() {
        try {
            this.h.invoke(this, LR57acf6eaf.gjm(15, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", -133979584, 17), 15, ZOA);
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
    public void updateLameClients(LameClient[] lameClientArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = lameClientArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57acf6eaf.gjm(16, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 1738923727, 1390964370), 16, objectArray);
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
    public void updateEngineering(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57acf6eaf.gjm(17, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", -15152607, -1665395196), 17, objectArray);
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
    public void updateUserSwdl(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57acf6eaf.gjm(18, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", -1252328669, -1665395196), 18, objectArray);
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
    public void updateRingNotOK(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57acf6eaf.gjm(19, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 1267457880, -1665395196), 19, objectArray);
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
    public void updateEndDownload(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57acf6eaf.gjm(20, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 1878297269, -1665395196), 20, objectArray);
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
    public void updateAvailableMedia(byte by, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(by);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57acf6eaf.gjm(21, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 968776227, 2092001536), 21, objectArray);
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
    public void updateUnitType(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR57acf6eaf.gjm(22, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", 1010920482, 1676164096), 22, objectArray);
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
            this.h.invoke(this, LR57acf6eaf.gjm(23, "org.dsi.ifc.swdlselection.DSISwdlSelectionListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateGeneralProgress(GeneralProgress generalProgress, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = generalProgress;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57acf6eaf.gjm(24, "org.dsi.ifc.swdlprogress.DSISwdlProgressListener", -1585608906, 987792448), 24, objectArray);
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
    public void updateDevicesOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = deviceOverviewProgressArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57acf6eaf.gjm(25, "org.dsi.ifc.swdlprogress.DSISwdlProgressListener", 804369309, -714929325), 25, objectArray);
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
    public void updateTriggerPanel(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR57acf6eaf.gjm(26, "org.dsi.ifc.swdlprogress.DSISwdlProgressListener", 172073691, 1676164096), 26, objectArray);
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
    public void updateLostDevices(String[] stringArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stringArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57acf6eaf.gjm(27, "org.dsi.ifc.swdlprogress.DSISwdlProgressListener", 87514341, -1178098921), 27, objectArray);
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
    public void updateOverviewStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR57acf6eaf.gjm(28, "org.dsi.ifc.swdlprogress.DSISwdlProgressListener", 1767785318, 1676164096), 28, objectArray);
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
    public void updateActiveDevices(String[] stringArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stringArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR57acf6eaf.gjm(29, "org.dsi.ifc.swdlprogress.DSISwdlProgressListener", 591104275, -1178098921), 29, objectArray);
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
    public void getStaticProgressDetails(int n, int n2, short s, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(s);
            objectArray[3] = string;
            this.h.invoke(this, LR57acf6eaf.gjm(30, "org.dsi.ifc.swdlprogress.DSISwdlProgressListener", -960504870, -924928958), 30, objectArray);
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
    public void getDynamicProgressDetails(int n, byte by, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(by);
            objectArray[2] = string;
            this.h.invoke(this, LR57acf6eaf.gjm(31, "org.dsi.ifc.swdlprogress.DSISwdlProgressListener", -2116679613, -509381886), 31, objectArray);
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
    public void indicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(by);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            objectArray[4] = RuntimeUtil.valueOf(n3);
            objectArray[5] = string2;
            this.h.invoke(this, LR57acf6eaf.gjm(32, "org.dsi.ifc.swdlprogress.DSISwdlProgressListener", 145791193, 80652446), 32, objectArray);
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
    public void indicateDismissPopUp(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR57acf6eaf.gjm(33, "org.dsi.ifc.swdlprogress.DSISwdlProgressListener", 812956443, 1909456715), 33, objectArray);
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

