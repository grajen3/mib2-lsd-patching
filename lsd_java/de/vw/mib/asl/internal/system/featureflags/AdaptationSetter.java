/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.featureflags;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.internal.system.has.SystemHasBridge;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import generated.de.vw.mib.has.containers.EncodedVehicleTypeContainer;

public class AdaptationSetter {
    private final SystemHasBridge systemHasBridge;
    private final ASLPropertyManager propertyManager;
    private final ConfigurationManagerDiag configurationManager;

    public AdaptationSetter(SystemHasBridge systemHasBridge, ASLPropertyManager aSLPropertyManager, ConfigurationManagerDiag configurationManagerDiag) {
        this.systemHasBridge = systemHasBridge;
        this.propertyManager = aSLPropertyManager;
        this.configurationManager = configurationManagerDiag;
    }

    public void update(Adaptation adaptation) {
        if (adaptation != null) {
            this.updateEncodedVehicleExtType(adaptation);
            this.updateFeatureFlagCountry(adaptation);
            this.updateFeatureFlagUseUSCarInfomationStyle(adaptation);
            this.updateAndroidAuto(adaptation);
            this.updateCarPlay(adaptation);
            this.updateWifiHotspot(adaptation);
            this.updateWifiClientHmi(adaptation);
            this.updateMirrorLink(adaptation);
            this.updateMostHud(adaptation);
            this.updateCarLife(adaptation);
        }
    }

    private void updateEncodedVehicleExtType(Adaptation adaptation) {
        EncodedVehicleTypeContainer encodedVehicleTypeContainer = this.systemHasBridge.getEncodedVehicleTypeContainer();
        int n = 0;
        n |= this.encodeBit(adaptation.getBoolean(179), 0);
        n |= this.encodeBit(adaptation.getBoolean(180), 1);
        n |= this.encodeBit(adaptation.getBoolean(181), 2);
        n |= this.encodeBit(adaptation.getBoolean(182), 3);
        n |= this.encodeBit(adaptation.getBoolean(183), 4);
        n |= this.encodeBit(adaptation.getBoolean(1144), 5);
        n |= this.encodeInt(adaptation.getValue(184), 6);
        n |= this.encodeBit(adaptation.getBoolean(185), 8);
        n |= this.encodeBit(adaptation.getBoolean(186), 9);
        n |= this.encodeBit(adaptation.getBoolean(187), 10);
        n |= this.encodeBit(adaptation.getBoolean(188), 11);
        n |= this.encodeBit(adaptation.getBoolean(1145), 12);
        n |= this.encodeBit(adaptation.getBoolean(1146), 13);
        n |= this.encodeBit(adaptation.getBoolean(1147), 14);
        encodedVehicleTypeContainer.setStickerBits(n |= this.encodeBit(adaptation.getBoolean(1148), 15));
        this.systemHasBridge.refreshEncodedVehicleTypeContainer();
    }

    private void updateFeatureFlagCountry(Adaptation adaptation) {
        byte[] byArray = adaptation.getByteArray(165);
        if (byArray != null) {
            String string = new String(byArray);
            this.updateFeatureFlagIsJp(string);
            this.updateFeatureFlagIsTwn(string);
            this.updateFeatureFlagIsKr(string);
            this.updateFeatureFlagIsChn(string);
        }
    }

    private void updateFeatureFlagIsKr(String string) {
        boolean bl = "KR".equals(string);
        this.propertyManager.valueChangedBoolean(1200691200, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isSellCountryKR", bl);
    }

    private void updateFeatureFlagIsJp(String string) {
        boolean bl = "JP".equals(string);
        this.propertyManager.valueChangedBoolean(730929152, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isSellCountryJP", bl);
    }

    private void updateFeatureFlagIsTwn(String string) {
        boolean bl = "TW".equals(string);
        this.propertyManager.valueChangedBoolean(999364608, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isSellCountryTWN", bl);
    }

    private void updateFeatureFlagIsChn(String string) {
        boolean bl = "CN".equals(string);
        this.propertyManager.valueChangedBoolean(1234245632, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isSellCountryCHN", bl);
    }

    private int encodeBit(boolean bl, int n) {
        if (bl) {
            return 1 << n;
        }
        return 0;
    }

    private int encodeInt(int n, int n2) {
        return n << n2;
    }

    private void updateFeatureFlagUseUSCarInfomationStyle(Adaptation adaptation) {
        byte[] byArray = adaptation.getByteArray(165);
        if (byArray == null) {
            return;
        }
        String string = new String(byArray);
        boolean bl = "US".equals(string);
        this.propertyManager.valueChangedBoolean(865146880, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isUseUSCarInfomationStyle", bl);
    }

    private void updateAndroidAuto(Adaptation adaptation) {
        boolean bl = adaptation.getBoolean(1142);
        this.propertyManager.valueChangedBoolean(965810176, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isAndroidAuto", bl);
    }

    private void updateCarPlay(Adaptation adaptation) {
        boolean bl = adaptation.getBoolean(1143);
        this.propertyManager.valueChangedBoolean(982587392, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isCarPlay", bl);
    }

    private void updateWifiHotspot(Adaptation adaptation) {
        boolean bl = adaptation.getBoolean(137);
        this.propertyManager.valueChangedBoolean(1100027904, bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isWlanHotspot", bl);
    }

    private void updateWifiClientHmi(Adaptation adaptation) {
        if (adaptation.contains(1155)) {
            boolean bl = adaptation.getBoolean(1155);
            this.propertyManager.valueChangedBoolean(1083250688, bl);
            this.configurationManager.setFeatureFlagValue("ASL.Configuration.isWlanClient", bl);
        }
    }

    private void updateMirrorLink(Adaptation adaptation) {
        if (adaptation.contains(1169)) {
            boolean bl = adaptation.getValue(1169) == 1;
            this.propertyManager.valueChangedBoolean(1150359552, bl);
            this.configurationManager.setFeatureFlagValue("ASL.Configuration.isMirrorLink", bl);
        }
    }

    private void updateCarLife(Adaptation adaptation) {
        this.updateCarLife(adaptation, 1194, 1569789952, "ASL.Configuration.isCarLifeAndroid");
        this.updateCarLife(adaptation, 1238, 1586567168, "ASL.Configuration.isCarLifeiOS");
    }

    private void updateCarLife(Adaptation adaptation, int n, int n2, String string) {
        if (adaptation.contains(n)) {
            boolean bl = adaptation.getBoolean(n);
            this.propertyManager.valueChangedBoolean(n2, bl);
            this.configurationManager.setFeatureFlagValue(string, bl);
        }
    }

    private void updateMostHud(Adaptation adaptation) {
        if (adaptation.contains(1173)) {
            boolean bl = adaptation.getValue(1173) == 1;
            this.configurationManager.setFeatureFlagValue("ASL.Configuration.isMostHUD", bl);
        }
    }
}

