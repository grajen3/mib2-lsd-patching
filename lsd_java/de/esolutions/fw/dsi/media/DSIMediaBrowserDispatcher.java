/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.media.DSIMediaBrowserReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMediaBrowserReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.DSIMediaBrowserListener;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.SearchListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public class DSIMediaBrowserDispatcher
extends AbstractDispatcher
implements DSIMediaBrowserReply {
    private DSIMediaBrowserReplyService service = new DSIMediaBrowserReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBrowserListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMediaBrowserDispatcher(int n) {
        super(n, (class$org$dsi$ifc$media$DSIMediaBrowserListener == null ? (class$org$dsi$ifc$media$DSIMediaBrowserListener = DSIMediaBrowserDispatcher.class$("org.dsi.ifc.media.DSIMediaBrowserListener")) : class$org$dsi$ifc$media$DSIMediaBrowserListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateBrowseMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMediaBrowserListener);
                    dSIMediaBrowserListener.updateBrowseMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    dSIMediaBrowserListener.updateBrowseMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateContentFilter(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMediaBrowserListener);
                    dSIMediaBrowserListener.updateContentFilter(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    dSIMediaBrowserListener.updateContentFilter(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrowseMedia(long l, long l2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMediaBrowserListener);
                    dSIMediaBrowserListener.updateBrowseMedia(l, l2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    dSIMediaBrowserListener.updateBrowseMedia(l, l2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrowseFolder(ListEntry[] listEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMediaBrowserListener);
                    dSIMediaBrowserListener.updateBrowseFolder(listEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    dSIMediaBrowserListener.updateBrowseFolder(listEntryArray, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    this.confirmNotificationListener(5, dSIMediaBrowserListener);
                    dSIMediaBrowserListener.updateListSize(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    dSIMediaBrowserListener.updateListSize(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAlphabeticalIndex(CharacterInfo[] characterInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    this.confirmNotificationListener(8, dSIMediaBrowserListener);
                    dSIMediaBrowserListener.updateAlphabeticalIndex(characterInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    dSIMediaBrowserListener.updateAlphabeticalIndex(characterInfoArray, n);
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
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)objectArray[i2];
                    dSIMediaBrowserListener.responseList(listEntryArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePickList(ListEntry[] listEntryArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)objectArray[i2];
                    dSIMediaBrowserListener.responsePickList(listEntryArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void selectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)objectArray[i2];
                    dSIMediaBrowserListener.selectionResult(n, n2, bl, l, l2, l3, l4, l5);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetSearchCriteria(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)objectArray[i2];
                    dSIMediaBrowserListener.responseSetSearchCriteria(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSearchSize(int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 0x80) == 128) {
            n5 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    this.confirmNotificationListener(7, dSIMediaBrowserListener);
                    dSIMediaBrowserListener.updateSearchSize(n, n2, n3, n4, n5);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    dSIMediaBrowserListener.updateSearchSize(n, n2, n3, n4, n5);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSelectSearchResult(long l, long l2, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)objectArray[i2];
                    dSIMediaBrowserListener.responseSelectSearchResult(l, l2, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetSearchString(String string, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)objectArray[i2];
                    dSIMediaBrowserListener.responseSetSearchString(string, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSearchSpellerState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    this.confirmNotificationListener(6, dSIMediaBrowserListener);
                    dSIMediaBrowserListener.updateSearchSpellerState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)iterator.next();
                    dSIMediaBrowserListener.updateSearchSpellerState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSearchList(SearchListEntry[] searchListEntryArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)objectArray[i2];
                    dSIMediaBrowserListener.responseSearchList(searchListEntryArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSearchListExt(SearchListEntryExt[] searchListEntryExtArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)objectArray[i2];
                    dSIMediaBrowserListener.responseSearchListExt(searchListEntryExtArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseFullyQualifiedName(long l, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)objectArray[i2];
                    dSIMediaBrowserListener.responseFullyQualifiedName(l, string);
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
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)objectArray[i2];
                    dSIMediaBrowserListener.asyncException(n, string, n2);
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
                    DSIMediaBrowserListener dSIMediaBrowserListener = (DSIMediaBrowserListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMediaBrowserDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMediaBrowserDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMediaBrowserListener, new Object[]{string, string2});
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

