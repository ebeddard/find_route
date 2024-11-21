package find_route;

class Node {
    private String city;
    private Node parent;
    private int cost;
    private int depth;

    Node(String city, Node parent, int cost, int depth) {
        this.city = city;
        this.parent = parent;
        this.cost = cost;
        this.depth = depth;
    }

    Node(String city, int depth) {
        this.city = city;
        parent = null;
        cost = 0;
        this.depth = depth;
    }

    public String getCity() {
        return city;
    }

    public Node getParentNode() {
        return parent;
    }

    public int getCost() {
        return cost;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Node) {
            if (((Node) o).city.equals(this.city)) {
            	if(((Node) o).parent == null && this.parent == null) {
            		return true;
            	} else if((((Node) o).getParentNode() != null && this.getParentNode() == null) ||
            			(((Node) o).getParentNode() == null && this.getParentNode() != null)) {
            		return false;
            	}
            	if(((Node) o).getParentNode().equals(this.getParentNode())) {
            		return true;
            	}
            }
        }
        return false;
    }
}