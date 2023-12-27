/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.caraircondition;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.caraircondition.DSICarAirConditionReply;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.DSICarAirCondition;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.osgi.framework.BundleContext;

public class DSICarAirConditionProvider
extends AbstractProvider
implements DSICarAirCondition {
    private static final int[] attributeIDs = new int[]{92, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 81, 14, 15, 82, 83, 16, 91, 17, 19, 20, 21, 22, 152, 153, 154, 62, 102, 103, 104, 105, 106, 93, 96, 99, 107, 24, 25, 26, 27, 167, 168, 110, 111, 122, 128, 134, 140, 69, 63, 146, 75, 30, 31, 32, 33, 169, 170, 112, 113, 123, 129, 135, 141, 147, 64, 70, 76, 94, 97, 100, 108, 36, 37, 38, 39, 171, 172, 114, 115, 124, 130, 136, 142, 148, 65, 71, 77, 42, 43, 44, 45, 173, 174, 116, 117, 125, 131, 137, 143, 149, 66, 72, 78, 95, 98, 101, 109, 48, 49, 50, 51, 175, 176, 118, 119, 126, 132, 138, 144, 150, 67, 73, 79, 54, 55, 56, 57, 177, 178, 120, 121, 127, 133, 139, 145, 151, 68, 74, 80};
    private DSICarAirConditionProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirCondition;

    public DSICarAirConditionProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$caraircondition$DSICarAirCondition == null ? (class$org$dsi$ifc$caraircondition$DSICarAirCondition = DSICarAirConditionProvider.class$("org.dsi.ifc.caraircondition.DSICarAirCondition")) : class$org$dsi$ifc$caraircondition$DSICarAirCondition).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarAirConditionProxy(this.instance, (DSICarAirConditionReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setAirconAirCirculationMan(boolean bl) {
        try {
            this.proxy.setAirconAirCirculationMan(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconAirCirculationAuto(boolean bl) {
        try {
            this.proxy.setAirconAirCirculationAuto(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconMiddleExhaustion(int n) {
        try {
            this.proxy.setAirconMiddleExhaustion(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconRearWindowHeater(boolean bl) {
        try {
            this.proxy.setAirconRearWindowHeater(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconIndirectVentilation(boolean bl) {
        try {
            this.proxy.setAirconIndirectVentilation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconPopupTime(int n) {
        try {
            this.proxy.setAirconPopupTime(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconHeater(boolean bl) {
        try {
            this.proxy.setAirconHeater(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconRearAuxHeater(boolean bl) {
        try {
            this.proxy.setAirconRearAuxHeater(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconFrontWindowHeater(boolean bl) {
        try {
            this.proxy.setAirconFrontWindowHeater(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconDefrost(boolean bl) {
        try {
            this.proxy.setAirconDefrost(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconMaxDefrost(boolean bl) {
        try {
            this.proxy.setAirconMaxDefrost(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSolar(boolean bl) {
        try {
            this.proxy.setAirconSolar(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconAC(boolean bl) {
        try {
            this.proxy.setAirconAC(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconMaxAC(boolean bl) {
        try {
            this.proxy.setAirconMaxAC(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconEcoAC(boolean bl) {
        try {
            this.proxy.setAirconEcoAC(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconRearControl(boolean bl) {
        try {
            this.proxy.setAirconRearControl(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconRearControlFondPlus(boolean bl) {
        try {
            this.proxy.setAirconRearControlFondPlus(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater) {
        try {
            this.proxy.setAirconSteeringWheelHeater(airconSteeringWheelHeater);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconFrontWindowHeaterAuto(boolean bl) {
        try {
            this.proxy.setAirconFrontWindowHeaterAuto(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconBlowerCompensation(AirconBlowerCompensation airconBlowerCompensation) {
        try {
            this.proxy.setAirconBlowerCompensation(airconBlowerCompensation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSynchronisation(AirconSynchronisation airconSynchronisation) {
        try {
            this.proxy.setAirconSynchronisation(airconSynchronisation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSuppressVisualisation(boolean bl) {
        try {
            this.proxy.setAirconSuppressVisualisation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSystemOnOffRow(int n, boolean bl) {
        try {
            this.proxy.setAirconSystemOnOffRow(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconAirCirculationSensitivity(int n) {
        try {
            this.proxy.setAirconAirCirculationSensitivity(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconResidualHeat(boolean bl) {
        try {
            this.proxy.setAirconResidualHeat(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showAirconPopup(AirconContent airconContent) {
        try {
            this.proxy.showAirconPopup(airconContent);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelAirconPopup(AirconContent airconContent, int n) {
        try {
            this.proxy.cancelAirconPopup(airconContent, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconContent(AirconContent airconContent) {
        try {
            this.proxy.setAirconContent(airconContent);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconTempZone(int n, AirconTemp airconTemp) {
        try {
            this.proxy.setAirconTempZone(n, airconTemp);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconAirVolume(int n, AirconAirVolume airconAirVolume) {
        try {
            this.proxy.setAirconAirVolume(n, airconAirVolume);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconAirDistribution(int n, AirconAirDistribution airconAirDistribution) {
        try {
            this.proxy.setAirconAirDistribution(n, airconAirDistribution);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconFootwellTemp(int n, int n2) {
        try {
            this.proxy.setAirconFootwellTemp(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSeatHeater(int n, int n2, int n3) {
        try {
            this.proxy.setAirconSeatHeater(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSeatVentilation(int n, int n2, int n3) {
        try {
            this.proxy.setAirconSeatVentilation(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconHMIIsReady(boolean bl) {
        try {
            this.proxy.setAirconHMIIsReady(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSeatHeaterDistribution(int n, int n2) {
        try {
            this.proxy.setAirconSeatHeaterDistribution(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSeatVentilationDistribution(int n, int n2) {
        try {
            this.proxy.setAirconSeatVentilationDistribution(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconTempStep(int n, int n2) {
        try {
            this.proxy.setAirconTempStep(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconClimateStyle(int n, int n2) {
        try {
            this.proxy.setAirconClimateStyle(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSetFactoryDefaultMaster() {
        try {
            this.proxy.setAirconSetFactoryDefaultMaster();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSetFactoryDefaultRow(int n) {
        try {
            this.proxy.setAirconSetFactoryDefaultRow(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconNozzleControlRow1(int n) {
        try {
            this.proxy.setAirconNozzleControlRow1(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconNozzleControlRow2(int n) {
        try {
            this.proxy.setAirconNozzleControlRow2(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconNozzleControlRow3(int n) {
        try {
            this.proxy.setAirconNozzleControlRow3(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAirconNozzleListRow(int n, CarArrayListUpdateInfo carArrayListUpdateInfo) {
        try {
            this.proxy.requestAirconNozzleListRow(n, carArrayListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconNozzleListRow(int n, CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        try {
            this.proxy.setAirconNozzleListRow(n, carArrayListUpdateInfo, airconNozzleListRecordArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSideWindowDefrost(boolean bl) {
        try {
            this.proxy.setAirconSideWindowDefrost(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconPureAir(AirconPureAirSetup airconPureAirSetup) {
        try {
            this.proxy.setAirconPureAir(airconPureAirSetup);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconFreshAirConfig(AirconFreshAirConfiguration airconFreshAirConfiguration) {
        try {
            this.proxy.setAirconFreshAirConfig(airconFreshAirConfiguration);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconAirQuality(int n, int n2) {
        try {
            this.proxy.setAirconAirQuality(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSeatNeckHeater(int n, boolean bl, int n2) {
        try {
            this.proxy.setAirconSeatNeckHeater(n, bl, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconSeatSurfaceHeater(int n, boolean bl, boolean bl2, int n2) {
        try {
            this.proxy.setAirconSeatSurfaceHeater(n, bl, bl2, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconIndividualClimatisation(int n, boolean bl) {
        try {
            this.proxy.setAirconIndividualClimatisation(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconIonisator(int n, int n2) {
        try {
            this.proxy.setAirconIonisator(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAirconBodyCloseMeasures(int n, boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration) {
        try {
            this.proxy.setAirconBodyCloseMeasures(n, bl, airconBCMeasuresConfiguration);
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

