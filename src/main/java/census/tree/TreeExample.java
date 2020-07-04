package census.tree;

public class TreeExample {

	public static void main(String[] args) {
		TreeNode<String> treeRoot = TreeExample.getSet1();
		for (TreeNode<String> node : treeRoot) {
			String indent = createIndent(node.getLevel(), " ");
			System.out.println(indent + node.getData());
		}
	}

	private static String createIndent(int depth, String spacer) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb.append(spacer);
		}
		return sb.toString();
	}
	
	private static TreeNode<String> getSet1() {
		TreeNode<String> root = new TreeNode<String>("root");
		{
			TreeNode<String> node0 = root.addChild("node0");
			TreeNode<String> node1 = root.addChild("node1");
			TreeNode<String> node2 = root.addChild("node2");
			{
				TreeNode<String> node20 = node2.addChild(null);
				TreeNode<String> node21 = node2.addChild("node21");
				{
					TreeNode<String> node210 = node21.addChild("node210");
					TreeNode<String> node211 = node21.addChild("node211");
				}
			}
			TreeNode<String> node3 = root.addChild("node3");
			{
				TreeNode<String> node30 = node3.addChild("node30");
			}
		}

		return root;
	}


}
