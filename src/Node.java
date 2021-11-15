import java.util.LinkedList;

public class Node {

    private int id;
    private Color color;
    private LinkedList<Integer> neighborsIds;
    private int cost;

    public Node(int id, Color color) {
        neighborsIds = new LinkedList<Integer>();
        this.id = id;
        this.color = color;
        changeCost(color);
    }

    public Node copy() {
        Node newNode = new Node(this.id, this.color);
        for (int i = 0; i < this.neighborsIds.size(); i++) {
            int neighborId = this.neighborsIds.get(i);
            newNode.addNeighborId(neighborId);
        }
        return newNode;
    }

    public void changeColorTo(Color color){
        this.color= color;
        changeCost(color);
    }

    public void reverseNodeColor() {
        if (color == Color.Green) {
            color = Color.Red;
            this.cost = 1;
        } else if (color == Color.Red) {
            color = Color.Green;
            this.cost = 3;
        }
    }


    public void addNeighborId(int neighborId) {
        neighborsIds.push(neighborId);
    }

    public LinkedList<Integer> getNeighborsIds() {
        return this.neighborsIds;
    }

    public int getNeighborsId(int index) {
        return this.neighborsIds.get(index);
    }

    public Color getColor() {
        return this.color;
    }

    public int getId() {
        return this.id;
    }

    public int getCost() {
        return cost;
    }

    private void changeCost(Color color){
        if (color == Color.Red){
            this.cost = 1;
        }else if(color == Color.Black){
            this.cost = 2;
        }else if(color == Color.Green){
            this.cost = 3;
        }
    }
}

