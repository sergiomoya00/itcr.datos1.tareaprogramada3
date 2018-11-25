package tareaprogramada3.datos1.structures.Tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
	/**
	 * Al ser recursivo es totalmente necesario que el nodo se encuentre dentro de la clase
	 * Debido a que debe tener acceso directo a los parámetros de memoria dentro del código
	 * @author jearo
	 *
	 * @param <T>
	 */
	@SuppressWarnings("hiding")
	

        //NODO PARA LOS ELEMENTOS DEL ÁRBOL (ROOT Y COMPARATOR)
        private class Node<T> {
		private T value;
		private Node<T> left, right;

		public Node(T data, Node<T> left, Node<T> right) {
			this.left = left;
			this.right = right;
			this.value = data;
		}

		public Node(T data) {
			this(data, null, null);
		}

		public String toString() {
			return value.toString();
		}
	}
	
	/**
	 * Atributos de la clase Árbol
	 */
	private Node<T> root;
	private Comparator<T> comparator;

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Constructir de la clase
	 */
	public BinarySearchTree() {
		root = null;
		comparator = null;
	}

	public BinarySearchTree(Comparator<T> comp) {
		root = null;
		comparator = comp;
	}

        
        //COMPARA LOS ELEMENTOS PARA VER DONDE SE INSERTA EL NUEVO ELEMENTO
	private int compare(T value_A, T value_B) {
		if (comparator == null)
			return value_A.compareTo(value_B);
		else
			return comparator.compare(value_A, value_B);
	}

	/**
	 * Insertar
	 * 
	 * @param data
	 */
        
        //PARA INSERTAR Y ALAMACENR EL DATO   //ESTE ES EL QUE SE TIENE QUE LLAMAR EN EL MANAGER
	public void insertNode(T data) {
		root = insert(root, data);
	}

        
        //PARA DETERMINAR LA POSICIÓN 
	private Node<T> insert(Node<T> newNode, T insertedNode) {
		if (newNode == null)
			return new Node<T>(insertedNode);

		if (compare(insertedNode, newNode.value) == 0)
			return newNode;

		if (compare(insertedNode, newNode.value) < 0)
			newNode.left = insert(newNode.left, insertedNode);
		else
			newNode.right = insert(newNode.right, insertedNode);

		return newNode;
	}

	/**
	 * Buscar
	 * 
	 * @param toSearch
	 * @return
	 */
        //PARA BUSCAR UN ELEMENTO DE TIPO GÉNERICO. //ESTE ES EL QUE SE PONE EN MANAGER
	public boolean searchNode(T toSearch) {
		return search(root, toSearch);
	}
        
        
        //PARA UTILIZAR EL COMPARATOR Y ENCONTAR EL ELEMENTO DESEADO
	private boolean search(Node<T> x, T toSearch) {
		if (x == null)
			return false;
		else if (compare(toSearch, x.value) == 0)
			return true;
		else if (compare(toSearch, x.value) < 0)
			return search(x.left, toSearch);
		else
			return search(x.right, toSearch);
	}
        
        
        public T getNode(T element){
            return searchGetNode(root, element);
        }

	private T searchGetNode(Node<T> x, T toSearch) {
		if (x == null)
			return null;
		else if (compare(toSearch, x.value) == 0)
			return x.value;
		else if (compare(toSearch, x.value) < 0)
			return searchGetNode(x.left, toSearch);
		else
			return searchGetNode(x.right, toSearch);
	}

	/**
	 * Eliminar
	 * 
	 * @param deleteNode
	 */
        
        
        //PARA ELIMINAR UN ELEMENTO, ESTA ES LA FUNCIÓN QUE SE LLAMA EN EL MANAGER
	public void deleteNode(T deleteNode) {
		root = delete(root, deleteNode);
	}
        
        //FUNCION AUTILIAR DEL BORRADO DEL ELEMENTO
	private Node<T> delete(Node<T> TemporaryNode, T NodeToDelete) {
		if (TemporaryNode == null)
			throw new RuntimeException("No elements to delete");
		else if (compare(NodeToDelete, TemporaryNode.value) < 0)
			TemporaryNode.left = delete(TemporaryNode.left, NodeToDelete);
		else if (compare(NodeToDelete, TemporaryNode.value) > 0)
			TemporaryNode.right = delete(TemporaryNode.right, NodeToDelete);
		else {
			if (TemporaryNode.left == null)
				return TemporaryNode.right;
			else if (TemporaryNode.right == null)
				return TemporaryNode.left;
			else {
				// Obtiene los datos por el lado rightecho
				TemporaryNode.value = getData(TemporaryNode.left);
				// Obtiene los datos del lado leftuierdo
				TemporaryNode.left = delete(TemporaryNode.left, TemporaryNode.value);
			}
		}
		return TemporaryNode;
	}
        
        //PARA OBTENER UN DATO
	private T getData(Node<T> x) {
		while (x.right != null)
			x = x.right;

		return x.value;
	}

	/**
	 * TO STRING
	 */
	public String toString() {
		StringBuffer message = new StringBuffer();
		for (T data : this)
			message.append(data.toString());

		return message.toString();
	}

	/**
	 * PreordenS
	 */
        //RECORRIDO PREORDEN
	public void preOrderJourneyt() {
		preOrderAux(root);
	}
        
        //RECORRIDO PREORDEN
	private void preOrderAux(Node<T> TemporaryNode) {
		if (TemporaryNode != null) {
			System.out.print(TemporaryNode + " ");
			preOrderAux(TemporaryNode.left);
			preOrderAux(TemporaryNode.right);
		}
	}

	/**
	 * En orden
	 */
	public void inOrderJourney() {
		inOrderJourneyAux(root);
	}

	private void inOrderJourneyAux(Node<T> TemporaryNode) {
		if (TemporaryNode != null) {
			inOrderJourneyAux(TemporaryNode.left);
			System.out.print(TemporaryNode + " ");
			inOrderJourneyAux(TemporaryNode.right);
		}
	}

	/**
	 * Post Orden
	 */
	public void postOrderJourney() {
		postOrderJourneyAux(root);
	}

	private void postOrderJourneyAux(Node<T> TemporaryNode) {
		if (TemporaryNode != null) {
			inOrderJourneyAux(TemporaryNode.left);
			inOrderJourneyAux(TemporaryNode.right);
			System.out.print(TemporaryNode + " ");
		}
	}

	/**
	 * Clonado
	 */
        //UNA CLONACIÓN RARA QUE SE SACÓ ESE HP DEL CULO
	
        public BinarySearchTree<T> clone() {
		BinarySearchTree<T> twin = null;

		if (comparator == null)
			twin = new BinarySearchTree<T>();
		else
			twin = new BinarySearchTree<T>(comparator);

		twin.root = cloneHelper(root);
		return twin;
	}

	private Node<T> cloneHelper(Node<T> p) {
		if (p == null)
			return null;
		else
			return new Node<T>(p.value, cloneHelper(p.left), cloneHelper(p.right));
	}

	/**
	 * Altura del árbol
	 * 
	 * @return
	 */
        
        //ALTURA DEL ÁRBOL
	public int height() {
		return height(root);
	}

	private int height(Node<T> x) {
		if (x == null)
			return -1;
		else
			return 1 + Math.max(height(x.left), height(x.right));
	}

	/**
	 * Contar las horas del árbol
	 * 
	 * @return
	 */
        //CONTAR LAS HOJAS
	public int countLeaves() {
		return countLeaves(root);
	}
        
	private int countLeaves(Node<T> x) {
		if (x == null)
			return 0;
		else if (x.left == null && x.right == null)
			return 1;
		else
			return countLeaves(x.left) + countLeaves(x.right);
	}

	/**
	 * Restaura el árbol en orden y preorden
	 * 
	 * @param pre
	 * @param in
	 */
        
        //RESTAURAR EL ÁRBOL EN ORDEN Y EN PREORDEN
	public void restore(T[] pre, T[] in) {
		root = restore(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node<T> restore(T[] pre, int preL, int preR, T[] in, int inL, int inR) {
		if (preL <= preR) {
			int count = 0;
			// find the root in the inorright array
			while (pre[preL] != in[inL + count])
				count++;

			Node<T> temporary = new Node<T>(pre[preL]);
			temporary.left = restore(pre, preL + 1, preL + count, in, inL, inL + count - 1);
			temporary.right = restore(pre, preL + count + 1, preR, in, inL + count + 1, inR);
			return temporary;
		} else
			return null;
	}

	/**
	 * Corresponde al máximo número de values en un nivel del árbol
	 * 
	 * @return
	 */
        
        ///ANCHURA DEL ÁRBOL
	public int width() {
		int max = 0;
		for (int k = 0; k <= height(); k++) {
			int temporary = width(root, k);
			if (temporary > max)
				max = temporary;
		}
		return max;
	}

	/**
	 * Retorna el número de nodos de un determinado nivel
	 * 
	 * @param p
	 * @param depth
	 * @return
	 */
       
	public int width(Node<T> x, int depth) {
		if (x == null)
			return 0;
		else if (depth == 0)
			return 1;
		else
			return width(x.left, depth - 1) + width(x.right, depth - 1);
	}

	/**
	 * El diametro del árbol es el número de nodos El camino más largo entre dos
	 * hojas
	 * 
	 * @return
	 */
        
        // CAMINO MÁS LARGO ENTRE TODAS LAS HOJAS
	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node<T> x) {
		if (x == null)
			return 0;

		// El camino va por la raíz
		int lenght1 = height(x.left) + height(x.right) + 3;

		// El camino no pasa por la raíz
		int lenght2 = Math.max(diameter(x.left), diameter(x.right));

		return Math.max(lenght1, lenght2);
	}

	public Iterator<T> iterator() {
		return new IteradorBST();
	}

	// pre-orright
	private class IteradorBST implements Iterator<T> {
		Stack<Node<T>> stk = new Stack<Node<T>>();

		public IteradorBST() {
			if (root != null)
				stk.push(root);
		}

		public boolean hasNext() {
			return !stk.isEmpty();
		}

		public T next() {
			Node<T> current = stk.peek();
			if (current.left != null) {
				stk.push(current.left);
			} else {
				Node<T> temporary = stk.pop();
				while (temporary.right == null) {
					if (stk.isEmpty())
						return current.value;
					temporary = stk.pop();
				}
				stk.push(temporary.right);
			}

			return current.value;
		}

		public void remove() {

		}
	}
}