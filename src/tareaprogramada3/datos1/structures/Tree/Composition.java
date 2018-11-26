package tareaprogramada3.datos1.structures.Tree;

import java.util.Comparator;

class Composition implements Comparator<Integer>
//MÉTODO PARA EL COMPARATOR
{
   public int compare(Integer x, Integer y)
   {
        return y-x;
   }
}
