/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.komonavinfo;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.komonavinfo.DSIKOMONavInfoReply;
import de.esolutions.fw.comm.dsi.komonavinfo.impl.DSIKOMONavInfoReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener;

public class DSIKOMONavInfoDispatcher
extends AbstractDispatcher
implements DSIKOMONavInfoReply {
    private DSIKOMONavInfoReplyService service = new DSIKOMONavInfoReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIKOMONavInfoDispatcher(int n) {
        super(n, (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener = DSIKOMONavInfoDispatcher.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void setCurrentStreetResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMONavInfoListener dSIKOMONavInfoListener = (DSIKOMONavInfoListener)objectArray[i2];
                    dSIKOMONavInfoListener.setCurrentStreetResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setTurnToStreetResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMONavInfoListener dSIKOMONavInfoListener = (DSIKOMONavInfoListener)objectArray[i2];
                    dSIKOMONavInfoListener.setTurnToStreetResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setCityNameResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMONavInfoListener dSIKOMONavInfoListener = (DSIKOMONavInfoListener)objectArray[i2];
                    dSIKOMONavInfoListener.setCityNameResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setSemiDynRouteResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMONavInfoListener dSIKOMONavInfoListener = (DSIKOMONavInfoListener)objectArray[i2];
                    dSIKOMONavInfoListener.setSemiDynRouteResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setTrafficOffsetResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMONavInfoListener dSIKOMONavInfoListener = (DSIKOMONavInfoListener)objectArray[i2];
                    dSIKOMONavInfoListener.setTrafficOffsetResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setRgSelectResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMONavInfoListener dSIKOMONavInfoListener = (DSIKOMONavInfoListener)objectArray[i2];
                    dSIKOMONavInfoListener.setRgSelectResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setCapabilitiesResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMONavInfoListener dSIKOMONavInfoListener = (DSIKOMONavInfoListener)objectArray[i2];
                    dSIKOMONavInfoListener.setCapabilitiesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setMapScaleResult(int n, int n2, boolean[] blArray, int n3, int n4, boolean[] blArray2, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMONavInfoListener dSIKOMONavInfoListener = (DSIKOMONavInfoListener)objectArray[i2];
                    dSIKOMONavInfoListener.setMapScaleResult(n, n2, blArray, n3, n4, blArray2, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setMapScale(int n, int n2, boolean[] blArray, int n3, int n4, int n5) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKOMONavInfoListener dSIKOMONavInfoListener = (DSIKOMONavInfoListener)objectArray[i2];
                    dSIKOMONavInfoListener.setMapScale(n, n2, blArray, n3, n4, n5);
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
                    DSIKOMONavInfoListener dSIKOMONavInfoListener = (DSIKOMONavInfoListener)objectArray[i2];
                    dSIKOMONavInfoListener.asyncException(n, string, n2);
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
                    DSIKOMONavInfoListener dSIKOMONavInfoListener = (DSIKOMONavInfoListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIKOMONavInfoDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIKOMONavInfoDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIKOMONavInfoListener, new Object[]{string, string2});
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

