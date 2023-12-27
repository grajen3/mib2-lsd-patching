/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.carearly.persistence;

import de.vw.mib.asl.carearly.persistence.CarEarly;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class CarEarlyImpl
extends AbstractPersistable
implements CarEarly {
    private final PersistenceModule module;
    private boolean climateSpecialFunctionsVisible;
    private int ambienceLightColor;
    private boolean trailerModeRouteCalculation;
    private int lastPqView;
    private int lastMainViewId;
    private int lastSubViewId;

    CarEarlyImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 1;
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
    public boolean isClimateSpecialFunctionsVisible() {
        return this.climateSpecialFunctionsVisible;
    }

    @Override
    public void setClimateSpecialFunctionsVisible(boolean bl) {
        this.climateSpecialFunctionsVisible = bl;
        this.markDirty();
    }

    @Override
    public int getAmbienceLightColor() {
        return this.ambienceLightColor;
    }

    @Override
    public void setAmbienceLightColor(int n) {
        this.ambienceLightColor = n;
        this.markDirty();
    }

    @Override
    public boolean isTrailerModeRouteCalculation() {
        return this.trailerModeRouteCalculation;
    }

    @Override
    public void setTrailerModeRouteCalculation(boolean bl) {
        this.trailerModeRouteCalculation = bl;
        this.markDirty();
    }

    @Override
    public int getLastPqView() {
        return this.lastPqView;
    }

    @Override
    public void setLastPqView(int n) {
        this.lastPqView = n;
        this.markDirty();
    }

    @Override
    public int getLastMainViewId() {
        return this.lastMainViewId;
    }

    @Override
    public void setLastMainViewId(int n) {
        this.lastMainViewId = n;
        this.markDirty();
    }

    @Override
    public int getLastSubViewId() {
        return this.lastSubViewId;
    }

    @Override
    public void setLastSubViewId(int n) {
        this.lastSubViewId = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

