/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.navigation;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.navigation.DSICombinedRouteListReply;
import de.esolutions.fw.comm.dsi.navigation.impl.DSICombinedRouteListReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.DSICombinedRouteListListener;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.tmc.TmcMessage;

public class DSICombinedRouteListDispatcher
extends AbstractDispatcher
implements DSICombinedRouteListReply {
    private DSICombinedRouteListReplyService service = new DSICombinedRouteListReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSICombinedRouteListListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICombinedRouteListDispatcher(int n) {
        super(n, (class$org$dsi$ifc$navigation$DSICombinedRouteListListener == null ? (class$org$dsi$ifc$navigation$DSICombinedRouteListListener = DSICombinedRouteListDispatcher.class$("org.dsi.ifc.navigation.DSICombinedRouteListListener")) : class$org$dsi$ifc$navigation$DSICombinedRouteListListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void windowChanged(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICombinedRouteListListener dSICombinedRouteListListener = (DSICombinedRouteListListener)objectArray[i2];
                    dSICombinedRouteListListener.windowChanged(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void combinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICombinedRouteListListener dSICombinedRouteListListener = (DSICombinedRouteListListener)objectArray[i2];
                    dSICombinedRouteListListener.combinedRouteListResult(l, combinedRouteListElementArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void trafficInformationResult(TmcMessage tmcMessage, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICombinedRouteListListener dSICombinedRouteListListener = (DSICombinedRouteListListener)objectArray[i2];
                    dSICombinedRouteListListener.trafficInformationResult(tmcMessage, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void poiInformationResult(NavPoiInfo navPoiInfo, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICombinedRouteListListener dSICombinedRouteListListener = (DSICombinedRouteListListener)objectArray[i2];
                    dSICombinedRouteListListener.poiInformationResult(navPoiInfo, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateElementsTotal(long l, long l2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICombinedRouteListListener dSICombinedRouteListListener = (DSICombinedRouteListListener)iterator.next();
                    this.confirmNotificationListener(1, dSICombinedRouteListListener);
                    dSICombinedRouteListListener.updateElementsTotal(l, l2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICombinedRouteListListener dSICombinedRouteListListener = (DSICombinedRouteListListener)iterator.next();
                    dSICombinedRouteListListener.updateElementsTotal(l, l2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getBoundingRectangleOfCombinedRouteListElementsResult(long[] lArray, NavRectangle navRectangle) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICombinedRouteListListener dSICombinedRouteListListener = (DSICombinedRouteListListener)objectArray[i2];
                    dSICombinedRouteListListener.getBoundingRectangleOfCombinedRouteListElementsResult(lArray, navRectangle);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestPriceInfoResult(NavPriceInfo navPriceInfo, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICombinedRouteListListener dSICombinedRouteListListener = (DSICombinedRouteListListener)objectArray[i2];
                    dSICombinedRouteListListener.requestPriceInfoResult(navPriceInfo, n);
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
                    DSICombinedRouteListListener dSICombinedRouteListListener = (DSICombinedRouteListListener)objectArray[i2];
                    dSICombinedRouteListListener.asyncException(n, string, n2);
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
                    DSICombinedRouteListListener dSICombinedRouteListListener = (DSICombinedRouteListListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICombinedRouteListDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICombinedRouteListDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICombinedRouteListListener, new Object[]{string, string2});
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

