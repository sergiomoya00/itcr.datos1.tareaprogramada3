
package tareaprogramada3.datos1.structuresInterface;
import tareaprogramada3.datos1.structures.Tree.*;

public interface TreeBehavior<T extends Comparable<T>> extends StructuresInterface<T> {
    public void preOrderTrail(TreeNode current);
    public void postOrderTrail(TreeNode current);     
    public void orderTrail(TreeNode current);
    public void widthTrail(TreeNode current);
    public boolean isLeaf(TreeNode Node);
}
