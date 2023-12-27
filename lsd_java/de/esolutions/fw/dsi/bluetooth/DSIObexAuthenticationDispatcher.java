/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.bluetooth;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.bluetooth.DSIObexAuthenticationReply;
import de.esolutions.fw.comm.dsi.bluetooth.impl.DSIObexAuthenticationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.bluetooth.DSIObexAuthenticationListener;

public class DSIObexAuthenticationDispatcher
extends AbstractDispatcher
implements DSIObexAuthenticationReply {
    private DSIObexAuthenticationReplyService service = new DSIObexAuthenticationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIObexAuthenticationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener == null ? (class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener = DSIObexAuthenticationDispatcher.class$("org.dsi.ifc.bluetooth.DSIObexAuthenticationListener")) : class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void authenticationRequired(int n, boolean bl, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIObexAuthenticationListener dSIObexAuthenticationListener = (DSIObexAuthenticationListener)objectArray[i2];
                    dSIObexAuthenticationListener.authenticationRequired(n, bl, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indAuthentication(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIObexAuthenticationListener dSIObexAuthenticationListener = (DSIObexAuthenticationListener)objectArray[i2];
                    dSIObexAuthenticationListener.indAuthentication(bl);
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
                    DSIObexAuthenticationListener dSIObexAuthenticationListener = (DSIObexAuthenticationListener)objectArray[i2];
                    dSIObexAuthenticationListener.asyncException(n, string, n2);
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
                    DSIObexAuthenticationListener dSIObexAuthenticationListener = (DSIObexAuthenticationListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIObexAuthenticationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIObexAuthenticationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIObexAuthenticationListener, new Object[]{string, string2});
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

