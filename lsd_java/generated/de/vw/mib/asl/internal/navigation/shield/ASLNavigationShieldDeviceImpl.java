/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.shield;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldLastDestList_1Transformer;
import de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldListTransformer;
import de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldResultConnectorDetailsTransformer;
import de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldResultListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldListInfoTransformer;
import generated.de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.shield.transformer.NavigationShieldLocationTransformer;

public final class ASLNavigationShieldDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationShieldDeviceImpl INSTANCE = new ASLNavigationShieldDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(7);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLNavigationShieldDeviceImpl() {
    }

    public static ASLNavigationShieldDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Shield";
    }

    @Override
    public int getTargetId() {
        return 12111;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1710231552, this);
        aSLListRegistry.registerASLDevice(-1729097728, this);
        aSLListRegistry.registerASLDevice(-1947201536, this);
        aSLListRegistry.registerASLDevice(-1963978752, this);
        aSLListRegistry.registerASLDevice(1727008768, this);
        aSLListRegistry.registerASLDevice(1777340416, this);
        aSLListRegistry.registerASLDevice(-1007677440, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(566825024, 12111);
        serviceRegister.registerService(1154027584, 12111);
        serviceRegister.registerService(1321799744, 12111);
        serviceRegister.registerService(1523126336, 12111);
        serviceRegister.registerService(583602240, 12111);
        serviceRegister.registerService(600379456, 12111);
        serviceRegister.registerService(902369344, 12111);
        serviceRegister.registerService(617156672, 12111);
        serviceRegister.registerService(1808339008, 12111);
        serviceRegister.registerService(919146560, 12111);
        serviceRegister.registerService(1187582016, 12111);
        serviceRegister.registerService(1221136448, 12111);
        serviceRegister.registerService(1237913664, 12111);
        serviceRegister.registerService(1254690880, 12111);
        serviceRegister.registerService(1422463040, 12111);
        serviceRegister.registerService(1439240256, 12111);
        serviceRegister.registerService(1539903552, 12111);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1110117: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 1110168: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 1110155: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1110154: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1110118: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1110121: {
                nArray = ListColumnsUtil.getSimpleIntArray(17);
                break;
            }
            case 1110211: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Shield: ").append(n).toString());
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
        return ASLNavigationShieldDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationShieldDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1110117: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationShieldListTransformer(), n, "Navigation.Shield", "List");
                break;
            }
            case 1110168: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationShieldResultListTransformer(), n, "Navigation.Shield", "ResultList");
                break;
            }
            case 1110155: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationShieldLastDestList_1Transformer(), n, "Navigation.Shield", "LastDestList_1");
                break;
            }
            case 1110154: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationShieldDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "LastDestList"), n, "Navigation.Shield", "LastDestList");
                break;
            }
            case 1110118: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationShieldListInfoTransformer(), n, "Navigation.Shield", "ListInfo");
                genericASLList.updateList(new NavigationShieldListInfoCollector[]{new NavigationShieldListInfoCollector()});
                break;
            }
            case 1110121: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationShieldLocationTransformer(), n, "Navigation.Shield", "Location");
                genericASLList.updateList(new NavigationShieldLocationCollector[]{new NavigationShieldLocationCollector()});
                break;
            }
            case 1110211: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationShieldResultConnectorDetailsTransformer(), n, "Navigation.Shield", "ResultConnectorDetails");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Shield: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 1110154: {
                string3 = "de.vw.mib.asl.internal.navigation.shield.transformer.";
                string2 = "NavigationShieldLastDestListTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Navigation.Shield: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Navigation.Shield", string);
    }
}

