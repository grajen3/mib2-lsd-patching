/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.ModelApiEventService;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcherExt;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.genericevents.ThreadSwitchingTarget;

final class Services$EventDispatcherServices {
    private final FrameworkEventDispatcher frameworkEventDispatcher;
    private final ModelApiEventService modelApiEventService;
    private final StartupEventDispatcher startupEventDispatcher;
    private final StatemachineEventDispatcherExt statemachineEventDispatcher;
    private final ViewEventDispatcher viewEventDispatcher;
    private final ThreadSwitchingTarget threadSwitchingTarget;

    Services$EventDispatcherServices(FrameworkEventDispatcher frameworkEventDispatcher, StartupEventDispatcher startupEventDispatcher, StatemachineEventDispatcherExt statemachineEventDispatcherExt, ViewEventDispatcher viewEventDispatcher, ThreadSwitchingTarget threadSwitchingTarget) {
        this.frameworkEventDispatcher = frameworkEventDispatcher;
        this.startupEventDispatcher = startupEventDispatcher;
        this.statemachineEventDispatcher = statemachineEventDispatcherExt;
        this.viewEventDispatcher = viewEventDispatcher;
        this.threadSwitchingTarget = threadSwitchingTarget;
        this.modelApiEventService = new ModelApiEventService(threadSwitchingTarget, statemachineEventDispatcherExt);
    }

    FrameworkEventDispatcher getFrameworkEventDispatcher() {
        return this.frameworkEventDispatcher;
    }

    ModelApiEventService getModelApiEventService() {
        return this.modelApiEventService;
    }

    StartupEventDispatcher getStartupEventDispatcher() {
        return this.startupEventDispatcher;
    }

    StatemachineEventDispatcherExt getStatemachineEventDispatcher() {
        return this.statemachineEventDispatcher;
    }

    ViewEventDispatcher getViewEventDispatcher() {
        return this.viewEventDispatcher;
    }

    ThreadSwitchingTarget getThreadSwitchingTarget() {
        return this.threadSwitchingTarget;
    }
}

