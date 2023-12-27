/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.internal.devices;

import de.vw.mib.input.devices.InputDeviceListener;
import de.vw.mib.input.internal.InputManagerNotifier;
import de.vw.mib.input.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public abstract class BaseInputDeviceHandler
implements InputDeviceListener {
    private static final int LOGGING_CLASSIFIER;
    private static final int LOGGING_SUB_CLASSIFIER;
    private static Logger LOGGER;
    private int type;
    protected InputManagerNotifier inputManagerNotifier;

    public BaseInputDeviceHandler(int n, InputManagerNotifier inputManagerNotifier) {
        LOGGER = ServiceManager.loggerFactory.getLogger(16384);
        this.type = n;
        this.inputManagerNotifier = inputManagerNotifier;
    }

    @Override
    public int getType() {
        return this.type;
    }

    protected static LogMessage trace() {
        return LOGGER.trace(8);
    }

    protected static boolean isTracingEnabled() {
        return LOGGER.isTraceEnabled(8);
    }

    protected static LogMessage info() {
        return LOGGER.info(8);
    }

    protected static LogMessage warn() {
        return LOGGER.warn(8);
    }

    protected static LogMessage error() {
        return LOGGER.error(8);
    }
}

