/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid;

import org.apache.commons.id.uuid.state.Node;

public interface NodeManager {
    default public Node currentNode() {
    }

    default public Node nextAvailableNode() {
    }

    default public void lockNode(Node node) {
    }

    default public void releaseNode(Node node) {
    }
}

