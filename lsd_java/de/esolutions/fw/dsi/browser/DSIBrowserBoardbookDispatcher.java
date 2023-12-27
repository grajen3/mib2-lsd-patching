/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.browser;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserBoardbookReply;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBoardbookReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.browser.DSIBrowserBoardbookListener;
import org.dsi.ifc.browser.SearchHit;

public class DSIBrowserBoardbookDispatcher
extends AbstractDispatcher
implements DSIBrowserBoardbookReply {
    private DSIBrowserBoardbookReplyService service = new DSIBrowserBoardbookReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserBoardbookListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIBrowserBoardbookDispatcher(int n) {
        super(n, (class$org$dsi$ifc$browser$DSIBrowserBoardbookListener == null ? (class$org$dsi$ifc$browser$DSIBrowserBoardbookListener = DSIBrowserBoardbookDispatcher.class$("org.dsi.ifc.browser.DSIBrowserBoardbookListener")) : class$org$dsi$ifc$browser$DSIBrowserBoardbookListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void indicateSearchResults(String string, int n, SearchHit[] searchHitArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIBrowserBoardbookListener dSIBrowserBoardbookListener = (DSIBrowserBoardbookListener)objectArray[i2];
                    dSIBrowserBoardbookListener.indicateSearchResults(string, n, searchHitArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBoardbookStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserBoardbookListener dSIBrowserBoardbookListener = (DSIBrowserBoardbookListener)iterator.next();
                    this.confirmNotificationListener(1, dSIBrowserBoardbookListener);
                    dSIBrowserBoardbookListener.updateBoardbookStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIBrowserBoardbookListener dSIBrowserBoardbookListener = (DSIBrowserBoardbookListener)iterator.next();
                    dSIBrowserBoardbookListener.updateBoardbookStatus(n, n2);
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
                    DSIBrowserBoardbookListener dSIBrowserBoardbookListener = (DSIBrowserBoardbookListener)objectArray[i2];
                    dSIBrowserBoardbookListener.asyncException(n, string, n2);
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
                    DSIBrowserBoardbookListener dSIBrowserBoardbookListener = (DSIBrowserBoardbookListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIBrowserBoardbookDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIBrowserBoardbookDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIBrowserBoardbookListener, new Object[]{string, string2});
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

