/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.pnav;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavButtonContentTransformer;
import de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavLikelyDestinationListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavBackgroundImageContentCollector;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavBackgroundImageContentTransformer;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavFooterContentCollector;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavFooterContentTransformer;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavLikelyDestinationsCollector;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavSelectedDestinationCollector;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavSelectedDestinationTransformer;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavTextAreaContentCollector;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavTextAreaContentTransformer;

public final class ASLNavigationPnavDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationPnavDeviceImpl INSTANCE = new ASLNavigationPnavDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(7);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_GEN;

    private ASLNavigationPnavDeviceImpl() {
    }

    public static ASLNavigationPnavDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Pnav";
    }

    @Override
    public int getTargetId() {
        return 10116;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2012221440, this);
        aSLListRegistry.registerASLDevice(2028998656, this);
        aSLListRegistry.registerASLDevice(2062553088, this);
        aSLListRegistry.registerASLDevice(2498, this);
        aSLListRegistry.registerASLDevice(2499, this);
        aSLListRegistry.registerASLDevice(2500, this);
        aSLListRegistry.registerASLDevice(2501, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-2063138752, 10116);
        serviceRegister.registerService(-2046361536, 10116);
        serviceRegister.registerService(-2029584320, 10116);
        serviceRegister.registerService(-2012807104, 10116);
        serviceRegister.registerService(818483264, 10116);
        serviceRegister.registerService(835260480, 10116);
        serviceRegister.registerService(852037696, 10116);
        serviceRegister.registerService(868814912, 10116);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1110135: {
                nArray = ListColumnsUtil.getSimpleIntArray(16);
                break;
            }
            case 1110136: {
                nArray = ListColumnsUtil.getSimpleIntArray(17);
                break;
            }
            case 1110138: {
                nArray = ListColumnsUtil.getSimpleIntArray(17);
                break;
            }
            case 2498: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2499: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 2500: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 2501: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Pnav: ").append(n).toString());
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
        return ASLNavigationPnavDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationPnavDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1110135: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationPnavDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "LikelyDestinations"), n, "Navigation.Pnav", "LikelyDestinations");
                genericASLList.updateList(new NavigationPnavLikelyDestinationsCollector[]{new NavigationPnavLikelyDestinationsCollector()});
                break;
            }
            case 1110136: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPnavLikelyDestinationListTransformer(), n, "Navigation.Pnav", "LikelyDestinationList");
                break;
            }
            case 1110138: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPnavSelectedDestinationTransformer(), n, "Navigation.Pnav", "SelectedDestination");
                genericASLList.updateList(new NavigationPnavSelectedDestinationCollector[]{new NavigationPnavSelectedDestinationCollector()});
                break;
            }
            case 2498: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPnavButtonContentTransformer(), n, "Navigation.Pnav", "ButtonContent");
                break;
            }
            case 2499: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPnavTextAreaContentTransformer(), n, "Navigation.Pnav", "TextAreaContent");
                genericASLList.updateList(new NavigationPnavTextAreaContentCollector[]{new NavigationPnavTextAreaContentCollector()});
                break;
            }
            case 2500: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPnavBackgroundImageContentTransformer(), n, "Navigation.Pnav", "BackgroundImageContent");
                genericASLList.updateList(new NavigationPnavBackgroundImageContentCollector[]{new NavigationPnavBackgroundImageContentCollector()});
                break;
            }
            case 2501: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPnavFooterContentTransformer(), n, "Navigation.Pnav", "FooterContent");
                genericASLList.updateList(new NavigationPnavFooterContentCollector[]{new NavigationPnavFooterContentCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Pnav: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 1110135: {
                string3 = "generated.de.vw.mib.asl.internal.navigation.pnav.transformer.";
                string2 = "NavigationPnavLikelyDestinationsTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Navigation.Pnav: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Navigation.Pnav", string);
    }
}

