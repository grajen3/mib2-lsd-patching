/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carplay;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.carplay.DSICarplayReply;
import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DSICarplayListener;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.PlaybackInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.TelephonyState;
import org.dsi.ifc.carplay.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSICarplayDispatcher
extends AbstractDispatcher
implements DSICarplayReply {
    private DSICarplayReplyService service = new DSICarplayReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$carplay$DSICarplayListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarplayDispatcher(int n) {
        super(n, (class$org$dsi$ifc$carplay$DSICarplayListener == null ? (class$org$dsi$ifc$carplay$DSICarplayListener = DSICarplayDispatcher.class$("org.dsi.ifc.carplay.DSICarplayListener")) : class$org$dsi$ifc$carplay$DSICarplayListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateMode(Resource[] resourceArray, AppState[] appStateArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarplayListener);
                    dSICarplayListener.updateMode(resourceArray, appStateArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    dSICarplayListener.updateMode(resourceArray, appStateArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)objectArray[i2];
                    dSICarplayListener.responseModeChange(resourceArray, appStateArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestBTDeactivation(String string, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)objectArray[i2];
                    dSICarplayListener.requestBTDeactivation(string, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDeviceInfo(DeviceInfo deviceInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarplayListener);
                    dSICarplayListener.updateDeviceInfo(deviceInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    dSICarplayListener.updateDeviceInfo(deviceInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCallState(CallState[] callStateArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarplayListener);
                    dSICarplayListener.updateCallState(callStateArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    dSICarplayListener.updateCallState(callStateArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTelephonyState(TelephonyState telephonyState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarplayListener);
                    dSICarplayListener.updateTelephonyState(telephonyState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    dSICarplayListener.updateTelephonyState(telephonyState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNowPlayingData(TrackData trackData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarplayListener);
                    dSICarplayListener.updateNowPlayingData(trackData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    dSICarplayListener.updateNowPlayingData(trackData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarplayListener);
                    dSICarplayListener.updatePlaybackState(playbackInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    dSICarplayListener.updatePlaybackState(playbackInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePlayposition(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarplayListener);
                    dSICarplayListener.updatePlayposition(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    dSICarplayListener.updatePlayposition(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarplayListener);
                    dSICarplayListener.updateCoverArtUrl(resourceLocator, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    dSICarplayListener.updateCoverArtUrl(resourceLocator, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTextInputState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarplayListener);
                    dSICarplayListener.updateTextInputState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    dSICarplayListener.updateTextInputState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void duckAudio(int n, double d2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)objectArray[i2];
                    dSICarplayListener.duckAudio(n, d2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void unduckAudio(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)objectArray[i2];
                    dSICarplayListener.unduckAudio(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void oemAppSelected() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)objectArray[i2];
                    dSICarplayListener.oemAppSelected();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMainAudioType(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarplayListener);
                    dSICarplayListener.updateMainAudioType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)iterator.next();
                    dSICarplayListener.updateMainAudioType(n, n2);
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
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)objectArray[i2];
                    dSICarplayListener.asyncException(n, string, n2);
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
                    DSICarplayListener dSICarplayListener = (DSICarplayListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarplayDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarplayDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarplayListener, new Object[]{string, string2});
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

