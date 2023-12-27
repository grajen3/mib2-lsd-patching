/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.komogfxstreamsink;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.komogfxstreamsink.DSIKOMOGfxStreamSinkReply;
import de.esolutions.fw.comm.dsi.komogfxstreamsink.impl.DSIKOMOGfxStreamSinkReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener;

public class DSIKOMOGfxStreamSinkDispatcher
extends AbstractDispatcher
implements DSIKOMOGfxStreamSinkReply {
    private DSIKOMOGfxStreamSinkReplyService service = new DSIKOMOGfxStreamSinkReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIKOMOGfxStreamSinkDispatcher(int n) {
        super(n, (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = DSIKOMOGfxStreamSinkDispatcher.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateGfxState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener = (DSIKOMOGfxStreamSinkListener)iterator.next();
                    this.confirmNotificationListener(1, dSIKOMOGfxStreamSinkListener);
                    dSIKOMOGfxStreamSinkListener.updateGfxState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener = (DSIKOMOGfxStreamSinkListener)iterator.next();
                    dSIKOMOGfxStreamSinkListener.updateGfxState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRequestSync(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener = (DSIKOMOGfxStreamSinkListener)iterator.next();
                    this.confirmNotificationListener(2, dSIKOMOGfxStreamSinkListener);
                    dSIKOMOGfxStreamSinkListener.updateRequestSync(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener = (DSIKOMOGfxStreamSinkListener)iterator.next();
                    dSIKOMOGfxStreamSinkListener.updateRequestSync(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDataRate(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener = (DSIKOMOGfxStreamSinkListener)iterator.next();
                    this.confirmNotificationListener(3, dSIKOMOGfxStreamSinkListener);
                    dSIKOMOGfxStreamSinkListener.updateDataRate(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener = (DSIKOMOGfxStreamSinkListener)iterator.next();
                    dSIKOMOGfxStreamSinkListener.updateDataRate(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setFGLayerResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener = (DSIKOMOGfxStreamSinkListener)objectArray[i2];
                    dSIKOMOGfxStreamSinkListener.setFGLayerResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void fadeInResult() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener = (DSIKOMOGfxStreamSinkListener)objectArray[i2];
                    dSIKOMOGfxStreamSinkListener.fadeInResult();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void fadeOutResult() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener = (DSIKOMOGfxStreamSinkListener)objectArray[i2];
                    dSIKOMOGfxStreamSinkListener.fadeOutResult();
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
                    DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener = (DSIKOMOGfxStreamSinkListener)objectArray[i2];
                    dSIKOMOGfxStreamSinkListener.asyncException(n, string, n2);
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
                    DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener = (DSIKOMOGfxStreamSinkListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIKOMOGfxStreamSinkDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIKOMOGfxStreamSinkDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIKOMOGfxStreamSinkListener, new Object[]{string, string2});
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

