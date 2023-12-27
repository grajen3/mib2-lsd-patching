/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.configuration.helper.FileHelper;
import java.util.Properties;

public class PropertiesReader {
    public Properties readProperties(String string) {
        return FileHelper.readPropertiesFromFile(string);
    }
}

