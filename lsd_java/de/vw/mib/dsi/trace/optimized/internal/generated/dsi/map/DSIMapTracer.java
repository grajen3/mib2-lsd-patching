/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.map;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.PoiListElement;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.RouteBrowserInfo;
import org.dsi.ifc.map.StreetViewThumbnail;
import org.dsi.ifc.map.ViewPort;

public final class DSIMapTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_AVAILABLEROUTE;
    private static final int ID_LAYERPROPERTY;
    private static final int ID_MAPFLAG;
    private static final int ID_MAPOVERLAY;
    private static final int ID_POILISTELEMENT;
    private static final int ID_POINT;
    private static final int ID_POSINFO;
    private static final int ID_RECT;
    private static final int ID_ROUTEBROWSERINFO;
    private static final int ID_STREETVIEWTHUMBNAIL;
    private static final int ID_VIEWPORT;
    static /* synthetic */ Class class$org$dsi$ifc$map$AvailableRoute;
    static /* synthetic */ Class class$org$dsi$ifc$map$LayerProperty;
    static /* synthetic */ Class class$org$dsi$ifc$map$MapFlag;
    static /* synthetic */ Class class$org$dsi$ifc$map$MapOverlay;
    static /* synthetic */ Class class$org$dsi$ifc$map$PoiListElement;
    static /* synthetic */ Class class$org$dsi$ifc$map$Point;
    static /* synthetic */ Class class$org$dsi$ifc$map$PosInfo;
    static /* synthetic */ Class class$org$dsi$ifc$map$Rect;
    static /* synthetic */ Class class$org$dsi$ifc$map$RouteBrowserInfo;
    static /* synthetic */ Class class$org$dsi$ifc$map$StreetViewThumbnail;
    static /* synthetic */ Class class$org$dsi$ifc$map$ViewPort;

    public DSIMapTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$map$AvailableRoute == null ? (class$org$dsi$ifc$map$AvailableRoute = DSIMapTracer.class$("org.dsi.ifc.map.AvailableRoute")) : class$org$dsi$ifc$map$AvailableRoute, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$map$LayerProperty == null ? (class$org$dsi$ifc$map$LayerProperty = DSIMapTracer.class$("org.dsi.ifc.map.LayerProperty")) : class$org$dsi$ifc$map$LayerProperty, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$map$MapFlag == null ? (class$org$dsi$ifc$map$MapFlag = DSIMapTracer.class$("org.dsi.ifc.map.MapFlag")) : class$org$dsi$ifc$map$MapFlag, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$map$MapOverlay == null ? (class$org$dsi$ifc$map$MapOverlay = DSIMapTracer.class$("org.dsi.ifc.map.MapOverlay")) : class$org$dsi$ifc$map$MapOverlay, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$map$PoiListElement == null ? (class$org$dsi$ifc$map$PoiListElement = DSIMapTracer.class$("org.dsi.ifc.map.PoiListElement")) : class$org$dsi$ifc$map$PoiListElement, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$map$Point == null ? (class$org$dsi$ifc$map$Point = DSIMapTracer.class$("org.dsi.ifc.map.Point")) : class$org$dsi$ifc$map$Point, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$map$PosInfo == null ? (class$org$dsi$ifc$map$PosInfo = DSIMapTracer.class$("org.dsi.ifc.map.PosInfo")) : class$org$dsi$ifc$map$PosInfo, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$map$Rect == null ? (class$org$dsi$ifc$map$Rect = DSIMapTracer.class$("org.dsi.ifc.map.Rect")) : class$org$dsi$ifc$map$Rect, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$map$RouteBrowserInfo == null ? (class$org$dsi$ifc$map$RouteBrowserInfo = DSIMapTracer.class$("org.dsi.ifc.map.RouteBrowserInfo")) : class$org$dsi$ifc$map$RouteBrowserInfo, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$map$StreetViewThumbnail == null ? (class$org$dsi$ifc$map$StreetViewThumbnail = DSIMapTracer.class$("org.dsi.ifc.map.StreetViewThumbnail")) : class$org$dsi$ifc$map$StreetViewThumbnail, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$map$ViewPort == null ? (class$org$dsi$ifc$map$ViewPort = DSIMapTracer.class$("org.dsi.ifc.map.ViewPort")) : class$org$dsi$ifc$map$ViewPort, 11);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAvailableRoute(printWriter, (AvailableRoute)object);
                break;
            }
            case 2: {
                this.traceLayerProperty(printWriter, (LayerProperty)object);
                break;
            }
            case 3: {
                this.traceMapFlag(printWriter, (MapFlag)object);
                break;
            }
            case 4: {
                this.traceMapOverlay(printWriter, (MapOverlay)object);
                break;
            }
            case 5: {
                this.tracePoiListElement(printWriter, (PoiListElement)object);
                break;
            }
            case 6: {
                this.tracePoint(printWriter, (Point)object);
                break;
            }
            case 7: {
                this.tracePosInfo(printWriter, (PosInfo)object);
                break;
            }
            case 8: {
                this.traceRect(printWriter, (Rect)object);
                break;
            }
            case 9: {
                this.traceRouteBrowserInfo(printWriter, (RouteBrowserInfo)object);
                break;
            }
            case 10: {
                this.traceStreetViewThumbnail(printWriter, (StreetViewThumbnail)object);
                break;
            }
            case 11: {
                this.traceViewPort(printWriter, (ViewPort)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAvailableRoute(PrintWriter printWriter, AvailableRoute availableRoute) {
        if (availableRoute == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, availableRoute.navSegmentID);
        printWriter.print(availableRoute.changeIndicator);
        printWriter.print(availableRoute.isComplete);
    }

    private void traceLayerProperty(PrintWriter printWriter, LayerProperty layerProperty) {
        if (layerProperty == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(layerProperty.iconFilename);
        printWriter.print(layerProperty.text);
        printWriter.print(layerProperty.uId);
        printWriter.print(layerProperty.parent);
        printWriter.print(layerProperty.layerType);
    }

    private void traceMapFlag(PrintWriter printWriter, MapFlag mapFlag) {
        if (mapFlag == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(mapFlag.geoX);
        printWriter.print(mapFlag.geoY);
        printWriter.print(mapFlag.styleIndex);
        printWriter.print(mapFlag.handle);
    }

    private void traceMapOverlay(PrintWriter printWriter, MapOverlay mapOverlay) {
        if (mapOverlay == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(mapOverlay.path);
        this.trace(printWriter, mapOverlay.rectangle);
        printWriter.print(mapOverlay.description);
        this.trace(printWriter, mapOverlay.textFieldBoundingBox);
    }

    private void tracePoiListElement(PrintWriter printWriter, PoiListElement poiListElement) {
        if (poiListElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(poiListElement.poiUniqueId);
        printWriter.print(poiListElement.criteriaNumber);
        this.trace(printWriter, poiListElement.position);
        printWriter.print(poiListElement.countryAbbreviation);
    }

    private void tracePoint(PrintWriter printWriter, Point point) {
        if (point == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(point.xPos);
        printWriter.print(point.yPos);
    }

    private void tracePosInfo(PrintWriter printWriter, PosInfo posInfo) {
        if (posInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(posInfo.eInfoType);
        printWriter.print(posInfo.objectId);
        this.trace(printWriter, posInfo.tLocation);
        this.trace(printWriter, posInfo.displayPosition);
        printWriter.print(posInfo.infoTxt);
        printWriter.print(posInfo.url);
        this.trace(printWriter, posInfo.resourceLocator);
        printWriter.print(posInfo.numberOfObjects);
    }

    private void traceRect(PrintWriter printWriter, Rect rect) {
        if (rect == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rect.kordX);
        printWriter.print(rect.kordY);
        printWriter.print(rect.diffX);
        printWriter.print(rect.diffY);
    }

    private void traceRouteBrowserInfo(PrintWriter printWriter, RouteBrowserInfo routeBrowserInfo) {
        if (routeBrowserInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(routeBrowserInfo.lengthOfSelectedSegments);
        printWriter.print(routeBrowserInfo.name);
    }

    private void traceStreetViewThumbnail(PrintWriter printWriter, StreetViewThumbnail streetViewThumbnail) {
        if (streetViewThumbnail == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(streetViewThumbnail.geoX);
        printWriter.print(streetViewThumbnail.geoY);
        printWriter.print(streetViewThumbnail.direction);
        printWriter.print(streetViewThumbnail.thumbnailWidth);
        printWriter.print(streetViewThumbnail.thumbnailHeight);
        printWriter.print(streetViewThumbnail.description);
        printWriter.print(streetViewThumbnail.url);
    }

    private void traceViewPort(PrintWriter printWriter, ViewPort viewPort) {
        if (viewPort == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, viewPort.position);
        printWriter.print(viewPort.rotation);
        printWriter.print(viewPort.zoomIdx);
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

