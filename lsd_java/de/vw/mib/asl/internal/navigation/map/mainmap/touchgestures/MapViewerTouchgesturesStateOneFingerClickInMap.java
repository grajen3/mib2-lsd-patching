/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayHsmState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;

public class MapViewerTouchgesturesStateOneFingerClickInMap
extends AbstractNavGatewayHsmState {
    private int[] eInfoTypePriorities = new int[]{4, 2, 1, 3, 8};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerTouchgesturesStateOneFingerClickInMap]");
    private final MapViewerTouchgesturesTargetHSM target;
    private String infoTxt;

    public MapViewerTouchgesturesStateOneFingerClickInMap(MapViewerTouchgesturesTargetHSM mapViewerTouchgesturesTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerTouchgesturesTargetHSM;
    }

    private PosInfo findPosInfoByPriorityList(PosInfo[] posInfoArray) {
        for (int i2 = 0; i2 < this.eInfoTypePriorities.length; ++i2) {
            int n = this.eInfoTypePriorities[i2];
            PosInfo posInfo = this.findPosInfoWithEInfoType(posInfoArray, n);
            if (posInfo == null) continue;
            return posInfo;
        }
        return null;
    }

    private PosInfo findPosInfoWithEInfoType(PosInfo[] posInfoArray, int n) {
        for (int i2 = 0; i2 < posInfoArray.length; ++i2) {
            PosInfo posInfo = posInfoArray[i2];
            int n2 = posInfo.eInfoType;
            if (n2 != n) continue;
            return posInfo;
        }
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3499022: {
                this.handleGetInfoForScreenPositionResult(eventGeneric);
                break;
            }
            case 3499054: {
                this.handleGetInfoForScreenPositionResultAsyncExcetion(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        this.logger.trace("handleCommandCmdGetLocationDescriptionTransform()");
        if (cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation == null) {
            this.logger.warn("handleCommandCmdGetLocationDescriptionTransform() - the NavLocation ist null, execution stopped");
            this.target.notifierModel.notifyClickInMapBrowserFooterEnabled();
            return;
        }
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation);
        iLocationWrapper.setMmiInternalDataValue(3, this.infoTxt);
        this.infoTxt = "";
        this.target.datapool.setMapInputLocation(iLocationWrapper.getLocation());
        this.target.notifierModel.notifyClickInMapBrowserFooterEnabled();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): rcvrEventId=").append(eventGeneric.getReceiverEventId()).append(", Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleGetInfoForScreenPositionResult(EventGeneric eventGeneric) {
        boolean bl;
        this.logger.trace("handleGetInfoForScreenPositionResult()");
        PosInfo[] posInfoArray = (PosInfo[])eventGeneric.getObject(0);
        if (posInfoArray == null || posInfoArray.length == 0) {
            this.logger.warn("posInfos == null || posInfos.length == 0");
            return;
        }
        PosInfo posInfo = this.findPosInfoByPriorityList(posInfoArray);
        if (posInfo == null) {
            this.logger.trace("no used eInfoType found in posInfoList");
            this.target.notifierModel.notifyClickedStatusNothingFound();
            return;
        }
        switch (posInfo.eInfoType) {
            case 4: {
                this.logger.trace("eInfoType = POSITIONINFOTYPE_TMC_MESSAGE");
                bl = this.showTmcMessage(posInfo);
                break;
            }
            case 2: {
                this.logger.trace("eInfoType = POSITIONINFOTYPE_POI_3D");
                bl = this.showPoi(posInfo);
                break;
            }
            case 1: {
                this.logger.trace("eInfoType = POSITIONINFOTYPE_POI");
                bl = this.showPoi(posInfo);
                break;
            }
            case 3: {
                this.logger.trace("eInfoType = POSITIONINFOTYPE_POI_CONTAINER");
                bl = this.showPoiContainer(posInfo);
                break;
            }
            case 8: {
                this.logger.trace("eInfoType = POSITIONINFOTYPE_XT_REPRESENTATION");
                bl = this.showXTRepresentation(posInfo);
                break;
            }
            default: {
                bl = false;
            }
        }
        if (!bl) {
            this.logger.trace("nothing found at the clicked location");
            this.target.notifierModel.notifyClickedStatusNothingFound();
        }
    }

    private void handleGetInfoForScreenPositionResultAsyncExcetion(EventGeneric eventGeneric) {
        this.logger.trace("handleGetInfoForScreenPositionResultAsyncExcetion()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.notifierDSI.getInfoForScreenPosition(this.target, new Point(this.target.datapool.getOneFingerClickX(), this.target.datapool.getOneFingerClickY()));
    }

    private boolean showPoi(PosInfo posInfo) {
        this.logger.trace("showPoi()");
        NavLocation navLocation = posInfo.getTLocation();
        if (navLocation == null) {
            this.logger.warn("posInfoList.tLocation == null, execution stopped");
            return false;
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), 1598755840, 1155609344);
        eventGeneric.setObject(0, navLocation);
        this.target.send(eventGeneric);
        return true;
    }

    private boolean showPoiContainer(PosInfo posInfo) {
        this.logger.trace("showPoiContainer()");
        NavLocation navLocation = posInfo.getTLocation();
        if (navLocation == null) {
            this.logger.warn("posInfoList.tLocation == null, execution stopped");
            return false;
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), 1598755840, 1122054912);
        eventGeneric.setObject(0, navLocation);
        this.target.send(eventGeneric);
        return true;
    }

    private boolean showTmcMessage(PosInfo posInfo) {
        this.logger.trace("showTmcMessage()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), 1883968512, 1138832128);
        eventGeneric.setLong(0, posInfo.getObjectId());
        this.target.send(eventGeneric);
        return true;
    }

    private boolean showXTRepresentation(PosInfo posInfo) {
        Object object;
        this.logger.trace("showXTRepresentation()");
        if (posInfo.url == null) {
            this.logger.trace("No url was set for the XTRepresentation eInfoType - this means no Google POI was found");
            return false;
        }
        this.target.notifierModel.notifyClickInMapBrowserFooterDisabled();
        NavLocation navLocation = posInfo.tLocation;
        if (navLocation != null) {
            object = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            this.infoTxt = posInfo.infoTxt;
            object.setMmiInternalDataValue(3, this.infoTxt);
            this.target.datapool.setMapInputLocation(object.getLocation());
            new CmdGetLocationDescriptionTransform(this, object.getLocation()).execute();
        }
        object = posInfo.getInfoTxt();
        this.target.notifierModel.notifyBrowserSetInfoText((String)object);
        String string = posInfo.getUrl();
        this.target.notifierModel.notifyBrowserSetURL(string);
        this.target.notifierModel.notifyClickenObjectTMCFalse();
        this.target.notifierModel.notifyObjectTypeOnMapXTRepresentation();
        this.target.sendHMIEventNaviClickedIcon();
        return true;
    }
}

