/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.asiainput;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.asiainput.DSIAsiaInputReply;
import de.esolutions.fw.comm.dsi.asiainput.impl.DSIAsiaInputReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.asiainput.DSIAsiaInputListener;

public class DSIAsiaInputDispatcher
extends AbstractDispatcher
implements DSIAsiaInputReply {
    private DSIAsiaInputReplyService service = new DSIAsiaInputReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$asiainput$DSIAsiaInputListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAsiaInputDispatcher(int n) {
        super(n, (class$org$dsi$ifc$asiainput$DSIAsiaInputListener == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInputListener = DSIAsiaInputDispatcher.class$("org.dsi.ifc.asiainput.DSIAsiaInputListener")) : class$org$dsi$ifc$asiainput$DSIAsiaInputListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void initialized(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.initialized(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getVersionInfo(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.getVersionInfo(string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void builtCandidates(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.builtCandidates(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getSpelling(String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.getSpelling(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getCandidates(String[] stringArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.getCandidates(stringArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void selectedCandidate(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.selectedCandidate(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicateErrorStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.indicateErrorStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicateDataInvalidated(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.indicateDataInvalidated(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getIntParameter(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.getIntParameter(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getBooleanParameter(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.getBooleanParameter(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setIntParameterResult(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.setIntParameterResult(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setBooleanParameterResult(int n, boolean bl, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.setBooleanParameterResult(n, bl, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setStringParameterResult(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.setStringParameterResult(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getStringParameter(int n, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.getStringParameter(n, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setAdditionalWordDatabasesResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.setAdditionalWordDatabasesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setUserDatabaseStateResult(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.setUserDatabaseStateResult(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resetToFactorySettingsResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.resetToFactorySettingsResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getSegmentation(String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.getSegmentation(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSegmentationForTruffles(String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.responseSegmentationForTruffles(string);
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
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    dSIAsiaInputListener.asyncException(n, string, n2);
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
                    DSIAsiaInputListener dSIAsiaInputListener = (DSIAsiaInputListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAsiaInputDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAsiaInputDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAsiaInputListener, new Object[]{string, string2});
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

