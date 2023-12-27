/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIInterceptor;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbListListener;

public class DSINavInterceptor
extends DSIInterceptor {
    public static final String DSINAVIGATION_CLASSNAME = (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern();
    public static final String DSINAVIGATIONLISTENER_CLASSNAME = (class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener).getName().intern();
    public static final String DSIADBLISTLISTENER_CLASSNAME = (class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = DSINavInterceptor.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener).getName().intern();
    private static int DSI_NAVIGATION_TYPE_IDX;
    private final int startSpellerMethodId;
    private final int restoreStateMethodId;
    private final int liValueListMethodId;
    private final int liResultMethodId;
    private final int lispUpdateSpellerResultMethodId;
    private Object[] liResultMethodArgs;
    private Object[] liValueListMethodArgs;
    private Object[] lispUpdateSpellerResultMethodArgs;
    private final int lispRequestValueListByListIndexMethodId;
    private final int dsiAdbListUpdateViewSizeMethodId;
    private boolean blockNumberOfUpdateViewSize = false;
    private boolean blockWrongTriple = false;
    private boolean injectLispUpdateSpellerResult = false;
    private DSINavigationListener dsiNavigationListener;
    private int liCurrentStateMethodId;
    private boolean intercepting = false;
    private final int etcSetDemoModeMethodId;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;

    public void testInternalMethods() {
        if (this.dsiNavigationListener != null && this.injectLispUpdateSpellerResult && this.restoreStateMethodId == 0 && this.startSpellerMethodId == 0) {
            this.dsiNavigationListener.liResult(0L);
            this.onBefore_DSINavigation_liRestoreState(new Object[0]);
            this.onBefore_DSINavigation_liStartSpeller(new Object[0]);
            this.onBefore_DSINavigationListener_liResult(new Object[0]);
            this.onBefore_DSINavigationListener_lispUpdateSpellerResult(new Object[0]);
            this.onBefore_DSINavigationListener_liValueList(new Object[0]);
        }
    }

    private void invokeListenerMethod(Class clazz, int n, Object[] objectArray) {
        try {
            ServiceManager.reflectionFactory.getListenersMmao(DSI_NAVIGATION_TYPE_IDX).invoke(n, this.getResponseListener(clazz), objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            ServiceManager.logger.error(16384, invocationTargetException.getTargetException().toString());
        }
    }

    private void info(String string) {
        ServiceManager.logger.info(16384).append("DSINavInterceptor").append(string).log();
    }

    private void warn(String string) {
        ServiceManager.logger.warn(16384).append("DSINavInterceptor").append(string).log();
    }

    private void error(String string) {
        ServiceManager.logger.error(16384).append("DSINavInterceptor").append(string).log();
    }

    private void startTripleBlocking() {
        this.blockWrongTriple = true;
        this.liResultMethodArgs = null;
        this.lispUpdateSpellerResultMethodArgs = null;
        this.liValueListMethodArgs = null;
    }

    private void finishTripleBlocking() {
        this.blockWrongTriple = false;
        this.liResultMethodArgs = null;
        this.lispUpdateSpellerResultMethodArgs = null;
        this.liValueListMethodArgs = null;
    }

    private boolean verifyTripleReceived() {
        boolean bl;
        boolean bl2 = bl = this.liResultMethodArgs != null && this.liValueListMethodArgs != null && this.lispUpdateSpellerResultMethodArgs != null;
        if (bl) {
            boolean bl3;
            LIValueList lIValueList = (LIValueList)this.liValueListMethodArgs[0];
            int n = (Integer)this.lispUpdateSpellerResultMethodArgs[1];
            boolean bl4 = bl3 = n == 0x2800000 || n == 0xF800000 || n == 0x1800000 || n == 0x9800000 || n == 0xA800000 || n == 0xB800000 || n == 0xD800000;
            if (lIValueList != null && null == lIValueList.list && !bl3) {
                this.warn("triple blocked");
            } else {
                this.intercepting = true;
                this.invokeListenerMethod(class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.liResultMethodId, this.liResultMethodArgs);
                this.invokeListenerMethod(class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.liValueListMethodId, this.liValueListMethodArgs);
                this.invokeListenerMethod(class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.lispUpdateSpellerResultMethodId, this.lispUpdateSpellerResultMethodArgs);
                this.intercepting = false;
            }
            this.finishTripleBlocking();
        }
        return false;
    }

    private boolean onBefore_DSINavigation_liStartSpeller(Object[] objectArray) {
        int n = (Integer)objectArray[0];
        switch (n) {
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 16: 
            case 32769: {
                this.startTripleBlocking();
                break;
            }
        }
        return true;
    }

    private boolean onBefore_DSINavigation_liRestoreState(Object[] objectArray) {
        this.startTripleBlocking();
        return true;
    }

    private boolean onBefore_DSINavigation_lispRequestValueListByListIndex(Object[] objectArray) {
        this.injectLispUpdateSpellerResult = true;
        return true;
    }

    private boolean onBefore_DSINavigationListener_liValueList(Object[] objectArray) {
        if (this.blockWrongTriple) {
            this.liValueListMethodArgs = (Object[])objectArray.clone();
            this.verifyTripleReceived();
            return false;
        }
        return true;
    }

    private boolean onBefore_DSINavigationListener_liResult(Object[] objectArray) {
        if (this.blockWrongTriple) {
            this.liResultMethodArgs = (Object[])objectArray.clone();
            this.verifyTripleReceived();
            return false;
        }
        return true;
    }

    private boolean onBefore_DSINavigationListener_lispUpdateSpellerResult(Object[] objectArray) {
        if (this.blockWrongTriple) {
            this.lispUpdateSpellerResultMethodArgs = (Object[])objectArray.clone();
            this.verifyTripleReceived();
            return false;
        }
        return true;
    }

    private boolean onBefore_DSINavigationListener_liUpdateCurrentState(Object[] objectArray) {
        for (int i2 = 1; i2 < 3; ++i2) {
            if (objectArray[i2] != null) continue;
            objectArray[i2] = new int[0];
            this.warn("prevented (null) in liCurrentState");
        }
        return true;
    }

    private boolean onBefore_DSIAdbListListener_updateViewSize(int n, Object[] objectArray) {
        if (!this.blockNumberOfUpdateViewSize) {
            this.blockNumberOfUpdateViewSize = true;
            for (int i2 = 0; i2 < 4; ++i2) {
                if (i2 != n) {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)this.getNotificationListener(class$org$dsi$ifc$organizer$DSIAdbListListener == null ? DSINavInterceptor.class$("org.dsi.ifc.organizer.DSIAdbListListener") : class$org$dsi$ifc$organizer$DSIAdbListListener, i2);
                    if (dSIAdbListListener != null) {
                        dSIAdbListListener.updateViewSize((AdbViewSize)objectArray[0], (Integer)objectArray[1]);
                        this.error(new StringBuffer().append("forwarded updateViewSize to instance: ").append(i2).toString());
                        continue;
                    }
                    this.error(new StringBuffer().append("forwarded updateViewSize to instance: ").append(i2).append(" no listener!").toString());
                    continue;
                }
                this.error(new StringBuffer().append("received updateViewSize on instance: ").append(i2).toString());
            }
            this.blockNumberOfUpdateViewSize = false;
        }
        return true;
    }

    public DSINavInterceptor() {
        this.info("initializing nav interceptor - A");
        this.startSpellerMethodId = this.getDSIServiceMethodId(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, "liStartSpeller");
        this.restoreStateMethodId = this.getDSIServiceMethodId(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, "liRestoreState");
        this.lispRequestValueListByListIndexMethodId = this.getDSIServiceMethodId(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, "lispRequestValueListByListIndex");
        this.liValueListMethodId = this.getDSIListenerMethodId(class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, "liValueList");
        this.liResultMethodId = this.getDSIListenerMethodId(class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, "liResult");
        this.lispUpdateSpellerResultMethodId = this.getDSIListenerMethodId(class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, "lispUpdateSpellerResult");
        this.dsiNavigationListener = (DSINavigationListener)this.getResponseListener(class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.dsiAdbListUpdateViewSizeMethodId = this.getDSIListenerMethodId(class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = DSINavInterceptor.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, "updateViewSize");
        this.liCurrentStateMethodId = this.getDSIListenerMethodId(class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, "liCurrentState");
        this.etcSetDemoModeMethodId = this.getDSIServiceMethodId(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, "etcSetDemoMode");
        this.intercepting = false;
    }

    @Override
    public boolean before(String string, int n, int n2, Object[] objectArray) {
        if (this.intercepting) {
            return true;
        }
        if (DSINAVIGATION_CLASSNAME == string) {
            if (this.lispRequestValueListByListIndexMethodId == n2) {
                return this.onBefore_DSINavigation_lispRequestValueListByListIndex(objectArray);
            }
            if (this.etcSetDemoModeMethodId == n2) {
                ((DSINavigationListener)this.getResponseListener(class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavInterceptor.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener)).etcSetDemoModeResult(0);
            }
        } else if (string == DSINAVIGATIONLISTENER_CLASSNAME) {
            if (this.liCurrentStateMethodId == n2) {
                return this.onBefore_DSINavigationListener_liUpdateCurrentState(objectArray);
            }
        } else if (string == DSIADBLISTLISTENER_CLASSNAME && this.dsiAdbListUpdateViewSizeMethodId == n2) {
            return this.onBefore_DSIAdbListListener_updateViewSize(n, objectArray);
        }
        return true;
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
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.SERVICE_TS_NS.length; ++i2) {
            if (RuntimeGeneratedConstants.SERVICE_TS_NS[i2].intern() != DSINAVIGATION_CLASSNAME) continue;
            DSI_NAVIGATION_TYPE_IDX = i2;
            break;
        }
    }
}

