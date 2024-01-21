package org.example.patternpractice.proxy;

public class ThumbnailPreviewHandler implements Thumbnail{
    @Override
    public void showTitle() {
        System.out.println("show Title");
    }

    @Override
    public void showPreview() {
        System.out.println("show Preview");
    }
}
