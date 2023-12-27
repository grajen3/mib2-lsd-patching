/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq;

import de.vw.mib.asl.api.bap.dispatcher.BAPDispatcher;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.bap.stream.BitStreamTransformer;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.format.FixFormat;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;

public final class ServiceManager {
    public static ServiceManager serviceManager = null;
    public Logger logger = null;
    public GenericEvents genericEvents = null;
    public EventFactory genericEventFactory = null;
    public AslPersistenceSyncApi persistence = null;
    public FixFormat fixFormat = null;
    public ASLDatapool dataPool = null;
    public ConfigurationManager configurationManager = null;
    public SystemEventDispatcher systemEventDispatcher = null;
    public ThreadSwitchingTarget threadSwitchingTarget = null;
    public BAPDispatcher bapDispatcher = null;
    public BitStreamTransformer bitStreamTransformer = null;

    private ServiceManager() {
    }

    public static void createNewInstance() {
        serviceManager = new ServiceManager();
    }
}

