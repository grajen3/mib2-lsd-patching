/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.mirrorlink;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.mirrorlink.DSIMirrorLinkReply;
import de.esolutions.fw.comm.dsi.mirrorlink.impl.DSIMirrorLinkReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.mirrorlink.Application;
import org.dsi.ifc.mirrorlink.DSIMirrorLinkListener;
import org.dsi.ifc.mirrorlink.Device;
import org.dsi.ifc.mirrorlink.Notification;

public class DSIMirrorLinkDispatcher
extends AbstractDispatcher
implements DSIMirrorLinkReply {
    private DSIMirrorLinkReplyService service = new DSIMirrorLinkReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMirrorLinkDispatcher(int n) {
        super(n, (class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener == null ? (class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener = DSIMirrorLinkDispatcher.class$("org.dsi.ifc.mirrorlink.DSIMirrorLinkListener")) : class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void responseClientCapabilities(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseClientCapabilities(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAccessMode(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseAccessMode(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDayNightMode(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseDayNightMode(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUsableViewPort(int n, int n2, int n3, int n4, int n5) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseUsableViewPort(n, n2, n3, n4, n5);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseContextVisible(boolean bl, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseContextVisible(bl, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseConnectDevice(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseConnectDevice(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDisconnectDevice(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseDisconnectDevice(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRotateScreen(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseRotateScreen(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSoftKeyEvent(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseSoftKeyEvent(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseLaunchApp(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseLaunchApp(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseTerminateApp(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseTerminateApp(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSpellerResult(String string, String string2, boolean bl, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseSpellerResult(string, string2, bl, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSendString(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseSendString(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAudioOption(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseAudioOption(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAudioConnectionAudible(int n, boolean bl, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseAudioConnectionAudible(n, bl, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSendTouchEvents(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseSendTouchEvents(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDiscoveredDevices(Device[] deviceArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateDiscoveredDevices(deviceArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateDiscoveredDevices(deviceArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDeviceConnectionStatus(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateDeviceConnectionStatus(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateDeviceConnectionStatus(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDeviceSoftKeys(int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateDeviceSoftKeys(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateDeviceSoftKeys(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateApplicationStatus(int n, int n2, int n3, int n4) {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(5, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateApplicationStatus(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateApplicationStatus(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateScreenOrientation(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(6, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateScreenOrientation(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateScreenOrientation(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateShowKeyboard(int n, String string, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(7, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateShowKeyboard(n, string, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateShowKeyboard(n, string, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateScreenOrientationAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(8, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateScreenOrientationAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateScreenOrientationAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateScreenRotationAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(9, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateScreenRotationAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateScreenRotationAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAudioConnectionRequested(int n, boolean bl, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(10, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateAudioConnectionRequested(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateAudioConnectionRequested(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseKeyboardMode(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseKeyboardMode(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailableApplicationsList(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(11, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateAvailableApplicationsList(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateAvailableApplicationsList(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAvailableApplicationsWindow(int n, Application[] applicationArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseAvailableApplicationsWindow(n, applicationArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSingleApplicationMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(12, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateSingleApplicationMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateSingleApplicationMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDisplayKeyboard(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseDisplayKeyboard(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDismissHMIKeyboard(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseDismissHMIKeyboard(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseFactorySettings(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseFactorySettings(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePhoneViewAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(13, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updatePhoneViewAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updatePhoneViewAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePhoneView(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responsePhoneView(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUncertifiedContent(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(14, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateUncertifiedContent(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateUncertifiedContent(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDeviceStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(15, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateDeviceStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateDeviceStatus(n, n2);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(16, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateSWaPStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateSWaPStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseContextSwitched() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.responseContextSwitched();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateShowNotification(Notification notification, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(17, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateShowNotification(notification, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateShowNotification(notification, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNotificationServiceEnabled(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(18, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateNotificationServiceEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateNotificationServiceEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLocationDataServicesEnabled(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(19, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateLocationDataServicesEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateLocationDataServicesEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSwitchToClientNativeUI(int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    this.confirmNotificationListener(20, dSIMirrorLinkListener);
                    dSIMirrorLinkListener.updateSwitchToClientNativeUI(n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)iterator.next();
                    dSIMirrorLinkListener.updateSwitchToClientNativeUI(n);
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
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    dSIMirrorLinkListener.asyncException(n, string, n2);
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
                    DSIMirrorLinkListener dSIMirrorLinkListener = (DSIMirrorLinkListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMirrorLinkDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMirrorLinkDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMirrorLinkListener, new Object[]{string, string2});
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

