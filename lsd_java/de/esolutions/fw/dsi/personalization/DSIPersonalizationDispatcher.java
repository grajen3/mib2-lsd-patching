/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.personalization;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.personalization.DSIPersonalizationReply;
import de.esolutions.fw.comm.dsi.personalization.impl.DSIPersonalizationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.personalization.DSIPersonalizationListener;

public class DSIPersonalizationDispatcher
extends AbstractDispatcher
implements DSIPersonalizationReply {
    private DSIPersonalizationReplyService service = new DSIPersonalizationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$personalization$DSIPersonalizationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIPersonalizationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$personalization$DSIPersonalizationListener == null ? (class$org$dsi$ifc$personalization$DSIPersonalizationListener = DSIPersonalizationDispatcher.class$("org.dsi.ifc.personalization.DSIPersonalizationListener")) : class$org$dsi$ifc$personalization$DSIPersonalizationListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void copyProfile(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersonalizationListener dSIPersonalizationListener = (DSIPersonalizationListener)objectArray[i2];
                    dSIPersonalizationListener.copyProfile(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resetProfile(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersonalizationListener dSIPersonalizationListener = (DSIPersonalizationListener)objectArray[i2];
                    dSIPersonalizationListener.resetProfile(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resetAllProfiles() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPersonalizationListener dSIPersonalizationListener = (DSIPersonalizationListener)objectArray[i2];
                    dSIPersonalizationListener.resetAllProfiles();
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
                    DSIPersonalizationListener dSIPersonalizationListener = (DSIPersonalizationListener)objectArray[i2];
                    dSIPersonalizationListener.asyncException(n, string, n2);
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
                    DSIPersonalizationListener dSIPersonalizationListener = (DSIPersonalizationListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIPersonalizationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIPersonalizationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIPersonalizationListener, new Object[]{string, string2});
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

