
public class FileSystemObject {
	private String parent;
	private String name;

	public FileSystemObject(String parent, String name) {
		this.parent = parent;
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {

		if (((parent.isEmpty()) || !parent.matches("[a-zA-Z0-9()_!.&]+"))
				|| (!parent.substring(0, 1).matches("[a-zA-Z0-9]"))) {
			throw (new IllegalArgumentException("Invalid name specified"));
		} else {
			this.parent = parent;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (((name.isEmpty()) || !name.matches("[a-zA-Z0-9()_!.&]+"))
				|| (!name.substring(0, 1).matches("[a-zA-Z0-9]"))) {
			throw (new IllegalArgumentException("Invalid name specified"));
		}
		this.name = name;
	}
}
