/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.ConfigurationAttributes;
import de.vw.mib.graphics.internal.AbstractConfiguration;
import javax.media.opengl.GLCapabilities;

public final class GLConfiguration
extends AbstractConfiguration {
    private final GLCapabilities glCapabilities;

    public GLConfiguration(ConfigurationAttributes configurationAttributes, GLCapabilities gLCapabilities) {
        super(configurationAttributes);
        this.glCapabilities = gLCapabilities;
    }

    public GLCapabilities getGLCapabilities() {
        return this.glCapabilities;
    }
}

