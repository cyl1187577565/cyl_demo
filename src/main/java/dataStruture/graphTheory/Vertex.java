package dataStruture.graphTheory;

/**
 * 顶点
 */
public class Vertex {
    public String label;
    public Boolean isVisited;

    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
    }
}
