/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.structures.Tree;


public class TreeNode<T> {
    
    T value;
    TreeNode subRight;
    TreeNode subLeft;

    public TreeNode() {
    }

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode subRight, TreeNode subLeft) {
        this.value = value;
        this.subRight = subRight;
        this.subLeft = subLeft;
    }

    public TreeNode(T value, TreeNode subRight) {
        this.value = value;
        this.subRight = subRight;
        this.subLeft = null;
    }
    
    public TreeNode(TreeNode subRight){
        this.subRight = subRight;
    }
  
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode getSubRight() {
        return subRight;
    }

    public void setSubRight(TreeNode subRight) {
        this.subRight = subRight;
    }

    public TreeNode getSubLeft() {
        return subLeft;
    }

    public void setSubLeft(TreeNode subLeft) {
        this.subLeft = subLeft;
    }
}
