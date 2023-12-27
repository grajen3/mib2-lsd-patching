/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.BlockElement;

public interface DSIBlockingReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateListOfBlocks(BlockElement[] blockElementArray, int n) {
    }

    default public void updateNaviCoreAvailableToSetBlocks(int n, int n2) {
    }

    default public void updateMaximumNumberOfBlockedAreas(int n, int n2) {
    }

    default public void updateMaximumNumberOfBlockedRouteSegments(int n, int n2) {
    }

    default public void updateMaximumNumberOfBlockedRoadSegments(int n, int n2) {
    }

    default public void updateMaximumDimensionsOfBlockedArea(int n, int n2, int n3) {
    }

    default public void updateMaximumSegmentLengthOfBlockedRouteSegment(int n, int n2) {
    }

    default public void updateMaximumLengthOfBlockRouteBasedOnLength(int n, int n2) {
    }

    default public void blockAreaResult(long l, int n) {
    }

    default public void blockRouteSegmentsResult(long l, int n) {
    }

    default public void blockRoadSegmentsResult(long l, int n) {
    }

    default public void blockRouteBasedOnLengthResult(long l, int n) {
    }

    default public void persistBlockResult(long[] lArray, int n) {
    }

    default public void deleteBlockResult(long[] lArray, int n) {
    }

    default public void setBlockDescriptionResult(long[] lArray, int n) {
    }

    default public void getBoundingRectangleOfBlocksResult(long[] lArray, NavRectangle navRectangle) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

