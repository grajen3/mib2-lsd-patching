/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.framework.internal.framework.util.LogUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.ApiPersFlush;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.persistence.DSIPersistence;

public final class ApiPersDsi {
    private static DSIPersistence mProxy;
    private static int mFlushCounter;
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistence;
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistenceListener;

    public static void enterEngineeringSession(int n) {
        mProxy.enterEngineeringSession(n);
    }

    public static void exitEngineeringSession(int n) {
        mProxy.exitEngineeringSession(n);
    }

    public static void flushSQLDatabase() {
        PersDebug.info("Persistence: Flush the SQL Database.");
        mProxy.flushSQLDatabase();
        ++mFlushCounter;
    }

    public static int getFlushCounter() {
        return mFlushCounter;
    }

    public static void initialize(TargetHsmImpl targetHsmImpl) {
        DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
        mProxy = (DSIPersistence)dSIServiceLocator.getService(targetHsmImpl, class$org$dsi$ifc$persistence$DSIPersistence == null ? (class$org$dsi$ifc$persistence$DSIPersistence = ApiPersDsi.class$("org.dsi.ifc.persistence.DSIPersistence")) : class$org$dsi$ifc$persistence$DSIPersistence);
        DSIListener dSIListener = AdaptorFactory.createDSIListenerMethodAdapter(targetHsmImpl.getHsm(), class$org$dsi$ifc$persistence$DSIPersistenceListener == null ? (class$org$dsi$ifc$persistence$DSIPersistenceListener = ApiPersDsi.class$("org.dsi.ifc.persistence.DSIPersistenceListener")) : class$org$dsi$ifc$persistence$DSIPersistenceListener);
        dSIServiceLocator.addResponseListener(targetHsmImpl, class$org$dsi$ifc$persistence$DSIPersistenceListener == null ? (class$org$dsi$ifc$persistence$DSIPersistenceListener = ApiPersDsi.class$("org.dsi.ifc.persistence.DSIPersistenceListener")) : class$org$dsi$ifc$persistence$DSIPersistenceListener, dSIListener);
        mProxy.setNotification(1, dSIListener);
    }

    public static void readBuffer(int n, long l) {
        PersDebug.ioLog("DSI RE", n, l, 0, (byte)3, "");
        mProxy.readBuffer(n, l);
    }

    public static void readInt(int n, long l) {
        mProxy.readInt(n, l);
    }

    public static void readString(int n, long l) {
        PersDebug.ioLog("DSI RE", n, l, 0, (byte)2, "");
        mProxy.readString(n, l);
    }

    public static void readStringArray(int n, long l) {
        PersDebug.ioLog("DSI RE", n, l, 0, (byte)4, "");
        mProxy.readStringArray(n, l);
    }

    public static void setSQLDatabaseMedium(int n) {
        mProxy.setSQLDatabaseMedium(n);
    }

    public static void writeBuffer(int n, long l, byte[] byArray) {
        PersDebug.ioLog("DSI WR", n, l, 0, (byte)3, LogUtil.toString(byArray, 400, true));
        mProxy.writeBuffer(n, l, byArray);
        ApiPersFlush.handleWrite(n, l);
    }

    public static void writeInt(int n, long l, int n2) {
        PersDebug.ioLog("DSI WR", n, l, 0, (byte)1, Integer.toString(n2));
        mProxy.writeInt(n, l, n2);
        ApiPersFlush.handleWrite(n, l);
    }

    public static void writeString(int n, long l, String string) {
        PersDebug.ioLog("DSI WR", n, l, 0, (byte)2, string);
        mProxy.writeString(n, l, string);
        ApiPersFlush.handleWrite(n, l);
    }

    public static void writeStringArray(int n, long l, String[] stringArray) {
        PersDebug.ioLog("DSI WR", n, l, 0, (byte)4, LogUtil.toString(stringArray, 400, true));
        mProxy.writeStringArray(n, l, stringArray);
        ApiPersFlush.handleWrite(n, l);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        mFlushCounter = 0;
    }
}

