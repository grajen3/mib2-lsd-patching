/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.media.DSIMediaRecorderReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMediaRecorderReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.media.DSIMediaRecorderListener;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;

public class DSIMediaRecorderDispatcher
extends AbstractDispatcher
implements DSIMediaRecorderReply {
    private DSIMediaRecorderReplyService service = new DSIMediaRecorderReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRecorderListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMediaRecorderDispatcher(int n) {
        super(n, (class$org$dsi$ifc$media$DSIMediaRecorderListener == null ? (class$org$dsi$ifc$media$DSIMediaRecorderListener = DSIMediaRecorderDispatcher.class$("org.dsi.ifc.media.DSIMediaRecorderListener")) : class$org$dsi$ifc$media$DSIMediaRecorderListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateActiveMedia(long l, long l2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMediaRecorderListener);
                    dSIMediaRecorderListener.updateActiveMedia(l, l2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    dSIMediaRecorderListener.updateActiveMedia(l, l2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetSelection(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)objectArray[i2];
                    dSIMediaRecorderListener.responseSetSelection(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateImportSummary(long l, long l2, long l3, long l4, long l5, long l6, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMediaRecorderListener);
                    dSIMediaRecorderListener.updateImportSummary(l, l2, l3, l4, l5, l6, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    dSIMediaRecorderListener.updateImportSummary(l, l2, l3, l4, l5, l6, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateImportProgress(long l, ListEntry listEntry, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMediaRecorderListener);
                    dSIMediaRecorderListener.updateImportProgress(l, listEntry, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    dSIMediaRecorderListener.updateImportProgress(l, listEntry, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateImportStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    this.confirmNotificationListener(6, dSIMediaRecorderListener);
                    dSIMediaRecorderListener.updateImportStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    dSIMediaRecorderListener.updateImportStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDeletionProgress(long l, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMediaRecorderListener);
                    dSIMediaRecorderListener.updateDeletionProgress(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    dSIMediaRecorderListener.updateDeletionProgress(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDeletionStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    this.confirmNotificationListener(7, dSIMediaRecorderListener);
                    dSIMediaRecorderListener.updateDeletionStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    dSIMediaRecorderListener.updateDeletionStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDatabaseSpace(DatabaseSpace databaseSpace, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    this.confirmNotificationListener(5, dSIMediaRecorderListener);
                    dSIMediaRecorderListener.updateDatabaseSpace(databaseSpace, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    dSIMediaRecorderListener.updateDatabaseSpace(databaseSpace, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTargetMedia(long l, long l2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    this.confirmNotificationListener(8, dSIMediaRecorderListener);
                    dSIMediaRecorderListener.updateTargetMedia(l, l2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)iterator.next();
                    dSIMediaRecorderListener.updateTargetMedia(l, l2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetEncodingQuality(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)objectArray[i2];
                    dSIMediaRecorderListener.responseSetEncodingQuality(n);
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
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)objectArray[i2];
                    dSIMediaRecorderListener.asyncException(n, string, n2);
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
                    DSIMediaRecorderListener dSIMediaRecorderListener = (DSIMediaRecorderListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMediaRecorderDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMediaRecorderDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMediaRecorderListener, new Object[]{string, string2});
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

