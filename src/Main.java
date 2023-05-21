public class Main {
    public static void main(String[] args) {
        //part3
        BinaryTree<Integer> tree = new BinaryTree<>(
                50,
                new BinaryTree<>(17,
                        new BinaryTree<>(12,
                                new BinaryTree<>(9),
                                new BinaryTree<>(14)
                        ),
                        new BinaryTree<>(23,
                                new BinaryTree<>(19),
                                new BinaryTree<>()
                        )
                ),
                new BinaryTree<>(72,
                        new BinaryTree<>(54,
                                new BinaryTree<>(),
                                new BinaryTree<>(67)
                        ),
                        new BinaryTree<>(76)
                )
        );

        //part 4
        BinaryTree.BinaryTreeVisitor<Integer> visitor = new BinaryTree.BinaryTreeVisitor<Integer>();
        System.out.println("inorder traversing: ");
        tree.inorderTraverse(visitor);
        System.out.println();
        System.out.println("postorder traversing: ");
        tree.postorderTraverse(visitor);
        System.out.println();
        System.out.println("preorder traversing: ");
        tree.preorderTraverse(visitor);
        System.out.println();

        //part5
        System.out.println("inorder iterator: ");
        for (Integer a : tree) {
            System.out.print(a + " ");
        }

        //part6
        System.out.println();
        System.out.println("the size of the tree is " + tree.getSize());
    }
}