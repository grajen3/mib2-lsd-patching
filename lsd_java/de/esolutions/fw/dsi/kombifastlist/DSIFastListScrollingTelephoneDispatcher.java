/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombifastlist;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingTelephoneReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingTelephoneReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener;

public class DSIFastListScrollingTelephoneDispatcher
extends AbstractDispatcher
implements DSIFastListScrollingTelephoneReply {
    private DSIFastListScrollingTelephoneReplyService service = new DSIFastListScrollingTelephoneReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIFastListScrollingTelephoneDispatcher(int n) {
        super(n, (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener = DSIFastListScrollingTelephoneDispatcher.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void indicationPhonebook(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingTelephoneListener dSIFastListScrollingTelephoneListener = (DSIFastListScrollingTelephoneListener)objectArray[i2];
                    dSIFastListScrollingTelephoneListener.indicationPhonebook(n, n2, n3, n4, l, n5, n6, n7, n8, n9, n10);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationGetInitialsTelephone(int n, int n2, int n3, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingTelephoneListener dSIFastListScrollingTelephoneListener = (DSIFastListScrollingTelephoneListener)objectArray[i2];
                    dSIFastListScrollingTelephoneListener.indicationGetInitialsTelephone(n, n2, n3, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationNotifyFavoriteListPush(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingTelephoneListener dSIFastListScrollingTelephoneListener = (DSIFastListScrollingTelephoneListener)objectArray[i2];
                    dSIFastListScrollingTelephoneListener.indicationNotifyFavoriteListPush(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationNotifyCombinedNumbersPush(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingTelephoneListener dSIFastListScrollingTelephoneListener = (DSIFastListScrollingTelephoneListener)objectArray[i2];
                    dSIFastListScrollingTelephoneListener.indicationNotifyCombinedNumbersPush(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationNotifyCurrentListSizeTelephone(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingTelephoneListener dSIFastListScrollingTelephoneListener = (DSIFastListScrollingTelephoneListener)objectArray[i2];
                    dSIFastListScrollingTelephoneListener.indicationNotifyCurrentListSizeTelephone(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationPhonebookJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingTelephoneListener dSIFastListScrollingTelephoneListener = (DSIFastListScrollingTelephoneListener)objectArray[i2];
                    dSIFastListScrollingTelephoneListener.indicationPhonebookJobs(n, n2, n3, arrayHeaderArray);
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
                    DSIFastListScrollingTelephoneListener dSIFastListScrollingTelephoneListener = (DSIFastListScrollingTelephoneListener)objectArray[i2];
                    dSIFastListScrollingTelephoneListener.asyncException(n, string, n2);
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
                    DSIFastListScrollingTelephoneListener dSIFastListScrollingTelephoneListener = (DSIFastListScrollingTelephoneListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIFastListScrollingTelephoneDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIFastListScrollingTelephoneDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIFastListScrollingTelephoneListener, new Object[]{string, string2});
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

