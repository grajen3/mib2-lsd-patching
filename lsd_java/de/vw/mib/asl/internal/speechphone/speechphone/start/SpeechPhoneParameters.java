/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.speechphone.start;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.api.phone.services.callstack.CallstackService;
import de.vw.mib.asl.api.phone.services.contact.ContactDetailsService;
import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstack;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import org.osgi.framework.BundleContext;

public interface SpeechPhoneParameters {
    default public GenericEvents genericEvents() {
    }

    default public String taskId() {
    }

    default public SystemEventDispatcher systemEventDispatcher() {
    }

    default public EventDispatcherHSM eventDispatcher() {
    }

    default public EventFactory eventFactory() {
    }

    default public ServiceRegister serviceRegister() {
    }

    default public ASLPropertyManager aslPropertyManager() {
    }

    default public PhoneService phoneService() {
    }

    default public ContactDetailsService contactDetailsService() {
    }

    default public CallstackService callstackService() {
    }

    default public TeleprompterManager teleprompterManager() {
    }

    default public SlotStateRouter slotStateRouter() {
    }

    default public SlotUpdater slotUpdater() {
    }

    default public AudioAccessor audioAccessor() {
    }

    default public ResultControllerRouter resultControllerRouter() {
    }

    default public ResultItemHandler resultItemHandler() {
    }

    default public ResultListHandler resultListHandler() {
    }

    default public ResultItemRowNumberHandler resultItemRowNumberHandler() {
    }

    default public DialogStateRouter dialogStateRouter() {
    }

    default public DialogBackstack dialogBackstack() {
    }

    default public AbstractClassifiedLogger classifiedLogger() {
    }

    default public BundleContext bundleContext() {
    }

    default public ASLListManager aslListManager() {
    }

    default public ConfigurationManager configurationManager() {
    }

    default public CioDictionary cioDictionary() {
    }

    default public CioDispatcher cioDispatcher() {
    }

    default public DialogManager dialogManager() {
    }
}

