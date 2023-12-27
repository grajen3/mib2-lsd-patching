/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.media.DSIMetadataServiceReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMetadataServiceReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.DSIMetadataServiceListener;

public class DSIMetadataServiceDispatcher
extends AbstractDispatcher
implements DSIMetadataServiceReply {
    private DSIMetadataServiceReplyService service = new DSIMetadataServiceReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMetadataServiceListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMetadataServiceDispatcher(int n) {
        super(n, (class$org$dsi$ifc$media$DSIMetadataServiceListener == null ? (class$org$dsi$ifc$media$DSIMetadataServiceListener = DSIMetadataServiceDispatcher.class$("org.dsi.ifc.media.DSIMetadataServiceListener")) : class$org$dsi$ifc$media$DSIMetadataServiceListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateOnlineLookupStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMetadataServiceListener dSIMetadataServiceListener = (DSIMetadataServiceListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMetadataServiceListener);
                    dSIMetadataServiceListener.updateOnlineLookupStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMetadataServiceListener dSIMetadataServiceListener = (DSIMetadataServiceListener)iterator.next();
                    dSIMetadataServiceListener.updateOnlineLookupStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseCoverArt(int n, ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMetadataServiceListener dSIMetadataServiceListener = (DSIMetadataServiceListener)objectArray[i2];
                    dSIMetadataServiceListener.responseCoverArt(n, resourceLocator);
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
                    DSIMetadataServiceListener dSIMetadataServiceListener = (DSIMetadataServiceListener)objectArray[i2];
                    dSIMetadataServiceListener.asyncException(n, string, n2);
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
                    DSIMetadataServiceListener dSIMetadataServiceListener = (DSIMetadataServiceListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMetadataServiceDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMetadataServiceDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMetadataServiceListener, new Object[]{string, string2});
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

