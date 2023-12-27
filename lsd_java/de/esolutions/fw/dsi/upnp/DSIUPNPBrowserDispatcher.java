/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.upnp;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPBrowserReply;
import de.esolutions.fw.comm.dsi.upnp.impl.DSIUPNPBrowserReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.upnp.DSIUPNPBrowserListener;
import org.dsi.ifc.upnp.ListEntry;

public class DSIUPNPBrowserDispatcher
extends AbstractDispatcher
implements DSIUPNPBrowserReply {
    private DSIUPNPBrowserReplyService service = new DSIUPNPBrowserReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$upnp$DSIUPNPBrowserListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIUPNPBrowserDispatcher(int n) {
        super(n, (class$org$dsi$ifc$upnp$DSIUPNPBrowserListener == null ? (class$org$dsi$ifc$upnp$DSIUPNPBrowserListener = DSIUPNPBrowserDispatcher.class$("org.dsi.ifc.upnp.DSIUPNPBrowserListener")) : class$org$dsi$ifc$upnp$DSIUPNPBrowserListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateBrowseFolder(ListEntry[] listEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPBrowserListener dSIUPNPBrowserListener = (DSIUPNPBrowserListener)iterator.next();
                    this.confirmNotificationListener(1, dSIUPNPBrowserListener);
                    dSIUPNPBrowserListener.updateBrowseFolder(listEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPBrowserListener dSIUPNPBrowserListener = (DSIUPNPBrowserListener)iterator.next();
                    dSIUPNPBrowserListener.updateBrowseFolder(listEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateListSize(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPBrowserListener dSIUPNPBrowserListener = (DSIUPNPBrowserListener)iterator.next();
                    this.confirmNotificationListener(2, dSIUPNPBrowserListener);
                    dSIUPNPBrowserListener.updateListSize(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIUPNPBrowserListener dSIUPNPBrowserListener = (DSIUPNPBrowserListener)iterator.next();
                    dSIUPNPBrowserListener.updateListSize(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseList(ListEntry[] listEntryArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIUPNPBrowserListener dSIUPNPBrowserListener = (DSIUPNPBrowserListener)objectArray[i2];
                    dSIUPNPBrowserListener.responseList(listEntryArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void invalidBrowsePath() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIUPNPBrowserListener dSIUPNPBrowserListener = (DSIUPNPBrowserListener)objectArray[i2];
                    dSIUPNPBrowserListener.invalidBrowsePath();
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
                    DSIUPNPBrowserListener dSIUPNPBrowserListener = (DSIUPNPBrowserListener)objectArray[i2];
                    dSIUPNPBrowserListener.asyncException(n, string, n2);
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
                    DSIUPNPBrowserListener dSIUPNPBrowserListener = (DSIUPNPBrowserListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIUPNPBrowserDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIUPNPBrowserDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIUPNPBrowserListener, new Object[]{string, string2});
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

