/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.androidauto;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.androidauto.DSIAndroidAutoReply;
import de.esolutions.fw.comm.dsi.androidauto.impl.DSIAndroidAutoReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.AppStateRequest;
import org.dsi.ifc.androidauto.CallState;
import org.dsi.ifc.androidauto.DSIAndroidAutoListener;
import org.dsi.ifc.androidauto.PlaybackInfo;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ResourceRequest;
import org.dsi.ifc.androidauto.TelephonyState;
import org.dsi.ifc.androidauto.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSIAndroidAutoDispatcher
extends AbstractDispatcher
implements DSIAndroidAutoReply {
    private DSIAndroidAutoReplyService service = new DSIAndroidAutoReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$DSIAndroidAutoListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAndroidAutoDispatcher(int n) {
        super(n, (class$org$dsi$ifc$androidauto$DSIAndroidAutoListener == null ? (class$org$dsi$ifc$androidauto$DSIAndroidAutoListener = DSIAndroidAutoDispatcher.class$("org.dsi.ifc.androidauto.DSIAndroidAutoListener")) : class$org$dsi$ifc$androidauto$DSIAndroidAutoListener).getName());
    }

   // @Override
    public IReplyService getService() {
        return this.service;
    }

   // @Override
    public void setMode(Resource[] resourceArray, AppState[] appStateArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)objectArray[i2];
                    dSIAndroidAutoListener.setMode(resourceArray, appStateArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)objectArray[i2];
                    dSIAndroidAutoListener.requestModeChange(resourceRequestArray, appStateRequestArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void updateCallState(CallState[] callStateArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    this.confirmNotificationListener(8, dSIAndroidAutoListener);
                    dSIAndroidAutoListener.updateCallState(callStateArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    dSIAndroidAutoListener.updateCallState(callStateArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void updateTelephonyState(TelephonyState telephonyState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    this.confirmNotificationListener(7, dSIAndroidAutoListener);
                    dSIAndroidAutoListener.updateTelephonyState(telephonyState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    dSIAndroidAutoListener.updateTelephonyState(telephonyState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void updateNowPlayingData(TrackData trackData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    this.confirmNotificationListener(3, dSIAndroidAutoListener);
                    dSIAndroidAutoListener.updateNowPlayingData(trackData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    dSIAndroidAutoListener.updateNowPlayingData(trackData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    this.confirmNotificationListener(4, dSIAndroidAutoListener);
                    dSIAndroidAutoListener.updatePlaybackState(playbackInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    dSIAndroidAutoListener.updatePlaybackState(playbackInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void updatePlayposition(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    this.confirmNotificationListener(5, dSIAndroidAutoListener);
                    dSIAndroidAutoListener.updatePlayposition(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    dSIAndroidAutoListener.updatePlayposition(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    this.confirmNotificationListener(6, dSIAndroidAutoListener);
                    dSIAndroidAutoListener.updateCoverArtUrl(resourceLocator, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    dSIAndroidAutoListener.updateCoverArtUrl(resourceLocator, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void updateNavigationNextTurnEvent(String string, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 0x80) == 128) {
            n5 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    this.confirmNotificationListener(11, dSIAndroidAutoListener);
                    dSIAndroidAutoListener.updateNavigationNextTurnEvent(string, n, n2, n3, n4, n5);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    dSIAndroidAutoListener.updateNavigationNextTurnEvent(string, n, n2, n3, n4, n5);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void updateNavigationNextTurnDistance(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    this.confirmNotificationListener(12, dSIAndroidAutoListener);
                    dSIAndroidAutoListener.updateNavigationNextTurnDistance(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)iterator.next();
                    dSIAndroidAutoListener.updateNavigationNextTurnDistance(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void setExternalDestination(double d2, double d3, String string, String string2) {
        System.out.println("DSIAndroidAutoDispatcher.setExternalDestination(" + d2 +", "+ d3 +", "+ string +", "+ string2 + ")");
        new Exception("Stack trace").printStackTrace();  

        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)objectArray[i2];
                    dSIAndroidAutoListener.setExternalDestination(d2, d3, string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void asyncException(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)objectArray[i2];
                    dSIAndroidAutoListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

   // @Override
    public void yyIndication(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAndroidAutoListener dSIAndroidAutoListener = (DSIAndroidAutoListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAndroidAutoDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAndroidAutoDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAndroidAutoListener, new Object[]{string, string2});
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
            throw new NoClassDefFoundError(string);
        }
    }
}

