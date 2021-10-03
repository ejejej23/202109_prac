package tmpTestFiles;

import java.io.IOException;
import java.util.Scanner;

public class B_1003_1 {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        //이진트리 노드입력하기 구현

    }

    public class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.setData(data);
            setLeft(null);
            setRight(null);
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(Node left){
            this.left = left;
        }

        public void setRight(Node right){
            this.right = right;
        }

        public int getData(){
            return data;
        }

        public Node getLeft(){
            return left;
        }

        public Node getRight(){
            return right;
        }
    }

    public Node root;

    public void insert(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            return;
        }

        Node curNode = root;
        Node parNode = null;

        while(true){
            parNode = curNode;

            if(curNode.getData() < data){
                curNode = curNode.getLeft();
                if(curNode == null){
                    parNode.setLeft(newNode);
                    return;
                }
            }else{
                curNode = curNode.getRight();
                if(curNode == null){
                    parNode.setRight(newNode);
                    return;
                }
            }
        }
    }
}
