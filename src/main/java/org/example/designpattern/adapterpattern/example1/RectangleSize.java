package org.example.designpattern.adapterpattern.example1;

import org.example.designpattern.adapterpattern.function.RectangleSizeBuilder;
import org.example.designpattern.adapterpattern.function.Shape;

import java.util.List;
import java.util.Map;

public class RectangleSize {
    int x1, x2, y1, y2;
    public RectangleSize(Map<String,Integer> sizes){
        this.x1 = sizes.get(RectangleSizeBuilder.X1);
        this.x2 = sizes.get(RectangleSizeBuilder.X2);
        this.y1 = sizes.get(RectangleSizeBuilder.Y1);
        this.y2 = sizes.get(RectangleSizeBuilder.Y2);
    }
    public RectangleSize(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
}
