/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.nar;

import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldCollector;
import java.util.Comparator;
import org.dsi.ifc.search.SearchResult;

public class SearchResultComparator
implements Comparator {
    private String sortingBy = "position";
    private boolean ascending = true;

    @Override
    public int compare(Object object, Object object2) {
        if (object instanceof ShieldCollector && object2 instanceof ShieldCollector) {
            SearchResult searchResult = ((ShieldCollector)object).res;
            SearchResult searchResult2 = ((ShieldCollector)object2).res;
            if (this.sortingBy.equals("position")) {
                Integer n = new Integer(searchResult.getListPosition());
                Integer n2 = new Integer(searchResult2.getListPosition());
                if (this.ascending) {
                    return n.compareTo(n2);
                }
                return n2.compareTo(n);
            }
            if (this.sortingBy.equals("distance")) {
                Integer n = new Integer(searchResult.distanceMeters);
                Integer n3 = new Integer(searchResult2.distanceMeters);
                if (this.ascending) {
                    return n.compareTo(n3);
                }
                return n3.compareTo(n);
            }
        }
        return 0;
    }

    public void setSortingBy(String string) {
        this.sortingBy = string;
    }

    public void setDescending() {
        this.ascending = false;
    }

    public void setAscending() {
        this.ascending = true;
    }
}

