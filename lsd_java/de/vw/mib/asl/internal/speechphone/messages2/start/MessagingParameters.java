/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.messages2.start;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.ASLTimeAndDateServiceTarget;
import de.vw.mib.asl.api.messages.services.available.MessageAvailableService;
import de.vw.mib.asl.api.messages.services.detail.MessageDetailService;
import de.vw.mib.asl.api.messages.services.status.MessagesStatusService;
import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.timer.TimerManager;

public interface MessagingParameters {
    default public GenericEvents genericEvents() {
    }

    default public String taskId() {
    }

    default public SystemEventDispatcher systemEventDispatcher() {
    }

    default public EventDispatcherHSM eventDispatcher() {
    }

    default public ASLPropertyManager aslPropertyManager() {
    }

    default public PhoneService phoneService() {
    }

    default public ServiceRegister serviceRegister() {
    }

    default public TimerManager timerManager() {
    }

    default public ResultControllerRouter resultControllerRouter() {
    }

    default public MessagesStatusService messagesStatusService() {
    }

    default public MessageAvailableService messageAvailableService() {
    }

    default public MessageDetailService messageDetailService() {
    }

    default public ThreadSwitchingTarget threadSwitchingTarget() {
    }

    default public AbstractClassifiedLogger classifiedLogger() {
    }

    default public ASLTimeAndDateServiceTarget aslTimeAndDateServiceTarget() {
    }

    default public ConfigurationManager configurationManager() {
    }
}

