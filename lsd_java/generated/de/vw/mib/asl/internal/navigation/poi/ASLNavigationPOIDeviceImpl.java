/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.poi;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIAllCategoryListTransformer;
import de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIOneShotCategoryListTransformer;
import de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIPitStopItemTransformer;
import de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIResultConnectorDetailsTransformer;
import de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIResultListTransformer;
import de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIResultSubListTransformer;
import de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOISearchCategoryGroupListTransformer;
import de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOISearchCategoryListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIResultSelectedDetailsCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIResultSelectedDetailsTransformer;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOISearchAreaMainCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOISearchAreaMainTransformer;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOISearchLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOISearchLocationTransformer;

public final class ASLNavigationPOIDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationPOIDeviceImpl INSTANCE = new ASLNavigationPOIDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(11);
    private ASLListFactory listFactory;

    private ASLNavigationPOIDeviceImpl() {
    }

    public static ASLNavigationPOIDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.POI";
    }

    @Override
    public int getTargetId() {
        return 10053;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(946, this);
        aSLListRegistry.registerASLDevice(947, this);
        aSLListRegistry.registerASLDevice(948, this);
        aSLListRegistry.registerASLDevice(949, this);
        aSLListRegistry.registerASLDevice(950, this);
        aSLListRegistry.registerASLDevice(951, this);
        aSLListRegistry.registerASLDevice(3099, this);
        aSLListRegistry.registerASLDevice(334499840, this);
        aSLListRegistry.registerASLDevice(930, this);
        aSLListRegistry.registerASLDevice(2311, this);
        aSLListRegistry.registerASLDevice(937, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1106771904, 10053);
        serviceRegister.registerService(-1627258816, 10053);
        serviceRegister.registerService(-1610481600, 10053);
        serviceRegister.registerService(-1593704384, 10053);
        serviceRegister.registerService(-1576927168, 10053);
        serviceRegister.registerService(1678311488, 10053);
        serviceRegister.registerService(-1560149952, 10053);
        serviceRegister.registerService(-1543372736, 10053);
        serviceRegister.registerService(-1526595520, 10053);
        serviceRegister.registerService(-1509818304, 10053);
        serviceRegister.registerService(-1493041088, 10053);
        serviceRegister.registerService(-1476263872, 10053);
        serviceRegister.registerService(-1459486656, 10053);
        serviceRegister.registerService(-1442709440, 10053);
        serviceRegister.registerService(-1425932224, 10053);
        serviceRegister.registerService(-1409155008, 10053);
        serviceRegister.registerService(-1392377792, 10053);
        serviceRegister.registerService(-1375600576, 10053);
        serviceRegister.registerService(-1358823360, 10053);
        serviceRegister.registerService(-1342046144, 10053);
        serviceRegister.registerService(-1325268928, 10053);
        serviceRegister.registerService(-1308491712, 10053);
        serviceRegister.registerService(-1291714496, 10053);
        serviceRegister.registerService(-1274937280, 10053);
        serviceRegister.registerService(29954112, 10053);
        serviceRegister.registerService(-1241382848, 10053);
        serviceRegister.registerService(-1224605632, 10053);
        serviceRegister.registerService(-1207828416, 10053);
        serviceRegister.registerService(-1191051200, 10053);
        serviceRegister.registerService(-1174273984, 10053);
        serviceRegister.registerService(-1157496768, 10053);
        serviceRegister.registerService(-1140719552, 10053);
        serviceRegister.registerService(-1123942336, 10053);
        serviceRegister.registerService(-1107165120, 10053);
        serviceRegister.registerService(-519569344, 10053);
        serviceRegister.registerService(-502792128, 10053);
        serviceRegister.registerService(-486014912, 10053);
        serviceRegister.registerService(589888, 10053);
        serviceRegister.registerService(-452460480, 10053);
        serviceRegister.registerService(-385351616, 10053);
        serviceRegister.registerService(-418906048, 10053);
        serviceRegister.registerService(-402128832, 10053);
        serviceRegister.registerService(319422528, 10053);
        serviceRegister.registerService(1762263104, 10053);
        serviceRegister.registerService(-137883584, 10053);
        serviceRegister.registerService(-121106368, 10053);
        serviceRegister.registerService(-104329152, 10053);
        serviceRegister.registerService(-87551936, 10053);
        serviceRegister.registerService(264835136, 10053);
        serviceRegister.registerService(281612352, 10053);
        serviceRegister.registerService(298389568, 10053);
        serviceRegister.registerService(365498432, 10053);
        serviceRegister.registerService(633933888, 10053);
        serviceRegister.registerService(1137250368, 10053);
        serviceRegister.registerService(650711104, 10053);
        serviceRegister.registerService(667488320, 10053);
        serviceRegister.registerService(717819968, 10053);
        serviceRegister.registerService(734597184, 10053);
        serviceRegister.registerService(885592128, 10053);
        serviceRegister.registerService(1355354176, 10053);
        serviceRegister.registerService(1372131392, 10053);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 946: {
                nArray = ListColumnsUtil.getSimpleIntArray(20);
                break;
            }
            case 947: {
                nArray = ListColumnsUtil.getSimpleIntArray(39);
                break;
            }
            case 948: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 949: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 950: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 951: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 3099: {
                nArray = ListColumnsUtil.getSimpleIntArray(32);
                break;
            }
            case 1110035: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 930: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2311: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 937: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.POI: ").append(n).toString());
            }
        }
        return nArray;
    }

    @Override
    public ASLList getASLList(int n) {
        return this.getGenericASLList(n);
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        return ASLNavigationPOIDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationPOIDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 946: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOIResultListTransformer(), n, "Navigation.POI", "ResultList");
                break;
            }
            case 947: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOIResultSelectedDetailsTransformer(), n, "Navigation.POI", "ResultSelectedDetails");
                genericASLList.updateList(new NavigationPOIResultSelectedDetailsCollector[]{new NavigationPOIResultSelectedDetailsCollector()});
                break;
            }
            case 948: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOIResultSubListTransformer(), n, "Navigation.POI", "ResultSubList");
                break;
            }
            case 949: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOISearchCategoryListTransformer(), n, "Navigation.POI", "SearchCategoryList");
                break;
            }
            case 950: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOIPitStopItemTransformer(), n, "Navigation.POI", "pitStopItem");
                break;
            }
            case 951: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOISearchAreaMainTransformer(), n, "Navigation.POI", "SearchAreaMain");
                genericASLList.updateList(new NavigationPOISearchAreaMainCollector[]{new NavigationPOISearchAreaMainCollector()});
                break;
            }
            case 3099: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOISearchLocationTransformer(), n, "Navigation.POI", "SearchLocation");
                genericASLList.updateList(new NavigationPOISearchLocationCollector[]{new NavigationPOISearchLocationCollector()});
                break;
            }
            case 1110035: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOIResultConnectorDetailsTransformer(), n, "Navigation.POI", "ResultConnectorDetails");
                break;
            }
            case 930: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOIAllCategoryListTransformer(), n, "Navigation.POI", "AllCategoryList");
                break;
            }
            case 2311: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOIOneShotCategoryListTransformer(), n, "Navigation.POI", "OneShotCategoryList");
                break;
            }
            case 937: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOISearchCategoryGroupListTransformer(), n, "Navigation.POI", "SearchCategoryGroupList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.POI: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

