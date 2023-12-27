/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoader;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterActivator;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterCallback;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterParameters;
import de.vw.mib.asl.internal.speechengine.startup.FrameworkServices;
import de.vw.mib.asl.internal.speechengine.startup.SpeechASLLogger;
import de.vw.mib.asl.internal.speechengine.startup.SpeechComponentStarter;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.TimerManager;

public class SlotUpdaterHandler
extends SpeechComponentStarter
implements SlotUpdaterParameters {
    private final FrameworkServices frameworkServices;
    private final SlotUpdaterCallback speechEngineStarter;
    private final AbstractClassifiedLogger internalLogger;
    private CommandLoader commandLoader = null;
    private final Services aslServices;

    SlotUpdaterHandler(AbstractClassifiedLogger abstractClassifiedLogger, SlotUpdaterCallback slotUpdaterCallback, FrameworkServices frameworkServices, Services services) {
        super(abstractClassifiedLogger);
        this.speechEngineStarter = slotUpdaterCallback;
        this.frameworkServices = frameworkServices;
        this.aslServices = services;
        this.internalLogger = new SpeechASLLogger(8, "[SlotLoader] ", frameworkServices.getSpeechLogger());
    }

    private void servicesChanged() {
        if (this.commandLoader != null) {
            this.getSlotUpdaterActivator().activate(this.speechEngineStarter, this);
        }
    }

    private SlotUpdaterActivator getSlotUpdaterActivator() {
        return (SlotUpdaterActivator)this.getActivatorViaReflection("de.vw.mib.asl.internal.speechengine.slots.SlotUpdaterActivatorImpl");
    }

    void updateCommandLoader(CommandLoader commandLoader) {
        this.commandLoader = commandLoader;
        this.servicesChanged();
    }

    @Override
    public AbstractClassifiedLogger getLogger() {
        return this.internalLogger;
    }

    @Override
    public Framework4U getFramework4u() {
        return this.frameworkServices.getFramework4u();
    }

    @Override
    public TimerManager getTimerManager() {
        return this.frameworkServices.getTimerManager();
    }

    @Override
    public CommandLoader getCommandLoader() {
        return this.commandLoader;
    }

    @Override
    public Invoker getInvoker() {
        return this.aslServices.getASLThreadSwitch();
    }

    @Override
    public ConfigurationManagerDiag getConfigurationManagerDiag() {
        return this.aslServices.getConfigurationManagerDiag();
    }
}

