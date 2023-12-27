/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.memory.sd;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDAvailableGPSPicSourcesTransformer;
import de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDGpsPicThumbnailTransformer;
import de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDGpsPicsBrowserListTransformer;
import de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDImportSDEntryListTransformer;
import de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDVCardListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDGpsPicListSelectedDetailsCollector;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDGpsPicListSelectedDetailsTransformer;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDImportingSDEntryListDataCollector;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDImportingSDEntryListDataTransformer;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDVCardImportBrowserResultsCollector;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDVCardImportBrowserResultsTransformer;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDVCardListSelectedDetailsCollector;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDVCardListSelectedDetailsTransformer;

public final class ASLNavigationMemorySDDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationMemorySDDeviceImpl INSTANCE = new ASLNavigationMemorySDDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(9);
    private ASLListFactory listFactory;

    private ASLNavigationMemorySDDeviceImpl() {
    }

    public static ASLNavigationMemorySDDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Memory.SD";
    }

    @Override
    public int getTargetId() {
        return 10052;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(923, this);
        aSLListRegistry.registerASLDevice(924, this);
        aSLListRegistry.registerASLDevice(925, this);
        aSLListRegistry.registerASLDevice(926, this);
        aSLListRegistry.registerASLDevice(927, this);
        aSLListRegistry.registerASLDevice(928, this);
        aSLListRegistry.registerASLDevice(929, this);
        aSLListRegistry.registerASLDevice(921, this);
        aSLListRegistry.registerASLDevice(922, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-2013134784, 10052);
        serviceRegister.registerService(-1996357568, 10052);
        serviceRegister.registerService(-1979580352, 10052);
        serviceRegister.registerService(-1962803136, 10052);
        serviceRegister.registerService(-1946025920, 10052);
        serviceRegister.registerService(-1929248704, 10052);
        serviceRegister.registerService(-1912471488, 10052);
        serviceRegister.registerService(-1895694272, 10052);
        serviceRegister.registerService(-1878917056, 10052);
        serviceRegister.registerService(-1862139840, 10052);
        serviceRegister.registerService(-1845362624, 10052);
        serviceRegister.registerService(-1828585408, 10052);
        serviceRegister.registerService(-1811808192, 10052);
        serviceRegister.registerService(-1795030976, 10052);
        serviceRegister.registerService(-1778253760, 10052);
        serviceRegister.registerService(-1761476544, 10052);
        serviceRegister.registerService(-1744699328, 10052);
        serviceRegister.registerService(-1727922112, 10052);
        serviceRegister.registerService(-1711144896, 10052);
        serviceRegister.registerService(-1039663040, 10052);
        serviceRegister.registerService(-1694367680, 10052);
        serviceRegister.registerService(-1677590464, 10052);
        serviceRegister.registerService(-1660813248, 10052);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 923: {
                nArray = ListColumnsUtil.getSimpleIntArray(28);
                break;
            }
            case 924: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 925: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 926: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 927: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 928: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 929: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 921: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 922: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Memory.SD: ").append(n).toString());
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
        return ASLNavigationMemorySDDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationMemorySDDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 923: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemorySDGpsPicListSelectedDetailsTransformer(), n, "Navigation.Memory.SD", "GpsPicListSelectedDetails");
                genericASLList.updateList(new NavigationMemorySDGpsPicListSelectedDetailsCollector[]{new NavigationMemorySDGpsPicListSelectedDetailsCollector()});
                break;
            }
            case 924: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemorySDImportingSDEntryListDataTransformer(), n, "Navigation.Memory.SD", "ImportingSDEntryListData");
                genericASLList.updateList(new NavigationMemorySDImportingSDEntryListDataCollector[]{new NavigationMemorySDImportingSDEntryListDataCollector()});
                break;
            }
            case 925: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemorySDImportSDEntryListTransformer(), n, "Navigation.Memory.SD", "ImportSDEntryList");
                break;
            }
            case 926: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemorySDGpsPicThumbnailTransformer(), n, "Navigation.Memory.SD", "GpsPicThumbnail");
                break;
            }
            case 927: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemorySDVCardListSelectedDetailsTransformer(), n, "Navigation.Memory.SD", "VCardListSelectedDetails");
                genericASLList.updateList(new NavigationMemorySDVCardListSelectedDetailsCollector[]{new NavigationMemorySDVCardListSelectedDetailsCollector()});
                break;
            }
            case 928: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemorySDGpsPicsBrowserListTransformer(), n, "Navigation.Memory.SD", "GpsPicsBrowserList");
                break;
            }
            case 929: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemorySDVCardImportBrowserResultsTransformer(), n, "Navigation.Memory.SD", "VCardImportBrowserResults");
                genericASLList.updateList(new NavigationMemorySDVCardImportBrowserResultsCollector[]{new NavigationMemorySDVCardImportBrowserResultsCollector()});
                break;
            }
            case 921: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemorySDAvailableGPSPicSourcesTransformer(), n, "Navigation.Memory.SD", "AvailableGPSPicSources");
                break;
            }
            case 922: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemorySDVCardListTransformer(), n, "Navigation.Memory.SD", "VCardList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Memory.SD: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

