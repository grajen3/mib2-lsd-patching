/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.impl.lsc.LscLogger;
import de.vw.mib.asl.framework.internal.lsc.LscServices;
import de.vw.mib.configuration.ConfigurationManagerDiag;

public class BrandHandler {
    private ConfigurationManagerDiag configurationManager;
    private ASLPropertyManager propertyManager;
    private LscLogger logger;

    public BrandHandler(LscServices lscServices) {
        this.configurationManager = lscServices.getConfigManagerDiag();
        this.propertyManager = lscServices.getPropertyManager();
        this.logger = lscServices.getLscLogger();
    }

    void updateBrand(int n) {
        if (n == 2 || n == 4 || n == 6) {
            this.logger.info(new StringBuffer().append("Writing brand :").append(this.getBrandName(n)).toString());
            this.writeBrand(n);
        } else {
            this.logger.info(new StringBuffer().append("Writing brand SKODA instead of: ").append(this.getBrandName(n)).toString());
            this.writeBrand(3);
        }
    }

    private void writeBrand(int n) {
        boolean bl = n == 2 || n == 6;
        boolean bl2 = n == 4;
        boolean bl3 = n == 3;
        this.propertyManager.valueChangedBoolean(346, bl);
        this.propertyManager.valueChangedBoolean(344, bl2);
        this.propertyManager.valueChangedBoolean(345, bl3);
        this.propertyManager.valueChangedBoolean(579934208, !bl2);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isVW", bl);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isSEAT", bl2);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isSkoda", bl3);
        this.configurationManager.setFeatureFlagValue("ASL.Configuration.isNotSEAT", !bl2);
    }

    private String getBrandName(int n) {
        switch (n) {
            case 1: {
                return "AUDI";
            }
            case 5: {
                return "BENTLEY";
            }
            case 0: {
                return "NO_BRAND";
            }
            case 4: {
                return "SEAT";
            }
            case 3: {
                return "SKODA";
            }
            case 2: {
                return "VW";
            }
            case 6: {
                return "VW_NFZ";
            }
        }
        return "?";
    }
}

