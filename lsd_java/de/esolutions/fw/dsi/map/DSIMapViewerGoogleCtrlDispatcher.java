/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerGoogleCtrlReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerGoogleCtrlReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Rect;

public class DSIMapViewerGoogleCtrlDispatcher
extends AbstractDispatcher
implements DSIMapViewerGoogleCtrlReply {
    private DSIMapViewerGoogleCtrlReplyService service = new DSIMapViewerGoogleCtrlReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMapViewerGoogleCtrlDispatcher(int n) {
        super(n, (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener = DSIMapViewerGoogleCtrlDispatcher.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener")) : class$org$dsi$ifc$map$DSIMapViewerGoogleCtrlListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateAvailableLayers(LayerProperty[] layerPropertyArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMapViewerGoogleCtrlListener);
                    dSIMapViewerGoogleCtrlListener.updateAvailableLayers(layerPropertyArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    dSIMapViewerGoogleCtrlListener.updateAvailableLayers(layerPropertyArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVisibleLayers(int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMapViewerGoogleCtrlListener);
                    dSIMapViewerGoogleCtrlListener.updateVisibleLayers(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    dSIMapViewerGoogleCtrlListener.updateVisibleLayers(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMapViewerGoogleCtrlListener);
                    dSIMapViewerGoogleCtrlListener.updateAvailableLanguages(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    dSIMapViewerGoogleCtrlListener.updateAvailableLanguages(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCurrentLanguage(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMapViewerGoogleCtrlListener);
                    dSIMapViewerGoogleCtrlListener.updateCurrentLanguage(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    dSIMapViewerGoogleCtrlListener.updateCurrentLanguage(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateGoogleDataStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    this.confirmNotificationListener(6, dSIMapViewerGoogleCtrlListener);
                    dSIMapViewerGoogleCtrlListener.updateGoogleDataStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    dSIMapViewerGoogleCtrlListener.updateGoogleDataStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCopyrightPosition(Rect rect, int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    this.confirmNotificationListener(7, dSIMapViewerGoogleCtrlListener);
                    dSIMapViewerGoogleCtrlListener.updateCopyrightPosition(rect, n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)iterator.next();
                    dSIMapViewerGoogleCtrlListener.updateCopyrightPosition(rect, n, n2, n3);
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
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)objectArray[i2];
                    dSIMapViewerGoogleCtrlListener.asyncException(n, string, n2);
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
                    DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener = (DSIMapViewerGoogleCtrlListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMapViewerGoogleCtrlDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMapViewerGoogleCtrlDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMapViewerGoogleCtrlListener, new Object[]{string, string2});
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

