/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerLandmarkPlayerReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerLandmarkPlayerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.map.DSIMapViewerLandmarkPlayerListener;

public class DSIMapViewerLandmarkPlayerDispatcher
extends AbstractDispatcher
implements DSIMapViewerLandmarkPlayerReply {
    private DSIMapViewerLandmarkPlayerReplyService service = new DSIMapViewerLandmarkPlayerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerLandmarkPlayerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMapViewerLandmarkPlayerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$map$DSIMapViewerLandmarkPlayerListener == null ? (class$org$dsi$ifc$map$DSIMapViewerLandmarkPlayerListener = DSIMapViewerLandmarkPlayerDispatcher.class$("org.dsi.ifc.map.DSIMapViewerLandmarkPlayerListener")) : class$org$dsi$ifc$map$DSIMapViewerLandmarkPlayerListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void showLandmark(float f2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerLandmarkPlayerListener dSIMapViewerLandmarkPlayerListener = (DSIMapViewerLandmarkPlayerListener)objectArray[i2];
                    dSIMapViewerLandmarkPlayerListener.showLandmark(f2);
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
                    DSIMapViewerLandmarkPlayerListener dSIMapViewerLandmarkPlayerListener = (DSIMapViewerLandmarkPlayerListener)objectArray[i2];
                    dSIMapViewerLandmarkPlayerListener.asyncException(n, string, n2);
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
                    DSIMapViewerLandmarkPlayerListener dSIMapViewerLandmarkPlayerListener = (DSIMapViewerLandmarkPlayerListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMapViewerLandmarkPlayerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMapViewerLandmarkPlayerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMapViewerLandmarkPlayerListener, new Object[]{string, string2});
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

