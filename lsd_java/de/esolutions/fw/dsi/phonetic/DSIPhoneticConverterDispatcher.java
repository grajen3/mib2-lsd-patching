/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.phonetic;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.phonetic.DSIPhoneticConverterReply;
import de.esolutions.fw.comm.dsi.phonetic.impl.DSIPhoneticConverterReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.phonetic.DSIPhoneticConverterListener;

public class DSIPhoneticConverterDispatcher
extends AbstractDispatcher
implements DSIPhoneticConverterReply {
    private DSIPhoneticConverterReplyService service = new DSIPhoneticConverterReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$phonetic$DSIPhoneticConverterListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIPhoneticConverterDispatcher(int n) {
        super(n, (class$org$dsi$ifc$phonetic$DSIPhoneticConverterListener == null ? (class$org$dsi$ifc$phonetic$DSIPhoneticConverterListener = DSIPhoneticConverterDispatcher.class$("org.dsi.ifc.phonetic.DSIPhoneticConverterListener")) : class$org$dsi$ifc$phonetic$DSIPhoneticConverterListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void hanziToPinYinResult(String string, String string2, String string3, String string4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPhoneticConverterListener dSIPhoneticConverterListener = (DSIPhoneticConverterListener)objectArray[i2];
                    dSIPhoneticConverterListener.hanziToPinYinResult(string, string2, string3, string4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void hanziToZhuYinResult(String string, String string2, String string3, String string4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPhoneticConverterListener dSIPhoneticConverterListener = (DSIPhoneticConverterListener)objectArray[i2];
                    dSIPhoneticConverterListener.hanziToZhuYinResult(string, string2, string3, string4);
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
                    DSIPhoneticConverterListener dSIPhoneticConverterListener = (DSIPhoneticConverterListener)objectArray[i2];
                    dSIPhoneticConverterListener.asyncException(n, string, n2);
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
                    DSIPhoneticConverterListener dSIPhoneticConverterListener = (DSIPhoneticConverterListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIPhoneticConverterDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIPhoneticConverterDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIPhoneticConverterListener, new Object[]{string, string2});
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

