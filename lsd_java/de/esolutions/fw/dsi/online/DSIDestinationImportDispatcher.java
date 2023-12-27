/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.online.DSIDestinationImportReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIDestinationImportReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.online.DSIDestinationImportListener;
import org.dsi.ifc.online.PortalADBEntry;

public class DSIDestinationImportDispatcher
extends AbstractDispatcher
implements DSIDestinationImportReply {
    private DSIDestinationImportReplyService service = new DSIDestinationImportReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIDestinationImportListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIDestinationImportDispatcher(int n) {
        super(n, (class$org$dsi$ifc$online$DSIDestinationImportListener == null ? (class$org$dsi$ifc$online$DSIDestinationImportListener = DSIDestinationImportDispatcher.class$("org.dsi.ifc.online.DSIDestinationImportListener")) : class$org$dsi$ifc$online$DSIDestinationImportListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void downloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDestinationImportListener dSIDestinationImportListener = (DSIDestinationImportListener)objectArray[i2];
                    dSIDestinationImportListener.downloadAddressListResult(portalADBEntryArray, n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void stopActionResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDestinationImportListener dSIDestinationImportListener = (DSIDestinationImportListener)objectArray[i2];
                    dSIDestinationImportListener.stopActionResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEntries(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIDestinationImportListener dSIDestinationImportListener = (DSIDestinationImportListener)iterator.next();
                    this.confirmNotificationListener(1, dSIDestinationImportListener);
                    dSIDestinationImportListener.updateEntries(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIDestinationImportListener dSIDestinationImportListener = (DSIDestinationImportListener)iterator.next();
                    dSIDestinationImportListener.updateEntries(n, n2);
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
                    DSIDestinationImportListener dSIDestinationImportListener = (DSIDestinationImportListener)objectArray[i2];
                    dSIDestinationImportListener.asyncException(n, string, n2);
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
                    DSIDestinationImportListener dSIDestinationImportListener = (DSIDestinationImportListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIDestinationImportDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIDestinationImportDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIDestinationImportListener, new Object[]{string, string2});
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

