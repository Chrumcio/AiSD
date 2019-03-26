public final class IntComparator implements Comparator {

	private int porownania;
	
	public int compare(Object left, Object right) throws ClassCastException {
		porownania++;
		return (Integer) left - (Integer) right;
	}

}