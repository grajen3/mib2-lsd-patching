/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.simplegridmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import generated.de.vw.mib.appadapter.simplegridmenu.GeneralModelApiService;
import generated.de.vw.mib.appadapter.simplegridmenu.GesturesModelApiService;

public class GesturesModelApiServiceImpl
implements GesturesModelApiService,
GeneralModelApiService {
    private final AppAdapterSystemServices systemServices;

    public GesturesModelApiServiceImpl(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    @Override
    public void _mda_showSpaceGestureAvailableAnimation() {
        this.showSpaceGestureAvailableAnimation("On");
    }

    @Override
    public void _mda_showSpaceGestureRegisteredAnimation(int n, boolean bl) {
        this.showSpaceGestureRegisteredAnimation(n, bl);
    }

    @Override
    public void _mda_leaveView() {
        this.showSpaceGestureAvailableAnimation("Off");
    }

    private void showSpaceGestureAvailableAnimation(String string) {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowSpaceGestureIndication", string);
        this.systemServices.getCioDispatcher().dispatch(cioIntent);
    }

    private void showSpaceGestureRegisteredAnimation(int n, boolean bl) {
        String string = this.transformDirectionEnumToUsageName(n);
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowSpaceGestureRecognitionFeedback", string);
        CioActionParameters cioActionParameters = this.createCioActionParameters(cioIntent, bl);
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }

    private CioActionParameters createCioActionParameters(CioIntent cioIntent, boolean bl) {
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setBoolean("Success", bl);
        return cioParametersCreator.finishActionParams();
    }

    private String transformDirectionEnumToUsageName(int n) {
        switch (n) {
            case 1: {
                return "RightToLeft";
            }
        }
        return "LeftToRight";
    }
}

