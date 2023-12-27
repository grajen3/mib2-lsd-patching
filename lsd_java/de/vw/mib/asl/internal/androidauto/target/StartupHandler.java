/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAPI;
import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.androidauto.transformer.AndroidAutoCanvasDimensionCollector;
import org.dsi.ifc.androidauto2.BluetoothServiceAnnouncement;
import org.dsi.ifc.androidauto2.ServiceConfiguration;

class StartupHandler {
    private AndroidAutoTarget target;
    private boolean isDeviceConnected;
    private boolean isDSI2Registered;
    ASLSmartphoneIntegrationAPI smartphoneintegrationAPI;
    int screenWidthResolution = ServiceManager.configManagerDiag.getLayoutAndroidAutoCanvasDimensionWidth();
    int screenHeightResolution = ServiceManager.configManagerDiag.getLayoutAndroidAutoCanvasDimensionHeight();
    int screenWidthDimension = 0;
    int screenHeightDimension = 0;

    public StartupHandler(AndroidAutoTarget androidAutoTarget) {
        this.target = androidAutoTarget;
        this.isDeviceConnected = false;
        this.isDSI2Registered = false;
        this.smartphoneintegrationAPI = ASLSmartphoneIntegrationFactory.getSmartphoneIntegrationApi();
    }

    public boolean isDeviceConnected() {
        return this.isDeviceConnected;
    }

    public void setDeviceConnected(boolean bl) {
        this.isDeviceConnected = bl;
    }

    public boolean isDSI2Registered() {
        return this.isDSI2Registered;
    }

    public void setDSI2Registered(boolean bl) {
        this.isDSI2Registered = bl;
    }

    public void startAndroidAutoService2() {
        if (this.isDeviceConnected && this.isDSI2Registered) {
            if (this.target.isTraceEnabled()) {
                this.target.trace("[DSI2] Target AndroidAuto ==> Starting Service...");
            }
            int n = 0;
            if (ServiceManager.configManagerDiag.getDriverSide() == 2) {
                n = 1;
            }
            if (this.smartphoneintegrationAPI != null) {
                this.screenWidthDimension = (int)(this.smartphoneintegrationAPI.getPixelDimensionWidth() * (double)this.screenWidthResolution);
                this.screenHeightDimension = (int)(this.smartphoneintegrationAPI.getPixelDimensionHeight() * (double)this.screenHeightResolution);
                if (this.target.isTraceEnabled()) {
                    this.target.trace(new StringBuffer().append("StartupHandler::startAndroidAutoService2( width->").append(this.screenWidthDimension).append("=").append(this.smartphoneintegrationAPI.getPixelDimensionWidth()).append("*").append(this.screenWidthResolution).toString());
                    this.target.trace(new StringBuffer().append("StartupHandler::startAndroidAutoService2( height->").append(this.screenHeightDimension).append("=").append(this.smartphoneintegrationAPI.getPixelDimensionHeight()).append("*").append(this.screenHeightResolution).toString());
                }
            } else if (this.target.isTraceEnabled()) {
                this.target.trace("StartupHandler::startAndroidAutoService2(smartphoneintegrationAPI == null)");
            }
            Object[] objectArray = new AndroidAutoCanvasDimensionCollector[]{new AndroidAutoCanvasDimensionCollector()};
            objectArray[0].androidauto_height = this.screenHeightResolution;
            objectArray[0].androidauto_width = this.screenWidthResolution;
            ListManager.getGenericASLList(879176704).updateList(objectArray);
            boolean bl = false;
            boolean bl2 = true;
            boolean bl3 = ASLSystemFactory.getSystemApi().getAbtFeatureService().getRotaryEncoderType() == 2;
            boolean bl4 = false;
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("getAbtFeatureService().getRotaryEncoderType(): ").append(ASLSystemFactory.getSystemApi().getAbtFeatureService().getRotaryEncoderType()).log();
            }
            ServiceConfiguration serviceConfiguration = new ServiceConfiguration(this.screenWidthResolution, this.screenHeightResolution, n, bl, 0, 0, bl2, this.screenWidthResolution, this.screenHeightResolution, this.screenHeightDimension, this.screenWidthDimension, bl3, bl4, new BluetoothServiceAnnouncement());
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("config= screenWidthResolution: ").append(this.screenWidthResolution).append(" screenHeightResolution: ").append(this.screenHeightResolution).append(" driverPosition: ").append(n).append(" touchpadAvailable: ").append(bl).append("touchpadResolutionXY: 0,0").append(" touchscreenAvailable: ").append(bl2).append(" screenWidthResolution: ").append(this.screenWidthResolution).append(" screenHeightResolution: ").append(this.screenHeightResolution).append(" screenHeightDimension: ").append(this.screenHeightDimension).append(" screenWidthDimension: ").append(this.screenWidthDimension).append("").append(" rotaryEncoderAvailable: ").append(bl3).append(" externalBluetoothPairing:").append(bl4).append(" new BluetoothServiceAnnouncement()").log();
            }
            this.target.getDSIAndroidAuto2().startService(serviceConfiguration);
        } else if (this.target.isTraceEnabled()) {
            this.target.trace("[DSI2] Target AndroidAuto ==> Starting Service not possible right now...");
        }
    }
}

