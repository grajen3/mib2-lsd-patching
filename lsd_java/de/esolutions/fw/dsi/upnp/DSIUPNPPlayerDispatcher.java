/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.upnp;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPPlayerReply;
import de.esolutions.fw.comm.dsi.upnp.impl.DSIUPNPPlayerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.upnp.DSIUPNPPlayerListener;
import org.dsi.ifc.upnp.DeviceInfo;
import org.dsi.ifc.upnp.EntryInfo;
import org.dsi.ifc.upnp.PlaybackMode;

public class DSIUPNPPlayerDispatcher
extends AbstractDispatcher
implements DSIUPNPPlayerReply {
    private DSIUPNPPlayerReplyService service = new DSIUPNPPlayerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$upnp$DSIUPNPPlayerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIUPNPPlayerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$upnp$DSIUPNPPlayerListener == null ? (class$org$dsi$ifc$upnp$DSIUPNPPlayerListener = DSIUPNPPlayerDispatcher.class$("org.dsi.ifc.upnp.DSIUPNPPlayerListener")) : class$org$dsi$ifc$upnp$DSIUPNPPlayerListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updatePlaybackModeList(String string, PlaybackMode[] playbackModeArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    this.confirmNotificationListener(4, dSIUPNPPlayerListener);
                    dSIUPNPPlayerListener.updatePlaybackModeList(string, playbackModeArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    dSIUPNPPlayerListener.updatePlaybackModeList(string, playbackModeArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePlaybackMode(String string, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    this.confirmNotificationListener(3, dSIUPNPPlayerListener);
                    dSIUPNPPlayerListener.updatePlaybackMode(string, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    dSIUPNPPlayerListener.updatePlaybackMode(string, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePlaybackState(String string, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    this.confirmNotificationListener(5, dSIUPNPPlayerListener);
                    dSIUPNPPlayerListener.updatePlaybackState(string, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    dSIUPNPPlayerListener.updatePlaybackState(string, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePlayPosition(String string, String string2, int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    this.confirmNotificationListener(6, dSIUPNPPlayerListener);
                    dSIUPNPPlayerListener.updatePlayPosition(string, string2, n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    dSIUPNPPlayerListener.updatePlayPosition(string, string2, n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDetailInfo(String string, EntryInfo entryInfo, ResourceLocator resourceLocator, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    this.confirmNotificationListener(1, dSIUPNPPlayerListener);
                    dSIUPNPPlayerListener.updateDetailInfo(string, entryInfo, resourceLocator, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    dSIUPNPPlayerListener.updateDetailInfo(string, entryInfo, resourceLocator, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDeviceList(DeviceInfo[] deviceInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    this.confirmNotificationListener(2, dSIUPNPPlayerListener);
                    dSIUPNPPlayerListener.updateDeviceList(deviceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    dSIUPNPPlayerListener.updateDeviceList(deviceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVolume(String string, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    this.confirmNotificationListener(7, dSIUPNPPlayerListener);
                    dSIUPNPPlayerListener.updateVolume(string, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)iterator.next();
                    dSIUPNPPlayerListener.updateVolume(string, n, n2);
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
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)objectArray[i2];
                    dSIUPNPPlayerListener.asyncException(n, string, n2);
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
                    DSIUPNPPlayerListener dSIUPNPPlayerListener = (DSIUPNPPlayerListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIUPNPPlayerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIUPNPPlayerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIUPNPPlayerListener, new Object[]{string, string2});
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

