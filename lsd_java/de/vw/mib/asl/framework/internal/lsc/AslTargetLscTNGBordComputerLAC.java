/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.framework.internal.impl.lsc.LscServicesProvider;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;
import de.vw.mib.asl.framework.internal.lsc.AutomaticLanguageModeInstaller;
import de.vw.mib.asl.framework.internal.lsc.LanguageHelper;
import de.vw.mib.asl.framework.internal.lsc.PersistableLsc;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class AslTargetLscTNGBordComputerLAC
extends AbstractASLTarget {
    private final boolean isPqVariantDetected = System.getProperty("de.vw.mib.asl.framework.internal.lsc.isPQVariant") != null;
    private DSICarTimeUnitsLanguage dsiCarTimeUnitsLanguage = null;
    private DSIListener carTimeUnitsLanguageListener;
    private final PersistableLsc persistableLsc = PersistableLsc.getInstance();
    private boolean powerIsOnSoEventHandlingIsAllowed = false;
    private boolean initialUpdateFromInstrumentClusterReceivedAlready = false;
    private String currentlyRequestedLanguage = "";
    private int currentTransactionId = -1;
    private int lastUpdateFromInstrumentCluster = -1;
    private boolean thisLACIsCurrentlyRegistered = false;
    private AutomaticLanguageModeInstaller lscAutomaticMode;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;

    public AslTargetLscTNGBordComputerLAC(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public AslTargetLscTNGBordComputerLAC(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5290;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                break;
            }
            case 106: {
                this.processAslEventPowerOn();
                break;
            }
            case 107: {
                this.processAslEventPowerOff();
                break;
            }
            case 40003: {
                this.processLscCommandOnNewLanguage(eventGeneric.getInt(0), eventGeneric.getString(1));
                break;
            }
            case 1075841824: {
                this.lscAutomaticMode.activateAutomaticLanguageMode(true);
                break;
            }
            case 1075841837: {
                this.lscAutomaticMode.activateAutomaticLanguageMode(false);
                break;
            }
        }
    }

    public void dsiCarTimeUnitsLanguageUpdateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
        CarViewOption carViewOption = unitmasterViewOptions.language;
        this.trace("LanguageViewOption: ", carViewOption.toString());
        if (carViewOption.state == 2) {
            if (carViewOption.reason != 0) {
                this.info("Language ViewOption was NORMAL_OPERATION, but reason was not NORMAL");
            }
            if (!this.thisLACIsCurrentlyRegistered) {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1083965440);
                eventGeneric.setInt(0, this.getTargetId());
                eventGeneric.setInt(1, 10);
                eventGeneric.setString(2, "NO_LANGUAGE");
                this.sendSafe(eventGeneric);
                this.thisLACIsCurrentlyRegistered = true;
            }
        } else if (this.thisLACIsCurrentlyRegistered) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1117519872);
            eventGeneric.setInt(0, this.getTargetId());
            eventGeneric.setInt(1, 10);
            this.sendSafe(eventGeneric);
            this.thisLACIsCurrentlyRegistered = false;
        }
    }

    public void dsiCarTimeUnitsLanguageUpdateMenuLanguage(int n, int n2) {
        if (n2 == 1) {
            if (this.isTraceEnabled()) {
                this.trace().append("Received new LANG from Instrument cluster: ").append(n).log();
            }
            this.lastUpdateFromInstrumentCluster = n;
            String string = LanguageHelper.getIsoCodeOfMenuLanguage(n);
            ServiceManager.aslPropertyManager.valueChangedString(0x33322000, string);
            if (!this.isPqVariantDetected) {
                if (!this.currentlyRequestedLanguage.equals("")) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("got Response for setMenuLanguage: ").append(n).log();
                    }
                    boolean bl = this.currentlyRequestedLanguage.equals(string);
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1151074304);
                    eventGeneric.setInt(0, this.currentTransactionId);
                    eventGeneric.setBoolean(1, bl);
                    eventGeneric.setString(2, string);
                    this.sendSafe(eventGeneric);
                    this.currentlyRequestedLanguage = "";
                    this.currentTransactionId = -1;
                } else {
                    if (this.isTraceEnabled()) {
                        this.trace().append("got Update from carTimeUnitsLanguage_updateMenuLanguage: ").append(n).log();
                    }
                    if (n != LanguageHelper.getMenuLanguage(ServiceManager.configManagerDiag.getCurrentGuiLanguage()) && AslTargetLscTNGBullhorn.initialLscWasSent && !LanguageHelper.generalLanguageSkinChangeIsPending) {
                        if (this.isTraceEnabled()) {
                            this.trace("MODE 1");
                        }
                        if (this.persistableLsc.containsValidLscData()) {
                            this.dsiCarTimeUnitsLanguage.setMenuLanguage(LanguageHelper.getMenuLanguage(this.persistableLsc.getPersistantLanguage()));
                        } else {
                            this.dsiCarTimeUnitsLanguage.setMenuLanguage(LanguageHelper.getMenuLanguageOfLanguageIndex(this.lscAutomaticMode.getPersistableData().getLastActiveLanguagePrefetch()));
                        }
                    } else if (!this.initialUpdateFromInstrumentClusterReceivedAlready) {
                        if (this.isTraceEnabled()) {
                            this.trace("MODE 2");
                        }
                        this.initialUpdateFromInstrumentClusterReceivedAlready = true;
                        if (LanguageHelper.initialGuiLscDoneSoCorrectLanguageIsSetInGui) {
                            LanguageHelper.lastRequestedLanguageForInstrumentCluster = ServiceManager.configManagerDiag.getCurrentGuiLanguage();
                            this.dsiCarTimeUnitsLanguage.setMenuLanguage(LanguageHelper.getMenuLanguage(ServiceManager.configManagerDiag.getCurrentGuiLanguage()));
                        } else {
                            LanguageHelper.lastRequestedLanguageForInstrumentCluster = LanguageHelper.getIsoCodeOfLanguageIndex(this.lscAutomaticMode.getPersistableData().getLastActiveLanguagePrefetch());
                            this.dsiCarTimeUnitsLanguage.setMenuLanguage(LanguageHelper.getMenuLanguageOfLanguageIndex(this.lscAutomaticMode.getPersistableData().getLastActiveLanguagePrefetch()));
                        }
                    } else if (!LanguageHelper.lastRequestedLanguageForInstrumentCluster.equals("") && n != LanguageHelper.getMenuLanguage(LanguageHelper.lastRequestedLanguageForInstrumentCluster)) {
                        if (this.isTraceEnabled()) {
                            this.trace("MODE 3");
                        }
                        this.dsiCarTimeUnitsLanguage.setMenuLanguage(LanguageHelper.getMenuLanguage(LanguageHelper.lastRequestedLanguageForInstrumentCluster));
                    } else if (LanguageHelper.lastRequestedLanguageForInstrumentCluster.equals("") && n != LanguageHelper.getMenuLanguage(ServiceManager.configManagerDiag.getCurrentGuiLanguage())) {
                        if (this.isTraceEnabled()) {
                            this.trace("MODE 4");
                        }
                        if (LanguageHelper.initialGuiLscDoneSoCorrectLanguageIsSetInGui) {
                            this.dsiCarTimeUnitsLanguage.setMenuLanguage(LanguageHelper.getMenuLanguage(ServiceManager.configManagerDiag.getCurrentGuiLanguage()));
                        } else {
                            this.dsiCarTimeUnitsLanguage.setMenuLanguage(LanguageHelper.getMenuLanguageOfLanguageIndex(this.lscAutomaticMode.getPersistableData().getLastActiveLanguagePrefetch()));
                        }
                    } else if (this.isTraceEnabled()) {
                        this.trace("not handling this update, as there is no usecase");
                    }
                }
            } else {
                this.lscAutomaticMode.setLastUpdatedLanguageforPqCase(n);
                if (this.lscAutomaticMode.isPqLscAutomaticModeAktive()) {
                    this.info().append("[AslTargetLscTNGBullhorn]").append("Received Lang from IC, Automode is active, trying to set language...").log();
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(23730176);
                    eventGeneric.setInt(0, n);
                    this.sendSafe(eventGeneric);
                } else {
                    this.info().append("[AslTargetLscTNGBullhorn]").append("not handling this update from instrument cluster, as there is no usecase in non-automatic-mode").log();
                }
            }
        }
    }

    @Override
    public int getClassifier() {
        return 1024;
    }

    @Override
    public int getSubClassifier() {
        return 64;
    }

    private void processAslEventPowerOn() {
        Object object;
        if (this.dsiCarTimeUnitsLanguage == null) {
            object = ServiceManager.dsiServiceLocator;
            this.dsiCarTimeUnitsLanguage = (DSICarTimeUnitsLanguage)((DSIServiceLocator)object).getService(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = AslTargetLscTNGBordComputerLAC.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage);
            this.carTimeUnitsLanguageListener = AdaptorFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = AslTargetLscTNGBordComputerLAC.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener);
            ((DSIServiceLocator)object).addResponseListener(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = AslTargetLscTNGBordComputerLAC.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener, this.carTimeUnitsLanguageListener);
            this.dsiCarTimeUnitsLanguage.setNotification(11, this.carTimeUnitsLanguageListener);
            this.dsiCarTimeUnitsLanguage.setNotification(10, this.carTimeUnitsLanguageListener);
        }
        this.powerIsOnSoEventHandlingIsAllowed = true;
        object = LscServicesProvider.getLscServices();
        this.lscAutomaticMode = object.getAutomaticLanguageModeInstaller();
        this.lscAutomaticMode.setPqLscAutomaticModeAktive(this.lscAutomaticMode.getPersistableData().getPqLscAutomaticModeActive());
        ServiceManager.aslPropertyManager.valueChangedBoolean(892477440, this.lscAutomaticMode.isPqLscAutomaticModeAktive());
        this.addObserver(1134297088);
        this.addObserver(537600064);
        this.addObserver(755703872);
    }

    private void processAslEventPowerOff() {
        this.powerIsOnSoEventHandlingIsAllowed = false;
    }

    private void processLscCommandOnNewLanguage(int n, String string) {
        if (!this.powerIsOnSoEventHandlingIsAllowed) {
            this.warn("POWER_ON is not set for ASlTargetLscTNGBordComputer");
            return;
        }
        if (this.isTraceEnabled()) {
            this.trace().append("BC: Got changeRequest: ").append(string).append(" TransactionId: ").append(n).log();
        }
        LanguageHelper.lastRequestedLanguageForInstrumentCluster = string;
        this.currentlyRequestedLanguage = string;
        this.currentTransactionId = n;
        int n2 = LanguageHelper.getMenuLanguage(string);
        if (string == LanguageHelper.lastRequestedLanguageForInstrumentCluster && LanguageHelper.getMenuLanguage(string) == this.lastUpdateFromInstrumentCluster) {
            this.info("Instrument Cluster/ Kombi already changed, so we are now omitting this one");
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1151074304);
            eventGeneric.setInt(0, n);
            eventGeneric.setBoolean(1, true);
            eventGeneric.setString(2, string);
            this.send(eventGeneric);
            this.currentlyRequestedLanguage = "";
            this.currentTransactionId = -1;
            return;
        }
        if (n2 >= 0) {
            if (this.thisLACIsCurrentlyRegistered) {
                this.dsiCarTimeUnitsLanguage.setMenuLanguage(n2);
            } else {
                this.warn("BordComputer not available by ViewOption now. Will be set when connected to target again. This should never happen");
                this.dsiCarTimeUnitsLanguageUpdateMenuLanguage(n2, 1);
            }
        } else {
            this.error().append("New MenuLanguage [").append(string).append("] uses unknown id. LSC cannot proceed to change BordComputerLanguage!").log();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1151074304);
            eventGeneric.setInt(0, n);
            eventGeneric.setBoolean(1, false);
            eventGeneric.setString(2, "");
            this.send(eventGeneric);
            this.currentlyRequestedLanguage = "";
            this.currentTransactionId = -1;
        }
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

