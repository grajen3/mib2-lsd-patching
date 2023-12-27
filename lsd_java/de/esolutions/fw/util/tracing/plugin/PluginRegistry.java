/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.plugin;

import de.esolutions.fw.util.tracing.plugin.ITracePlugin;
import de.esolutions.fw.util.tracing.util.ObjectFactory;

public class PluginRegistry
extends ObjectFactory {
    private static PluginRegistry registry;

    public static PluginRegistry getInstance() {
        if (registry == null) {
            registry = new PluginRegistry();
        }
        return registry;
    }

    public ITracePlugin createPlugin(String string) {
        return (ITracePlugin)super.create(string);
    }
}

