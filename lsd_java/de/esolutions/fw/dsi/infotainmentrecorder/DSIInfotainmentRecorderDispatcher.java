/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.infotainmentrecorder;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.infotainmentrecorder.DSIInfotainmentRecorderReply;
import de.esolutions.fw.comm.dsi.infotainmentrecorder.impl.DSIInfotainmentRecorderReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorderListener;

public class DSIInfotainmentRecorderDispatcher
extends AbstractDispatcher
implements DSIInfotainmentRecorderReply {
    private DSIInfotainmentRecorderReplyService service = new DSIInfotainmentRecorderReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorderListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIInfotainmentRecorderDispatcher(int n) {
        super(n, (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorderListener == null ? (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorderListener = DSIInfotainmentRecorderDispatcher.class$("org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorderListener")) : class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorderListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateEnabledTriggers(boolean[] blArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIInfotainmentRecorderListener dSIInfotainmentRecorderListener = (DSIInfotainmentRecorderListener)iterator.next();
                    this.confirmNotificationListener(1, dSIInfotainmentRecorderListener);
                    dSIInfotainmentRecorderListener.updateEnabledTriggers(blArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIInfotainmentRecorderListener dSIInfotainmentRecorderListener = (DSIInfotainmentRecorderListener)iterator.next();
                    dSIInfotainmentRecorderListener.updateEnabledTriggers(blArray, n);
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
                    DSIInfotainmentRecorderListener dSIInfotainmentRecorderListener = (DSIInfotainmentRecorderListener)objectArray[i2];
                    dSIInfotainmentRecorderListener.asyncException(n, string, n2);
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
                    DSIInfotainmentRecorderListener dSIInfotainmentRecorderListener = (DSIInfotainmentRecorderListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIInfotainmentRecorderDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIInfotainmentRecorderDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIInfotainmentRecorderListener, new Object[]{string, string2});
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

