import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChartExp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        List<Point> points = new ArrayList<>();
        Scanner sc = new Scanner(System.in);


        // сетка
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(.5);
        gc.setFontSmoothingType(null);
        gc.setLineDashes(5, 2);
        for (int i = 0; i < 10; i++) {
            gc.strokeLine(i * 60, 0, i * 60, 600);
            gc.strokeLine(0, i * 60, 600, i * 60);
        }
        gc.setStroke(Color.BLUE);
        gc.setLineDashes(null);
        gc.setLineWidth(1);

        // числа
        gc.setTextAlign(TextAlignment.CENTER);
        for (int i = 0; i < 11; i++) {
            if (i == 5) continue;
            gc.strokeText(String.valueOf(i * 60 - 300), i * 60, 315);
        }
        gc.setTextBaseline(VPos.CENTER);
        gc.setTextAlign(TextAlignment.LEFT);
        for (int i = 0; i < 11; i++) {
            if (i == 5) continue;
            gc.strokeText(String.valueOf(300 - i * 60), 310, i * 60);
        }

        gc.setStroke(Color.BLACK);
        gc.strokeLine(300, 0, 300, 600);    // zero line
        gc.strokeLine(0, 300, 600, 300);    // zero line


        canvas.setOnMouseClicked(event -> {
            double x = event.getX() - 2;
            double y = event.getY() - 2;
            gc.fillOval(x, y, 4, 4);
            points.add(new Point(x, y));
        });

        canvas.setOnScroll(event -> {
            Collections.sort(points);
            int size = points.size();
            int mid = size % 2 == 0 ? size / 2 : size / 2 + 1;

            double x1 = points.get(mid).x;
            double y1 = points.get(mid).y;
            double x2 = points.get(mid - 1).x;
            double y2 = points.get(mid - 1).y;

            double x1UP = x1;
            double y1UP = y1;
            double x2UP = x2;
            double y2UP = y2;

            double x1DOWN = x1;
            double y1DOWN = y1;
            double x2DOWN = x2;
            double y2DOWN = y2;

            double deltaX = x1 - x2;
            double deltaY = y1 - y2;
            do {
                gc.strokeLine(x1UP, y1UP, x2UP, y2UP);
                gc.strokeLine(x1DOWN, y1DOWN, x2DOWN, y2DOWN);

                x1UP += deltaX;
                y1UP += deltaY;
                x2UP += deltaX;
                y2UP += deltaY;

                x1DOWN -= deltaX;
                y1DOWN -= deltaY;
                x2DOWN -= deltaX;
                y2DOWN -= deltaY;
            }
            while (x1UP < 600 && y1UP < 600 && x1UP > -600 && y1UP > -600 ||
                    x1DOWN < 600 && y1DOWN < 600 && x1DOWN > -600 && y1DOWN > -600);
        });

        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.show();
    }

    public class Point implements Comparable<Point> {
        double x;
        double y;
        Double sum;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
            sum = x + y;
        }

        @Override
        public int compareTo(Point o) {
            return o.sum.compareTo(sum);
        }

        @Override
        public String toString() {
            return "Point(" + x + ", " + y + ')';
        }
    }
}