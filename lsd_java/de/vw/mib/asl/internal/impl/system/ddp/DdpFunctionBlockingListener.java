/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.configuration.ConfigurationManagerDiag;

public class DdpFunctionBlockingListener
implements DriverDistractionPreventionThresholdListener {
    private final ASLPropertyManager aslPropertyManager;
    private final ConfigurationManagerDiag configurationManagerDiag;
    private final String configManagerRtMethodName;
    private final int aslPropertyManagerId;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManagerDiag;
    static /* synthetic */ Class class$de$vw$mib$asl$ASLPropertyManager;

    public DdpFunctionBlockingListener(ConfigurationManagerDiag configurationManagerDiag, ASLPropertyManager aSLPropertyManager, String string, int n) {
        Preconditions.checkArgumentNotNull(configurationManagerDiag, new StringBuffer().append("Incoming ").append((class$de$vw$mib$configuration$ConfigurationManagerDiag == null ? (class$de$vw$mib$configuration$ConfigurationManagerDiag = DdpFunctionBlockingListener.class$("de.vw.mib.configuration.ConfigurationManagerDiag")) : class$de$vw$mib$configuration$ConfigurationManagerDiag).getName()).append(" must not be null!").toString());
        Preconditions.checkArgumentNotNull(aSLPropertyManager, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$ASLPropertyManager == null ? (class$de$vw$mib$asl$ASLPropertyManager = DdpFunctionBlockingListener.class$("de.vw.mib.asl.ASLPropertyManager")) : class$de$vw$mib$asl$ASLPropertyManager).getName()).append(" must not be null!").toString());
        this.aslPropertyManager = aSLPropertyManager;
        this.configurationManagerDiag = configurationManagerDiag;
        this.configManagerRtMethodName = string;
        this.aslPropertyManagerId = n;
    }

    @Override
    public void onDriverDistractionPreventionRequired(boolean bl) {
        this.aslPropertyManager.valueChangedBoolean(this.aslPropertyManagerId, bl);
        this.configurationManagerDiag.setFeatureFlagValue(this.configManagerRtMethodName, bl);
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

