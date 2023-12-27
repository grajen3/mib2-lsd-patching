/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;

class AbtFeaturesImpl
extends AbstractPersistable
implements AbtFeatures {
    private final PersistenceModule module;
    private int proximitySensor;
    private boolean handWritingRecognition;
    private boolean hapticFeedback;
    private int displayResolutionX;
    private int displayResolutionY;
    private int abtType;
    private int displayShape;
    private int nubmerOfHardKeys;
    private int buttonTechnology;
    private int rotaryEncoderType;
    private int touchController;
    private int touchMultiplicatorX;
    private int touchMultiplicatorY;

    AbtFeaturesImpl(PersistenceModule persistenceModule) {
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
    public int getProximitySensor() {
        return this.proximitySensor;
    }

    @Override
    public void setProximitySensor(int n) {
        this.proximitySensor = n;
        this.markDirty();
    }

    @Override
    public boolean isHandWritingRecognition() {
        return this.handWritingRecognition;
    }

    @Override
    public void setHandWritingRecognition(boolean bl) {
        this.handWritingRecognition = bl;
        this.markDirty();
    }

    @Override
    public boolean isHapticFeedback() {
        return this.hapticFeedback;
    }

    @Override
    public void setHapticFeedback(boolean bl) {
        this.hapticFeedback = bl;
        this.markDirty();
    }

    @Override
    public int getDisplayResolutionX() {
        return this.displayResolutionX;
    }

    @Override
    public void setDisplayResolutionX(int n) {
        this.displayResolutionX = n;
        this.markDirty();
    }

    @Override
    public int getDisplayResolutionY() {
        return this.displayResolutionY;
    }

    @Override
    public void setDisplayResolutionY(int n) {
        this.displayResolutionY = n;
        this.markDirty();
    }

    @Override
    public int getAbtType() {
        return this.abtType;
    }

    @Override
    public void setAbtType(int n) {
        this.abtType = n;
        this.markDirty();
    }

    @Override
    public int getDisplayShape() {
        return this.displayShape;
    }

    @Override
    public void setDisplayShape(int n) {
        this.displayShape = n;
        this.markDirty();
    }

    @Override
    public int getNubmerOfHardKeys() {
        return this.nubmerOfHardKeys;
    }

    @Override
    public void setNubmerOfHardKeys(int n) {
        this.nubmerOfHardKeys = n;
        this.markDirty();
    }

    @Override
    public int getButtonTechnology() {
        return this.buttonTechnology;
    }

    @Override
    public void setButtonTechnology(int n) {
        this.buttonTechnology = n;
        this.markDirty();
    }

    @Override
    public int getRotaryEncoderType() {
        return this.rotaryEncoderType;
    }

    @Override
    public void setRotaryEncoderType(int n) {
        this.rotaryEncoderType = n;
        this.markDirty();
    }

    @Override
    public int getTouchController() {
        return this.touchController;
    }

    @Override
    public void setTouchController(int n) {
        this.touchController = n;
        this.markDirty();
    }

    @Override
    public int getTouchMultiplicatorX() {
        return this.touchMultiplicatorX;
    }

    @Override
    public void setTouchMultiplicatorX(int n) {
        this.touchMultiplicatorX = n;
        this.markDirty();
    }

    @Override
    public int getTouchMultiplicatorY() {
        return this.touchMultiplicatorY;
    }

    @Override
    public void setTouchMultiplicatorY(int n) {
        this.touchMultiplicatorY = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

