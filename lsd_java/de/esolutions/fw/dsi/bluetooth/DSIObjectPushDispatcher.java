/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.bluetooth;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.bluetooth.DSIObjectPushReply;
import de.esolutions.fw.comm.dsi.bluetooth.impl.DSIObjectPushReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.bluetooth.DSIObjectPushListener;

public class DSIObjectPushDispatcher
extends AbstractDispatcher
implements DSIObjectPushReply {
    private DSIObjectPushReplyService service = new DSIObjectPushReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObjectPushListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIObjectPushDispatcher(int n) {
        super(n, (class$org$dsi$ifc$bluetooth$DSIObjectPushListener == null ? (class$org$dsi$ifc$bluetooth$DSIObjectPushListener = DSIObjectPushDispatcher.class$("org.dsi.ifc.bluetooth.DSIObjectPushListener")) : class$org$dsi$ifc$bluetooth$DSIObjectPushListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateOPPIncomingObject(String string, String string2, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIObjectPushListener dSIObjectPushListener = (DSIObjectPushListener)iterator.next();
                    this.confirmNotificationListener(1, dSIObjectPushListener);
                    dSIObjectPushListener.updateOPPIncomingObject(string, string2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIObjectPushListener dSIObjectPushListener = (DSIObjectPushListener)iterator.next();
                    dSIObjectPushListener.updateOPPIncomingObject(string, string2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseOPPAbortSending(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIObjectPushListener dSIObjectPushListener = (DSIObjectPushListener)objectArray[i2];
                    dSIObjectPushListener.responseOPPAbortSending(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseOPPAcceptObject(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIObjectPushListener dSIObjectPushListener = (DSIObjectPushListener)objectArray[i2];
                    dSIObjectPushListener.responseOPPAcceptObject(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseOPPSendContacts(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIObjectPushListener dSIObjectPushListener = (DSIObjectPushListener)objectArray[i2];
                    dSIObjectPushListener.responseOPPSendContacts(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseOPPSendMessages(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIObjectPushListener dSIObjectPushListener = (DSIObjectPushListener)objectArray[i2];
                    dSIObjectPushListener.responseOPPSendMessages(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseOPPSendBinary(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIObjectPushListener dSIObjectPushListener = (DSIObjectPushListener)objectArray[i2];
                    dSIObjectPushListener.responseOPPSendBinary(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVCardsReceived(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIObjectPushListener dSIObjectPushListener = (DSIObjectPushListener)iterator.next();
                    this.confirmNotificationListener(2, dSIObjectPushListener);
                    dSIObjectPushListener.updateVCardsReceived(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIObjectPushListener dSIObjectPushListener = (DSIObjectPushListener)iterator.next();
                    dSIObjectPushListener.updateVCardsReceived(string, n);
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
                    DSIObjectPushListener dSIObjectPushListener = (DSIObjectPushListener)objectArray[i2];
                    dSIObjectPushListener.asyncException(n, string, n2);
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
                    DSIObjectPushListener dSIObjectPushListener = (DSIObjectPushListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIObjectPushDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIObjectPushDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIObjectPushListener, new Object[]{string, string2});
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

