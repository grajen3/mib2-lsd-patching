/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.iconhandling;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.iconhandling.DSIIconExtractorReply;
import de.esolutions.fw.comm.dsi.iconhandling.impl.DSIIconExtractorReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.DSIIconExtractorListener;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public class DSIIconExtractorDispatcher
extends AbstractDispatcher
implements DSIIconExtractorReply {
    private DSIIconExtractorReplyService service = new DSIIconExtractorReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$iconhandling$DSIIconExtractorListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIIconExtractorDispatcher(int n) {
        super(n, (class$org$dsi$ifc$iconhandling$DSIIconExtractorListener == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractorListener = DSIIconExtractorDispatcher.class$("org.dsi.ifc.iconhandling.DSIIconExtractorListener")) : class$org$dsi$ifc$iconhandling$DSIIconExtractorListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void iconResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.iconResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForTMCEventIcon(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForTMCEventIcon(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForPOIIcon(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForPOIIcon(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void renderingInformationForRoadIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.renderingInformationForRoadIcon(resourceLocator, textRenderingInfo);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForTargetIcon(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForTargetIcon(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForRoadClassIcon(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForRoadClassIcon(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForTrafficRegulationIcon(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForTrafficRegulationIcon(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForAdditionalIcon(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForAdditionalIcon(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void renderingInformationForExitIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.renderingInformationForExitIcon(resourceLocator, textRenderingInfo);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForCountryIcon(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForCountryIcon(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForTrafficRegulationIconWithSubIndex(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForTrafficRegulationIconWithSubIndex(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void renderingInformationForExitIconWithVariant(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.renderingInformationForExitIconWithVariant(resourceLocator, textRenderingInfo);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setBrandIconStyleResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.setBrandIconStyleResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForTrafficSourceIconResult(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForTrafficSourceIconResult(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForAreaWarningIconResult(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForAreaWarningIconResult(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForAdditionalTurnListIconResult(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForAdditionalTurnListIconResult(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForComposedPOIIconResult(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForComposedPOIIconResult(resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resourceIdForPOIIconFromRawDataResult(ResourceLocator resourceLocator) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.resourceIdForPOIIconFromRawDataResult(resourceLocator);
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
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    dSIIconExtractorListener.asyncException(n, string, n2);
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
                    DSIIconExtractorListener dSIIconExtractorListener = (DSIIconExtractorListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIIconExtractorDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIIconExtractorDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIIconExtractorListener, new Object[]{string, string2});
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

