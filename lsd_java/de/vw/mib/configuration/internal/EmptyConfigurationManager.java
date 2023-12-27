/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.configuration.internal.ConfigurationManagerImpl;
import java.util.Properties;

public class EmptyConfigurationManager
extends ConfigurationManagerImpl {
    protected Properties properties;

    public EmptyConfigurationManager() {
        super(null);
    }

    public String getDefaultEncodedVehicleType() {
        return "0000000000";
    }
}

