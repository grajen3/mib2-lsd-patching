/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.ppoi;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.ASLNavigationDP;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayHsmState;
import de.vw.mib.asl.internal.navigation.gateway.NavGateway;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiSelectSelectionCriteria;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.util.PPoiDatapool;
import de.vw.mib.asl.internal.navigation.util.LocationHelper;
import de.vw.mib.asl.internal.navigation.util.LocationWrapper;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.Route;

public abstract class PPoiAbstractHsmState
extends AbstractNavGatewayHsmState {
    protected PPoiHsmTarget pPoiTarget;

    public PPoiAbstractHsmState(PPoiHsmTarget pPoiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.pPoiTarget = pPoiHsmTarget;
    }

    protected static int calculateDistance(LIValueListElement lIValueListElement) {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistance(lIValueListElement.getLongitude(), lIValueListElement.getLatitude(), PPoiDatapool.getInstance().getReferenceLocation().getLongitude(), PPoiDatapool.getInstance().getReferenceLocation().getLatitude());
    }

    protected void setPoiContextToDsi() {
        Route route = ASLNavigationDP.getInstance().getCurrentRoute();
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive() && route != null) {
            NavLocation navLocation = route.routelist[route.routelist.length - 1].getRouteLocation();
            this.pPoiTarget.getDsiNavigation().poiSetContext(new LocationWrapper(navLocation.getLatitude(), navLocation.getLongitude()).getLocation());
            this.setAroundDestinationAsReference(route);
        } else {
            this.pPoiTarget.getDsiNavigation().poiSetContext(new LocationWrapper(NavGateway.getInstance().getSoPosPosition()).getLocation());
            this.setCcpAsReference();
        }
    }

    private void setCcpAsReference() {
        PPoiDatapool.getInstance().setReferenceDirection(ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition().getDirectionAngle());
        this.pPoiTarget.myTrace(this, "setCcpAsReference");
        PPoiDatapool.getInstance().setReferenceLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition()));
    }

    private void setAroundDestinationAsReference(Route route) {
        PPoiDatapool.getInstance().setReferenceLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(LocationHelper.cloneLocation(route.routelist[route.routelist.length - 1].getRouteLocation())));
    }

    protected boolean isliValuelistEmpty(LIValueList lIValueList, boolean bl) {
        if (lIValueList != null && lIValueList.list != null) {
            if (this.pPoiTarget.getTextLogger().isTraceEnabled(this.pPoiTarget.getSubClassifier())) {
                this.pPoiTarget.makeTrace(this).append("Length of LIValueList:").append(lIValueList.list.length).log();
            }
            if (lIValueList.list.length > 0) {
                return true;
            }
            this.pPoiTarget.myError(this, "LIValueList.list.length == 0!");
            NaviHelper.getInstance().resetNaviContext("LIValueList.list.length == 0!");
        } else {
            this.pPoiTarget.myError(this, "LIValueList == null");
            NaviHelper.getInstance().resetNaviContext("LIValueList == null");
        }
        return false;
    }

    protected void handlePOIVALUELIST(LIValueList lIValueList, int n) {
        this.pPoiTarget.myTrace(this, "LIValueList list updated with PPOI options.");
        int n2 = -1;
        boolean bl = false;
        if (lIValueList != null && lIValueList.list != null) {
            this.pPoiTarget.myTrace(this, new StringBuffer().append("Length of LIValueList: ").append(lIValueList.list.length).toString());
            for (n2 = 0; n2 < lIValueList.list.length; ++n2) {
                if (lIValueList.list[n2] != null) {
                    if (lIValueList.list[n2].criteriaNumber != n) continue;
                    bl = true;
                    break;
                }
                this.pPoiTarget.makeError(this).append("LIValueList.list[").append(n2).append("] = null!").log();
            }
        }
        if (bl) {
            new CmdPoiSelectSelectionCriteria(this, n2).execute();
        } else {
            this.pPoiTarget.myTrace(this, new StringBuffer().append("Selection criterion ").append(n).append(" not available!").toString());
        }
    }
}

