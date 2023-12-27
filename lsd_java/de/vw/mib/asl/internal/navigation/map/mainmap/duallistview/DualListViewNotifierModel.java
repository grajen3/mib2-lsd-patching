/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.duallistview;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.map.duallistview.transformer.NavigationMapDualListViewDualListViewIconsCollector;
import org.dsi.ifc.global.ResourceLocator;

public class DualListViewNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DualListViewNotifierModel]");
    private final NavigationMapDualListViewDualListViewIconsCollector collectorIcons;
    private final NavigationMapDualListViewDualListViewIconsCollector[] collectorIconsArray;
    private final GenericASLList listIcons = ListManager.getGenericASLList(703598592);

    public DualListViewNotifierModel() {
        Object object = this.listIcons.getRowItemCacheOnly(0);
        this.collectorIcons = object instanceof NavigationMapDualListViewDualListViewIconsCollector ? (NavigationMapDualListViewDualListViewIconsCollector)object : new NavigationMapDualListViewDualListViewIconsCollector();
        this.collectorIconsArray = new NavigationMapDualListViewDualListViewIconsCollector[]{this.collectorIcons};
    }

    public void setFlagIcon(int n, ResourceLocator resourceLocator) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setFlagIcon(index=").append(n).append(")").log();
        }
        switch (n) {
            case 71: {
                this.collectorIcons.navigation_map_duallistview_dual_list_view_icon1 = resourceLocator;
                break;
            }
            case 72: {
                this.collectorIcons.navigation_map_duallistview_dual_list_view_icon2 = resourceLocator;
                break;
            }
            case 73: {
                this.collectorIcons.navigation_map_duallistview_dual_list_view_icon3 = resourceLocator;
                break;
            }
            case 74: {
                this.collectorIcons.navigation_map_duallistview_dual_list_view_icon4 = resourceLocator;
                break;
            }
            case 75: {
                this.collectorIcons.navigation_map_duallistview_dual_list_view_icon5 = resourceLocator;
                break;
            }
            case 76: {
                this.collectorIcons.navigation_map_duallistview_dual_list_view_icon6 = resourceLocator;
                break;
            }
            case 25: {
                this.collectorIcons.navigation_map_duallistview_dual_list_view_icon_default = resourceLocator;
                break;
            }
            default: {
                this.logger.makeWarn().append("setFlagIcons(), index '").append(n).append("' is unknown").log();
            }
        }
        this.listIcons.updateList(this.collectorIconsArray);
    }

    public void setMapReady() {
        this.logger.trace("setMapReady()");
        AbstractASLTarget.writeBooleanToDatapool(-84996096, true);
        AbstractASLTarget.writeBooleanToDatapool(519049216, true);
    }

    public void setLocationIDForClickedPin(int n) {
        this.logger.trace("setLocationIDForClickedPin()");
        AbstractASLTarget.writeIntegerToDatapool(-1477439488, n);
        AbstractASLTarget.writeIntegerToDatapool(-638578688, n);
    }
}

