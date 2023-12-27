/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal;

import de.vw.mib.graphics.Configuration;
import de.vw.mib.graphics.ConfigurationAttributes;

public abstract class AbstractConfiguration
implements Configuration {
    private final ConfigurationAttributes configAttribs;

    public AbstractConfiguration(ConfigurationAttributes configurationAttributes) {
        this.configAttribs = configurationAttributes;
    }

    @Override
    public final ConfigurationAttributes getConfigurationAttributes() {
        return this.configAttribs;
    }
}

