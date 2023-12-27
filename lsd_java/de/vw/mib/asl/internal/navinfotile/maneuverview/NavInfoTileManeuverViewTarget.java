/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.maneuverview;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenService;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navinfotile.maneuverview.NavInfoTileManeuverViewNotifierModel;
import de.vw.mib.asl.internal.navinfotile.maneuverview.NavInfoTileServiceListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class NavInfoTileManeuverViewTarget
extends AbstractASLTarget
implements Observer {
    final NavInfoTileManeuverViewNotifierModel notifierModel;
    NavInfoTileServiceListener serviceListener = new NavInfoTileServiceListener(this);
    private NavigationSplitscreenService navigationSplitscreenService;

    public NavInfoTileManeuverViewTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.notifierModel = new NavInfoTileManeuverViewNotifierModel();
        int[] nArray = new int[]{106};
        this.addObservers(nArray);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.traceState("POWER_ON");
                break;
            }
        }
    }

    private void handleNavServiceReady() {
        this.traceState("handleNavServiceReady()");
        this.navigationSplitscreenService = ASLNavigationFactory.getNavigationApi().getNavigationSplitscreenService(this.serviceListener);
        this.notifierModel.setManeuverViewDefaults();
    }

    public void traceState(String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }

    public void updateCompassDegree(int n) {
    }

    public void updateCompassStreet(String string) {
    }

    public void updateLocationInfo(INavigationLocation iNavigationLocation) {
    }

    public void updatePositionInfo(INavigationPosPosition iNavigationPosPosition) {
    }

    public void updateRMLInformation(IManeuverViewElement[] iManeuverViewElementArray) {
        this.traceState("updateRMLInformation()");
        if (iManeuverViewElementArray != null) {
            this.notifierModel.updateListManeuverView(this.createTileElementList(iManeuverViewElementArray));
        }
    }

    IManeuverViewElement[] createTileElementList(IManeuverViewElement[] iManeuverViewElementArray) {
        this.traceState("createTileElementList()");
        IManeuverViewElement[] iManeuverViewElementArray2 = new IManeuverViewElement[]{};
        if (iManeuverViewElementArray == null || iManeuverViewElementArray.length == 0) {
            return iManeuverViewElementArray2;
        }
        ArrayList arrayList = this.removePois(iManeuverViewElementArray);
        if (arrayList.size() >= 2) {
            iManeuverViewElementArray2 = new IManeuverViewElement[]{(IManeuverViewElement)arrayList.get(1), (IManeuverViewElement)arrayList.get(0)};
            if (!this.isManeuverInList(iManeuverViewElementArray2)) {
                this.traceState("No maneuver in list");
                IManeuverViewElement iManeuverViewElement = this.getFirstManeuverElement(iManeuverViewElementArray);
                if (iManeuverViewElement != null) {
                    this.traceState("Maneuver added");
                    iManeuverViewElementArray2[0] = iManeuverViewElement;
                }
            }
        } else if (arrayList.size() >= 1) {
            iManeuverViewElementArray2 = new IManeuverViewElement[]{(IManeuverViewElement)arrayList.get(0)};
        }
        return iManeuverViewElementArray2;
    }

    private ArrayList removePois(IManeuverViewElement[] iManeuverViewElementArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < iManeuverViewElementArray.length; ++i2) {
            if (iManeuverViewElementArray[i2].getType() == 1) continue;
            arrayList.add(iManeuverViewElementArray[i2]);
        }
        return arrayList;
    }

    boolean isManeuverInList(IManeuverViewElement[] iManeuverViewElementArray) {
        boolean bl = false;
        if (iManeuverViewElementArray != null) {
            for (int i2 = 0; i2 < iManeuverViewElementArray.length; ++i2) {
                if (iManeuverViewElementArray[i2].getType() != 0) continue;
                bl = true;
                break;
            }
        }
        return bl;
    }

    private IManeuverViewElement getFirstManeuverElement(IManeuverViewElement[] iManeuverViewElementArray) {
        IManeuverViewElement iManeuverViewElement = null;
        for (int i2 = 0; i2 < iManeuverViewElementArray.length; ++i2) {
            if (iManeuverViewElementArray[i2].getType() != 0) continue;
            iManeuverViewElement = iManeuverViewElementArray[i2];
            break;
        }
        return iManeuverViewElement;
    }

    @Override
    public void update(Observable observable, Object object) {
        this.trace("Navigation state fully operable received");
        try {
            this.handleNavServiceReady();
        }
        catch (NavigationServiceException navigationServiceException) {
            this.traceState(navigationServiceException.getMessage());
        }
    }
}

