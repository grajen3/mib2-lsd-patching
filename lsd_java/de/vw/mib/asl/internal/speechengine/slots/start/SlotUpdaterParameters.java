/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.start;

import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoader;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.TimerManager;

public interface SlotUpdaterParameters {
    default public AbstractClassifiedLogger getLogger() {
    }

    default public Framework4U getFramework4u() {
    }

    default public TimerManager getTimerManager() {
    }

    default public Invoker getInvoker() {
    }

    default public CommandLoader getCommandLoader() {
    }

    default public ConfigurationManagerDiag getConfigurationManagerDiag() {
    }
}

