/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navinfotile.pnav;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navinfotile.pnav.transformer.NavInfoTilePnavButtonContentTransformer;
import de.vw.mib.asl.internal.navinfotile.pnav.transformer.NavInfoTilePnavLikelyDestinationListTransformer;
import de.vw.mib.asl.internal.navinfotile.pnav.transformer.NavInfoTilePnavLikelyDestinationStaticListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navinfotile.pnav.transformer.NavInfoTilePnavSelectedDestinationCollector;
import generated.de.vw.mib.asl.internal.navinfotile.pnav.transformer.NavInfoTilePnavSelectedDestinationTransformer;

public final class ASLNavInfoTilePnavDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavInfoTilePnavDeviceImpl INSTANCE = new ASLNavInfoTilePnavDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(4);
    private ASLListFactory listFactory;

    private ASLNavInfoTilePnavDeviceImpl() {
    }

    public static ASLNavInfoTilePnavDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "NavInfoTile.Pnav";
    }

    @Override
    public int getTargetId() {
        return 16906;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(472799744, this);
        aSLListRegistry.registerASLDevice(489576960, this);
        aSLListRegistry.registerASLDevice(506354176, this);
        aSLListRegistry.registerASLDevice(724457984, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-486122944, 16906);
        serviceRegister.registerService(-469345728, 16906);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5910044: {
                nArray = ListColumnsUtil.getSimpleIntArray(17);
                break;
            }
            case 5910045: {
                nArray = ListColumnsUtil.getSimpleIntArray(17);
                break;
            }
            case 5910046: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 5910059: {
                nArray = ListColumnsUtil.getSimpleIntArray(18);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavInfoTile.Pnav: ").append(n).toString());
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
        return ASLNavInfoTilePnavDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavInfoTilePnavDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5910044: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTilePnavLikelyDestinationListTransformer(), n, "NavInfoTile.Pnav", "LikelyDestinationList");
                break;
            }
            case 5910045: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTilePnavSelectedDestinationTransformer(), n, "NavInfoTile.Pnav", "SelectedDestination");
                genericASLList.updateList(new NavInfoTilePnavSelectedDestinationCollector[]{new NavInfoTilePnavSelectedDestinationCollector()});
                break;
            }
            case 5910046: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTilePnavButtonContentTransformer(), n, "NavInfoTile.Pnav", "ButtonContent");
                break;
            }
            case 5910059: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTilePnavLikelyDestinationStaticListTransformer(), n, "NavInfoTile.Pnav", "LikelyDestinationStaticList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device NavInfoTile.Pnav: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

