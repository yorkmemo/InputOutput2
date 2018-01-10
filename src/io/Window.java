package io;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Map;


public abstract class Window {
    private static Stage stage;
    private static Scene scene;
    private static BorderPane borderPane;
    private static Font font = new Font(12);
    private static AnchorPane anchorPane;
    private static VBox centerVBox = new VBox();

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;
    private static final Color DEFAULT_FILL = Color.BLACK;
    private static final Color DEFAULT_STROKE = Color.BLACK;
    private static final double DEFAULT_STROKE_WIDTH = 0.5;
    private static final String DEFAULT_TITLE = "Application";

    private static Map<String, Node> idMap;


    private static void registerNodeId(Node node, String id) {
        if (id != null) {
            if (idMap.containsKey(id)) {
                return;
            }

            node.setId(id);
            idMap.put(id, node);
        }
    }

    public static void open(String title, int width, int height) {
        initialize(title, width, height);

        stage.show();
    }

    public static void open() {
        open(DEFAULT_TITLE);
    }

    public static void open(int width, int height) {
        open(DEFAULT_TITLE, width, height);
    }

    public static void open(String title) {
        Screen screen = Screen.getPrimary();

        Rectangle2D bounds = screen.getVisualBounds();
        if (stage == null) {
            stage = new Stage();
        }

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());

        open(title, (int) bounds.getWidth(), (int) bounds.getHeight());
    }

    private static void initialize() {
        if (stage == null) {
            initialize(DEFAULT_TITLE, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }

    private static void initialize(String title, int width, int height) {
        if (stage == null) {
            stage = new Stage();
        }

        stage.setTitle(title);
        stage.setWidth(width);
        stage.setHeight(height);

        anchorPane = new AnchorPane();
        //anchorPane.setStyle("-fx-background-color: crimson");
        borderPane = new BorderPane(new StackPane(anchorPane, centerVBox));

        scene = new Scene(borderPane);

        stage.setScene(scene);
    }

    public static void setFont(String name) {
        initialize();
        font = new Font(name, font.getSize());
    }

    public static void setFontSize(int size) {
        initialize();
        font = new Font(font.getName(), size);
    }

    public static void addText(String text) {
        addTextWithId(text, null);
    }

    public static void addTextWithId(String id, String text) {
        initialize();

        Text displayText = new Text(text);
        displayText.setFont(font);

        registerNodeId(displayText, id);

        centerVBox.getChildren().add(new Text(text));
    }

    public static void addCircleWithId(String id, double centerX, double centerY, double radius) {
        addCircleWithId(id, centerX, centerY, radius, DEFAULT_FILL);
    }

    public static void addCircleWithId(String id, double centerX, double centerY, double radius, Color fill) {
        addCircleWithId(id, centerX, centerY, radius, fill, DEFAULT_STROKE_WIDTH, DEFAULT_STROKE);
    }

    public static void addCircleWithId(String id, double centerX, double centerY, double radius, Color fill, double strokeWidth) {
        addCircleWithId(id, centerX, centerY, radius, fill, strokeWidth, DEFAULT_STROKE);
    }

    public static void addCircleWithId(String id, double centerX, double centerY, double radius, Color fill, double strokeWidth, Color stroke) {
        initialize();
        Circle circle = new Circle(centerX, centerY, radius, fill);
        circle.setStroke(stroke);
        circle.setStrokeWidth(strokeWidth);

        registerNodeId(circle, id);

        anchorPane.getChildren().add(circle);
    }

    public static void addCircle(double centerX, double centerY, double radius) {
        addCircleWithId(null, centerX, centerY, radius);
    }

    public static void addCircle(double centerX, double centerY, double radius, Color fill) {
        addCircleWithId(null, centerX, centerY, radius, fill);
    }

    public static void addCircle(double centerX, double centerY, double radius, Color fill, double strokeWidth) {
        addCircleWithId(null, centerX, centerY, radius, fill, strokeWidth);
    }

    public static void addCircle(double centerX, double centerY, double radius, Color fill, double strokeWidth, Color stroke) {
        addCircleWithId(null, centerX, centerY, radius, fill, strokeWidth, stroke);
    }

    public static void addRectangleWithId(String id, double leftX, double topY, double width, double height) {
        addRectangleWithId(id, leftX, topY, width, height, DEFAULT_FILL);
    }

    public static void addRectangleWithId(String id, double leftX, double topY, double width, double height, double angle) {
        addRectangleWithId(id, leftX, topY, width, height, DEFAULT_FILL, DEFAULT_STROKE_WIDTH, DEFAULT_STROKE, angle);
    }

    public static void addRectangleWithId(String id, double leftX, double topY, double width, double height, Color fill) {
        addRectangleWithId(id, leftX, topY, width, height, fill, DEFAULT_STROKE_WIDTH, DEFAULT_STROKE);
    }
    
    public static void addRectangleWithId(String id, double leftX, double topY, double width, double height, Color fill, double strokeWidth) {
        addRectangleWithId(id, leftX, topY, width, height, fill, strokeWidth, DEFAULT_STROKE);
    }

    public static void addRectangleWithId(String id, double leftX, double topY, double width, double height, Color fill, double strokeWidth, double angle) {
        addRectangleWithId(id, leftX, topY, width, height, fill, strokeWidth, DEFAULT_STROKE, angle);
    }

    public static void addRectangleWithId(String id, double leftX, double topY, double width, double height, Color fill, double strokeWidth, Color stroke) {
        addRectangleWithId(id, leftX, topY, width, height, fill, strokeWidth, stroke, 0);
    }

    public static void addRectangleWithId(String id, double leftX, double topY, double width, double height, Color fill, double strokeWidth, Color stroke, double angle) {
        initialize();
        Rectangle rectangle = new Rectangle(leftX, topY, width, height);
        rectangle.setFill(fill);
        rectangle.setStroke(stroke);
        rectangle.setStrokeWidth(strokeWidth);
        rectangle.setRotate(angle);

        registerNodeId(rectangle, id);

        anchorPane.getChildren().add(rectangle);
    }

    public static void addRectangle(double leftX, double topY, double width, double height) {
        addRectangleWithId(null, leftX, topY, width, height);
    }

    public static void addRectangle(double leftX, double topY, double width, double height, double angle) {
        addRectangleWithId(null, leftX, topY, width, height, angle);
    }

    public static void addRectangle(double leftX, double topY, double width, double height, Color fill) {
        addRectangleWithId(null, leftX, topY, width, height, fill);
    }

    public static void addRectangle(double leftX, double topY, double width, double height, Color fill, double strokeWidth) {
        addRectangleWithId(null, leftX, topY, width, height, fill, strokeWidth);
    }

    public static void addRectangle(double leftX, double topY, double width, double height, Color fill, double strokeWidth, double angle) {
        addRectangleWithId(null, leftX, topY, width, height, fill, strokeWidth, angle);
    }

    public static void addRectangle(double leftX, double topY, double width, double height, Color fill, double strokeWidth, Color stroke) {
        addRectangleWithId(null, leftX, topY, width, height, fill, strokeWidth, stroke);
    }

    public static void addRectangle(double leftX, double topY, double width, double height, Color fill, double strokeWidth, Color stroke, double angle) {
        addRectangleWithId(null, leftX, topY, width, height, fill, strokeWidth, stroke);
    }

}