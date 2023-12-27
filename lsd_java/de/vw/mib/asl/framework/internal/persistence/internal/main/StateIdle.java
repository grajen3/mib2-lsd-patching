/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.main;

import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDbImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.ApiPersFlush;
import de.vw.mib.asl.framework.internal.persistence.internal.main.PersistenceMainTarget;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServicesProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.InitialProfileTargetHIGH;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.InitialProfileTargetSTD;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateIdle
extends AbstractHsmState {
    private final PersistenceMainTarget mTarget;
    private boolean startedInitialProfileTarget;

    public StateIdle(PersistenceMainTarget persistenceMainTarget, String string, HsmState hsmState) {
        super(persistenceMainTarget.getHsm(), string, hsmState);
        this.mTarget = persistenceMainTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.createInitialStartupTarget();
                break;
            }
            case 4: {
                boolean bl = this.mTarget.getTimerServer().isTimerActive(this.mTarget.getTargetId(), -1568276224);
                if (!bl) break;
                this.mTarget.stopTimer(-1568276224);
                break;
            }
            case 100002: {
                if (this.mTarget.mIsEnabled && !this.mTarget.mIsDisabledDueToError) {
                    ApiPersDbImpl.INSTANCE.writeRecords();
                    break;
                }
                this.mTarget.startTimerForWritingRecords();
                PersDebug.trace("don't write now, start new timer as persistence is disabled!", true);
                break;
            }
            case 1700010: {
                ApiPersFlush.flushDatabase(false);
                eventGeneric.setResult(0);
                break;
            }
            case 4300042: {
                ApiPersFlush.flushDatabaseShutdown();
                eventGeneric.setResult(0);
                break;
            }
            case 4300054: {
                ApiPersFlush.indicatePowerstateOn();
                eventGeneric.setResult(0);
                break;
            }
            case 1700002: {
                this.mTarget.handleRead(eventGeneric, (byte)1);
                break;
            }
            case 1700004: {
                this.mTarget.handleRead(eventGeneric, (byte)2);
                break;
            }
            case 1700006: {
                this.mTarget.handleRead(eventGeneric, (byte)4);
                break;
            }
            case 1700008: {
                this.mTarget.handleRead(eventGeneric, (byte)3);
                break;
            }
            case 1700003: {
                this.mTarget.handleWrite(eventGeneric, (byte)1);
                break;
            }
            case 1700005: {
                this.mTarget.handleWrite(eventGeneric, (byte)2);
                break;
            }
            case 1700007: {
                this.mTarget.handleWrite(eventGeneric, (byte)4);
                break;
            }
            case 1700009: {
                this.mTarget.handleWrite(eventGeneric, (byte)3);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void createInitialStartupTarget() {
        PersDebug.trace("State Main:Idle", true);
        if (this.startedInitialProfileTarget) {
            return;
        }
        PersistenceServices persistenceServices = PersistenceServicesProvider.getPersistenceServices();
        String string = System.getProperty("de.vw.mib.pso.useReadInt");
        this.mTarget.info(new StringBuffer().append("de.vw.mib.pso.useReadInt=").append(string).toString());
        if ("true".equals(string)) {
            this.mTarget.info("initial profile for HIGH");
            new InitialProfileTargetHIGH(persistenceServices);
        } else {
            this.mTarget.info("initial profile for STD");
            new InitialProfileTargetSTD(persistenceServices);
        }
        this.startedInitialProfileTarget = true;
    }
}

