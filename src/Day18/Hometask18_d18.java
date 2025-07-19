package Day18;
import java.util.*;
class MyNode {
    char data;
    MyNode left, right;
    public MyNode(char data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class Hometask18_d18 {
    public static void invertBinaryTree(MyNode root) {
        if (root == null) return;
        Queue<MyNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<MyNode> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                MyNode node = queue.poll();
                currentLevel.add(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (level % 2 == 1) {
                int i = 0, j = currentLevel.size() - 1;
                while (i < j) {
                    char temp = currentLevel.get(i).data;
                    currentLevel.get(i).data = currentLevel.get(j).data;
                    currentLevel.get(j).data = temp;
                    i++;
                    j--;
                }
            }
            level++;
        }
    }
    public static void levelOrderTraversal(MyNode root) {
        if (root == null) return;
        Queue<MyNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            MyNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
    public static void main(String[] args) {
        MyNode root = new MyNode('A');
        root.left = new MyNode('B');
        root.right = new MyNode('C');
        root.left.left = new MyNode('D');
        root.left.right = new MyNode('E');
        root.right.left = new MyNode('F');
        root.right.right = new MyNode('G');
        root.left.left.left = new MyNode('H');
        root.left.left.right = new MyNode('I');
        root.left.right.left = new MyNode('J');
        root.left.right.right = new MyNode('K');
        root.right.left.left = new MyNode('L');
        root.right.left.right = new MyNode('M');
        root.right.right.left = new MyNode('N');
        root.right.right.right = new MyNode('O');
        invertBinaryTree(root);
        levelOrderTraversal(root); // Output: A C B D E F G O N M L K J I H
    }
}
