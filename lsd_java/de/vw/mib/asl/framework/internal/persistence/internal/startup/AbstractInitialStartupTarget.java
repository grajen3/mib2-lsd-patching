/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.startup;

import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistableService;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.AbstractInitialStartupTarget$1;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractInitialStartupTarget
implements Target {
    static final int VALID_PROFILE_BITS_MASK;
    static final byte INVALID_PROFILE;
    static final int INITIAL_PROFILE_RESPONSE;
    private static final String LOG_PREFIX;
    private final GenericEvents genericEvents;
    private final Logger logger;
    private final PersistableService persistableService;
    private final AslPersistenceSyncApi persistenceSyncApi;

    public AbstractInitialStartupTarget(PersistenceServices persistenceServices) {
        this.genericEvents = persistenceServices.getGenericEvents();
        this.genericEvents.getEventDispatcher().registerTarget(this.getTargetId(), this, "hsmtask");
        this.persistableService = persistenceServices.getPersistableService();
        this.persistenceSyncApi = persistenceServices.getASLPersistenceAPI().getPersistenceSyncApi();
        this.logger = persistenceServices.getLogger();
        this.requestInitialProfile(this.getTargetId(), -1434058496, persistenceServices);
        this.writeInitialProfileAfterProfileChanges(persistenceServices.getPersistableService());
    }

    @Override
    public final void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() != -1434058496) {
            return;
        }
        this.processInitialProfileResponse(eventGeneric);
    }

    @Override
    public final GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public final int getTargetId() {
        return 1085477120;
    }

    @Override
    public final void setTargetId(int n) {
    }

    abstract void requestInitialProfile(int n, int n2, PersistenceServices persistenceServices) {
    }

    abstract void processInitialProfileResponse(EventGeneric eventGeneric) {
    }

    abstract void writeInitialProfile(byte by, AslPersistenceSyncApi aslPersistenceSyncApi) {
    }

    final void setInitialProfile(byte by) {
        this.persistableService.setupInitialProfile(by);
    }

    final void setInitialProfileToDefault(String string) {
        this.logError(new StringBuffer().append(string).append(" Setting initial profile to default: ").append(1).toString());
        this.persistableService.setupInitialProfile((byte)1);
    }

    final void info(String string) {
        this.logger.info(32).append("[InitialStartupProfileTarget] ").append(string).log();
    }

    final void trace(String string) {
        this.logger.trace(32).append("[InitialStartupProfileTarget] ").append(string);
    }

    boolean isInvalidStartupProfile(byte by) {
        return by < 1 || by > 4;
    }

    private void logError(String string) {
        this.logger.error(32).append("[InitialStartupProfileTarget] ").append(string);
    }

    private void writeInitialProfileAfterProfileChanges(PersistableService persistableService) {
        AslPersistenceSyncApi aslPersistenceSyncApi = this.persistenceSyncApi;
        AbstractInitialStartupTarget$1 abstractInitialStartupTarget$1 = new AbstractInitialStartupTarget$1(this, persistableService, aslPersistenceSyncApi);
        persistableService.addGlobalProfileChangeListener(abstractInitialStartupTarget$1, 0);
    }
}

