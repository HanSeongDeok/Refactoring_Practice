package org.example.patternpractice.proxy;

public class ProxyThumbnail implements Thumbnail{
    private ThumbnailPreviewHandler previewHandler;
    @Override
    public void showTitle() {
        System.out.println("show Title");
    }

    @Override
    public void showPreview() {
        getPreviewHandler().showPreview();
    }

    private ThumbnailPreviewHandler getPreviewHandler() {
        return previewHandler == null ?
                new ThumbnailPreviewHandler() :
                previewHandler;
    }
}
