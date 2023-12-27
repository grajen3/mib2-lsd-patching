/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.internal;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.input.InputManager;
import de.vw.mib.input.InputManagerListener;
import de.vw.mib.input.devices.InputDevice;
import de.vw.mib.input.devices.ProximityInputDevice;
import de.vw.mib.input.devices.TouchInputDevice;
import de.vw.mib.input.internal.InputManagerImpl$ProximityGestureSuppressor;
import de.vw.mib.input.internal.InputManagerNotifier;
import de.vw.mib.input.internal.ServiceManager;
import de.vw.mib.input.internal.devices.ProximityInputDeviceHandler;
import de.vw.mib.input.internal.devices.TouchInputDeviceHandler;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class InputManagerImpl
implements InputManager,
InputManagerNotifier {
    private static final int LOGGING_CLASSIFIER;
    private static final int LOGGING_SUB_CLASSIFIER;
    private static Logger LOGGER;
    private ProximityInputDevice proximityInputDevice;
    private TouchInputDevice touchInputDevice;
    protected final ProximityInputDeviceHandler proximityInputDeviceHandler = new ProximityInputDeviceHandler(this);
    protected final TouchInputDeviceHandler touchInputDeviceHandler = new TouchInputDeviceHandler(this);
    private CowList inputManagerListeners = CowList.EMPTY;

    public InputManagerImpl() {
        this.addInputManagerListener(new InputManagerImpl$ProximityGestureSuppressor(this));
        LOGGER = ServiceManager.loggerFactory.getLogger(16384);
        InputManagerImpl.normal().append("Input Manager started.").log();
    }

    @Override
    public void registerInputDevice(InputDevice inputDevice) {
        switch (inputDevice.getType()) {
            case 1: {
                this.proximityInputDevice = (ProximityInputDevice)inputDevice;
                this.proximityInputDevice.addInputDeviceListener(this.proximityInputDeviceHandler);
                InputManagerImpl.normal().append("Proximity input device registered.").log();
                break;
            }
            case 0: {
                this.touchInputDevice = (TouchInputDevice)inputDevice;
                this.touchInputDevice.addInputDeviceListener(this.touchInputDeviceHandler);
                InputManagerImpl.normal().append("Touch input device registered.").log();
                break;
            }
        }
    }

    @Override
    public void unregisterInputDevice(InputDevice inputDevice) {
        switch (inputDevice.getType()) {
            case 1: {
                this.proximityInputDevice.removeInputDeviceListener(this.proximityInputDeviceHandler);
                this.proximityInputDevice = null;
                InputManagerImpl.normal().append("Proximity input device unregistered.").log();
                break;
            }
            case 0: {
                this.touchInputDevice.removeInputDeviceListener(this.touchInputDeviceHandler);
                this.touchInputDevice = null;
                InputManagerImpl.normal().append("Touch input device unregistered.").log();
                break;
            }
        }
    }

    @Override
    public void addInputManagerListener(InputManagerListener inputManagerListener) {
        this.inputManagerListeners = this.inputManagerListeners.addIfAbsent(inputManagerListener);
    }

    @Override
    public void removeInputManagerListener(InputManagerListener inputManagerListener) {
        this.inputManagerListeners = this.inputManagerListeners.remove(inputManagerListener);
    }

    @Override
    public void notifyUserInteractionStarted(int n, int n2) {
        for (CowList cowList = this.inputManagerListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            InputManagerListener inputManagerListener = (InputManagerListener)cowList.head();
            inputManagerListener.userInteractionStarted(n, n2);
        }
    }

    @Override
    public void notifyUserInteractionStopped(int n, int n2) {
        for (CowList cowList = this.inputManagerListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            InputManagerListener inputManagerListener = (InputManagerListener)cowList.head();
            inputManagerListener.userInteractionStopped(n, n2);
        }
    }

    protected static LogMessage trace() {
        return LOGGER.trace(8);
    }

    protected static boolean isTracingEnabled() {
        return LOGGER.isTraceEnabled(8);
    }

    protected static LogMessage normal() {
        return LOGGER.normal(8);
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

