/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.state;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.id.uuid.state.Node;
import org.apache.commons.id.uuid.state.State;
import org.apache.commons.id.uuid.state.StateHelper;

public class InMemoryStateImpl
implements State {
    private static HashSet nodes = new HashSet(1);

    @Override
    public void load() {
        Node node = new Node(StateHelper.randomNodeIdentifier());
        nodes.add(node);
    }

    @Override
    public Set getNodes() {
        return nodes;
    }

    @Override
    public void store(Set set) {
    }

    @Override
    public void store(Set set, long l) {
    }

    @Override
    public long getSynchInterval() {
        return Long.MAX_VALUE;
    }
}

