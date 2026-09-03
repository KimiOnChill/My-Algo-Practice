package CodeRun.JAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n4BinaryTree_OK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().trim().split(" ");
        BinTree tree = new BinTree();

        for (String x: line) {
            int num = Integer.parseInt(x);
            if (num == 0) {
                break;
            }
            tree.handleNode(num);
        }
        
        writer.write( tree.getHeight().toString());
        reader.close();
        writer.close();
    }

    public static class NodeOfTree {
        NodeOfTree leftNode, rightNode;
        int rootValue;

        public NodeOfTree (int root) {
            this.rootValue = root;
            this.leftNode = this.rightNode = null;
        }

        public int getRoot () {
            return rootValue;
        } 
    }
    
    public static class BinTree {
        NodeOfTree root;
        int bestHeight;

        public BinTree () {
            root = null;
            bestHeight = 0;
        }

        public Integer getHeight () {
            return bestHeight;
        }

        public void handleNode (int number) {
            root = insertKey(root, number, 0);
        }

        public NodeOfTree insertKey (NodeOfTree root, int num, int height) {

            height++;
            if (height > bestHeight) {
                bestHeight = height;
            }
            
            if (root == null) {
                root = new NodeOfTree(num);
                return root;
            }

            if (num < root.rootValue) {
                root.leftNode = insertKey (root.leftNode, num, height);
            } else if (num == root.rootValue) {
                return root;
            } else {
                root.rightNode = insertKey(root.rightNode, num, height);
            }

            return root;
        }
    }
}
