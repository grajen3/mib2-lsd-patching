/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.speech.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.speechengine.config.settings.SpeechSettingsDefaultProvider;
import de.vw.mib.asl.speech.persistence.SpeechSettingsPersistable;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class SpeechSettingsPersistableUserHandler
extends AbstractPersistenceDataHandler {
    private final SpeechSettingsPersistable handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$speech$persistence$SpeechSettingsPersistableUserHandler;

    SpeechSettingsPersistableUserHandler(SpeechSettingsPersistable speechSettingsPersistable, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && speechSettingsPersistable == null) {
            throw new AssertionError();
        }
        this.handledPersistable = speechSettingsPersistable;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 1: {
                this.handledPersistable.setIsDisplayAvailableCommandsOnHeadunitActivated(bl);
                this.markAsProcessed(n);
                break;
            }
            case 2: {
                this.handledPersistable.setIsDisplayAvailableCommandsOnICActivated(bl);
                this.markAsProcessed(n);
                break;
            }
            case 3: {
                this.handledPersistable.setIsUseSpeechSessionStartToneActivated(bl);
                this.markAsProcessed(n);
                break;
            }
            case 4: {
                this.handledPersistable.setIsUseSpeechSessionEndToneActivated(bl);
                this.markAsProcessed(n);
                break;
            }
            case 5: {
                this.handledPersistable.setIsRecognizerReadyToneActivated(bl);
                this.markAsProcessed(n);
                break;
            }
            case 6: {
                this.handledPersistable.setIsRecognizerEndToneActivated(bl);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "boolean");
            }
        }
    }

    @Override
    public void handle(int n, char c2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "char");
    }

    @Override
    public void handle(int n, byte by) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "byte");
    }

    @Override
    public void handle(int n, short s) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "short");
    }

    @Override
    public void handle(int n, int n2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "int");
    }

    @Override
    public void handle(int n, long l) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "long");
    }

    @Override
    public void handle(int n, float f2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "float");
    }

    @Override
    public void handle(int n, double d2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "double");
    }

    @Override
    public void handle(int n, String string) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "String");
    }

    @Override
    public void handle(int n, Persistable persistable) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "Persistable");
    }

    @Override
    public void handle(int n, Map$Entry map$Entry) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "Map");
    }

    @Override
    public void handleEmptyCollection(int n) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "Container");
    }

    @Override
    protected int[] getFieldIds() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 1: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setIsDisplayAvailableCommandsOnHeadunitActivated(SpeechSettingsDefaultProvider.isDisplayAvailableCommandsOnHeadunitActivated());
                break;
            }
            case 2: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setIsDisplayAvailableCommandsOnICActivated(SpeechSettingsDefaultProvider.isDisplayAvailableCommandsOnICActivated());
                break;
            }
            case 3: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setIsUseSpeechSessionStartToneActivated(SpeechSettingsDefaultProvider.isUseSpeechSessionStartToneActivated());
                break;
            }
            case 4: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setIsUseSpeechSessionEndToneActivated(SpeechSettingsDefaultProvider.isUseSpeechSessionEndToneActivated());
                break;
            }
            case 5: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setIsRecognizerReadyToneActivated(SpeechSettingsDefaultProvider.isRecognizerReadyToneActivated());
                break;
            }
            case 6: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setIsRecognizerEndToneActivated(SpeechSettingsDefaultProvider.isRecognizerEndToneActivated());
                break;
            }
            default: {
                this.getLogger().warn(32).append("Cannot install default value: Unknown field ID (").append(n).append(")").log();
            }
        }
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int getPersistableId() {
        return 2;
    }

    protected boolean performValidation() {
        return true;
    }

    protected boolean invokeExternalMethods() {
        return true;
    }

    void preventUnusedModuleWarning__doNotInvoke() {
        this.module.getVersion();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$speech$persistence$SpeechSettingsPersistableUserHandler == null ? (class$de$vw$mib$asl$speech$persistence$SpeechSettingsPersistableUserHandler = SpeechSettingsPersistableUserHandler.class$("de.vw.mib.asl.speech.persistence.SpeechSettingsPersistableUserHandler")) : class$de$vw$mib$asl$speech$persistence$SpeechSettingsPersistableUserHandler).desiredAssertionStatus();
    }
}

