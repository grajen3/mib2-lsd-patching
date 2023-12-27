/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.transformer;

import de.vw.mib.asl.api.devicehandling.Device;
import generated.de.vw.mib.asl.internal.avdc.transformer.AbstractAVDCUsbDeviceMountedTransformer;

public class AVDCUsbDeviceMountedTransformer
extends AbstractAVDCUsbDeviceMountedTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        Device device = (Device)object;
        switch (n) {
            case 0: {
                return device.getCurrentState().isMediaInSlot();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }
}

