/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset.participant;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.GlobalFacoryResetParticipant$1;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder;

public class GlobalFacoryResetParticipant
extends AbstractFactoryResetParticipant {
    private DSIInfotainmentRecorder dsiInfotainmentRecorder;
    private final DSIProxy dsiProxy;
    private final Logger logger;
    private final AslPersistenceSyncApi persistence;
    private final SystemEventDispatcher systemEventDispatcher;
    static /* synthetic */ Class class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder;

    public GlobalFacoryResetParticipant(SystemServices systemServices) {
        this.systemEventDispatcher = systemServices.getSystemEventDispatcher();
        this.logger = systemServices.getAsl1Logger();
        this.dsiProxy = systemServices.getDsiProxy();
        this.persistence = systemServices.getPersistence();
        this.dsiProxy.addServiceStateListener(class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder == null ? (class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder = GlobalFacoryResetParticipant.class$("org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder")) : class$org$dsi$ifc$infotainmentrecorder$DSIInfotainmentRecorder, this.createInfotainmentRecordListener());
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.fireRestoreFactorySettingsEvent();
        this.resetInfotainmentRecorderLog();
        this.flushPersistenceDatabase();
        factoryResetCallback.notifyResetDone();
    }

    void setDsiInfotainmentRecorder(DSIInfotainmentRecorder dSIInfotainmentRecorder) {
        this.dsiInfotainmentRecorder = dSIInfotainmentRecorder;
    }

    private DSIServiceStateListenerAdapter createInfotainmentRecordListener() {
        DSIProxy dSIProxy = this.dsiProxy;
        return new GlobalFacoryResetParticipant$1(this, dSIProxy);
    }

    private void fireRestoreFactorySettingsEvent() {
        this.systemEventDispatcher.createAndSubmitRestoreFactorySettingsEvent();
    }

    private void flushPersistenceDatabase() {
        try {
            this.persistence.flushDatabase(true);
        }
        catch (GenericEventException genericEventException) {
            this.logError(new StringBuffer().append("Failed to flush the persistence database! Cause:").append(genericEventException.getMessage()).toString(), genericEventException);
        }
    }

    private void logError(String string, Exception exception) {
        this.logger.error(2048, string, exception);
    }

    private void resetInfotainmentRecorderLog() {
        if (this.dsiInfotainmentRecorder != null) {
            this.dsiInfotainmentRecorder.logInit();
        } else {
            String string = "Unable to reset the DsiInfotainmentRecorder, cause it's not available!";
            this.logError(string, null);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

