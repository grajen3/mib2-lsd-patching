/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.displaymanagement;

import de.vw.mib.asl.framework.api.displaymanagement.displayable.DisplayableService;
import de.vw.mib.asl.framework.api.displaymanagement.displayable.DisplayableServiceAdapter;
import de.vw.mib.asl.framework.api.displaymanagement.displayable.DisplayableServiceListener;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DisplayableServiceImpl
implements DisplayableService {
    private final List listeners = new ArrayList();
    private final IntIntMap mapDsiToDisplayable = this.createDsiToDisplayableMapping();
    private IntArrayList shownDisplayables = new IntArrayList();

    @Override
    public boolean isDisplayableShown(int n) {
        return this.shownDisplayables.contains(n);
    }

    @Override
    public void addListener(DisplayableServiceListener displayableServiceListener) {
        this.verifyListener(displayableServiceListener);
        this.listeners.add(displayableServiceListener);
    }

    @Override
    public void removeListener(DisplayableServiceListener displayableServiceListener) {
        this.listeners.remove(displayableServiceListener);
    }

    public void updateDisplayables(int[] nArray) {
        IntArrayList intArrayList = this.shownDisplayables;
        this.shownDisplayables = new IntArrayList();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            if (!this.mapDsiToDisplayable.containsKey(n)) continue;
            this.shownDisplayables.add(this.mapDsiToDisplayable.get(n));
        }
        this.notifyListeners(this.shownDisplayables, intArrayList);
    }

    private void verifyListener(DisplayableServiceListener displayableServiceListener) {
        if (displayableServiceListener == null) {
            throw new IllegalArgumentException("Listener must not be null.");
        }
        if (!(displayableServiceListener instanceof DisplayableServiceAdapter)) {
            throw new IllegalArgumentException("Listener must extend the DisplayableServiceAdapter");
        }
        if (this.listeners.contains(displayableServiceListener)) {
            throw new IllegalArgumentException("Listener was added before.");
        }
    }

    private void notifyListeners(IntArrayList intArrayList, IntArrayList intArrayList2) {
        IntArrayList intArrayList3 = this.subtract(intArrayList, intArrayList2);
        for (int i2 = 0; i2 < intArrayList3.size(); ++i2) {
            this.notifyListenersDisplayableShown(intArrayList3.get(i2));
        }
        IntArrayList intArrayList4 = this.subtract(intArrayList2, intArrayList);
        for (int i3 = 0; i3 < intArrayList4.size(); ++i3) {
            this.notifyListenersDisplayableHidden(intArrayList4.get(i3));
        }
    }

    private void notifyListenersDisplayableShown(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DisplayableServiceListener displayableServiceListener = (DisplayableServiceListener)iterator.next();
            displayableServiceListener.onDisplayableShown(n);
        }
    }

    private void notifyListenersDisplayableHidden(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DisplayableServiceListener displayableServiceListener = (DisplayableServiceListener)iterator.next();
            displayableServiceListener.onDisplayableHidden(n);
        }
    }

    private IntIntMap createDsiToDisplayableMapping() {
        IntIntOptHashMap intIntOptHashMap = new IntIntOptHashMap();
        intIntOptHashMap.put(16, 1);
        intIntOptHashMap.put(17, 2);
        intIntOptHashMap.put(19, 3);
        intIntOptHashMap.put(59, 4);
        return intIntOptHashMap;
    }

    private IntArrayList subtract(IntArrayList intArrayList, IntArrayList intArrayList2) {
        IntArrayList intArrayList3 = new IntArrayList();
        IntIterator intIterator = intArrayList.iterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            if (intArrayList2.contains(n)) continue;
            intArrayList3.add(n);
        }
        return intArrayList3;
    }
}

