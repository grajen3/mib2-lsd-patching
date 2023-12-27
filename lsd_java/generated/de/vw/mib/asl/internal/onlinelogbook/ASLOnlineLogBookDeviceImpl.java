/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.onlinelogbook;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.onlinelogbook.transformer.OnlineLogBookTripTransformer;
import de.vw.mib.asl.internal.onlinelogbook.transformer.OnlineLogBookUsersTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.onlinelogbook.transformer.OnlineLogBookActiveTripCollector;
import generated.de.vw.mib.asl.internal.onlinelogbook.transformer.OnlineLogBookActiveTripTransformer;

public final class ASLOnlineLogBookDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLOnlineLogBookDeviceImpl INSTANCE = new ASLOnlineLogBookDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLOnlineLogBookDeviceImpl() {
    }

    public static ASLOnlineLogBookDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "OnlineLogBook";
    }

    @Override
    public int getTargetId() {
        return 18401;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1393651968, this);
        aSLListRegistry.registerASLDevice(1410429184, this);
        aSLListRegistry.registerASLDevice(1360097536, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1307209792, 18401);
        serviceRegister.registerService(1323987008, 18401);
        serviceRegister.registerService(1089105984, 18401);
        serviceRegister.registerService(1105883200, 18401);
        serviceRegister.registerService(1122660416, 18401);
        serviceRegister.registerService(1139437632, 18401);
        serviceRegister.registerService(1156214848, 18401);
        serviceRegister.registerService(1172992064, 18401);
        serviceRegister.registerService(1189769280, 18401);
        serviceRegister.registerService(1206546496, 18401);
        serviceRegister.registerService(1223323712, 18401);
        serviceRegister.registerService(1240100928, 18401);
        serviceRegister.registerService(1256878144, 18401);
        serviceRegister.registerService(1273655360, 18401);
        serviceRegister.registerService(1290432576, 18401);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 7410003: {
                nArray = ListColumnsUtil.getSimpleIntArray(12);
                break;
            }
            case 7410004: {
                nArray = ListColumnsUtil.getSimpleIntArray(11);
                break;
            }
            case 0x711151: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device OnlineLogBook: ").append(n).toString());
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
        return ASLOnlineLogBookDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLOnlineLogBookDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 7410003: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineLogBookTripTransformer(), n, "OnlineLogBook", "Trip");
                break;
            }
            case 7410004: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineLogBookActiveTripTransformer(), n, "OnlineLogBook", "ActiveTrip");
                genericASLList.updateList(new OnlineLogBookActiveTripCollector[]{new OnlineLogBookActiveTripCollector()});
                break;
            }
            case 0x711151: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineLogBookUsersTransformer(), n, "OnlineLogBook", "Users");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device OnlineLogBook: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

