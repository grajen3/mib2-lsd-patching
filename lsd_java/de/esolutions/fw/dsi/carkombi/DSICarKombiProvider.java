/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carkombi;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carkombi.DSICarKombiReply;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsReset;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.osgi.framework.BundleContext;

public class DSICarKombiProvider
extends AbstractProvider
implements DSICarKombi {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 103, 104, 105, 106, 107, 108, 109, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102};
    private DSICarKombiProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;

    public DSICarKombiProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = DSICarKombiProvider.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarKombiProxy(this.instance, (DSICarKombiReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void resetSIAValue(int n) {
        try {
            this.proxy.resetSIAValue(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        try {
            this.proxy.requestSIAHistoryList(carArrayListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSIADistanceOilUser(int n, int n2) {
        try {
            this.proxy.setSIADistanceOilUser(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSIADistanceAirFilterUser(int n, int n2) {
        try {
            this.proxy.setSIADistanceAirFilterUser(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSIADistanceOilFilterUser(int n, int n2) {
        try {
            this.proxy.setSIADistanceOilFilterUser(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSIAInspectionDistanceUser(int n, int n2) {
        try {
            this.proxy.setSIAInspectionDistanceUser(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCVZADisplay(boolean bl) {
        try {
            this.proxy.setBCVZADisplay(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCLifeTipsDisplay(boolean bl) {
        try {
            this.proxy.setBCLifeTipsDisplay(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCConsumerDisplay(boolean bl) {
        try {
            this.proxy.setBCConsumerDisplay(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCMenueConfig(BCMenueConfiguration bCMenueConfiguration, int n) {
        try {
            this.proxy.setBCMenueConfig(bCMenueConfiguration, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetBCMenue(int n) {
        try {
            this.proxy.resetBCMenue(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCOilTemperature(boolean bl) {
        try {
            this.proxy.setBCOilTemperature(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCDigitalSpeed(boolean bl) {
        try {
            this.proxy.setBCDigitalSpeed(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCStopwatch(boolean bl) {
        try {
            this.proxy.setBCStopwatch(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCVzaMFA(boolean bl) {
        try {
            this.proxy.setBCVzaMFA(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings) {
        try {
            this.proxy.setBCSpeedWarning(bCSpeedWarningSettings);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCGearRecommendation(boolean bl) {
        try {
            this.proxy.setBCGearRecommendation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCRearSeatbeltWarning(boolean bl) {
        try {
            this.proxy.setBCRearSeatbeltWarning(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestVehicleStateList(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH) {
        try {
            this.proxy.requestVehicleStateList(bCVehicleStateUpdateInfoAH);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBcSetFactoryDefault() {
        try {
            this.proxy.setBcSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetBCStatistics(BCStatisticsReset bCStatisticsReset) {
        try {
            this.proxy.resetBCStatistics(bCStatisticsReset);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCAstaMFA(boolean bl) {
        try {
            this.proxy.setBCAstaMFA(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHUDHeightAdjustment(byte by) {
        try {
            this.proxy.setHUDHeightAdjustment(by);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHUDBrightness(byte by) {
        try {
            this.proxy.setHUDBrightness(by);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHUDContent(HUDContent hUDContent) {
        try {
            this.proxy.setHUDContent(hUDContent);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHUDRotationAdjustment(int n) {
        try {
            this.proxy.setHUDRotationAdjustment(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHUDColour(int n, int n2) {
        try {
            this.proxy.setHUDColour(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHUDSetFactoryDefault() {
        try {
            this.proxy.setHUDSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHUDSystemOnOff(boolean bl) {
        try {
            this.proxy.setHUDSystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCSetFactoryDefault() {
        try {
            this.proxy.setDCSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCBrightness(int n) {
        try {
            this.proxy.setDCBrightness(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCVolume(int n) {
        try {
            this.proxy.setDCVolume(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCDisplay1MainSelection(DCMainItems dCMainItems) {
        try {
            this.proxy.setDCDisplay1MainSelection(dCMainItems);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCDisplay2MainSelection(DCMainItems dCMainItems) {
        try {
            this.proxy.setDCDisplay2MainSelection(dCMainItems);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCDisplay3MainSelection(DCMainItems dCMainItems) {
        try {
            this.proxy.setDCDisplay3MainSelection(dCMainItems);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDCElementContentSelectionList(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
        try {
            this.proxy.requestDCElementContentSelectionList(dCElementContentSelectionListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        try {
            this.proxy.setDCElementContentSelectionListRA1(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
        try {
            this.proxy.setDCElementContentSelectionListRA2(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA2Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        try {
            this.proxy.setDCElementContentSelectionListRAF(dCElementContentSelectionListUpdateInfo, nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument) {
        try {
            this.proxy.setDCAdditionalInstrumentSetup(dCAdditionalInstrument);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2) {
        try {
            this.proxy.setDCAdditionalInstrument2Setup(dCAdditionalInstrument2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        try {
            this.proxy.requestDCDisplayPresetsList(carArrayListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
        try {
            this.proxy.setDCDisplayPresetsList(carArrayListUpdateInfo, dCDisplayPresetsListRecordArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency) {
        try {
            this.proxy.setDCDisplayDependencySetup(dCDisplayDependency);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCActiveDisplayPreset(int n) {
        try {
            this.proxy.setDCActiveDisplayPreset(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration) {
        try {
            this.proxy.setDCDisplayViewConfiguration(dCDisplayViewConfiguration);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHUDLicense(boolean bl) {
        try {
            this.proxy.setHUDLicense(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDCLEDConfiguration(boolean bl) {
        try {
            this.proxy.setDCLEDConfiguration(bl);
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

