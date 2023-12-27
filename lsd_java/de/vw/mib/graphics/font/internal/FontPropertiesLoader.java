/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.FontProperties;
import java.io.File;

public interface FontPropertiesLoader {
    public static final String DEFAULT_PROPERTY_FILE_NAME;

    default public FontProperties openFontProperties(int n, File file, String[] stringArray) {
    }
}

