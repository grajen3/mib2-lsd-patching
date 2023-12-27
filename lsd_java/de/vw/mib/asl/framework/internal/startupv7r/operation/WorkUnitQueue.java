/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.hmi.utils.Preconditions;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WorkUnitQueue {
    private final List workUnitsToStart = new ArrayList();
    private final Set workUnitsToComplete = new HashSet();
    private final Set completedWorkUnits = new HashSet();
    private final List prioritizedWorkUnits = new ArrayList();

    public WorkUnitQueue(AbstractWorkUnit[] abstractWorkUnitArray) {
        Preconditions.checkArgument(abstractWorkUnitArray != null, "Work units must not be null.");
        this.workUnitsToStart.addAll(Arrays.asList(abstractWorkUnitArray));
    }

    public AbstractWorkUnit poll() {
        Preconditions.checkState(this.checkIsNextWorkUnitAvailable(), "No work unit is available for start.");
        AbstractWorkUnit abstractWorkUnit = this.retrieveNextWorkUnit();
        this.prioritizedWorkUnits.remove(abstractWorkUnit);
        this.moveWorkUnit(abstractWorkUnit, this.workUnitsToStart, this.workUnitsToComplete);
        return abstractWorkUnit;
    }

    public boolean hasPendingWorkUnits() {
        return !this.workUnitsToStart.isEmpty() || !this.workUnitsToComplete.isEmpty();
    }

    public void markAsCompleted(AbstractWorkUnit abstractWorkUnit) {
        Preconditions.checkState(this.workUnitsToComplete.contains(abstractWorkUnit), "Cannot mark work unit as finished since it was not returned by this queue or it was completed before");
        this.moveWorkUnit(abstractWorkUnit, this.workUnitsToComplete, this.completedWorkUnits);
    }

    public boolean checkIsNextWorkUnitAvailable() {
        return this.retrieveNextWorkUnit() != null;
    }

    public void prioritize(AbstractWorkUnit abstractWorkUnit) {
        if (!this.checkIsWorkUnitKnown(abstractWorkUnit)) {
            throw new IllegalArgumentException("The given work unit is not known by this queue.");
        }
        if (!this.prioritizedWorkUnits.contains(abstractWorkUnit) && this.workUnitsToStart.contains(abstractWorkUnit)) {
            this.prioritizedWorkUnits.add(abstractWorkUnit);
        }
    }

    private boolean checkIsWorkUnitKnown(AbstractWorkUnit abstractWorkUnit) {
        return this.workUnitsToStart.contains(abstractWorkUnit) || this.workUnitsToComplete.contains(abstractWorkUnit) || this.completedWorkUnits.contains(abstractWorkUnit);
    }

    private void moveWorkUnit(AbstractWorkUnit abstractWorkUnit, Collection collection, Collection collection2) {
        collection.remove(abstractWorkUnit);
        collection2.add(abstractWorkUnit);
    }

    private AbstractWorkUnit retrieveNextWorkUnit() {
        AbstractWorkUnit abstractWorkUnit = this.retrieveNextWorkUnit(this.prioritizedWorkUnits);
        if (abstractWorkUnit != null) {
            return abstractWorkUnit;
        }
        return this.retrieveNextWorkUnit(this.workUnitsToStart);
    }

    private AbstractWorkUnit retrieveNextWorkUnit(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            AbstractWorkUnit abstractWorkUnit;
            AbstractWorkUnit abstractWorkUnit2 = (AbstractWorkUnit)iterator.next();
            if (!this.workUnitsToStart.contains(abstractWorkUnit2) || (abstractWorkUnit = this.retrieveNextWorkUnit(abstractWorkUnit2)) == null) continue;
            return abstractWorkUnit;
        }
        return null;
    }

    private AbstractWorkUnit retrieveNextWorkUnit(AbstractWorkUnit abstractWorkUnit) {
        Object[] objectArray = abstractWorkUnit.getPreconditions();
        if (objectArray != null && !this.completedWorkUnits.containsAll(Arrays.asList(objectArray))) {
            return this.retrieveNextWorkUnit(Arrays.asList(objectArray));
        }
        return abstractWorkUnit;
    }
}

