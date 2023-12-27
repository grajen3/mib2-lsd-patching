/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.picturestore;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.picturestore.DSIPictureStoreReply;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStoreListener;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public class DSIPictureStoreDispatcher
extends AbstractDispatcher
implements DSIPictureStoreReply {
    private DSIPictureStoreReplyService service = new DSIPictureStoreReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$picturestore$DSIPictureStoreListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIPictureStoreDispatcher(int n) {
        super(n, (class$org$dsi$ifc$picturestore$DSIPictureStoreListener == null ? (class$org$dsi$ifc$picturestore$DSIPictureStoreListener = DSIPictureStoreDispatcher.class$("org.dsi.ifc.picturestore.DSIPictureStoreListener")) : class$org$dsi$ifc$picturestore$DSIPictureStoreListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void importPictureResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.importPictureResult(n, resourceLocator, resourceLocator2, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void pictureExists(ResourceLocator resourceLocator, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.pictureExists(resourceLocator, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void freeSlots(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.freeSlots(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getReferencesResult(ResourceLocator resourceLocator, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.getReferencesResult(resourceLocator, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deletedPictures(ResourceLocator[] resourceLocatorArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.deletedPictures(resourceLocatorArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseLRUPictures(int n, ResourceLocator[] resourceLocatorArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.responseLRUPictures(n, resourceLocatorArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void listResult(ResourceLocator[] resourceLocatorArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.listResult(resourceLocatorArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void listForContextResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.listForContextResult(n, resourceLocatorArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getPictureAttributesResult(ResourceLocator resourceLocator, PictureAttribute[] pictureAttributeArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.getPictureAttributesResult(resourceLocator, pictureAttributeArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void importPictureFromSourceResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.importPictureFromSourceResult(n, resourceLocator, resourceLocator2, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void listForContextWithFilterResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.listForContextWithFilterResult(n, resourceLocatorArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void listForContextWithFilterSortDistResult(int n, ResourceLocator[] resourceLocatorArray, int n2, float f2, float f3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.listForContextWithFilterSortDistResult(n, resourceLocatorArray, n2, f2, f3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getRectanglePicturesGridResult(GeoPicture[] geoPictureArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.getRectanglePicturesGridResult(geoPictureArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getAvailableYearsResult(int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.getAvailableYearsResult(nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getAvailableMonthsResult(int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.getAvailableMonthsResult(nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void createFilterSetResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.createFilterSetResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void cloneFilterSetResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.cloneFilterSetResult(n, n2);
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
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.resetToFactorySettingsResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void invalidData(int[] nArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.invalidData(nArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getAvailableFoldersResult(int n, String[] stringArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.getAvailableFoldersResult(n, stringArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void countPicturesInContextResult(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.countPicturesInContextResult(n, n2, n3);
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
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    dSIPictureStoreListener.asyncException(n, string, n2);
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
                    DSIPictureStoreListener dSIPictureStoreListener = (DSIPictureStoreListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIPictureStoreDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIPictureStoreDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIPictureStoreListener, new Object[]{string, string2});
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

