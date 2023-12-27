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
import de.vw.mib.asl.framework.api.persistence2.collections.lists.PersistenceArrayList;
import de.vw.mib.asl.homescreen.persistence.HomescreenInfo;
import java.util.Iterator;
import java.util.List;

class HomescreenInfoImpl
extends AbstractPersistable
implements HomescreenInfo {
    private final PersistenceModule module;
    private final PersistenceArrayList tileContents = new PersistenceArrayList();
    private int clockLayout;

    HomescreenInfoImpl(PersistenceModule persistenceModule) {
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
        this.tileContents.setRootPersistable(persistable);
        Iterator iterator = this.getTileContents().iterator();
        while (iterator.hasNext()) {
            AbstractPersistable abstractPersistable = (AbstractPersistable)iterator.next();
            if (abstractPersistable == null) continue;
            abstractPersistable.updateRootPersistable(persistable);
        }
    }

    @Override
    public int getClockLayout() {
        return this.clockLayout;
    }

    @Override
    public void setClockLayout(int n) {
        this.clockLayout = n;
        this.markDirty();
    }

    @Override
    public List getTileContents() {
        return this.tileContents;
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

