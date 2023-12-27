/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbEditReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbEditReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbEditListener;
import org.dsi.ifc.organizer.DataSet;

public class DSIAdbEditDispatcher
extends AbstractDispatcher
implements DSIAdbEditReply {
    private DSIAdbEditReplyService service = new DSIAdbEditReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAdbEditDispatcher(int n) {
        super(n, (class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = DSIAdbEditDispatcher.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateNewEntryAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)iterator.next();
                    this.confirmNotificationListener(1, dSIAdbEditListener);
                    dSIAdbEditListener.updateNewEntryAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)iterator.next();
                    dSIAdbEditListener.updateNewEntryAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNewPublicProfileEntryAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)iterator.next();
                    this.confirmNotificationListener(2, dSIAdbEditListener);
                    dSIAdbEditListener.updateNewPublicProfileEntryAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)iterator.next();
                    dSIAdbEditListener.updateNewPublicProfileEntryAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNewTopDestinationEntryAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)iterator.next();
                    this.confirmNotificationListener(3, dSIAdbEditListener);
                    dSIAdbEditListener.updateNewTopDestinationEntryAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)iterator.next();
                    dSIAdbEditListener.updateNewTopDestinationEntryAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNewPublicProfileTopDestEntryAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)iterator.next();
                    this.confirmNotificationListener(4, dSIAdbEditListener);
                    dSIAdbEditListener.updateNewPublicProfileTopDestEntryAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)iterator.next();
                    dSIAdbEditListener.updateNewPublicProfileTopDestEntryAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void insertEntryResult(int n, AdbEntry adbEntry) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)objectArray[i2];
                    dSIAdbEditListener.insertEntryResult(n, adbEntry);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getEntriesResult(int n, AdbEntry[] adbEntryArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)objectArray[i2];
                    dSIAdbEditListener.getEntriesResult(n, adbEntryArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getEntryDataSetsResult(int n, DataSet[] dataSetArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)objectArray[i2];
                    dSIAdbEditListener.getEntryDataSetsResult(n, dataSetArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void changeEntryResult(int n, AdbEntry adbEntry) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)objectArray[i2];
                    dSIAdbEditListener.changeEntryResult(n, adbEntry);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void copyEntryResult(int n, AdbEntry adbEntry) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)objectArray[i2];
                    dSIAdbEditListener.copyEntryResult(n, adbEntry);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deleteEntriesResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)objectArray[i2];
                    dSIAdbEditListener.deleteEntriesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setSpeedDialResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)objectArray[i2];
                    dSIAdbEditListener.setSpeedDialResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deleteSpeedDialResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)objectArray[i2];
                    dSIAdbEditListener.deleteSpeedDialResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getEntryByReferenceIdResult(int n, AdbEntry adbEntry) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)objectArray[i2];
                    dSIAdbEditListener.getEntryByReferenceIdResult(n, adbEntry);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNewOnlineDestinationEntryAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)iterator.next();
                    this.confirmNotificationListener(5, dSIAdbEditListener);
                    dSIAdbEditListener.updateNewOnlineDestinationEntryAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)iterator.next();
                    dSIAdbEditListener.updateNewOnlineDestinationEntryAvailable(bl, n);
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
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)objectArray[i2];
                    dSIAdbEditListener.asyncException(n, string, n2);
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
                    DSIAdbEditListener dSIAdbEditListener = (DSIAdbEditListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAdbEditDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAdbEditDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAdbEditListener, new Object[]{string, string2});
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

