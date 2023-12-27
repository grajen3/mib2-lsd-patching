/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.search;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.search.DSISearchDataProviderReply;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchDataProviderReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.search.DSISearchDataProviderListener;

public class DSISearchDataProviderDispatcher
extends AbstractDispatcher
implements DSISearchDataProviderReply {
    private DSISearchDataProviderReplyService service = new DSISearchDataProviderReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchDataProviderListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISearchDataProviderDispatcher(int n) {
        super(n, (class$org$dsi$ifc$search$DSISearchDataProviderListener == null ? (class$org$dsi$ifc$search$DSISearchDataProviderListener = DSISearchDataProviderDispatcher.class$("org.dsi.ifc.search.DSISearchDataProviderListener")) : class$org$dsi$ifc$search$DSISearchDataProviderListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void registerProviderSourceResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchDataProviderListener dSISearchDataProviderListener = (DSISearchDataProviderListener)objectArray[i2];
                    dSISearchDataProviderListener.registerProviderSourceResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void activateProviderSource(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchDataProviderListener dSISearchDataProviderListener = (DSISearchDataProviderListener)objectArray[i2];
                    dSISearchDataProviderListener.activateProviderSource(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void invalidateAllDataResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchDataProviderListener dSISearchDataProviderListener = (DSISearchDataProviderListener)objectArray[i2];
                    dSISearchDataProviderListener.invalidateAllDataResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void provideData(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchDataProviderListener dSISearchDataProviderListener = (DSISearchDataProviderListener)objectArray[i2];
                    dSISearchDataProviderListener.provideData(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void storeDataSetsResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchDataProviderListener dSISearchDataProviderListener = (DSISearchDataProviderListener)objectArray[i2];
                    dSISearchDataProviderListener.storeDataSetsResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deleteDataSetResult(int n, int n2, long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISearchDataProviderListener dSISearchDataProviderListener = (DSISearchDataProviderListener)objectArray[i2];
                    dSISearchDataProviderListener.deleteDataSetResult(n, n2, l);
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
                    DSISearchDataProviderListener dSISearchDataProviderListener = (DSISearchDataProviderListener)objectArray[i2];
                    dSISearchDataProviderListener.asyncException(n, string, n2);
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
                    DSISearchDataProviderListener dSISearchDataProviderListener = (DSISearchDataProviderListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISearchDataProviderDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISearchDataProviderDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISearchDataProviderListener, new Object[]{string, string2});
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

