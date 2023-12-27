/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.nar;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLListViewListener;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldCollector;
import de.vw.mib.asl.internal.navigation.shield.transformer.ShieldResultConnectorDetailsCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.locationinput.transformer.NavigationLocationInputNextRefinementsCollector;
import generated.de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldLocationCollector;
import java.util.Collection;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class ShieldModelNotifier {
    static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "ShieldModelNotifier");

    ShieldCollector getSearchResultFromListByIndex(int n) {
        return (ShieldCollector)ListManager.getGenericASLList(1710231552).getRowItem(n);
    }

    void updateSearchResultList(Collection collection) {
        NavigationShieldListInfoCollector navigationShieldListInfoCollector = new NavigationShieldListInfoCollector();
        navigationShieldListInfoCollector.navigation_shield_list_info_size = collection.size();
        ListManager.getGenericASLList(1710231552).updateList(collection.toArray());
        ListManager.getGenericASLList(1727008768).updateList(new Object[]{navigationShieldListInfoCollector});
    }

    void updateMapSearchResultList(Collection collection) {
        ListManager.getGenericASLList(-1729097728).updateList(collection.toArray());
    }

    void registerDualListViewHandler(ASLListViewListener aSLListViewListener) {
        ListManager.getGenericASLList(-1729097728).addListViewListener(aSLListViewListener);
    }

    void updateLocationIcon(ResourceLocator resourceLocator) {
        GenericASLList genericASLList = ListManager.getGenericASLList(1777340416);
        NavigationShieldLocationCollector navigationShieldLocationCollector = (NavigationShieldLocationCollector)genericASLList.getRowItem(0);
        navigationShieldLocationCollector.navigation_shield_location_icon = resourceLocator;
        genericASLList.updateListItem(0, navigationShieldLocationCollector);
    }

    void updateSelectedSearchResult(NavigationShieldLocationCollector navigationShieldLocationCollector) {
        ListManager.getGenericASLList(1777340416).updateList(new Object[]{navigationShieldLocationCollector});
    }

    public void notifyConnectorDetails(ShieldResultConnectorDetailsCollector[] shieldResultConnectorDetailsCollectorArray) {
        ListManager.getGenericASLList(-1007677440).updateList(shieldResultConnectorDetailsCollectorArray);
    }

    void updateRefinementsForHNO(boolean bl, boolean bl2) {
        GenericASLList genericASLList = ListManager.getGenericASLList(2829);
        NavigationLocationInputNextRefinementsCollector navigationLocationInputNextRefinementsCollector = (NavigationLocationInputNextRefinementsCollector)genericASLList.getRowItem(0);
        ShieldModelNotifier.printTrace(new StringBuffer().append("updateRefinementsForHNO, hnoAvailable=").append(bl).toString());
        ShieldModelNotifier.printTrace(new StringBuffer().append("updateRefinementsForHNO, hnoAlternativesAvailable=").append(bl2).toString());
        navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_housenumber_alternative_available = bl2;
        navigationLocationInputNextRefinementsCollector.navigation_locationinput_next_refinements_housenumber_match_or_alternative_available = bl;
        genericASLList.updateListItem(0, navigationLocationInputNextRefinementsCollector);
    }

    void updateSearchStatus(boolean bl) {
        ShieldModelNotifier.printTrace(new StringBuffer().append("updateSearchStatus: ").append(bl).toString());
        ServiceManager.aslPropertyManager.valueChangedInteger(2079330304, bl ? 1 : 0);
    }

    void setHousenumberAlternativesAvailable(boolean bl) {
        ShieldModelNotifier.printTrace(new StringBuffer().append("setHousenumberAlternativesAvailable: ").append(bl).toString());
        if (bl) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-2047864832, true);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-2047864832, false);
        }
    }

    public void setCurrentSearchLocation(NavLocation navLocation) {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        FixFormatterFieldData fixFormatterFieldData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
        ServiceManager.aslPropertyManager.valueChangedFixFormatterFieldData(-1712320512, fixFormatterFieldData);
    }

    void resetSearchResultListCount() {
        GenericASLList genericASLList = ListManager.getGenericASLList(1727008768);
        NavigationShieldListInfoCollector navigationShieldListInfoCollector = (NavigationShieldListInfoCollector)genericASLList.getRowItem(0);
        navigationShieldListInfoCollector.navigation_shield_list_info_size = 0;
        genericASLList.updateListItem(0, navigationShieldListInfoCollector);
    }

    void quitModelWaitstate(String string) {
        ShieldModelNotifier.printTrace(new StringBuffer().append("quitModelWaitstate with reason=").append(string).toString());
        ServiceManager.aslPropertyManager.valueChangedBoolean(1693454336, true);
    }

    public void setNextPageAvailable(boolean bl) {
        if (bl) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1745874944, true);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1745874944, false);
        }
    }

    static void printTrace(String string) {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append(string).log();
        }
    }
}

