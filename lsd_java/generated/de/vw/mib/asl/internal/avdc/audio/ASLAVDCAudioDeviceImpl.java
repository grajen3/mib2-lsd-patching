/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.audio;

import de.vw.mib.asl.internal.avdc.audio.transformer.AVDCAudioAvailableAudioSourcesTransformer;
import de.vw.mib.asl.internal.avdc.audio.transformer.AVDCAudioAvailableBrowsingSourcesTransformer;
import de.vw.mib.asl.internal.avdc.audio.transformer.AVDCAudioAvailableImportSourcesTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.avdc.audio.transformer.AVDCAudioCurrentTrackInfoCollector;
import generated.de.vw.mib.asl.internal.avdc.audio.transformer.AVDCAudioCurrentTrackInfoTransformer;

public final class ASLAVDCAudioDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLAVDCAudioDeviceImpl INSTANCE = new ASLAVDCAudioDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(4);
    private ASLListFactory listFactory;

    private ASLAVDCAudioDeviceImpl() {
    }

    public static ASLAVDCAudioDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "AVDC.Audio";
    }

    @Override
    public int getTargetId() {
        return 10002;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(56, this);
        aSLListRegistry.registerASLDevice(2354, this);
        aSLListRegistry.registerASLDevice(57, this);
        aSLListRegistry.registerASLDevice(58, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(738852928, 10002);
        serviceRegister.registerService(0x2000040, 10002);
        serviceRegister.registerService(755630144, 10002);
        serviceRegister.registerService(1158283328, 10002);
        serviceRegister.registerService(0x5000040, 10002);
        serviceRegister.registerService(0x6000040, 10002);
        serviceRegister.registerService(0x7000040, 10002);
        serviceRegister.registerService(0x8000040, 10002);
        serviceRegister.registerService(0x9000040, 10002);
        serviceRegister.registerService(0xA000040, 10002);
        serviceRegister.registerService(0xB000040, 10002);
        serviceRegister.registerService(0xC000040, 10002);
        serviceRegister.registerService(1342701632, 10002);
        serviceRegister.registerService(1241907264, 10002);
        serviceRegister.registerService(0xD000040, 10002);
        serviceRegister.registerService(2064056384, 10002);
        serviceRegister.registerService(-939065280, 10002);
        serviceRegister.registerService(0xE000040, 10002);
        serviceRegister.registerService(2080833600, 10002);
        serviceRegister.registerService(0xF000040, 10002);
        serviceRegister.registerService(0x10000040, 10002);
        serviceRegister.registerService(571146304, 10002);
        serviceRegister.registerService(0x11000040, 10002);
        serviceRegister.registerService(301989952, 10002);
        serviceRegister.registerService(688521280, 10002);
        serviceRegister.registerService(705298496, 10002);
        serviceRegister.registerService(385876032, 10002);
        serviceRegister.registerService(402653248, 10002);
        serviceRegister.registerService(419430464, 10002);
        serviceRegister.registerService(436207680, 10002);
        serviceRegister.registerService(486539328, 10002);
        serviceRegister.registerService(520093760, 10002);
        serviceRegister.registerService(-938999744, 10002);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 56: {
                nArray = ListColumnsUtil.getSimpleIntArray(10);
                break;
            }
            case 2354: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 57: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 58: {
                nArray = ListColumnsUtil.getSimpleIntArray(10);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Audio: ").append(n).toString());
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
        return ASLAVDCAudioDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLAVDCAudioDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 56: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioAvailableAudioSourcesTransformer(), n, "AVDC.Audio", "availableAudioSources");
                break;
            }
            case 2354: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioAvailableBrowsingSourcesTransformer(), n, "AVDC.Audio", "availableBrowsingSources");
                break;
            }
            case 57: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioAvailableImportSourcesTransformer(), n, "AVDC.Audio", "availableImportSources");
                break;
            }
            case 58: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioCurrentTrackInfoTransformer(), n, "AVDC.Audio", "currentTrackInfo");
                genericASLList.updateList(new AVDCAudioCurrentTrackInfoCollector[]{new AVDCAudioCurrentTrackInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device AVDC.Audio: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

