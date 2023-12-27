/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.tpegservices;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.tpegservices.FuelPrice;
import org.dsi.ifc.tpegservices.FuelPriceInformation;
import org.dsi.ifc.tpegservices.News;
import org.dsi.ifc.tpegservices.NewsCategory;
import org.dsi.ifc.tpegservices.ResourceInformation;
import org.dsi.ifc.tpegservices.SimpleMapData;
import org.dsi.ifc.tpegservices.WeatherData;
import org.dsi.ifc.tpegservices.WeatherInfo;

public final class DSITPEGServicesTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_FUELPRICE;
    private static final int ID_FUELPRICEINFORMATION;
    private static final int ID_NEWS;
    private static final int ID_NEWSCATEGORY;
    private static final int ID_RESOURCEINFORMATION;
    private static final int ID_SIMPLEMAPDATA;
    private static final int ID_WEATHERDATA;
    private static final int ID_WEATHERINFO;
    static /* synthetic */ Class class$org$dsi$ifc$tpegservices$FuelPrice;
    static /* synthetic */ Class class$org$dsi$ifc$tpegservices$FuelPriceInformation;
    static /* synthetic */ Class class$org$dsi$ifc$tpegservices$News;
    static /* synthetic */ Class class$org$dsi$ifc$tpegservices$NewsCategory;
    static /* synthetic */ Class class$org$dsi$ifc$tpegservices$ResourceInformation;
    static /* synthetic */ Class class$org$dsi$ifc$tpegservices$SimpleMapData;
    static /* synthetic */ Class class$org$dsi$ifc$tpegservices$WeatherData;
    static /* synthetic */ Class class$org$dsi$ifc$tpegservices$WeatherInfo;

    public DSITPEGServicesTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tpegservices$FuelPrice == null ? (class$org$dsi$ifc$tpegservices$FuelPrice = DSITPEGServicesTracer.class$("org.dsi.ifc.tpegservices.FuelPrice")) : class$org$dsi$ifc$tpegservices$FuelPrice, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tpegservices$FuelPriceInformation == null ? (class$org$dsi$ifc$tpegservices$FuelPriceInformation = DSITPEGServicesTracer.class$("org.dsi.ifc.tpegservices.FuelPriceInformation")) : class$org$dsi$ifc$tpegservices$FuelPriceInformation, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tpegservices$News == null ? (class$org$dsi$ifc$tpegservices$News = DSITPEGServicesTracer.class$("org.dsi.ifc.tpegservices.News")) : class$org$dsi$ifc$tpegservices$News, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tpegservices$NewsCategory == null ? (class$org$dsi$ifc$tpegservices$NewsCategory = DSITPEGServicesTracer.class$("org.dsi.ifc.tpegservices.NewsCategory")) : class$org$dsi$ifc$tpegservices$NewsCategory, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tpegservices$ResourceInformation == null ? (class$org$dsi$ifc$tpegservices$ResourceInformation = DSITPEGServicesTracer.class$("org.dsi.ifc.tpegservices.ResourceInformation")) : class$org$dsi$ifc$tpegservices$ResourceInformation, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tpegservices$SimpleMapData == null ? (class$org$dsi$ifc$tpegservices$SimpleMapData = DSITPEGServicesTracer.class$("org.dsi.ifc.tpegservices.SimpleMapData")) : class$org$dsi$ifc$tpegservices$SimpleMapData, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tpegservices$WeatherData == null ? (class$org$dsi$ifc$tpegservices$WeatherData = DSITPEGServicesTracer.class$("org.dsi.ifc.tpegservices.WeatherData")) : class$org$dsi$ifc$tpegservices$WeatherData, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tpegservices$WeatherInfo == null ? (class$org$dsi$ifc$tpegservices$WeatherInfo = DSITPEGServicesTracer.class$("org.dsi.ifc.tpegservices.WeatherInfo")) : class$org$dsi$ifc$tpegservices$WeatherInfo, 8);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceFuelPrice(printWriter, (FuelPrice)object);
                break;
            }
            case 2: {
                this.traceFuelPriceInformation(printWriter, (FuelPriceInformation)object);
                break;
            }
            case 3: {
                this.traceNews(printWriter, (News)object);
                break;
            }
            case 4: {
                this.traceNewsCategory(printWriter, (NewsCategory)object);
                break;
            }
            case 5: {
                this.traceResourceInformation(printWriter, (ResourceInformation)object);
                break;
            }
            case 6: {
                this.traceSimpleMapData(printWriter, (SimpleMapData)object);
                break;
            }
            case 7: {
                this.traceWeatherData(printWriter, (WeatherData)object);
                break;
            }
            case 8: {
                this.traceWeatherInfo(printWriter, (WeatherInfo)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceFuelPrice(PrintWriter printWriter, FuelPrice fuelPrice) {
        if (fuelPrice == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(fuelPrice.currency);
        printWriter.print(fuelPrice.gasoline);
        printWriter.print(fuelPrice.diesel);
    }

    private void traceFuelPriceInformation(PrintWriter printWriter, FuelPriceInformation fuelPriceInformation) {
        if (fuelPriceInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(fuelPriceInformation.name);
        this.trace(printWriter, fuelPriceInformation.lastUpdate);
        this.trace(printWriter, fuelPriceInformation.priceInformation);
        printWriter.print(fuelPriceInformation.latitude);
        printWriter.print(fuelPriceInformation.longitude);
        printWriter.print(fuelPriceInformation.contentId);
        printWriter.print(fuelPriceInformation.navLocationId);
    }

    private void traceNews(PrintWriter printWriter, News news) {
        if (news == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(news.newsHeadliner);
        this.trace(printWriter, news.timestamp);
        printWriter.print(news.contentId);
        printWriter.print(news.newsHeadline);
        printWriter.print(news.newsText);
    }

    private void traceNewsCategory(PrintWriter printWriter, NewsCategory newsCategory) {
        if (newsCategory == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(newsCategory.contentId);
        printWriter.print(newsCategory.newsType);
        if (newsCategory.news == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = newsCategory.news.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, newsCategory.news[i2]);
            }
        }
    }

    private void traceResourceInformation(PrintWriter printWriter, ResourceInformation resourceInformation) {
        if (resourceInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, resourceInformation.resourceLocator);
        printWriter.print(resourceInformation.phoneticString);
    }

    private void traceSimpleMapData(PrintWriter printWriter, SimpleMapData simpleMapData) {
        if (simpleMapData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(simpleMapData.id);
        printWriter.print(simpleMapData.contentId);
        printWriter.print(simpleMapData.subCategory);
        printWriter.print(simpleMapData.isBookmark);
        printWriter.print(simpleMapData.description);
        this.trace(printWriter, simpleMapData.timestamp);
    }

    private void traceWeatherData(PrintWriter printWriter, WeatherData weatherData) {
        if (weatherData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(weatherData.weatherType);
        printWriter.print(weatherData.weatherInfoType);
        printWriter.print(weatherData.maxTemperature);
        printWriter.print(weatherData.minTemperature);
        printWriter.print(weatherData.averageTemperature);
    }

    private void traceWeatherInfo(PrintWriter printWriter, WeatherInfo weatherInfo) {
        if (weatherInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, weatherInfo.dateTime);
        printWriter.print(weatherInfo.weatherInfoInterval);
        if (weatherInfo.weatherDataList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = weatherInfo.weatherDataList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, weatherInfo.weatherDataList[i2]);
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

