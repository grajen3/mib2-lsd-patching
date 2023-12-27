/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.high2;

import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public final class CodingImpl
extends AccessImpl
implements Coding {
    public CodingImpl(byte[] byArray) {
        super(byArray, new int[]{25}, -687821311, 1L);
        this.mConfiguration = new int[]{1091, 0, 8, 1, 0, 20051, 4, 0, 0, 2, 3, 1091, 0, 9, 1, 11, 20051, 4, 1, 0, 3, 14, 20051, 4, 1, 4, 7, 14, 20051, 4, 2, 0, 0, 14, 20051, 4, 2, 4, 0, 14, 1091, 0, 19, 1, 40, 20051, 8, 3, 0, 1, 43, 10037, 1, 4, 0, 0, -1, 10037, 1, 4, 1, 0, -1, 10037, 1, 4, 2, 0, -1, 10037, 1, 4, 3, 0, -1, 10037, 1, 4, 4, 0, -1, 10037, 1, 4, 5, 0, -1, 10037, 1, 4, 6, 0, -1, 10037, 1, 4, 7, 0, -1, 10037, 1, 5, 0, 0, -1, 10037, 1, 5, 1, 0, -1, 10037, 1, 5, 2, 0, -1, 10037, 1, 5, 3, 0, -1, 10037, 1, 5, 4, 0, -1, 10037, 1, 5, 5, 0, -1, 10037, 1, 5, 6, 0, -1, 10037, 1, 5, 7, 0, -1, 10037, 1, 6, 0, 0, -1, 10037, 1, 6, 1, 0, -1, 10037, 1, 6, 2, 0, -1, 10037, 1, 6, 3, 0, -1, 10037, 1, 6, 4, 0, -1, 10037, 1, 6, 5, 0, -1, 10037, 1, 6, 6, 0, -1, 10037, 1, 6, 7, 0, -1, 10037, 1, 7, 0, 0, -1, 10037, 1, 7, 1, 0, -1, 10037, 1, 7, 2, 0, -1, 10037, 1, 7, 3, 0, -1, 10037, 1, 7, 4, 0, -1, 10037, 1, 7, 5, 0, -1, 10037, 1, 7, 6, 0, -1, 10037, 1, 7, 7, 0, -1, 10037, 1, 8, 0, 1, -1, 10037, 1, 8, 1, 0, -1, 10037, 1, 8, 2, 0, -1, 10037, 1, 8, 3, 0, -1, 10037, 1, 8, 4, 0, -1, 10037, 1, 8, 5, 1, -1, 10037, 1, 8, 6, 1, -1, 20051, 4, 9, 0, 1, 3, 1091, 0, 5, 1, 291, 20051, 4, 9, 4, 1, 294, 1091, 0, 7, 1, 302, 20051, 4, 10, 0, 2, 305, 1091, 0, 2, 1, 313, 20051, 4, 10, 4, 1, 316, 1091, 0, 4, 1, 324, 20051, 8, 11, 0, 0, 327, 10037, 1, 12, 0, 1, -1, 20051, 3, 12, 1, 0, 327, 10037, 1, 13, 0, 1, -1, 2029, 2, 0, 1, 1, 353, 20051, 1, 13, 1, 1, 357, 20051, 1, 13, 2, 0, 357, 10037, 1, 13, 3, 1, -1, 10037, 1, 13, 4, 1, 357, 1091, 0, 3, 1, 383, 20051, 2, 13, 5, 0, 386, 10037, 1, 13, 7, 1, -1, 10037, 1, 14, 0, 1, -1, 10037, 1, 14, 1, 0, -1, 10037, 1, 14, 2, 0, -1, 10037, 1, 14, 3, 0, -1, 10037, 1, 14, 4, 0, -1, 10037, 1, 14, 5, 0, -1, 10037, 1, 15, 0, 0, -1, 10037, 1, 15, 1, 0, -1, 10037, 1, 15, 2, 0, -1, 10037, 1, 15, 3, 0, -1, 10037, 1, 15, 4, 1, -1, 10037, 1, 15, 5, 0, 357, 10037, 1, 16, 0, 1, -1, 10037, 1, 16, 1, 1, -1, 10037, 1, 16, 2, 1, -1, 10037, 1, 16, 3, 1, -1, 20051, 2, 16, 4, 1, 386, 10037, 1, 16, 6, 0, -1, 20051, 8, 17, 0, 1, 3, 1091, 0, 11, 1, 514, 20051, 8, 18, 0, 1, 517, 10037, 1, 19, 0, 0, -1, 20051, 1, 19, 1, 0, 357, 20051, 2, 19, 2, 0, 316, 10037, 1, 19, 4, 1, -1, 10037, 1, 19, 5, 0, -1, 20051, 2, 19, 6, 2, 386, 10037, 1, 20, 0, 1, -1, 10037, 1, 20, 1, 0, -1, 10037, 1, 20, 2, 0, -1, 10037, 1, 20, 3, 0, -1, 10037, 1, 20, 4, 0, -1, 10037, 1, 20, 5, 0, -1, 10037, 1, 20, 6, 0, -1, 20051, 1, 20, 7, 0, 357, 10037, 1, 21, 4, 0, -1, 10037, 1, 21, 5, 0, -1, 10037, 1, 21, 6, 0, -1, 10037, 1, 21, 7, 0, -1, 20051, 1, 22, 0, 1, 357, 10037, 1, 22, 1, 1, -1, 10037, 1, 22, 2, 0, 357, 10037, 1, 22, 3, 0, 357, 10037, 1, 22, 5, 0, 357, 20051, 2, 22, 6, 0, 316, 10037, 1, 23, 0, 1, -1, 10037, 1, 23, 1, 0, -1, 10037, 1, 23, 2, 0, -1, 10037, 1, 24, 0, 0, -1, 10037, 1, 24, 1, 1, -1, 10037, 1, 24, 2, 1, -1, 10037, 1, 24, 3, 0, -1, 10037, 1, 24, 4, 0, -1, 10037, 1, 24, 5, 0, -1, 10037, 1, 24, 6, 0, -1, 10037, 1, 24, 7, 0, -1, 254, 0, 5, 32, 207, 64, 430, 96, 621, 1, 16, 33, 213, 65, 436, 97, 633, 2, 22, 34, 219, 66, 442, 1177, 627, 3, 28, 35, 225, 67, 448, 98, 639, 4, 34, 36, 231, 68, 454, 1178, 645, 5, 45, 37, 237, 69, 460, 99, 663, 6, 51, 38, 243, 100, 669, 101, 675, 7, 57, 39, 249, 71, 472, 102, 681, 8, 63, 40, 255, 72, 478, 103, 687, 9, 69, 41, 261, 73, 484, 104, 693, 10, 75, 42, 267, 74, 490, 105, 699, 11, 81, 43, 273, 75, 496, 106, 705, 12, 87, 44, 279, 76, 502, 107, 711, 13, 93, 45, 285, 77, 508, 108, 717, 14, 99, 46, 296, 78, 519, 109, 723, 15, 105, 47, 307, 79, 525, 110, 729, 16, 111, 48, 318, 80, 531, 128, 128, 17, 117, 49, 329, 81, 537, 128, 128, 18, 123, 50, 335, 82, 543, 128, 128, 19, 129, 51, 341, 83, 549, 128, 128, 20, 135, 52, 347, 84, 555, 128, 128, 21, 141, 53, 359, 85, 561, 1164, 657, 22, 147, 54, 365, 1165, 466, 86, 567, 23, 153, 55, 371, 87, 573, 128, 128, 24, 159, 56, 377, 88, 579, 128, 128, 25, 165, 57, 388, 89, 585, 128, 128, 26, 171, 58, 394, 90, 591, 128, 128, 27, 177, 59, 400, 91, 597, 1234, 651, 28, 183, 60, 406, 92, 603, 128, 128, 29, 189, 61, 412, 128, 128, 128, 128, 30, 195, 62, 418, 94, 609, 128, 128, 31, 201, 63, 424, 95, 615, 735};
        this.mEngine = new Engine(this.mConfiguration);
    }

    @Override
    public boolean isAfPersistent(int n) {
        return n == 0;
    }

    @Override
    public boolean isAfTemporary(int n) {
        return n == 1;
    }

    @Override
    public boolean isBandSettingsAmTunerEu(int n) {
        return n == 4;
    }

    @Override
    public boolean isBandSettingsAmTunerEuRdw(int n) {
        return n == 1;
    }

    @Override
    public boolean isBandSettingsAmTunerJp(int n) {
        return n == 3;
    }

    @Override
    public boolean isBandSettingsAmTunerNar(int n) {
        return n == 2;
    }

    @Override
    public boolean isBandSettingsAmTunerNoSetting(int n) {
        return n == 0;
    }

    @Override
    public boolean isBandSettingsAmTunerOff(int n) {
        return n == 5;
    }

    @Override
    public boolean isBandSettingsDabTunerBand1CanadaLBand(int n) {
        return n == 3;
    }

    @Override
    public boolean isBandSettingsDabTunerBand1ChinaBandIii(int n) {
        return n == 5;
    }

    @Override
    public boolean isBandSettingsDabTunerBand1DownloadTable1(int n) {
        return n == 6;
    }

    @Override
    public boolean isBandSettingsDabTunerBand1EuBandIii(int n) {
        return n == 2;
    }

    @Override
    public boolean isBandSettingsDabTunerBand1EuBandIiiN(int n) {
        return n == 1;
    }

    @Override
    public boolean isBandSettingsDabTunerBand1KoreaBandIii(int n) {
        return n == 4;
    }

    @Override
    public boolean isBandSettingsDabTunerBand1NewZealandBandIii(int n) {
        return n == 7;
    }

    @Override
    public boolean isBandSettingsDabTunerBand1Off(int n) {
        return n == 0;
    }

    @Override
    public boolean isBandSettingsDabTunerBand2DownloadTable2(int n) {
        return n == 2;
    }

    @Override
    public boolean isBandSettingsDabTunerBand2LBand(int n) {
        return n == 1;
    }

    @Override
    public boolean isBandSettingsDabTunerBand2Off(int n) {
        return n == 0;
    }

    @Override
    public boolean isBandSettingsFmTunerChina(int n) {
        return n == 5;
    }

    @Override
    public boolean isBandSettingsFmTunerEuRdw(int n) {
        return n == 1;
    }

    @Override
    public boolean isBandSettingsFmTunerJp(int n) {
        return n == 3;
    }

    @Override
    public boolean isBandSettingsFmTunerKor(int n) {
        return n == 4;
    }

    @Override
    public boolean isBandSettingsFmTunerNar(int n) {
        return n == 2;
    }

    @Override
    public boolean isBandSettingsFmTunerNoSetting(int n) {
        return n == 0;
    }

    @Override
    public boolean isBluetoothVisibilityAuto(int n) {
        return n == 1;
    }

    @Override
    public boolean isBluetoothVisibilityLimited(int n) {
        return n == 3;
    }

    @Override
    public boolean isBluetoothVisibilityOff(int n) {
        return n == 0;
    }

    @Override
    public boolean isBluetoothVisibilityOn(int n) {
        return n == 2;
    }

    @Override
    public boolean isBwsNo(int n) {
        return n == 0;
    }

    @Override
    public boolean isBwsRestricted(int n) {
        return n == 1;
    }

    @Override
    public boolean isBwsRestrictedUnrestricted(int n) {
        return n == 3;
    }

    @Override
    public boolean isBwsUnrestricted(int n) {
        return n == 2;
    }

    @Override
    public boolean isCarBrandAudi(int n) {
        return n == 1;
    }

    @Override
    public boolean isCarBrandBentley(int n) {
        return n == 5;
    }

    @Override
    public boolean isCarBrandNoBrand(int n) {
        return n == 0;
    }

    @Override
    public boolean isCarBrandSeat(int n) {
        return n == 4;
    }

    @Override
    public boolean isCarBrandSkoda(int n) {
        return n == 3;
    }

    @Override
    public boolean isCarBrandVw(int n) {
        return n == 2;
    }

    @Override
    public boolean isCarBrandVwNfz(int n) {
        return n == 6;
    }

    @Override
    public boolean isCarClassA(int n) {
        return n == 3;
    }

    @Override
    public boolean isCarClassA0(int n) {
        return n == 2;
    }

    @Override
    public boolean isCarClassA00(int n) {
        return n == 1;
    }

    @Override
    public boolean isCarClassA000(int n) {
        return n == 0;
    }

    @Override
    public boolean isCarClassB(int n) {
        return n == 4;
    }

    @Override
    public boolean isCarClassC(int n) {
        return n == 5;
    }

    @Override
    public boolean isCarClassD(int n) {
        return n == 6;
    }

    @Override
    public boolean isCarClassEMinus(int n) {
        return n == 7;
    }

    @Override
    public boolean isCarClassEPlus(int n) {
        return n == 8;
    }

    @Override
    public boolean isCarClassOthers(int n) {
        return n == 9;
    }

    @Override
    public boolean isCarDerivateCabrioRoadsterSpiderTarga(int n) {
        return n == 5;
    }

    @Override
    public boolean isCarDerivateCoupe(int n) {
        return n == 4;
    }

    @Override
    public boolean isCarDerivateFliessheckSportsback(int n) {
        return n == 3;
    }

    @Override
    public boolean isCarDerivateKombi(int n) {
        return n == 2;
    }

    @Override
    public boolean isCarDerivateKurzheck(int n) {
        return n == 0;
    }

    @Override
    public boolean isCarDerivatePickUp(int n) {
        return n == 7;
    }

    @Override
    public boolean isCarDerivateRaumkonzept(int n) {
        return n == 8;
    }

    @Override
    public boolean isCarDerivateSonstige(int n) {
        return n == 9;
    }

    @Override
    public boolean isCarDerivateStufenheck(int n) {
        return n == 1;
    }

    @Override
    public boolean isCarDerivateSupplementAlternAntrieb(int n) {
        return n == 7;
    }

    @Override
    public boolean isCarDerivateSupplementAufbauDachvar(int n) {
        return n == 3;
    }

    @Override
    public boolean isCarDerivateSupplementCrossAllroad(int n) {
        return n == 4;
    }

    @Override
    public boolean isCarDerivateSupplementGeaendertFrontHeck(int n) {
        return n == 2;
    }

    @Override
    public boolean isCarDerivateSupplementKurzerRadstand(int n) {
        return n == 0;
    }

    @Override
    public boolean isCarDerivateSupplementLangerRadstand(int n) {
        return n == 1;
    }

    @Override
    public boolean isCarDerivateSupplementLeistungsvari2(int n) {
        return n == 6;
    }

    @Override
    public boolean isCarDerivateSupplementLeistungvari1(int n) {
        return n == 5;
    }

    @Override
    public boolean isCarDerivateSupplementSonst(int n) {
        return n == 8;
    }

    @Override
    public boolean isCarDerivateSupplementSonstige(int n) {
        return n == 9;
    }

    @Override
    public boolean isCarDerivateSuv(int n) {
        return n == 6;
    }

    @Override
    public boolean isCountryAsiaPacific(int n) {
        return n == 7;
    }

    @Override
    public boolean isCountryAustralia(int n) {
        return n == 8;
    }

    @Override
    public boolean isCountryCentralAsia(int n) {
        return n == 13;
    }

    @Override
    public boolean isCountryChina(int n) {
        return n == 5;
    }

    @Override
    public boolean isCountryEu(int n) {
        return n == 1;
    }

    @Override
    public boolean isCountryIndia(int n) {
        return n == 14;
    }

    @Override
    public boolean isCountryIsrael(int n) {
        return n == 15;
    }

    @Override
    public boolean isCountryJapan(int n) {
        return n == 6;
    }

    @Override
    public boolean isCountryKorea(int n) {
        return n == 4;
    }

    @Override
    public boolean isCountryMeast(int n) {
        return n == 12;
    }

    @Override
    public boolean isCountryMsa(int n) {
        return n == 3;
    }

    @Override
    public boolean isCountryNar(int n) {
        return n == 2;
    }

    @Override
    public boolean isCountryNeast(int n) {
        return n == 10;
    }

    @Override
    public boolean isCountryNmAfrica(int n) {
        return n == 11;
    }

    @Override
    public boolean isCountryNoCountry(int n) {
        return n == 0;
    }

    @Override
    public boolean isCountrySouthAfrika(int n) {
        return n == 9;
    }

    @Override
    public boolean isDashboardCommunicationBap(int n) {
        return n == 0;
    }

    @Override
    public boolean isDashboardCommunicationDdp2(int n) {
        return n == 1;
    }

    @Override
    public boolean isDashboardGraphicVariantCan(int n) {
        return n == 1;
    }

    @Override
    public boolean isDashboardGraphicVariantMost(int n) {
        return n == 0;
    }

    @Override
    public boolean isHdAntennaAmFm(int n) {
        return n == 0;
    }

    @Override
    public boolean isHdAntennaFm(int n) {
        return n == 1;
    }

    @Override
    public boolean isHdAntennaMrc(int n) {
        return n == 3;
    }

    @Override
    public boolean isHdAntennaSwitching(int n) {
        return n == 2;
    }

    @Override
    public boolean isHdAntennaTestMode(int n) {
        return n == 4;
    }

    @Override
    public boolean isHdRadioActivationActive(int n) {
        return n == 1;
    }

    @Override
    public boolean isHdRadioActivationNotActive(int n) {
        return n == 0;
    }

    @Override
    public boolean isKombiTrackStationInfoLongInfo(int n) {
        return n == 1;
    }

    @Override
    public boolean isKombiTrackStationInfoNotAvailable(int n) {
        return n == 0;
    }

    @Override
    public boolean isKombiTrackStationInfoShortInfo(int n) {
        return n == 2;
    }

    @Override
    public boolean isScreeningsNoScreen(int n) {
        return n == 0;
    }

    @Override
    public boolean isSkinningNoSkinning(int n) {
        return n == 0;
    }

    @Override
    public boolean isSoundSystemExtern(int n) {
        return n == 2;
    }

    @Override
    public boolean isSoundSystemExternBap(int n) {
        return n == 3;
    }

    @Override
    public boolean isSoundSystemIntern(int n) {
        return n == 1;
    }

    @Override
    public boolean isSoundSystemInternalIndividual(int n) {
        return n == 4;
    }

    @Override
    public boolean isSoundSystemNoAlloc(int n) {
        return n == 0;
    }

    @Override
    public boolean isSuspensionArmSideLeft(int n) {
        return n == 0;
    }

    @Override
    public boolean isSuspensionArmSideRight(int n) {
        return n == 1;
    }

    @Override
    public boolean isUsbCharge(int n) {
        return n == 1;
    }

    @Override
    public boolean isUsbFull(int n) {
        return n == 2;
    }

    @Override
    public boolean isUsbOff(int n) {
        return n == 0;
    }

    @Override
    public boolean isUsbUsbIpod(int n) {
        return n == 3;
    }

    @Override
    public boolean isWheelDriveAll(int n) {
        return n == 2;
    }

    @Override
    public boolean isWheelDriveFront(int n) {
        return n == 0;
    }

    @Override
    public boolean isWheelDriveRear(int n) {
        return n == 1;
    }
}

