/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombifastlist;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingNavigationReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingNavigationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener;

public class DSIFastListScrollingNavigationDispatcher
extends AbstractDispatcher
implements DSIFastListScrollingNavigationReply {
    private DSIFastListScrollingNavigationReplyService service = new DSIFastListScrollingNavigationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIFastListScrollingNavigationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener = DSIFastListScrollingNavigationDispatcher.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void indicationNavBook(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingNavigationListener dSIFastListScrollingNavigationListener = (DSIFastListScrollingNavigationListener)objectArray[i2];
                    dSIFastListScrollingNavigationListener.indicationNavBook(n, n2, n3, n4, l, n5, n6, n7, n8, n9, n10);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationGetInitialsNavigation(int n, int n2, int n3, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingNavigationListener dSIFastListScrollingNavigationListener = (DSIFastListScrollingNavigationListener)objectArray[i2];
                    dSIFastListScrollingNavigationListener.indicationGetInitialsNavigation(n, n2, n3, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationNotifyLastDestListPUSH(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingNavigationListener dSIFastListScrollingNavigationListener = (DSIFastListScrollingNavigationListener)objectArray[i2];
                    dSIFastListScrollingNavigationListener.indicationNotifyLastDestListPUSH(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationNotifyFavoriteDestListPUSH(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingNavigationListener dSIFastListScrollingNavigationListener = (DSIFastListScrollingNavigationListener)objectArray[i2];
                    dSIFastListScrollingNavigationListener.indicationNotifyFavoriteDestListPUSH(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationNotifyCurrentListSizeNavigation(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingNavigationListener dSIFastListScrollingNavigationListener = (DSIFastListScrollingNavigationListener)objectArray[i2];
                    dSIFastListScrollingNavigationListener.indicationNotifyCurrentListSizeNavigation(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicationNavBookJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFastListScrollingNavigationListener dSIFastListScrollingNavigationListener = (DSIFastListScrollingNavigationListener)objectArray[i2];
                    dSIFastListScrollingNavigationListener.indicationNavBookJobs(n, n2, n3, arrayHeaderArray);
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
                    DSIFastListScrollingNavigationListener dSIFastListScrollingNavigationListener = (DSIFastListScrollingNavigationListener)objectArray[i2];
                    dSIFastListScrollingNavigationListener.asyncException(n, string, n2);
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
                    DSIFastListScrollingNavigationListener dSIFastListScrollingNavigationListener = (DSIFastListScrollingNavigationListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIFastListScrollingNavigationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIFastListScrollingNavigationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIFastListScrollingNavigationListener, new Object[]{string, string2});
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

