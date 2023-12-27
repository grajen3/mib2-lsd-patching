/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.navigation;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.navigation.DSIBlockingReply;
import de.esolutions.fw.comm.dsi.navigation.impl.DSIBlockingReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.BlockElement;
import org.dsi.ifc.navigation.DSIBlockingListener;

public class DSIBlockingDispatcher
extends AbstractDispatcher
implements DSIBlockingReply {
    private DSIBlockingReplyService service = new DSIBlockingReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSIBlockingListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIBlockingDispatcher(int n) {
        super(n, (class$org$dsi$ifc$navigation$DSIBlockingListener == null ? (class$org$dsi$ifc$navigation$DSIBlockingListener = DSIBlockingDispatcher.class$("org.dsi.ifc.navigation.DSIBlockingListener")) : class$org$dsi$ifc$navigation$DSIBlockingListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateListOfBlocks(BlockElement[] blockElementArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    this.confirmNotificationListener(2, dSIBlockingListener);
                    dSIBlockingListener.updateListOfBlocks(blockElementArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    dSIBlockingListener.updateListOfBlocks(blockElementArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNaviCoreAvailableToSetBlocks(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    this.confirmNotificationListener(1, dSIBlockingListener);
                    dSIBlockingListener.updateNaviCoreAvailableToSetBlocks(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    dSIBlockingListener.updateNaviCoreAvailableToSetBlocks(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaximumNumberOfBlockedAreas(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    this.confirmNotificationListener(3, dSIBlockingListener);
                    dSIBlockingListener.updateMaximumNumberOfBlockedAreas(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    dSIBlockingListener.updateMaximumNumberOfBlockedAreas(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaximumNumberOfBlockedRouteSegments(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    this.confirmNotificationListener(4, dSIBlockingListener);
                    dSIBlockingListener.updateMaximumNumberOfBlockedRouteSegments(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    dSIBlockingListener.updateMaximumNumberOfBlockedRouteSegments(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaximumNumberOfBlockedRoadSegments(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    this.confirmNotificationListener(5, dSIBlockingListener);
                    dSIBlockingListener.updateMaximumNumberOfBlockedRoadSegments(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    dSIBlockingListener.updateMaximumNumberOfBlockedRoadSegments(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaximumDimensionsOfBlockedArea(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    this.confirmNotificationListener(6, dSIBlockingListener);
                    dSIBlockingListener.updateMaximumDimensionsOfBlockedArea(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    dSIBlockingListener.updateMaximumDimensionsOfBlockedArea(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaximumSegmentLengthOfBlockedRouteSegment(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    this.confirmNotificationListener(7, dSIBlockingListener);
                    dSIBlockingListener.updateMaximumSegmentLengthOfBlockedRouteSegment(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    dSIBlockingListener.updateMaximumSegmentLengthOfBlockedRouteSegment(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaximumLengthOfBlockRouteBasedOnLength(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    this.confirmNotificationListener(8, dSIBlockingListener);
                    dSIBlockingListener.updateMaximumLengthOfBlockRouteBasedOnLength(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)iterator.next();
                    dSIBlockingListener.updateMaximumLengthOfBlockRouteBasedOnLength(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void blockAreaResult(long l, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)objectArray[i2];
                    dSIBlockingListener.blockAreaResult(l, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void blockRouteSegmentsResult(long l, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)objectArray[i2];
                    dSIBlockingListener.blockRouteSegmentsResult(l, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void blockRoadSegmentsResult(long l, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)objectArray[i2];
                    dSIBlockingListener.blockRoadSegmentsResult(l, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void blockRouteBasedOnLengthResult(long l, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)objectArray[i2];
                    dSIBlockingListener.blockRouteBasedOnLengthResult(l, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void persistBlockResult(long[] lArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)objectArray[i2];
                    dSIBlockingListener.persistBlockResult(lArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deleteBlockResult(long[] lArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)objectArray[i2];
                    dSIBlockingListener.deleteBlockResult(lArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setBlockDescriptionResult(long[] lArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)objectArray[i2];
                    dSIBlockingListener.setBlockDescriptionResult(lArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getBoundingRectangleOfBlocksResult(long[] lArray, NavRectangle navRectangle) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)objectArray[i2];
                    dSIBlockingListener.getBoundingRectangleOfBlocksResult(lArray, navRectangle);
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
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)objectArray[i2];
                    dSIBlockingListener.asyncException(n, string, n2);
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
                    DSIBlockingListener dSIBlockingListener = (DSIBlockingListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIBlockingDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIBlockingDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIBlockingListener, new Object[]{string, string2});
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

