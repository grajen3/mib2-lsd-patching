/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.media.DSIRadioTaggingReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIRadioTaggingReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.media.DSIRadioTaggingListener;

public class DSIRadioTaggingDispatcher
extends AbstractDispatcher
implements DSIRadioTaggingReply {
    private DSIRadioTaggingReplyService service = new DSIRadioTaggingReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIRadioTaggingListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIRadioTaggingDispatcher(int n) {
        super(n, (class$org$dsi$ifc$media$DSIRadioTaggingListener == null ? (class$org$dsi$ifc$media$DSIRadioTaggingListener = DSIRadioTaggingDispatcher.class$("org.dsi.ifc.media.DSIRadioTaggingListener")) : class$org$dsi$ifc$media$DSIRadioTaggingListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void tagResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioTaggingListener dSIRadioTaggingListener = (DSIRadioTaggingListener)objectArray[i2];
                    dSIRadioTaggingListener.tagResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCompatibleDevAvail(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIRadioTaggingListener dSIRadioTaggingListener = (DSIRadioTaggingListener)iterator.next();
                    this.confirmNotificationListener(1, dSIRadioTaggingListener);
                    dSIRadioTaggingListener.updateCompatibleDevAvail(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIRadioTaggingListener dSIRadioTaggingListener = (DSIRadioTaggingListener)iterator.next();
                    dSIRadioTaggingListener.updateCompatibleDevAvail(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void groupTagsResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioTaggingListener dSIRadioTaggingListener = (DSIRadioTaggingListener)objectArray[i2];
                    dSIRadioTaggingListener.groupTagsResult(n, n2);
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
                    DSIRadioTaggingListener dSIRadioTaggingListener = (DSIRadioTaggingListener)objectArray[i2];
                    dSIRadioTaggingListener.asyncException(n, string, n2);
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
                    DSIRadioTaggingListener dSIRadioTaggingListener = (DSIRadioTaggingListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIRadioTaggingDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIRadioTaggingDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIRadioTaggingListener, new Object[]{string, string2});
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

