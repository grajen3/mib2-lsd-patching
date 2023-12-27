/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.DriverDistractionPreventionService;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.impl.system.ddp.DdpFunctionBlockingListener;
import de.vw.mib.asl.internal.impl.system.ddp.FunctionBlockingInfo;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.log4mib.Logger;
import java.util.List;

public class DdpFunctionBlockingListenerInstaller {
    private final Logger logger;
    private final ConfigurationManagerDiag configurationManagerDiag;
    private final ASLPropertyManager aslPropertyManager;
    private final DriverDistractionPreventionService ddpService;
    static /* synthetic */ Class class$de$vw$mib$log4mib$Logger;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManagerDiag;
    static /* synthetic */ Class class$de$vw$mib$asl$ASLPropertyManager;
    static /* synthetic */ Class class$de$vw$mib$asl$api$system$DriverDistractionPreventionService;

    public DdpFunctionBlockingListenerInstaller(Logger logger, ConfigurationManagerDiag configurationManagerDiag, ASLPropertyManager aSLPropertyManager, DriverDistractionPreventionService driverDistractionPreventionService) {
        Preconditions.checkArgumentNotNull(logger, new StringBuffer().append("Incoming ").append((class$de$vw$mib$log4mib$Logger == null ? (class$de$vw$mib$log4mib$Logger = DdpFunctionBlockingListenerInstaller.class$("de.vw.mib.log4mib.Logger")) : class$de$vw$mib$log4mib$Logger).getName()).append(" must not be null!").toString());
        Preconditions.checkArgumentNotNull(configurationManagerDiag, new StringBuffer().append("Incoming ").append((class$de$vw$mib$configuration$ConfigurationManagerDiag == null ? (class$de$vw$mib$configuration$ConfigurationManagerDiag = DdpFunctionBlockingListenerInstaller.class$("de.vw.mib.configuration.ConfigurationManagerDiag")) : class$de$vw$mib$configuration$ConfigurationManagerDiag).getName()).append(" must not be null!").toString());
        Preconditions.checkArgumentNotNull(aSLPropertyManager, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$ASLPropertyManager == null ? (class$de$vw$mib$asl$ASLPropertyManager = DdpFunctionBlockingListenerInstaller.class$("de.vw.mib.asl.ASLPropertyManager")) : class$de$vw$mib$asl$ASLPropertyManager).getName()).append(" must not be null!").toString());
        Preconditions.checkArgumentNotNull(driverDistractionPreventionService, new StringBuffer().append("Incoming ").append((class$de$vw$mib$asl$api$system$DriverDistractionPreventionService == null ? (class$de$vw$mib$asl$api$system$DriverDistractionPreventionService = DdpFunctionBlockingListenerInstaller.class$("de.vw.mib.asl.api.system.DriverDistractionPreventionService")) : class$de$vw$mib$asl$api$system$DriverDistractionPreventionService).getName()).append(" must not be null!").toString());
        this.logger = logger;
        this.configurationManagerDiag = configurationManagerDiag;
        this.aslPropertyManager = aSLPropertyManager;
        this.ddpService = driverDistractionPreventionService;
    }

    public void install(Access access, List list) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            FunctionBlockingInfo functionBlockingInfo = (FunctionBlockingInfo)list.get(i2);
            this.install(access, functionBlockingInfo);
        }
    }

    private void install(Access access, FunctionBlockingInfo functionBlockingInfo) {
        String string = new StringBuffer().append("Diagnosis for ").append(functionBlockingInfo.getName()).append("=").append(functionBlockingInfo.getConfigurationManagerRtMethodName()).toString();
        if (access.contains(functionBlockingInfo.getDiagnosisBitId()) && access.getValue(functionBlockingInfo.getDiagnosisBitId()) == 1) {
            this.ddpService.addDriverDistractionPreventionListener(new DdpFunctionBlockingListener(this.configurationManagerDiag, this.aslPropertyManager, functionBlockingInfo.getConfigurationManagerRtMethodName(), functionBlockingInfo.getAslPropertyManagerId()));
            string = string.concat(" coded, listener registered with DDP service.");
        } else {
            string = string.concat(" NOT coded (not contained or coded as false), NO listener registered with DDP service.");
        }
        this.logger.info(2048, string);
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

