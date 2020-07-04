package census.tree;

import java.util.Iterator;

import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> implements Iterable<TreeNode<T>> {

	private T data;
	private TreeNode<T> parent;
	private List<TreeNode<T>> children;
	
	public T getData() {
		return data;
	}
	
	public TreeNode<T> getParent() {
		return parent;
	}
	
	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public boolean isRoot() {
		return parent == null;
	}

	public boolean isLeaf() {
		return children.size() == 0;
	}

	private List<TreeNode<T>> elementsIndex;

	public TreeNode(T data) {
		this.data = data;
		this.children = new LinkedList<TreeNode<T>>();
		this.elementsIndex = new LinkedList<TreeNode<T>>();
		this.elementsIndex.add(this);
	}
	
	public TreeNode<T> addNode(TreeNode<T> child) {
		child.parent = this;
		this.children.add(child);
		this.registerChildForSearch(child);
		return child;
	}

	public TreeNode<T> addChild(T child) {
		TreeNode<T> childNode = new TreeNode<T>(child);
		return addNode(childNode);
	}

	public int getLevel() {
		if (this.isRoot())
			return 0;
		else
			return parent.getLevel() + 1;
	}

	private void registerChildForSearch(TreeNode<T> node) {
		elementsIndex.add(node);
		if (parent != null)
			parent.registerChildForSearch(node);
	}

	public TreeNode<T> findTreeNode(Comparable<T> cmp) {
		for (TreeNode<T> element : this.elementsIndex) {
			T elData = element.data;
			if (cmp.compareTo(elData) == 0)
				return element;
		}

		return null;
	}
	
	private static String createIndent(int depth, String spacer) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb.append(spacer);
		}
		return sb.toString();
	}
	
	public String generateConsoleView(String spacer) {
		String out = "Tree:" + System.lineSeparator();
		for (TreeNode<T> node : this) {
			String indent = createIndent(node.getLevel(), " ");
			out += indent + node.getData() + System.lineSeparator();
		}
		return out;
	}

	@Override
	public String toString() {
		return data != null ? data.toString() : "[data null]";
	}

	@Override
	public Iterator<TreeNode<T>> iterator() {
		TreeNodeIter<T> iter = new TreeNodeIter<T>(this);
		return iter;
	}
}
