/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.appconnecttiles.component;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.appconnecttiles.component.AppConnectTileApiListener$1;
import de.vw.mib.appadapter.appconnecttiles.component.AppConnectTileComponentHandler;
import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAPI;
import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAppConnectAppAdapter;
import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationFactory;
import de.vw.mib.cio.CioIntent;
import generated.de.vw.mib.appadapter.appconnecttiles.AppConnectModelApiCallback;
import generated.de.vw.mib.appadapter.appconnecttiles.AppConnectModelApiService;

public class AppConnectTileApiListener
implements AppConnectModelApiService {
    private AppConnectModelApiCallback modelApiClient;
    private AppAdapterSystemServices systemServices;
    private ASLSmartphoneIntegrationAppConnectAppAdapter aslAppAdapter;
    private ASLSmartphoneIntegrationAPI aslApi = ASLSmartphoneIntegrationFactory.getSmartphoneIntegrationApi();
    private AppConnectTileComponentHandler componentHandler;

    public AppConnectTileApiListener(AppConnectModelApiCallback appConnectModelApiCallback, AppAdapterSystemServices appAdapterSystemServices, AppConnectTileComponentHandler appConnectTileComponentHandler) {
        this.modelApiClient = appConnectModelApiCallback;
        this.systemServices = appAdapterSystemServices;
        this.componentHandler = appConnectTileComponentHandler;
    }

    public void updateCurrentDeviceName(String string) {
        this.modelApiClient._update_getCurrentActiveDeviceName(string);
    }

    public void updateCurrentConnectionMethod(int n) {
        int n2;
        switch (n) {
            case 8: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 2;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 32: {
                n2 = 4;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        this.modelApiClient._update_getCurrentActiveConnectionMethod(n2);
    }

    public void updateInstanceRole(int n) {
        this.modelApiClient._update_getAppInstanceRole(n);
    }

    public void updateSwapState() {
        this.modelApiClient._update_isSwapUpdated(true);
    }

    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{this};
    }

    public void showSmartPhoneIntegrationContext() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_SMARTPHONEINTEGRATION");
        this.systemServices.getCioDispatcher().dispatch(cioIntent);
    }

    @Override
    public void _mda_openFullscreen() {
        this.showSmartPhoneIntegrationContext();
    }

    public void registerApi() {
        this.aslAppAdapter = new AppConnectTileApiListener$1(this);
        this.aslApi.registerAppConnectAppAdapter(this.aslAppAdapter);
    }

    @Override
    public void _mda_setHeaderVisualization(int n) {
        this.componentHandler.updateHeadervisualization(n);
    }

    static /* synthetic */ AppConnectTileComponentHandler access$000(AppConnectTileApiListener appConnectTileApiListener) {
        return appConnectTileApiListener.componentHandler;
    }

    static /* synthetic */ AppAdapterSystemServices access$100(AppConnectTileApiListener appConnectTileApiListener) {
        return appConnectTileApiListener.systemServices;
    }
}

