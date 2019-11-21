package org.stevenw.AU272.A2;

public class BinaryTree<T> {
    /*
    Binary-search-tree property: Let x be a node in a binary search tree. If y is a node
in the left subtree of x, then y.key ≤ x.key. If y is a node in the right subtree of x, then
y.key ≥ x.key. (Stanford)
     */

    protected int n;
    protected Node<T> root;
    protected Node<T> getRoot() {
        return root;
    }
    /*
    Proof that Prove that a binary tree with k leaves has height at least log k.

    height(k) >= log(k)

    h >= log(k)
    2^h >= k


     k <= 2^h
     log(k) <= log(2^h)
     log(k) <= h
     h >= log(k)


    Pigeonhole principle?
    Lemma: the number of leaves in a tree of height h is no more than 2^h.
    k <= 2^h

     */

    public int height() {
        return height(this.root);
    }
    public int height(Node<T> node) {
        if(node == null) return -1;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
    public int size() {
        return size(root);
    }
    public int size(Node<T> node) {
        if(node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }
    public static class Node<T> {
        public T getData() {
            return data;
        }

        private T data;

        public Node<T> getLeft() {
            return left;
        }

        private Node<T> left;

        public Node<T> getRight() {
            return right;
        }

        private Node<T> right;
        private Node<T> parent;

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node(T data) {

            this.data = data;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }
    /*
    (15 marks) Design an algorithm for the following operations for a binary tree BT, and show the
worst-case running times for each implementation:
preorderNext(x): return the node visited after node x in a pre-order traversal of BT.
postorderNext(x): return the node visited after node x in a post-order traversal of BT.
inorderNext(x): return the node visited after node x in an in-order traversal of BT.
2. (25 marks) Design a recursive linear-time algorithm that tests whether a binary tree satisfies the
search tree order property at every node.
3. (20 marks) Exercise 8.2. Illustrate what happens when the sequence 1, 5, 2, 4, 3 is added to an empty
ScapegoatTree, and show where the credits described in the proof of Lemma 8.3 go, and how they
are used during this sequence of additions.
4. (20 marks) Implement a commonly used hash table in a program that handles collision using linear
probing. Using (K mod 13) as the hash function, store the following elements in the table: {1, 5, 21,
26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146}.
5. (20 marks) Exercise 6.7. Create a subclass of BinaryTree whose nodes have fields for storing
preorder, post-order, and in-order numbers. Write methods preOrderNumber(),
inOrderNumber(), and postOrderNumbers()
     */
    public Node<T> preOrderNext(Node<T> node) {
        if(node.getLeft() != null) {
            return node.getLeft();
        }
        if(node.getParent() != null && node.getParent().getRight() == node) {
            return node.getParent().getParent();
        }
        if(node.getParent().getLeft() == node) {
            return node.getParent().getRight();
        }
        /*
        if(node.getParent() != null) {
            node = node.getParent();
            while(node.getParent() != null) {
                if(node == node.getRight()) {
                    node = node.getParent();
                } else {
                    node = node.getRight();
                }
            }
            return node;
        }*/
        return null;
    }
    public Node<T> postOrderNext(Node<T> node) {
        if (node.getParent() != null) {
            return node.getParent();
        }
        if (node.getRight() != null) {
            Node<T> node1 = node;

            while(node1.getLeft()!= null) {
                node1 = node1.getLeft();
            }
            return node1;
        }
        return null;
    }
    public T inOrderNext() {
        return null;
    }
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
      /*  System.out.println(tree.preOrderNext(tree.root).data.toString());
        System.out.println(tree.preOrderNext(tree.root.left).data.toString());
        System.out.println(tree.preOrderNext(tree.root.left.left).data.toString());
        System.out.println(tree.preOrderNext(tree.root.left.right).data.toString());
        System.out.println(tree.preOrderNext(tree.root.right).data.toString());
*/
    }

}

