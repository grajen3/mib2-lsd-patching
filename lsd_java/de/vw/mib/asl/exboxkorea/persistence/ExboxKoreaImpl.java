/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.exboxkorea.persistence;

import de.vw.mib.asl.exboxkorea.persistence.ExboxKorea;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class ExboxKoreaImpl
extends AbstractPersistable
implements ExboxKorea {
    private final PersistenceModule module;
    private boolean navigationAnnouncementDuringPhoneCallEnabled;

    ExboxKoreaImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
    }

    @Override
    public boolean isNavigationAnnouncementDuringPhoneCallEnabled() {
        return this.navigationAnnouncementDuringPhoneCallEnabled;
    }

    @Override
    public void setNavigationAnnouncementDuringPhoneCallEnabled(boolean bl) {
        this.navigationAnnouncementDuringPhoneCallEnabled = bl;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

