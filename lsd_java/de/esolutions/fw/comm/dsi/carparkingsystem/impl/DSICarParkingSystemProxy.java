/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carparkingsystem.DSICarParkingSystem;
import de.esolutions.fw.comm.dsi.carparkingsystem.DSICarParkingSystemC;
import de.esolutions.fw.comm.dsi.carparkingsystem.DSICarParkingSystemReply;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$1;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$10;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$11;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$12;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$13;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$14;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$15;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$16;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$17;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$2;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$3;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$4;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$5;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$6;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$7;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$8;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy$9;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
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

public class DSICarParkingSystemProxy
implements DSICarParkingSystem,
DSICarParkingSystemC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carparkingsystem.DSICarParkingSystem");
    private Proxy proxy;

    public DSICarParkingSystemProxy(int n, DSICarParkingSystemReply dSICarParkingSystemReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("84b9518c-66ec-58f1-8efb-ea1c6a621692", n, "6f0ad754-4b1b-5807-8e51-0f831609c79a", "dsi.carparkingsystem.DSICarParkingSystem");
        DSICarParkingSystemReplyService dSICarParkingSystemReplyService = new DSICarParkingSystemReplyService(dSICarParkingSystemReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarParkingSystemReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setHMIStateIsReady(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setPDCDefaultParkingMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void setPDCMute(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    @Override
    public void setPDCFrequenceFront(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void setPDCFrequenceRear(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    @Override
    public void setPDCVolumeFront(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    @Override
    public void setPDCVolumeRear(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    @Override
    public void setPDCAutoActivation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    @Override
    public void setPDCSystemOnOff(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    @Override
    public void setPDCFrequenceRight(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    @Override
    public void setPDCFrequenceLeft(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void setPDCVolumeRight(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    @Override
    public void setPDCVolumeLeft(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    @Override
    public void setPDCFlankGuard(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void setPDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction) {
        DSICarParkingSystemProxy$1 dSICarParkingSystemProxy$1 = new DSICarParkingSystemProxy$1(this, pDCSoundReproduction);
        this.proxy.remoteCallMethod((short)23, dSICarParkingSystemProxy$1);
    }

    @Override
    public void setPDCSoundFront(PDCSound pDCSound) {
        DSICarParkingSystemProxy$2 dSICarParkingSystemProxy$2 = new DSICarParkingSystemProxy$2(this, pDCSound);
        this.proxy.remoteCallMethod((short)95, dSICarParkingSystemProxy$2);
    }

    @Override
    public void setPDCSoundRear(PDCSound pDCSound) {
        DSICarParkingSystemProxy$3 dSICarParkingSystemProxy$3 = new DSICarParkingSystemProxy$3(this, pDCSound);
        this.proxy.remoteCallMethod((short)97, dSICarParkingSystemProxy$3);
    }

    @Override
    public void setPDCSoundLeft(PDCSound pDCSound) {
        DSICarParkingSystemProxy$4 dSICarParkingSystemProxy$4 = new DSICarParkingSystemProxy$4(this, pDCSound);
        this.proxy.remoteCallMethod((short)96, dSICarParkingSystemProxy$4);
    }

    @Override
    public void setPDCSoundRight(PDCSound pDCSound) {
        DSICarParkingSystemProxy$5 dSICarParkingSystemProxy$5 = new DSICarParkingSystemProxy$5(this, pDCSound);
        this.proxy.remoteCallMethod((short)98, dSICarParkingSystemProxy$5);
    }

    @Override
    public void setPDCPLAPreSelection(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)93, genericSerializable);
    }

    @Override
    public void setPDCPLAParkMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)92, genericSerializable);
    }

    @Override
    public void setPDCPLASystemState(PDCPLASystemState pDCPLASystemState) {
        DSICarParkingSystemProxy$6 dSICarParkingSystemProxy$6 = new DSICarParkingSystemProxy$6(this, pDCPLASystemState);
        this.proxy.remoteCallMethod((short)94, dSICarParkingSystemProxy$6);
    }

    @Override
    public void setPDCOffroadMode(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)91, genericSerializable);
    }

    @Override
    public void setPDCVisualisationParkbox(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)99, genericSerializable);
    }

    @Override
    public void setPDCOPSVisualisationPosition(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)90, genericSerializable);
    }

    @Override
    public void setVPSFollowUpTime(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    @Override
    public void setVPSColor(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)31, genericSerializable);
    }

    @Override
    public void setVPSContrast(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    @Override
    public void setVPSBrightness(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    @Override
    public void setVPSDefaultModeRV(VPSDefaultMode vPSDefaultMode) {
        DSICarParkingSystemProxy$7 dSICarParkingSystemProxy$7 = new DSICarParkingSystemProxy$7(this, vPSDefaultMode);
        this.proxy.remoteCallMethod((short)35, dSICarParkingSystemProxy$7);
    }

    @Override
    public void setVPSDefaultModeFV(VPSDefaultMode vPSDefaultMode) {
        DSICarParkingSystemProxy$8 dSICarParkingSystemProxy$8 = new DSICarParkingSystemProxy$8(this, vPSDefaultMode);
        this.proxy.remoteCallMethod((short)34, dSICarParkingSystemProxy$8);
    }

    @Override
    public void setVPSDefaultModeSV(VPSDefaultMode vPSDefaultMode) {
        DSICarParkingSystemProxy$9 dSICarParkingSystemProxy$9 = new DSICarParkingSystemProxy$9(this, vPSDefaultMode);
        this.proxy.remoteCallMethod((short)36, dSICarParkingSystemProxy$9);
    }

    @Override
    public void setVPSDefaultModeBV(VPSDefaultMode vPSDefaultMode) {
        DSICarParkingSystemProxy$10 dSICarParkingSystemProxy$10 = new DSICarParkingSystemProxy$10(this, vPSDefaultMode);
        this.proxy.remoteCallMethod((short)33, dSICarParkingSystemProxy$10);
    }

    @Override
    public void setVPSDefaultView(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    @Override
    public void setVPSOPSOverlay(VPSOPSOverlay vPSOPSOverlay) {
        DSICarParkingSystemProxy$11 dSICarParkingSystemProxy$11 = new DSICarParkingSystemProxy$11(this, vPSOPSOverlay);
        this.proxy.remoteCallMethod((short)40, dSICarParkingSystemProxy$11);
    }

    @Override
    public void setVPSDynamicParkingMode(VPSDynParkingMode vPSDynParkingMode) {
        DSICarParkingSystemProxy$12 dSICarParkingSystemProxy$12 = new DSICarParkingSystemProxy$12(this, vPSDynParkingMode);
        this.proxy.remoteCallMethod((short)38, dSICarParkingSystemProxy$12);
    }

    @Override
    public void setVPSSystemOnOff(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)41, genericSerializable);
    }

    @Override
    public void setVPSExtCamConfig(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)127, genericSerializable);
    }

    @Override
    public void setVPSExtCamManActivation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)128, genericSerializable);
    }

    @Override
    public void setVPS3DBirdview(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)126, genericSerializable);
    }

    @Override
    public void setVPSSystemState(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)129, genericSerializable);
    }

    @Override
    public void showParkingPopup(DisplayContent displayContent) {
        DSICarParkingSystemProxy$13 dSICarParkingSystemProxy$13 = new DSICarParkingSystemProxy$13(this, displayContent);
        this.proxy.remoteCallMethod((short)43, dSICarParkingSystemProxy$13);
    }

    @Override
    public void cancelParkingPopup(DisplayContent displayContent, int n) {
        DSICarParkingSystemProxy$14 dSICarParkingSystemProxy$14 = new DSICarParkingSystemProxy$14(this, displayContent, n);
        this.proxy.remoteCallMethod((short)4, dSICarParkingSystemProxy$14);
    }

    @Override
    public void requestLifeMonitoring(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setPdcSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)29, null);
    }

    @Override
    public void setVpsSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)42, null);
    }

    @Override
    public void setARATargetTrailerAngle(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)89, genericSerializable);
    }

    @Override
    public void setPDCManeuverAssistConfig(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)137, genericSerializable);
    }

    @Override
    public void setPDCManeuverAssist(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)136, genericSerializable);
    }

    @Override
    public void setPDCContinueDrivingAssist(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)142, genericSerializable);
    }

    @Override
    public void setPDCIpaConfig(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)143, genericSerializable);
    }

    @Override
    public void setPDCPiloPaSystemState(PDCPiloPaSystemState pDCPiloPaSystemState) {
        DSICarParkingSystemProxy$15 dSICarParkingSystemProxy$15 = new DSICarParkingSystemProxy$15(this, pDCPiloPaSystemState);
        this.proxy.remoteCallMethod((short)144, dSICarParkingSystemProxy$15);
    }

    @Override
    public void setVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning) {
        DSICarParkingSystemProxy$16 dSICarParkingSystemProxy$16 = new DSICarParkingSystemProxy$16(this, vPSCameraCleaning);
        this.proxy.remoteCallMethod((short)145, dSICarParkingSystemProxy$16);
    }

    @Override
    public void setWCAutoActivation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)177, genericSerializable);
    }

    @Override
    public void setWCSystemOnOff(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)179, genericSerializable);
    }

    @Override
    public void setWCSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)178, null);
    }

    @Override
    public void showWCPopup(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)180, genericSerializable);
    }

    @Override
    public void cancelWCPopup(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)170, genericSerializable);
    }

    @Override
    public void requestWCPanelList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        DSICarParkingSystemProxy$17 dSICarParkingSystemProxy$17 = new DSICarParkingSystemProxy$17(this, carArrayListUpdateInfo);
        this.proxy.remoteCallMethod((short)174, dSICarParkingSystemProxy$17);
    }

    @Override
    public void enterWCPinPuk(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)173, genericSerializable);
    }

    @Override
    public void abortWCEnterPinPuk() {
        this.proxy.remoteCallMethod((short)158, null);
    }

    @Override
    public void startWCScanning() {
        this.proxy.remoteCallMethod((short)182, null);
    }

    @Override
    public void abortWCScanning() {
        this.proxy.remoteCallMethod((short)160, null);
    }

    @Override
    public void startWCPairing(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)181, genericSerializable);
    }

    @Override
    public void abortWCPairing() {
        this.proxy.remoteCallMethod((short)159, null);
    }

    @Override
    public void startWCSoftwareUpdate(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)183, genericSerializable);
    }

    @Override
    public void abortWCSoftwareUpdate() {
        this.proxy.remoteCallMethod((short)161, null);
    }

    @Override
    public void changeWCPin(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)172, genericSerializable);
    }

    @Override
    public void abortWCChangePin() {
        this.proxy.remoteCallMethod((short)157, null);
    }

    @Override
    public void changeWCPanelName(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)171, genericSerializable);
    }

    @Override
    public void abortWCChangePanelName() {
        this.proxy.remoteCallMethod((short)156, null);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)12, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)5, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)88, genericSerializable);
    }
}

