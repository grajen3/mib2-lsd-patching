/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.appconnecttiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.appconnecttiles.component.AppConnectTileComponentHandler;
import de.vw.mib.cio.CioExecutor;
import generated.de.vw.mib.appadapter.appconnecttiles.AppConnectModelApiCallback;

public class AppConnectTileSAdapter
extends AbstractAppAdapter {
    public static final int TILE_HEADER_BUTTON_ACTION;
    public static final int INSTANCE_TILE_S_NATIVE;
    public static final int INSTANCE_TILE_L_NATIVE;
    public static final int INSTANCE_TILE_S_MEDIA;
    public static final int INSTANCE_TILE_L_MEDIA;
    private AppConnectModelApiCallback modelApiClient;
    private int instanceId;
    private String instanceName;
    private AppConnectTileComponentHandler appConnectComponentHandler;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$appconnecttiles$AppConnectModelApiCallback;

    public AppConnectTileSAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        this.modelApiClient = (AppConnectModelApiCallback)appAdapterSystemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$appconnecttiles$AppConnectModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$appconnecttiles$AppConnectModelApiCallback = AppConnectTileSAdapter.class$("generated.de.vw.mib.appadapter.appconnecttiles.AppConnectModelApiCallback")) : class$generated$de$vw$mib$appadapter$appconnecttiles$AppConnectModelApiCallback);
        this.appConnectComponentHandler = new AppConnectTileComponentHandler(appAdapterSystemServices, this.modelApiClient);
    }

    public AppConnectTileComponentHandler getAppConnectComponentHandler() {
        if (this.appConnectComponentHandler == null) {
            this.appConnectComponentHandler = new AppConnectTileComponentHandler(this.systemServices, this.modelApiClient);
        }
        return this.appConnectComponentHandler;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this.getAppConnectComponentHandler();
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        ModelApiService[] modelApiServiceArray = new ModelApiService[]{this.getAppConnectComponentHandler().getAslApiListener()};
        return modelApiServiceArray;
    }

    @Override
    public void init(int n, String string) {
        this.instanceId = n;
        this.instanceName = string;
        this.getAppConnectComponentHandler().setInstanceID(this.instanceId);
        this.systemServices.createLogger(128).info(128).append("AppConnect Adapter Instance ID: ").append(this.instanceId).log();
        this.systemServices.createLogger(128).info(128).append("AppConnect Adapter Instace Name: ").append(this.instanceName).log();
    }

    @Override
    public void ready() {
        this.appConnectComponentHandler.start();
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

