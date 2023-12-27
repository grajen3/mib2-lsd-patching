/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.model;

import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import java.util.ArrayList;

public class WorkUnitModelUtil {
    public AbstractWorkUnit[] findDynamicWorkUnits(AbstractWorkUnit[] abstractWorkUnitArray, boolean bl) {
        ArrayList arrayList = new ArrayList();
        if (abstractWorkUnitArray != null) {
            for (int i2 = 0; i2 < abstractWorkUnitArray.length; ++i2) {
                if (abstractWorkUnitArray[i2].isDynamic() != bl) continue;
                arrayList.add(abstractWorkUnitArray[i2]);
            }
        }
        return (AbstractWorkUnit[])arrayList.toArray(new AbstractWorkUnit[arrayList.size()]);
    }
}

