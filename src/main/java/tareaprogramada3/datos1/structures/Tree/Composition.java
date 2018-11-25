package tareaprogramada3.datos1.structures.Tree;

import java.util.Comparator;

class Composition implements Comparator<Integer>

{
   public int compare(Integer element1, Integer element2)
   {
        return element1 - element2;
   }
}
