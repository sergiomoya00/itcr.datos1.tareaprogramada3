/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.structures.Tree;

import tareaprogramada3.datos1.structuresInterface.StructuresInterface;

public class Tree<T extends Comparable<T>> implements StructuresInterface {

    TreeNode<T> root;
    public int size;

    public Tree() {
        root = null;
        size = 0;
    }

    
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
    
    public boolean isLeaf(TreeNode Node){
        if((Node.subLeft != null) & (Node.subRight!= null)){
            return true;
        }
        return false;
   
    }
    
    public T searchMin(){
        TreeNode<T> current = this.root;
        
        while (! current.subLeft.isEmpty()){     //No lo lee, supongo que por estar en la interfaz
            current = current.subLeft;
        }
        
        return current.getValue();
    }
    
    
    public T searchMax(){
        TreeNode<T> current = this.root;
        
        while (! current.subRight.isEmpty()){     //No lo lee, supongo que por estar en la interfaz
            current = current.subRight;
        }
        return current.getValue();
    }
    
    @Override
    public Object remove(Object element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object search(T element) {
        if (isEmpty()) {
            return null;
        }

        TreeNode<T> current = root;
        TreeNode<T> father;

        while (true) {
            father = current;

            if (current == null) {
                break;
            }

            if (current.getValue().equals(element)) {
                break;
            } 
            else if ((current.getValue()).compareTo(element) < 0) { //NO SE EJECUTA BIEN EL CompareTo
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
    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    @Override
    public void add(Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object search(Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
