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
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;
import org.dsi.ifc.modelapi.DSIModelAPI;
import org.dsi.ifc.modelapi.ListRowData;
import org.dsi.ifc.modelapi.NBestResultEntry;

public final class LR5a2db6e7f
extends AbstractProxy
implements DSIModelAPI,
DSIMobilityHorizon {
    private static final Method[] JMS = new Method[51];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5a2db6e7f(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void popupRemoved(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a2db6e7f.gjm(0, "org.dsi.ifc.modelapi.DSIModelAPI", -1989666137, 1687814400), 0, objectArray);
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
    public void hmiState(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a2db6e7f.gjm(1, "org.dsi.ifc.modelapi.DSIModelAPI", 1646622321, 1687814400), 1, objectArray);
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
    public void keyTyped(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a2db6e7f.gjm(2, "org.dsi.ifc.modelapi.DSIModelAPI", -1058061027, 1687814400), 2, objectArray);
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
    public void increment(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a2db6e7f.gjm(3, "org.dsi.ifc.modelapi.DSIModelAPI", -460511568, 1676164096), 3, objectArray);
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
    public void decrement(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a2db6e7f.gjm(4, "org.dsi.ifc.modelapi.DSIModelAPI", 147842339, 1676164096), 4, objectArray);
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
    public void textChanged(int n, String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = string2;
            this.h.invoke(this, LR5a2db6e7f.gjm(5, "org.dsi.ifc.modelapi.DSIModelAPI", 1023146745, 1383775559), 5, objectArray);
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
    public void itemSelected(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5a2db6e7f.gjm(6, "org.dsi.ifc.modelapi.DSIModelAPI", 1125219180, -995993593), 6, objectArray);
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
    public void itemFocused(int n, long l) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            this.h.invoke(this, LR5a2db6e7f.gjm(7, "org.dsi.ifc.modelapi.DSIModelAPI", 1503657142, -995993593), 7, objectArray);
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
    public void itemDrag(int n, long l, long l2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(l2);
            this.h.invoke(this, LR5a2db6e7f.gjm(8, "org.dsi.ifc.modelapi.DSIModelAPI", 1549609030, -1529287658), 8, objectArray);
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
    public void itemSelectedColumn(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a2db6e7f.gjm(9, "org.dsi.ifc.modelapi.DSIModelAPI", 972971909, -1612125681), 9, objectArray);
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
    public void fillListBufferAtStart(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a2db6e7f.gjm(10, "org.dsi.ifc.modelapi.DSIModelAPI", -1010900855, -1612125681), 10, objectArray);
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
    public void fillListBufferAtEnd(int n, long l, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(l);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a2db6e7f.gjm(11, "org.dsi.ifc.modelapi.DSIModelAPI", 1015942362, -1612125681), 11, objectArray);
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
    public void textChangedFreeTextSpeller(int n, String string, String string2, String string3, String string4) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = string2;
            objectArray[3] = string3;
            objectArray[4] = string4;
            this.h.invoke(this, LR5a2db6e7f.gjm(12, "org.dsi.ifc.modelapi.DSIModelAPI", -1966454211, 284847587), 12, objectArray);
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
    public void screenHidden(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a2db6e7f.gjm(13, "org.dsi.ifc.modelapi.DSIModelAPI", -1421112696, 1687814400), 13, objectArray);
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
    public void screenVisible(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a2db6e7f.gjm(14, "org.dsi.ifc.modelapi.DSIModelAPI", -608687250, 1687814400), 14, objectArray);
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
    public void touchPadMovement(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5a2db6e7f.gjm(15, "org.dsi.ifc.modelapi.DSIModelAPI", 418390723, 1043255048), 15, objectArray);
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
    public void validateCharacters(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR5a2db6e7f.gjm(16, "org.dsi.ifc.modelapi.DSIModelAPI", -1782697274, 1909456715), 16, objectArray);
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
    public void touchScreenPressed(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5a2db6e7f.gjm(17, "org.dsi.ifc.modelapi.DSIModelAPI", -1933352940, 1043255048), 17, objectArray);
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
    public void touchScreenLongPressed(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a2db6e7f.gjm(18, "org.dsi.ifc.modelapi.DSIModelAPI", -267468665, 1676164096), 18, objectArray);
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
    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = RuntimeUtil.valueOf(n5);
            this.h.invoke(this, LR5a2db6e7f.gjm(19, "org.dsi.ifc.modelapi.DSIModelAPI", 1561282595, 148318748), 19, objectArray);
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
    public void touchScreenReleased(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5a2db6e7f.gjm(20, "org.dsi.ifc.modelapi.DSIModelAPI", 1566961058, 1043255048), 20, objectArray);
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
    public void touchScreenZoom(int n, int n2, int n3, int n4, int n5) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = RuntimeUtil.valueOf(n5);
            this.h.invoke(this, LR5a2db6e7f.gjm(21, "org.dsi.ifc.modelapi.DSIModelAPI", 1933379709, 148318748), 21, objectArray);
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
    public void inputModeChanged(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5a2db6e7f.gjm(22, "org.dsi.ifc.modelapi.DSIModelAPI", -593232742, 1676164096), 22, objectArray);
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
    public void sdsSessionEnded() {
        try {
            this.h.invoke(this, LR5a2db6e7f.gjm(23, "org.dsi.ifc.modelapi.DSIModelAPI", -1689943396, 17), 23, ZOA);
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
    public void sdsSessionStarted() {
        try {
            this.h.invoke(this, LR5a2db6e7f.gjm(24, "org.dsi.ifc.modelapi.DSIModelAPI", 1649454707, 17), 24, ZOA);
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
    public void sdsRuleFired(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a2db6e7f.gjm(25, "org.dsi.ifc.modelapi.DSIModelAPI", -1520993196, 1687814400), 25, objectArray);
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
    public void sdsRuleFiredNBest(int n, NBestResultEntry nBestResultEntry) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = nBestResultEntry;
            this.h.invoke(this, LR5a2db6e7f.gjm(26, "org.dsi.ifc.modelapi.DSIModelAPI", -1759624069, 1516286462), 26, objectArray);
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
    public void sdsRuleFiredOneShot(int n, NBestResultEntry[] nBestResultEntryArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = nBestResultEntryArray;
            this.h.invoke(this, LR5a2db6e7f.gjm(27, "org.dsi.ifc.modelapi.DSIModelAPI", -1519805894, 305244040), 27, objectArray);
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
    public void sdsPromptFinished() {
        try {
            this.h.invoke(this, LR5a2db6e7f.gjm(28, "org.dsi.ifc.modelapi.DSIModelAPI", 1305067304, 17), 28, ZOA);
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
    public void listDataChanged(int n, ListRowData[] listRowDataArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = listRowDataArray;
            this.h.invoke(this, LR5a2db6e7f.gjm(29, "org.dsi.ifc.modelapi.DSIModelAPI", -1593700507, -1621617783), 29, objectArray);
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
    public void setPOIViewPortData(int n, ListRowData[] listRowDataArray, int n2, double[] dArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = listRowDataArray;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = dArray;
            this.h.invoke(this, LR5a2db6e7f.gjm(30, "org.dsi.ifc.modelapi.DSIModelAPI", -1387362747, -745719908), 30, objectArray);
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
    public void addSpellerStroke(int n, String string, String string2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = string2;
            this.h.invoke(this, LR5a2db6e7f.gjm(31, "org.dsi.ifc.modelapi.DSIModelAPI", -1051099657, 1383775559), 31, objectArray);
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
    public void getValidHanziCharsWindow(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5a2db6e7f.gjm(32, "org.dsi.ifc.modelapi.DSIModelAPI", -464316443, 1043255048), 32, objectArray);
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
    public void responseStateMachineControl() {
        try {
            this.h.invoke(this, LR5a2db6e7f.gjm(33, "org.dsi.ifc.modelapi.DSIModelAPI", 2064540455, 17), 33, ZOA);
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
            this.h.invoke(this, LR5a2db6e7f.gjm(34, "org.dsi.ifc.modelapi.DSIModelAPI", -501696838, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR5a2db6e7f.gjm(35, "org.dsi.ifc.modelapi.DSIModelAPI", -501696838, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR5a2db6e7f.gjm(36, "org.dsi.ifc.modelapi.DSIModelAPI", -501696838, -864245041), -1, objectArray);
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
            this.h.invoke(this, LR5a2db6e7f.gjm(37, "org.dsi.ifc.modelapi.DSIModelAPI", 1300919239, -904616957), -1, objectArray);
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
            this.h.invoke(this, LR5a2db6e7f.gjm(38, "org.dsi.ifc.modelapi.DSIModelAPI", 1300919239, 1805755651), -1, objectArray);
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
            this.h.invoke(this, LR5a2db6e7f.gjm(39, "org.dsi.ifc.modelapi.DSIModelAPI", 1300919239, -864245041), -1, objectArray);
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
    public void setConsumptionInfo(ConsumptionInfo[] consumptionInfoArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = consumptionInfoArray;
            this.h.invoke(this, LR5a2db6e7f.gjm(40, "org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon", -1661721807, -54730077), 40, objectArray);
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
    public void setLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = mobilityHorizonLocationArray;
            this.h.invoke(this, LR5a2db6e7f.gjm(41, "org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon", -1853135596, 539566029), 41, objectArray);
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
    public void setConsideredLocationTypes(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR5a2db6e7f.gjm(42, "org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon", 1061733182, 3523), 42, objectArray);
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
    public void setDriveTrainMode(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a2db6e7f.gjm(43, "org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon", -667672065, 1687814400), 43, objectArray);
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
    public void requestLocationRangeLevel(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5a2db6e7f.gjm(44, "org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon", 1083833822, 1687814400), 44, objectArray);
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

