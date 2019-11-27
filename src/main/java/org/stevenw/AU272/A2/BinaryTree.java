package org.stevenw.AU272.A2;

import java.util.Collections;
import java.util.Comparator;

public class BinaryTree<T> {
    /*
    Binary-search-tree property: Let x be a node in a binary search tree. If y is a node
in the left subtree of x, then y.key ≤ x.key. If y is a node in the right subtree of x, then
y.key ≥ x.key. (Stanford)
     */
    private T min;
    private T max;
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

    public boolean satisfiesSearchOrder() {
        if(root == null) return true; //empty tree is still a BST
        return satisfiesSearchOrder2(this.root, null, null);
    }


    /**
     * @param a - comparable element
     * @param b - comparable element
     * @return max of A and B
     * Based on code by Duncan McGregor (StackOverflow)
     */
    public T max(T a, T b) {
        if (a == null) {
            if (b == null) return (T) a;
            else return (T) b;
        }
        if (b == null)
            return (T) a;
        return ((Comparable<T>) a).compareTo((T) b) > 0 ? (T) a : (T) b;
    }

    /**
     * @param a - comparable element
     * @param b - comparable element
     * @return max of A and B
     * Based on code by Duncan McGregor (StackOverflow)
     */
    public T min(T a, T b) {
        if (a == null) {
            if (b == null) return (T) a;
            else return (T) b;
        }
        if (b == null)
            return (T) a;
        return ((Comparable<T>) a).compareTo((T) b) < 0 ? (T) a : (T) b;
    }



    private boolean satisfiesSearchOrder2(Node<T> node, T min, T max) {
        if(node == null) return true;
        if(min != null && ((Comparable<T>) node.getData()).compareTo(min) <= 0) {
            return false;
        }
        if(max != null && ((Comparable<T>) node.getData()).compareTo(max) >= 0) {
            return false;
        }
        //when going to left child, the max for anything in that subtree is the current node's value
        //for a path forming a straight line going down every left node, there'd be no min.
        //since the root node calls this method with a null min and max, that makes there be no min in that case.
        //otherwise the min would be the last node where the right child was visited (first right-side parent going up from the current node)

        //same applies for the right side
        //when going to the right child, the min for the subtree is the current node's value
        //the max would be the first left-side parent going up form the current node
        return satisfiesSearchOrder2(node.getLeft(), min, node.getData())
                && satisfiesSearchOrder2(node.getRight(), node.getData(), max);
    }

    /**
     * @param node
     * @param min
     * @param max
     * @param side - 1 from left side, 0 from right, 2 from root
     * @return
     */
    private boolean satisfiesSearchOrder(Node<T> node, T min, T max, int side) {
        System.out.println();
        if (node == null) return true;
        if (node != root) {
            System.out.println("chk1 " + node.getData() + " " + min + " " + max);

            //right side must be greater than root at all times


            //in every recursion, acceptable ranges get bigger

            //make sure right child  is bigger than root and all nodes under the root on path to node
            if (side == 1 && min != null && node != null && ((Comparable<T>) node.getData()).compareTo(min) <= 0) {
                System.out.println("left" + node.getData() + " " + min.toString());
                return false;
            }

            System.out.println("chk2 " + node.getData() + " " + min + " " + max);

            //make sure right child is bigger than the current node
            if (node.getRight() != null && ((Comparable<T>) node.getRight().getData()).compareTo(node.getData()) <= 0) {
                return false;
            }
            System.out.println("chk3 " + node.getData() + " " + min + " " + max);


            //make sure left node is bigger than the root and all nodes under the root to the node
            if (side == 0 && max != null && node != null && ((Comparable<T>) node.getData()).compareTo(max) >= 0) {
                System.out.println("right" + node.getData() + " " + " " + max.toString());
                return false;
            }

            System.out.println("chk4 " + node.getData() + " " + min + " " + max);

            //make sure left child is smaller than current node
            if (node.getLeft() != null && ((Comparable<T>) node.getLeft().getData()).compareTo(node.getData()) >= 0) {
                return false;
            }
            System.out.println("chkt " + node.getData() + " " + min + " " + max);
            return satisfiesSearchOrder(node.getLeft(), min, node.getData(), 1) && satisfiesSearchOrder(node.getRight(),
                    node.getData(), max, 0);
        }
        return true;
    }

    // else {
       // return satisfiesSearchOrder(node.getLeft(), node.getData(), node.getData(), 1) && satisfiesSearchOrder(node.getRight(),
         //       node.getData(), null, 0);
    //}

    /*
    Binary-search-tree property: Let x be a node in a binary search tree. If y is a node
in the left subtree of x, then y.key ≤ x.key. If y is a node in the right subtree of x, then
y.key ≥ x.key.
1 < left <
     */
    /*
    if(node.getLeft()!= null && !(node.getLeft().getData().compareTo(node.getData()) <= 0)) {
        return false;
    }
    if(node.getRight()!= null && !(node.getRight().getData().compareTo(node.getData()) >= 0)) {
return false;
    }
    return (node.getLeft() == null) || (satisfiesSearchOrder(node.getLeft())) && ((node
            .getRight() == null) || satisfiesSearchOrder(node.getLeft()));*/
//}

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
        //NLR
        if(node == null) {
            return null;
        }

        //after the node is visited, the left subtree will be checked.
        //if there is a right tree, the next node will be the smallest element in the right subtree,
        //which is the node that will form a continuous left-line from the right child of the current node.

        if(node.getLeft() != null) {
            return node.getLeft();
        }
        if(node.getRight() != null) {
            return node.getRight();
        }

        //if we're coming in to the parent from the right, keep going up, until we come up from the left.
        while(node != null) {
            if(node.getParent().getLeft() == node) {
                return node.getParent().getRight();
            }
            node = node.getParent();
        }

        return null;

    }
    public Node<T> postOrderNext(Node<T> node) {
        //LRN
            if(node == root) {
                //root is last node
                return null;
            }

            if(node.getParent().getRight() == node) {
                //right subtree
                return node.getParent();
            } else {
                //left subtree
                if(node.getParent().getRight() != null) {
                    node = node.getParent().getRight();
                } else {
                    return node.getParent();
                }
                //next node is always under previous node.
                while(node != null) {
                    if (node.getLeft() == null && node.getRight() == null) {
                        //leave nodes
                        return node;
                    }
                    //if not leave node, then go down until we get to one
                    if(node.getLeft() != null) {
                        node = node.getLeft();

                    } else if(node.getRight() != null) {
                        node = node.getRight();
                    }
                }
            }

        return null;
    }
    private Node<T> goToLeftmostNode(Node<T> node) {
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * @param node - the node that you want to know what comes next for
     * @return the next node with inorder traversal. null if there are none left after the node given.
     *
     * Worst case run time will be proportional to the height of the tree.
     * This will be the node forming a continuous right-line from the left child of the root,
     * as it's the last node, in order, before comes the root,
     * but it will have to go up level by level until it gets to the root.
     * In an unbalanced tree, this will be O(n) whereas in a balanced tree it will be O(log n)
     */
    public Node<T> inOrderNext(Node<T> node) {
       //LNR
        if(node == null) {
            return null;
        }
        //after the node is visited, the right subtree will be checked.
        //if there is a right tree, the next node will be the smallest element in the right subtree,
        //which is the node that will form a continuous left-line from the right child of the current node.
        if(node.getRight() != null) {
            node = node.getRight();
            return goToLeftmostNode(node);
        }

        //if right subtree is empty, we will need to go up a level.
        while(node != null) {

            if(node.getParent() != null) {

                if (node.getParent().getRight() == node) {
                    if(node.getParent().getParent() == null) {
                        //this means that the parent of the node is the root as it will be the only node without a parent.
                        if(node.getParent().getRight() == node) {
                            //if coming to node from right child, that means it's the end of the traversal.
                            return null;
                        }
                    }
                    node = node.getParent();
				} else {
                    //if node is the left child of its parent the next node will be the parent of the current node.
                    return node.getParent();
				}
			} else {
				//node is root node.
                //only return right if coming in from the right, otherwise this will return the previous node.
                //before node is updated to be it's parent, the special case of whether the node's parent is the root is checked, and will cause the method to return null, so the only way this gets executed if the root was reached via its left child.
				return node.getRight();
			}

        }
        return null;
    }

}

