/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.homescreen.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.homescreen.persistence.TileContent;

class TileContentImpl
extends AbstractPersistable
implements TileContent {
    private final PersistenceModule module;
    private String tileUsageId;
    private int tileUsageIndex;
    private long cioIntentId;

    TileContentImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
    }

    @Override
    public String getTileUsageId() {
        return this.tileUsageId;
    }

    @Override
    public void setTileUsageId(String string) {
        this.tileUsageId = string;
        this.markDirty();
    }

    @Override
    public int getTileUsageIndex() {
        return this.tileUsageIndex;
    }

    @Override
    public void setTileUsageIndex(int n) {
        this.tileUsageIndex = n;
        this.markDirty();
    }

    @Override
    public long getCioIntentId() {
        return this.cioIntentId;
    }

    @Override
    public void setCioIntentId(long l) {
        this.cioIntentId = l;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

