package panel;

import java.util.*;
import java.io.*;

public class ShapeFactory {
    private static Properties shapes = new Properties();

    static {
        try {
            InputStream in = ShapeFactory.class.getResourceAsStream("panel.properties");
            shapes.load(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Shape getShape(int type) {
        try {
            String className = (String) shapes.get(String.valueOf(type));
            return (Shape) Class.forName("panel." + className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}