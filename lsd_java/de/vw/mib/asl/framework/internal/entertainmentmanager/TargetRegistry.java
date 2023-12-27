/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentContext;
import de.vw.mib.asl.framework.internal.entertainmentmanager.DefaultEntertainmentContext;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import java.util.Iterator;

public class TargetRegistry {
    private final IntObjectOptHashMap contexts = new IntObjectOptHashMap(11);
    private final IntOptHashSet handshaking = new IntOptHashSet(2);

    private static int defaultViewChangeEvent(int n) {
        switch (n) {
            case 1: {
                return 459;
            }
            case 2: {
                return 458;
            }
            case 4: {
                return 509;
            }
            case 5: {
                return 508;
            }
        }
        return -1;
    }

    public EntertainmentContext get(int n) {
        return (EntertainmentContext)this.contexts.get(n);
    }

    public boolean isContextRegistered(int n) {
        return this.contexts.get(n) != null && !this.handshaking.contains(n);
    }

    public int getTargetIdForContext(int n) {
        if (this.contexts.get(n) != null) {
            return ((EntertainmentContext)this.contexts.get(n)).targetId();
        }
        return -1;
    }

    public void finishHandshake(int n) {
        if (!this.handshaking.contains(n)) {
            throw new IllegalStateException(new StringBuffer().append("finishing handshake for context ").append(n).append(", but map does not contain half-initialized value.").toString());
        }
        this.handshaking.remove(n);
    }

    public boolean isDeactivateOnSubcontextSwitchForContext(int n) {
        return ((EntertainmentContext)this.contexts.get(n)).isDeactivateOnSubcontextSwitch();
    }

    public void register(int n, int n2, int n3, boolean bl, int n4, boolean bl2) {
        if (n4 == -1) {
            n4 = TargetRegistry.defaultViewChangeEvent(n2);
        }
        DefaultEntertainmentContext defaultEntertainmentContext = new DefaultEntertainmentContext(n2, n, bl, n3, n4);
        this.register(defaultEntertainmentContext, bl2);
    }

    public void register(EntertainmentContext entertainmentContext, boolean bl) {
        int n = entertainmentContext.contextId();
        if (bl) {
            this.handshaking.add(n);
        } else {
            this.handshaking.remove(n);
        }
        this.contexts.put(n, entertainmentContext);
    }

    public int deregisterByTargetId(int n) {
        int n2 = -1;
        Iterator iterator = this.contexts.valueIterator();
        while (iterator.hasNext()) {
            EntertainmentContext entertainmentContext = (EntertainmentContext)iterator.next();
            if (entertainmentContext.targetId() != n) continue;
            iterator.remove();
            n2 = entertainmentContext.contextId();
        }
        return n2;
    }

    public void deregisterByContext(int n) {
        this.contexts.remove(n);
    }
}

