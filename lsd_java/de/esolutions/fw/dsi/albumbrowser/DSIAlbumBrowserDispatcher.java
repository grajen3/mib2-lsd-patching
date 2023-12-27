/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.albumbrowser;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.albumbrowser.DSIAlbumBrowserReply;
import de.esolutions.fw.comm.dsi.albumbrowser.impl.DSIAlbumBrowserReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.albumbrowser.AlbumEntryInfo;
import org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener;

public class DSIAlbumBrowserDispatcher
extends AbstractDispatcher
implements DSIAlbumBrowserReply {
    private DSIAlbumBrowserReplyService service = new DSIAlbumBrowserReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAlbumBrowserDispatcher(int n) {
        super(n, (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener == null ? (class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener = DSIAlbumBrowserDispatcher.class$("org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener")) : class$org$dsi$ifc$albumbrowser$DSIAlbumBrowserListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateBrowserState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)iterator.next();
                    this.confirmNotificationListener(1, dSIAlbumBrowserListener);
                    dSIAlbumBrowserListener.updateBrowserState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)iterator.next();
                    dSIAlbumBrowserListener.updateBrowserState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFocusedEntry(AlbumEntryInfo albumEntryInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)iterator.next();
                    this.confirmNotificationListener(2, dSIAlbumBrowserListener);
                    dSIAlbumBrowserListener.updateFocusedEntry(albumEntryInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)iterator.next();
                    dSIAlbumBrowserListener.updateFocusedEntry(albumEntryInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateListPosition(long l, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)iterator.next();
                    this.confirmNotificationListener(5, dSIAlbumBrowserListener);
                    dSIAlbumBrowserListener.updateListPosition(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)iterator.next();
                    dSIAlbumBrowserListener.updateListPosition(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNumEntries(long l, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)iterator.next();
                    this.confirmNotificationListener(3, dSIAlbumBrowserListener);
                    dSIAlbumBrowserListener.updateNumEntries(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)iterator.next();
                    dSIAlbumBrowserListener.updateNumEntries(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateScrollMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)iterator.next();
                    this.confirmNotificationListener(4, dSIAlbumBrowserListener);
                    dSIAlbumBrowserListener.updateScrollMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)iterator.next();
                    dSIAlbumBrowserListener.updateScrollMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void selectAlbum(long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)objectArray[i2];
                    dSIAlbumBrowserListener.selectAlbum(l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void albumIdxForFID(long l, long l2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)objectArray[i2];
                    dSIAlbumBrowserListener.albumIdxForFID(l, l2);
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
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)objectArray[i2];
                    dSIAlbumBrowserListener.asyncException(n, string, n2);
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
                    DSIAlbumBrowserListener dSIAlbumBrowserListener = (DSIAlbumBrowserListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAlbumBrowserDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAlbumBrowserDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAlbumBrowserListener, new Object[]{string, string2});
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

