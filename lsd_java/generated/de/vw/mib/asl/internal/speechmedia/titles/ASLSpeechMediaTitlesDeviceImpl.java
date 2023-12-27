/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechmedia.titles;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechmedia.titles.transformer.SpeechMediaTitlesTitleListTransformer;
import de.vw.mib.asl.internal.speechmedia.titles.transformer.SpeechMediaTitlesTitleSelectedListTransformer;
import de.vw.mib.asl.internal.speechmedia.titles.transformer.SpeechMediaTitlesTitleSubListTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechMediaTitlesDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechMediaTitlesDeviceImpl INSTANCE = new ASLSpeechMediaTitlesDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLSpeechMediaTitlesDeviceImpl() {
    }

    public static ASLSpeechMediaTitlesDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechMedia.Titles";
    }

    @Override
    public int getTargetId() {
        return 14307;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-998166016, this);
        aSLListRegistry.registerASLDevice(-914279936, this);
        aSLListRegistry.registerASLDevice(-897502720, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1202048448, 14307);
        serviceRegister.registerService(-933612992, 14307);
        serviceRegister.registerService(-1168494016, 14307);
        serviceRegister.registerService(-1151716800, 14307);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3310020: {
                nArray = ListColumnsUtil.getIntArrayByBits(8175, 12);
                break;
            }
            case 3310025: {
                nArray = ListColumnsUtil.getSimpleIntArray(11);
                break;
            }
            case 3310026: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.Titles: ").append(n).toString());
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
        return ASLSpeechMediaTitlesDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechMediaTitlesDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3310020: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechMediaTitlesTitleListTransformer(), n, "SpeechMedia.Titles", "TitleList");
                break;
            }
            case 3310025: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechMediaTitlesTitleSubListTransformer(), n, "SpeechMedia.Titles", "TitleSubList");
                break;
            }
            case 3310026: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechMediaTitlesTitleSelectedListTransformer(), n, "SpeechMedia.Titles", "TitleSelectedList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechMedia.Titles: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

