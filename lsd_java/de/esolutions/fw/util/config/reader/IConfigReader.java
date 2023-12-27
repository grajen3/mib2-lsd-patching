/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.reader;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import java.io.InputStream;

public interface IConfigReader {
    default public ConfigValue readFromInputStream(InputStream inputStream, ConfigDictionary configDictionary) {
    }
}

