/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.wirelesscharging;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.wirelesscharging.DSIWirelessChargingReply;
import de.esolutions.fw.comm.dsi.wirelesscharging.impl.DSIWirelessChargingReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.wirelesscharging.DSIWirelessChargingListener;

public class DSIWirelessChargingDispatcher
extends AbstractDispatcher
implements DSIWirelessChargingReply {
    private DSIWirelessChargingReplyService service = new DSIWirelessChargingReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIWirelessChargingDispatcher(int n) {
        super(n, (class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener == null ? (class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener = DSIWirelessChargingDispatcher.class$("org.dsi.ifc.wirelesscharging.DSIWirelessChargingListener")) : class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateChargingInfo(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIWirelessChargingListener dSIWirelessChargingListener = (DSIWirelessChargingListener)iterator.next();
                    this.confirmNotificationListener(1, dSIWirelessChargingListener);
                    dSIWirelessChargingListener.updateChargingInfo(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIWirelessChargingListener dSIWirelessChargingListener = (DSIWirelessChargingListener)iterator.next();
                    dSIWirelessChargingListener.updateChargingInfo(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryLevel(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIWirelessChargingListener dSIWirelessChargingListener = (DSIWirelessChargingListener)iterator.next();
                    this.confirmNotificationListener(2, dSIWirelessChargingListener);
                    dSIWirelessChargingListener.updateBatteryLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIWirelessChargingListener dSIWirelessChargingListener = (DSIWirelessChargingListener)iterator.next();
                    dSIWirelessChargingListener.updateBatteryLevel(n, n2);
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
                    DSIWirelessChargingListener dSIWirelessChargingListener = (DSIWirelessChargingListener)objectArray[i2];
                    dSIWirelessChargingListener.asyncException(n, string, n2);
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
                    DSIWirelessChargingListener dSIWirelessChargingListener = (DSIWirelessChargingListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIWirelessChargingDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIWirelessChargingDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIWirelessChargingListener, new Object[]{string, string2});
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

