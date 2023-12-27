/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.cardriverassistance;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.cardriverassistance.DSICarDriverAssistanceReply;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.DSICarDriverAssistanceProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistance;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.global.CarBCSpeed;
import org.osgi.framework.BundleContext;

public class DSICarDriverAssistanceProvider
extends AbstractProvider
implements DSICarDriverAssistance {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 54, 55, 56, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 74, 75, 19, 20, 21, 22, 23, 57, 82, 24, 25, 26, 27, 28, 29, 47, 48, 49, 50, 51, 66, 67, 68, 69, 70, 71, 72, 30, 31, 32, 33, 34, 41, 42, 46, 63, 35, 36, 37, 38, 39, 40, 77, 78, 43, 52, 53, 64, 76, 44, 45, 58, 59, 60, 61, 73, 62, 79, 80, 81};
    private DSICarDriverAssistanceProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance;

    public DSICarDriverAssistanceProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance = DSICarDriverAssistanceProvider.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistance")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarDriverAssistanceProxy(this.instance, (DSICarDriverAssistanceReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setACCGongState(boolean bl) {
        try {
            this.proxy.setACCGongState(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setACCGongVolume(int n) {
        try {
            this.proxy.setACCGongVolume(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setACCDrivingProgram(int n) {
        try {
            this.proxy.setACCDrivingProgram(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setACCTimeGap(int n) {
        try {
            this.proxy.setACCTimeGap(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setACCDefaultMode(int n) {
        try {
            this.proxy.setACCDefaultMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setACCCurveAssist(boolean bl) {
        try {
            this.proxy.setACCCurveAssist(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setACCSpeedLimitAdoption(boolean bl) {
        try {
            this.proxy.setACCSpeedLimitAdoption(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setACCTrafficJamAssist(boolean bl) {
        try {
            this.proxy.setACCTrafficJamAssist(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setACCSpeedLimitOffset(int n) {
        try {
            this.proxy.setACCSpeedLimitOffset(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning) {
        try {
            this.proxy.setACCDistanceWarning(aCCDistanceWarning);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setACCSetFactoryDefault() {
        try {
            this.proxy.setACCSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPACCSensibility(boolean bl) {
        try {
            this.proxy.setPACCSensibility(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPACCMaxSpeed(int n, int n2) {
        try {
            this.proxy.setPACCMaxSpeed(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPACCDrivingProgram(int n) {
        try {
            this.proxy.setPACCDrivingProgram(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAWVSystem(int n) {
        try {
            this.proxy.setAWVSystem(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAWVWarning(boolean bl) {
        try {
            this.proxy.setAWVWarning(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAWVGong(boolean bl) {
        try {
            this.proxy.setAWVGong(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAWVGongVolume(int n) {
        try {
            this.proxy.setAWVGongVolume(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAWVBrakeJerk(boolean bl) {
        try {
            this.proxy.setAWVBrakeJerk(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAWVEmergencyBrake(AWVEmergencyBrake aWVEmergencyBrake) {
        try {
            this.proxy.setAWVEmergencyBrake(aWVEmergencyBrake);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAWVDistanceWarning(boolean bl) {
        try {
            this.proxy.setAWVDistanceWarning(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAWVWarningTimegap(int n) {
        try {
            this.proxy.setAWVWarningTimegap(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAWVSetFactoryDefault() {
        try {
            this.proxy.setAWVSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSWABrightness(int n) {
        try {
            this.proxy.setSWABrightness(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSWAWarningTime(int n) {
        try {
            this.proxy.setSWAWarningTime(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSWAFrequency(int n) {
        try {
            this.proxy.setSWAFrequency(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSWASystem(int n) {
        try {
            this.proxy.setSWASystem(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSWAGongState(boolean bl) {
        try {
            this.proxy.setSWAGongState(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSWAGongVolume(int n) {
        try {
            this.proxy.setSWAGongVolume(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSWARCTA(boolean bl) {
        try {
            this.proxy.setSWARCTA(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSWAExitAssist(boolean bl) {
        try {
            this.proxy.setSWAExitAssist(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVActivation(boolean bl) {
        try {
            this.proxy.setNVActivation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVContrast(int n) {
        try {
            this.proxy.setNVContrast(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVBrightness(int n) {
        try {
            this.proxy.setNVBrightness(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVObjectDetection(NVObjectDetection nVObjectDetection) {
        try {
            this.proxy.setNVObjectDetection(nVObjectDetection);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVColorPA(int n) {
        try {
            this.proxy.setNVColorPA(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVDesignPA(int n) {
        try {
            this.proxy.setNVDesignPA(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVDisplay(int n) {
        try {
            this.proxy.setNVDisplay(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVZoomPanning(int n) {
        try {
            this.proxy.setNVZoomPanning(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVSound(int n) {
        try {
            this.proxy.setNVSound(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVSymbol(boolean bl) {
        try {
            this.proxy.setNVSymbol(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVSetFactoryDefault() {
        try {
            this.proxy.setNVSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVWarningTimegap(int n) {
        try {
            this.proxy.setNVWarningTimegap(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNVSystem(boolean bl) {
        try {
            this.proxy.setNVSystem(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLDWWarningTime(int n) {
        try {
            this.proxy.setLDWWarningTime(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLDWSteeringWheelVibration(int n) {
        try {
            this.proxy.setLDWSteeringWheelVibration(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHCAInterventionStyle(int n) {
        try {
            this.proxy.setHCAInterventionStyle(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHCAToleranceLevel(int n) {
        try {
            this.proxy.setHCAToleranceLevel(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLdwhcaSetFactoryDefault() {
        try {
            this.proxy.setLdwhcaSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLDWHCASystemOnOff(boolean bl) {
        try {
            this.proxy.setLDWHCASystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLDWHCAWarningSound(boolean bl, int n) {
        try {
            this.proxy.setLDWHCAWarningSound(bl, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTSDSystemOnOff(boolean bl) {
        try {
            this.proxy.setTSDSystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter) {
        try {
            this.proxy.setTSDRoadSignFilter(tSDRoadSignFilter);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTsdSetFactoryDefault() {
        try {
            this.proxy.setTsdSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed) {
        try {
            this.proxy.setTSDSpeedWarningThreshold(bl, carBCSpeed);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed) {
        try {
            this.proxy.setTSDTrailerSpeedLimit(carBCSpeed);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTSDSpeedWarningAcoustics(boolean bl) {
        try {
            this.proxy.setTSDSpeedWarningAcoustics(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMKESystemOnOff(boolean bl) {
        try {
            this.proxy.setMKESystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMKESetFactoryDefault() {
        try {
            this.proxy.setMKESetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPASystemOnOff(boolean bl) {
        try {
            this.proxy.setPASystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPASetFactoryDefault() {
        try {
            this.proxy.setPASetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPAConfigInformation(boolean bl) {
        try {
            this.proxy.setPAConfigInformation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPAConfigWarning(boolean bl) {
        try {
            this.proxy.setPAConfigWarning(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPAWarningTimegap(int n) {
        try {
            this.proxy.setPAWarningTimegap(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCurveAssistSystemOnOff(boolean bl) {
        try {
            this.proxy.setCurveAssistSystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCurveAssistSetFactoryDefault() {
        try {
            this.proxy.setCurveAssistSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFTASystemOnOff(boolean bl) {
        try {
            this.proxy.setFTASystemOnOff(bl);
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

