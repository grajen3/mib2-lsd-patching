/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.video;

import de.vw.mib.asl.internal.avdc.video.transformer.AVDCVideoAvailableDVDMenuLanguagesTransformer;
import de.vw.mib.asl.internal.avdc.video.transformer.AVDCVideoAvailableDVDSubtitlesTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLAVDCVideoDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLAVDCVideoDeviceImpl INSTANCE = new ASLAVDCVideoDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLAVDCVideoDeviceImpl() {
    }

    public static ASLAVDCVideoDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "AVDC.Video";
    }

    @Override
    public int getTargetId() {
        return 10008;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(114, this);
        aSLListRegistry.registerASLDevice(115, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(0x60000040, 10008);
        serviceRegister.registerService(1627390016, 10008);
        serviceRegister.registerService(1644167232, 10008);
        serviceRegister.registerService(1660944448, 10008);
        serviceRegister.registerService(1694498880, 10008);
        serviceRegister.registerService(1728053312, 10008);
        serviceRegister.registerService(1761607744, 10008);
        serviceRegister.registerService(1778384960, 10008);
        serviceRegister.registerService(1795162176, 10008);
        serviceRegister.registerService(1811939392, 10008);
        serviceRegister.registerService(1828716608, 10008);
        serviceRegister.registerService(1845493824, 10008);
        serviceRegister.registerService(1862271040, 10008);
        serviceRegister.registerService(0x70000040, 10008);
        serviceRegister.registerService(1895825472, 10008);
        serviceRegister.registerService(1912602688, 10008);
        serviceRegister.registerService(1979711552, 10008);
        serviceRegister.registerService(0x77000040, 10008);
        serviceRegister.registerService(2013265984, 10008);
        serviceRegister.registerService(2030043200, 10008);
        serviceRegister.registerService(2046820416, 10008);
        serviceRegister.registerService(2063597632, 10008);
        serviceRegister.registerService(2080374848, 10008);
        serviceRegister.registerService(2113929280, 10008);
        serviceRegister.registerService(-2147483584, 10008);
        serviceRegister.registerService(-2130706368, 10008);
        serviceRegister.registerService(0x40090040, 10008);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 114: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 115: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Video: ").append(n).toString());
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
        return ASLAVDCVideoDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLAVDCVideoDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 114: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCVideoAvailableDVDMenuLanguagesTransformer(), n, "AVDC.Video", "AvailableDVDMenuLanguages");
                break;
            }
            case 115: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCVideoAvailableDVDSubtitlesTransformer(), n, "AVDC.Video", "AvailableDVDSubtitles");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device AVDC.Video: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

