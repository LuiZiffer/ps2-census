package census.tree;

public class Pair<L, R> {

	private L left;
	private R right;

	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}
	
	public Pair(Pair<L,R> p) {
		this.left = p.left();
		this.right = p.right();
	}

	public L left() {
		return left;
	}

	public R right() {
		return right;
	}
	
	public void setLeft(L left) {
		this.left = left();
	}

	public void setRight(R right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Pair [left=" + left + ", right=" + right + "]";
	}

	@Override
	public int hashCode() {
		return left.hashCode() ^ right.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pair))
			return false;
		Pair<?, ?> pairo = (Pair<?, ?>) o;
		return this.left.equals(pairo.left()) && this.right.equals(pairo.right());
	}

}
