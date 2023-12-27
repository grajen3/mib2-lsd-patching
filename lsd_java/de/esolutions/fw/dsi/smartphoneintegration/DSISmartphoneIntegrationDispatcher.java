/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.smartphoneintegration;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.smartphoneintegration.DSISmartphoneIntegrationReply;
import de.esolutions.fw.comm.dsi.smartphoneintegration.impl.DSISmartphoneIntegrationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegrationListener;
import org.dsi.ifc.smartphoneintegration.Device;

public class DSISmartphoneIntegrationDispatcher
extends AbstractDispatcher
implements DSISmartphoneIntegrationReply {
    private DSISmartphoneIntegrationReplyService service = new DSISmartphoneIntegrationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISmartphoneIntegrationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener = DSISmartphoneIntegrationDispatcher.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegrationListener")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateDiscoveredDevices(Device[] deviceArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)iterator.next();
                    this.confirmNotificationListener(1, dSISmartphoneIntegrationListener);
                    dSISmartphoneIntegrationListener.updateDiscoveredDevices(deviceArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)iterator.next();
                    dSISmartphoneIntegrationListener.updateDiscoveredDevices(deviceArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDeviceConnectionState(int n, int n2, int n3, int n4) {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)iterator.next();
                    this.confirmNotificationListener(2, dSISmartphoneIntegrationListener);
                    dSISmartphoneIntegrationListener.updateDeviceConnectionState(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)iterator.next();
                    dSISmartphoneIntegrationListener.updateDeviceConnectionState(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseFactorySettings(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)objectArray[i2];
                    dSISmartphoneIntegrationListener.responseFactorySettings(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSWaPStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)iterator.next();
                    this.confirmNotificationListener(3, dSISmartphoneIntegrationListener);
                    dSISmartphoneIntegrationListener.updateSWaPStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)iterator.next();
                    dSISmartphoneIntegrationListener.updateSWaPStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUSBResetActive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)iterator.next();
                    this.confirmNotificationListener(4, dSISmartphoneIntegrationListener);
                    dSISmartphoneIntegrationListener.updateUSBResetActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)iterator.next();
                    dSISmartphoneIntegrationListener.updateUSBResetActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAppConnectContextRequested(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)iterator.next();
                    this.confirmNotificationListener(5, dSISmartphoneIntegrationListener);
                    dSISmartphoneIntegrationListener.updateAppConnectContextRequested(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)iterator.next();
                    dSISmartphoneIntegrationListener.updateAppConnectContextRequested(bl, n);
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
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)objectArray[i2];
                    dSISmartphoneIntegrationListener.asyncException(n, string, n2);
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
                    DSISmartphoneIntegrationListener dSISmartphoneIntegrationListener = (DSISmartphoneIntegrationListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISmartphoneIntegrationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISmartphoneIntegrationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISmartphoneIntegrationListener, new Object[]{string, string2});
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

