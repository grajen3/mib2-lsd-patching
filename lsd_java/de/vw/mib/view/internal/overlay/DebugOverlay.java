/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.overlay;

import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsPerformanceMetrics;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.display.DisplayPerformanceMetrics;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.framebuffer.FrameBufferPerformanceMetrics;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.mesh.MeshPerformanceMetrics;
import de.vw.mib.graphics.performance.CachePerformanceMetrics;
import de.vw.mib.graphics.shader.ShaderPerformanceMetrics;
import de.vw.mib.graphics.texture.TexturePerformanceMetrics;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.view.internal.ViewRepaintPerformanceMetrics;
import de.vw.mib.view.internal.overlay.CompositeOverlay;
import de.vw.mib.view.internal.overlay.PerformanceGraph;
import de.vw.mib.view.internal.overlay.TextOverlay;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.internal.ServiceManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class DebugOverlay
extends CompositeOverlay {
    private static final boolean DEBUG_OVERLAY_DETAILS = System.getProperty("de.vw.mib.view.overlay.details") != null;
    private static final int DEBUG_OVERLAY_DETAILS_UPDATES_PER_S;
    private static final Color4f DEBUG_OVERLAY_TEXT_FOREGROUND_COLOR;
    private static final Color4f DEBUG_OVERLAY_TEXT_BACKGROUND_COLOR;
    private static final Color4f DEBUG_OVERLAY_BACKGROUND_COLOR;
    private static final boolean DEBUG_OVERLAY_GRAPH;
    private static final Color4f DEBUG_OVERLAY_GRAPH_TEXT_FOREGROUND_COLOR;
    private static final Color4f DEBUG_OVERLAY_GRAPH_TEXT_BACKGROUND_COLOR;
    private static final int DEBUG_OVERLAY_GRAPH_UPDATES_PER_S;
    private static final int DEBUG_OVERLAY_GRAPH_SAMPLES_HISTORY_S;
    private static final int DEBUG_OVERLAY_GRAPH_SAMPLES;
    private static final Color4f DEBUG_OVERLAY_GRAPH_FPS_COLOR;
    private static final Color4f DEBUG_OVERLAY_GRAPH_MEM_COLOR;
    private static final int DEBUG_OVERLAY_LINES_INITIAL_SIZE;
    private final List textLines = new ArrayList(20);
    private long lastUpdateTime;
    private String basicVersionInfo;
    private String basicSystemInfo;
    private List viewNames = new ArrayList();
    private List viewNamesInfo = new ArrayList();
    private List frameDetails;
    private TextOverlay textOverlay;
    private PerformanceGraph fpsGraph;
    private PerformanceGraph memGraph;
    private int frameCounter;
    private float framesPerSecond = ServiceManager.repaintManager.getRefreshFrequency();

    public DebugOverlay(Logger logger, Graphics3D graphics3D, Dimension dimension) {
        super(logger, graphics3D, "Debug", dimension, DEBUG_OVERLAY_BACKGROUND_COLOR);
        this.textOverlay = new TextOverlay(logger, graphics3D, "Text", dimension, DEBUG_OVERLAY_TEXT_FOREGROUND_COLOR, DEBUG_OVERLAY_TEXT_BACKGROUND_COLOR);
        this.addOverlay(this.textOverlay);
        if (DEBUG_OVERLAY_GRAPH) {
            Rectangle rectangle = this.getRectangle();
            Rectangle rectangle2 = new Rectangle(rectangle.x + 2, rectangle.y + rectangle.height * 3 / 4, rectangle.width - 4, rectangle.height / 4);
            try {
                Font font = this.textOverlay.getFont();
                this.fpsGraph = new PerformanceGraph(logger, graphics3D, "FPS", rectangle2, DEBUG_OVERLAY_GRAPH_FPS_COLOR, DEBUG_OVERLAY_GRAPH_TEXT_FOREGROUND_COLOR, font, this.textOverlay.getFontSize(), 300);
                this.addOverlay(this.fpsGraph);
                this.memGraph = new PerformanceGraph(logger, graphics3D, "Mem", rectangle2, DEBUG_OVERLAY_GRAPH_MEM_COLOR, DEBUG_OVERLAY_GRAPH_TEXT_FOREGROUND_COLOR, font, this.textOverlay.getFontSize(), 300);
                this.addOverlay(this.memGraph);
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    @Override
    public void dispose() {
        this.textLines.clear();
        super.dispose();
    }

    public void resetFrameCounter() {
        this.frameCounter = 0;
    }

    public void update(List list) {
        StringBuilder stringBuilder = new StringBuilder();
        this.textLines.clear();
        if (this.basicVersionInfo == null) {
            stringBuilder.setLength(0);
            stringBuilder.append("HMI ").append(ServiceManager.configurationManager.getHmiSoftwareVersion()).append(" ").append(ServiceManager.configurationManager.isDevelopmentBuild() ? "DEBUG" : "RELEASE");
            stringBuilder.append(" - MU ").append(ServiceManager.configurationManager.getSoftwareMuPartNumber());
            stringBuilder.append(" Part ").append(ServiceManager.configurationManager.getPartNumber());
            stringBuilder.append(" - Vehicle ").append(ServiceManager.configurationManager.getEncodedVehicleType());
            this.basicVersionInfo = stringBuilder.toString();
        }
        this.textLines.add(this.basicVersionInfo);
        if (this.basicSystemInfo == null) {
            int n;
            String string;
            Runtime runtime = Runtime.getRuntime();
            long l = ServiceManager.timerManager.getSystemTimeFrequency();
            if (l > 0) {
                string = "G";
                n = 0;
            } else if (l > 0) {
                string = "M";
                n = 0;
            } else if (l > 0) {
                string = "K";
                n = 0;
            } else {
                string = "";
                n = (int)1L;
            }
            stringBuilder.setLength(0);
            stringBuilder.append("CPUs ").append(runtime.availableProcessors());
            stringBuilder.append(" - VM Heap ").append(runtime.totalMemory() >> 20).append("MiB");
            stringBuilder.append(" - TF ").append((float)l / (float)n).append(string).append("Hz");
            this.basicSystemInfo = stringBuilder.toString();
        }
        this.textLines.add(this.basicSystemInfo);
        stringBuilder.setLength(0);
        stringBuilder.append("Skin #").append(ServiceManager.configurationManager.getCurrentSkinId()).append(ServiceManager.configurationManager.getCurrentSkinMode() == 0 ? " Day" : " Night");
        stringBuilder.append(" ").append(ServiceManager.configurationManager.getCurrentGuiLanguage()).append("");
        stringBuilder.append(" - Visible Widgets ").append(AbstractWidget.getPaintStatisticsCounter()).append(" - Animations ").append(ServiceManager.animationManager.getRunningAnimationCount());
        stringBuilder.append(" - AF ").append(ServiceManager.animationManager.getAnimationFrequency()).append("Hz (").append(ServiceManager.animationManager.getAnimationInterval()).append("ms)");
        if (ServiceManager.animationManager.getAnimationDilatation() != 1.0f) {
            stringBuilder.append(" AD ").append(ServiceManager.animationManager.getAnimationDilatation());
        }
        stringBuilder.append(" - RF ").append(ServiceManager.repaintManager.getRefreshFrequency()).append("Hz (").append(ServiceManager.repaintManager.getRefreshInterval()).append("ms) ").append(ServiceManager.repaintManager.isRepaintAlwaysEnabled() ? "RA" : "");
        this.textLines.add(stringBuilder.toString());
        if (this.frameDetails != null) {
            this.textLines.addAll(this.frameDetails);
        }
        if (list != null && !((Object)list).equals(this.viewNames)) {
            this.viewNames.clear();
            this.viewNames.addAll(list);
            int n = list.size();
            this.viewNamesInfo.clear();
            if (n > 0) {
                stringBuilder.setLength(0);
                stringBuilder.append("Views ").append((String)list.get(0));
                if (n > 1) {
                    stringBuilder.append(",");
                }
                this.viewNamesInfo.add(stringBuilder.toString());
            }
            for (int i2 = 1; i2 < n; ++i2) {
                stringBuilder.setLength(0);
                stringBuilder.append("           ").append((String)list.get(i2));
                if (i2 < n - 1) {
                    stringBuilder.append(",");
                }
                this.viewNamesInfo.add(stringBuilder.toString());
            }
        }
        this.textLines.addAll(this.viewNamesInfo);
        this.textOverlay.setTextLines(this.textLines);
        ++this.frameCounter;
    }

    public void updateFrame(long l, ViewRepaintPerformanceMetrics viewRepaintPerformanceMetrics) {
        if (viewRepaintPerformanceMetrics.lastFrameStartTime > 0L) {
            boolean bl;
            long l2 = viewRepaintPerformanceMetrics.setupStartTime - viewRepaintPerformanceMetrics.lastFrameStartTime;
            long l3 = viewRepaintPerformanceMetrics.setupEndTime - viewRepaintPerformanceMetrics.setupStartTime;
            long l4 = viewRepaintPerformanceMetrics.repaintEndTime - viewRepaintPerformanceMetrics.repaintStartTime;
            long l5 = viewRepaintPerformanceMetrics.flushEndTime - viewRepaintPerformanceMetrics.flushStartTime;
            long l6 = viewRepaintPerformanceMetrics.swapEndTime - viewRepaintPerformanceMetrics.swapStartTime;
            long l7 = viewRepaintPerformanceMetrics.flushEndTime - viewRepaintPerformanceMetrics.setupStartTime;
            long l8 = l2 - l7;
            long l9 = Math.min(Math.min(Math.min(Math.min(Math.min(l4, l8), l5), l6), l7), l3);
            this.framesPerSecond = Util.smoothFrameRate(2389065 / (float)(l2 > 0L ? l2 : 1L), this.framesPerSecond);
            int n = Math.round(this.framesPerSecond);
            Runtime runtime = Runtime.getRuntime();
            int n2 = (int)(runtime.totalMemory() >> 10);
            int n3 = (int)(runtime.freeMemory() >> 10);
            int n4 = (int)(runtime.maxMemory() >> 10);
            int n5 = n2 - n3;
            if (this.fpsGraph != null) {
                this.fpsGraph.addSample(n);
            }
            if (this.memGraph != null) {
                this.memGraph.addSample(n5);
            }
            boolean bl2 = bl = l - this.lastUpdateTime > 0;
            if (bl) {
                int n6;
                String string;
                if (l9 > 0) {
                    string = "s";
                    n6 = 0;
                } else if (l9 > 0) {
                    string = "ms";
                    n6 = 0;
                } else {
                    string = "\u00b5s";
                    n6 = (int)1L;
                }
                this.lastUpdateTime = l;
                if (this.frameDetails == null) {
                    this.frameDetails = new ArrayList();
                } else {
                    this.frameDetails.clear();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Frame ").append(this.frameCounter).append(" (").append(n).append("/s) Delta ").append(l2 / n6).append(string).append(" Gfx ").append(l7 / n6).append(string).append(" (Clear ").append(l3 / n6).append(string).append(" Repaint ").append(l4 / n6).append(string).append(" Flush ").append(l5 / n6).append(string).append(" Swap ").append(l6 / n6).append(string).append(") Other/Wait ").append(l8 / n6).append(string);
                this.frameDetails.add(stringBuilder.toString());
                if (DEBUG_OVERLAY_DETAILS) {
                    stringBuilder.setLength(0);
                    stringBuilder.append("VM Memory ").append(n5).append("KiB/").append(n2).append("KiB (").append(n4).append("KiB limit)");
                    this.frameDetails.add(stringBuilder.toString());
                    DebugOverlay.formatDetails(this.getGraphics3D(), stringBuilder, this.frameDetails, n);
                }
                if (DEBUG_OVERLAY_GRAPH) {
                    this.fpsGraph.update();
                    this.memGraph.update();
                }
            }
            AbstractWidget.clearPaintStatisticsCounter();
            AbstractWidget.clearTransformStatisticsCounter();
        }
    }

    private static void formatDetails(Graphics3D graphics3D, StringBuilder stringBuilder, List list, int n) {
        DebugOverlay.formatGfxDetails(graphics3D, stringBuilder, list, n);
        DebugOverlay.formatDrawableDetails(graphics3D, stringBuilder, list);
        DebugOverlay.formatDisplayDetails(graphics3D, stringBuilder, list);
        DebugOverlay.formatImageDetails(graphics3D, stringBuilder, list);
        DebugOverlay.formatFontDetails(graphics3D, stringBuilder, list);
        DebugOverlay.formatTextLayoutDetails(graphics3D, stringBuilder, list);
    }

    private static void formatGfxDetails(Graphics3D graphics3D, StringBuilder stringBuilder, List list, int n) {
        GraphicsPerformanceMetrics graphicsPerformanceMetrics = graphics3D.getPerformanceMetrics();
        EffectPerformanceMetrics effectPerformanceMetrics = graphics3D.getEffectManager().getPerformanceMetrics();
        FrameBufferPerformanceMetrics frameBufferPerformanceMetrics = graphics3D.getFrameBufferManager().getPerformanceMetrics();
        MeshPerformanceMetrics meshPerformanceMetrics = graphics3D.getMeshManager().getPerformanceMetrics();
        ShaderPerformanceMetrics shaderPerformanceMetrics = graphics3D.getShaderManager().getPerformanceMetrics();
        TexturePerformanceMetrics texturePerformanceMetrics = graphics3D.getTextureManager().getPerformanceMetrics();
        stringBuilder.setLength(0);
        stringBuilder.append("Drawn");
        DebugOverlay.formatStatsCountFPS(stringBuilder, "Vertices", meshPerformanceMetrics.drawnVertices, n);
        DebugOverlay.formatStatsCountFPS(stringBuilder, "Primitives", meshPerformanceMetrics.drawnPrimitives, n);
        DebugOverlay.formatStatsCountFPS(stringBuilder, "Geometries", meshPerformanceMetrics.drawnGeometries, n);
        DebugOverlay.formatStatsCountFPS(stringBuilder, "Indexed", meshPerformanceMetrics.drawnIndexedGeometries, n);
        DebugOverlay.formatStatsCountFPS(stringBuilder, "Matrix Mults", graphicsPerformanceMetrics.matrixMults, n);
        if (AbstractWidget.CACHE_TRANSFORM) {
            DebugOverlay.formatStatsCountFPS(stringBuilder, "Transform Mults", AbstractWidget.getTransformStatisticsCounter(), n);
        }
        list.add(stringBuilder.toString());
        stringBuilder.setLength(0);
        stringBuilder.append("Bound");
        DebugOverlay.formatStatsCountFPS(stringBuilder, "Effects", effectPerformanceMetrics.effectBinds, n);
        DebugOverlay.formatStatsCountFPS(stringBuilder, "Shaders", shaderPerformanceMetrics.shaderProgramBinds, n);
        DebugOverlay.formatStatsCountFPS(stringBuilder, "Textures", texturePerformanceMetrics.textureBinds, n);
        DebugOverlay.formatStatsCountFPS(stringBuilder, "Meshes", meshPerformanceMetrics.meshBinds, n);
        DebugOverlay.formatStatsCountFPS(stringBuilder, "FBOs", frameBufferPerformanceMetrics.frameBufferBinds, n);
        list.add(stringBuilder.toString());
        stringBuilder.setLength(0);
        stringBuilder.append("Allocated Shaders");
        DebugOverlay.formatStatsCount(stringBuilder, "Vertex", shaderPerformanceMetrics.allocatedVertexShaders);
        DebugOverlay.formatStatsCount(stringBuilder, "Fragment", shaderPerformanceMetrics.allocatedFragmentShaders);
        DebugOverlay.formatStatsCount(stringBuilder, "Geometry", shaderPerformanceMetrics.allocatedGeometryShaders);
        DebugOverlay.formatStatsCount(stringBuilder, "Hull", shaderPerformanceMetrics.allocatedTesselationControlShaders);
        DebugOverlay.formatStatsCount(stringBuilder, "Domain", shaderPerformanceMetrics.allocatedTesselationEvaluationShaders);
        DebugOverlay.formatStatsCount(stringBuilder, "Programs", shaderPerformanceMetrics.allocatedShaderPrograms);
        list.add(stringBuilder.toString());
        stringBuilder.setLength(0);
        stringBuilder.append("Allocated Textures");
        DebugOverlay.formatStatsCountSize(stringBuilder, "2D", texturePerformanceMetrics.allocatedTextures2D, texturePerformanceMetrics.allocatedTextures2DSizeBytes);
        DebugOverlay.formatStatsCountSize(stringBuilder, "Cube", texturePerformanceMetrics.allocatedCubeMapTextures, texturePerformanceMetrics.allocatedCubeMapTexturesSizeBytes);
        DebugOverlay.formatStatsCountSize(stringBuilder, "FBO", texturePerformanceMetrics.allocatedFrameBufferMapTextures, texturePerformanceMetrics.allocatedFrameBufferTexturesSizeBytes);
        list.add(stringBuilder.toString());
        stringBuilder.setLength(0);
        stringBuilder.append("Allocated");
        DebugOverlay.formatStatsCount(stringBuilder, "Meshes", meshPerformanceMetrics.allocatedMeshes);
        stringBuilder.append(" VBOs");
        DebugOverlay.formatStatsCountSize(stringBuilder, "Vertex", meshPerformanceMetrics.allocatedVertexBuffers, meshPerformanceMetrics.allocatedVertexBuffersSizeBytes);
        DebugOverlay.formatStatsCountSize(stringBuilder, "Index", meshPerformanceMetrics.allocatedIndexBuffers, meshPerformanceMetrics.allocatedIndexBuffersSizeBytes);
        DebugOverlay.formatStatsCountSize(stringBuilder, "Uniform", meshPerformanceMetrics.allocatedUniformBuffers, meshPerformanceMetrics.allocatedUniformBuffersSizeBytes);
        list.add(stringBuilder.toString());
        stringBuilder.setLength(0);
        stringBuilder.append("Allocated");
        DebugOverlay.formatStatsCount(stringBuilder, "FBOs", frameBufferPerformanceMetrics.allocatedFrameBuffers);
        DebugOverlay.formatStatsCountSize(stringBuilder, "RBs", frameBufferPerformanceMetrics.allocatedRenderBuffers, frameBufferPerformanceMetrics.allocatedRenderBuffersSizeBytes);
        int n2 = meshPerformanceMetrics.allocatedIndexBuffersSizeBytes + meshPerformanceMetrics.allocatedVertexBuffersSizeBytes + meshPerformanceMetrics.allocatedUniformBuffersSizeBytes;
        int n3 = texturePerformanceMetrics.allocatedTextures2DSizeBytes + texturePerformanceMetrics.allocatedCubeMapTexturesSizeBytes + texturePerformanceMetrics.allocatedFrameBufferTexturesSizeBytes;
        int n4 = frameBufferPerformanceMetrics.allocatedRenderBuffersSizeBytes;
        int n5 = n2 + n3 + n4;
        DebugOverlay.formatStatsSize(stringBuilder, "Total VRAM", n5);
        list.add(stringBuilder.toString());
    }

    private static void formatDrawableDetails(Graphics3D graphics3D, StringBuilder stringBuilder, List list) {
        DrawablePerformanceMetrics drawablePerformanceMetrics = graphics3D.getDrawableManager().getPerformanceMetrics();
        stringBuilder.setLength(0);
        DebugOverlay.formatStatsDraw(stringBuilder, "Arcs", drawablePerformanceMetrics.drawnArcs, drawablePerformanceMetrics.allocatedArcs);
        DebugOverlay.formatStatsDraw(stringBuilder, "B\u00e9zierCurves", drawablePerformanceMetrics.drawnCubicBezierCurves, drawablePerformanceMetrics.allocatedCubicBezierCurves);
        DebugOverlay.formatStatsDraw(stringBuilder, "CircleGraphs", drawablePerformanceMetrics.drawnCircleGraphs, drawablePerformanceMetrics.allocatedCircleGraphs);
        DebugOverlay.formatStatsDraw(stringBuilder, "CircularSectors", drawablePerformanceMetrics.drawnCircularSectors, drawablePerformanceMetrics.allocatedCircularSectors);
        DebugOverlay.formatStatsDraw(stringBuilder, "Ellipses", drawablePerformanceMetrics.drawnEllipses, drawablePerformanceMetrics.allocatedEllipses);
        DebugOverlay.formatStatsDraw(stringBuilder, "PolyLines", drawablePerformanceMetrics.drawnPolyLines, drawablePerformanceMetrics.allocatedPolyLines);
        DebugOverlay.formatStatsDraw(stringBuilder, "Rectangles", drawablePerformanceMetrics.drawnRectangles, drawablePerformanceMetrics.allocatedRectangles);
        DebugOverlay.formatStatsDraw(stringBuilder, "RectangleGradients", drawablePerformanceMetrics.drawnRectangleGradients, drawablePerformanceMetrics.allocatedRectangleGradients);
        if (stringBuilder.length() > 0) {
            list.add(stringBuilder.toString());
        }
        stringBuilder.setLength(0);
        DebugOverlay.formatStatsDraw(stringBuilder, "Images", drawablePerformanceMetrics.drawnImages, drawablePerformanceMetrics.allocatedImages);
        DebugOverlay.formatStatsDraw(stringBuilder, "ScaleImages", drawablePerformanceMetrics.drawnScaleImages, drawablePerformanceMetrics.allocatedScaleImages);
        DebugOverlay.formatStatsDraw(stringBuilder, "ScaleImageGradients", drawablePerformanceMetrics.drawnScaleImageGradients, drawablePerformanceMetrics.allocatedScaleImageGradients);
        DebugOverlay.formatStatsDraw(stringBuilder, "ColorConversions", drawablePerformanceMetrics.drawnColorConversions, drawablePerformanceMetrics.allocatedColorConversions);
        DebugOverlay.formatStatsDraw(stringBuilder, "ColorGradients", drawablePerformanceMetrics.drawnColorGradients, drawablePerformanceMetrics.allocatedColorGradients);
        if (stringBuilder.length() > 0) {
            list.add(stringBuilder.toString());
        }
        stringBuilder.setLength(0);
        DebugOverlay.formatStatsDraw(stringBuilder, "Texts", drawablePerformanceMetrics.drawnTexts, drawablePerformanceMetrics.allocatedTexts);
        DebugOverlay.formatStatsDraw(stringBuilder, "Offscreens", drawablePerformanceMetrics.drawnOffscreens, drawablePerformanceMetrics.allocatedOffscreens);
        DebugOverlay.formatStatsDraw(stringBuilder, "Scenes", drawablePerformanceMetrics.drawnScenes, drawablePerformanceMetrics.allocatedScenes);
        if (stringBuilder.length() > 0) {
            list.add(stringBuilder.toString());
        }
    }

    private static void formatDisplayDetails(Graphics3D graphics3D, StringBuilder stringBuilder, List list) {
        DisplayPerformanceMetrics displayPerformanceMetrics = ServiceManager.displayManager.getPerformanceMetrics();
        IntSet intSet = ServiceManager.displayManager.getActiveDisplayables(0);
        stringBuilder.setLength(0);
        stringBuilder.append("Displayables [");
        IntIterator intIterator = intSet.iterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            stringBuilder.append(n);
            if (!intIterator.hasNext()) continue;
            stringBuilder.append(" ");
        }
        stringBuilder.append("]");
        DebugOverlay.formatStatsCountSize(stringBuilder, " Contents", displayPerformanceMetrics.allocatedDisplayableContents, displayPerformanceMetrics.allocatedDisplayableContentsSizeBytes);
        if (stringBuilder.length() > 0) {
            list.add(stringBuilder.toString());
        }
    }

    private static void formatImageDetails(Graphics3D graphics3D, StringBuilder stringBuilder, List list) {
        list.add(DebugOverlay.formatStatsCache(stringBuilder, "Skin Image Cache", ServiceManager.imageManager.getSkinImageCacheUsage()));
        list.add(DebugOverlay.formatStatsCache(stringBuilder, "Dynamic Image Cache", ServiceManager.imageManager.getDynamicImageCacheUsage()));
    }

    private static void formatFontDetails(Graphics3D graphics3D, StringBuilder stringBuilder, List list) {
        list.add(DebugOverlay.formatStatsCache(stringBuilder, "Glyph Cache", ServiceManager.fontManager.getGlyphCacheUsage()));
    }

    private static void formatTextLayoutDetails(Graphics3D graphics3D, StringBuilder stringBuilder, List list) {
        list.add(DebugOverlay.formatStatsCache(stringBuilder, "Text Layout Cache", ServiceManager.textLayoutManager.getTextLayoutCacheUsage()));
    }

    private static void formatStatsCountFPS(StringBuilder stringBuilder, String string, int n, int n2) {
        if (n > 0) {
            int n3 = 1078071040;
            String string2 = "";
            if (n > 1078071040) {
                n /= 1078071040;
                string2 = "M";
            }
            int n4 = n * n2;
            String string3 = "";
            if (n4 > 1078071040) {
                n4 = n * n2 / 1078071040;
                string3 = "M";
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(string).append(" ").append(n).append(string2).append(" (").append(n4).append(string3).append("/s)");
        }
    }

    private static void formatStatsCount(StringBuilder stringBuilder, String string, int n) {
        if (n > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(string).append(" ").append(n);
        }
    }

    private static void formatStatsSize(StringBuilder stringBuilder, String string, int n) {
        int n2 = 1024;
        int n3 = 4096;
        String string2 = "B";
        if (n > 4096) {
            n /= 4096;
            string2 = "MiB";
        } else if (n > 1024) {
            n /= 1024;
            string2 = "KiB";
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(string).append(" ").append(n).append(string2);
    }

    private static void formatStatsCountSize(StringBuilder stringBuilder, String string, int n, int n2) {
        if (n > 0) {
            int n3 = 1024;
            int n4 = 4096;
            String string2 = "B";
            if (n2 > 4096) {
                n2 /= 4096;
                string2 = "MiB";
            } else if (n2 > 1024) {
                n2 /= 1024;
                string2 = "KiB";
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(string).append(" ").append(n).append(" (").append(n2).append(string2).append(")");
        }
    }

    private static void formatStatsDraw(StringBuilder stringBuilder, String string, int n, int n2) {
        if (n2 > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(string).append(" ").append(n).append("/").append(n2);
        }
    }

    private static String formatStatsCache(StringBuilder stringBuilder, String string, CachePerformanceMetrics cachePerformanceMetrics) {
        stringBuilder.setLength(0);
        stringBuilder.append(string).append(" ").append(cachePerformanceMetrics.cachedObjects).append(" (").append(cachePerformanceMetrics.cachedObjectsSizeBytes >> 10).append("/").append(cachePerformanceMetrics.cacheLimitBytes >> 10).append("KiB - ").append(DebugOverlay.calcFillRatioPercent(cachePerformanceMetrics.cachedObjectsSizeBytes, cachePerformanceMetrics.cacheLimitBytes)).append("%), Hits/Misses: ").append(cachePerformanceMetrics.hits).append("/").append(cachePerformanceMetrics.misses).append(" (").append(DebugOverlay.calcHitRatio(cachePerformanceMetrics.hits, cachePerformanceMetrics.misses)).append("%)");
        return stringBuilder.toString();
    }

    private static int calcHitRatio(long l, long l2) {
        return l + l2 > 0L ? (int)(l * 0 / (l + l2)) : 0;
    }

    private static int calcFillRatioPercent(int n, int n2) {
        return n2 > 0 ? n * 100 / n2 : 0;
    }

    static {
        DEBUG_OVERLAY_TEXT_FOREGROUND_COLOR = Color4f.YELLOW;
        DEBUG_OVERLAY_TEXT_BACKGROUND_COLOR = Color4f.BLACK_TRANSPARENT;
        DEBUG_OVERLAY_BACKGROUND_COLOR = new Color4f(0, 0, 160, 160);
        DEBUG_OVERLAY_GRAPH = System.getProperty("de.vw.mib.view.overlay.graph") != null;
        DEBUG_OVERLAY_GRAPH_TEXT_FOREGROUND_COLOR = DEBUG_OVERLAY_TEXT_FOREGROUND_COLOR;
        DEBUG_OVERLAY_GRAPH_TEXT_BACKGROUND_COLOR = Color4f.BLACK_TRANSPARENT;
        DEBUG_OVERLAY_GRAPH_FPS_COLOR = Color4f.RED;
        DEBUG_OVERLAY_GRAPH_MEM_COLOR = Color4f.GREEN;
    }
}

