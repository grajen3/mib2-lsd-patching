/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.workunits;

import de.vw.mib.asl.api.phone.PhoneConstants;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.startupv7r.AslTargetStartup;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.StartupSummarizer;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.model.FeatureFlagDefinition;
import de.vw.mib.asl.framework.internal.startupv7r.operation.LoadPersistenceOperation;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartASLTargetsOperation;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartAslComponentOperation;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartDomainsOperation;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartDsisOperation;
import de.vw.mib.asl.framework.internal.startupv7r.restart.RestartHandler;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.AbstractStartupWorkUnitController;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.ContextInformationWorkUnit$1;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.ContextInformationWorkUnit$2;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.ContextInformationWorkUnit$3;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.ContextInformationWorkUnit$4;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.ContextInformationWorkUnit$5;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContextInformationWorkUnit
extends AbstractStartupWorkUnitController {
    private final boolean browserConditionWasHandledAlready;
    private final StartupServices startupServices;
    private final ConfigurationManagerDiag configurationManagerDiag;
    private final StartAslComponentOperation startAslComponentOperation;
    private final LoadPersistenceOperation loadPersistenceOperation;
    private final StartupSummarizer startupSummarizer;
    private final ContextWorkUnit model;
    private int[] internalWorkStates;
    private int currentInternalWorkStateIndex;
    private boolean thisWorkUnitWasStartedCompletely;
    private boolean entryConditionWasAlreadyEvaluatedAndHandled;
    private boolean persistenceWasLoaded = true;
    private boolean aslTargetStartWaitsForPersistence = false;
    private boolean evaluatedFeatureFlag;
    private StartDsisOperation startDsiOperation;
    private StartupEventDispatcher startupEventDispatcher;

    public ContextInformationWorkUnit(StartupServices startupServices, ContextWorkUnit contextWorkUnit, StartupSummarizer startupSummarizer) {
        super(startupServices.getLogger());
        this.browserConditionWasHandledAlready = false;
        this.model = contextWorkUnit;
        this.startupSummarizer = startupSummarizer;
        this.currentInternalWorkStateIndex = -1;
        this.startupServices = startupServices;
        this.configurationManagerDiag = startupServices.getConfigurationManagerDiag();
        this.startupEventDispatcher = startupServices.getStartupEventDispatcher();
        this.startAslComponentOperation = new StartAslComponentOperation(startupServices, contextWorkUnit);
        this.loadPersistenceOperation = new LoadPersistenceOperation(startupServices, contextWorkUnit.getPersistenceIdsForContext());
        this.buildInternalWorkStates(contextWorkUnit);
    }

    public static final int[] increaseIntegerArray(int[] nArray, int n) {
        if (n < 1) {
            return nArray;
        }
        return Arrays.copyOf(nArray, nArray.length + n);
    }

    public static final int[] increaseIntegerArrayByOneWithValue(int[] nArray, int n) {
        nArray = ContextInformationWorkUnit.increaseIntegerArray(nArray, 1);
        nArray[nArray.length - 1] = n;
        return nArray;
    }

    void doNextWorkStepLocal() {
        AbstractWorkUnit abstractWorkUnit = this.getModel();
        if (!this.thisWorkUnitWasStartedCompletely && abstractWorkUnit.hasValidFeatureFlag()) {
            this.processFeatureFlag(abstractWorkUnit);
        }
        if (!this.thisWorkUnitWasStartedCompletely) {
            if (!this.evaluateEntryConditions()) {
                this.trace(new StringBuffer().append(this.model.getName()).append(" missed its entry conditions").toString());
                this.startNextWorkUnit();
            }
            ++this.currentInternalWorkStateIndex;
            if (this.currentInternalWorkStateIndex >= this.internalWorkStates.length) {
                this.thisWorkUnitWasStartedCompletely = true;
                this.trace(new StringBuffer().append(this.model.getName()).append(" is finished now, moving on...").toString());
                this.startNextWorkUnit();
                return;
            }
            switch (this.internalWorkStates[this.currentInternalWorkStateIndex]) {
                case 0: {
                    this.trace(new StringBuffer().append(this.model.getName()).append(" is checking preconditions...").toString());
                    this.doNextWorkStepLocal();
                    break;
                }
                case 1: {
                    this.trace(new StringBuffer().append(this.model.getName()).append(" is starting asl components").toString());
                    this.startAslComponentOperation.run(new ContextInformationWorkUnit$1(this));
                    break;
                }
                case 2: {
                    this.trace(new StringBuffer().append(this.model.getName()).append(" is starting persistencies").toString());
                    this.loadPersistenceOperation.run(new ContextInformationWorkUnit$2(this));
                    this.doNextWorkStepLocal();
                    break;
                }
                case 3: {
                    this.trace(new StringBuffer().append(this.model.getName()).append(" is starting Domain").toString());
                    new StartDomainsOperation(this.startupServices, this.model.getDomainToStart(), this.model.getDomainStateToReach()).run(new ContextInformationWorkUnit$3(this));
                    break;
                }
                case 4: {
                    this.trace(new StringBuffer().append(this.model.getName()).append(" is starting DSIs").toString());
                    this.startDSIs();
                    break;
                }
                case 5: {
                    if (this.model.getPersistenceIdsForContext() != null && this.model.getPersistenceIdsForContext().length != 0) {
                        this.persistenceWasLoaded = this.checkPersistenceWasLoaded();
                    }
                    if (this.persistenceWasLoaded) {
                        this.trace(new StringBuffer().append(this.model.getName()).append(" is starting ASLs").toString());
                        this.startAslTargets();
                        break;
                    }
                    this.trace(new StringBuffer().append(this.model.getName()).append(" is waiting for persistence to start ASLs").toString());
                    this.aslTargetStartWaitsForPersistence = true;
                    break;
                }
                case 6: {
                    this.trace(new StringBuffer().append(this.model.getName()).append(" is updating its hmi-domain-state").toString());
                    AslTargetStartup.aslTargetStartupInstance.updateStateToHmi(this.model.getListenerConstantForUpdateToHmi());
                    this.doNextWorkStep();
                    break;
                }
            }
        } else {
            this.trace(new StringBuffer().append(this.model.getName()).append(" is finished already (or was skipped), moving on...").toString());
            this.startNextWorkUnit();
        }
    }

    private void startNextWorkUnit() {
        if ((this.model.getBitmaskToCheckForSpecialExitConditions() & 0x40) != 0) {
            this.trace("sending LUM Ready Event");
            this.startupEventDispatcher.createAndSubmitStartupEvent(3);
        }
        this.finish();
    }

    private boolean checkPersistenceWasLoaded() {
        boolean bl = true;
        for (int i2 = 0; i2 < this.model.getPersistenceIdsForContext().length; ++i2) {
            int n = this.loadPersistenceOperation.getPersistenciesLoadStatusMap().get(this.model.getPersistenceIdsForContext()[i2]);
            super.getClass();
            if (n == 2) continue;
            bl = false;
            break;
        }
        return bl;
    }

    private void processFeatureFlag(AbstractWorkUnit abstractWorkUnit) {
        if (this.evaluatedFeatureFlag) {
            return;
        }
        this.evaluatedFeatureFlag = true;
        int n = abstractWorkUnit.getFeatureFlag();
        boolean bl = this.configurationManagerDiag.isFeatureFlagSet(n);
        if (!bl) {
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("featureFlag ").append(n).append(" is disabled, skip this work unit.").toString());
        } else {
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("featureFlag ").append(n).append(" is enabled, start this work unit.").toString());
        }
        if (this.getLogger().isTraceEnabled(1)) {
            FeatureFlagDefinition featureFlagDefinition = new FeatureFlagDefinition();
            String string = (String)featureFlagDefinition.getDeclaredFeatureFlags().get(n);
            if (!bl) {
                this.trace(new StringBuffer().append("featureFlag ").append(n).append(" (").append(string).append(") is disabled, skip this work unit.").toString());
            } else {
                this.trace(new StringBuffer().append("featureFlag ").append(n).append(" (").append(string).append(") is enabled, start this work unit.").toString());
            }
        }
    }

    public boolean wasCompletelyStartedAlready() {
        return this.thisWorkUnitWasStartedCompletely;
    }

    public AbstractWorkUnit[] getPreconditionWorkUnit() {
        return this.model.getPreconditions();
    }

    public String getName() {
        return this.model.getName();
    }

    private void buildInternalWorkStates(ContextWorkUnit contextWorkUnit) {
        int[] nArray = new int[]{0};
        if (contextWorkUnit.getAslComponentQualifiedNames().length > 0) {
            nArray = ContextInformationWorkUnit.increaseIntegerArrayByOneWithValue(nArray, 1);
        }
        if (contextWorkUnit.getPersistenceIdsForContext().length > 0) {
            nArray = ContextInformationWorkUnit.increaseIntegerArrayByOneWithValue(nArray, 2);
            this.persistenceWasLoaded = false;
        } else {
            this.persistenceWasLoaded = true;
        }
        if (contextWorkUnit.getDomainToStart().length > 0) {
            nArray = ContextInformationWorkUnit.increaseIntegerArrayByOneWithValue(nArray, 3);
        }
        if (contextWorkUnit.getDsiInterfacesToStart().length > 0 || (contextWorkUnit.getBitmaskToCheckForSpecialEntryConditions() & 0x10) != 0) {
            nArray = ContextInformationWorkUnit.increaseIntegerArrayByOneWithValue(nArray, 4);
        }
        nArray = ContextInformationWorkUnit.increaseIntegerArrayByOneWithValue(nArray, 5);
        if (contextWorkUnit.getListenerConstantForUpdateToHmi() != 0) {
            nArray = ContextInformationWorkUnit.increaseIntegerArrayByOneWithValue(nArray, 6);
        }
        this.internalWorkStates = nArray;
    }

    private void evaluateExitConditionForNormalOrder() {
        if ((this.model.getBitmaskToCheckForSpecialExitConditions() & 0x40) != 0) {
            this.trace("sending LUM Ready Event");
            this.startupEventDispatcher.createAndSubmitStartupEvent(3);
        }
        this.finish();
    }

    private boolean evaluateEntryConditions() {
        int n;
        if (this.entryConditionWasAlreadyEvaluatedAndHandled) {
            return true;
        }
        this.entryConditionWasAlreadyEvaluatedAndHandled = true;
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x200) != 0) {
            this.model.setPreconditions(null);
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("Storing for Restart purposes: ").append(this.model.getName()).toString());
            this.currentInternalWorkStateIndex = 7;
            this.model.setBitmaskToCheckForSpecialEntryConditions(this.model.getBitmaskToCheckForSpecialEntryConditions() & 0xFFFFFDFF);
            RestartHandler.RESTART_EXLAP.installStartupWorkUnit(this);
            return true;
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x100) != 0) {
            this.model.setPreconditions(null);
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("Storing for Restart purposes: ").append(this.model.getName()).toString());
            this.currentInternalWorkStateIndex = 7;
            this.model.setBitmaskToCheckForSpecialEntryConditions(this.model.getBitmaskToCheckForSpecialEntryConditions() & 0xFFFFFEFF);
            RestartHandler.RESTART_GEMMI.installStartupWorkUnit(this);
            return true;
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x80800000) == -2139095040) {
            this.model.setPreconditions(null);
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("## Storing for Restart purposes: ").append(this.model.getName()).toString());
            this.currentInternalWorkStateIndex = 7;
            this.model.setBitmaskToCheckForSpecialEntryConditions(this.model.getBitmaskToCheckForSpecialEntryConditions() & 0xFF7FFFFF);
            RestartHandler.RESTART_NAV_WITH_KOMONAV.installStartupWorkUnit(this);
            return true;
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x820000) == 0x820000) {
            this.model.setPreconditions(null);
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("Storing for Restart purposes: ").append(this.model.getName()).toString());
            this.currentInternalWorkStateIndex = 7;
            this.model.setBitmaskToCheckForSpecialEntryConditions(this.model.getBitmaskToCheckForSpecialEntryConditions() & 0xFF7FFFFF);
            RestartHandler.RESTART_NAV_WITH_SPLITSCREEN.installStartupWorkUnit(this);
            return true;
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x4000) != 0) {
            this.model.setPreconditions(null);
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("Storing for Restart purposes: ").append(this.model.getName()).toString());
            this.currentInternalWorkStateIndex = 7;
            this.model.setBitmaskToCheckForSpecialEntryConditions(this.model.getBitmaskToCheckForSpecialEntryConditions() & 0xFFFFBFFF);
            RestartHandler.RESTART_SPEECH.installStartupWorkUnit(this);
            return true;
        }
        if (StartupServiceManager.swdlPowerstateDetected && (this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x1000) == 0) {
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("skipped: ").append(this.model.getName()).append(", Cause: not used in SWDL").toString());
            this.internalWorkStates = new int[]{0};
            return true;
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 1) != 0 && !this.configurationManagerDiag.isFeatureFlagSet(400)) {
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("skipped: ").append(this.model.getName()).append(", Cause: not coded").toString());
            this.trace("Testmode skipped, cause not coded");
            this.internalWorkStates = new int[]{0};
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 8) != 0 && !this.configurationManagerDiag.isFeatureFlagSet(184)) {
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("skipped: ").append(this.model.getName()).append("(OnlineService), Cause: not coded").toString());
            this.trace("OnlineServices skipped, cause not coded");
            this.internalWorkStates = new int[]{0};
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 2) != 0) {
            // empty if block
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x10) != 0) {
            this.model.setDsiInterfacesToStart(PhoneConstants.NEEDED_PHONE_DSI_IDS);
            this.model.setDsiDoNotWaitFlags(new boolean[this.model.getDsiInterfacesToStart().length]);
            for (n = 0; n < this.model.getDomainToStart().length; ++n) {
                if (this.model.getDomainToStart()[n] != 5) continue;
                this.model.getDomainStateToReach()[0] = StartupServiceManager.getSupplier() == 1 ? PhoneConstants.DOMAIN_RUN_LEVEL : 8;
            }
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x20) != 0 && !this.configurationManagerDiag.isFeatureFlagSet(48)) {
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("skipped: ").append(this.model.getName()).append(", Cause: not coded").toString());
            this.trace("Addtional Browser Instance skipped, cause FEAT_IS_COVER_FLOW not coded");
            this.internalWorkStates = new int[]{0};
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x40) != 0) {
            if (!(ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV() || ASLSystemFactory.getSystemApi().getFeatureFlagValuePHEV() || this.configurationManagerDiag.isFeatureFlagSet(394))) {
                this.thisWorkUnitWasStartedCompletely = true;
                this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("skipped: ").append(this.model.getName()).append(", Cause: no BEV/PHEV detected").toString());
                this.trace(new StringBuffer().append("BEV/PHEV skipped, cause not detected (Combustion only): ").append(this.model.getName()).toString());
                this.internalWorkStates = new int[]{0};
            } else {
                this.startupSummarizer.logAdditionalMessage(this.getModel(), "BEV/PHEV was detected");
            }
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x100) != 0 && !this.configurationManagerDiag.isFeatureFlagSet(425)) {
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("skipped: ").append(this.model.getName()).append(", Cause: no TV_TUNER coded").toString());
            this.trace(new StringBuffer().append("TV_TUNER skipped, cause not coded: ").append(this.model.getName()).toString());
            this.internalWorkStates = new int[]{0};
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x80) != 0 && !StartupServiceManager.komoNavIsAllowedByCoding) {
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("skipped: ").append(this.model.getName()).append(", Cause: no KOMO/FPK coded").toString());
            this.internalWorkStates = new int[]{0};
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x200) != 0 && StartupServiceManager.komoNavIsAllowedByCoding) {
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("skipped: ").append(this.model.getName()).append(", Cause: KOMO/FPK coded").toString());
            this.internalWorkStates = new int[]{0};
        }
        if (!((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x400) == 0 || this.configurationManagerDiag.isFeatureFlagSet(191) && this.configurationManagerDiag.isFeatureFlagSet(432))) {
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("skipped: ").append(this.model.getName()).append(", Cause: Online Personal POIs not allowed").toString());
            this.internalWorkStates = new int[]{0};
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x800) != 0) {
            int n2 = n = !this.configurationManagerDiag.isFeatureFlagSet(184) ? 1 : 0;
            if (n != 0) {
                this.thisWorkUnitWasStartedCompletely = true;
                this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("skipped: ").append(this.model.getName()).append(", Cause: Online Core Services not allowed").toString());
                this.internalWorkStates = new int[]{0};
            }
        }
        if ((this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x2000) != 0 && !StartupServiceManager.pictureServerStartAllowed) {
            this.thisWorkUnitWasStartedCompletely = true;
            this.startupSummarizer.logAdditionalMessage(this.getModel(), new StringBuffer().append("skipped: ").append(this.model.getName()).append(", Cause: MOST Services not coded").toString());
            this.internalWorkStates = new int[]{0};
        }
        this.startupServices.getEntryConditionService().applyEntryConditions(this.model);
        return true;
    }

    public void setPersistenceReady() {
        this.persistenceWasLoaded = true;
        if (this.aslTargetStartWaitsForPersistence) {
            this.trace(new StringBuffer().append(this.model.getName()).append(" is starting ASLs as persistence is now ready").toString());
            this.startAslTargets();
        }
    }

    private void startAslTargets() {
        List list = Collections.EMPTY_LIST;
        if (this.startDsiOperation != null) {
            list = this.startDsiOperation.getFailedDsis();
        }
        new StartASLTargetsOperation(this.startupServices, this.model.getAslTargetsToStart(), list).run(new ContextInformationWorkUnit$4(this));
    }

    public void doNextWorkStepAfterASLCallback() {
        if (this.internalWorkStates[this.currentInternalWorkStateIndex] == 5) {
            this.doNextWorkStepLocal();
        } else {
            this.warn("ASLCallback received out-of-ASLPhase, this should not happen");
        }
    }

    public void doNextWorkStepAfterDSICallback() {
        if (this.internalWorkStates[this.currentInternalWorkStateIndex] == 4) {
            this.doNextWorkStepLocal();
        } else {
            this.warn("DSICallback received out-of-DSIPhase, this should not happen");
        }
    }

    public void doNextWorkStepAfterDomainCallback() {
        if (this.internalWorkStates[this.currentInternalWorkStateIndex] == 3) {
            this.doNextWorkStepLocal();
        } else {
            this.warn("domainCallback received out-of-DomainPhase, this should happen only directly after startup begin");
        }
    }

    public void doNextWorkStep() {
        if (this.currentInternalWorkStateIndex > this.internalWorkStates.length) {
            this.currentInternalWorkStateIndex = this.internalWorkStates.length;
        }
        if (this.currentInternalWorkStateIndex == -1 || this.currentInternalWorkStateIndex == this.internalWorkStates.length || this.internalWorkStates[this.currentInternalWorkStateIndex] == 0 || this.internalWorkStates[this.currentInternalWorkStateIndex] == 6) {
            this.doNextWorkStepLocal();
        }
    }

    public void resetThisWorkUnitForReuseDuringRun() {
        this.currentInternalWorkStateIndex = -1;
        this.thisWorkUnitWasStartedCompletely = false;
        this.entryConditionWasAlreadyEvaluatedAndHandled = false;
        this.persistenceWasLoaded = true;
        this.aslTargetStartWaitsForPersistence = false;
    }

    public String getWorkstepForDebugging() {
        switch (this.internalWorkStates[this.currentInternalWorkStateIndex]) {
            case -1: {
                return "STARTUP_STEP_INIT";
            }
            case 0: {
                return "STARTUP_STEP_0_CHECK_PRECEDING_WORK_UNITS";
            }
            case 1: {
                return "STARTUP_STEP_1_ASL_COMPONENTS";
            }
            case 2: {
                return "STARTUP_STEP_2_PERSISTENCE";
            }
            case 3: {
                return "STARTUP_STEP_3_DOMAIN";
            }
            case 4: {
                return "STARTUP_STEP_4_DSI";
            }
            case 5: {
                return "STARTUP_STEP_5_ASL";
            }
            case 6: {
                return "STARTUP_STEP_6_UPDATE_TO_HMI";
            }
        }
        return "N/A - Error";
    }

    @Override
    public AbstractWorkUnit getModel() {
        return this.model;
    }

    private void startDSIs() {
        boolean bl = (this.model.getBitmaskToCheckForSpecialEntryConditions() & 0x10) != 0;
        this.startDsiOperation = new StartDsisOperation(this.startupServices, this.model.getDsiInterfacesToStart(), this.model.getDsiDoNotWaitFlags(), bl);
        this.startDsiOperation.run(new ContextInformationWorkUnit$5(this));
    }

    @Override
    public void runTask() {
        this.doNextWorkStep();
    }
}

