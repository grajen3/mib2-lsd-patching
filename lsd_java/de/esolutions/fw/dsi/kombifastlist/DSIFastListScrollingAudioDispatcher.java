/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombifastlist;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingAudioReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingAudioReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingAudioListener;

public class DSIFastListScrollingAudioDispatcher
extends AbstractDispatcher
implements DSIFastListScrollingAudioReply {
    private DSIFastListScrollingAudioReplyService service = new DSIFastListScrollingAudioReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIFastListScrollingAudioDispatcher(int n) {
        super(n, (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener = DSIFastListScrollingAudioDispatcher.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingAudioListener")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void indicationMediaBrowser(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingAudioListener dSIFastListScrollingAudioListener = (DSIFastListScrollingAudioListener)objectArray[i2];
                    dSIFastListScrollingAudioListener.indicationMediaBrowser(n, n2, n3, n4, l, n5, n6, n7, n8, n9, n10);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationNotifyCommonListPUSH(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingAudioListener dSIFastListScrollingAudioListener = (DSIFastListScrollingAudioListener)objectArray[i2];
                    dSIFastListScrollingAudioListener.indicationNotifyCommonListPUSH(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationNotifyReceptionListPUSH(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingAudioListener dSIFastListScrollingAudioListener = (DSIFastListScrollingAudioListener)objectArray[i2];
                    dSIFastListScrollingAudioListener.indicationNotifyReceptionListPUSH(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationNotifyCurrentListSizeAudio(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingAudioListener dSIFastListScrollingAudioListener = (DSIFastListScrollingAudioListener)objectArray[i2];
                    dSIFastListScrollingAudioListener.indicationNotifyCurrentListSizeAudio(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationMediaBrowserJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingAudioListener dSIFastListScrollingAudioListener = (DSIFastListScrollingAudioListener)objectArray[i2];
                    dSIFastListScrollingAudioListener.indicationMediaBrowserJobs(n, n2, n3, arrayHeaderArray);
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
                    DSIFastListScrollingAudioListener dSIFastListScrollingAudioListener = (DSIFastListScrollingAudioListener)objectArray[i2];
                    dSIFastListScrollingAudioListener.asyncException(n, string, n2);
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
                    DSIFastListScrollingAudioListener dSIFastListScrollingAudioListener = (DSIFastListScrollingAudioListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIFastListScrollingAudioDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIFastListScrollingAudioDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIFastListScrollingAudioListener, new Object[]{string, string2});
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

