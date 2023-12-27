/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.destinput;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.destinput.destlist.transformer.DestListCollector;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.FixFormatterFieldData;
import java.util.LinkedList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public final class TourList {
    private static TourList INSTANCE;
    private LinkedList myTour = new LinkedList();
    private int myIndexToAdd = 0;
    private NavLocation myLocationToAdd;
    private NavLocation myLocationToAddBackup;
    private boolean isReplaceInterDest = false;
    private boolean isReplaceFinalDest = false;
    private static final int MAX_SIZE;

    private NavLocation getMyLocationToAdd() {
        return this.myLocationToAdd;
    }

    private void setMyLocationToAdd(NavLocation navLocation) {
        this.myLocationToAdd = navLocation;
        if (navLocation != null) {
            this.myLocationToAddBackup = navLocation;
        }
    }

    private TourList() {
    }

    public static TourList getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TourList();
        }
        return INSTANCE;
    }

    public void trace(String string) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    public void createNewTour(NavLocation navLocation) {
        this.trace("createNewTour()");
        ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().traceWithLocation(ServiceManager.logger, 16384, "createNewTour() location: ", navLocation, "");
        this.myTour.clear();
        this.setMyLocationToAdd(navLocation);
        this.isReplaceInterDest = false;
        this.isReplaceFinalDest = false;
        this.myIndexToAdd = this.myTour.size();
        this.save();
    }

    public LinkedList getTour() {
        return this.myTour;
    }

    public void addDestination(NavLocation navLocation) {
        this.trace("addDestination()");
        ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().traceWithLocation(ServiceManager.logger, 16384, "addDestination() location: ", navLocation, "");
        this.setMyLocationToAdd(navLocation);
        this.myIndexToAdd = this.myTour.size();
        this.updateListForHMI(false);
    }

    public void save() {
        this.trace("save()");
        if (this.isReplaceFinalDest) {
            this.trace("replacing final destination.");
            this.myTour.removeLast();
            this.isReplaceFinalDest = false;
        } else if (this.isReplaceInterDest) {
            this.trace("replacing intermediate destination.");
            this.myTour.removeFirst();
            this.isReplaceInterDest = false;
        }
        if (this.getMyLocationToAdd() != null) {
            this.myTour.add(this.myIndexToAdd, this.getMyLocationToAdd());
        } else if (this.myLocationToAddBackup != null) {
            this.myTour.add(this.myIndexToAdd, this.myLocationToAddBackup);
        }
        this.myIndexToAdd = this.myTour.size();
        int n = ServiceManager.configManagerDiag.getNaviCommonOptionDefault(1);
        if (this.myTour.size() > 1) {
            FixFormatterFieldData fixFormatterFieldData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper((NavLocation)this.myTour.getFirst()));
            String string = ServiceManager.fixFormat4Asl.fmtRulesetBasedString(10 + n, fixFormatterFieldData);
            ServiceManager.aslPropertyManager.valueChangedString(793, string);
        } else if (this.myTour.size() > 0) {
            FixFormatterFieldData fixFormatterFieldData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper((NavLocation)this.myTour.getLast()));
            String string = ServiceManager.fixFormat4Asl.fmtRulesetBasedString(10 + n, fixFormatterFieldData);
            ServiceManager.aslPropertyManager.valueChangedString(792, string);
        }
    }

    public void restore() {
        this.trace("restore()");
        this.myTour.remove(this.getMyLocationToAdd());
        this.setMyLocationToAdd(null);
        this.isReplaceInterDest = false;
        this.isReplaceFinalDest = false;
        this.myIndexToAdd = this.myTour.size();
        this.updateListForHMI(false);
    }

    public void clear() {
        this.trace("clear()");
        this.myTour.clear();
        this.setMyLocationToAdd(null);
        this.isReplaceInterDest = false;
        this.isReplaceFinalDest = false;
        this.myIndexToAdd = this.myTour.size();
        this.updateListForHMI(false);
    }

    public void moveUp() {
        this.trace("moveUp()");
        if (this.myIndexToAdd < this.myTour.size()) {
            ++this.myIndexToAdd;
            this.updateListForHMI(false);
        }
    }

    public void moveDown() {
        this.trace("moveDown()");
        if (this.myIndexToAdd > 0) {
            --this.myIndexToAdd;
            this.updateListForHMI(false);
        }
    }

    public void exchangeInterAndDest() {
        this.trace("exchangeInterAndDest()");
        this.myIndexToAdd = this.myIndexToAdd > 0 ? 0 : 1;
        this.updateListForHMI(false);
    }

    public void trim() {
        this.trace("trim()");
        this.isReplaceInterDest = false;
        this.isReplaceFinalDest = false;
        this.myTour.clear();
        this.myIndexToAdd = this.myTour.size();
        this.myTour.add(this.getMyLocationToAdd());
        ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().traceWithLocation(ServiceManager.logger, 16384, "trim() location: ", this.getMyLocationToAdd(), "");
    }

    public void replaceFinalDest() {
        this.trace("replaceFinalDest()");
        if (!this.myTour.isEmpty()) {
            this.isReplaceFinalDest = true;
            this.myIndexToAdd = this.myTour.size() - 1;
            this.updateListForHMI(false);
        }
    }

    public void replaceInterDest() {
        this.trace("replaceInterDest()");
        if (this.myTour.size() > 1) {
            this.isReplaceInterDest = true;
            this.myIndexToAdd = 0;
            this.updateListForHMI(false);
        }
    }

    public void deleteIntermediateDest() {
        this.trace("deleteIntermediateDest()");
        if (this.myTour.size() > 1) {
            this.myTour.removeFirst();
            this.myIndexToAdd = this.myTour.size();
            this.setMyLocationToAdd(null);
            this.updateListForHMI(false);
        }
    }

    public void deleteFirstDest() {
        this.trace("deleteFirstDest()");
        if (this.myTour.size() > 0) {
            this.myTour.removeFirst();
        }
        this.setMyLocationToAdd(null);
        this.updateListForHMI(false);
    }

    private void updateListForHMI(boolean bl) {
        int n;
        LinkedList linkedList;
        block12: {
            Object object;
            this.trace("updateListForHMI()");
            linkedList = new LinkedList();
            n = this.myIndexToAdd;
            NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPositionDescription();
            if (navLocation != null) {
                object = this.createDestListCollector(navLocation);
                linkedList.add(object);
                ++n;
            }
            if (!bl) {
                object = this.myTour.iterator();
                while (object.hasNext()) {
                    linkedList.add(this.createDestListCollector((NavLocation)object.next()));
                }
            }
            try {
                if (this.isReplaceFinalDest) {
                    linkedList.removeLast();
                } else if (this.isReplaceInterDest) {
                    linkedList.remove(1);
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                linkedList.clear();
                if (navLocation == null) break block12;
                linkedList.add(this.createDestListCollector(navLocation));
                n = 1;
            }
        }
        if (this.getMyLocationToAdd() != null) {
            if (n >= 0 && n < linkedList.size()) {
                linkedList.add(n, this.createDestListCollector(this.getMyLocationToAdd()));
            } else {
                linkedList.add(this.createDestListCollector(this.getMyLocationToAdd()));
            }
        }
        for (int i2 = linkedList.size(); i2 < 3; ++i2) {
            linkedList.add(new DestListCollector());
        }
    }

    private DestListCollector createDestListCollector(NavLocation navLocation) {
        this.trace("createDestListCollector()");
        DestListCollector destListCollector = new DestListCollector();
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        destListCollector.city = iLocationWrapper.getCity();
        destListCollector.crossing = iLocationWrapper.getCrossing();
        destListCollector.hno = iLocationWrapper.getHousenumber();
        destListCollector.latDegree = iLocationWrapper.getLatitudeDegrees();
        destListCollector.latMin = iLocationWrapper.getLatitudeMinutes();
        destListCollector.latSec = iLocationWrapper.getLatitudeSeconds();
        destListCollector.lonDegree = iLocationWrapper.getLongitudeDegrees();
        destListCollector.lonMin = iLocationWrapper.getLongitudeMinutes();
        destListCollector.lonSec = iLocationWrapper.getLongitudeSeconds();
        destListCollector.poiName = iLocationWrapper.getPoiName();
        destListCollector.street = iLocationWrapper.getStreet();
        switch (iLocationWrapper.getLocationType()) {
            case 1: {
                destListCollector.type = 0;
                break;
            }
            case 2: {
                destListCollector.type = 1;
                break;
            }
            case 0: {
                destListCollector.type = 3;
                break;
            }
            case 3: {
                destListCollector.type = 2;
                break;
            }
            case -1: {
                destListCollector.type = 255;
                break;
            }
        }
        return destListCollector;
    }

    public void updateCurrentRoute(Route route) {
        this.trace("updateCurrentRoute()");
        this.myTour = new LinkedList();
        if (route != null && route.routelist != null) {
            for (int i2 = (int)route.indexOfCurrentDestination; i2 < route.routelist.length; ++i2) {
                this.myTour.add(route.routelist[i2].routeLocation);
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("TourList [isReplaceFinalDest=");
        stringBuffer.append(this.isReplaceFinalDest);
        stringBuffer.append(", isReplaceInterDest=");
        stringBuffer.append(this.isReplaceInterDest);
        stringBuffer.append(", myIndexToAdd=");
        stringBuffer.append(this.myIndexToAdd);
        stringBuffer.append(", myLocationToAdd=");
        if (this.getMyLocationToAdd() != null) {
            stringBuffer.append(this.getMyLocationToAdd().toString());
        } else {
            stringBuffer.append("null");
        }
        stringBuffer.append(", myTout=");
        stringBuffer.append(this.myTour.toString());
        return stringBuffer.toString();
    }
}

