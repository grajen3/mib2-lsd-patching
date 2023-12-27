/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.state;

import java.io.Serializable;
import java.util.Set;

public interface State
extends Serializable {
    public static final String DEFAULT_STATE_IMPL;

    default public void load() {
    }

    default public Set getNodes() {
    }

    default public void store(Set set) {
    }

    default public void store(Set set, long l) {
    }

    default public long getSynchInterval() {
    }
}

