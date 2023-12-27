/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.google.earth;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerGoogleCtrlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.setup.google.earth.GoogleEarthSetupTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class GoogleEarthSetupStateInit
extends AbstractHsmState {
    private static final int[] ASL_OBSERVER = new int[]{-439873472, -423096256, -456650688, -406319040, 1239495424, 593769728, 442774784, 610546944};
    private static final int[] ATTRIBUTES_GOOGLE_EARTH = new int[]{1, 6, 2};
    private static final int[] ASL_SERVICES = new int[]{593769728, 610546944};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GoogleEarthSetupStateInit]");
    private final GoogleEarthSetupTargetHSM target;

    public GoogleEarthSetupStateInit(GoogleEarthSetupTargetHSM googleEarthSetupTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = googleEarthSetupTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 3499018: {
                this.handleGoogleEarthReady();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault() ").append(eventGeneric).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleGoogleEarthReady() {
        this.initDSI();
        this.initModel();
        this.initASL();
        this.target.transStateWork();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.addObserver(174339328);
    }

    private void initASL() {
        this.logger.trace("initASL");
        this.target.registerServices(ASL_SERVICES, false);
        this.target.addObservers(ASL_OBSERVER);
    }

    private void initDSI() {
        this.logger.trace("initDSI");
        this.target.notifierDSI.setDsiMapViewerControlVW(DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, null));
        this.target.notifierDSI.setMapViewerGoogleCtrl(DSIMapViewerGoogleCtrlFactoryVW.createMapViewerGoogleCtrl(this.target, ATTRIBUTES_GOOGLE_EARTH));
    }

    private void initModel() {
        this.logger.trace("initModel");
        this.target.notifierModel.setLayerBusinessInvisible();
        this.target.notifierModel.setLayerPanoramioInvisible();
        this.target.notifierModel.setLayerPlacesInvisible();
        this.target.notifierModel.setLayerWikipediaInvisible();
        int[] nArray = this.target.datapool.getGoogleEarthVisibleLayer();
        if (nArray == null || nArray.length == 0) {
            return;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            if (n == 1) {
                this.target.notifierModel.setLayerBusinessVisible();
                continue;
            }
            if (n == 2) {
                this.target.notifierModel.setLayerPanoramioVisible();
                continue;
            }
            if (n == 0) {
                this.target.notifierModel.setLayerPlacesVisible();
                continue;
            }
            if (n != 3) continue;
            this.target.notifierModel.setLayerWikipediaVisible();
        }
    }
}

