/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tpegservices;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.tpegservices.DSITPEGServicesReply;
import de.esolutions.fw.comm.dsi.tpegservices.impl.DSITPEGServicesReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.tpegservices.DSITPEGServicesListener;
import org.dsi.ifc.tpegservices.FuelPriceInformation;
import org.dsi.ifc.tpegservices.NewsCategory;
import org.dsi.ifc.tpegservices.ResourceInformation;
import org.dsi.ifc.tpegservices.SimpleMapData;
import org.dsi.ifc.tpegservices.WeatherInfo;

public class DSITPEGServicesDispatcher
extends AbstractDispatcher
implements DSITPEGServicesReply {
    private DSITPEGServicesReplyService service = new DSITPEGServicesReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$tpegservices$DSITPEGServicesListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSITPEGServicesDispatcher(int n) {
        super(n, (class$org$dsi$ifc$tpegservices$DSITPEGServicesListener == null ? (class$org$dsi$ifc$tpegservices$DSITPEGServicesListener = DSITPEGServicesDispatcher.class$("org.dsi.ifc.tpegservices.DSITPEGServicesListener")) : class$org$dsi$ifc$tpegservices$DSITPEGServicesListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateTPEGContentAvailability(int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)iterator.next();
                    this.confirmNotificationListener(1, dSITPEGServicesListener);
                    dSITPEGServicesListener.updateTPEGContentAvailability(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)iterator.next();
                    dSITPEGServicesListener.updateTPEGContentAvailability(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSimpleMapsBookmarks(SimpleMapData[] simpleMapDataArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)iterator.next();
                    this.confirmNotificationListener(2, dSITPEGServicesListener);
                    dSITPEGServicesListener.updateSimpleMapsBookmarks(simpleMapDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)iterator.next();
                    dSITPEGServicesListener.updateSimpleMapsBookmarks(simpleMapDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestLocationDetailsResponse(NavLocation navLocation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    dSITPEGServicesListener.requestLocationDetailsResponse(navLocation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestFuelPriceInformationResponse(FuelPriceInformation[] fuelPriceInformationArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    dSITPEGServicesListener.requestFuelPriceInformationResponse(fuelPriceInformationArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestNewsInformationResponse(NewsCategory newsCategory) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    dSITPEGServicesListener.requestNewsInformationResponse(newsCategory);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestSimpleMapListResponse(int n, int n2, SimpleMapData[] simpleMapDataArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    dSITPEGServicesListener.requestSimpleMapListResponse(n, n2, simpleMapDataArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void addSimpleMapBookmarkResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    dSITPEGServicesListener.addSimpleMapBookmarkResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deleteSimpleMapBookmarkResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    dSITPEGServicesListener.deleteSimpleMapBookmarkResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deleteAllSimpleMapBookmarksResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    dSITPEGServicesListener.deleteAllSimpleMapBookmarksResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    dSITPEGServicesListener.requestResourceInformationResponse(n, resourceInformation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setLanguageResponse(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    dSITPEGServicesListener.setLanguageResponse(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestWeatherInfoResult(WeatherInfo weatherInfo, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    dSITPEGServicesListener.requestWeatherInfoResult(weatherInfo, n);
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
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    dSITPEGServicesListener.asyncException(n, string, n2);
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
                    DSITPEGServicesListener dSITPEGServicesListener = (DSITPEGServicesListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSITPEGServicesDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSITPEGServicesDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSITPEGServicesListener, new Object[]{string, string2});
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

