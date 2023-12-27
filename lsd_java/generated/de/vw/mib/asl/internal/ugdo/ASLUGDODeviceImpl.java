/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.ugdo;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.ugdo.transformer.UGDOKeyListTransformer;
import de.vw.mib.asl.internal.ugdo.transformer.UGDOUGDOFunctionAvailableTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.ugdo.transformer.UGDODeviceInfoUGDOCollector;
import generated.de.vw.mib.asl.internal.ugdo.transformer.UGDOGroupInfoCollector;
import generated.de.vw.mib.asl.internal.ugdo.transformer.UGDOSelectedUGDOKeyNrCollector;
import generated.de.vw.mib.asl.internal.ugdo.transformer.UGDOSelectedUGDOKeyNrTransformer;
import generated.de.vw.mib.asl.internal.ugdo.transformer.UGDOVersionInformationCollector;
import generated.de.vw.mib.asl.internal.ugdo.transformer.UGDOVersionInformationTransformer;

public final class ASLUGDODeviceImpl
extends ASLDeviceAdapter {
    private static final ASLUGDODeviceImpl INSTANCE = new ASLUGDODeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(6);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_GEN;

    private ASLUGDODeviceImpl() {
    }

    public static ASLUGDODeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "UGDO";
    }

    @Override
    public int getTargetId() {
        return 13701;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-245815040, this);
        aSLListRegistry.registerASLDevice(-229037824, this);
        aSLListRegistry.registerASLDevice(-61265664, this);
        aSLListRegistry.registerASLDevice(-44488448, this);
        aSLListRegistry.registerASLDevice(-78042880, this);
        aSLListRegistry.registerASLDevice(5908736, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-533583552, 13701);
        serviceRegister.registerService(-449697472, 13701);
        serviceRegister.registerService(-416143040, 13701);
        serviceRegister.registerService(-399365824, 13701);
        serviceRegister.registerService(-382588608, 13701);
        serviceRegister.registerService(-365811392, 13701);
        serviceRegister.registerService(-500029120, 13701);
        serviceRegister.registerService(-466474688, 13701);
        serviceRegister.registerService(-483251904, 13701);
        serviceRegister.registerService(-349034176, 13701);
        serviceRegister.registerService(-332256960, 13701);
        serviceRegister.registerService(-315479744, 13701);
        serviceRegister.registerService(-298702528, 13701);
        serviceRegister.registerService(-281925312, 13701);
        serviceRegister.registerService(-265148096, 13701);
        serviceRegister.registerService(-248370880, 13701);
        serviceRegister.registerService(-231593664, 13701);
        serviceRegister.registerService(-214816448, 13701);
        serviceRegister.registerService(-198039232, 13701);
        serviceRegister.registerService(-130930368, 13701);
        serviceRegister.registerService(-114153152, 13701);
        serviceRegister.registerService(-181262016, 13701);
        serviceRegister.registerService(-97375936, 13701);
        serviceRegister.registerService(-164484800, 13701);
        serviceRegister.registerService(-147707584, 13701);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2710001: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2710002: {
                nArray = ListColumnsUtil.getIntArrayByBits(62, 5);
                break;
            }
            case 2710012: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 2710013: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2710011: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2710016: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device UGDO: ").append(n).toString());
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
        return ASLUGDODeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLUGDODeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2710001: {
                genericASLList = aSLListFactory.createGenericASLList(new UGDOVersionInformationTransformer(), n, "UGDO", "VersionInformation");
                genericASLList.updateList(new UGDOVersionInformationCollector[]{new UGDOVersionInformationCollector()});
                break;
            }
            case 2710002: {
                genericASLList = aSLListFactory.createGenericASLList(new UGDOKeyListTransformer(), n, "UGDO", "KeyList");
                break;
            }
            case 2710012: {
                genericASLList = aSLListFactory.createGenericASLList(ASLUGDODeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "DeviceInfoUGDO"), n, "UGDO", "DeviceInfoUGDO");
                genericASLList.updateList(new UGDODeviceInfoUGDOCollector[]{new UGDODeviceInfoUGDOCollector()});
                break;
            }
            case 2710013: {
                genericASLList = aSLListFactory.createGenericASLList(ASLUGDODeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "GroupInfo"), n, "UGDO", "GroupInfo");
                genericASLList.updateList(new UGDOGroupInfoCollector[]{new UGDOGroupInfoCollector()});
                break;
            }
            case 2710011: {
                genericASLList = aSLListFactory.createGenericASLList(new UGDOUGDOFunctionAvailableTransformer(), n, "UGDO", "UGDOFunctionAvailable");
                break;
            }
            case 2710016: {
                genericASLList = aSLListFactory.createGenericASLList(new UGDOSelectedUGDOKeyNrTransformer(), n, "UGDO", "SelectedUGDOKeyNr");
                genericASLList.updateList(new UGDOSelectedUGDOKeyNrCollector[]{new UGDOSelectedUGDOKeyNrCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device UGDO: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 2710012: {
                string3 = "generated.de.vw.mib.asl.internal.ugdo.transformer.";
                string2 = "UGDODeviceInfoUGDOTransformer";
                break;
            }
            case 2710013: {
                string3 = "generated.de.vw.mib.asl.internal.ugdo.transformer.";
                string2 = "UGDOGroupInfoTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device UGDO: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "UGDO", string);
    }
}

