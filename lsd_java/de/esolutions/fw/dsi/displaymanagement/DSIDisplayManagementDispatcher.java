/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.displaymanagement;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.displaymanagement.DSIDisplayManagementReply;
import de.esolutions.fw.comm.dsi.displaymanagement.impl.DSIDisplayManagementReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;

public class DSIDisplayManagementDispatcher
extends AbstractDispatcher
implements DSIDisplayManagementReply {
    private DSIDisplayManagementReplyService service = new DSIDisplayManagementReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIDisplayManagementDispatcher(int n) {
        super(n, (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener = DSIDisplayManagementDispatcher.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagementListener")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void getExtents(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.getExtents(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void activeContext(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.activeContext(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void fadeStarted(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.fadeStarted(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void fadeComplete(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.fadeComplete(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getDisplayPower(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.getDisplayPower(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getDisplayBrightness(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.getDisplayBrightness(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getBrightness(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.getBrightness(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getContrast(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.getContrast(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getColor(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.getColor(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getTint(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.getTint(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void lockDisplayResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.lockDisplayResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void unlockDisplayResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.unlockDisplayResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setCroppingResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.setCroppingResult(n, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getDisplayableInfo(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.getDisplayableInfo(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void takeScreenshotOnExternalStorageResult(int n, int n2, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.takeScreenshotOnExternalStorageResult(n, n2, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setDisplayTypeResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.setDisplayTypeResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getDisplayTypeResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.getDisplayTypeResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setUpdateRateResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.setUpdateRateResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getUpdateRateResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.getUpdateRateResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void startComponentResult(int n, int n2, int n3, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.startComponentResult(n, n2, n3, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void stopComponentResult(int n, int n2, int n3, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.stopComponentResult(n, n2, n3, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setAnnotationDataResponse(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.setAnnotationDataResponse(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void initAnnotationsResponse(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.initAnnotationsResponse(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void destroyImageDisplayableResponse(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.destroyImageDisplayableResponse(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestUpdateImageDisplayableResponse(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.requestUpdateImageDisplayableResponse(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void createImageDisplayableResponse(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.createImageDisplayableResponse(n, n2);
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
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    dSIDisplayManagementListener.asyncException(n, string, n2);
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
                    DSIDisplayManagementListener dSIDisplayManagementListener = (DSIDisplayManagementListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIDisplayManagementDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIDisplayManagementDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIDisplayManagementListener, new Object[]{string, string2});
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

