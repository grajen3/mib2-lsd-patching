/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.powermanagement;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.powermanagement.DSIPowerManagementReply;
import de.esolutions.fw.comm.dsi.powermanagement.impl.DSIPowerManagementReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;

public class DSIPowerManagementDispatcher
extends AbstractDispatcher
implements DSIPowerManagementReply {
    private DSIPowerManagementReplyService service = new DSIPowerManagementReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIPowerManagementDispatcher(int n) {
        super(n, (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = DSIPowerManagementDispatcher.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updatePowerManagementState(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    this.confirmNotificationListener(1, dSIPowerManagementListener);
                    dSIPowerManagementListener.updatePowerManagementState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    dSIPowerManagementListener.updatePowerManagementState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePowerManagementStateRight(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    this.confirmNotificationListener(2, dSIPowerManagementListener);
                    dSIPowerManagementListener.updatePowerManagementStateRight(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    dSIPowerManagementListener.updatePowerManagementStateRight(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBEMState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    this.confirmNotificationListener(3, dSIPowerManagementListener);
                    dSIPowerManagementListener.updateBEMState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    dSIPowerManagementListener.updateBEMState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTelMaxPopup(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    this.confirmNotificationListener(8, dSIPowerManagementListener);
                    dSIPowerManagementListener.updateTelMaxPopup(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    dSIPowerManagementListener.updateTelMaxPopup(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTStandbyPopup(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    this.confirmNotificationListener(11, dSIPowerManagementListener);
                    dSIPowerManagementListener.updateTStandbyPopup(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    dSIPowerManagementListener.updateTStandbyPopup(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateClampSignal(ClampSignal clampSignal, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    this.confirmNotificationListener(4, dSIPowerManagementListener);
                    dSIPowerManagementListener.updateClampSignal(clampSignal, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    dSIPowerManagementListener.updateClampSignal(clampSignal, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRVCActive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    this.confirmNotificationListener(7, dSIPowerManagementListener);
                    dSIPowerManagementListener.updateRVCActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    dSIPowerManagementListener.updateRVCActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateChildLockState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    this.confirmNotificationListener(5, dSIPowerManagementListener);
                    dSIPowerManagementListener.updateChildLockState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    dSIPowerManagementListener.updateChildLockState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLastOn(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    this.confirmNotificationListener(6, dSIPowerManagementListener);
                    dSIPowerManagementListener.updateLastOn(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    dSIPowerManagementListener.updateLastOn(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSplashScreenAnimation(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    this.confirmNotificationListener(9, dSIPowerManagementListener);
                    dSIPowerManagementListener.updateSplashScreenAnimation(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)iterator.next();
                    dSIPowerManagementListener.updateSplashScreenAnimation(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)objectArray[i2];
                    dSIPowerManagementListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void yyIndication(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIPowerManagementDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIPowerManagementDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIPowerManagementListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

