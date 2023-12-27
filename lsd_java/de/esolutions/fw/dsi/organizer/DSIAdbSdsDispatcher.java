/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbSdsReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbSdsReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.organizer.DSIAdbSdsListener;

public class DSIAdbSdsDispatcher
extends AbstractDispatcher
implements DSIAdbSdsReply {
    private DSIAdbSdsReplyService service = new DSIAdbSdsReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSdsListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAdbSdsDispatcher(int n) {
        super(n, (class$org$dsi$ifc$organizer$DSIAdbSdsListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSdsListener = DSIAdbSdsDispatcher.class$("org.dsi.ifc.organizer.DSIAdbSdsListener")) : class$org$dsi$ifc$organizer$DSIAdbSdsListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void getAllVoiceTagsResult(int n, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbSdsListener dSIAdbSdsListener = (DSIAdbSdsListener)objectArray[i2];
                    dSIAdbSdsListener.getAllVoiceTagsResult(n, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deleteVoiceTagsResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbSdsListener dSIAdbSdsListener = (DSIAdbSdsListener)objectArray[i2];
                    dSIAdbSdsListener.deleteVoiceTagsResult(n);
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
                    DSIAdbSdsListener dSIAdbSdsListener = (DSIAdbSdsListener)objectArray[i2];
                    dSIAdbSdsListener.asyncException(n, string, n2);
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
                    DSIAdbSdsListener dSIAdbSdsListener = (DSIAdbSdsListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAdbSdsDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAdbSdsDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAdbSdsListener, new Object[]{string, string2});
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

