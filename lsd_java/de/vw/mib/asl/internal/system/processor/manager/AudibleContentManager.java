/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.manager;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.internal.impl.system.AbstractSystemTarget;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.processor.manager.AudibleContentManager$1;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.List;

public class AudibleContentManager
extends AbstractSystemTarget {
    private static final String LOG_PREFIX;
    private final List entertainmentContents = this.getEntertainmentContents();
    private final Logger logger;
    private final ASLPropertyManager propertyManager;
    private final AslPersistenceSyncApi persistenceSyncApi;
    private SystemCommon systemCommon;
    private SystemCommonPersistenceService commonPersistenceService;

    public AudibleContentManager(SystemServices systemServices) {
        super(systemServices.getGenericEvents(), systemServices.getAsl1Logger(), -173402880);
        this.commonPersistenceService = systemServices.getSystemCommonPersistenceService();
        this.systemCommon = this.commonPersistenceService.loadSystemCommon();
        this.logger = systemServices.getAsl1Logger();
        this.propertyManager = systemServices.getPropertyManager();
        this.persistenceSyncApi = systemServices.getPersistence();
        this.addObservers(systemServices.getServiceRegister());
        this.commonPersistenceService.addProfileChangeListener(this.createProfileChangeListener());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1400026: {
                int n = eventGeneric.getInt(0);
                this.processNewEntertainmentContext(n);
                break;
            }
        }
    }

    void loadPersistence() {
        this.systemCommon = this.commonPersistenceService.loadSystemCommon();
    }

    private ProfileChangeListener createProfileChangeListener() {
        return new AudibleContentManager$1(this);
    }

    private void processNewEntertainmentContext(int n) {
        boolean bl = this.entertainmentContents.contains(this.systemCommon.getLastContentId());
        if (bl) {
            String string = this.findMainContentForAudibleContext(n);
            this.switchToContent(string);
            this.propertyManager.valueChangedInteger(1612, this.findMainContextIdForAudibleContext(n));
        }
    }

    private void switchToContent(String string) {
        boolean bl;
        boolean bl2 = bl = string != null && !this.systemCommon.getLastContentId().equals(string) && !this.persistenceSyncApi.isProfileChangeRunning();
        if (bl) {
            this.logger.info(2048).append("[AudibleContentManager] ").append("Changing last persisted content to").append(string).append(" because of changed entertainment content").log();
            this.systemCommon.setLastContentId(string);
        }
    }

    private void addObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(-631499520, this.getTargetId());
    }

    private List getEntertainmentContents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("HMI_MEDIA");
        arrayList.add("HMI_RADIO");
        arrayList.add("HMI_TVTUNER");
        arrayList.add("HMI_SMARTPHONEINTEGRATION");
        return arrayList;
    }

    private String findMainContentForAudibleContext(int n) {
        switch (n) {
            case 1: {
                return "HMI_RADIO";
            }
            case 2: {
                return "HMI_MEDIA";
            }
            case 5: {
                return "HMI_TVTUNER";
            }
            case 7: 
            case 8: 
            case 9: {
                return "HMI_SMARTPHONEINTEGRATION";
            }
        }
        return null;
    }

    private int findMainContextIdForAudibleContext(int n) {
        switch (n) {
            case 1: {
                return 6;
            }
            case 2: {
                return 4;
            }
            case 5: {
                return 21;
            }
            case 7: 
            case 8: 
            case 9: {
                return 25;
            }
        }
        return 0;
    }
}

