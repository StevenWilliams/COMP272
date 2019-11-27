package org.stevenw.AU272.A2;

import java.util.Collections;
import java.util.Comparator;

public class BinaryTree<T> {
    /**
     * Number of elements in tree
     */
    protected int n;
    protected Node<T> root;

    protected Node<T> getRoot() {
        return root;
    }

    /**
	 * Calculate height of the Binary Tree (number of edges to furthest leaf node from root)
     * @return height of binary tree
     */
    public int height() {
        return height(this.root);
    }

    /**
     * Calculates height for a given node.
     * @param node - Node to find height of
     * @return height of specified node
     */
    public int height(Node<T> node) {
        if(node == null) return -1;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    /**
     * @return calculate size of binary tree
     */
    public int size() {
        return size(root);
    }

    /**
     * Calculate size of a subtree
     * @param node - Node to calculate subtree size for
     * @return size of subtree
     */
    public int size(Node<T> node) {
        if(node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    /**
     * @return true if binary tree is a valid BST
     */
    public boolean satisfiesSearchOrder() {
        if(root == null) return true; //empty tree is still a BST
        return satisfiesSearchOrder(this.root, null, null);
    }


    /**
     * @param node - Node to check whether it satisifed the BST search order property for
     * @param min - min value that node must meet
     * @param max - max value that node must meet
     * @return true if it satisifes conditions, false otherwise
     */
    private boolean satisfiesSearchOrder(Node<T> node, T min, T max) {
        /*
 Binary-search-tree property: Let x be a node in a binary search tree. If y is a node
in the left subtree of x, then y.key ≤ x.key. If y is a node in the right subtree of x, then
y.key ≥ x.key.
         */
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
        return satisfiesSearchOrder(node.getLeft(), min, node.getData())
                && satisfiesSearchOrder(node.getRight(), node.getData(), max);
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

    /**
     * Find what node comes after a given node in pre-order traversal
     * @param node - node to find out what comes next in pre-order traversal
     * @return next node
     * Worst case time would be on the last node in pre-order traversal
     * as it would have to travel up to the tree until it gets to the root.
     * Worst case time would be O(n) in an unbalanced tree and O(log n) in a balanced tree
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

    /**
     * Finds what node comes after node given in post order traversal
     * @param node a Node to find the next
     * @return the next Node that comes after in postorder traversal
     * Worst case time is when given the root, is it may have to go all the way down the tree to find the next node.
     */
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
                //next node is always under previous node, if not parent (node is a right child of parent)
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


    /**
     * @param node a node
     * @return - the deepest left node, forming a continuous left-child straight line
     */
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
     * Assumptions: Requires that a valid node in the tree be given.
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

