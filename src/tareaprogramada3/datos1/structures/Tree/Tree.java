/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.structures.Tree;

import tareaprogramada3.datos1.structuresInterface.StructuresInterface;

public class Tree<T extends Comparable<T>> implements StructuresInterface {

    TreeNode root;
    public int size;

    public Tree() {
        root = null;
        size = 0;
    }

    @Override
    public void add(Object element) {
        TreeNode newNode = new TreeNode(element);
        if (isEmpty()) {
            newNode = root;
        }

        TreeNode current = root;
        TreeNode father;
        while (true) {
            father = current;
            if (current.getValue().compareTo(element) < 0) { //NO SE EJECUTA BIEN EL CompareTo
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
    
    public boolean isLeaf(TreeNode Node){
        if((Node.subLeft != null) & (Node.subRight!= null)){
            return true;
        }
        return false;
   }
   

    @Override
    public Object remove(Object element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object search(Object element) {
        if (isEmpty()) {
            return null;
        }

        TreeNode current = root;
        TreeNode father;

        while (true) {
            father = current;

            if (current == null) {
                break;
            }

            if (current.getValue().equals(element)) {
                break;
            } else if (current.getValue().compareTo(element) < 0) { //NO SE EJECUTA BIEN EL CompareTo
                current = current.subLeft;
            }
            else {
                current = current.subRight;
            }
        }

        if (current == null) {
            return null;
        }

        return current.getValue();
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
    public Object set(Object element, int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

}
