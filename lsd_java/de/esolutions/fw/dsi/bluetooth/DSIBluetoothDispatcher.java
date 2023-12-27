/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.bluetooth;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.bluetooth.DSIBluetoothReply;
import de.esolutions.fw.comm.dsi.bluetooth.impl.DSIBluetoothReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

public class DSIBluetoothDispatcher
extends AbstractDispatcher
implements DSIBluetoothReply {
    private DSIBluetoothReplyService service = new DSIBluetoothReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIBluetoothDispatcher(int n) {
        super(n, (class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = DSIBluetoothDispatcher.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void responseAbortConnectService(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseAbortConnectService(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAbortInquiry(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseAbortInquiry(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAcceptIncomingServiceRequest(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseAcceptIncomingServiceRequest(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseConnectService(string, string2, n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseConnectServiceToInstance(string, string2, n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDisconnectService(String string, int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseDisconnectService(string, n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseGetServices(String string, String string2, int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseGetServices(string, string2, n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseInquiry(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseInquiry(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePasskeyResponse(String string, String string2, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responsePasskeyResponse(string, string2, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRemoveAuthentication(String string, String string2, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseRemoveAuthentication(string, string2, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseRestoreFactorySettings(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetA2DPUserSetting(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseSetA2DPUserSetting(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetAccessibleMode(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseSetAccessibleMode(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSwitchBTState(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseSwitchBTState(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void removeAuthenticationNoSupport(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.removeAuthenticationNoSupport(string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAccessibleMode(int n, boolean bl, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(1, dSIBluetoothListener);
                    dSIBluetoothListener.updateAccessibleMode(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateAccessibleMode(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBTState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(3, dSIBluetoothListener);
                    dSIBluetoothListener.updateBTState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateBTState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(4, dSIBluetoothListener);
                    dSIBluetoothListener.updateDiscoveredDevices(discoveredDevice, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateDiscoveredDevices(discoveredDevice, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHUCandBTHSState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(15, dSIBluetoothListener);
                    dSIBluetoothListener.updateHUCandBTHSState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateHUCandBTHSState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(11, dSIBluetoothListener);
                    dSIBluetoothListener.updateIncomingServiceRequest(requestIncomingService, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateIncomingServiceRequest(requestIncomingService, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(14, dSIBluetoothListener);
                    dSIBluetoothListener.updateMasterRoleRequestError(masterRoleRequestStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateMasterRoleRequestError(masterRoleRequestStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(7, dSIBluetoothListener);
                    dSIBluetoothListener.updatePasskeyState(passkeyStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updatePasskeyState(passkeyStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(10, dSIBluetoothListener);
                    dSIBluetoothListener.updateReconnectIndicator(reconnectInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateReconnectIndicator(reconnectInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(8, dSIBluetoothListener);
                    dSIBluetoothListener.updateServiceRequestState(serviceRequestStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateServiceRequestState(serviceRequestStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSupportedBTProfiles(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(12, dSIBluetoothListener);
                    dSIBluetoothListener.updateSupportedBTProfiles(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateSupportedBTProfiles(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(6, dSIBluetoothListener);
                    dSIBluetoothListener.updateTrustedDevices(trustedDeviceArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateTrustedDevices(trustedDeviceArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUserFriendlyName(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(9, dSIBluetoothListener);
                    dSIBluetoothListener.updateUserFriendlyName(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateUserFriendlyName(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateA2DPUserSetting(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(16, dSIBluetoothListener);
                    dSIBluetoothListener.updateA2DPUserSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updateA2DPUserSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    this.confirmNotificationListener(17, dSIBluetoothListener);
                    dSIBluetoothListener.updatePriorizedDeviceReconnect(bl, string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)iterator.next();
                    dSIBluetoothListener.updatePriorizedDeviceReconnect(bl, string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deviceDisonnectionInfo(String string, String string2, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.deviceDisonnectionInfo(string, string2, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void serviceRejectNoSupport(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.serviceRejectNoSupport(string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseReconnectSuspend(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseReconnectSuspend(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetPriorizedDeviceReconnect(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.responseSetPriorizedDeviceReconnect(n);
                    continue;
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
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    dSIBluetoothListener.asyncException(n, string, n2);
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
                    DSIBluetoothListener dSIBluetoothListener = (DSIBluetoothListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIBluetoothDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIBluetoothDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIBluetoothListener, new Object[]{string, string2});
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

