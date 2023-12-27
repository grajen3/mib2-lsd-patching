/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.poi.setup;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.NavigationPOISetupCategoryListTransformer;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.NavigationPOISetupCategoryShortCutListTransformer;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.NavigationPOISetupLevel1CategoryListTransformer;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.NavigationPOISetupLevel2CategoryListTransformer;
import de.vw.mib.asl.internal.navigation.poi.setup.transformer.NavigationPOISetupLevel3CategoryListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationPOISetupDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationPOISetupDeviceImpl INSTANCE = new ASLNavigationPOISetupDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLNavigationPOISetupDeviceImpl() {
    }

    public static ASLNavigationPOISetupDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.POI.Setup";
    }

    @Override
    public int getTargetId() {
        return 10054;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(953, this);
        aSLListRegistry.registerASLDevice(-621801472, this);
        aSLListRegistry.registerASLDevice(-605024256, this);
        aSLListRegistry.registerASLDevice(-588247040, this);
        aSLListRegistry.registerASLDevice(954, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1090387904, 10054);
        serviceRegister.registerService(-1073610688, 10054);
        serviceRegister.registerService(-1056833472, 10054);
        serviceRegister.registerService(-1040056256, 10054);
        serviceRegister.registerService(1909002304, 10054);
        serviceRegister.registerService(1925779520, 10054);
        serviceRegister.registerService(1942556736, 10054);
        serviceRegister.registerService(537526336, 10054);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 953: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 1110234: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 1110235: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 1110236: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 954: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.POI.Setup: ").append(n).toString());
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
        return ASLNavigationPOISetupDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationPOISetupDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 953: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOISetupCategoryListTransformer(), n, "Navigation.POI.Setup", "CategoryList");
                break;
            }
            case 1110234: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOISetupLevel1CategoryListTransformer(), n, "Navigation.POI.Setup", "Level1CategoryList");
                break;
            }
            case 1110235: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOISetupLevel2CategoryListTransformer(), n, "Navigation.POI.Setup", "Level2CategoryList");
                break;
            }
            case 1110236: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOISetupLevel3CategoryListTransformer(), n, "Navigation.POI.Setup", "Level3CategoryList");
                break;
            }
            case 954: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOISetupCategoryShortCutListTransformer(), n, "Navigation.POI.Setup", "CategoryShortCutList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.POI.Setup: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

