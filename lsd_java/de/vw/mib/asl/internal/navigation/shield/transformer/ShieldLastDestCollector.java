/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.transformer;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.search.SearchResult;

public class ShieldLastDestCollector {
    public int id;
    public FixFormatterFieldData fieldData;
    public float lat;
    public float lon;
    public SearchResult res;
    public ResourceLocator resourceLocator;

    public ShieldLastDestCollector(SearchResult searchResult) {
        this.res = searchResult;
        this.id = searchResult.getListPosition();
        this.fieldData = ASLNavigationUtilFactory.getNavigationUtilApi().prepareFixFormatterFieldData(searchResult);
        this.lat = searchResult.position.lat;
        this.lon = searchResult.position.lon;
    }

    public int getIconId() {
        if (this.res.getSource() == -101) {
            return 5;
        }
        switch (this.res.entryType) {
            case 16: {
                if (this.res.getSource() == -100) {
                    return 0;
                }
                return 1;
            }
            case 64: {
                return 7;
            }
            case 4: {
                return 2;
            }
            case 32: {
                return 3;
            }
            case 2: {
                if (this.res.getSource() == -100) {
                    return 6;
                }
                return 4;
            }
        }
        return 0;
    }
}

