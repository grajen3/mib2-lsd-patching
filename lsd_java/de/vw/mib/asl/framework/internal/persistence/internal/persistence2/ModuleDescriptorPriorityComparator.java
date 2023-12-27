/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import java.util.Comparator;

public class ModuleDescriptorPriorityComparator
implements Comparator {
    private static final int ENTERTAINMENT_MANAGER;
    private static final int MEDIA;
    private static final int SOUND;
    private static final int AM_FM;
    private static final int[] NAMESPACE_ORDER;
    private static final int NO_PRIORITY;
    public static final Comparator COMPERATOR;

    private ModuleDescriptorPriorityComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        int n;
        if (object == object2) {
            return 0;
        }
        ModuleDescriptor moduleDescriptor = (ModuleDescriptor)object;
        ModuleDescriptor moduleDescriptor2 = (ModuleDescriptor)object2;
        int n2 = moduleDescriptor.getNamespace();
        if (n2 == (n = moduleDescriptor2.getNamespace())) {
            return 1;
        }
        int n3 = this.priorityOf(n2);
        if (n3 == -129) {
            return 1;
        }
        int n4 = this.priorityOf(n);
        return n3 - n4;
    }

    public int priorityOf(int n) {
        for (int i2 = 0; i2 < NAMESPACE_ORDER.length; ++i2) {
            int n2 = NAMESPACE_ORDER[i2];
            if (n2 != n) continue;
            return i2;
        }
        return -129;
    }

    static {
        NAMESPACE_ORDER = new int[]{5061, 5057, 5056, 5052};
        COMPERATOR = new ModuleDescriptorPriorityComparator();
    }
}

