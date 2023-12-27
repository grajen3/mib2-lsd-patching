/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.featureflags;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.diagnosis.config.HmiFunctionBlockTbl;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.Arrays;

public class HmiFunctionBlockTblSetter {
    private static final int BIT_INDEX_TUNER1;
    private static final int BIT_INDEX_TUNER2;
    private static final int BIT_INDEX_CAR2;
    private static final int BIT_INDEX_CAR3;
    private static final int BIT_INDEX_MISC17;
    private static final String ALLOFF;
    private static final String ALLON;
    private final ASLPropertyManager aslPropertyManager;
    private final ConfigurationManagerDiag configManagerDiag;
    private final Logger logger;

    public HmiFunctionBlockTblSetter(ASLPropertyManager aSLPropertyManager, ConfigurationManagerDiag configurationManagerDiag, Logger logger) {
        this.aslPropertyManager = aSLPropertyManager;
        this.configManagerDiag = configurationManagerDiag;
        this.logger = logger;
    }

    public void update(HmiFunctionBlockTbl hmiFunctionBlockTbl) {
        if (this.tryOverwriteFeatureFlags()) {
            return;
        }
        if (hmiFunctionBlockTbl == null) {
            this.logError("processDiagHmiFunctionBlockTbl Data could not be read");
            this.setDefaults();
            return;
        }
        this.logInfo("Hmi Function blocking table");
        byte[] byArray = hmiFunctionBlockTbl.getRawData();
        byte[] byArray2 = HmiFunctionBlockTblSetter.reverseBitOrder(byArray);
        if (byArray.length == 0) {
            this.logWarning("processDiagHmiFunctionBlockTbl South side returns no data");
            this.setDefaults();
            return;
        }
        this.writeNhtsaFeatureFlags(hmiFunctionBlockTbl);
        this.writeNhtsaGroupIds(byArray2);
    }

    static byte[] reverseBitOrder(byte[] byArray) {
        byte[] byArray2 = new byte[byArray.length];
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            byte by = 0;
            byte by2 = byArray[i2];
            for (int i3 = 0; i3 < 8; ++i3) {
                boolean bl;
                boolean bl2 = bl = (by2 & 1 << i3) != 0;
                if (!bl) continue;
                by = (byte)(by | 1 << 7 - i3);
            }
            byArray2[i2] = by;
        }
        return byArray2;
    }

    static boolean getBit(byte[] byArray, int n) {
        byte by = byArray[n / 8];
        int n2 = 7 - n % 8;
        int n3 = (0xFF & by) >> n2;
        return (1 & n3) == 1;
    }

    private boolean tryOverwriteFeatureFlags() {
        String string = System.getProperty("de.vw.mib.driverdistraction.overwrite");
        if (string == null) {
            return false;
        }
        if (string.equals("ALLON")) {
            this.writeAllOn();
            return true;
        }
        if (string.equals("ALLOFF")) {
            this.writeAllOff();
            return true;
        }
        if (string.startsWith("0x")) {
            return this.writeCustom(string);
        }
        return false;
    }

    private void setDefaults() {
        String string = System.getProperty("de.vw.mib.driverdistraction.default");
        if ("ALLON".equals(string)) {
            this.writeAllOn();
            return;
        }
        if (!"ALLOFF".equals(string)) {
            this.logWarning(new StringBuffer().append("Unexpected system property value 'de.vw.mib.driverdistraction.default=").append(string).append("'! Using value 'ALLOFF' instead.").toString());
        }
        this.writeAllOff();
    }

    private void writeAllOff() {
        this.writeFeatueFlags(false, false, false, false, false);
        this.writeNhtsaGroupIds(new byte[21]);
    }

    private void writeAllOn() {
        this.writeFeatueFlags(true, true, true, true, true);
        byte[] byArray = new byte[21];
        Arrays.fill(byArray, (byte)-1);
        this.writeNhtsaGroupIds(byArray);
    }

    private boolean writeCustom(String string) {
        byte[] byArray;
        String string2 = string.substring(2);
        if (string2.length() != 42) {
            this.logWarning(new StringBuffer().append("Unexpected length of custom overwrite data detected! Expected 21 hexadecimal coded bytes, got:").append(string2).toString());
            return false;
        }
        try {
            byArray = HmiFunctionBlockTblSetter.parse(string2);
        }
        catch (NumberFormatException numberFormatException) {
            this.logWarning(new StringBuffer().append("Unexpected non-hex digit detected, in custom overwrite data! Got: ").append(string2).toString());
            return false;
        }
        boolean bl = HmiFunctionBlockTblSetter.getBit(byArray, 1);
        boolean bl2 = HmiFunctionBlockTblSetter.getBit(byArray, 2);
        boolean bl3 = HmiFunctionBlockTblSetter.getBit(byArray, 98);
        boolean bl4 = HmiFunctionBlockTblSetter.getBit(byArray, 99);
        boolean bl5 = HmiFunctionBlockTblSetter.getBit(byArray, 137);
        this.writeFeatueFlags(bl, bl2, bl3, bl4, bl5);
        this.writeNhtsaGroupIds(byArray);
        return true;
    }

    private void writeNhtsaFeatureFlags(HmiFunctionBlockTbl hmiFunctionBlockTbl) {
        boolean bl = HmiFunctionBlockTblSetter.getDiagnosisValue(hmiFunctionBlockTbl, 973);
        boolean bl2 = HmiFunctionBlockTblSetter.getDiagnosisValue(hmiFunctionBlockTbl, 974);
        boolean bl3 = HmiFunctionBlockTblSetter.getDiagnosisValue(hmiFunctionBlockTbl, 1070);
        boolean bl4 = HmiFunctionBlockTblSetter.getDiagnosisValue(hmiFunctionBlockTbl, 1071);
        boolean bl5 = HmiFunctionBlockTblSetter.getDiagnosisValue(hmiFunctionBlockTbl, 1109);
        this.writeFeatueFlags(bl, bl2, bl3, bl4, bl5);
    }

    private void writeFeatueFlags(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.writeFeatureFlagTuner1(bl);
        this.writeFeatureFlagTuner2(bl2);
        this.writeFeatureFlagCar2(bl3);
        this.writeFeatureFlagCar3(bl4);
        this.writeFeatureFlagMisc17(bl5);
    }

    private void writeFeatureFlagMisc17(boolean bl) {
        this.aslPropertyManager.valueChangedBoolean(1385240576, bl);
        this.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isHomescreenTileSelectionBlockedWhileDriving", bl);
    }

    private void writeFeatureFlagCar3(boolean bl) {
        this.aslPropertyManager.valueChangedBoolean(949032960, bl);
        this.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isNHTSAFBCar3", bl);
    }

    private void writeFeatureFlagCar2(boolean bl) {
        this.aslPropertyManager.valueChangedBoolean(932255744, bl);
        this.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isNHTSAFBCar2", bl);
    }

    private void writeFeatureFlagTuner2(boolean bl) {
        this.aslPropertyManager.valueChangedBoolean(898701312, bl);
        this.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isNHTSAFBTuner2", bl);
    }

    private void writeFeatureFlagTuner1(boolean bl) {
        this.aslPropertyManager.valueChangedBoolean(915478528, bl);
        this.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isNHTSAFBTuner1", bl);
    }

    private void writeNhtsaGroupIds(byte[] byArray) {
        this.traceConfiguration(byArray);
        this.configManagerDiag.setDriverDistractionPreventionConfig(byArray);
    }

    private void traceConfiguration(byte[] byArray) {
        if (this.logger.isTraceEnabled(16384)) {
            LogMessage logMessage = this.logger.trace(16384).append("Setting distraction prevention config (NHTSA): ");
            if (byArray != null) {
                logMessage.append("[");
                boolean bl = true;
                for (int i2 = 0; i2 < byArray.length; ++i2) {
                    if (bl) {
                        bl = false;
                    } else {
                        logMessage.append(", ");
                    }
                    logMessage.append(byArray[i2]);
                }
                logMessage.append("]");
            } else {
                logMessage.append("null");
            }
            logMessage.log();
        }
    }

    private static boolean getDiagnosisValue(Access access, int n) {
        if (!access.contains(n)) {
            return false;
        }
        return access.getValue(n) == 1;
    }

    private static byte[] parse(String string) {
        int n = string.length();
        byte[] byArray = new byte[n / 2];
        for (int i2 = 0; i2 < n; i2 += 2) {
            String string2 = string.substring(i2, i2 + 2);
            byArray[i2 / 2] = (byte)Integer.parseInt(string2, 16);
        }
        return byArray;
    }

    private void logWarning(String string) {
        this.logger.warn(16384, string);
    }

    private void logInfo(String string) {
        this.logger.info(16384, string);
    }

    private void logError(String string) {
        this.logger.error(16384, string);
    }
}

