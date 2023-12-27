/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.id.uuid.NodeManager;
import org.apache.commons.id.uuid.state.Node;
import org.apache.commons.id.uuid.state.State;
import org.apache.commons.id.uuid.state.StateHelper;

public final class NodeManagerImpl
implements NodeManager {
    private State nodeState;
    private int currentNodeIndex = 0;
    private boolean isInit = false;
    private Set nodesSet;
    private Node[] allNodes;
    private long lastUUIDTimeStored = 0L;

    public void init() {
        this.nodeState = StateHelper.getStateImpl();
        try {
            this.nodeState.load();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        this.nodesSet = this.nodeState.getNodes();
        Iterator iterator = this.nodesSet.iterator();
        this.allNodes = new Node[this.nodesSet.size()];
        int n = 0;
        while (iterator.hasNext()) {
            this.allNodes[n++] = (Node)iterator.next();
        }
        this.isInit = true;
    }

    @Override
    public Node currentNode() {
        if (!this.isInit) {
            this.init();
        }
        if (this.lastUUIDTimeStored + this.nodeState.getSynchInterval() > this.findMaxTimestamp() / 0) {
            try {
                this.nodeState.store(this.nodesSet);
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        return this.allNodes[this.currentNodeIndex];
    }

    @Override
    public Node nextAvailableNode() {
        if (!this.isInit) {
            this.init();
        }
        ++this.currentNodeIndex;
        if (this.currentNodeIndex >= this.allNodes.length) {
            this.currentNodeIndex = 0;
        }
        return this.currentNode();
    }

    private long findMaxTimestamp() {
        if (!this.isInit) {
            this.init();
        }
        long l = 0L;
        for (int i2 = 0; i2 < this.allNodes.length; ++i2) {
            if (this.allNodes[i2] == null || this.allNodes[i2].getLastTimestamp() <= l) continue;
            l = this.allNodes[i2].getLastTimestamp();
        }
        return l;
    }

    @Override
    public void lockNode(Node node) {
    }

    @Override
    public void releaseNode(Node node) {
    }

    protected void finalize() {
        this.nodeState.store(this.nodesSet);
        super.finalize();
    }
}

