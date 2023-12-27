/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tvtuner;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.tvtuner.SpaceGesturesModelApiService;

public class TVTunerSpaceGesturesModelApiService
implements SpaceGesturesModelApiService {
    private final AppAdapterSystemServices systemServices;
    private final Logger logger;

    public TVTunerSpaceGesturesModelApiService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
        this.logger = appAdapterSystemServices.createLogger(128);
    }

    @Override
    public void _mda_showSpaceGestureAvailableAnimation(boolean bl) {
        this.showSpaceGestureAvailableAnimation(bl);
    }

    @Override
    public void _mda_showSpaceGestureRegisteredAnimation(int n, boolean bl) {
        this.showSpaceGestureRegisteredAnimation(n, bl);
    }

    private void showSpaceGestureAvailableAnimation(boolean bl) {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowSpaceGestureIndication", bl ? "On" : "Off");
        if (cioIntent == null) {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append("Could not dispatch CIO ShowSpaceGestureIndication. CIO is null.").log();
            }
            return;
        }
        this.systemServices.getCioDispatcher().dispatch(cioIntent);
    }

    private void showSpaceGestureRegisteredAnimation(int n, boolean bl) {
        String string;
        switch (n) {
            case 1: {
                string = "RightToLeft";
                break;
            }
            default: {
                string = "LeftToRight";
            }
        }
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowSpaceGestureRecognitionFeedback", string);
        if (cioIntent == null) {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append("Could not dispatch CIO ShowSpaceGestureRecognitionFeedback. CIO is null.").log();
            }
            return;
        }
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setBoolean("Success", bl);
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }
}

