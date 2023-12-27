/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.call.dial;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialShortDialEmergencyNumbersTransformer;
import de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialShortDialMatchingNumbersTransformer;
import de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialShortDialMatchingTransformer;
import de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialShortDialTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialLastDialedNumberInformationsCollector;
import generated.de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialLastDialedNumberInformationsTransformer;

public final class ASLPhoneCallDialDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneCallDialDeviceImpl INSTANCE = new ASLPhoneCallDialDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLPhoneCallDialDeviceImpl() {
    }

    public static ASLPhoneCallDialDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Call.Dial";
    }

    @Override
    public int getTargetId() {
        return 10077;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2565, this);
        aSLListRegistry.registerASLDevice(1167, this);
        aSLListRegistry.registerASLDevice(277091584, this);
        aSLListRegistry.registerASLDevice(1169, this);
        aSLListRegistry.registerASLDevice(1168, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1358757824, 10077);
        serviceRegister.registerService(-1341980608, 10077);
        serviceRegister.registerService(-1325203392, 10077);
        serviceRegister.registerService(-1308426176, 10077);
        serviceRegister.registerService(-1291648960, 10077);
        serviceRegister.registerService(-1542848448, 10077);
        serviceRegister.registerService(-1258094528, 10077);
        serviceRegister.registerService(-1241317312, 10077);
        serviceRegister.registerService(-748939968, 10077);
        serviceRegister.registerService(-1207762880, 10077);
        serviceRegister.registerService(-1190985664, 10077);
        serviceRegister.registerService(-1174208448, 10077);
        serviceRegister.registerService(-883157696, 10077);
        serviceRegister.registerService(-1157431232, 10077);
        serviceRegister.registerService(-1140654016, 10077);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2565: {
                nArray = ListColumnsUtil.getIntArrayByBits(463, 7);
                break;
            }
            case 1167: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1410064: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1169: {
                nArray = ListColumnsUtil.getIntArrayByBits(125, 6);
                break;
            }
            case 1168: {
                nArray = ListColumnsUtil.getIntArrayByBits(14, 3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Call.Dial: ").append(n).toString());
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
        return ASLPhoneCallDialDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneCallDialDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2565: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneCallDialLastDialedNumberInformationsTransformer(), n, "Phone.Call.Dial", "lastDialedNumberInformations");
                genericASLList.updateList(new PhoneCallDialLastDialedNumberInformationsCollector[]{new PhoneCallDialLastDialedNumberInformationsCollector()});
                break;
            }
            case 1167: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneCallDialShortDialTransformer(), n, "Phone.Call.Dial", "shortDial");
                break;
            }
            case 1410064: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneCallDialShortDialEmergencyNumbersTransformer(), n, "Phone.Call.Dial", "shortDialEmergencyNumbers");
                break;
            }
            case 1169: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneCallDialShortDialMatchingTransformer(), n, "Phone.Call.Dial", "shortDialMatching");
                break;
            }
            case 1168: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneCallDialShortDialMatchingNumbersTransformer(), n, "Phone.Call.Dial", "shortDialMatchingNumbers");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Phone.Call.Dial: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

