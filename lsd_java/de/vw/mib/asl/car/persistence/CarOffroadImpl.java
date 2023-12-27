/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.car.persistence;

import de.vw.mib.asl.car.persistence.CarOffroad;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class CarOffroadImpl
extends AbstractPersistable
implements CarOffroad {
    private final PersistenceModule module;
    private int offroadLeftTubeNonNav;
    private int offroadMiddleTubeNonNav;
    private int offroadRightTubeNonNav;
    private int offroadLeftTubeNav;
    private int offroadMiddleTubeNav;
    private int offroadRightTubeNav;

    CarOffroadImpl(PersistenceModule persistenceModule) {
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
    public int getOffroadLeftTubeNonNav() {
        return this.offroadLeftTubeNonNav;
    }

    @Override
    public void setOffroadLeftTubeNonNav(int n) {
        this.offroadLeftTubeNonNav = n;
        this.markDirty();
    }

    @Override
    public int getOffroadMiddleTubeNonNav() {
        return this.offroadMiddleTubeNonNav;
    }

    @Override
    public void setOffroadMiddleTubeNonNav(int n) {
        this.offroadMiddleTubeNonNav = n;
        this.markDirty();
    }

    @Override
    public int getOffroadRightTubeNonNav() {
        return this.offroadRightTubeNonNav;
    }

    @Override
    public void setOffroadRightTubeNonNav(int n) {
        this.offroadRightTubeNonNav = n;
        this.markDirty();
    }

    @Override
    public int getOffroadLeftTubeNav() {
        return this.offroadLeftTubeNav;
    }

    @Override
    public void setOffroadLeftTubeNav(int n) {
        this.offroadLeftTubeNav = n;
        this.markDirty();
    }

    @Override
    public int getOffroadMiddleTubeNav() {
        return this.offroadMiddleTubeNav;
    }

    @Override
    public void setOffroadMiddleTubeNav(int n) {
        this.offroadMiddleTubeNav = n;
        this.markDirty();
    }

    @Override
    public int getOffroadRightTubeNav() {
        return this.offroadRightTubeNav;
    }

    @Override
    public void setOffroadRightTubeNav(int n) {
        this.offroadRightTubeNav = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

