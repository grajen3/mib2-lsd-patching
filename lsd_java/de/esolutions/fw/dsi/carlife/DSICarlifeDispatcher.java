/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carlife;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.carlife.DSICarlifeReply;
import de.esolutions.fw.comm.dsi.carlife.impl.DSICarlifeReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSICarlifeDispatcher
extends AbstractDispatcher
implements DSICarlifeReply {
    private DSICarlifeReplyService service = new DSICarlifeReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$carlife$DSICarlifeListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarlifeDispatcher(int n) {
        super(n, (class$org$dsi$ifc$carlife$DSICarlifeListener == null ? (class$org$dsi$ifc$carlife$DSICarlifeListener = DSICarlifeDispatcher.class$("org.dsi.ifc.carlife.DSICarlifeListener")) : class$org$dsi$ifc$carlife$DSICarlifeListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void responseSetMode(Resource[] resourceArray, AppState[] appStateArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)objectArray[i2];
                    dSICarlifeListener.responseSetMode(resourceArray, appStateArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCallState(CallState callState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarlifeListener);
                    dSICarlifeListener.updateCallState(callState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    dSICarlifeListener.updateCallState(callState, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarlifeListener);
                    dSICarlifeListener.updateNowPlayingData(trackData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    dSICarlifeListener.updateNowPlayingData(trackData, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarlifeListener);
                    dSICarlifeListener.updatePlaybackState(playbackInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    dSICarlifeListener.updatePlaybackState(playbackInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePlaymodeState(PlaymodeInfo playmodeInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarlifeListener);
                    dSICarlifeListener.updatePlaymodeState(playmodeInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    dSICarlifeListener.updatePlaymodeState(playmodeInfo, n);
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
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarlifeListener);
                    dSICarlifeListener.updatePlayposition(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    dSICarlifeListener.updatePlayposition(n, n2);
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
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarlifeListener);
                    dSICarlifeListener.updateCoverArtUrl(resourceLocator, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    dSICarlifeListener.updateCoverArtUrl(resourceLocator, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNavigationNextTurnInfo(String string, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 0x80) == 128) {
            n5 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarlifeListener);
                    dSICarlifeListener.updateNavigationNextTurnInfo(string, n, n2, n3, n4, n5);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    dSICarlifeListener.updateNavigationNextTurnInfo(string, n, n2, n3, n4, n5);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarlifeListener);
                    dSICarlifeListener.updateDeviceInfo(deviceInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    dSICarlifeListener.updateDeviceInfo(deviceInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)objectArray[i2];
                    dSICarlifeListener.requestModeChange(resourceArray, appStateArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVideoAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarlifeListener);
                    dSICarlifeListener.updateVideoAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)iterator.next();
                    dSICarlifeListener.updateVideoAvailable(bl, n);
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
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)objectArray[i2];
                    dSICarlifeListener.asyncException(n, string, n2);
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
                    DSICarlifeListener dSICarlifeListener = (DSICarlifeListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarlifeDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarlifeDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarlifeListener, new Object[]{string, string2});
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

