/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombisync2;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.kombisync2.DSIKombiSyncReply;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.kombisync2.DSIKombiSyncListener;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;

public class DSIKombiSyncDispatcher
extends AbstractDispatcher
implements DSIKombiSyncReply {
    private DSIKombiSyncReplyService service = new DSIKombiSyncReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$DSIKombiSyncListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIKombiSyncDispatcher(int n) {
        super(n, (class$org$dsi$ifc$kombisync2$DSIKombiSyncListener == null ? (class$org$dsi$ifc$kombisync2$DSIKombiSyncListener = DSIKombiSyncDispatcher.class$("org.dsi.ifc.kombisync2.DSIKombiSyncListener")) : class$org$dsi$ifc$kombisync2$DSIKombiSyncListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateKombiCommunicationState(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    this.confirmNotificationListener(1, dSIKombiSyncListener);
                    dSIKombiSyncListener.updateKombiCommunicationState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    dSIKombiSyncListener.updateKombiCommunicationState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateKombiMessageStateDisplayIdentification(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    this.confirmNotificationListener(2, dSIKombiSyncListener);
                    dSIKombiSyncListener.updateKombiMessageStateDisplayIdentification(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    dSIKombiSyncListener.updateKombiMessageStateDisplayIdentification(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateKombiMessageStateDisplayRequestResponse(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    this.confirmNotificationListener(3, dSIKombiSyncListener);
                    dSIKombiSyncListener.updateKombiMessageStateDisplayRequestResponse(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    dSIKombiSyncListener.updateKombiMessageStateDisplayRequestResponse(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateKombiMessageStateDisplayStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    this.confirmNotificationListener(4, dSIKombiSyncListener);
                    dSIKombiSyncListener.updateKombiMessageStateDisplayStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    dSIKombiSyncListener.updateKombiMessageStateDisplayStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateKombiMessageStatePopupActionRequest(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    this.confirmNotificationListener(5, dSIKombiSyncListener);
                    dSIKombiSyncListener.updateKombiMessageStatePopupActionRequest(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    dSIKombiSyncListener.updateKombiMessageStatePopupActionRequest(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateKombiMessageStatePopupRegisterResponse(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    this.confirmNotificationListener(6, dSIKombiSyncListener);
                    dSIKombiSyncListener.updateKombiMessageStatePopupRegisterResponse(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    dSIKombiSyncListener.updateKombiMessageStatePopupRegisterResponse(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateKombiMessageStatePopupStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    this.confirmNotificationListener(7, dSIKombiSyncListener);
                    dSIKombiSyncListener.updateKombiMessageStatePopupStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    dSIKombiSyncListener.updateKombiMessageStatePopupStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseKombiDisplayRequestResponse(DisplayRequestResponse displayRequestResponse) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)objectArray[i2];
                    dSIKombiSyncListener.responseKombiDisplayRequestResponse(displayRequestResponse);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseKombiDisplayStatus(DisplayStatus displayStatus) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)objectArray[i2];
                    dSIKombiSyncListener.responseKombiDisplayStatus(displayStatus);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseKombiDisplayIdentification(DisplayIdentification displayIdentification) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)objectArray[i2];
                    dSIKombiSyncListener.responseKombiDisplayIdentification(displayIdentification);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseKombiPopupRegisterResponse(PopupRegisterRequestResponse popupRegisterRequestResponse) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)objectArray[i2];
                    dSIKombiSyncListener.responseKombiPopupRegisterResponse(popupRegisterRequestResponse);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseKombiPopupActionRequest(PopupActionRequestResponse popupActionRequestResponse) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)objectArray[i2];
                    dSIKombiSyncListener.responseKombiPopupActionRequest(popupActionRequestResponse);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseKombiPopupStatus(PopupStatus popupStatus) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)objectArray[i2];
                    dSIKombiSyncListener.responseKombiPopupStatus(popupStatus);
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
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)objectArray[i2];
                    dSIKombiSyncListener.asyncException(n, string, n2);
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
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIKombiSyncDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIKombiSyncDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIKombiSyncListener, new Object[]{string, string2});
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

