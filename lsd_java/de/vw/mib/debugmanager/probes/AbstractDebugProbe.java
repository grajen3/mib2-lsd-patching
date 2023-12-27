/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.probes;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.Logger;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractDebugProbe
implements DebugProbe {
    private static byte INIT_STATE = 0;
    private static byte INACTIVE_STATE = 1;
    private static byte ACTIVE_STATE = (byte)2;
    private byte currentState;
    protected final ProbeSystemServices probeSystemServices;
    protected final Logger logger;
    private boolean activationRequested;

    public AbstractDebugProbe(ProbeSystemServices probeSystemServices) {
        this.logger = probeSystemServices.getLogger(64);
        this.probeSystemServices = probeSystemServices;
    }

    protected abstract boolean initProbe() {
    }

    protected abstract boolean configureProbe() {
    }

    protected abstract boolean activateProbe() {
    }

    protected abstract boolean deactivateProbe() {
    }

    protected abstract boolean cleanUpProbe() {
    }

    @Override
    public final synchronized boolean init() {
        this.trace("Initializing probe: ");
        if (this.isInitialized()) {
            if (this.logger.isTraceEnabled(4)) {
                this.trace("Debug probe already initialized. ");
            }
            return false;
        }
        if (this.initProbe()) {
            this.currentState = INACTIVE_STATE;
        }
        if (this.activationRequested && this.activationRequested()) {
            this.currentState = ACTIVE_STATE;
            this.sendConfiguration();
        }
        return true;
    }

    private void trace(String string) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append(string).append(super.getClass().getName()).log();
        }
    }

    @Override
    public final synchronized boolean activate(byte[] byArray) {
        this.trace("Activating probe: ");
        if (!this.loadConfiguration(byArray)) {
            return false;
        }
        if (this.activationRequested()) {
            this.currentState = ACTIVE_STATE;
            this.sendConfiguration();
        }
        return true;
    }

    @Override
    public final synchronized boolean activate(Properties properties) {
        this.trace("Activating probe: ");
        this.loadConfiguration(properties);
        if (this.activationRequested()) {
            this.currentState = ACTIVE_STATE;
            this.sendConfiguration();
        }
        return true;
    }

    @Override
    public final synchronized boolean deactivate() {
        this.trace("Deactivating probe: ");
        if (this.isActive()) {
            this.deactivateProbe();
            this.currentState = INACTIVE_STATE;
        }
        this.activationRequested = false;
        this.sendProbeDeactive();
        return true;
    }

    @Override
    public final synchronized boolean cleanUp() {
        this.trace("Clean up probe: ");
        this.deactivate();
        this.cleanUpProbe();
        this.currentState = INIT_STATE;
        return true;
    }

    @Override
    public final synchronized void responseConfigurationRequest() {
        if (this.isActive()) {
            this.sendConfiguration();
        } else {
            this.sendProbeDeactive();
        }
    }

    @Override
    public final synchronized boolean isActive() {
        return this.currentState == ACTIVE_STATE;
    }

    @Override
    public final synchronized boolean isInitialized() {
        return this.currentState != INIT_STATE;
    }

    @Override
    public final synchronized boolean isInactive() {
        return this.currentState == INACTIVE_STATE;
    }

    protected void sendConfiguration() {
        AbstractProbeCodec abstractProbeCodec = this.probeSystemServices.borrowCodec();
        abstractProbeCodec.encodeProbeConfiguration(this.probeSystemServices.getConfiguration());
        this.probeSystemServices.releaseCodec(abstractProbeCodec);
    }

    private void sendProbeDeactive() {
        AbstractProbeCodec abstractProbeCodec = this.probeSystemServices.borrowCodec();
        abstractProbeCodec.encodeProbeDeactivation();
        this.probeSystemServices.releaseCodec(abstractProbeCodec);
    }

    private boolean activationRequested() {
        if (!this.isInitialized()) {
            this.activationRequested = true;
            return false;
        }
        this.configureProbe();
        if (this.isInactive()) {
            return this.activateProbe();
        }
        return true;
    }

    private boolean loadConfiguration(byte[] byArray) {
        try {
            this.probeSystemServices.getConfiguration().load(byArray);
            return true;
        }
        catch (IOException iOException) {
            this.logger.error(4).append("Coudn't read configuration data for debug probe ").append(super.getClass().getName()).append(iOException).log();
            return false;
        }
    }

    private boolean loadConfiguration(Properties properties) {
        this.probeSystemServices.getConfiguration().load(properties);
        return true;
    }
}

