/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.systemstate;

import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.internal.impl.system.systemstate.SystemStateServiceImpl$1;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;

public class SystemStateServiceImpl
implements SystemStateService {
    private final SystemCommonPersistenceService persistenceService;
    private SystemCommon systemCommon;
    private String originalLastContentId;

    public SystemStateServiceImpl(SystemCommonPersistenceService systemCommonPersistenceService) {
        this.persistenceService = systemCommonPersistenceService;
        this.loadPersistence();
        systemCommonPersistenceService.addProfileChangeListener(this.createProfileChangeListener());
        this.originalLastContentId = this.systemCommon.getLastContentId();
    }

    void loadPersistence() {
        this.systemCommon = this.persistenceService.loadSystemCommon();
    }

    private ProfileChangeListener createProfileChangeListener() {
        return new SystemStateServiceImpl$1(this);
    }

    @Override
    public String getLastContentId() {
        return this.originalLastContentId;
    }

    @Override
    public String getCurrentLastContentId() {
        return this.systemCommon.getLastContentId();
    }
}

