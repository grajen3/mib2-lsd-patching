/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.globalsetupwizard;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.globalsetupwizard.wizard.WizardService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardPersistenceService;
import de.vw.mib.asl.internal.globalsetupwizard.GlobalSetupWizardServices;
import de.vw.mib.asl.internal.impl.globalsetupwizard.AbstractGlobalSetupWizardTarget;
import de.vw.mib.asl.internal.impl.globalsetupwizard.GlobalSetupWizardPersistence;
import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageDescriptor;
import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageManager$1;
import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageManager$2;
import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageManager$3;
import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageManager$4;
import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageManager$5;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.globalsetupwizard.GlobalWizardPage;
import de.vw.mib.log4mib.Logger;

public class WizardPageManager
extends AbstractGlobalSetupWizardTarget
implements WizardService {
    private static final String LOGGING_PREFIX;
    private static final boolean SUCCESSFUL_TRANSITION;
    private static final int START_PAGE;
    private static final String INTENT_GLOBAL_WIZARD_PAGE;
    private static final boolean PAGE_FINISHED;
    private static final String GLOBAL_WIZARD_PAGE;
    GlobalSetupWizardPersistence wizardPersistence;
    final CioDictionary cioDictionary;
    final CioFactory cioFactory;
    final CioDispatcher cioDispatcher;
    private final GlobalSetupWizardServices services;
    private final GlobalSetupWizardPersistenceService globalSetupWirzadPersistenceService;
    private final ASLPropertyManager propertyManager;
    private final ASLListManager listManager;
    private final FactoryResetService factoryResetService;
    private final StartupStateService startupStateService;
    private final SystemStateService systemStateService;
    private final Logger logger;
    private int currentMode = 0;
    private CioIntent[] wizardPages;
    private int currentPage;
    private boolean isClampState15Active;
    private String lastContent = "HMI_RADIO";

    public WizardPageManager(GlobalSetupWizardServices globalSetupWizardServices) {
        super(globalSetupWizardServices.getGenericEvents(), globalSetupWizardServices.getLogger(), -2079122432);
        this.services = globalSetupWizardServices;
        this.propertyManager = globalSetupWizardServices.getAslPropertyManager();
        this.listManager = globalSetupWizardServices.getListManager();
        this.cioDictionary = globalSetupWizardServices.getCioDictionary();
        this.cioFactory = globalSetupWizardServices.getCioFactory();
        this.cioDispatcher = globalSetupWizardServices.getCioDispatcher();
        this.factoryResetService = globalSetupWizardServices.getFactoryResetService();
        this.startupStateService = globalSetupWizardServices.getStartupStateService();
        this.systemStateService = globalSetupWizardServices.getSystemStateService();
        this.logger = globalSetupWizardServices.getLogger();
        this.globalSetupWirzadPersistenceService = globalSetupWizardServices.getGlobalSetupWirzadPersistenceService();
        this.wizardPersistence = new GlobalSetupWizardPersistence(globalSetupWizardServices);
        this.addObservers(globalSetupWizardServices.getServiceRegister());
        this.addCioRegistrationListener();
        this.registerFactoryResetParticipant();
        this.registerProfileChangeListener();
        this.registerStartupStateListener();
        this.retrievePages();
        this.setupGlobalWizard();
        this.updateModel();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 4300004: {
                this.isClampState15Active = eventGeneric.getBoolean(0);
                break;
            }
            case 1078941824: {
                this.activateToNextPage();
                this.updateModel();
                break;
            }
            case 1078941825: {
                this.activateToPreviousPage();
                this.updateModel();
                break;
            }
            case 1078941826: {
                long l = eventGeneric.getLong(0);
                this.activateCertainPage(l);
                this.updateModel();
                break;
            }
            case 1078941827: {
                this.showLastContent();
                break;
            }
            case 1078941828: {
                this.wizardPersistence.pagesDontShowAgain(true);
                this.showLastContent();
                break;
            }
            case 1078941829: {
                this.resetWizardState();
                this.updateModel();
                break;
            }
        }
    }

    @Override
    public void startWizard() {
        this.resetWizardState();
        this.updateModel();
        this.showWizard();
    }

    void retrievePages() {
        this.wizardPages = this.cioDictionary.getCioIntents("InitGlobalWizardPage");
        if (this.wizardPages == null) {
            this.wizardPages = new CioIntent[0];
        }
        this.updateProgressList();
    }

    void updateProgressList() {
        Object[] objectArray = this.convertToWizardPageDescriptors(this.wizardPages);
        this.listManager.getASLList(-1820373248).updateList(objectArray);
    }

    void processRevertWizardPages() {
        this.wizardPersistence.reset();
        this.initializationGlobalWizard();
    }

    void startGlobalWizardPages() {
        boolean bl;
        boolean bl2 = bl = this.wizardPersistence.isAllSettingsNotSuccessfulFinished() && !this.wizardPersistence.isDontShowAgain() && this.isClampState15Active;
        if (bl) {
            this.showWizard();
        }
    }

    void loadDataFromGlobalSetupWizardPersistence() {
        this.wizardPersistence = new GlobalSetupWizardPersistence(this.services);
        this.initializationGlobalWizard();
    }

    void addWizardPage(CioIntent cioIntent) {
        this.wizardPersistence.addPageIntent(cioIntent);
        this.initializePage(cioIntent);
    }

    boolean checkIsActivePage(CioIntent cioIntent) {
        boolean bl = this.currentMode == 1;
        boolean bl2 = this.wizardPages[this.currentPage] == cioIntent;
        return bl && bl2;
    }

    void activateToNextPage() {
        if (this.hasNextPage()) {
            this.prepareNextPage();
        } else {
            this.currentMode = 2;
        }
    }

    void updateModel() {
        this.propertyManager.valueChangedInteger(-1837150464, this.currentMode);
        if (this.currentMode == 1) {
            CioIntent cioIntent = this.wizardPages[this.currentPage];
            this.propertyManager.valueChangedLong(-1853927680, cioIntent.getCioIntentId());
            this.activateWizardPage(cioIntent);
        }
    }

    private void resetWizardState() {
        this.currentMode = 0;
        this.currentPage = 0;
    }

    private void initializePage(CioIntent cioIntent) {
        CioParametersCreator cioParametersCreator = this.cioFactory.createActionParameters(cioIntent);
        GlobalWizardPage globalWizardPage = this.createGlobalWizardPage(cioIntent);
        cioParametersCreator.setObject("globalWizardPage", globalWizardPage);
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.cioDispatcher.dispatch(cioIntent, cioActionParameters);
    }

    private GlobalWizardPage createGlobalWizardPage(CioIntent cioIntent) {
        Logger logger = this.logger;
        return new WizardPageManager$1(this, cioIntent, logger);
    }

    private void showLastContent() {
        CioIntent cioIntent = this.cioDictionary.getCioIntent("ShowContent", this.lastContent);
        this.cioDispatcher.dispatch(cioIntent);
    }

    private WizardPageDescriptor[] convertToWizardPageDescriptors(CioIntent[] cioIntentArray) {
        WizardPageDescriptor[] wizardPageDescriptorArray = new WizardPageDescriptor[cioIntentArray.length];
        for (int i2 = 0; i2 < wizardPageDescriptorArray.length; ++i2) {
            CioIntent cioIntent = cioIntentArray[i2];
            boolean bl = this.wizardPersistence.isPageFinished(cioIntent.getCioIntentId());
            wizardPageDescriptorArray[i2] = new WizardPageDescriptor(cioIntent, bl);
        }
        return wizardPageDescriptorArray;
    }

    private void initializationGlobalWizard() {
        this.resetCurrentPageAndMode();
        this.retrievePages();
        this.setupGlobalWizard();
        this.updateModel();
        this.startGlobalWizardPages();
    }

    private void resetCurrentPageAndMode() {
        this.currentMode = 0;
        this.currentPage = 0;
    }

    void showWizard() {
        this.lastContent = this.systemStateService.getCurrentLastContentId();
        CioIntent cioIntent = this.cioDictionary.getCioIntent("ShowContent", "HMI_GLOBAL_SETUP_WIZARD");
        this.cioDispatcher.dispatch(cioIntent);
    }

    private void setupGlobalWizard() {
        for (int i2 = 0; i2 < this.wizardPages.length; ++i2) {
            CioIntent cioIntent = this.wizardPages[i2];
            this.addWizardPage(cioIntent);
        }
    }

    private void addObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(-2141696192, this.getTargetId());
        serviceRegister.addObserver(-2124918976, this.getTargetId());
        serviceRegister.addObserver(-2108141760, this.getTargetId());
        serviceRegister.addObserver(-2091364544, this.getTargetId());
        serviceRegister.addObserver(-2074587328, this.getTargetId());
        serviceRegister.addObserver(-2057810112, this.getTargetId());
        serviceRegister.addObserver(-459521792, this.getTargetId());
    }

    void activateCertainPage(long l) {
        boolean bl = false;
        for (int i2 = 0; i2 < this.wizardPages.length && !bl; ++i2) {
            if (this.wizardPages[i2].getCioIntentId() == l) {
                bl = true;
                this.currentPage = i2;
            }
            this.currentMode = 1;
        }
    }

    private void prepareNextPage() {
        if (this.currentPage + 1 < this.wizardPages.length || this.wizardPages.length == 1 && this.currentPage == 0) {
            if (this.currentMode == 0) {
                this.currentPage = 0;
                this.goToNextUnfinishedPage();
            } else {
                ++this.currentPage;
                this.currentMode = 1;
            }
        }
    }

    private void goToNextUnfinishedPage() {
        for (int i2 = this.currentPage; i2 < this.wizardPages.length; ++i2) {
            long l = this.wizardPages[i2].getCioIntentId();
            if (!this.wizardPersistence.isPageFinished(l)) {
                this.currentPage = i2;
                this.currentMode = 1;
                return;
            }
            this.currentMode = 2;
        }
    }

    private boolean hasNextPage() {
        return this.currentMode == 0 && this.wizardPages.length != 0 || this.wizardPages.length > this.currentPage + 1;
    }

    private void activateToPreviousPage() {
        if (this.hasPreviousPage()) {
            this.preparePreviousPage();
        } else {
            this.currentMode = 0;
        }
    }

    private void preparePreviousPage() {
        if (this.currentPage > 0) {
            --this.currentPage;
            this.currentMode = 1;
        } else if (this.currentPage == 0 && this.currentMode == 2) {
            this.currentPage = this.wizardPages.length - 1;
            this.currentMode = 1;
        }
    }

    private boolean hasPreviousPage() {
        return this.currentMode == 2 && this.wizardPages.length != 0 || this.currentPage > 0;
    }

    private void activateWizardPage(CioIntent cioIntent) {
        CioIntent cioIntent2 = this.cioDictionary.getCioIntent("BindHostedApp", cioIntent);
        CioParametersCreator cioParametersCreator = this.cioFactory.createActionParameters(cioIntent2);
        cioParametersCreator.setString("hostAppName", "GlobalSetupWizard");
        cioParametersCreator.setString("hostAppInstanceName", "GlobalSetupWizard");
        cioParametersCreator.setString("hostAppScreenArea", "ScreenArea");
        cioParametersCreator.setString("hostedAppLayerLabel", "Main");
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.cioDispatcher.dispatch(cioIntent2, cioActionParameters);
    }

    private void registerProfileChangeListener() {
        WizardPageManager$2 wizardPageManager$2 = new WizardPageManager$2(this);
        this.globalSetupWirzadPersistenceService.addProfileChangeListener(wizardPageManager$2);
    }

    private void registerFactoryResetParticipant() {
        WizardPageManager$3 wizardPageManager$3 = new WizardPageManager$3(this);
        this.factoryResetService.addParticipant(wizardPageManager$3, FactoryResetComponents.SYSTEM);
        this.factoryResetService.addParticipant(wizardPageManager$3, FactoryResetComponents.FULL);
    }

    private void registerStartupStateListener() {
        WizardPageManager$4 wizardPageManager$4 = new WizardPageManager$4(this);
        this.startupStateService.addListener(wizardPageManager$4);
    }

    private void addCioRegistrationListener() {
        this.cioDictionary.addCioRegistrationListener("InitGlobalWizardPage", new WizardPageManager$5(this));
    }
}

