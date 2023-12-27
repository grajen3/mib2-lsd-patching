/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.audio.browser;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserAlbumInfoList_1Transformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserAlbumSearchResultListTransformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserArtistInfoListTransformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserArtistSearchResultListTransformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserBrowserInfoList_1Transformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserDvdChangerInfoListTransformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserGenreInfoListTransformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserNotPlayableInfoListTransformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserPartitionInfoListTransformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserPathToDisplayedLevelTransformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserRootItemInfoListTransformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserTitleInfoList_1Transformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserTitleSearchResultList_1Transformer;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.AVDCAudioBrowserVideoInfoList_1Transformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLAVDCAudioBrowserDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLAVDCAudioBrowserDeviceImpl INSTANCE = new ASLAVDCAudioBrowserDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(14);
    private ASLListFactory listFactory;

    private ASLAVDCAudioBrowserDeviceImpl() {
    }

    public static ASLAVDCAudioBrowserDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "AVDC.Audio.Browser";
    }

    @Override
    public int getTargetId() {
        return 10005;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3648, this);
        aSLListRegistry.registerASLDevice(425462784, this);
        aSLListRegistry.registerASLDevice(99, this);
        aSLListRegistry.registerASLDevice(442240000, this);
        aSLListRegistry.registerASLDevice(3649, this);
        aSLListRegistry.registerASLDevice(1096551424, this);
        aSLListRegistry.registerASLDevice(102, this);
        aSLListRegistry.registerASLDevice(2588, this);
        aSLListRegistry.registerASLDevice(3626, this);
        aSLListRegistry.registerASLDevice(3555, this);
        aSLListRegistry.registerASLDevice(3650, this);
        aSLListRegistry.registerASLDevice(459017216, this);
        aSLListRegistry.registerASLDevice(3651, this);
        aSLListRegistry.registerASLDevice(84, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(637534272, 10005);
        serviceRegister.registerService(372575296, 10005);
        serviceRegister.registerService(151715904, 10005);
        serviceRegister.registerService(389352512, 10005);
        serviceRegister.registerService(721420352, 10005);
        serviceRegister.registerService(738197568, 10005);
        serviceRegister.registerService(754974784, 10005);
        serviceRegister.registerService(771752000, 10005);
        serviceRegister.registerService(788529216, 10005);
        serviceRegister.registerService(838860864, 10005);
        serviceRegister.registerService(0x33000040, 10005);
        serviceRegister.registerService(0x34000040, 10005);
        serviceRegister.registerService(889192512, 10005);
        serviceRegister.registerService(905969728, 10005);
        serviceRegister.registerService(922746944, 10005);
        serviceRegister.registerService(939524160, 10005);
        serviceRegister.registerService(989855808, 10005);
        serviceRegister.registerService(1006633024, 10005);
        serviceRegister.registerService(1023410240, 10005);
        serviceRegister.registerService(1040187456, 10005);
        serviceRegister.registerService(1056964672, 10005);
        serviceRegister.registerService(0x40000040, 10005);
        serviceRegister.registerService(671744064, 10005);
        serviceRegister.registerService(0x42000040, 10005);
        serviceRegister.registerService(0x4B000040, 10005);
        serviceRegister.registerService(0x4C000040, 10005);
        serviceRegister.registerService(0x4D000040, 10005);
        serviceRegister.registerService(-905510848, 10005);
        serviceRegister.registerService(0x4E000040, 10005);
        serviceRegister.registerService(0x50000040, 10005);
        serviceRegister.registerService(1358954560, 10005);
        serviceRegister.registerService(1375731776, 10005);
        serviceRegister.registerService(1392508992, 10005);
        serviceRegister.registerService(1442840640, 10005);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3648: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 810009: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 99: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 810010: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3649: {
                nArray = ListColumnsUtil.getIntArrayByBits(1911, 9);
                break;
            }
            case 810049: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 102: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2588: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3626: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3555: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3650: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 810011: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3651: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 84: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Audio.Browser: ").append(n).toString());
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
        return ASLAVDCAudioBrowserDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLAVDCAudioBrowserDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3648: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserAlbumInfoList_1Transformer(), n, "AVDC.Audio.Browser", "albumInfoList_1");
                break;
            }
            case 810009: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserAlbumSearchResultListTransformer(), n, "AVDC.Audio.Browser", "albumSearchResultList");
                break;
            }
            case 99: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserArtistInfoListTransformer(), n, "AVDC.Audio.Browser", "artistInfoList");
                break;
            }
            case 810010: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserArtistSearchResultListTransformer(), n, "AVDC.Audio.Browser", "artistSearchResultList");
                break;
            }
            case 3649: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserBrowserInfoList_1Transformer(), n, "AVDC.Audio.Browser", "browserInfoList_1");
                break;
            }
            case 810049: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserDvdChangerInfoListTransformer(), n, "AVDC.Audio.Browser", "dvdChangerInfoList");
                break;
            }
            case 102: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserGenreInfoListTransformer(), n, "AVDC.Audio.Browser", "genreInfoList");
                break;
            }
            case 2588: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserNotPlayableInfoListTransformer(), n, "AVDC.Audio.Browser", "notPlayableInfoList");
                break;
            }
            case 3626: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserPartitionInfoListTransformer(), n, "AVDC.Audio.Browser", "partitionInfoList");
                break;
            }
            case 3555: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserRootItemInfoListTransformer(), n, "AVDC.Audio.Browser", "rootItemInfoList");
                break;
            }
            case 3650: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserTitleInfoList_1Transformer(), n, "AVDC.Audio.Browser", "titleInfoList_1");
                break;
            }
            case 810011: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserTitleSearchResultList_1Transformer(), n, "AVDC.Audio.Browser", "titleSearchResultList_1");
                break;
            }
            case 3651: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserVideoInfoList_1Transformer(), n, "AVDC.Audio.Browser", "videoInfoList_1");
                break;
            }
            case 84: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBrowserPathToDisplayedLevelTransformer(), n, "AVDC.Audio.Browser", "PathToDisplayedLevel");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device AVDC.Audio.Browser: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

