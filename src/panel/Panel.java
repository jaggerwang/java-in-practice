package panel;

import java.io.*;

public class Panel {
    public void selectShape() throws Exception {
        System.out.println("请输入形状类型：");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int shapeType = Integer.parseInt(input.readLine());

        Shape shape = ShapeFactory.getShape(shapeType);

        if (shape == null) {
            System.out.println("输入的形状类型不存在");
        } else {
            shape.draw();
        }
    }

    public static void main(String[] args) throws Exception {
        new Panel().selectShape();
    }
}