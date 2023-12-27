/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diagnose;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.diagnose.DSIDiagnoseSystemReply;
import de.esolutions.fw.comm.dsi.diagnose.impl.DSIDiagnoseSystemReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.diagnose.DSIDiagnoseSystemListener;

public class DSIDiagnoseSystemDispatcher
extends AbstractDispatcher
implements DSIDiagnoseSystemReply {
    private DSIDiagnoseSystemReplyService service = new DSIDiagnoseSystemReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIDiagnoseSystemDispatcher(int n) {
        super(n, (class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener == null ? (class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener = DSIDiagnoseSystemDispatcher.class$("org.dsi.ifc.diagnose.DSIDiagnoseSystemListener")) : class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateDiagnosticValueChanged(int n, long l, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIDiagnoseSystemListener dSIDiagnoseSystemListener = (DSIDiagnoseSystemListener)iterator.next();
                    this.confirmNotificationListener(20, dSIDiagnoseSystemListener);
                    dSIDiagnoseSystemListener.updateDiagnosticValueChanged(n, l, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIDiagnoseSystemListener dSIDiagnoseSystemListener = (DSIDiagnoseSystemListener)iterator.next();
                    dSIDiagnoseSystemListener.updateDiagnosticValueChanged(n, l, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestRoutine(int n, int n2, int n3, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDiagnoseSystemListener dSIDiagnoseSystemListener = (DSIDiagnoseSystemListener)objectArray[i2];
                    dSIDiagnoseSystemListener.requestRoutine(n, n2, n3, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestActuatorTest(int n, int n2, int n3, int n4, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDiagnoseSystemListener dSIDiagnoseSystemListener = (DSIDiagnoseSystemListener)objectArray[i2];
                    dSIDiagnoseSystemListener.requestActuatorTest(n, n2, n3, n4, nArray);
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
                    DSIDiagnoseSystemListener dSIDiagnoseSystemListener = (DSIDiagnoseSystemListener)objectArray[i2];
                    dSIDiagnoseSystemListener.asyncException(n, string, n2);
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
                    DSIDiagnoseSystemListener dSIDiagnoseSystemListener = (DSIDiagnoseSystemListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIDiagnoseSystemDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIDiagnoseSystemDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIDiagnoseSystemListener, new Object[]{string, string2});
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

