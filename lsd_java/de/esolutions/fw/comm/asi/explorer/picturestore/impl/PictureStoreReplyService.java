/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.PictureStoreReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.GeoPictureSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.PictureAttributeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public class PictureStoreReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.explorer.picturestore.PictureStore");
    private static int dynamicHandle = 0;
    private PictureStoreReply p_PictureStoreReply;

    public PictureStoreReplyService(PictureStoreReply pictureStoreReply) {
        super(new ServiceInstanceID("a4508c38-8b16-4130-967f-f23cb2238fda", PictureStoreReplyService.nextDynamicHandle(), "ca2869dd-3831-51b0-8093-231b81bca2c1", "asi.explorer.picturestore.PictureStore"));
        this.p_PictureStoreReply = pictureStoreReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 41: {
                    int n = iDeserializer.getEnum();
                    this.p_PictureStoreReply.beginImportResult(n);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getEnum();
                    this.p_PictureStoreReply.endImportResult(n);
                    break;
                }
                case 49: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    ResourceLocator resourceLocator2 = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n2 = iDeserializer.getEnum();
                    this.p_PictureStoreReply.importPictureFromSourceResult(n, resourceLocator, resourceLocator2, n2);
                    break;
                }
                case 66: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    ResourceLocator resourceLocator3 = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n3 = iDeserializer.getEnum();
                    long l = iDeserializer.getInt64();
                    this.p_PictureStoreReply.importPictureWithSynchronizationIDResult(n, resourceLocator, resourceLocator3, n3, l);
                    break;
                }
                case 64: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    this.p_PictureStoreReply.getMaxSynchronizationIDResult(n, l);
                    break;
                }
                case 72: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    this.p_PictureStoreReply.setSynchronizationIDResult(n, l);
                    break;
                }
                case 70: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    long l = iDeserializer.getInt64();
                    int n4 = iDeserializer.getEnum();
                    this.p_PictureStoreReply.renameFolderResult(n, string, string2, l, n4);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_PictureStoreReply.countPicturesInContextResult(n, n5, n6);
                    break;
                }
                case 50: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    ResourceLocator resourceLocator4 = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_PictureStoreReply.increaseRefCounterResult(resourceLocator, resourceLocator4, n);
                    break;
                }
                case 2: {
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    this.p_PictureStoreReply.deletedPictures(resourceLocatorArray);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    int n7 = iDeserializer.getEnum();
                    this.p_PictureStoreReply.deleteSynchronizedPictureResult(n, l, l2, n7);
                    break;
                }
                case 47: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    PictureAttribute[] pictureAttributeArray = PictureAttributeSerializer.getOptionalPictureAttributeVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_PictureStoreReply.getPictureAttributesResult(resourceLocator, pictureAttributeArray, n);
                    break;
                }
                case 30: {
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_PictureStoreReply.listWithFilterResult(resourceLocatorArray, n);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n8 = iDeserializer.getInt32();
                    this.p_PictureStoreReply.listForContextResult(n, resourceLocatorArray, n8);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n9 = iDeserializer.getInt32();
                    this.p_PictureStoreReply.listForContextWithFilterResult(n, resourceLocatorArray, n9);
                    break;
                }
                case 73: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n10 = iDeserializer.getInt32();
                    float f2 = iDeserializer.getFloat();
                    float f3 = iDeserializer.getFloat();
                    this.p_PictureStoreReply.listForContextWithFilterSortDistResult(n, resourceLocatorArray, n10, f2, f3);
                    break;
                }
                case 10: {
                    GeoPicture[] geoPictureArray = GeoPictureSerializer.getOptionalGeoPictureVarArray(iDeserializer);
                    this.p_PictureStoreReply.getRectanglePicturesGridResult(geoPictureArray);
                    break;
                }
                case 24: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_PictureStoreReply.getAvailableYearsResult(nArray);
                    break;
                }
                case 22: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_PictureStoreReply.getAvailableMonthsResult(nArray);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    this.p_PictureStoreReply.createFilterSetResult(n);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_PictureStoreReply.cloneFilterSetResult(n, n11);
                    break;
                }
                case 75: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getEnum();
                    this.p_PictureStoreReply.invalidData(nArray, n);
                    break;
                }
                case 58: {
                    int n = iDeserializer.getInt32();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_PictureStoreReply.getAvailableFoldersResult(n, stringArray);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

