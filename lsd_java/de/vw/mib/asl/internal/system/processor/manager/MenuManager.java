/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.manager;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.impl.system.AbstractSystemTarget;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.processor.manager.MenuManager$1;
import de.vw.mib.asl.internal.system.processor.manager.MenuManager$2;
import de.vw.mib.asl.internal.system.processor.manager.MenuManager$3;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.configuration.NvListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.threads.AsyncServiceFactory;

public class MenuManager
extends AbstractSystemTarget {
    private final ConfigurationManagerDiag configurationManager;
    private SystemCommon systemCommon;
    private ASLPropertyManager propertyManager;

    public MenuManager(SystemServices systemServices) {
        super(systemServices.getGenericEvents(), systemServices.getAsl1Logger(), -206957312);
        SystemCommonPersistenceService systemCommonPersistenceService = systemServices.getSystemCommonPersistenceService();
        systemCommonPersistenceService.addProfileChangeListener(this.createProfileChangeListener(systemCommonPersistenceService));
        this.configurationManager = systemServices.getConfigManagerDiag();
        this.configurationManager.addNvListener(this.createConfigurationManagerListener(systemServices.getAsyncServiceFactory()), 3);
        this.propertyManager = systemServices.getPropertyManager();
        systemServices.getFactoryResetService().addParticipant(this.createFactoryResetParticipant(), FactoryResetComponents.SYSTEM);
        this.loadPersistence(systemCommonPersistenceService);
        this.updateMenuModeAvailability();
        this.updateCurrentMenuMode();
        this.registerObservers(systemServices.getServiceRegister());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1075841846: {
                int n = eventGeneric.getInt(0);
                this.processMenuModeChange(n);
                break;
            }
        }
    }

    public String getMenuContentId() {
        if (this.systemCommon.getMenuMode() == 1) {
            return "HMI_GRIDMENU";
        }
        return "HMI_MENU";
    }

    void loadPersistence(SystemCommonPersistenceService systemCommonPersistenceService) {
        this.systemCommon = systemCommonPersistenceService.loadSystemCommon();
        this.updateMenuModeToSkinRestrictions();
        this.updateCurrentMenuMode();
    }

    void updateMenuModeToSkinRestrictions() {
        boolean bl;
        int n = this.configurationManager.getDefaultMenuMode();
        boolean bl2 = !this.configurationManager.isMenuModeUserSwitchable();
        boolean bl3 = bl = n != this.systemCommon.getMenuMode();
        if (bl2 && bl) {
            this.systemCommon.setMenuMode(n);
        }
    }

    void installDefaultMenuMode() {
        this.systemCommon.setMenuMode(this.configurationManager.getDefaultMenuMode());
        this.updateCurrentMenuMode();
    }

    void updateMenuModeAvailability() {
        this.propertyManager.valueChangedBoolean(1580343296, this.configurationManager.isMenuModeUserSwitchable());
    }

    private void updateCurrentMenuMode() {
        if (this.systemCommon.getMenuMode() == 1) {
            this.propertyManager.valueChangedInteger(1563566080, 1);
        } else {
            this.propertyManager.valueChangedInteger(1563566080, 0);
        }
    }

    private FactoryResetParticipant createFactoryResetParticipant() {
        return new MenuManager$1(this);
    }

    private NvListener createConfigurationManagerListener(AsyncServiceFactory asyncServiceFactory) {
        MenuManager$2 menuManager$2 = new MenuManager$2(this);
        return (NvListener)asyncServiceFactory.create(menuManager$2);
    }

    private void processMenuModeChange(int n) {
        boolean bl = this.configurationManager.isMenuModeUserSwitchable();
        if (bl) {
            this.persistNewMenuMode(n);
            this.updateCurrentMenuMode();
        }
    }

    private void persistNewMenuMode(int n) {
        if (n == 1) {
            this.systemCommon.setMenuMode(1);
        } else {
            this.systemCommon.setMenuMode(0);
        }
    }

    private AbstractProfileChangeHandler createProfileChangeListener(SystemCommonPersistenceService systemCommonPersistenceService) {
        return new MenuManager$3(this, systemCommonPersistenceService);
    }

    private void registerObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(906698816, this.getTargetId());
    }
}

