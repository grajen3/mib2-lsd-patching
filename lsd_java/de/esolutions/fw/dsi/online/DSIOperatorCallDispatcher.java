/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.online.DSIOperatorCallReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOperatorCallReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.online.DSIOperatorCallListener;
import org.dsi.ifc.online.OperatorCallResult;

public class DSIOperatorCallDispatcher
extends AbstractDispatcher
implements DSIOperatorCallReply {
    private DSIOperatorCallReplyService service = new DSIOperatorCallReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOperatorCallListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIOperatorCallDispatcher(int n) {
        super(n, (class$org$dsi$ifc$online$DSIOperatorCallListener == null ? (class$org$dsi$ifc$online$DSIOperatorCallListener = DSIOperatorCallDispatcher.class$("org.dsi.ifc.online.DSIOperatorCallListener")) : class$org$dsi$ifc$online$DSIOperatorCallListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void responseOperatorCallResult(int n, OperatorCallResult[] operatorCallResultArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOperatorCallListener dSIOperatorCallListener = (DSIOperatorCallListener)objectArray[i2];
                    dSIOperatorCallListener.responseOperatorCallResult(n, operatorCallResultArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseOperatorPhoneNumber(int n, String string, String[] stringArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOperatorCallListener dSIOperatorCallListener = (DSIOperatorCallListener)objectArray[i2];
                    dSIOperatorCallListener.responseOperatorPhoneNumber(n, string, stringArray, n2);
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
                    DSIOperatorCallListener dSIOperatorCallListener = (DSIOperatorCallListener)objectArray[i2];
                    dSIOperatorCallListener.asyncException(n, string, n2);
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
                    DSIOperatorCallListener dSIOperatorCallListener = (DSIOperatorCallListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIOperatorCallDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIOperatorCallDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIOperatorCallListener, new Object[]{string, string2});
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

