/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.jpn;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.poi.jpn.JavaContent;
import de.vw.mib.asl.internal.navigation.poi.jpn.JavaContent$IND;
import de.vw.mib.asl.internal.navigation.poi.jpn.JavaContent$PoiBrand;
import de.vw.mib.asl.internal.navigation.poi.jpn.JavaContent$PoiCategory;
import de.vw.mib.asl.internal.navigation.poi.jpn.JavaContent$PoiClass;
import de.vw.mib.asl.internal.navigation.poi.jpn.PoiJpnEvents;
import de.vw.mib.asl.internal.navigation.poi.jpn.PoiJpnModelNotifier;
import de.vw.mib.asl.internal.navigation.poi.transformer.PoiCatListCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.navigation.poi.category.transformer.NavigationPOICategorySelectedItemCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PoiJpnTarget
extends AbstractNavGatewayTarget {
    static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "PoiJpnTarget");
    private final int LAYER_CLASSES;
    private final int LAYER_CATEGORIES;
    private final int LAYER_BRANDS;
    private int layer;
    private String currentLanguage = "";
    private PoiJpnModelNotifier modelNotifier = new PoiJpnModelNotifier();
    private JavaContent$PoiClass selectedPoiClass = null;
    private JavaContent$PoiCategory selectedPoiCategory = null;
    private JavaContent$PoiBrand selectedPoiBrand = null;

    public PoiJpnTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.LAYER_CLASSES = 0;
        this.LAYER_CATEGORIES = 1;
        this.LAYER_BRANDS = 2;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                PoiJpnTarget.printTrace("NAVI_TARGET_PREPARE_ON");
                PoiJpnEvents.addObservers(this);
                break;
            }
            case 1074841952: {
                this.handleInit();
                break;
            }
            case 1074841954: {
                this.handleUp();
                break;
            }
            case 1074841953: {
                int n = eventGeneric.getInt(0);
                this.handleDown(n);
                break;
            }
        }
    }

    private void handleInit() {
        PoiJpnTarget.printTrace("handleInit");
        this.layer = 0;
        this.selectedPoiClass = null;
        this.selectedPoiCategory = null;
        this.selectedPoiBrand = null;
        this.updateState();
    }

    private void handleDown(int n) {
        PoiJpnTarget.printTrace(new StringBuffer().append("handleDown: ").append(n).toString());
        try {
            switch (this.layer) {
                case 0: {
                    this.selectedPoiClass = (JavaContent$PoiClass)JavaContent.poiClasses.get(new Integer(n));
                    PoiJpnTarget.printTrace("handleDown: currentLayer = LAYER_CLASSES");
                    break;
                }
                case 1: {
                    this.selectedPoiCategory = (JavaContent$PoiCategory)this.selectedPoiClass.categories.get(new Integer(n));
                    PoiJpnTarget.printTrace("handleDown: currentLayer = LAYER_CATEGORIES");
                    break;
                }
                case 2: {
                    this.selectedPoiBrand = (JavaContent$PoiBrand)this.selectedPoiCategory.brands.get(new Integer(n));
                    PoiJpnTarget.printTrace("handleDown: currentLayer = LAYER_BRANDS");
                    break;
                }
                default: {
                    PoiJpnTarget.printTrace(new StringBuffer().append("handleDown: invalid layer (").append(this.layer).append(")").toString());
                }
            }
            ++this.layer;
            this.updateState();
        }
        catch (Exception exception) {
            PoiJpnTarget.printTrace("handleDown: Error going down the poi tree");
        }
    }

    private void handleUp() {
        PoiJpnTarget.printTrace("handleUp");
        switch (this.layer) {
            case 0: {
                this.selectedPoiClass = null;
                PoiJpnTarget.printTrace("handleUp: currentLayer = LAYER_CLASSES");
                break;
            }
            case 1: {
                this.selectedPoiCategory = null;
                PoiJpnTarget.printTrace("handleUp: currentLayer = LAYER_CATEGORIES");
                break;
            }
            case 2: {
                this.selectedPoiBrand = null;
                PoiJpnTarget.printTrace("handleUp: currentLayer = LAYER_BRANDS");
                break;
            }
            default: {
                PoiJpnTarget.printTrace(new StringBuffer().append("handleUp: invalid layer (").append(this.layer).append(")").toString());
            }
        }
        --this.layer;
        this.updateState();
    }

    private void updateState() {
        this.currentLanguage = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getLanguage();
        PoiJpnTarget.printTrace(new StringBuffer().append("updateState: layer=").append(this.layer).toString());
        this.modelNotifier.setLayer(this.layer);
        String string = "";
        String string2 = "";
        ArrayList arrayList = new ArrayList();
        NavigationPOICategorySelectedItemCollector navigationPOICategorySelectedItemCollector = this.getEmptyPoiCollector();
        switch (this.layer) {
            case 0: {
                arrayList = this.getPoiObjects(JavaContent.poiClasses.values());
                PoiJpnTarget.printTrace("updateState: currentLayer = LAYER_CLASSES ");
                break;
            }
            case 1: {
                if (this.selectedPoiClass == null) break;
                arrayList = this.getPoiObjects(this.selectedPoiClass.categories.values());
                navigationPOICategorySelectedItemCollector = this.getPoiSelectedCollectorFromPoiObject(this.selectedPoiClass);
                string2 = (String)this.selectedPoiClass.names.get(this.currentLanguage);
                string = (String)this.selectedPoiClass.truffleNames.get(this.currentLanguage);
                PoiJpnTarget.printTrace(new StringBuffer().append("updateState: currentLayer = LAYER_CATEGORIES selected class ").append(string2).toString());
                break;
            }
            case 2: {
                if (this.selectedPoiCategory == null) break;
                arrayList = this.getPoiObjects(this.selectedPoiCategory.brands.values());
                navigationPOICategorySelectedItemCollector = this.getPoiSelectedCollectorFromPoiObject(this.selectedPoiCategory);
                string2 = (String)this.selectedPoiCategory.names.get(this.currentLanguage);
                string = (String)this.selectedPoiCategory.truffleNames.get(this.currentLanguage);
                PoiJpnTarget.printTrace(new StringBuffer().append("updateState: currentLayer = LAYER_BRANDS selected category ").append(string2).toString());
                break;
            }
            default: {
                if (this.selectedPoiBrand == null) break;
                navigationPOICategorySelectedItemCollector = this.getPoiSelectedCollectorFromPoiObject(this.selectedPoiBrand);
                string2 = (String)this.selectedPoiBrand.names.get(this.currentLanguage);
                string = (String)this.selectedPoiBrand.truffleNames.get(this.currentLanguage);
                PoiJpnTarget.printTrace(new StringBuffer().append("updateState: currentLayer = DEFAULT selected brand ").append(string2).toString());
            }
        }
        if (string != null && !string.equals("")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPoiJpnCategory(string);
        } else if (string2 != null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPoiJpnCategory(string2);
        } else {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPoiJpnCategory("");
        }
        this.modelNotifier.setSelectedResult(navigationPOICategorySelectedItemCollector);
        this.modelNotifier.setResultList(arrayList);
        this.modelNotifier.quitModelWaitstate();
    }

    private NavigationPOICategorySelectedItemCollector getEmptyPoiCollector() {
        NavigationPOICategorySelectedItemCollector navigationPOICategorySelectedItemCollector = new NavigationPOICategorySelectedItemCollector();
        return navigationPOICategorySelectedItemCollector;
    }

    private NavigationPOICategorySelectedItemCollector getPoiSelectedCollectorFromPoiObject(JavaContent$IND javaContent$IND) {
        NavigationPOICategorySelectedItemCollector navigationPOICategorySelectedItemCollector = new NavigationPOICategorySelectedItemCollector();
        navigationPOICategorySelectedItemCollector.navigation_poi_category_selected_item_icon_available = false;
        navigationPOICategorySelectedItemCollector.navigation_poi_category_selected_item_icon_index = javaContent$IND.iconID;
        navigationPOICategorySelectedItemCollector.navigation_poi_category_selected_item_refineable = javaContent$IND.toRefine;
        navigationPOICategorySelectedItemCollector.navigation_poi_category_selected_item_name = (String)javaContent$IND.names.get(this.currentLanguage);
        if (navigationPOICategorySelectedItemCollector.navigation_poi_category_selected_item_name == null) {
            navigationPOICategorySelectedItemCollector.navigation_poi_category_selected_item_name = "";
        }
        return navigationPOICategorySelectedItemCollector;
    }

    private PoiCatListCollector getPoiCollectorFromPoiObject(JavaContent$IND javaContent$IND) {
        PoiCatListCollector poiCatListCollector = new PoiCatListCollector(null, (String)javaContent$IND.names.get(this.currentLanguage), javaContent$IND.id, javaContent$IND.iconID, true, javaContent$IND.toRefine);
        if (poiCatListCollector.catName == null) {
            poiCatListCollector.catName = "";
        }
        return poiCatListCollector;
    }

    private ArrayList getPoiObjects(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            JavaContent$IND javaContent$IND = (JavaContent$IND)iterator.next();
            arrayList.add(this.getPoiCollectorFromPoiObject(javaContent$IND));
        }
        return arrayList;
    }

    static void printTrace(String string) {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append(string).log();
        }
    }
}

