/*
 * Decompiled with CFR 0.152.
 */
package org.elektrobit.json.simple.parser;

import java.util.List;
import java.util.Map;

public interface ContainerFactory {
    default public Map createObjectContainer() {
    }

    default public List creatArrayContainer() {
    }
}

