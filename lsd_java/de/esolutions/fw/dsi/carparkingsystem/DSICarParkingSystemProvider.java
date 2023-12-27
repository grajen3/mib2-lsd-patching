/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carparkingsystem;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carparkingsystem.DSICarParkingSystemReply;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystem;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.osgi.framework.BundleContext;

public class DSICarParkingSystemProvider
extends AbstractProvider
implements DSICarParkingSystem {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 71, 72, 73, 74, 75, 76, 77, 78, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 44, 66, 67, 68, 69, 70, 79, 80, 45, 46, 47, 48, 26, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 102};
    private DSICarParkingSystemProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem;

    public DSICarParkingSystemProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem = DSICarParkingSystemProvider.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystem")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarParkingSystemProxy(this.instance, (DSICarParkingSystemReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setHMIStateIsReady(boolean bl) {
        try {
            this.proxy.setHMIStateIsReady(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCDefaultParkingMode(int n) {
        try {
            this.proxy.setPDCDefaultParkingMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCMute(boolean bl) {
        try {
            this.proxy.setPDCMute(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCFrequenceFront(int n) {
        try {
            this.proxy.setPDCFrequenceFront(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCFrequenceRear(int n) {
        try {
            this.proxy.setPDCFrequenceRear(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCVolumeFront(int n) {
        try {
            this.proxy.setPDCVolumeFront(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCVolumeRear(int n) {
        try {
            this.proxy.setPDCVolumeRear(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCAutoActivation(boolean bl) {
        try {
            this.proxy.setPDCAutoActivation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCSystemOnOff(boolean bl) {
        try {
            this.proxy.setPDCSystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCFrequenceRight(int n) {
        try {
            this.proxy.setPDCFrequenceRight(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCFrequenceLeft(int n) {
        try {
            this.proxy.setPDCFrequenceLeft(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCVolumeRight(int n) {
        try {
            this.proxy.setPDCVolumeRight(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCVolumeLeft(int n) {
        try {
            this.proxy.setPDCVolumeLeft(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCFlankGuard(boolean bl) {
        try {
            this.proxy.setPDCFlankGuard(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction) {
        try {
            this.proxy.setPDCSoundReproduction(pDCSoundReproduction);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCSoundFront(PDCSound pDCSound) {
        try {
            this.proxy.setPDCSoundFront(pDCSound);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCSoundRear(PDCSound pDCSound) {
        try {
            this.proxy.setPDCSoundRear(pDCSound);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCSoundLeft(PDCSound pDCSound) {
        try {
            this.proxy.setPDCSoundLeft(pDCSound);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCSoundRight(PDCSound pDCSound) {
        try {
            this.proxy.setPDCSoundRight(pDCSound);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCPLAPreSelection(int n) {
        try {
            this.proxy.setPDCPLAPreSelection(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCPLAParkMode(int n) {
        try {
            this.proxy.setPDCPLAParkMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCPLASystemState(PDCPLASystemState pDCPLASystemState) {
        try {
            this.proxy.setPDCPLASystemState(pDCPLASystemState);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCOffroadMode(boolean bl) {
        try {
            this.proxy.setPDCOffroadMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCVisualisationParkbox(boolean bl) {
        try {
            this.proxy.setPDCVisualisationParkbox(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCOPSVisualisationPosition(int n) {
        try {
            this.proxy.setPDCOPSVisualisationPosition(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSFollowUpTime(int n) {
        try {
            this.proxy.setVPSFollowUpTime(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSColor(int n) {
        try {
            this.proxy.setVPSColor(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSContrast(int n) {
        try {
            this.proxy.setVPSContrast(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSBrightness(int n) {
        try {
            this.proxy.setVPSBrightness(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSDefaultModeRV(VPSDefaultMode vPSDefaultMode) {
        try {
            this.proxy.setVPSDefaultModeRV(vPSDefaultMode);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSDefaultModeFV(VPSDefaultMode vPSDefaultMode) {
        try {
            this.proxy.setVPSDefaultModeFV(vPSDefaultMode);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSDefaultModeSV(VPSDefaultMode vPSDefaultMode) {
        try {
            this.proxy.setVPSDefaultModeSV(vPSDefaultMode);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSDefaultModeBV(VPSDefaultMode vPSDefaultMode) {
        try {
            this.proxy.setVPSDefaultModeBV(vPSDefaultMode);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSDefaultView(int n) {
        try {
            this.proxy.setVPSDefaultView(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSOPSOverlay(VPSOPSOverlay vPSOPSOverlay) {
        try {
            this.proxy.setVPSOPSOverlay(vPSOPSOverlay);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSDynamicParkingMode(VPSDynParkingMode vPSDynParkingMode) {
        try {
            this.proxy.setVPSDynamicParkingMode(vPSDynParkingMode);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSSystemOnOff(boolean bl) {
        try {
            this.proxy.setVPSSystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSExtCamConfig(int n) {
        try {
            this.proxy.setVPSExtCamConfig(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSExtCamManActivation(boolean bl) {
        try {
            this.proxy.setVPSExtCamManActivation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPS3DBirdview(int n, int n2) {
        try {
            this.proxy.setVPS3DBirdview(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSSystemState(boolean bl) {
        try {
            this.proxy.setVPSSystemState(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showParkingPopup(DisplayContent displayContent) {
        try {
            this.proxy.showParkingPopup(displayContent);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelParkingPopup(DisplayContent displayContent, int n) {
        try {
            this.proxy.cancelParkingPopup(displayContent, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestLifeMonitoring(boolean bl) {
        try {
            this.proxy.requestLifeMonitoring(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPdcSetFactoryDefault() {
        try {
            this.proxy.setPdcSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVpsSetFactoryDefault() {
        try {
            this.proxy.setVpsSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setARATargetTrailerAngle(int n) {
        try {
            this.proxy.setARATargetTrailerAngle(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCManeuverAssistConfig(int n) {
        try {
            this.proxy.setPDCManeuverAssistConfig(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCManeuverAssist(boolean bl) {
        try {
            this.proxy.setPDCManeuverAssist(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCContinueDrivingAssist(int n) {
        try {
            this.proxy.setPDCContinueDrivingAssist(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCIpaConfig(int n) {
        try {
            this.proxy.setPDCIpaConfig(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPDCPiloPaSystemState(PDCPiloPaSystemState pDCPiloPaSystemState) {
        try {
            this.proxy.setPDCPiloPaSystemState(pDCPiloPaSystemState);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning) {
        try {
            this.proxy.setVPSCameraCleaning(vPSCameraCleaning);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWCAutoActivation(boolean bl) {
        try {
            this.proxy.setWCAutoActivation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWCSystemOnOff(boolean bl) {
        try {
            this.proxy.setWCSystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWCSetFactoryDefault() {
        try {
            this.proxy.setWCSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showWCPopup(int n) {
        try {
            this.proxy.showWCPopup(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelWCPopup(int n, int n2) {
        try {
            this.proxy.cancelWCPopup(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestWCPanelList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        try {
            this.proxy.requestWCPanelList(carArrayListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enterWCPinPuk(String string, String string2) {
        try {
            this.proxy.enterWCPinPuk(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortWCEnterPinPuk() {
        try {
            this.proxy.abortWCEnterPinPuk();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startWCScanning() {
        try {
            this.proxy.startWCScanning();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortWCScanning() {
        try {
            this.proxy.abortWCScanning();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startWCPairing(String string, String string2) {
        try {
            this.proxy.startWCPairing(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortWCPairing() {
        try {
            this.proxy.abortWCPairing();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startWCSoftwareUpdate(String string) {
        try {
            this.proxy.startWCSoftwareUpdate(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortWCSoftwareUpdate() {
        try {
            this.proxy.abortWCSoftwareUpdate();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void changeWCPin(String string, String string2) {
        try {
            this.proxy.changeWCPin(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortWCChangePin() {
        try {
            this.proxy.abortWCChangePin();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void changeWCPanelName(String string, String string2) {
        try {
            this.proxy.changeWCPanelName(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortWCChangePanelName() {
        try {
            this.proxy.abortWCChangePanelName();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
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

