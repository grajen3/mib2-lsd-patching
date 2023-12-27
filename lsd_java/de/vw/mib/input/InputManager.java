/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input;

import de.vw.mib.input.InputManagerListener;
import de.vw.mib.input.devices.InputDevice;

public interface InputManager {
    default public void registerInputDevice(InputDevice inputDevice) {
    }

    default public void unregisterInputDevice(InputDevice inputDevice) {
    }

    default public void addInputManagerListener(InputManagerListener inputManagerListener) {
    }

    default public void removeInputManagerListener(InputManagerListener inputManagerListener) {
    }
}

