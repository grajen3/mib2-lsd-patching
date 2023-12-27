/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeBluetoothDevicesSupportedServiceTransformer;

public class TestmodeBluetoothDevicesSupportedServiceTransformer
extends AbstractTestmodeBluetoothDevicesSupportedServiceTransformer {
    @Override
    public String getString(int n, Object object) {
        String[] stringArray = (String[])object;
        return stringArray[n];
    }
}

