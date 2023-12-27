/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.ARATrailerConfigurationSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCConfigurationSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSConfigurationSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.ARATrailerConfiguration;
import org.dsi.ifc.carparkingsystem.PDCConfiguration;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carparkingsystem.VPSConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class ParkingSystemViewOptionsSerializer {
    public static void putOptionalParkingSystemViewOptions(ISerializer iSerializer, ParkingSystemViewOptions parkingSystemViewOptions) {
        boolean bl = parkingSystemViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = parkingSystemViewOptions.getPdcSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = parkingSystemViewOptions.getPdcVolumeFront();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = parkingSystemViewOptions.getPdcFrequencyFront();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = parkingSystemViewOptions.getPdcVolumeRear();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = parkingSystemViewOptions.getPdcFrequencyRear();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = parkingSystemViewOptions.getPdcVolumeRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
            CarViewOption carViewOption7 = parkingSystemViewOptions.getPdcFrequencyRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption7);
            CarViewOption carViewOption8 = parkingSystemViewOptions.getPdcVolumeLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption8);
            CarViewOption carViewOption9 = parkingSystemViewOptions.getPdcFrequencyLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption9);
            CarViewOption carViewOption10 = parkingSystemViewOptions.getPdcDefaultParkingMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption10);
            CarViewOption carViewOption11 = parkingSystemViewOptions.getPdcMute();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption11);
            CarViewOption carViewOption12 = parkingSystemViewOptions.getPdcAutoActivation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption12);
            CarViewOption carViewOption13 = parkingSystemViewOptions.getPdcSoundReproduction();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption13);
            CarViewOption carViewOption14 = parkingSystemViewOptions.getPdcFlankGuard();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption14);
            CarViewOption carViewOption15 = parkingSystemViewOptions.getPdcSoundFront();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption15);
            CarViewOption carViewOption16 = parkingSystemViewOptions.getPdcSoundRear();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption16);
            CarViewOption carViewOption17 = parkingSystemViewOptions.getPdcSoundLeft();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption17);
            CarViewOption carViewOption18 = parkingSystemViewOptions.getPdcSoundRight();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption18);
            CarViewOption carViewOption19 = parkingSystemViewOptions.getPdcOffroadMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption19);
            CarViewOption carViewOption20 = parkingSystemViewOptions.getPdcParkboxVisualisation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption20);
            CarViewOption carViewOption21 = parkingSystemViewOptions.getPdcOPSVisualisationPosition();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption21);
            CarViewOption carViewOption22 = parkingSystemViewOptions.getPdcPLAStatus();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption22);
            CarViewOption carViewOption23 = parkingSystemViewOptions.getPdcPLABargraph();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption23);
            CarViewOption carViewOption24 = parkingSystemViewOptions.getPdcPLAParkmodeSelection();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption24);
            CarViewOption carViewOption25 = parkingSystemViewOptions.getPdcPLASystemState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption25);
            CarViewOption carViewOption26 = parkingSystemViewOptions.getVpsSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption26);
            CarViewOption carViewOption27 = parkingSystemViewOptions.getVpsColor();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption27);
            CarViewOption carViewOption28 = parkingSystemViewOptions.getVpsBrightness();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption28);
            CarViewOption carViewOption29 = parkingSystemViewOptions.getVpsContrast();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption29);
            CarViewOption carViewOption30 = parkingSystemViewOptions.getVpsFollowUpTime();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption30);
            CarViewOption carViewOption31 = parkingSystemViewOptions.getVpsOPSOverlay();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption31);
            CarViewOption carViewOption32 = parkingSystemViewOptions.getVpsDynamicParkingMode();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption32);
            CarViewOption carViewOption33 = parkingSystemViewOptions.getVpsDefaultView();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption33);
            CarViewOption carViewOption34 = parkingSystemViewOptions.getVpsDefaultModeRV();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption34);
            CarViewOption carViewOption35 = parkingSystemViewOptions.getVpsDefaultModeFV();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption35);
            CarViewOption carViewOption36 = parkingSystemViewOptions.getVpsDefaultModeSV();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption36);
            CarViewOption carViewOption37 = parkingSystemViewOptions.getVpsDefaultModeBV();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption37);
            CarViewOption carViewOption38 = parkingSystemViewOptions.getVpsExtCamConfig();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption38);
            CarViewOption carViewOption39 = parkingSystemViewOptions.getVpsExtCamManActivation();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption39);
            CarViewOption carViewOption40 = parkingSystemViewOptions.getVps3DBirdview();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption40);
            CarViewOption carViewOption41 = parkingSystemViewOptions.getVpsSystemState();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption41);
            CarViewOption carViewOption42 = parkingSystemViewOptions.getPdcSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption42);
            CarViewOption carViewOption43 = parkingSystemViewOptions.getVpsSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption43);
            CarViewOption carViewOption44 = parkingSystemViewOptions.getAraCurrentTrailerAngle();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption44);
            CarViewOption carViewOption45 = parkingSystemViewOptions.getAraTargetTrailerAngle();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption45);
            PDCConfiguration pDCConfiguration = parkingSystemViewOptions.getPdcConfiguration();
            PDCConfigurationSerializer.putOptionalPDCConfiguration(iSerializer, pDCConfiguration);
            VPSConfiguration vPSConfiguration = parkingSystemViewOptions.getVpsConfiguration();
            VPSConfigurationSerializer.putOptionalVPSConfiguration(iSerializer, vPSConfiguration);
            ARATrailerConfiguration aRATrailerConfiguration = parkingSystemViewOptions.getAraTrailerConfiguration();
            ARATrailerConfigurationSerializer.putOptionalARATrailerConfiguration(iSerializer, aRATrailerConfiguration);
            CarViewOption carViewOption46 = parkingSystemViewOptions.getPdcManeuverAssistConfig();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption46);
            CarViewOption carViewOption47 = parkingSystemViewOptions.getPdcManeuverAssist();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption47);
            CarViewOption carViewOption48 = parkingSystemViewOptions.getPdcContinueDrivingAssist();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption48);
            CarViewOption carViewOption49 = parkingSystemViewOptions.getPdcIpaConfig();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption49);
            CarViewOption carViewOption50 = parkingSystemViewOptions.getPdcPiloPaSystemStatePP();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption50);
            CarViewOption carViewOption51 = parkingSystemViewOptions.getPdcPiloPaSystemStateGP();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption51);
            CarViewOption carViewOption52 = parkingSystemViewOptions.getVpsCameraCleaning();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption52);
            CarViewOption carViewOption53 = parkingSystemViewOptions.getVpsRimProtection();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption53);
        }
    }

    public static void putOptionalParkingSystemViewOptionsVarArray(ISerializer iSerializer, ParkingSystemViewOptions[] parkingSystemViewOptionsArray) {
        boolean bl = parkingSystemViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(parkingSystemViewOptionsArray.length);
            for (int i2 = 0; i2 < parkingSystemViewOptionsArray.length; ++i2) {
                ParkingSystemViewOptionsSerializer.putOptionalParkingSystemViewOptions(iSerializer, parkingSystemViewOptionsArray[i2]);
            }
        }
    }

    public static ParkingSystemViewOptions getOptionalParkingSystemViewOptions(IDeserializer iDeserializer) {
        ParkingSystemViewOptions parkingSystemViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            CarViewOption carViewOption7;
            CarViewOption carViewOption8;
            ARATrailerConfiguration aRATrailerConfiguration;
            VPSConfiguration vPSConfiguration;
            PDCConfiguration pDCConfiguration;
            CarViewOption carViewOption9;
            CarViewOption carViewOption10;
            CarViewOption carViewOption11;
            CarViewOption carViewOption12;
            CarViewOption carViewOption13;
            CarViewOption carViewOption14;
            CarViewOption carViewOption15;
            CarViewOption carViewOption16;
            CarViewOption carViewOption17;
            CarViewOption carViewOption18;
            CarViewOption carViewOption19;
            CarViewOption carViewOption20;
            CarViewOption carViewOption21;
            CarViewOption carViewOption22;
            CarViewOption carViewOption23;
            CarViewOption carViewOption24;
            CarViewOption carViewOption25;
            CarViewOption carViewOption26;
            CarViewOption carViewOption27;
            CarViewOption carViewOption28;
            CarViewOption carViewOption29;
            CarViewOption carViewOption30;
            CarViewOption carViewOption31;
            CarViewOption carViewOption32;
            CarViewOption carViewOption33;
            CarViewOption carViewOption34;
            CarViewOption carViewOption35;
            CarViewOption carViewOption36;
            CarViewOption carViewOption37;
            CarViewOption carViewOption38;
            CarViewOption carViewOption39;
            CarViewOption carViewOption40;
            CarViewOption carViewOption41;
            CarViewOption carViewOption42;
            CarViewOption carViewOption43;
            CarViewOption carViewOption44;
            CarViewOption carViewOption45;
            CarViewOption carViewOption46;
            CarViewOption carViewOption47;
            CarViewOption carViewOption48;
            CarViewOption carViewOption49;
            CarViewOption carViewOption50;
            CarViewOption carViewOption51;
            CarViewOption carViewOption52;
            CarViewOption carViewOption53;
            parkingSystemViewOptions = new ParkingSystemViewOptions();
            parkingSystemViewOptions.pdcSystemOnOff = carViewOption53 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcVolumeFront = carViewOption52 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcFrequencyFront = carViewOption51 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcVolumeRear = carViewOption50 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcFrequencyRear = carViewOption49 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcVolumeRight = carViewOption48 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcFrequencyRight = carViewOption47 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcVolumeLeft = carViewOption46 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcFrequencyLeft = carViewOption45 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcDefaultParkingMode = carViewOption44 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcMute = carViewOption43 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcAutoActivation = carViewOption42 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcSoundReproduction = carViewOption41 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcFlankGuard = carViewOption40 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcSoundFront = carViewOption39 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcSoundRear = carViewOption38 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcSoundLeft = carViewOption37 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcSoundRight = carViewOption36 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcOffroadMode = carViewOption35 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcParkboxVisualisation = carViewOption34 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcOPSVisualisationPosition = carViewOption33 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcPLAStatus = carViewOption32 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcPLABargraph = carViewOption31 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcPLAParkmodeSelection = carViewOption30 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcPLASystemState = carViewOption29 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsSystemOnOff = carViewOption28 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsColor = carViewOption27 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsBrightness = carViewOption26 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsContrast = carViewOption25 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsFollowUpTime = carViewOption24 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsOPSOverlay = carViewOption23 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsDynamicParkingMode = carViewOption22 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsDefaultView = carViewOption21 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsDefaultModeRV = carViewOption20 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsDefaultModeFV = carViewOption19 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsDefaultModeSV = carViewOption18 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsDefaultModeBV = carViewOption17 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsExtCamConfig = carViewOption16 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsExtCamManActivation = carViewOption15 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vps3DBirdview = carViewOption14 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsSystemState = carViewOption13 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcSetFactoryDefault = carViewOption12 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsSetFactoryDefault = carViewOption11 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.araCurrentTrailerAngle = carViewOption10 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.araTargetTrailerAngle = carViewOption9 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcConfiguration = pDCConfiguration = PDCConfigurationSerializer.getOptionalPDCConfiguration(iDeserializer);
            parkingSystemViewOptions.vpsConfiguration = vPSConfiguration = VPSConfigurationSerializer.getOptionalVPSConfiguration(iDeserializer);
            parkingSystemViewOptions.araTrailerConfiguration = aRATrailerConfiguration = ARATrailerConfigurationSerializer.getOptionalARATrailerConfiguration(iDeserializer);
            parkingSystemViewOptions.pdcManeuverAssistConfig = carViewOption8 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcManeuverAssist = carViewOption7 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcContinueDrivingAssist = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcIpaConfig = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcPiloPaSystemStatePP = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.pdcPiloPaSystemStateGP = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsCameraCleaning = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            parkingSystemViewOptions.vpsRimProtection = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return parkingSystemViewOptions;
    }

    public static ParkingSystemViewOptions[] getOptionalParkingSystemViewOptionsVarArray(IDeserializer iDeserializer) {
        ParkingSystemViewOptions[] parkingSystemViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            parkingSystemViewOptionsArray = new ParkingSystemViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                parkingSystemViewOptionsArray[i2] = ParkingSystemViewOptionsSerializer.getOptionalParkingSystemViewOptions(iDeserializer);
            }
        }
        return parkingSystemViewOptionsArray;
    }
}

