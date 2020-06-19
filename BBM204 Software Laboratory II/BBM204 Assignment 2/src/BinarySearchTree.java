

public class BinarySearchTree {
    class Node {
        String key;
        Node left, right;
        int second_Chance;
        public Node(String item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(String key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, String key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key.compareTo(root.key)<0)
            root.left = insertRec(root.left, key);
        else if (key.compareTo(root.key)>0)
            root.right = insertRec(root.right, key);

        return root;
    }

    public Node search(Node root, String key)
    {

        if (root==null || root.key.equals(key))
            return root;
        if (root.key.compareTo(key)>0)
            return search(root.left, key);

        return search(root.right, key);
    }
    public  boolean search2(Node root, String key)
    {
        if(root==null)
            return false;
        if(root.key.equals(key))
            return true;

        if(root.key.compareTo(key) > 0)
            return search2(root.left, key);

        return search2(root.right, key);
    }
    void deleteTree(Node node)
    {
        if (node == null)
            return;
        deleteTree(node.left);
        deleteTree(node.right);
        node = null;
    }
    void second_chance(Node node,String key){
        if ( root.key.equals(key))
            root.second_Chance=1;
        if (root.key.compareTo(key)>0)
             search(root.left, key);

         search(root.right, key);
    }

}

