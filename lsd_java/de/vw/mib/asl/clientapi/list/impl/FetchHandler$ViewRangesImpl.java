/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.list.Coverage;
import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.list.HMIListViewRangesAdapter;
import de.vw.mib.list.Range;

class FetchHandler$ViewRangesImpl
extends HMIListViewRangesAdapter {
    private final Coverage mostRecent;
    private final Coverage visible;
    private final Coverage prefetch;

    static FetchHandler$ViewRangesImpl create(HMIListDataFactory hMIListDataFactory) {
        Coverage coverage = hMIListDataFactory.createCoverage();
        Coverage coverage2 = hMIListDataFactory.createCoverage();
        Coverage coverage3 = hMIListDataFactory.createCoverage();
        return new FetchHandler$ViewRangesImpl(coverage, coverage2, coverage3);
    }

    private FetchHandler$ViewRangesImpl(Coverage coverage, Coverage coverage2, Coverage coverage3) {
        this.mostRecent = coverage;
        this.visible = coverage2;
        this.prefetch = coverage3;
    }

    void clear() {
        this.mostRecent.clear();
        this.visible.clear();
        this.prefetch.clear();
    }

    Range getNextFetchRange(Coverage coverage) {
        Range range;
        if (coverage.isEmpty()) {
            range = null;
        } else {
            range = this.mostRecent.getFirstIntersection(coverage);
            if (null == range) {
                range = this.visible.getFirstIntersection(coverage);
            }
            if (null == range) {
                range = this.prefetch.getFirstIntersection(coverage);
            }
        }
        return range;
    }

    @Override
    public void addMostRecentViewRange(int n, int n2) {
        this.mostRecent.addRange(n, n2);
    }

    @Override
    public void addVisibleViewRange(int n, int n2) {
        this.visible.addRange(n, n2);
    }

    @Override
    public void addPrefetchViewRange(int n, int n2) {
        this.prefetch.addRange(n, n2);
    }
}

