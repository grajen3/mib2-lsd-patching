/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombipictureserver;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.kombipictureserver.DSIKombiPictureServerReply;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener;

public class DSIKombiPictureServerDispatcher
extends AbstractDispatcher
implements DSIKombiPictureServerReply {
    private DSIKombiPictureServerReplyService service = new DSIKombiPictureServerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIKombiPictureServerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener = DSIKombiPictureServerDispatcher.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void indicationCoverArt(long l, int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiPictureServerListener dSIKombiPictureServerListener = (DSIKombiPictureServerListener)objectArray[i2];
                    dSIKombiPictureServerListener.indicationCoverArt(l, n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationStationArt(long l, int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiPictureServerListener dSIKombiPictureServerListener = (DSIKombiPictureServerListener)objectArray[i2];
                    dSIKombiPictureServerListener.indicationStationArt(l, n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationActiveCallPicture(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiPictureServerListener dSIKombiPictureServerListener = (DSIKombiPictureServerListener)objectArray[i2];
                    dSIKombiPictureServerListener.indicationActiveCallPicture(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationActiveCallPictureInstance(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiPictureServerListener dSIKombiPictureServerListener = (DSIKombiPictureServerListener)objectArray[i2];
                    dSIKombiPictureServerListener.indicationActiveCallPictureInstance(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationDynamicIcon(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiPictureServerListener dSIKombiPictureServerListener = (DSIKombiPictureServerListener)objectArray[i2];
                    dSIKombiPictureServerListener.indicationDynamicIcon(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationInternalAddressID(long l, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiPictureServerListener dSIKombiPictureServerListener = (DSIKombiPictureServerListener)objectArray[i2];
                    dSIKombiPictureServerListener.indicationInternalAddressID(l, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationAdbContactPicture(long l, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiPictureServerListener dSIKombiPictureServerListener = (DSIKombiPictureServerListener)objectArray[i2];
                    dSIKombiPictureServerListener.indicationAdbContactPicture(l, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationPictureStreamAbilities() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiPictureServerListener dSIKombiPictureServerListener = (DSIKombiPictureServerListener)objectArray[i2];
                    dSIKombiPictureServerListener.indicationPictureStreamAbilities();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationPictureStream(int n, short s, short s2, int n2, int n3, int n4, int n5, byte[] byArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIKombiPictureServerListener dSIKombiPictureServerListener = (DSIKombiPictureServerListener)objectArray[i2];
                    dSIKombiPictureServerListener.indicationPictureStream(n, s, s2, n2, n3, n4, n5, byArray);
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
                    DSIKombiPictureServerListener dSIKombiPictureServerListener = (DSIKombiPictureServerListener)objectArray[i2];
                    dSIKombiPictureServerListener.asyncException(n, string, n2);
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
                    DSIKombiPictureServerListener dSIKombiPictureServerListener = (DSIKombiPictureServerListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIKombiPictureServerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIKombiPictureServerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIKombiPictureServerListener, new Object[]{string, string2});
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

