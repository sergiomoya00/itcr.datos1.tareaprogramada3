/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.structures.Tree;

import tareaprogramada3.datos1.structuresInterface.*;

public class Tree<T extends Comparable<T>> implements TreeBehavior<T> {

    TreeNode<T> root;
    public int size;

    public Tree() {
        root = null;
        size = 0;
    }

     @Override
    public void add(T element) {
        TreeNode newNode = new TreeNode(element);
        if (isEmpty()) {
            newNode = root;
        }

        TreeNode<T> current = root;
        TreeNode<T> father;
        while (true) {
            father = current;

            if ((current.getValue()).compareTo(element) < 0) { //NO SE EJECUTA BIEN EL CompareTo
                current = current.subLeft;
                if (current == null) {
                    father.subLeft = newNode;
                    this.size ++;
                    return;
                }
            } else {
                current = current.subRight;
                if (current == null) {
                    father.subLeft = newNode;
                    this.size ++;
                }
            }
        }
    }
    
    
    

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        size =0;
        root = null;
    }


    @Override
    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    @Override
    public Comparable remove(Comparable element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable search(Comparable element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preOrderTrail(TreeNode current) {  //Se implementa igual a root SUPONGO
        if (current != null){
            preOrderTrail(current.subLeft);
            preOrderTrail(current.subRight);
        }
    }

    @Override
    public void postOrderTrail(TreeNode current) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void orderTrail(TreeNode current) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void widthTrail(TreeNode current) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLeaf(TreeNode node) {       
        if((node.subLeft != null) & (node.subRight!= null)){
            return true;
        }
        return false;
    }

}
