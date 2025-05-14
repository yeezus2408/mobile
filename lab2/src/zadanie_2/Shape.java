package zadanie_2;

import java.awt.*;
import java.util.Map;

public abstract class Shape {
    public abstract double area();

    public static Shape fromJson(Map<String, Object> json) {
        String type = (String) json.get("type");

        if ("circle".equalsIgnoreCase(type)) {
            Double radius = (Double) json.get("radius");
            if (radius == null) {
                throw new IllegalArgumentException("Radius is required for circle");
            }
            return new Circle(radius);
        } else if ("rectangle".equalsIgnoreCase(type)) {
            Double width = (Double) json.get("width");
            Double height = (Double) json.get("height");
            if (width == null || height == null) {
                throw new IllegalArgumentException("Width and height are required for rectangle");
            }
            return new Rectangle(width, height);
        } else {
            throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}
