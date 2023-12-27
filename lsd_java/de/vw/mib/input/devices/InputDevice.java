/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.devices;

import de.vw.mib.input.devices.InputDeviceListener;
import de.vw.mib.input.devices.InputDeviceType;

public interface InputDevice
extends InputDeviceType {
    default public void addInputDeviceListener(InputDeviceListener inputDeviceListener) {
    }

    default public void removeInputDeviceListener(InputDeviceListener inputDeviceListener) {
    }
}

