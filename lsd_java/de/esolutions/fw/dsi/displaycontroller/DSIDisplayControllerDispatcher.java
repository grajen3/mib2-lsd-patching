/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.displaycontroller;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.displaycontroller.DSIDisplayControllerReply;
import de.esolutions.fw.comm.dsi.displaycontroller.impl.DSIDisplayControllerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.displaycontroller.DSIDisplayControllerListener;

public class DSIDisplayControllerDispatcher
extends AbstractDispatcher
implements DSIDisplayControllerReply {
    private DSIDisplayControllerReplyService service = new DSIDisplayControllerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$displaycontroller$DSIDisplayControllerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIDisplayControllerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$displaycontroller$DSIDisplayControllerListener == null ? (class$org$dsi$ifc$displaycontroller$DSIDisplayControllerListener = DSIDisplayControllerDispatcher.class$("org.dsi.ifc.displaycontroller.DSIDisplayControllerListener")) : class$org$dsi$ifc$displaycontroller$DSIDisplayControllerListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void getDisplayBrightness(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayControllerListener dSIDisplayControllerListener = (DSIDisplayControllerListener)objectArray[i2];
                    dSIDisplayControllerListener.getDisplayBrightness(n, n2);
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
                    DSIDisplayControllerListener dSIDisplayControllerListener = (DSIDisplayControllerListener)objectArray[i2];
                    dSIDisplayControllerListener.asyncException(n, string, n2);
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
                    DSIDisplayControllerListener dSIDisplayControllerListener = (DSIDisplayControllerListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIDisplayControllerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIDisplayControllerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIDisplayControllerListener, new Object[]{string, string2});
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

