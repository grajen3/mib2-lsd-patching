/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal;

import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.consumer.StatemachineManagerEventConsumer;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.hmi.HmiEventIdMap;
import de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionManager;
import de.vw.mib.sm.internal.ActivityFactory;
import de.vw.mib.sm.internal.StatemachineManagerImpl;
import de.vw.mib.sm.internal.SubStatemachineFactory;
import de.vw.mib.sm.internal.activity.DynamicStatemachineTrigger;
import de.vw.mib.sm.internal.activity.EventReceiverTable;
import de.vw.mib.sm.internal.activity.GlobalActionHandler;
import de.vw.mib.sm.internal.journal.SmJournalEx;
import de.vw.mib.sm.internal.waitaphore.WaitaphoreWatcher;

public final class ServiceManagerStatemachine {
    public static HmiEventIdMap hmiEventIdMap;
    public static GenericEvents genericEvents;
    public static ErrorHandler errorHandler;
    public static EventFactory eventFactory;
    public static SdFeatureCollectionManager sdFeatureCollectionManager;
    public static StatemachineManagerImpl statemachineManager;
    public static StatemachineManagerEventConsumer statemachineManagerEventConsumer;
    public static EventReceiverTable eventReceiverTable;
    public static DynamicStatemachineTrigger dynamicStatemachineTrigger;
    public static GlobalActionHandler globalActionHandler;
    public static SmJournalEx journalEx;
    public static SubStatemachineFactory subStatemachineFactory;
    public static ActivityFactory activityFactory;
    public static WaitaphoreWatcher waitaphoreWatcher;
    public static int smChecksum;
    public static long globalReceiverId;

    private ServiceManagerStatemachine() {
    }
}

