/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple;

import java.io.Writer;

public interface JSONStreamAware {
    default public void writeJSONString(Writer writer) {
    }
}

