/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.transformer;

import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldResultConnectorDetailsCollector;
import generated.de.vw.mib.asl.internal.navigation.shield.transformer.AbstractNavigationShieldResultConnectorDetailsTransformer;

public class NavigationShieldResultConnectorDetailsTransformer
extends AbstractNavigationShieldResultConnectorDetailsTransformer {
    @Override
    public String getString(int n, Object object) {
        String string = "";
        ShieldResultConnectorDetailsCollector shieldResultConnectorDetailsCollector = (ShieldResultConnectorDetailsCollector)object;
        switch (n) {
            case 1: {
                string = shieldResultConnectorDetailsCollector.chargeMode;
                break;
            }
            case 2: {
                string = shieldResultConnectorDetailsCollector.chargeLevel;
                break;
            }
            case 3: {
                string = shieldResultConnectorDetailsCollector.name;
                break;
            }
            case 5: {
                string = shieldResultConnectorDetailsCollector.fuseProtection;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return string;
    }

    @Override
    public int getInt(int n, Object object) {
        ShieldResultConnectorDetailsCollector shieldResultConnectorDetailsCollector = (ShieldResultConnectorDetailsCollector)object;
        switch (n) {
            case 0: {
                return shieldResultConnectorDetailsCollector.count;
            }
            case 6: {
                return shieldResultConnectorDetailsCollector.poweroutput;
            }
            case 4: {
                return shieldResultConnectorDetailsCollector.type;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain integer values.");
    }
}

