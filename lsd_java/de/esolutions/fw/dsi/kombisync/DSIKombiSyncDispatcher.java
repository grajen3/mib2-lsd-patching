/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombisync;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.kombisync.DSIKombiSyncReply;
import de.esolutions.fw.comm.dsi.kombisync.impl.DSIKombiSyncReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.kombisync.DSIKombiSyncListener;
import org.dsi.ifc.kombisync.KombiDisplayRequest;
import org.dsi.ifc.kombisync.KombiDisplayStatus;
import org.dsi.ifc.kombisync.KombiPopupStatus;

public class DSIKombiSyncDispatcher
extends AbstractDispatcher
implements DSIKombiSyncReply {
    private DSIKombiSyncReplyService service = new DSIKombiSyncReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$kombisync$DSIKombiSyncListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIKombiSyncDispatcher(int n) {
        super(n, (class$org$dsi$ifc$kombisync$DSIKombiSyncListener == null ? (class$org$dsi$ifc$kombisync$DSIKombiSyncListener = DSIKombiSyncDispatcher.class$("org.dsi.ifc.kombisync.DSIKombiSyncListener")) : class$org$dsi$ifc$kombisync$DSIKombiSyncListener).getName());
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
    public void updateKombiMessageStateDisplayStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    this.confirmNotificationListener(2, dSIKombiSyncListener);
                    dSIKombiSyncListener.updateKombiMessageStateDisplayStatus(n, n2);
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
                    dSIKombiSyncListener.updateKombiMessageStateDisplayStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateKombiMessageStateDisplayRequest(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    this.confirmNotificationListener(3, dSIKombiSyncListener);
                    dSIKombiSyncListener.updateKombiMessageStateDisplayRequest(n, n2);
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
                    dSIKombiSyncListener.updateKombiMessageStateDisplayRequest(n, n2);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)iterator.next();
                    this.confirmNotificationListener(4, dSIKombiSyncListener);
                    dSIKombiSyncListener.updateKombiMessageStatePopupStatus(n, n2);
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
                    dSIKombiSyncListener.updateKombiMessageStatePopupStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseKombiDisplayStatus(KombiDisplayStatus kombiDisplayStatus, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)objectArray[i2];
                    dSIKombiSyncListener.responseKombiDisplayStatus(kombiDisplayStatus, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseKombiDisplayRequest(KombiDisplayRequest kombiDisplayRequest) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)objectArray[i2];
                    dSIKombiSyncListener.responseKombiDisplayRequest(kombiDisplayRequest);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseKombiPopupStatus(KombiPopupStatus kombiPopupStatus, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiSyncListener dSIKombiSyncListener = (DSIKombiSyncListener)objectArray[i2];
                    dSIKombiSyncListener.responseKombiPopupStatus(kombiPopupStatus, n);
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

