import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree<T> implements Iterable<T> {
    private final Node<T> root;

    //part1
    public static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //part2
    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T rootData) {
        root = new Node<>(rootData);
    }

    public BinaryTree(T rootData, BinaryTree<T> left, BinaryTree<T> right) {
        root = new Node<>(rootData);
        root.left = left.root;
        root.right = right.root;
    }

    //part4
    public static class BinaryTreeVisitor<T> implements Visitor<T> {

        @Override
        public void visit(T data) {
            System.out.print(data + " ");
        }
    }

    public void inorderTraverse(Visitor<T> visitor) {
        inorderTraverseNode(root, visitor);
    }

    private void inorderTraverseNode(Node<T> node, Visitor<T> visitor) {
        if (node == null) {
            return;
        }
        inorderTraverseNode(node.left, visitor);
        visitor.visit(node.data);
        inorderTraverseNode(node.right, visitor);
    }

    public void postorderTraverse(Visitor<T> visitor) {
        postorderTraverseNode(root, visitor);
    }

    private void postorderTraverseNode(Node<T> node, Visitor<T> visitor) {
        if (node == null) {
            return;
        }
        inorderTraverseNode(node.left, visitor);
        inorderTraverseNode(node.right, visitor);
        visitor.visit(node.data);
    }

    public void preorderTraverse(Visitor<T> visitor) {
        preorderTraverseNode(root, visitor);
    }

    private void preorderTraverseNode(Node<T> node, Visitor<T> visitor) {
        if (node == null) {
            return;
        }
        visitor.visit(node.data);
        inorderTraverseNode(node.left, visitor);
        inorderTraverseNode(node.right, visitor);
    }

    //part5
    @Override
    public Iterator<T> iterator() {
        return new InorderIterator<>(root);
    }

    private static class InorderIterator<T> implements Iterator<T> {
        private final Stack<Node<T>> stack;

        private Node<T> current;

        public InorderIterator(Node<T> root) {
            stack = new Stack<>();
            current = root;
            pushUntilLeftList(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<T> node = stack.pop();
            pushUntilLeftList(node.right);
            return node.data;
        }

        private void pushUntilLeftList(Node<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

    }

    //part6
    public int getSize() {
        return getSizeOfNode(root);
    }

    private int getSizeOfNode(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int leftSubTree = getSizeOfNode(node.left);
        int rightSubTree = getSizeOfNode(node.right);

        return 1 + leftSubTree + rightSubTree;
    }
}
