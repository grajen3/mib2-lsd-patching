/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingProfileSelectionTransformer;
import de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingSearchResultTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingErrorCollector;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingErrorTransformer;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothSelectedbondingDeviceCollector;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothSelectedbondingDeviceTransformer;

public final class ASLPhoneBluetoothDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneBluetoothDeviceImpl INSTANCE = new ASLPhoneBluetoothDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(4);
    private ASLListFactory listFactory;

    private ASLPhoneBluetoothDeviceImpl() {
    }

    public static ASLPhoneBluetoothDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Bluetooth";
    }

    @Override
    public int getTargetId() {
        return 10071;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2855, this);
        aSLListRegistry.registerASLDevice(1141, this);
        aSLListRegistry.registerASLDevice(1142, this);
        aSLListRegistry.registerASLDevice(1143, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1845690432, 10071);
        serviceRegister.registerService(1862467648, 10071);
        serviceRegister.registerService(0x44060040, 10071);
        serviceRegister.registerService(1879244864, 10071);
        serviceRegister.registerService(302710848, 10071);
        serviceRegister.registerService(1896022080, 10071);
        serviceRegister.registerService(1912799296, 10071);
        serviceRegister.registerService(319488064, 10071);
        serviceRegister.registerService(1963130944, 10071);
        serviceRegister.registerService(-396618432, 10071);
        serviceRegister.registerService(1996685376, 10071);
        serviceRegister.registerService(-379841216, 10071);
        serviceRegister.registerService(-983820992, 10071);
        serviceRegister.registerService(2013462592, 10071);
        serviceRegister.registerService(2047017024, 10071);
        serviceRegister.registerService(2063794240, 10071);
        serviceRegister.registerService(2080571456, 10071);
        serviceRegister.registerService(2097348672, 10071);
        serviceRegister.registerService(2114125888, 10071);
        serviceRegister.registerService(2130903104, 10071);
        serviceRegister.registerService(-2147286976, 10071);
        serviceRegister.registerService(-2130509760, 10071);
        serviceRegister.registerService(-1358495680, 10071);
        serviceRegister.registerService(-2113732544, 10071);
        serviceRegister.registerService(-547613376, 10071);
        serviceRegister.registerService(-530836160, 10071);
        serviceRegister.registerService(-2096955328, 10071);
        serviceRegister.registerService(-284557248, 10071);
        serviceRegister.registerService(-2080178112, 10071);
        serviceRegister.registerService(285868096, 10071);
        serviceRegister.registerService(-2046623680, 10071);
        serviceRegister.registerService(-2029846464, 10071);
        serviceRegister.registerService(-2013069248, 10071);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2855: {
                nArray = ListColumnsUtil.getIntArrayByBits(67, 3);
                break;
            }
            case 1141: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 1142: {
                nArray = ListColumnsUtil.getSimpleIntArray(12);
                break;
            }
            case 1143: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Bluetooth: ").append(n).toString());
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
        return ASLPhoneBluetoothDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneBluetoothDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2855: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneBluetoothBondingErrorTransformer(), n, "Phone.Bluetooth", "bondingError");
                genericASLList.updateList(new PhoneBluetoothBondingErrorCollector[]{new PhoneBluetoothBondingErrorCollector()});
                break;
            }
            case 1141: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneBluetoothBondingProfileSelectionTransformer(), n, "Phone.Bluetooth", "bondingProfileSelection");
                break;
            }
            case 1142: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneBluetoothBondingSearchResultTransformer(), n, "Phone.Bluetooth", "bondingSearchResult");
                break;
            }
            case 1143: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneBluetoothSelectedbondingDeviceTransformer(), n, "Phone.Bluetooth", "selectedbondingDevice");
                genericASLList.updateList(new PhoneBluetoothSelectedbondingDeviceCollector[]{new PhoneBluetoothSelectedbondingDeviceCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Phone.Bluetooth: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

