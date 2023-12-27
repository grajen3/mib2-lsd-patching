/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.system;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.system.DSIHMIWatchDogReply;
import de.esolutions.fw.comm.dsi.system.impl.DSIHMIWatchDogReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.system.DSIHMIWatchDogListener;

public class DSIHMIWatchDogDispatcher
extends AbstractDispatcher
implements DSIHMIWatchDogReply {
    private DSIHMIWatchDogReplyService service = new DSIHMIWatchDogReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$system$DSIHMIWatchDogListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIHMIWatchDogDispatcher(int n) {
        super(n, (class$org$dsi$ifc$system$DSIHMIWatchDogListener == null ? (class$org$dsi$ifc$system$DSIHMIWatchDogListener = DSIHMIWatchDogDispatcher.class$("org.dsi.ifc.system.DSIHMIWatchDogListener")) : class$org$dsi$ifc$system$DSIHMIWatchDogListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void triggerErrorLogDump() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHMIWatchDogListener dSIHMIWatchDogListener = (DSIHMIWatchDogListener)objectArray[i2];
                    dSIHMIWatchDogListener.triggerErrorLogDump();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateQueryHeartbeat(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIHMIWatchDogListener dSIHMIWatchDogListener = (DSIHMIWatchDogListener)iterator.next();
                    this.confirmNotificationListener(1, dSIHMIWatchDogListener);
                    dSIHMIWatchDogListener.updateQueryHeartbeat(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIHMIWatchDogListener dSIHMIWatchDogListener = (DSIHMIWatchDogListener)iterator.next();
                    dSIHMIWatchDogListener.updateQueryHeartbeat(n, n2);
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
                    DSIHMIWatchDogListener dSIHMIWatchDogListener = (DSIHMIWatchDogListener)objectArray[i2];
                    dSIHMIWatchDogListener.asyncException(n, string, n2);
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
                    DSIHMIWatchDogListener dSIHMIWatchDogListener = (DSIHMIWatchDogListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIHMIWatchDogDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIHMIWatchDogDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIHMIWatchDogListener, new Object[]{string, string2});
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

