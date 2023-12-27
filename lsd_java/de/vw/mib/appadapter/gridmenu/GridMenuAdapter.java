/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.gridmenu;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.gridmenu.GridMenuAdapter$1;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.ContentInformationObject;

public final class GridMenuAdapter
extends AbstractAppAdapter
implements CioExecutor {
    private static AppAdapterSystemServices SYSTEM_SERVICES;

    public GridMenuAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        SYSTEM_SERVICES = appAdapterSystemServices;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{new GridMenuAdapter$1(this)};
    }

    void showSpaceGestureAvailableAnimation() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowSpaceGestureIndication");
        this.systemServices.getCioDispatcher().dispatch(cioIntent);
    }

    void showSpaceGestureRegisteredAnimation(int n, boolean bl) {
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
    public void init(int n, String string) {
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
    }

    @Override
    public void stop() {
    }
}

