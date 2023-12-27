/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.online.DSIOnlinePicNavReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlinePicNavReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.online.DSIOnlinePicNavListener;
import org.dsi.ifc.online.PicNavSyncInfo;

public class DSIOnlinePicNavDispatcher
extends AbstractDispatcher
implements DSIOnlinePicNavReply {
    private DSIOnlinePicNavReplyService service = new DSIOnlinePicNavReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlinePicNavListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIOnlinePicNavDispatcher(int n) {
        super(n, (class$org$dsi$ifc$online$DSIOnlinePicNavListener == null ? (class$org$dsi$ifc$online$DSIOnlinePicNavListener = DSIOnlinePicNavDispatcher.class$("org.dsi.ifc.online.DSIOnlinePicNavListener")) : class$org$dsi$ifc$online$DSIOnlinePicNavListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateSyncStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlinePicNavListener dSIOnlinePicNavListener = (DSIOnlinePicNavListener)iterator.next();
                    this.confirmNotificationListener(1, dSIOnlinePicNavListener);
                    dSIOnlinePicNavListener.updateSyncStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlinePicNavListener dSIOnlinePicNavListener = (DSIOnlinePicNavListener)iterator.next();
                    dSIOnlinePicNavListener.updateSyncStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void synchronizeResult(int n, PicNavSyncInfo picNavSyncInfo) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlinePicNavListener dSIOnlinePicNavListener = (DSIOnlinePicNavListener)objectArray[i2];
                    dSIOnlinePicNavListener.synchronizeResult(n, picNavSyncInfo);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getPendingTransactionsResult(int n, PicNavSyncInfo picNavSyncInfo) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlinePicNavListener dSIOnlinePicNavListener = (DSIOnlinePicNavListener)objectArray[i2];
                    dSIOnlinePicNavListener.getPendingTransactionsResult(n, picNavSyncInfo);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setActiveProfileResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlinePicNavListener dSIOnlinePicNavListener = (DSIOnlinePicNavListener)objectArray[i2];
                    dSIOnlinePicNavListener.setActiveProfileResult(n);
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
                    DSIOnlinePicNavListener dSIOnlinePicNavListener = (DSIOnlinePicNavListener)objectArray[i2];
                    dSIOnlinePicNavListener.asyncException(n, string, n2);
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
                    DSIOnlinePicNavListener dSIOnlinePicNavListener = (DSIOnlinePicNavListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIOnlinePicNavDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIOnlinePicNavDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIOnlinePicNavListener, new Object[]{string, string2});
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

