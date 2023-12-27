/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.car;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import generated.de.vw.mib.appadapter.car.GesturesModelApiService;

public class GestureService
implements GesturesModelApiService {
    private AppAdapterSystemServices systemServices;

    public GestureService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    public void start() {
    }

    private void showSpaceGestureAvailableAnimation(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "Off";
                break;
            }
            default: {
                string = "On";
            }
        }
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowSpaceGestureIndication", string);
        String string2 = "";
        if (cioIntent == null) {
            string2 = "No Intentclass found with usage ";
            this.systemServices.createLogger(128).warn(128).append("Send space gesture available cio: ").append(string2).append(string).log();
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
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setBoolean("Success", bl);
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }

    @Override
    public void _mda_showSpaceGestureAvailableAnimation(int n) {
        this.showSpaceGestureAvailableAnimation(n);
    }

    @Override
    public void _mda_showSpaceGestureRegisteredAnimation(int n, boolean bl) {
        this.showSpaceGestureRegisteredAnimation(n, bl);
    }
}

