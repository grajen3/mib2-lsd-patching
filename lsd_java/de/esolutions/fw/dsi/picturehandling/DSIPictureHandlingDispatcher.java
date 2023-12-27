/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.picturehandling;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.picturehandling.DSIPictureHandlingReply;
import de.esolutions.fw.comm.dsi.picturehandling.impl.DSIPictureHandlingReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturehandling.DSIPictureHandlingListener;

public class DSIPictureHandlingDispatcher
extends AbstractDispatcher
implements DSIPictureHandlingReply {
    private DSIPictureHandlingReplyService service = new DSIPictureHandlingReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$picturehandling$DSIPictureHandlingListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIPictureHandlingDispatcher(int n) {
        super(n, (class$org$dsi$ifc$picturehandling$DSIPictureHandlingListener == null ? (class$org$dsi$ifc$picturehandling$DSIPictureHandlingListener = DSIPictureHandlingDispatcher.class$("org.dsi.ifc.picturehandling.DSIPictureHandlingListener")) : class$org$dsi$ifc$picturehandling$DSIPictureHandlingListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void indicatePicture(int n, int n2, ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureHandlingListener dSIPictureHandlingListener = (DSIPictureHandlingListener)objectArray[i2];
                    dSIPictureHandlingListener.indicatePicture(n, n2, resourceLocator, resourceLocator2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void finishPictureRequest(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureHandlingListener dSIPictureHandlingListener = (DSIPictureHandlingListener)objectArray[i2];
                    dSIPictureHandlingListener.finishPictureRequest(n);
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
                    DSIPictureHandlingListener dSIPictureHandlingListener = (DSIPictureHandlingListener)objectArray[i2];
                    dSIPictureHandlingListener.asyncException(n, string, n2);
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
                    DSIPictureHandlingListener dSIPictureHandlingListener = (DSIPictureHandlingListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIPictureHandlingDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIPictureHandlingDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIPictureHandlingListener, new Object[]{string, string2});
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

