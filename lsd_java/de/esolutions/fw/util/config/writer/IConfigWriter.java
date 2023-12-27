/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.writer;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import java.io.OutputStream;

public interface IConfigWriter {
    default public void writeToOutputStream(OutputStream outputStream, ConfigValue configValue, ConfigDictionary configDictionary) {
    }
}

