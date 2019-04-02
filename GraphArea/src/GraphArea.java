import java.lang.Math;
import java.util.ArrayList;

import javafx.application.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.event.EventHandler;

public class GraphArea extends Application {

    double increment = 0.01;

    Group group1 = new Group();
    Group group2 = new Group();
    Group group3 = new Group();

    Scene scene1 = new Scene(group1);
    Scene scene2 = new Scene(group2);
    Scene scene3 = new Scene(group3);

    int currentShown = 1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage primaryStage) {
        group1.setScaleY(-1);
        group2.setScaleY(-1);
        group3.setScaleY(-1);

        showOne(primaryStage);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (currentShown < 3) {
                    currentShown++;
                } else {
                    currentShown = 1;
                }

                nextShown(primaryStage);
            }
        };

        scene1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        scene2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        scene3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public void nextShown(Stage primaryStage) {
        if (currentShown == 1) {
            showOne(primaryStage);
        } else if (currentShown == 2) {
            showTwo(primaryStage);
        } else if (currentShown == 3) {
            showThree(primaryStage);
        }
    }

    public void showOne(Stage primaryStage) {
        System.out.println(getArea(increment, 4, 0, 1));

        ArrayList<Rectangle> rectArr1 = new ArrayList<Rectangle>();
        for(double i = 0; i <= 4; i+=increment) {
            rectArr1.add(new Rectangle(i * 100, 0, increment*100, functionOne(i)*100));
        }

        for (int i = 0; i < rectArr1.size(); i++) {
            rectArr1.get(i).setFill(Color.rgb(0, 0, 0));
            group1.getChildren().add(rectArr1.get(i));
        }

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public void showTwo(Stage primaryStage) {
        System.out.println(getArea(increment, Math.PI/2, 0, 2));

        ArrayList<Rectangle> rectArr2 = new ArrayList<Rectangle>();
        for(double i = 0; i <= Math.PI/2; i+=increment) {
            rectArr2.add(new Rectangle(i * 100, 0, increment*100, functionTwo(i)*100));
        }

        for (int i = 0; i < rectArr2.size(); i++) {
            rectArr2.get(i).setFill(Color.rgb(0, 0, 0));
            group2.getChildren().add(rectArr2.get(i));
        }

        primaryStage.setScene(scene2);
        primaryStage.show();
    }

    public void showThree(Stage primaryStage) {
        System.out.println(getArea(increment, 5, 0, 3));

        ArrayList<Rectangle> rectArr3 = new ArrayList<Rectangle>();
        for(double i = 0; i <= 5; i+=increment) {
            rectArr3.add(new Rectangle(i * 100, 0, increment*100, functionThree(i)*100));
        }

        for (int i = 0; i < rectArr3.size(); i++) {
            rectArr3.get(i).setFill(Color.rgb(0, 0, 0));
            group3.getChildren().add(rectArr3.get(i));
        }

        primaryStage.setScene(scene3);
        primaryStage.show();
    }

    public static double getArea(double baseWidth, double maxValue, double startValue, int functionValue) {
        double currentValue = startValue;
        double area = 0.0;
        while (currentValue <= maxValue) {
            if (functionValue == 1) {
                area += functionOne(currentValue) * baseWidth;
            } else if (functionValue == 2) {
                area += functionTwo(currentValue) * baseWidth;
            } else if (functionValue == 3) {
                area += functionThree(currentValue) * baseWidth;
            }
            currentValue += baseWidth;
        }

        return area;
    }

    public static double functionOne(double x) {
        return Math.sqrt(-(x-4));
    }

    public static double functionTwo(double x) {
        return Math.cos(x);
    }

    public static double functionThree(double x) {
        return x;
    }
}
