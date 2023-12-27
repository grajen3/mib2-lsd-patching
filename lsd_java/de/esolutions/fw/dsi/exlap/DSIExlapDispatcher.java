/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.exlap;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.exlap.DSIExlapReply;
import de.esolutions.fw.comm.dsi.exlap.impl.DSIExlapReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.exlap.DSIExlapListener;
import org.dsi.ifc.exlap.Service;

public class DSIExlapDispatcher
extends AbstractDispatcher
implements DSIExlapReply {
    private DSIExlapReplyService service = new DSIExlapReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$exlap$DSIExlapListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIExlapDispatcher(int n) {
        super(n, (class$org$dsi$ifc$exlap$DSIExlapListener == null ? (class$org$dsi$ifc$exlap$DSIExlapListener = DSIExlapDispatcher.class$("org.dsi.ifc.exlap.DSIExlapListener")) : class$org$dsi$ifc$exlap$DSIExlapListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void startResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIExlapListener dSIExlapListener = (DSIExlapListener)objectArray[i2];
                    dSIExlapListener.startResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void stopResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIExlapListener dSIExlapListener = (DSIExlapListener)objectArray[i2];
                    dSIExlapListener.stopResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailableServices(Service[] serviceArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIExlapListener dSIExlapListener = (DSIExlapListener)iterator.next();
                    this.confirmNotificationListener(1, dSIExlapListener);
                    dSIExlapListener.updateAvailableServices(serviceArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIExlapListener dSIExlapListener = (DSIExlapListener)iterator.next();
                    dSIExlapListener.updateAvailableServices(serviceArray, n);
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
                    DSIExlapListener dSIExlapListener = (DSIExlapListener)objectArray[i2];
                    dSIExlapListener.asyncException(n, string, n2);
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
                    DSIExlapListener dSIExlapListener = (DSIExlapListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIExlapDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIExlapDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIExlapListener, new Object[]{string, string2});
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

