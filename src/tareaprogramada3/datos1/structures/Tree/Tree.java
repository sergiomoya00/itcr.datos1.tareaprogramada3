/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.structures.Tree;

import tareaprogramada3.datos1.structuresInterface.StructuresInterface;

public class Tree<T extends Comparable<T>> implements StructuresInterface {

    TreeNode root;

    public Tree() {
        root = null;
    }
    @Override
    public void add(Object element) {
        TreeNode newNode = new TreeNode();
        if (isEmpty()) {
            newNode = root;
        }

        TreeNode current = root;
        TreeNode father;
        while(true){
            father = current;
            if (current.getValue().compareTo(element) < 0){ //NO SE EJECUTA BIEN EL CompareTo
                current = current.subLeft;
                if (current == null){
                    father.subLeft = newNode;
                    return;
                }
            }
            else{
                current = current.subRight;
                father.subRight = newNode;
                return;
            }
        }
    }

        @Override
        public Object remove(Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object search(Object element) {
            return false;
    }

        @Override
        public int size
        
            () {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void clear
        
            () {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object set
        (Object element, int index
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object get
        (int index
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isEmpty
        
            () {
        if (root == null) {
                return true;
            }
            return false;
        }

    }
