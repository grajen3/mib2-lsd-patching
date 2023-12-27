/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.car;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import generated.de.vw.mib.appadapter.car.ShowActualViewsModelApiCallback;
import generated.de.vw.mib.appadapter.car.ShowActualViewsModelApiService;

public class ShowActualViewsService
implements ShowActualViewsModelApiService,
CioExecutor {
    private final AppAdapterSystemServices systemServices;
    private ShowActualViewsModelApiCallback showActualViewsModelApiCallback;
    private CioIntent backCioAction;
    private static final String PARAM__BACK_BUTTON_ACTION;
    private static final int CIO_ACTION_SHOW_CAR_VIEW;
    private static final String CAR_STATUS_MAIN_VIEW;
    private static final String CAR_STATUS_OIL_VIEW;
    private static final String CAR_STATUS_TIRES_VIEW;
    private static final String CAR_TBT_VIEW;
    private static final String CAR_TBT_VIEW_BLUEPOINTS;
    private static final String CAR_TBT_VIEW_CONSUMPTION;
    private static final String CAR_DRIVING_DATA_VIEW_SINCE_START;
    private static final String CAR_DRIVING_DATA_VIEW_SINCE_LONGTERM;
    private static final String CAR_DRIVING_DATA_VIEW_SINCE_REFUELING;
    private static final String CAR_SETUP_HUD_SETTINGS_VIEW;
    private static final String CAR_SETUP_FPK_SETTINGS_VIEW;
    private static ObjectIntMap VIEW2ID;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$car$ShowActualViewsModelApiCallback;

    public ShowActualViewsService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    private ShowActualViewsModelApiCallback getShowActualViewsModelApiCallback() {
        if (this.showActualViewsModelApiCallback == null) {
            this.showActualViewsModelApiCallback = (ShowActualViewsModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$car$ShowActualViewsModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$car$ShowActualViewsModelApiCallback = ShowActualViewsService.class$("generated.de.vw.mib.appadapter.car.ShowActualViewsModelApiCallback")) : class$generated$de$vw$mib$appadapter$car$ShowActualViewsModelApiCallback);
        }
        return this.showActualViewsModelApiCallback;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 1: {
                this.onShowCarView(cioActionParameters);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public void _mda_reset() {
        this.getShowActualViewsModelApiCallback()._update_getToFullScreen(0);
    }

    @Override
    public void _mda_goBack() {
        if (this.backCioAction != null) {
            this.systemServices.getCioDispatcher().dispatch(this.backCioAction);
            this.backCioAction = null;
        }
    }

    @Override
    public void _mda_showView(int n) {
        this.getShowActualViewsModelApiCallback()._update_getToFullScreen(n);
        if (n != 0) {
            CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_CAR");
            this.systemServices.getCioDispatcher().dispatch(cioIntent);
        }
    }

    private void onShowCarView(CioActionParameters cioActionParameters) {
        Object object;
        if (cioActionParameters != null) {
            this.backCioAction = cioActionParameters.getCioIntent("BackButtonAction");
            object = cioActionParameters.getString("Context");
            int n = this.getViewId((String)object);
            this.getShowActualViewsModelApiCallback()._update_getToFullScreen(n);
        }
        object = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_CAR");
        this.systemServices.getCioDispatcher().dispatch((CioIntent)object);
    }

    private int getViewId(String string) {
        if (!VIEW2ID.containsKey(string)) {
            return 0;
        }
        return VIEW2ID.get(string);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        VIEW2ID = new ObjectIntOptHashMap();
        VIEW2ID.put("CarStatusMainView", 1);
        VIEW2ID.put("CarStatusOilView", 3);
        VIEW2ID.put("CarStatusTiresView", 2);
        VIEW2ID.put("CarTbtView", 7);
        VIEW2ID.put("CarTbtViewBluePoints", 8);
        VIEW2ID.put("CarTbtViewConsumption", 9);
        VIEW2ID.put("CarDrivingDataSinceStart", 4);
        VIEW2ID.put("CarDrivingDataSinceRefueling", 6);
        VIEW2ID.put("CarDrivingDataSinceLongterm", 5);
        VIEW2ID.put("CarSetupHUDSettingsView", 10);
        VIEW2ID.put("CarSetupFPKSettingsView", 11);
    }
}

