/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.telephone;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.telephone.DSICallStacksReply;
import de.esolutions.fw.comm.dsi.telephone.impl.DSICallStacksReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.telephone.CallStackEntry;
import org.dsi.ifc.telephone.DSICallStacksListener;
import org.dsi.ifc.telephone.MissedCallIndicator;

public class DSICallStacksDispatcher
extends AbstractDispatcher
implements DSICallStacksReply {
    private DSICallStacksReplyService service = new DSICallStacksReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DSICallStacksListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICallStacksDispatcher(int n) {
        super(n, (class$org$dsi$ifc$telephone$DSICallStacksListener == null ? (class$org$dsi$ifc$telephone$DSICallStacksListener = DSICallStacksDispatcher.class$("org.dsi.ifc.telephone.DSICallStacksListener")) : class$org$dsi$ifc$telephone$DSICallStacksListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateIsReverted(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    this.confirmNotificationListener(1, dSICallStacksListener);
                    dSICallStacksListener.updateIsReverted(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    dSICallStacksListener.updateIsReverted(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    this.confirmNotificationListener(2, dSICallStacksListener);
                    dSICallStacksListener.updateLastAnsweredNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    dSICallStacksListener.updateLastAnsweredNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    this.confirmNotificationListener(3, dSICallStacksListener);
                    dSICallStacksListener.updateLastDialedNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    dSICallStacksListener.updateLastDialedNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMissedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    this.confirmNotificationListener(4, dSICallStacksListener);
                    dSICallStacksListener.updateMissedNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    dSICallStacksListener.updateMissedNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMEDataValidity(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    this.confirmNotificationListener(6, dSICallStacksListener);
                    dSICallStacksListener.updateMEDataValidity(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    dSICallStacksListener.updateMEDataValidity(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMissedCallIndicator(MissedCallIndicator missedCallIndicator, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    this.confirmNotificationListener(7, dSICallStacksListener);
                    dSICallStacksListener.updateMissedCallIndicator(missedCallIndicator, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)iterator.next();
                    dSICallStacksListener.updateMissedCallIndicator(missedCallIndicator, n);
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
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)objectArray[i2];
                    dSICallStacksListener.asyncException(n, string, n2);
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
                    DSICallStacksListener dSICallStacksListener = (DSICallStacksListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICallStacksDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICallStacksDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICallStacksListener, new Object[]{string, string2});
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

