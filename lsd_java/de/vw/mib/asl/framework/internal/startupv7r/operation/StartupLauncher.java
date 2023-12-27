/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.StartupSummarizer;
import de.vw.mib.asl.framework.internal.startupv7r.StartupVariantDefinitionBuilder;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.ASLStartupv7rAPIImpl;
import de.vw.mib.asl.framework.internal.startupv7r.dynamic.DynamicWorkUnitStarterImpl;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.LastUserModeMapping;
import de.vw.mib.asl.framework.internal.startupv7r.model.WorkUnitModelUtil;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartupLauncher$1;
import de.vw.mib.asl.framework.internal.startupv7r.operation.TaskPool;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitQueue;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarter;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarter$WorkUnitStarterBuilder;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.SendLumReadyOperation;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.StartupAnimationSendLumReadyOperation;
import de.vw.mib.asl.framework.internal.startupv7r.prioritizer.ContentChangePrioritizer;
import de.vw.mib.asl.framework.internal.startupv7r.prioritizer.LastUserModePrioritizer;
import de.vw.mib.asl.framework.internal.startupv7r.restart.DomainRestartObservation;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.ControllerFactory;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.List;

public class StartupLauncher {
    private static final int TASK_POOL_COUNT = Integer.getInteger("de.vw.mib.startup.taskPoolCount", 1);
    private final StartupServices startupServices;

    public StartupLauncher(StartupServices startupServices) {
        this.startupServices = startupServices;
    }

    public void start() {
        StartupSummarizer startupSummarizer = new StartupSummarizer();
        ControllerFactory controllerFactory = new ControllerFactory(this.startupServices, startupSummarizer);
        int[] nArray = this.startupServices.getConfigurationManagerDiag().getStartupWorkUnitData();
        StartupVariantDefinitionBuilder startupVariantDefinitionBuilder = new StartupVariantDefinitionBuilder(this.startupServices);
        AbstractWorkUnit[] abstractWorkUnitArray = startupVariantDefinitionBuilder.buildStartupDefinitionFromStream(nArray);
        this.setupDynamicWorkUnitStarter(controllerFactory, abstractWorkUnitArray);
        List list = this.filterContextWorkUnits(abstractWorkUnitArray);
        this.startupServices.getDsiInformationService().extractVariantDsiNames(list);
        this.startupServices.getPersistenceInformationService().extractVariantPersistenceNamespaces(list);
        boolean bl = false;
        AbstractWorkUnit[] abstractWorkUnitArray2 = new WorkUnitModelUtil().findDynamicWorkUnits(abstractWorkUnitArray, bl);
        WorkUnitQueue workUnitQueue = new WorkUnitQueue(abstractWorkUnitArray2);
        TaskPool taskPool = new TaskPool(this.startupServices.getAsyncServiceFactory(), TASK_POOL_COUNT);
        WorkUnitStarter workUnitStarter = new WorkUnitStarter$WorkUnitStarterBuilder().controllerManager(controllerFactory).logger(this.startupServices.getLogger()).taskPool(taskPool).startupSummarizer(startupSummarizer).workUnitQueue(workUnitQueue).build();
        workUnitStarter.run(new StartupLauncher$1(this));
        ConfigurationManagerDiag configurationManagerDiag = this.startupServices.getConfigurationManagerDiag();
        Logger logger = this.startupServices.getLogger();
        LastUserModeMapping lastUserModeMapping = new LastUserModeMapping(configurationManagerDiag, logger, abstractWorkUnitArray);
        new LastUserModePrioritizer(this.startupServices, workUnitQueue, lastUserModeMapping).run();
        new ContentChangePrioritizer(this.startupServices, workUnitQueue, lastUserModeMapping).run();
        if (configurationManagerDiag.isFeatureFlagSet(381)) {
            new StartupAnimationSendLumReadyOperation(this.startupServices, workUnitStarter);
        } else {
            new SendLumReadyOperation(this.startupServices, lastUserModeMapping, workUnitStarter);
        }
        new DomainRestartObservation(this.startupServices).run();
    }

    private void setupDynamicWorkUnitStarter(ControllerFactory controllerFactory, AbstractWorkUnit[] abstractWorkUnitArray) {
        DynamicWorkUnitStarterImpl dynamicWorkUnitStarterImpl = new DynamicWorkUnitStarterImpl(controllerFactory, abstractWorkUnitArray);
        ((ASLStartupv7rAPIImpl)ASLStartupv7rFactory.getStartupv7rApi()).setDynamicWorkUnitStarter(dynamicWorkUnitStarterImpl);
    }

    private List filterContextWorkUnits(AbstractWorkUnit[] abstractWorkUnitArray) {
        ArrayList arrayList = new ArrayList();
        if (abstractWorkUnitArray == null || abstractWorkUnitArray.length == 0) {
            return arrayList;
        }
        for (int i2 = 0; i2 < abstractWorkUnitArray.length; ++i2) {
            AbstractWorkUnit abstractWorkUnit = abstractWorkUnitArray[i2];
            if (abstractWorkUnit == null || !(abstractWorkUnit instanceof ContextWorkUnit)) continue;
            ContextWorkUnit contextWorkUnit = (ContextWorkUnit)abstractWorkUnit;
            arrayList.add(contextWorkUnit);
        }
        return arrayList;
    }
}

