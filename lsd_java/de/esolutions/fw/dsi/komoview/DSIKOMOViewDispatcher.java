/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.komoview;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.komoview.DSIKOMOViewReply;
import de.esolutions.fw.comm.dsi.komoview.impl.DSIKOMOViewReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.komoview.DSIKOMOViewListener;

public class DSIKOMOViewDispatcher
extends AbstractDispatcher
implements DSIKOMOViewReply {
    private DSIKOMOViewReplyService service = new DSIKOMOViewReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$komoview$DSIKOMOViewListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIKOMOViewDispatcher(int n) {
        super(n, (class$org$dsi$ifc$komoview$DSIKOMOViewListener == null ? (class$org$dsi$ifc$komoview$DSIKOMOViewListener = DSIKOMOViewDispatcher.class$("org.dsi.ifc.komoview.DSIKOMOViewListener")) : class$org$dsi$ifc$komoview$DSIKOMOViewListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateKomoViewEnabled(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOViewListener dSIKOMOViewListener = (DSIKOMOViewListener)iterator.next();
                    this.confirmNotificationListener(1, dSIKOMOViewListener);
                    dSIKOMOViewListener.updateKomoViewEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOViewListener dSIKOMOViewListener = (DSIKOMOViewListener)iterator.next();
                    dSIKOMOViewListener.updateKomoViewEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVisibility(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOViewListener dSIKOMOViewListener = (DSIKOMOViewListener)iterator.next();
                    this.confirmNotificationListener(2, dSIKOMOViewListener);
                    dSIKOMOViewListener.updateVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOViewListener dSIKOMOViewListener = (DSIKOMOViewListener)iterator.next();
                    dSIKOMOViewListener.updateVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void komoViewResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMOViewListener dSIKOMOViewListener = (DSIKOMOViewListener)objectArray[i2];
                    dSIKOMOViewListener.komoViewResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCurrentKomoViewType(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOViewListener dSIKOMOViewListener = (DSIKOMOViewListener)iterator.next();
                    this.confirmNotificationListener(3, dSIKOMOViewListener);
                    dSIKOMOViewListener.updateCurrentKomoViewType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOViewListener dSIKOMOViewListener = (DSIKOMOViewListener)iterator.next();
                    dSIKOMOViewListener.updateCurrentKomoViewType(n, n2);
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
                    DSIKOMOViewListener dSIKOMOViewListener = (DSIKOMOViewListener)objectArray[i2];
                    dSIKOMOViewListener.asyncException(n, string, n2);
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
                    DSIKOMOViewListener dSIKOMOViewListener = (DSIKOMOViewListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIKOMOViewDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIKOMOViewDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIKOMOViewListener, new Object[]{string, string2});
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

