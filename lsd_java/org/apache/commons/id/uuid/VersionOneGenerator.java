/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.discovery.tools.DiscoverSingleton
 */
package org.apache.commons.id.uuid;

import org.apache.commons.discovery.tools.DiscoverSingleton;
import org.apache.commons.id.IdentifierGenerator;
import org.apache.commons.id.uuid.Bytes;
import org.apache.commons.id.uuid.Constants;
import org.apache.commons.id.uuid.NodeManager;
import org.apache.commons.id.uuid.UUID;
import org.apache.commons.id.uuid.clock.OverClockedException;
import org.apache.commons.id.uuid.state.Node;

public final class VersionOneGenerator
implements IdentifierGenerator,
Constants {
    private static final int NODE_ID_BYTE_LENGTH;
    private static final int CLOCK_HI_VARIANT_BYTE8;
    private static final int CLOCK_LOW_BYTE9;
    private static final int NODE_ID_BYTE10;
    private static final String DEFAULT_NODEMANAGER_IMPL;
    private NodeManager manager = (NodeManager)DiscoverSingleton.find((Class)(class$org$apache$commons$id$uuid$NodeManager == null ? (class$org$apache$commons$id$uuid$NodeManager = VersionOneGenerator.class$("org.apache.commons.id.uuid.NodeManager")) : class$org$apache$commons$id$uuid$NodeManager), (String)DEFAULT_NODEMANAGER_IMPL);
    private static VersionOneGenerator generator;
    static /* synthetic */ Class class$org$apache$commons$id$uuid$NodeManagerImpl;
    static /* synthetic */ Class class$org$apache$commons$id$uuid$NodeManager;

    private VersionOneGenerator() {
    }

    public static VersionOneGenerator getInstance() {
        if (generator == null) {
            generator = new VersionOneGenerator();
        }
        return generator;
    }

    @Override
    public Object nextIdentifier() {
        return this.nextUUID();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized UUID nextUUID() {
        byte[] byArray = new byte[16];
        long l = 0L;
        short s = 0;
        Node node = this.manager.currentNode();
        while (l < 1L) {
            try {
                this.manager.lockNode(node);
                l = node.getUUIDTime();
                s = node.getClockSequence();
                System.arraycopy((Object)node.getNodeIdentifier(), 0, (Object)byArray, 10, 6);
                this.manager.releaseNode(node);
            }
            catch (OverClockedException overClockedException) {
                node = this.manager.nextAvailableNode();
            }
            finally {
                this.manager.releaseNode(node);
            }
        }
        byte[] byArray2 = Bytes.toBytes(l);
        System.arraycopy((Object)byArray2, 4, (Object)byArray, 0, 4);
        System.arraycopy((Object)byArray2, 2, (Object)byArray, 4, 2);
        System.arraycopy((Object)byArray2, 0, (Object)byArray, 6, 2);
        byArray[6] = (byte)(byArray[6] | 0x10);
        byArray[8] = (byte)((s & 0x3F00) >>> 8);
        byArray[8] = (byte)(byArray[8] | 0x80);
        byArray[9] = (byte)(s & 0xFF);
        return new UUID(byArray);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    static {
        DEFAULT_NODEMANAGER_IMPL = (class$org$apache$commons$id$uuid$NodeManagerImpl == null ? (class$org$apache$commons$id$uuid$NodeManagerImpl = VersionOneGenerator.class$("org.apache.commons.id.uuid.NodeManagerImpl")) : class$org$apache$commons$id$uuid$NodeManagerImpl).getName();
    }
}

