/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetExecutionParticipantData;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetNotificator;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetNotificator$FactoryResetNotificatorCallback;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimeoutManager$1;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimer;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.log4mib.Logger;

class FactoryResetTimeoutManager {
    static final long MIN_PROVIDED_TIMEOUT;
    private final Logger logger;
    private FactoryResetNotificator notificator;
    private final SystemServices services;
    private final FactoryResetTimer timer;

    FactoryResetTimeoutManager(FactoryResetTimer factoryResetTimer, SystemServices systemServices) {
        Preconditions.checkArgumentNotNull(factoryResetTimer);
        Preconditions.checkArgumentNotNull(systemServices);
        this.timer = factoryResetTimer;
        this.services = systemServices;
        this.logger = systemServices.getAsl1Logger();
    }

    boolean isIdle() {
        return this.notificator == null;
    }

    void reset(FactoryResetExecutionParticipantData factoryResetExecutionParticipantData, FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback factoryResetTimeoutManager$FactoryResetTimeoutManagerCallback) {
        Preconditions.checkArgumentNotNull(factoryResetExecutionParticipantData);
        Preconditions.checkArgumentNotNull(factoryResetTimeoutManager$FactoryResetTimeoutManagerCallback);
        long l = this.calculateTimeout(factoryResetExecutionParticipantData.getParticipants());
        if (this.isTraceEnabled()) {
            this.logTrace(new StringBuffer().append("Starting factory reset for component >").append(factoryResetExecutionParticipantData.getComponentName()).append(" with >").append(factoryResetExecutionParticipantData.getParticipants().length).append("< participants and a timeout of >").append(l).append("< ms.").toString());
        }
        FactoryResetNotificator$FactoryResetNotificatorCallback factoryResetNotificator$FactoryResetNotificatorCallback = this.createNotificatorCallback(this.timer, factoryResetTimeoutManager$FactoryResetTimeoutManagerCallback);
        this.notificator = new FactoryResetNotificator(factoryResetExecutionParticipantData, factoryResetNotificator$FactoryResetNotificatorCallback, this.services);
        this.timer.startTimer(l, this.notificator.getTimeoutListener());
    }

    void clearNotificator() {
        this.notificator = null;
    }

    private long calculateTimeout(FactoryResetParticipant[] factoryResetParticipantArray) {
        int n = 0;
        for (int i2 = 0; i2 < factoryResetParticipantArray.length; ++i2) {
            FactoryResetParticipant factoryResetParticipant = factoryResetParticipantArray[i2];
            n = (int)Math.max((long)n, factoryResetParticipant.getTimeout());
        }
        return n;
    }

    private FactoryResetNotificator$FactoryResetNotificatorCallback createNotificatorCallback(FactoryResetTimer factoryResetTimer, FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback factoryResetTimeoutManager$FactoryResetTimeoutManagerCallback) {
        return new FactoryResetTimeoutManager$1(this, factoryResetTimer, factoryResetTimeoutManager$FactoryResetTimeoutManagerCallback);
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(2048);
    }

    private void logTrace(String string) {
        this.logger.trace(2048, new StringBuffer().append("[FactoryResetServiceTimeoutManager] ").append(string).toString());
    }
}

