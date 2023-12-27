/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.map;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.AbstractDualListViewHandlerUpdateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListViewListener;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractDualListViewHandler
implements ASLListViewListener {
    private int mapFlagType = 0;
    private boolean startScrollEventSent;
    private AbstractDualListViewHandlerUpdateListener listener;

    public AbstractDualListViewHandler(ASLList aSLList) {
    }

    public AbstractDualListViewHandler() {
    }

    public AbstractDualListViewHandler(AbstractDualListViewHandlerUpdateListener abstractDualListViewHandlerUpdateListener) {
        this.listener = abstractDualListViewHandlerUpdateListener;
    }

    @Override
    public void listViewUpdated(ASLList aSLList, int n, int n2, Object[] objectArray) {
        ServiceManager.logger2.trace(16384).append("AbstractDualListViewHandler.listViewUpdated()").log();
        NavLocation[] navLocationArray = new NavLocation[objectArray.length];
        boolean bl = n == -1 && n2 > 0;
        ServiceManager.aslPropertyManager.valueChangedBoolean(519049216, !bl);
        if (this.listener != null) {
            this.listener.listViewUpdated(bl, aSLList, n, n2, objectArray);
        }
        if (!bl) {
            ServiceManager.logger2.trace(16384).append("AbstractDualListViewHandler: NO scrolling, #items: ").append(n2).log();
            this.startScrollEventSent = false;
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                NavLocation navLocation;
                Object object = objectArray[i2];
                if (!aSLList.isValidItem(object)) continue;
                navLocationArray[i2] = navLocation = this.navLocationFromListItem(object);
            }
            ASLNavigationMapFactory.getNavigationMapApi().sendEvListViewUpdate(navLocationArray, this.mapFlagType);
            ServiceManager.aslPropertyManager.valueChangedInteger(0x1FF01000, n);
        } else {
            ServiceManager.logger2.trace(16384).append("AbstractDualListViewHandler: scrolling active").append(n2).log();
            if (!this.startScrollEventSent) {
                this.startScrollEventSent = true;
                ASLNavigationMapFactory.getNavigationMapApi().sendEvListViewStartScroll();
            }
        }
    }

    public abstract NavLocation navLocationFromListItem(Object object) {
    }

    public void setMapFlagType(int n) {
        this.mapFlagType = n;
    }
}

