/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.system.AslTargetSystemFeaturesAndCoding;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.configuration.RtMethodListener;

class AslTargetSystemFeaturesAndCoding$1
implements RtMethodListener {
    private final /* synthetic */ ConfigurationManagerDiag val$configManagerDiag;
    private final /* synthetic */ AslTargetSystemFeaturesAndCoding this$0;

    AslTargetSystemFeaturesAndCoding$1(AslTargetSystemFeaturesAndCoding aslTargetSystemFeaturesAndCoding, ConfigurationManagerDiag configurationManagerDiag) {
        this.this$0 = aslTargetSystemFeaturesAndCoding;
        this.val$configManagerDiag = configurationManagerDiag;
    }

    @Override
    public void onRtMethodValueChanged(String string) {
        if (!"ASL.Configuration.isIntPhoneAvailable".equals(string)) {
            return;
        }
        boolean bl = this.val$configManagerDiag.isFeatureFlagSet(73);
        this.this$0.updateInternalPhoneAvailablility(bl);
    }
}

