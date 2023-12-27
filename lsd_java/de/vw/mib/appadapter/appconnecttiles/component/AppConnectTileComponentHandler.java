/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.appconnecttiles.component;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.appadapter.appconnecttiles.component.AppConnectTileApiListener;
import de.vw.mib.appadapter.appconnecttiles.component.AppConnectTileBigCioHandler;
import de.vw.mib.appadapter.appconnecttiles.component.AppConnectTileSmallCioHandler;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import generated.de.vw.mib.appadapter.appconnecttiles.AppConnectModelApiCallback;

public class AppConnectTileComponentHandler
implements CioExecutor {
    private AppAdapterSystemServices systemServices;
    private int instanceId;
    private int instanceRole;
    private final IntObjectMap tileHeaderVisualizationsCios = new IntObjectOptHashMap();
    private ContentInformationObject currentHeaderCio = null;
    private AppConnectTileSmallCioHandler smallCioHandler;
    private AppConnectTileBigCioHandler bigCioHandler;
    private AppConnectModelApiCallback modelApiClient;
    private AppConnectTileApiListener tileListener;
    private int visualizationType;
    private final int VISUALIZATION_NATIVE;
    private final int VISUALIZATION_ANDROIDAUTO;
    private final int VISUALIZATION_CARPLAY;
    private final int VISUALIZATION_MIRRORLINK;
    private final int VISUALIZATION_CARLIFE;

    public AppConnectTileComponentHandler(AppAdapterSystemServices appAdapterSystemServices, AppConnectModelApiCallback appConnectModelApiCallback) {
        this.VISUALIZATION_NATIVE = 0;
        this.VISUALIZATION_ANDROIDAUTO = 1;
        this.VISUALIZATION_CARPLAY = 2;
        this.VISUALIZATION_MIRRORLINK = 3;
        this.VISUALIZATION_CARLIFE = 4;
        this.systemServices = appAdapterSystemServices;
        this.modelApiClient = appConnectModelApiCallback;
        this.visualizationType = 0;
    }

    public void setInstanceID(int n) {
        this.instanceId = n;
        if (this.smallCioHandler == null && this.bigCioHandler == null) {
            this.createCioHandler();
        }
    }

    public int getInstanceID() {
        return this.instanceId;
    }

    public void updateHeadervisualization(int n) {
        this.visualizationType = n;
        this.registerNativeTileHeaderVisualization();
    }

    public AppConnectTileApiListener getAslApiListener() {
        if (this.tileListener == null) {
            this.tileListener = new AppConnectTileApiListener(this.modelApiClient, this.systemServices, this);
        }
        return this.tileListener;
    }

    private void createCioHandler() {
        if (this.instanceId == 0 || this.instanceId == 2) {
            this.smallCioHandler = new AppConnectTileSmallCioHandler(this.systemServices, this.instanceId);
        }
        if (this.instanceId == 1 || this.instanceId == 3) {
            this.bigCioHandler = new AppConnectTileBigCioHandler(this.systemServices, this.instanceId);
        }
    }

    private void registerNativeTileHeaderVisualization() {
        if (this.currentHeaderCio != null) {
            this.currentHeaderCio.unregister();
        }
        this.currentHeaderCio = (ContentInformationObject)this.tileHeaderVisualizationsCios.get(this.visualizationType);
        if (this.currentHeaderCio != null) {
            this.currentHeaderCio.register();
        }
    }

    public void start() {
        this.getAslApiListener().registerApi();
        this.systemServices.createLogger(128).info(128).append("AppConnect Adapter Instance ID (Ready): ").append(this.instanceId).log();
        switch (this.instanceId) {
            case 0: {
                this.instanceRole = 0;
                this.registerNativeTileHeaderVisualization();
                this.tileListener.updateInstanceRole(this.instanceRole);
                break;
            }
            case 2: {
                this.smallCioHandler.updateRegisterEntertainmentTile(this.tileHeaderVisualizationsCios);
                this.instanceRole = 2;
                this.tileListener.updateInstanceRole(this.instanceRole);
                break;
            }
            case 1: {
                this.instanceRole = 1;
                this.registerNativeTileHeaderVisualization();
                this.tileListener.updateInstanceRole(this.instanceRole);
                break;
            }
            case 3: {
                this.bigCioHandler.updateRegisterEntertainmentTile(this.tileHeaderVisualizationsCios);
                this.instanceRole = 3;
                this.tileListener.updateInstanceRole(this.instanceRole);
                break;
            }
        }
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        int n = contentInformationObject.getActionId();
        switch (n) {
            case 2: {
                this.tileListener.showSmartPhoneIntegrationContext();
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        String string = contentInformationObject.getCioIntentName();
        this.systemServices.createLogger(128).info(128).append("AppConnectTileComponentHandler onRegistration cio: ").append(contentInformationObject.getCioIntentName()).log();
        if (string.equals("AppConnectTileHeaderButtonAction")) {
            this.tileHeaderVisualizationsCios.put(0, contentInformationObject);
            return true;
        }
        if (string.equals("CarPlayTileHeaderButtonAction")) {
            this.tileHeaderVisualizationsCios.put(2, contentInformationObject);
            return true;
        }
        if (string.equals("AndroidAutoTileHeaderButtonAction")) {
            this.tileHeaderVisualizationsCios.put(1, contentInformationObject);
            return true;
        }
        if (string.equals("MirrorlinkTileHeaderButtonAction")) {
            this.tileHeaderVisualizationsCios.put(3, contentInformationObject);
            return true;
        }
        if (string.equals("CarLifeTileHeaderButtonAction")) {
            this.tileHeaderVisualizationsCios.put(4, contentInformationObject);
            return true;
        }
        switch (this.instanceId) {
            case 0: {
                return this.smallCioHandler.handleCioIntentRegistration(contentInformationObject);
            }
            case 1: {
                return this.bigCioHandler.handleCioIntentRegistration(contentInformationObject);
            }
            case 2: {
                return this.smallCioHandler.handleCioIntentRegistration(contentInformationObject);
            }
            case 3: {
                return this.bigCioHandler.handleCioIntentRegistration(contentInformationObject);
            }
        }
        return true;
    }
}

