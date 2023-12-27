/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.bap;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.bap.DSIBAPReply;
import de.esolutions.fw.comm.dsi.bap.impl.DSIBAPReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.bap.DSIBAPListener;

public class DSIBAPDispatcher
extends AbstractDispatcher
implements DSIBAPReply {
    private DSIBAPReplyService service = new DSIBAPReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$bap$DSIBAPListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIBAPDispatcher(int n) {
        super(n, (class$org$dsi$ifc$bap$DSIBAPListener == null ? (class$org$dsi$ifc$bap$DSIBAPListener = DSIBAPDispatcher.class$("org.dsi.ifc.bap.DSIBAPListener")) : class$org$dsi$ifc$bap$DSIBAPListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBAPListener dSIBAPListener = (DSIBAPListener)objectArray[i2];
                    dSIBAPListener.bapStateStatus(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indication(int n, int n2, int n3, int n4, int n5) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBAPListener dSIBAPListener = (DSIBAPListener)objectArray[i2];
                    dSIBAPListener.indication(n, n2, n3, n4, n5);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationVoid(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBAPListener dSIBAPListener = (DSIBAPListener)objectArray[i2];
                    dSIBAPListener.indicationVoid(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBAPListener dSIBAPListener = (DSIBAPListener)objectArray[i2];
                    dSIBAPListener.indicationByteSequence(n, n2, n3, byArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationError(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBAPListener dSIBAPListener = (DSIBAPListener)objectArray[i2];
                    dSIBAPListener.indicationError(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBAPListener dSIBAPListener = (DSIBAPListener)objectArray[i2];
                    dSIBAPListener.acknowledge(n, n2, n3);
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
                    DSIBAPListener dSIBAPListener = (DSIBAPListener)objectArray[i2];
                    dSIBAPListener.asyncException(n, string, n2);
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
                    DSIBAPListener dSIBAPListener = (DSIBAPListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIBAPDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIBAPDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIBAPListener, new Object[]{string, string2});
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

