/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.online.DSIPoiOnlineSearchReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIPoiOnlineSearchReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public class DSIPoiOnlineSearchDispatcher
extends AbstractDispatcher
implements DSIPoiOnlineSearchReply {
    private DSIPoiOnlineSearchReplyService service = new DSIPoiOnlineSearchReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearchListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIPoiOnlineSearchDispatcher(int n) {
        super(n, (class$org$dsi$ifc$online$DSIPoiOnlineSearchListener == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearchListener = DSIPoiOnlineSearchDispatcher.class$("org.dsi.ifc.online.DSIPoiOnlineSearchListener")) : class$org$dsi$ifc$online$DSIPoiOnlineSearchListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void poiResult(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPoiOnlineSearchListener dSIPoiOnlineSearchListener = (DSIPoiOnlineSearchListener)objectArray[i2];
                    dSIPoiOnlineSearchListener.poiResult(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPoiOnlineSearchListener dSIPoiOnlineSearchListener = (DSIPoiOnlineSearchListener)objectArray[i2];
                    dSIPoiOnlineSearchListener.poiSpellingSuggestion(n, string, stringArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void poiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPoiOnlineSearchListener dSIPoiOnlineSearchListener = (DSIPoiOnlineSearchListener)objectArray[i2];
                    dSIPoiOnlineSearchListener.poiValueList(n, n2, poiOnlineSearchValuelist, n3, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void precheckDynamicPOICategoryResponse(int n, OSRServiceState oSRServiceState) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPoiOnlineSearchListener dSIPoiOnlineSearchListener = (DSIPoiOnlineSearchListener)objectArray[i2];
                    dSIPoiOnlineSearchListener.precheckDynamicPOICategoryResponse(n, oSRServiceState);
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
                    DSIPoiOnlineSearchListener dSIPoiOnlineSearchListener = (DSIPoiOnlineSearchListener)objectArray[i2];
                    dSIPoiOnlineSearchListener.asyncException(n, string, n2);
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
                    DSIPoiOnlineSearchListener dSIPoiOnlineSearchListener = (DSIPoiOnlineSearchListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIPoiOnlineSearchDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIPoiOnlineSearchDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIPoiOnlineSearchListener, new Object[]{string, string2});
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

